package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import model.GameEngineImpl;
import view.AddPlayerPanel;
import view.AllPlayersTable;
import view.MainGameFrame;
import view.PlaceBetPanel;
import view.RemovePlayerPanel;

public class AddRemovePlayerButtonActionListener implements ActionListener {

	private MainGameFrame theView;
	private GameEngineImpl theModel;
	private int buttonNumber;

	public AddRemovePlayerButtonActionListener(MainGameFrame theView, GameEngineImpl theModel, int buttonNumber) {
		this.theView = theView;
		this.theModel = theModel;
		this.buttonNumber = buttonNumber;
	}

	public int getButtonNumber() {
		return buttonNumber;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		new Thread() {
			@Override
			public void run() {

//		CardGameAddPlayerPanel addNewPlayerDetails = new CardGameAddPlayerPanel();
				if (getButtonNumber() == 1) {
					AddPlayerPanel addPlayerSubView = theView.getAddPlayerSubView();
					addPlayerSubView.setVisible(true);

					System.out.println("*****Add Player button has been clicked");
				}

				if (getButtonNumber() == 2) {
					RemovePlayerPanel remPlayerSubView = theView.getRemovePlayerPanel();

					remPlayerSubView.repaint();
					remPlayerSubView.setVisible(true);

					System.out.println("*****Remove Player button has been clicked");

				}

				if (getButtonNumber() == 3) {
					AllPlayersTable allPlayerSubView = new AllPlayersTable(theModel);
					allPlayerSubView.repaint();
					allPlayerSubView.setVisible(true);

					System.out.println("*****VIEW ALL Player button has been clicked");

				}

				if (getButtonNumber() == 4) {
					PlaceBetPanel placeBetPanel = theView.getPlaceBetPanel();
					placeBetPanel.repaint();
					placeBetPanel.setVisible(true);

					System.out.println("zzzPlaceBet button has been clicked");

				}
			}
		}.start();
	}

}
