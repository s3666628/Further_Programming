package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.CardGameAddPlayerPanel;

public class RemovePlayerButtonActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		new CardGameAddPlayerPanel();
		System.out.println("Player been removed");
		
		
		
	}

}
