package view;

import javax.swing.*;

import model.GameEngineImpl;

import java.awt.event.ActionListener;

@SuppressWarnings("serial")

public class RemovePlayerPanel extends JFrame {

	// instance variables
	private JLabel playerIDLabel = new JLabel("PlayerID:"); // Label for playerID
	private JTextField playerID = new JTextField(10); // text field for playerID

	private JLabel playerNameLabel = new JLabel("PlayerName:"); // Label for PlayerName
	private JTextField PlayerName = new JTextField(10); // text field for PlayerName

	private JLabel playerPointsLabel = new JLabel("PlayerPoints:"); // Label for PlayerName
	private JTextField PlayerPoints = new JTextField(10); // text field for PlayerName

	private JButton submit = new JButton("Remove Player"); // button for submitting player information
	private JButton cancel = new JButton("Cancel"); // button cancelling and closing the screen

	// constructor for the panel
	public RemovePlayerPanel(GameEngineImpl theModel) {
		System.out.println("CardGameRemovePlayerPanel has been created");
		JPanel removePlayerPanel = new JPanel(); // create new jPanel which will get called when constructor is called
//		addPlayerPanel.setLayout(new GridLayout(2,2));
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); // so it closes
		this.setSize(900, 75); // confused about the "this"

		removePlayerPanel.add(playerIDLabel); // add PlayerIDLabel
		removePlayerPanel.add(playerID); // addPlayerID Text Field
		removePlayerPanel.add(playerNameLabel); // add PlayerName label
		removePlayerPanel.add(PlayerName); // add PlayerName Text Field
		removePlayerPanel.add(playerPointsLabel); // add PlayerName label
		removePlayerPanel.add(PlayerPoints); // add PlayerName Text Field

		removePlayerPanel.add(submit);
		removePlayerPanel.add(cancel);
//		submit.addActionListener(new SubmitNewPlayerButtonActionListener(this, engine)); // pass in the frame to the action lister

		this.setTitle("Remove Player");
		this.add(removePlayerPanel);

	}

	// think these are to get the data from the fields
	public String getPlayerID() {

		return playerID.getText();

	}

	public String getPlayername() {

		return PlayerName.getText();

	}

	public int getPlayerPoints() {

		return Integer.parseInt(PlayerPoints.getText());

	}

	public void addSubmitListener(ActionListener SubmitNewPLayerButtonActionListener) {

		submit.addActionListener(SubmitNewPLayerButtonActionListener);
	}
	
	public void cancelButtonListener(ActionListener CloseButtonActionListener) {

		cancel.addActionListener(CloseButtonActionListener);
	}

	public void displayErrorMessage(String errorMessage) {

		JOptionPane.showMessageDialog(this, errorMessage);
	}

}
