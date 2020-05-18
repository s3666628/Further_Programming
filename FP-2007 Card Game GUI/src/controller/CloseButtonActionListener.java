package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import view.CardGameAddPlayerPanel;

public class CloseButtonActionListener implements ActionListener {
	
	
	private JDialog dialog;
	
	public CloseButtonActionListener(JDialog theDialog) 
	
	{
		this.dialog = theDialog;
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		dialog.setVisible(false);
		System.out.println("Close button has been clicked");
		
		
		
	}

}
