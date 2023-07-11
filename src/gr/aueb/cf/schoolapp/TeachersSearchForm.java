package gr.aueb.cf.schoolapp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TeachersSearchForm extends JFrame {

	private static final long serialVersionUID = 123456;
	private JPanel contentPane;
	private JTextField lastnameTxt;
	private String lastname = "";


	public TeachersSearchForm() {
		setTitle("Εισαγωγή/Αναζήτηση Εκπαιδευτή");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TeachersSearchForm.class.getResource("/resources/357723230_6327687377321082_6310236883841704585_n.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 358);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 248, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton SearchBtn = new JButton("Αναζήτηση");
		SearchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lastname = lastnameTxt.getText();
				Main.getTeachersUpdateDeleteForm().setVisible(true);
				Main.getSearchForm().setEnabled(false);
			}
		});
		SearchBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		SearchBtn.setForeground(new Color(0, 102, 204));
		SearchBtn.setBounds(172, 123, 96, 35);
		contentPane.add(SearchBtn);
		
		JLabel lblLastname = new JLabel("Επώνυμο");
		lblLastname.setForeground(new Color(153, 0, 0));
		lblLastname.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLastname.setBounds(172, 45, 96, 30);
		contentPane.add(lblLastname);
		
		lastnameTxt = new JTextField();
		lastnameTxt.setBounds(136, 85, 172, 25);
		contentPane.add(lastnameTxt);
		lastnameTxt.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("ComboBox.disabledBackground"));
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		panel.setBounds(72, 22, 297, 162);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton InsertBtn = new JButton("Εισαγωγή");
		InsertBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getTeachersInsertForm().setVisible(true);
				Main.getSearchForm().setEnabled(false);
			}
		});
		InsertBtn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		InsertBtn.setForeground(new Color(0, 102, 204));
		InsertBtn.setBounds(172, 210, 96, 35);
		contentPane.add(InsertBtn);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBounds(72, 194, 297, 70);
		contentPane.add(panel_2);
		
		JButton CloseBtn = new JButton("Close");
		CloseBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getMenu().setEnabled(true);
				Main.getSearchForm().setVisible(false);
			}
		});
		CloseBtn.setForeground(new Color(255, 0, 0));
		CloseBtn.setBounds(300, 281, 69, 30);
		contentPane.add(CloseBtn);
	}


	public String getLastname() {
		return lastname;
	}
}
