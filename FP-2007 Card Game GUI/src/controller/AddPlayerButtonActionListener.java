package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameEngineImpl;
import view.CardGameAddPlayerPanel;
import view.CardGameFrame;

public class AddPlayerButtonActionListener implements ActionListener {

	private CardGameFrame theView;
	private GameEngineImpl theModel;

	public AddPlayerButtonActionListener(CardGameFrame theView, GameEngineImpl theModel) {
		this.theView = theView;
		this.theModel = theModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		CardGameAddPlayerPanel addNewPlayerDetails = new CardGameAddPlayerPanel();
		CardGameAddPlayerPanel subView = theView.getSubView();
		subView.setVisible(true);

		System.out.println("*****Add Player button has been clicked");

	}

}
