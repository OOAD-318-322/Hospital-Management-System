import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.sql.DriverManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.sql.SQLException;
import javax.swing.JTextField;
import java.sql.Statement;
import javax.swing.JTextArea;
import javax.swing.JButton;

public class PatientReport extends JFrame {

	private JPanel contentPane;
	private JTextField patientName;
	private JTextField date;
	private JTextField Doctor;
	private JTextField Diagnosis;
	private JTextArea treatment;
	private JTextArea prescription;
	private JButton btnSave = new JButton("Save");


	/**
	 * Create the frame.
	 */
	public PatientReport() {
		setTitle("Hospital Manager");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Patient report");
		lblNewLabel.setBounds(179, 11, 118, 14);
		contentPane.add(lblNewLabel);
		
		patientName = new JTextField();
		patientName.setBounds(270, 36, 96, 20);
		contentPane.add(patientName);
		patientName.setColumns(10);
		
		JTextArea treatment = new JTextArea();
		treatment.setBounds(270, 158, 96, 22);
		contentPane.add(treatment);
		
		date = new JTextField();
		date.setBounds(270, 65, 96, 20);
		contentPane.add(date);
		date.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Appointment Date (DD-MM-YYYY):");
		lblNewLabel_1.setBounds(10, 68, 226, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Patient Name:");
		lblNewLabel_2.setBounds(121, 36, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		Doctor = new JTextField();
		Doctor.setBounds(270, 96, 96, 20);
		contentPane.add(Doctor);
		Doctor.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Attending Physician:");
		lblNewLabel_3.setBounds(72, 100, 127, 14);
		contentPane.add(lblNewLabel_3);
		
		Diagnosis = new JTextField();
		Diagnosis.setBounds(270, 127, 96, 20);
		contentPane.add(Diagnosis);
		Diagnosis.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Diagnosis:");
		lblNewLabel_4.setBounds(134, 131, 77, 14);
		contentPane.add(lblNewLabel_4);
		
		JTextArea prescription = new JTextArea();
		prescription.setBounds(270, 195, 96, 22);
		contentPane.add(prescription);
		
		JLabel lblNewLabel_5 = new JLabel("Treatment:");
		lblNewLabel_5.setBounds(134, 162, 65, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Prescription:");
		lblNewLabel_6.setBounds(134, 195, 77, 14);
		contentPane.add(lblNewLabel_6);
		btnSave.setBounds(191, 232, 77, 22);
		contentPane.add(btnSave);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBounds(0, 242, 65, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			dispose();
    			DoctorChoices obj = new DoctorChoices();
    			obj.main(null);
    			//contentPane.setVisible(false);
    		}
    	});
		
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String patientName2 = patientName.getText();
			    String date2 = date.getText();
			    String Doctor2 = Doctor.getText();
			    String Diagnosis2 = Diagnosis.getText();
			    String treatment2 = treatment.getText();
			    String prescription2 = prescription.getText();
			    
			    
			    int code = 1;
		        String Name = patientName2;
		        String date = date2;
		        String Doc = Doctor2;
		        String diag = Diagnosis2;
		        String T = treatment2;
		        String pres = prescription2;
		        String ecc = "";
		        /*if (qty <= 0) {
		            code = 0;
		            ecc = "Invalid quantity";
		        }*/
		        try {
		        	Class.forName("org.postgresql.Driver");
		        	//Connection connection = (Connection)
		            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/hospital",
		                "postgres", "random_password");
		           String query = "INSERT INTO Report values(\'" + Name + "\', \'" + date + "\', \'" + Doc +"\', \'" + diag + "\', \'" + T + "\', \'" + pres+"\');";
		           Statement sta = connection.createStatement();  
		           int x = sta.executeUpdate(query);
		           connection.close();
		           
		            if (x == 0) {
		                code = 0;
		                ecc = "Already entered";
		                JOptionPane.showMessageDialog(null,
		            	        "Already entered",
		            	        "Info",
		            	        JOptionPane.INFORMATION_MESSAGE);
		            	return;
		            } else {
		            	JOptionPane.showMessageDialog(null,
		            			"Succesfully saved request",
		            			"Info",JOptionPane.INFORMATION_MESSAGE);
		code = 1;
		}
		            System.out.println(ecc);
		        } catch (Exception exception) {
		        	JOptionPane.showMessageDialog(null,
	            	        "Invalid request",
	            	        "Info",
	            	        JOptionPane.INFORMATION_MESSAGE);
	            	
		            //exception.printStackTrace();
		            return;
		        }
		        //return code;
			}
	});}
	
	/**
	 * Launch the application.
	 */
	
	
	public JTextField getpatientName() {
	    return patientName;
	}
	public void setpatientName(JTextField patientName) {
	    this.patientName = patientName;
	}
	
	
	public JTextField getdate() {
	    return date;
	}
	public void setdate(JTextField
			date) { this.date =
					date;
	}

	public JTextField getDoctor() {
	    return Doctor;
	}
	public void setDoctor(JTextField
			Doctor) { this.Doctor =
					Doctor;
	}
	public JTextField getDiagnosis() {
	    return Diagnosis;
	}
	public void setDiagnosis(JTextField Diagnosis) {
	    this.Diagnosis = Diagnosis;
	}
	
	
	public JTextArea gettreatment() {
	    return treatment;
	}
	public void settreatment(JTextArea treatment) {
	    this.treatment = treatment;
	}
	
	
	public JTextArea getprescription() {
	    return prescription;
	}
	public void setprescription(JTextArea prescription) {
	    this.prescription = prescription;
	}
	
	public JButton getbtnSave() {
        return btnSave;
}
    public void setbtnSave(JButton btnSave) {
        this.btnSave = btnSave;
    }
	    
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatientReport frame = new PatientReport();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}