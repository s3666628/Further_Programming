package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import javax.swing.JOptionPane;
import model.GameEngine;
import model.Player;
import model.bet.Bet;
import view.MainGameFrame;

public class AutoDealActionListener implements ActionListener {

	private GameEngine theModel;

	public AutoDealActionListener(MainGameFrame theView, GameEngine theModel)

	{
		this.theModel = theModel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		new Thread() {
			public void run() {

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
					} catch (IllegalArgumentException ex) {
						JOptionPane.showMessageDialog(null, ex.getMessage());
					}

				} else {
					JOptionPane.showMessageDialog(null, "All Players must place a bet before Auto Deal can run");

				}
			}
		}.start();

	}

}
