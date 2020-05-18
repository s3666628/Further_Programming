package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.CardGameAddPlayerPanel;

public class AddPlayerButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		
		CardGameAddPlayerPanel addNewPlayerDetails = new CardGameAddPlayerPanel();		
		addNewPlayerDetails.setVisible(true); 
		
		System.out.println("button has been clicked");
		
		
		
	}

}
