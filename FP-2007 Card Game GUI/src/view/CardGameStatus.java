package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class CardGameStatus extends JPanel {

	private JLabel status1;
	private JLabel status2;

	public CardGameStatus() {

		setLayout(new GridLayout(1, 2));// 1 row 2 cols
		// create new border
		Border border = BorderFactory.createLineBorder(Color.BLUE, 1);
		status1 = new JLabel("Status 1", SwingConstants.CENTER); // text for the status bar
		status1.setBorder(border);
		status2 = new JLabel("Status 2", SwingConstants.CENTER); // text for the status bar
		status2.setBorder(border);

		// add the status bars which are labels to the panel
		add(status1);
		add(status2);

	}
//	

}
