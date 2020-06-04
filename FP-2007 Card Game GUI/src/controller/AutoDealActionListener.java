package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import model.GameEngine;
import model.GameEngineImpl;
import model.Player;
import model.PlayerImpl;
import model.bet.Bet;
import model.card.Suit;
import view.AddPlayerPanel;
import view.MainGameFrame;
import view.PlaceBetPanel;
import view.RemovePlayerPanel;
import view.TabbedPane;

public class AutoDealActionListener implements ActionListener {

	private GameEngine theModel;
	private MainGameFrame theView;

	public AutoDealActionListener(MainGameFrame theView, GameEngine theModel)

	{
		this.theView = theView;
		this.theModel = theModel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Auto Deal button has been clicked");
		Collection<Player> allPlayers = theModel.getAllPlayers();
		int timeDelay = 100;

		int numPlayersNoBet = 0;
		for (Player player : allPlayers) {
			if (player.getBet() == Bet.NO_BET) {
				numPlayersNoBet += 1;
			}
		}
// do not deal cards if there are players that have not placed a bet
		if (numPlayersNoBet == 0) {

			for (Player player : allPlayers) {
				try {
					theModel.dealPlayer(player.getId(), timeDelay);
				} catch (NullPointerException ex) {

					JOptionPane.showMessageDialog(null, "Player ID" + player.getName() + "cannot be Null");

				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage() + player.getName());

				} catch (IllegalStateException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage() + player.getName());

				}
			}
			try {
				theModel.dealHouse(timeDelay);
				}catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());}

		}
		else {
			JOptionPane.showMessageDialog(null, "All Players must place a bet before Auto Deal can run");
			
		}

	}

}
