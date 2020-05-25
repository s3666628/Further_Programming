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
import model.card.Suit;
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

		String playerID = (String) theSubView.getPlayerCombo().getSelectedItem(); //
		String suitBet = (String) theSubView.getSuitCombo().getSelectedItem();
		int betAmount = theSubView.getPlayerBetAmount();
		if (suitBet == "None (Score Bet)") {

			try {

				theModel.placeBet(playerID, betAmount);
				JOptionPane.showMessageDialog(theView.getAddPlayerSubView(),
						"Player: " + playerID + " Has Place a Bet for $ " + betAmount);

			} catch (NumberFormatException ex) {
				theSubView.displayErrorMessage("Bet Amount must be a Number");

			} catch (NullPointerException ex) {
				theSubView.displayErrorMessage(ex.getMessage());
			} catch (IllegalArgumentException ex) {
				theSubView.displayErrorMessage(ex.getMessage());
			}

		}

		else if (suitBet == "Clubs") {

			try {

				theModel.placeBet(playerID, betAmount, Suit.CLUBS);

				JOptionPane.showMessageDialog(theView.getAddPlayerSubView(),
						"Player: " + playerID + " Has Place a Bet for $ " + betAmount + "on the Suit: " + Suit.CLUBS.toString() );

			} catch (NumberFormatException ex) {
				theSubView.displayErrorMessage("Bet Amount must be a Number");

			} catch (NullPointerException ex) {
				theSubView.displayErrorMessage(ex.getMessage());
			} catch (IllegalArgumentException ex) {
				theSubView.displayErrorMessage(ex.getMessage());
			}

		}
		else if (suitBet == "Diamonds") {

			try {

				theModel.placeBet(playerID, betAmount, Suit.DIAMONDS);

				JOptionPane.showMessageDialog(theView.getAddPlayerSubView(),
						"Player: " + playerID + " Has Place a Bet for $ " + betAmount + "on the Suit: " + Suit.DIAMONDS.toString() );

			} catch (NumberFormatException ex) {
				theSubView.displayErrorMessage("Bet Amount must be a Number");

			} catch (NullPointerException ex) {
				theSubView.displayErrorMessage(ex.getMessage());
			} catch (IllegalArgumentException ex) {
				theSubView.displayErrorMessage(ex.getMessage());
			}

		}
		else if (suitBet == "Hearts") {

			try {

				theModel.placeBet(playerID, betAmount, Suit.HEARTS);

				JOptionPane.showMessageDialog(theView.getAddPlayerSubView(),
						"Player: " + playerID + " Has Place a Bet for $ " + betAmount + "on the Suit: " + Suit.HEARTS.toString() );

			} catch (NumberFormatException ex) {
				theSubView.displayErrorMessage("Bet Amount must be a Number");

			} catch (NullPointerException ex) {
				theSubView.displayErrorMessage(ex.getMessage());
			} catch (IllegalArgumentException ex) {
				theSubView.displayErrorMessage(ex.getMessage());
			}

		}
		else {

			try {

				theModel.placeBet(playerID, betAmount, Suit.SPADES);

				JOptionPane.showMessageDialog(theView.getAddPlayerSubView(),
						"Player: " + playerID + " Has Place a Bet for $ " + betAmount + "on the Suit: " + Suit.SPADES.toString() );

			} catch (NumberFormatException ex) {
				theSubView.displayErrorMessage("Bet Amount must be a Number");

			} catch (NullPointerException ex) {
				theSubView.displayErrorMessage(ex.getMessage());
			} catch (IllegalArgumentException ex) {
				theSubView.displayErrorMessage(ex.getMessage());
			}

		}
	}
}