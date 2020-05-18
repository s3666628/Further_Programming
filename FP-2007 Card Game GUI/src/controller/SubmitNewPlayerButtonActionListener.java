package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.GameEngine;
import model.GameEngineImpl;
import model.Player;
import model.PlayerImpl;
import view.CardGameAddPlayerPanel;
import view.CardGameFrame;


public class SubmitNewPlayerButtonActionListener implements ActionListener {
	
	
	private GameEngine theModel;
	private CardGameFrame theView;
	
	
	
	
	public SubmitNewPlayerButtonActionListener(CardGameFrame theView, GameEngine theModel) 
	
	{
		this.theView = theView;
		this.theModel = theModel;	
		
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		CardGameAddPlayerPanel theSubView = theView.getSubView();
		
		
//		
//		String PlayerId;
//		String PlayerName;
//		int PlayerPoints;
		
		System.out.println("Submit button has been clicked");
//		JOptionPane.showMessageDialog(theView.getSubView(), "Player Has Been Created");
		
//		PlayerId = theSubView.getPlayerID(); //gets first number from the view
//		PlayerName = theSubView.getName(); // gets second number from the view
//		PlayerPoints = theSubView.getPlayerPoints();
//		
//		theModel.addPlayer(new PlayerImpl(PlayerId, PlayerName, PlayerPoints));
//		theModel.addPlayer(new PlayerImpl("P1", "Player One", 1000));
//		theModel.addPlayer(new Player());		
//		
		
		
	}

}
