import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
public class Controller {
    private Model model;
    private View view;
    private OpenView openview;
     public Controller(Model m, View v, OpenView ov) {
        model = m;
view = v;
	openview = ov;
        initView();
    }
    public void initView() {
        view.getEqpmtNameTextfield();//.setText(model.getEqpmtName());
        view.getTypeTextfield();//.setText(model.getType());
        view.getDoctorTextfield();//.setText(model.getDoctor());
    view.getQtyTextfield();//.setText(String.valueOf(model.getIssue_qty()));
    }
    public void initController() {
        view.getSaveButton().addActionListener(e -> saveName());
        //view.getView().addActionListener(e -> sayView());
        //view.getQuit().addActionListener(e -> sayQuit());
        
        openview.getdoctorButton().addActionListener(e -> docLoginPage());
      //openview.getadminButton().addActionListener(e -> adLoginPage());
}
    private void saveName() {
        model.setEqpmtName(view.getEqpmtNameTextfield().getText());
        model.setType(view.getTypeTextfield().getText());
        model.setDoctor(view.getDoctorTextfield().getText());
        try {
        model.setIssue_qty(Integer.valueOf(view.getQtyTextfield().getText())); }
        catch(Exception exception)
        {
        	JOptionPane.showMessageDialog(null,
        	        "Invalid request",
        	        "Info",
        	        JOptionPane.INFORMATION_MESSAGE);
        	return;
        }
        int code =
model.actionPerformed(view.getEqpmtNameTextfield().getText(),
view.getTypeTextfield().getText(),
view.getDoctorTextfield().getText(),
              Integer.valueOf(view.getQtyTextfield().getText()));
        if (code == 1) {
            JOptionPane.showMessageDialog(null,
"Succesfully saved request",
"Info",JOptionPane.INFORMATION_MESSAGE);
} else {JOptionPane.showMessageDialog(null,
        "Invalid quantity",
        "Info",
        JOptionPane.INFORMATION_MESSAGE);}}
    private void sayView() {
        JOptionPane.showMessageDialog(null,
               "Equipment Name : " + model.getEqpmtName() + "\nType : " +
model.getType()
                      + "\nDoctor requesting : " + model.getDoctor()
                        + "\nQuantity to be issued : " +
String.valueOf(model.getIssue_qty()),
                "Info",
                 JOptionPane.INFORMATION_MESSAGE);
}
    
    
    private void docLoginPage() {
				DoctorLogin obj = new DoctorLogin();
				obj.main(null);
	}
}
