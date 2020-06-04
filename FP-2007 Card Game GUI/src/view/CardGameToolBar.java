package view;

import java.awt.Color;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JToggleButton;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;

import model.ComponentNames;

@SuppressWarnings("serial")

public class CardGameToolBar extends JToolBar {

	private AbstractButton addPlayerButton;
	private AbstractButton removePlayerButton;
	private AbstractButton viewAllPlayersButton;
	private AbstractButton placeBetButton;
	private AbstractButton dealCards; 

	CardGameToolBar(int vertical, MainGameFrame cardGameFrame) {

		ButtonGroup toolButtonsGroup = new ButtonGroup(); // create new group for buttons in the tool bar

		this.addPlayerButton = new JToggleButton(
				CardGameHelperMethods.resizeImageIcon(ComponentNames.ADDPLAYER.getImageIcon(), 130, 35));
		add(addPlayerButton);
		toolButtonsGroup.add(addPlayerButton);
		addPlayerButton.setBorder(new LineBorder(Color.LIGHT_GRAY)); // put a border around it

		this.removePlayerButton = new JToggleButton(
				CardGameHelperMethods.resizeImageIcon(ComponentNames.REMOVE_PLAYER.getImageIcon(), 130, 35));
		add(removePlayerButton);
		toolButtonsGroup.add(removePlayerButton);
		removePlayerButton.setBorder(new LineBorder(Color.LIGHT_GRAY)); // put a border around it
		
		this.viewAllPlayersButton = new JToggleButton(
				CardGameHelperMethods.resizeImageIcon(ComponentNames.DISPLAY_ALL_PLAYER.getImageIcon(), 130, 35));
		add(viewAllPlayersButton);
		toolButtonsGroup.add(viewAllPlayersButton);
		viewAllPlayersButton.setBorder(new LineBorder(Color.LIGHT_GRAY)); // put a border around it
		
		this.placeBetButton = new JToggleButton(
				CardGameHelperMethods.resizeImageIcon(ComponentNames.PLACE_BET.getImageIcon(), 130, 35));
		add(placeBetButton);
		toolButtonsGroup.add(placeBetButton);
		placeBetButton.setBorder(new LineBorder(Color.LIGHT_GRAY)); // put a border around it

		
		this.dealCards = new JToggleButton(
				CardGameHelperMethods.resizeImageIcon(ComponentNames.AUTO_DEAL.getImageIcon(), 130, 35));
		add(dealCards);
		toolButtonsGroup.add(dealCards);
		dealCards.setBorder(new LineBorder(Color.LIGHT_GRAY)); // put a border around it
		

	}

	// methods for attaching action listeners to the various buttons

	public void addPlayerListerner(ActionListener AddRemovePlayerButtonActionListener) {

		addPlayerButton.addActionListener(AddRemovePlayerButtonActionListener);

	}

	public void remPlayerListerner(ActionListener AddRemovePlayerButtonActionListener) {

		removePlayerButton.addActionListener(AddRemovePlayerButtonActionListener);
	}
	
	public void viewAllPlayerActionListener (ActionListener AddRemovePlayerButtonActionListener) {

		viewAllPlayersButton.addActionListener(AddRemovePlayerButtonActionListener);
	}
	
	public void placeBetActionListener (ActionListener AddRemovePlayerButtonActionListener) {

		placeBetButton.addActionListener(AddRemovePlayerButtonActionListener);
	}
	
	public void autoDealActionListener (ActionListener AutoDealButtonActionListener) {

		dealCards.addActionListener(AutoDealButtonActionListener);
	}

}
