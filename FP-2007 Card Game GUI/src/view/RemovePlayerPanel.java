package view;

import javax.swing.*;

import model.GameEngineImpl;
import model.Player;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import view.CardGameHelperMethods;

@SuppressWarnings("serial")

public class RemovePlayerPanel extends JFrame {

	// instance variables
	private JLabel playerRemove = new JLabel("Player to Remove:"); // Label for playerID//
	private JButton submit = new JButton("Remove Player"); // button for submitting player information
	private JButton cancel = new JButton("Cancel"); // button cancelling and closing the screen

	private String[] playerNames;
	private String[] playerIds;
	private JComboBox<String> playersCombo;
	private Collection<Player> AllPlayers;

	public JComboBox<String> getplayersCombo() {
		return this.playersCombo;

	}

//	public String[] createPlayerIdList(Collection<Player> allPlayers) {
//		String[] playerNames = new String[allPlayers.size()];
//		int counter = 0;
//		for (Player player : allPlayers) {
//			playerNames[counter] = player.getId();
////			playerIds[counter] = player.getId();
//			counter += 1;
//			System.out.println(player.getId());
//		}
//
//		return playerNames;
//
//	}

	/**
	 * @param allPlayers the allPlayers to set
	 */
//	public void setAllPlayers(Collection<Player> allPlayers) {
//		AllPlayers = allPlayers;

//	}
	// this is called by GUI Callback when new player is added to the model
	// so that the new player is added to the string of arrays and is then seen on the screen
	public void addPlayerToCombo(String playerId) {
		this.playersCombo.addItem(playerId);
	}
	
	public void remPlayerFromCombo(String playerId) {
		this.playersCombo.removeItem(playerId);
	}

//	public void setComboBox(String[] playerNames) {
//
//		this.playerNames = playerNames;
//		this.playersCombo = new JComboBox<String>(playerNames);
//
//		this.repaint();
//	}

	// constructor for the panel
	public RemovePlayerPanel(GameEngineImpl theModel) {

		this.AllPlayers = theModel.getAllPlayers();
		this.playerNames = CardGameHelperMethods.createPlayerIdList(AllPlayers); // this populates the combo box

		this.playersCombo = new JComboBox<String>(playerNames);

//		JComboBox playersCombo = new JComboBox(playerNames);

		System.out.println("CardGameRemovePlayerPanel has been created");
		JPanel removePlayerPanel = new JPanel(); // create new jPanel which will get called when constructor is called
//		addPlayerPanel.setLayout(new GridLayout(2,2));
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // so it closes
		this.setSize(500, 75); // confused about the "this"

		removePlayerPanel.add(playersCombo); // add PlayerIDLabel
		removePlayerPanel.add(playerRemove); // add PlayerName Text Field

		removePlayerPanel.add(submit);
		removePlayerPanel.add(cancel);
//		submit.addActionListener(new SubmitNewPlayerButtonActionListener(this, engine)); // pass in the frame to the action lister

		this.setTitle("Remove Player");
		this.add(removePlayerPanel);

	}

	// think these are to get the data from the fields
//	public String getPlayerID() {
//
//		return playerID.getText();
//
//	}
//
//	public String getPlayername() {
//
//		return PlayerName.getText();
//
//	}
//
//	public int getPlayerPoints() {
//
//		return Integer.parseInt(PlayerPoints.getText());
//
//	}

	public void addSubmitRemoveListener(ActionListener SubmitRemPlayerButtonActionListener) {

		submit.addActionListener(SubmitRemPlayerButtonActionListener);
	}

	public void cancelButtonListener(ActionListener CloseButtonActionListener) {

		cancel.addActionListener(CloseButtonActionListener);
	}

	public void displayErrorMessage(String errorMessage) {

		JOptionPane.showMessageDialog(this, errorMessage);
	}

}
