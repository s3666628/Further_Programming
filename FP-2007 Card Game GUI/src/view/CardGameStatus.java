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
		
		setLayout(new GridLayout(1,0));
		// compoents are visible by default
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
//		this.status1 = new JLabel("Status 1", SwingConstants.LEFT);
//		status1.setBorder(border);
//		this.status3 = new JLabel("Status 1", SwingConstants.CENTER);
//		status3.setBorder(border);
//		JLabel status3 = new JLabel("Status 1", SwingConstants.RIGHT);
//		status3.setBorder(border);	
		status1 = new JLabel("Status 1", SwingConstants.CENTER);
		status1.setBorder(border);		
//		status1.setVerticalTextPosition(SwingConstants.CENTER);
		status2 = new JLabel("Status 2", SwingConstants.CENTER);
//		status2.setVerticalTextPosition(SwingConstants.CENTER);
		status2.setBorder(border);
	

		
		
		// set the borders
	
		add(status1);
		add(status2);

//		model.addPropertyChangeListener(this);
		
	}
//	
	

}
