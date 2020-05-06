package view;

import java.awt.FlowLayout;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Iterator;

import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class cardGameDiaglogBox extends JDialog {

	private final static String STUDENT_NAME = "Philip Beeby";
	private final static String STUDENT_NUMBER = "s366628";
	// https://www.javatpoint.com/java-get-current-date

	private static LocalDate currentDate = LocalDate.now();
	private static LocalTime currentTime = LocalTime.now();

	private JDialog dialog;
	private JLabel label;

//	= new JDialog(cardGameFrame, "About This Game"); 
//	JLabel l = new JLabel("this is a dialog box"); 
//	d.add(l);

	public cardGameDiaglogBox(JFrame frame, String dialogTitle, int size, boolean visible) {

		this.dialog = new JDialog(frame, dialogTitle);
		this.label = new JLabel(getDialogText());
		this.dialog.add(this.label);
		dialog.setLayout(new FlowLayout()); // otherwise it doesn't work
		this.dialog.setLocationRelativeTo(frame);
		this.dialog.setSize(size, size);
//		this.dialog.setSize(400, 400);
//		closeButton = new JButton("Close");
//		closeButton.setSize(2, 5);
//		dialog.add(closeButton);// add child to dialog

		JButton close = new JButton("Close");
		close.addActionListener(e -> dialog.setVisible(false));

//	    dialog.add(close);
		close.setBounds(50, 100, 95, 30);
		dialog.add(close);
		this.dialog.setVisible(visible);

//		setVisible(true);

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

	String convertStringtoHTML(String text) {
		String newText = "<html>";
		newText += text;
		newText += "<br/>";
		newText += "</html>";
		return newText;
	}

	String getDialogText() {

		String nameMessage = String.format("Author: %s", STUDENT_NAME);
		String numberMessage = String.format("Student ID: %s", STUDENT_NUMBER);
		String dateMessage = String.format("Date: %s", currentDate);
		String timeMessage = String.format("Date: %s", currentTime);
		return "<html>" + nameMessage + "<br/>" + numberMessage + "<br/>" + dateMessage + "<br/>" + timeMessage
				+ "</html>";
	}

}
