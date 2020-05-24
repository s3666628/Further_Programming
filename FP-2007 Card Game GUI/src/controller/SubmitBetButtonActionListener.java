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
import view.AddPlayerPanel;
import view.MainGameFrame;
import view.PlaceBetPanel;
import view.RemovePlayerPanel;
import view.TabbedPane;

public class SubmitBetButtonActionListener implements ActionListener {

	private GameEngine theModel;
	private MainGameFrame theView;

	public SubmitBetButtonActionListener(MainGameFrame theView, GameEngine theModel)

	{
		this.theView = theView;
		this.theModel = theModel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		RemovePlayerPanel theSubView = theView.getRemovePlayerPanel();
		PlaceBetPanel theSubView = theView.getPlaceBetPanel();

		System.out.println("Submit **BET** button has been clicked");

		try {

//			String PlayerId = theSubView.getPlayerID(); // gets first number from the view
//			String PlayerName = theSubView.getPlayername(); // gets second number from the view
//			int PlayerPoints = theSubView.getPlayerPoints();

			String playerID = (String) theSubView.getplayersCombo().getSelectedItem(); // player to remove
			int betAmount = theSubView.getPlayerBetAmount();

			theModel.placeBet(playerID, betAmount);

//			if (playerId == null) {
//				throw new NullPointerException("Player ID cannot be Null");
//			}
//			if (playerId.isEmpty()) {
//				throw new IllegalArgumentException("Player ID has not been populated");
//			}
//			if (amount < 0) {
//				throw new IllegalArgumentException("Bet Amount cannot be negative");
//			}

			JOptionPane.showMessageDialog(theView.getAddPlayerSubView(),
					"Player: " + playerID + " Has Place a Bet for $ "+betAmount);

		} catch (NumberFormatException ex) {
			theSubView.displayErrorMessage("Bet Amount must be a Number");
			
		} catch (NullPointerException ex) {
			theSubView.displayErrorMessage(ex.getMessage());
		} catch (IllegalArgumentException ex) {
			theSubView.displayErrorMessage(ex.getMessage());
		}

//		theModel.addPlayer(new PlayerImpl("P1", "Player One", 1000));
//		theModel.addPlayer(new Player());		

	}
}