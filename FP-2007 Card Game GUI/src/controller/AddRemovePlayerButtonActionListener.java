package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.GameEngineImpl;
import view.AddPlayerPanel;
import view.AllPlayersTable;
import view.xxxMainGameFrame;
import view.PlaceBetPanel;
import view.RemovePlayerPanel;

public class AddRemovePlayerButtonActionListener implements ActionListener {

	private xxxMainGameFrame theView;
	private GameEngineImpl theModel;
	private int buttonNumber;

	public AddRemovePlayerButtonActionListener(xxxMainGameFrame theView, GameEngineImpl theModel, int buttonNumber) {
		this.theView = theView;
		this.theModel = theModel;
		this.buttonNumber = buttonNumber;
	}
	

	public int getButtonNumber() {
		return buttonNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		CardGameAddPlayerPanel addNewPlayerDetails = new CardGameAddPlayerPanel();
		if (getButtonNumber() ==1) {
		AddPlayerPanel addPlayerSubView = theView.getAddPlayerSubView();
		addPlayerSubView.setVisible(true);


		System.out.println("*****Add Player button has been clicked");
		}
		
		if (getButtonNumber() ==2) {
		RemovePlayerPanel remPlayerSubView = theView.getRemovePlayerPanel();

		remPlayerSubView.repaint();
		remPlayerSubView.setVisible(true);

		System.out.println("*****Remove Player button has been clicked");

		}
		
		if (getButtonNumber() ==3) {
		AllPlayersTable allPlayerSubView = new AllPlayersTable(theModel);
		allPlayerSubView.repaint();
		allPlayerSubView.setVisible(true);

		System.out.println("*****VIEW ALL Player button has been clicked");

		}
		
		if (getButtonNumber() ==4) {
		PlaceBetPanel placeBetPanel =theView.getPlaceBetPanel();
		placeBetPanel.repaint();
		placeBetPanel.setVisible(true);

		System.out.println("zzzPlaceBet button has been clicked");

		}
	}

}
