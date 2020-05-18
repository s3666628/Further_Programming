package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.MatteBorder;

import model.GameEngine;

@SuppressWarnings("serial")
public class CardGameFrame extends JFrame {
	
	private CardGameAddPlayerPanel subView;
	private CardGameToolBar toolbar;

	public CardGameFrame() {

		
		
		super("Card Game");// add title
		this.subView = new CardGameAddPlayerPanel(); // create the Add Player window so that it is part of the main Frame
		; // comment out for now as not working as expected
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Determines what happens when press close buttons

		setLayout(new BorderLayout()); // don't need to call this if you want Flow which is default
		// do this last so that user doesn't see frame being built

		// creates a new panel
		JPanel playerPanel = new JPanel();
		// set layout for the new panel
		playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.PAGE_AXIS));
		// add components to the main
		playerPanel.add((new CardGameTabbedPane(this)));
		playerPanel.add((new CardGameHandPanel("Player")));
		playerPanel.add((new CardGameHandPanel("Dealer")));

		// // ADD MENU BAR
		this.add(new CardGameMenuBar(this), BorderLayout.PAGE_START);
		// add main game panel to the - might need one of these for each player added or

//		this.add(new CardGamePanel(), BorderLayout.CENTER); not sure what this is so commented out
		// add tool bar to the main frame

		// ADD TOOL BAR
		this.toolbar = new CardGameToolBar(JToolBar.VERTICAL, this);
		MatteBorder matteBorder = new MatteBorder(1, 1, 1, 1, Color.BLUE);
		this.toolbar.setBorder(matteBorder);
		this.toolbar.setOrientation(JToolBar.VERTICAL);
		this.add(toolbar, BorderLayout.WEST);
		// ADD STATUS BAR
		CardGameStatus statusBar = new CardGameStatus();
		this.add(statusBar, BorderLayout.SOUTH);
		this.add(playerPanel, BorderLayout.CENTER);
//		this.add(subview); // add subview to the main frame but won't be visible until addPlayer button is clicked on 
		// SET SIZE of Main Frame
		setSize(800, 1200);
//		pack(); 
		setVisible(true); // by default frame is not visible

	}

	public CardGameAddPlayerPanel getSubView() {
		return this.subView;
	}
	
	public CardGameToolBar getToolBar() {
		return this.toolbar;
	}
	
	
		
	
}
