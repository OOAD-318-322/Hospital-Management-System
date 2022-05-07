import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(9, 49, 80, 32);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(99, 58, 184, 19);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 117, 80, 13);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Admin Login");
		lblNewLabel_2.setVerticalAlignment(SwingConstants.TOP);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(174, 10, 109, 29);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
			    String password = passwordField.getText();
			    
			    int code = 1;
		        String ecc = "";
		        
		        try {
		        	
		        	Class.forName("org.postgresql.Driver");
		        	//Connection connection = (Connection)
		            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital",
		                "postgres", "random_password");
		            Statement stmt = connection.createStatement();

		            ResultSet rs = stmt.executeQuery( "select * from  AdminCred;" );
		            
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
		      					AdminOptions obj = new AdminOptions();
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
		btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		btnNewButton.setBounds(140, 181, 98, 32);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(99, 116, 184, 19);
		contentPane.add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setBounds(0, 231, 89, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				OpenView obj = new OpenView();
				obj.main(null);
			}
		});
	}
}
