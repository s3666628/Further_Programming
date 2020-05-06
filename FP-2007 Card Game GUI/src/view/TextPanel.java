package view;

import javax.swing.JLabel;
import javax.swing.JPanel;



public class TextPanel {
	
	private JPanel newPanel;
	private JLabel newLabel ;
	
	// constructor
	public TextPanel(String labelText) {
		this.newPanel = new JPanel();
		JLabel newLabel = new JLabel(labelText);
		this.newPanel.add(newLabel);
		
	}

	public JPanel getNewPanel() {
		
		return newPanel;
	}

	public void setNewPanel(JPanel newPanel) {
		this.newPanel = newPanel;
	}
		
	

}
