package view;

import java.awt.FlowLayout;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

import controller.CloseButtonActionListener;

@SuppressWarnings("serial")
public class AboutGameDiaglogBox extends JDialog {

	// this is used in the About dialog box to output student details
	private final static String STUDENT_NAME = "Philip Beeby";
	private final static String STUDENT_NUMBER = "s366628";
	private static Date currentDate = new Date();
	private JDialog dialog;
	private JLabel label;
	

// create a new dialog box which takes a frame so we can add it to the frame
	public AboutGameDiaglogBox(MainGameFrame cardGameFrame, String dialogTitle, int size, boolean visible) {
		// create new dialog
		this.dialog = new JDialog(cardGameFrame, dialogTitle);
		this.label = new JLabel(getDialogText());
		this.dialog.add(this.label);
		dialog.setLayout(new FlowLayout()); // otherwise it doesn't work
		this.dialog.setLocationRelativeTo(cardGameFrame);
		this.dialog.setSize(size, size);

		// create the button to go on the dialog box
		JButton close = new JButton("Close");
		// action listener so that the button closes the window when user clicks on
		// button
//		close.addActionListener(e -> dialog.setVisible(false));
		int closeOption =1; // so we close the right thing
		close.addActionListener(new CloseButtonActionListener(dialog, cardGameFrame, closeOption));
		// Position the close button
		close.setBounds(50, 100, 95, 30);
		dialog.add(close);
		this.dialog.setVisible(visible);
		// for testing use
		System.out.println(dialog.getTitle());
		System.out.println("new object created");
	}

// no longer needed but save just in case
	String convertStringtoHTML(String text) {
		String newText = "<html>";
		newText += text;
		newText += "<br/>";
		newText += "</html>";
		return newText;
	}

	String getDialogText() {
		// formats the text that goes on the About button
		SimpleDateFormat dateFormat = new SimpleDateFormat("EEE dd MMM yyyy");
		SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
		String dateString = dateFormat.format(currentDate);
		String timeString = timeFormat.format(currentDate);

		String nameMessage = String.format("Author: %s", STUDENT_NAME);
		String numberMessage = String.format("Student ID: %s", STUDENT_NUMBER);
		String dateMessage = String.format("Date: %s", dateString);
		String timeMessage = String.format("Time: %s", timeString);
		return "<html>" + nameMessage + "<br/>" + numberMessage + "<br/>" + dateMessage + "<br/>" + timeMessage
				+ "</html>";
	}

}
