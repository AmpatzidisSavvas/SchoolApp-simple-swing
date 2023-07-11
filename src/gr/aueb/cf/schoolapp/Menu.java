package gr.aueb.cf.schoolapp;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Menu extends JFrame {

	private static final long serialVersionUID = 123456;
	private JPanel contentPane;
	private static Connection connection;
	
	
	public Menu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Menu.class.getResource("/resources/357723230_6327687377321082_6310236883841704585_n.png")));
		
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				
				String username = "schooldbuser";
				String password = System.getenv("SCHOOL_DB_USER_PASSWRD");
				String url = "jdbc:mysql://localhost:3306/schooldb?serverTimezone=UTC";
				
				try {
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					connection = DriverManager.getConnection(url, username, password);
					System.out.println("Connection established");
						
				} catch (SQLException | ClassNotFoundException e1) {
					e1.printStackTrace();
				}
			}
		});
		setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		setTitle("Μενού Διαχείρισης Σχολικού Συστήματος");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 486, 329);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setForeground(UIManager.getColor("RadioButton.light"));
		contentPane.setBackground(UIManager.getColor("FileChooser.listViewBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton teachersBtn = new JButton("");
		teachersBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Main.getSearchForm().setVisible(true);
				Main.getMenu().setEnabled(false);
			}
		});
		teachersBtn.setForeground(new Color(0, 0, 0));
		teachersBtn.setBounds(43, 107, 48, 48);
		contentPane.add(teachersBtn);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(43, 198, 48, 48);
		contentPane.add(btnNewButton_1);
		
		JLabel IbIEdyQuality1 = new JLabel("Ποιότητα στην Εκπαίδευση");
		IbIEdyQuality1.setForeground(SystemColor.windowText);
		IbIEdyQuality1.setFont(new Font("Tahoma", Font.BOLD, 22));
		IbIEdyQuality1.setBounds(101, 15, 301, 31);
		contentPane.add(IbIEdyQuality1);
		
		JLabel lblStudents = new JLabel("Εκπαιδευτές");
		lblStudents.setForeground(new Color(153, 0, 0));
		lblStudents.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblStudents.setBounds(107, 117, 132, 29);
		contentPane.add(lblStudents);
		
		JLabel lblNewLabel_2 = new JLabel("Εκπαιδευόμενοι");
		lblNewLabel_2.setForeground(new Color(153, 0, 0));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(107, 208, 132, 29);
		contentPane.add(lblNewLabel_2);
		
		JLabel IbIEdyQuality2 = new JLabel("Ποιότητα στην Εκπαίδευση");
		IbIEdyQuality2.setForeground(new Color(255, 255, 255));
		IbIEdyQuality2.setFont(new Font("Tahoma", Font.BOLD, 22));
		IbIEdyQuality2.setBounds(104, 18, 301, 31);
		contentPane.add(IbIEdyQuality2);
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
