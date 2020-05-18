package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import view.CardGameAddPlayerPanel;
import view.CardGameFrame;

public class CloseButtonActionListener implements ActionListener {
	
	
	private JDialog dialog;
	private CardGameFrame theView;
	private int closeOption;
	
	public CloseButtonActionListener(JDialog theDialog, CardGameFrame theView, int closeOption) 
	
	{
		this.dialog = theDialog;
		this.theView = theView;
		this.closeOption = closeOption;
		
		
	}
	
	public CloseButtonActionListener(CardGameFrame theView, int closeOption) 
	
	{
		this.theView = theView;
		this.closeOption = closeOption;
		
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (closeOption ==1) {
			dialog.setVisible(false);
			System.out.println("Close button has been clicked");
		}
		if (closeOption ==2) {
			CardGameAddPlayerPanel subView = theView.getSubView();
			subView.setVisible(false);
			System.out.println("*****Add Player button has been clicked");
			System.out.println("Close button has been clicked");
		}

		
		
	}

}
