package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import model.CircleColor;
import model.CirclesModel;

@SuppressWarnings("serial")
public class CirclesStatus extends JPanel implements PropertyChangeListener{
	
	private JLabel status1;
	private JLabel status3;

	// this is for the bottom bit of the tute with the 3 sections
	
	public CirclesStatus(CirclesModel model) {
		
		setLayout(new GridLayout(1,0));
		// compoents are visible by default
		
		Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
		
//		this.status1 = new JLabel("Status 1", SwingConstants.LEFT);
//		status1.setBorder(border);
//		this.status3 = new JLabel("Status 1", SwingConstants.CENTER);
//		status3.setBorder(border);
//		JLabel status3 = new JLabel("Status 1", SwingConstants.RIGHT);
//		status3.setBorder(border);	
		status1 = new JLabel("Status 1", SwingConstants.LEFT);
		status1.setBorder(border);
		JLabel status2 = new JLabel("Status 2", SwingConstants.CENTER);
		status2.setBorder(border);
		status3 = new JLabel();
		status3.setBorder(border);
		
		
		// set the borders
	
		add(status1);
		add(status2);
		add(status3);
		model.addPropertyChangeListener(this);
		
	}
//	
//	public void updateLabel(String textMessage) {
//		this.status1.setText(textMessage);
//	}
	
	public void updateLabel(CircleColor images) {
		this.status1.setText(String.format("Selected %s", images.toString()));
		this.status3.setIcon(images.getImageIcon());
		
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
		if (evt.getPropertyName() == (CirclesModel.SELECTED_COLOR_CHANGE)) {
			updateLabel((CircleColor) evt.getNewValue());
		};
		
	}
}
