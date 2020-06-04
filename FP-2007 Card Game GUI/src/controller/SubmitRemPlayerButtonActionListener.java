package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.GameEngine;
import view.MainGameFrame;
import view.RemovePlayerPanel;

public class SubmitRemPlayerButtonActionListener implements ActionListener {

	private GameEngine theModel;
	private MainGameFrame theView;

	public SubmitRemPlayerButtonActionListener(MainGameFrame theView, GameEngine theModel)

	{
		this.theView = theView;
		this.theModel = theModel;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		RemovePlayerPanel theSubView = theView.getRemovePlayerPanel();

		System.out.println("Remove Player Submit button has been clicked");

		try {

			String PlayerID = (String) theSubView.getplayersCombo().getSelectedItem(); // player to remove

			theModel.removePlayer(PlayerID);

			JOptionPane.showMessageDialog(theView.getAddPlayerSubView(),
					"Player: " + PlayerID + " Has Been Removed from the game");

		} catch (NullPointerException ex) {
			theSubView.displayErrorMessage(ex.getMessage());
		} catch (IllegalArgumentException ex) {
			theSubView.displayErrorMessage(ex.getMessage());
		}

	}
}