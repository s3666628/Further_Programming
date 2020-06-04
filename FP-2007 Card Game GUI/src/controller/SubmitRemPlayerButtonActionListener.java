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
import view.RemovePlayerPanel;
import view.TabbedPane;

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
		TabbedPane theTabbedPane = theView.getTabbedPane();

//		
//		String PlayerId;
//		String PlayerName;
//		int PlayerPoints;

		System.out.println("Remove Player Submit button has been clicked");

		try {

//			String PlayerId = theSubView.getPlayerID(); // gets first number from the view
//			String PlayerName = theSubView.getPlayername(); // gets second number from the view
//			int PlayerPoints = theSubView.getPlayerPoints();

			String PlayerID = (String) theSubView.getplayersCombo().getSelectedItem(); // player to remove

			theModel.removePlayer(PlayerID);

//			theModel.addPlayer(player);
//			theTabbedPane.addNewPlayerToTabbedFrame(player);
//			theTabbedPane.addNewPlayerToTabbedFrame(player);

			JOptionPane.showMessageDialog(theView.getAddPlayerSubView(),
					"Player: " + PlayerID + " Has Been Removed from the game");

		} catch (NullPointerException ex) {
			theSubView.displayErrorMessage(ex.getMessage());
		} catch (IllegalArgumentException ex) {
			theSubView.displayErrorMessage(ex.getMessage());
		}

//		theModel.addPlayer(new PlayerImpl("P1", "Player One", 1000));
//		theModel.addPlayer(new Player());		

	}
}