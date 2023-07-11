package gr.aueb.cf.schoolapp;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TeachersInsertForm extends JFrame {

	private static final long serialVersionUID = 123456;
	private JPanel contentPane;
	private JTextField firstnameTxt;
	private JTextField lastnameTxt;

	
	public TeachersInsertForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				firstnameTxt.setText("");
				lastnameTxt.setText("");
			}
		});
		setTitle("Εισαγωγή Εκπαιδευτή");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel firstnameLabel = new JLabel("Όνομα");
		firstnameLabel.setForeground(new Color(220, 20, 60));
		firstnameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstnameLabel.setBounds(47, 75, 101, 19);
		contentPane.add(firstnameLabel);
		
		firstnameTxt = new JTextField();
		firstnameTxt.setBounds(122, 75, 158, 19);
		contentPane.add(firstnameTxt);
		firstnameTxt.setColumns(10);
		
		JLabel lastnameLabel = new JLabel("Επώνυμο");
		lastnameLabel.setForeground(new Color(220, 20, 60));
		lastnameLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lastnameLabel.setBounds(47, 121, 101, 19);
		contentPane.add(lastnameLabel);
		
		lastnameTxt = new JTextField();
		lastnameTxt.setColumns(10);
		lastnameTxt.setBounds(122, 121, 158, 19);
		contentPane.add(lastnameTxt);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 20, 346, 192);
		contentPane.add(panel);
		
		JButton insertBtn = new JButton("Εισαγωγή");
		insertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "INSERT INTO TEACHERS(FIRSTNAME, LASTNAME) VALUES (?, ?)";
				
				try {
					String firstname = firstnameTxt.getText().trim();
					String lastname = lastnameTxt.getText().trim();
					
					if(firstname.equals("")|| lastname.equals("")) {
						JOptionPane.showMessageDialog(null, "Empty firstname / lastname", "Error", JOptionPane.ERROR_MESSAGE);
						return;
					}
					
					Connection connection = Menu.getConnection();
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setString(1, firstname);
					ps.setString(2, lastname);
					
					int n = ps.executeUpdate();
					JOptionPane.showMessageDialog(null,n + " rows affected", "Insert", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		insertBtn.setForeground(new Color(30, 144, 255));
		insertBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		insertBtn.setBounds(122, 215, 123, 38);
		contentPane.add(insertBtn);
		
		JButton closeBtn = new JButton("Κλείσιμο");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getSearchForm().setEnabled(true);
				Main.getTeachersInsertForm().setVisible(false);
			}
		});
		closeBtn.setForeground(new Color(30, 144, 255));
		closeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeBtn.setBounds(255, 215, 101, 38);
		contentPane.add(closeBtn);
	}
}
