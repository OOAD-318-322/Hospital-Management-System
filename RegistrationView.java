import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class RegistrationView extends JFrame implements ActionListener{
	private JTextField txtUsername;
    private JTextField txtPassword;
    private JButton btnLog;
    private RegistrationModel model;
 
    public RegistrationView(){
        super("Hospital Admin");
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
 
        JPanel content = new JPanel();
        JLabel label = new JLabel("Name:");
        txtUsername = new JTextField(15);
        JLabel label_1 = new JLabel("Phone number:");
        btnLog= new JButton("Register");
        
               btnLog.addActionListener(this);
 
        this.setContentPane(content);
        content.setLayout(new GridLayout(0, 1, 0, 0));
        content.add(label);
        content.add(txtUsername);
        content.add(label_1);
        
        txtPassword = new JTextField();
        content.add(txtPassword);
        txtPassword.setColumns(10);
        content.add(btnLog);
        this.pack();
 
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                System.exit(0);
            }
        });
    }
    public void actionPerformed(ActionEvent e) {
    }
    @SuppressWarnings("deprecation")
	public RegistrationModel getUser() {
     model = new RegistrationModel(txtUsername.getText(), txtPassword.getText());
        return model;       
    }
 
    public void showMessage(String msg){
        JOptionPane.showMessageDialog(this, msg);
    }
 
    public void addRegListener(ActionListener log) {
          btnLog.addActionListener(log);
        }
}