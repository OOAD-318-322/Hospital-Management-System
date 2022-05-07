import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class DoctorLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoctorLogin frame = new DoctorLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DoctorLogin() {
		setTitle("Hospital Manager System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setPreferredSize(new Dimension(0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setBounds(205, 38, 106, 47);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(170, 131, 96, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(170, 190, 96, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setBounds(88, 131, 78, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password :");
		lblNewLabel_1_1.setBounds(88, 190, 78, 20);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setBounds(177, 231, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(0, 242, 69, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
			    String password = passwordField.getText();
			    
			    int code = 1;
		        String ecc = "";
		        
		        try {
		        	
		        	Class.forName("org.postgresql.Driver");
		            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital",
		                "postgres", "random_password");
		            Statement stmt = connection.createStatement();

		            ResultSet rs = stmt.executeQuery( "select * from  DoctorCred;" );
		            
		            int flag = 0;
		            while ( rs.next() ) {

		               String tempUser = rs.getString("Name");

		               String  tempPass = rs.getString("password");
		               
		               
		               if (username.equals(tempUser))
		            	   
		               {
		            	   if (password.equals(tempPass))
		            	   {
		            		   flag = 1;
		            		   JOptionPane.showMessageDialog(null,
		            				   "Log In successful",
		            				   "Info",JOptionPane.INFORMATION_MESSAGE);
		            		   dispose();
		      					DoctorChoices obj = new DoctorChoices();
		      					obj.main(null);
		            	   }
		            	   
		            	   else
		            	   {
		            		   JOptionPane.showMessageDialog(null,
		            			        "Incorrect credentials",
		            			        "Info",
		            			        JOptionPane.INFORMATION_MESSAGE);
		            		   flag = 1;
		            	   		        break;
		            	   }
		               }		            	   
		               }
		            
		            if (flag == 0)
		            {
		            	JOptionPane.showMessageDialog(null,
            			        "Incorrect credentials",
            			        "Info",
            			        JOptionPane.INFORMATION_MESSAGE);
            	   		        
		            }
		            rs.close();
		            stmt.close();
		            connection.close();
		        } catch (Exception exception) {
		            exception.printStackTrace();
		        }
			}
		});
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OpenView obj = new OpenView();
				obj.main(null);
			}
		});
	}
}
