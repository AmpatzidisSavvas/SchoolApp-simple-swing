package gr.aueb.cf.schoolapp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.border.BevelBorder;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeachersUpdateDeleteForm extends JFrame {
	
	private static final long serialVersionUID= 123456;

	private JPanel ContentPane;
	private JTextField idTxt;
	private JTextField firstnameTxt;
	private JLabel lastnameLbl;
	private JTextField lastnameTxt;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	
	public TeachersUpdateDeleteForm() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				String sql = "SELECT * FROM TEACHERS WHERE LASTNAME LIKE ?";
				Connection connection = Menu.getConnection();
				
				try {
					
					ps = connection.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
					ps.setString(1, Main.getSearchForm().getLastname() + "%");
					rs = ps.executeQuery();
					
					if (rs.next()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					} else {
						JOptionPane.showMessageDialog(null, "No Teachers found","Teachers", JOptionPane.WARNING_MESSAGE);
						Main.getTeachersUpdateDeleteForm().setVisible(false);
						Main.getSearchForm().setEnabled(true);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 404, 311);
		ContentPane = new JPanel();
		ContentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);

		setContentPane(ContentPane);
		ContentPane.setLayout(null);
		
		JLabel idLbl = new JLabel("ID");
		idLbl.setForeground(new Color(165, 42, 42));
		idLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		idLbl.setBounds(72, 35, 25, 13);
		ContentPane.add(idLbl);
		
		idTxt = new JTextField();
		idTxt.setBackground(new Color(250, 250, 210));
		idTxt.setEditable(false);
		idTxt.setBounds(107, 33, 50, 19);
		ContentPane.add(idTxt);
		idTxt.setColumns(10);
		
		JLabel firstnameLbl = new JLabel("Όνομα");
		firstnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		firstnameLbl.setForeground(new Color(165, 42, 42));
		firstnameLbl.setBounds(47, 67, 50, 19);
		ContentPane.add(firstnameLbl);
		
		firstnameTxt = new JTextField();
		firstnameTxt.setBounds(107, 69, 129, 19);
		ContentPane.add(firstnameTxt);
		firstnameTxt.setColumns(10);
		
		lastnameLbl = new JLabel("Έπωνυμο");
		lastnameLbl.setForeground(new Color(165, 42, 42));
		lastnameLbl.setFont(new Font("Tahoma", Font.BOLD, 14));
		lastnameLbl.setBounds(25, 99, 72, 19);
		ContentPane.add(lastnameLbl);
		
		lastnameTxt = new JTextField();
		lastnameTxt.setColumns(10);
		lastnameTxt.setBounds(107, 99, 129, 19);
		ContentPane.add(lastnameTxt);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(10, 10, 310, 129);
		ContentPane.add(panel);
		
		JButton firstBtn = new JButton("");
		firstBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if (rs.first()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		firstBtn.setIcon(new ImageIcon(TeachersUpdateDeleteForm.class.getResource("/resources/357119561_793767825549991_4730330584429555688_n.png")));
		firstBtn.setBounds(47, 146, 50, 38);
		ContentPane.add(firstBtn);
		
		JButton prevBtn = new JButton("");
		prevBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if (rs.previous()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					} else {
						rs.first();
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		prevBtn.setIcon(new ImageIcon(TeachersUpdateDeleteForm.class.getResource("/resources/358451924_1626891444443517_5038342046303015128_n.png")));
		prevBtn.setBounds(107, 146, 50, 38);
		ContentPane.add(prevBtn);
		
		JButton nextBtn = new JButton("");
		nextBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					if (rs.next()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					} else {
						rs.last();
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		nextBtn.setIcon(new ImageIcon(TeachersUpdateDeleteForm.class.getResource("/resources/358464859_1475921026498305_7232277947822690924_n.png")));
		nextBtn.setBounds(167, 146, 50, 38);
		ContentPane.add(nextBtn);
		
		JButton lastBtn = new JButton("");
		lastBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
					if (rs.last()) {
						idTxt.setText(rs.getString("ID"));
						firstnameTxt.setText(rs.getString("FIRSTNAME"));
						lastnameTxt.setText(rs.getString("LASTNAME"));
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		lastBtn.setIcon(new ImageIcon(TeachersUpdateDeleteForm.class.getResource("/resources/357626703_1426934671180978_5228612354067086979_n.png")));
		lastBtn.setBounds(227, 146, 50, 38);
		ContentPane.add(lastBtn);
		
		JButton updateBtn = new JButton("Ενημέρωση");
		updateBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "UPDATE TEACHERS SET FIRSTNAME=?, LASTNAME=? WHERE ID=?";
				
				try {
					Connection connection = Menu.getConnection();
					PreparedStatement ps = connection.prepareStatement(sql);
					
					String firstname = firstnameTxt.getText().trim();
					String lastname = lastnameTxt.getText().trim();
					String id = idTxt.getText().trim();
					
					if (firstname.equals("")| lastname.equals("")) {
						
						JOptionPane.showMessageDialog(null, "Empty Firstname/ Lastname", "Warning", JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					ps.setString(1,firstname);
					ps.setString(2, lastname);
					ps.setInt(3, Integer.parseInt(id));
					
					
					int n = ps.executeUpdate();
					
					if (n > 0) {
						JOptionPane.showMessageDialog(null, "Successful Update", "Update", JOptionPane.INFORMATION_MESSAGE);
					} else {
						JOptionPane.showMessageDialog(null, "Update Error", "Error", JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				} finally {
					if (ps != null) {
						try {
							ps.close();
						} catch (SQLException e1) {
							e1.printStackTrace();
						}
					}
				}
			}
		});
		updateBtn.setForeground(new Color(100, 149, 237));
		updateBtn.setBackground(new Color(255, 255, 255));
		updateBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		updateBtn.setBounds(9, 219, 123, 38);
		ContentPane.add(updateBtn);
		
		JButton deleteBtn = new JButton("Διαγραφή");
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql = "DELETE FROM TEACHERS WHERE ID = ?";
				
				try {
					Connection connection = Menu.getConnection();
					
					PreparedStatement ps = connection.prepareStatement(sql);
					ps.setInt(1, Integer.parseInt(idTxt.getText()));
					
					int response = JOptionPane.showConfirmDialog(null, "Είστε σίγουρος?", "Warning!!", JOptionPane.YES_NO_OPTION);
					
					if (response == JOptionPane.YES_OPTION) {
						
						int numberOfRowsAffected = ps.executeUpdate();
						JOptionPane.showMessageDialog(null, numberOfRowsAffected  + " rows affected", "Delet", JOptionPane.INFORMATION_MESSAGE);
					} else {
						return;
					}
					 
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		deleteBtn.setForeground(new Color(100, 149, 237));
		deleteBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		deleteBtn.setBackground(new Color(255, 255, 255));
		deleteBtn.setBounds(142, 219, 115, 38);
		ContentPane.add(deleteBtn);
		
		JButton closeBtn = new JButton("Κλείσιμο");
		closeBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getSearchForm().setEnabled(true);
				Main.getTeachersUpdateDeleteForm().setVisible(false);
				
			}
		});
		closeBtn.setForeground(new Color(100, 149, 237));
		closeBtn.setFont(new Font("Tahoma", Font.BOLD, 14));
		closeBtn.setBackground(Color.WHITE);
		closeBtn.setBounds(267, 219, 115, 38);
		ContentPane.add(closeBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 201, 372, 1);
		ContentPane.add(separator);
	}
}
