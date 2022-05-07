import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AdminOptions extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminOptions frame = new AdminOptions();
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
	public AdminOptions() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("List of Doctors");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] doctors = {"Names"};
				String[] names;
				names = new String[1];
				DefaultTableModel model = new DefaultTableModel(null, doctors);
				JTable abc  = new JTable(model);
				try {
				Class.forName("org.postgresql.Driver");
	        	
	            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital",
	                "postgres", "random_password");
	            Statement stmt = connection.createStatement();

	            ResultSet rs = stmt.executeQuery( "select * from  listOfdoctors;" );
	            
	            int flag = 0;
	            while ( rs.next() ) {
	            	names[0] = rs.getString("Name");
	                model.addRow(names);	            
	            }
	            abc.setModel(model);
	            abc.setBounds(30, 40, 200, 300);
	            
	            // adding it to JScrollPane
	            JScrollPane sp = new JScrollPane(abc);
	            add(sp);
	            setSize(500, 200);
	            // Frame Visible = true
	            setVisible(true);
	            rs.close();

	            stmt.close();

	            connection.close();}
	            
	            catch(Exception exception)
	            {
	            	exception.printStackTrace();
	            }
			}
		});
		btnNewButton.setBounds(128, 39, 147, 67);
		contentPane.add(btnNewButton);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				RegistrationView view       = new RegistrationView();
		         @SuppressWarnings("unused")
				RegistrationController controller = new RegistrationController(view);        
		         view.setVisible(true);
			}
		});
		btnRegister.setBounds(128, 145, 147, 67);
		contentPane.add(btnRegister);
	}
}
