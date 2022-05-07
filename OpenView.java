import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class OpenView extends JFrame {

	private JPanel contentPane;
	private JButton doctorButton;
	private JButton adminButton;

	public OpenView() {
		setTitle("Hospital Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		doctorButton = new JButton("Doctor");
		doctorButton.setBounds(137, 152, 149, 61);
		contentPane.add(doctorButton);
		
		adminButton = new JButton("Admin");
		adminButton.setBounds(137, 61, 149, 61);
		contentPane.add(adminButton);
		doctorButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				DoctorLogin obj = new DoctorLogin();
				obj.main(null);
			}
		});
		
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				Admin obj = new Admin();
				obj.main(null);
			}
		});
		
	}
	
	
	public JButton getdoctorButton() {
        return doctorButton;
}
	public void setdoctorButton()
	{
		this.doctorButton = doctorButton;
		
	}
	
	public JButton getadminButton() {
        return adminButton;
}

	public void setadminButton()
	{
		this.adminButton = adminButton;
		
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpenView frame = new OpenView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
    
