package view;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class cardGameDiaglogBox extends JDialog{
	
	private JDialog dialog;
	private JLabel label;

	
//	= new JDialog(cardGameFrame, "About This Game"); 
//	JLabel l = new JLabel("this is a dialog box"); 
//	d.add(l);
	
	public cardGameDiaglogBox(JFrame frame, String dialogTitle, String labelName, int size, boolean visible){
		
		this.dialog = new JDialog(frame, dialogTitle);
		this.label = new JLabel(labelName); 
		this.dialog.add(this.label);
		this.dialog.setVisible(visible);		
		this.dialog.setSize(size, size); 
		  
        // set visibility of dialog 
//		dialog.setVisible(true);
		
		System.out.println(dialog.getTitle());
		// create a new dialog box for the frame passed in.
//		JDialog dialog = new JDialog(frame, dialogTitle); 
//		//create a new label for the dialog box - based on label name
//		JLabel label = new JLabel(labelName); 
//		//add the label to the dialog
//		this.dialog.add(label);
		
		
		System.out.println("new object created");
	}

}
