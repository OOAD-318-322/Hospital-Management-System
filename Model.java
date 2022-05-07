import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.JOptionPane;
public class Model {
    private String EqpmtName;
    private String Type;
    private String Doctor;
    private int Issue_qty;
    public Model(String EqpmtName, String Type, String Doctor, int Issue_qty) {
        this.EqpmtName = EqpmtName;
        this.Type = Type;
        this.Doctor = Doctor;
        this.Issue_qty = Issue_qty;
}
    
    
public String getEqpmtName() {
    return EqpmtName;
}

public void setEqpmtName(String EqpmtName) {
    this.EqpmtName = EqpmtName;
}

public String getType() {
    return Type;
}

public void setType(String Type) {
    this.Type = Type;
}
public String getDoctor() {
    return Doctor;
}
public void setDoctor(String Doctor) {
    this.Doctor = Doctor;
}
public int getIssue_qty() {
    return Issue_qty;
    }
    public void setIssue_qty(int Issue_qty) {
        this.Issue_qty = Issue_qty;
}
    public int actionPerformed(String EqpmtName, String Type, String Doctor,
            int Issue_qty) {
        int code = 1;
        String Name = EqpmtName;
        String T = Type;
        String Doc = Doctor;
        int qty = Issue_qty;
        String ecc = "";
        if (qty <= 0 || (((Object)qty).getClass().getSimpleName()) != "Integer") {
        	JOptionPane.showMessageDialog(null,
        	        "Request Unsuccessful",
        	        "Info",
        	        JOptionPane.INFORMATION_MESSAGE);
            code = 0;
            ecc = "Invalid quantity";
            return code;
        }
        try {
        	
        	Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital",
                "postgres", "random_password");
            String query = "INSERT INTO Inventory values(\'" + Name + "\', \'" + T + "\', \'" + Doc +"\', \'" + qty + "\');";  
           Statement sta = connection.createStatement();
           int x = sta.executeUpdate(query);
           connection.close();
           
            if (x == 0) {
            	
            	JOptionPane.showMessageDialog(null,
            	        "Request Unsuccessful",
            	        "Info",
            	        JOptionPane.INFORMATION_MESSAGE);
                code = 0;
                ecc = "Already issued";
            } else {
code = 1;
}
            System.out.println(ecc);
        } catch (Exception exception) {
        	
        	exception.printStackTrace();
            
        }
        return code;
    }    
}