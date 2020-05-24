package view;

import javax.swing.*;

import model.GameEngineImpl;
import model.Player;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

@SuppressWarnings("serial")

public class PlaceBetPanel extends JFrame {

	// instance variables
	private JLabel playerRemove = new JLabel("Select Player:"); // Label for playerID//
	private JButton submit = new JButton("Confirm Bet"); // button for submitting player information
	private JButton cancel = new JButton("Cancel"); // button cancelling and closing the screen
	private JLabel labelplayerBetAmount = new JLabel("Bet Amount:"); // Label for PlayerName
	private JTextField betAmount = new JTextField(10); // text field for PlayerName

	private String[] playerNames;
	private JComboBox<String> playersCombo;
	private Collection<Player> AllPlayers;
	public JComboBox<String> getplayersCombo() {
		return this.playersCombo;

	}


	// this is called by GUI Callback when new player is added to the model
	// so that the new player is added to the string of arrays and is then seen on the screen
	public void addPlayerToCombo(String playerId) {
		this.playersCombo.addItem(playerId);
	}
	
	public void remPlayerFromCombo(String playerId) {
		this.playersCombo.removeItem(playerId);
	}


	// constructor for the panel
	public PlaceBetPanel(GameEngineImpl theModel) {

		this.AllPlayers = theModel.getAllPlayers();
		this.playerNames = CardGameHelperMethods.createPlayerIdList(AllPlayers);
		this.playersCombo = new JComboBox<String>(playerNames);



		System.out.println("CardGameRemovePlayerPanel has been created");
		JPanel removePlayerPanel = new JPanel(); // create new jPanel which will get called when constructor is called
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // so it closes
		this.setSize(500, 100); // confused about the "this"

		removePlayerPanel.add(playersCombo); // add PlayerIDLabel
		removePlayerPanel.add(playerRemove); // add PlayerName Text Field
		removePlayerPanel.add(labelplayerBetAmount); // add PlayerIDLabel
		removePlayerPanel.add(betAmount); // add PlayerName Text Field

		removePlayerPanel.add(submit);
		removePlayerPanel.add(cancel);

		this.setTitle("Place Bet");
		this.add(removePlayerPanel);

	}
	
	public int getPlayerBetAmount() {

		return Integer.parseInt(betAmount.getText());

	}


	public void addSubmitBetListener(ActionListener SubmitBetButtonActionListener) {

		submit.addActionListener(SubmitBetButtonActionListener);
	}

	public void cancelButtonListener(ActionListener CloseButtonActionListener) {

		cancel.addActionListener(CloseButtonActionListener);
	}

	public void displayErrorMessage(String errorMessage) {

		JOptionPane.showMessageDialog(this, errorMessage);
	}

}
