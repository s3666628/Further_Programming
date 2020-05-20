package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameEngineImpl;
import view.AddPlayerPanel;
import view.MainGameFrame;

public class RemovePlayerButtonActionListener implements ActionListener {

	private MainGameFrame theView;
	private GameEngineImpl theModel;

	public RemovePlayerButtonActionListener(MainGameFrame theView, GameEngineImpl theModel) {
		this.theView = theView;
		this.theModel = theModel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

//		CardGameAddPlayerPanel addNewPlayerDetails = new CardGameAddPlayerPanel();
//		addNewPlayerDetails.setVisible(true);

		System.out.println("////////////Remove Player button has been clicked");

	}

}

//}
