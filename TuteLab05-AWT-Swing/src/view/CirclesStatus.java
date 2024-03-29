package view;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class CirclesStatus extends JPanel {
	
	private JLabel status1;
	private JLabel status2;

	// this is for the bottom bit of the tute with the 3 sections
	
	public CirclesStatus() {
		
		setLayout(new GridLayout(1,0));
		// compoents are visible by default
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
		this.status1 = new JLabel("Status 1", SwingConstants.LEFT);
		status1.setBorder(border);
		this.status2 = new JLabel("Status 1", SwingConstants.CENTER);
		status2.setBorder(border);
		JLabel status3 = new JLabel("Status 1", SwingConstants.RIGHT);
		status3.setBorder(border);	

		
		// set the borders
	
		this.add(status1);
		this.add(status2);
		this.add(status3);
		
		
	}
//	
//	public void updateLabel(String textMessage) {
//		this.status1.setText(textMessage);
//	}
	
	public void updateLabel(CircleImages images) {
		this.status1.setText(String.format("Selected %s", images.toString()));
		this.status2.setIcon(images.getImageIcon());
		
	}
}
