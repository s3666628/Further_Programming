package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import model.GameEngine;
import model.Player;
import model.PlayerImpl;
import view.AddPlayerPanel;
import view.MainGameFrame;

public class SubmitNewPlayerButtonActionListener implements ActionListener {

	private GameEngine theModel;
	private MainGameFrame theView;

	public SubmitNewPlayerButtonActionListener(MainGameFrame theView, GameEngine theModel)

	{
		this.theView = theView;
		this.theModel = theModel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new Thread() {
			@Override
			public void run() {

				AddPlayerPanel theSubView = theView.getAddPlayerSubView();
				System.out.println("Submit button has been clicked");

				try {

					String PlayerId = theSubView.getPlayerID(); // gets first number from the view
					String PlayerName = theSubView.getPlayername(); // gets second number from the view
					int PlayerPoints = theSubView.getPlayerPoints();
					Player player = new PlayerImpl(PlayerId, PlayerName, PlayerPoints);

					theModel.addPlayer(player);

					JOptionPane.showMessageDialog(theView.getAddPlayerSubView(),
							"Player: " + PlayerName + " Has Been Created with " + PlayerPoints + " points");

				} catch (NumberFormatException ex) {
					theSubView.displayErrorMessage("You need to enter a number for Player Points ");
				} catch (NullPointerException ex) {
					theSubView.displayErrorMessage(ex.getMessage());
				} catch (IllegalArgumentException ex) {
					theSubView.displayErrorMessage(ex.getMessage());
				}

			}

		}.start();

	}
}
