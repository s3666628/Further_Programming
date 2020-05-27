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
		int timeDelay = 1;

		for (Player player : allPlayers) {
			try {
				theModel.dealPlayer(player.getId(), timeDelay);
			} catch (NullPointerException ex) {

				JOptionPane.showMessageDialog(null, "Player ID cannot be Null");

			} catch (IllegalArgumentException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());

			} catch (IllegalStateException ex) {
				JOptionPane.showMessageDialog(null, ex.getMessage());

			}

		}

	}

}
