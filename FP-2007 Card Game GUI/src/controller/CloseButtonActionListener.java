package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import view.AddPlayerPanel;
import view.AllPlayersTable;
import view.MainGameFrame;
import view.PlaceBetPanel;
import view.RemovePlayerPanel;

public class CloseButtonActionListener implements ActionListener {

	private JDialog dialog;
	private MainGameFrame theView;
	private int closeOption;

	public CloseButtonActionListener(JDialog theDialog, MainGameFrame theView, int closeOption)

	{
		this.dialog = theDialog;
		this.theView = theView;
		this.closeOption = closeOption;

	}

	public CloseButtonActionListener(MainGameFrame theView, int closeOption)

	{
		this.theView = theView;
		this.closeOption = closeOption;

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if (closeOption == 1) {
			dialog.setVisible(false);
			System.out.println("Close button has been clicked");
		}
		if (closeOption == 2) {
			AddPlayerPanel subView = theView.getAddPlayerSubView();
			subView.setVisible(false);
			System.out.println("*****Add Player button has been clicked");
			System.out.println("Close button has been clicked");
		}
		if (closeOption == 3) {
			RemovePlayerPanel subView = theView.getRemovePlayerPanel();
			subView.setVisible(false);
			System.out.println("*****Remove Player cancel button has been clicked");
			System.out.println("Close button has been clicked");
		}
		if (closeOption == 4) {
			AllPlayersTable subView = theView.getAllPlayersTable();
			subView.setVisible(false);
			System.out.println("*****View All Player Close button has been clicked");
			System.out.println("Close button has been clicked");
		}
		if (closeOption == 5) {
			PlaceBetPanel subView = theView.getPlaceBetPanel();
			subView.setVisible(false);
			System.out.println("*****View All Player Close button has been clicked");
			System.out.println("Close button has been clicked");
		}

	}

}
