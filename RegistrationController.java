import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;


public class RegistrationController {
    private RegistrationModel model;
    private RegistrationView view;
 
    public RegistrationController(RegistrationView view){
        this.view = view;
 
        view.addRegListener(new RegListener());
    }
 
    class RegListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            try {
                model = view.getUser();
                if(checkUser(model)){
                    view.showMessage("Registered succesfully!");
                }
                else{
                    view.showMessage("One(or more) details entered is wrong!");
                }                
            } catch (Exception ex) {
                view.showMessage(ex.getStackTrace().toString());
            }
        }
    }

    
    public boolean checkUser(RegistrationModel User) throws Exception {
        String Username=User.getUsername();
        String password=User.getPassword();  
        try {
        	
        	Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital",
                "postgres", "random_password");
            String query = "INSERT INTO patients values(\'" + Username + "\', \'" + password + "\');";  
           Statement sta = connection.createStatement();
           int x = sta.executeUpdate(query);
           connection.close();
        }
           
           catch(Exception exception)
        {
        	   exception.printStackTrace();
        }
    
        return true;
    }}
