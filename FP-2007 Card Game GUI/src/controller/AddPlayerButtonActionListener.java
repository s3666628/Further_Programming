package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameEngineImpl;
import view.AddPlayerPanel;
import view.MainGameFrame;

public class AddPlayerButtonActionListener implements ActionListener {

	private MainGameFrame theView;
	private GameEngineImpl theModel;

	public AddPlayerButtonActionListener(MainGameFrame theView, GameEngineImpl theModel) {
		this.theView = theView;
		this.theModel = theModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		CardGameAddPlayerPanel addNewPlayerDetails = new CardGameAddPlayerPanel();
		AddPlayerPanel subView = theView.getSubView();
		subView.setVisible(true);

		System.out.println("*****Add Player button has been clicked");

	}

}
