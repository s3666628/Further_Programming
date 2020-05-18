package view;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public abstract class AbstractCardGameAddDialog {
	
	private JDialog dialog;
	private JLabel label;
	
	public AbstractCardGameAddDialog(JFrame frame, String dialogTitle, String dialogText, int size, boolean visible) {
		// create new dialog
		this.dialog = new JDialog(frame, dialogTitle);
		this.label = new JLabel(dialogText);
		this.dialog.add(this.label);
		dialog.setLayout(new FlowLayout()); // otherwise it doesn't work
		this.dialog.setLocationRelativeTo(frame);
		this.dialog.setSize(size, size);

		// create the button to go on the dialog box
		JButton close = new JButton("Close");
		// action listener so that the button closes the window when user clicks on
		// button
		close.addActionListener(e -> dialog.setVisible(false));
		// Position the close button
		close.setBounds(50, 100, 95, 30);
		dialog.add(close);
		this.dialog.setVisible(visible);
		// for testing use
;
	}


}
