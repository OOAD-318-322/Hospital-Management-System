import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class View {
    // View uses Swing framework to display UI to user
    private JFrame frame;
    private JLabel EqpmtNameLabel;
    private JLabel TypeLabel;
    private JLabel DoctorLabel;
    private JLabel QtyLabel;
    private JTextField EqpmtNameTextfield;
    private JTextField TypeTextfield;
    private JTextField DoctorTextfield;
    private JTextField QtyTextfield;
    private JButton SaveButton;
    //private JButton View;
    private JButton Quit;
    private JButton btnNewButton;
    public View(String title) {
        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        // Create UI elements
        EqpmtNameLabel = new JLabel("Equipment Name :");
        EqpmtNameLabel.setBounds(10, 14, 91, 14);
        TypeLabel = new JLabel("Type :");
        TypeLabel.setBounds(10, 40, 32, 14);
        DoctorLabel = new JLabel("Doctor :");
        DoctorLabel.setBounds(10, 66, 40, 14);
        QtyLabel = new JLabel("Quantity to be issued :");
        QtyLabel.setBounds(10, 92, 111, 14);
        EqpmtNameTextfield = new JTextField();
        EqpmtNameTextfield.setBounds(125, 11, 353, 20);
        TypeTextfield = new JTextField();
        TypeTextfield.setBounds(125, 37, 353, 20);
        DoctorTextfield = new JTextField();
        DoctorTextfield.setBounds(125, 63, 353, 20);
        QtyTextfield = new JTextField();
        QtyTextfield.setBounds(125, 89, 353, 20);
        SaveButton = new JButton("Save Details");
        SaveButton.setBounds(125, 115, 93, 23);
        //View = new JButton("View Details");
        //Quit = new JButton("Quit");
        //Quit.setBounds(125, 144, 53, 23);
        frame.getContentPane().setLayout(null);
        
        btnNewButton = new JButton("Back");
        // Add UI element to frame
        GroupLayout layout = new GroupLayout(frame.getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(EqpmtNameLabel)
        						.addComponent(TypeLabel)
        						.addComponent(DoctorLabel)
        						.addComponent(QtyLabel))
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(EqpmtNameTextfield, 353, 353, 353)
        						.addComponent(TypeTextfield, 353, 353, 353)
        						.addComponent(DoctorTextfield, 353, 353, 353)
        						.addComponent(QtyTextfield, 353, 353, 353)
        						//.addComponent(Quit)
        						.addComponent(SaveButton)))
        				.addComponent(btnNewButton))
        			.addContainerGap(10, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(EqpmtNameLabel)
        				.addComponent(EqpmtNameTextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(TypeLabel)
        				.addComponent(TypeTextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(DoctorLabel)
        				.addComponent(DoctorTextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(QtyLabel)
        				.addComponent(QtyTextfield, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addComponent(SaveButton)
        			//.addComponent(Quit)
        			.addPreferredGap(ComponentPlacement.RELATED, 275, Short.MAX_VALUE)
        			.addComponent(btnNewButton))
        );
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        frame.getContentPane().setLayout(layout);
        
        
        btnNewButton.addActionListener(new ActionListener() {
    		public void actionPerformed(ActionEvent e) {
    			frame.dispose();
    			DoctorChoices obj = new DoctorChoices();
    			obj.main(null);
    			//contentPane.setVisible(false);
    		}
    	});
        
}
    /*public JFrame getFrame() {
        return frame;
}
    public void setFrame(JFrame frame) {
        this.frame = frame;
}*/
    public JLabel getEqpmtNameLabel() {
        return EqpmtNameLabel;
}
public void setEqpmtNameLabel(JLabel EqpmtNameLabel) {
    this.EqpmtNameLabel = EqpmtNameLabel;
}
public JLabel getTypeLabel() {
    return TypeLabel;
}
public void setTypeLabel(JLabel TypeLabel) {
    this.TypeLabel = TypeLabel;
}
public JLabel getDoctorLabel() {
    return DoctorLabel;
}
public void setDoctorLabel(JLabel DoctorLabel) {
    this.DoctorLabel = DoctorLabel;
}
public JLabel getQtyLabel() {
    return QtyLabel;
}
public void setQtyLabel(JLabel QtyLabel) {
    this.QtyLabel = QtyLabel;
}
public JTextField getEqpmtNameTextfield() {
    return EqpmtNameTextfield;
}
public void setEqpmtNameTextfield(JTextField EqpmtNameTextfield) {
    this.EqpmtNameTextfield = EqpmtNameTextfield;
}
public JTextField getTypeTextfield() {
    return TypeTextfield;
}
public void setTypeTextfield(JTextField TypeTextfield) {
    this.TypeTextfield = TypeTextfield;
}
public JTextField getDoctorTextfield() {
    return DoctorTextfield;
}
public void setDoctorTextfield(JTextField
		DoctorTextfield) { this.DoctorTextfield =
				DoctorTextfield;
}
public JTextField getQtyTextfield() {
        return QtyTextfield;
}
    public void setQtyTextfield(JTextField QtyTextfield) {
        this.QtyTextfield = QtyTextfield;
}
    public JButton getSaveButton() {
        return SaveButton;
}
    public void setSaveButton(JButton SaveButton) {
        this.SaveButton = SaveButton;
}
    /*public JButton getView() {
        return View;
}
    public void setView(JButton View) {
        this.View = View;
}*/
    /*public JButton getQuit() {
        return Quit;
}
    public void setQuit(JButton Quit) {
        this.Quit = Quit;
}    */
}