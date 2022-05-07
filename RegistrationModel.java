/**import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;**/

public class RegistrationModel {
    private String Username;
    private String password;
    
    public RegistrationModel(String username, String password)
    {
        this.Username = username;
        this.password = password;
    }
    public String getUsername()
		{return Username;}

    public void setUsername(String username)
		{this.Username = username;}

    public String getPassword()
        {return password;}
    
    public void setPassword(String password) 
    	{this.password = password;}
}
