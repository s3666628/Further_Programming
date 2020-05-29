package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.MatteBorder;

import model.GameEngine;
import model.GameEngineImpl;

@SuppressWarnings("serial")
public class xxxMainGameFrame extends JFrame {

	private AddPlayerPanel addPlayerSubView;
	private RemovePlayerPanel removePlayerSubview;
	private CardGameToolBar toolbar;
	private TabbedPane tabbedPane;
	private AllPlayersTable allPlayersTable;
	private PlaceBetPanel thePlaceBetPanel;
	private StatusBar statusBar ;
	private CardGameMenuBar menuBar;
	
	public xxxMainGameFrame(GameEngineImpl theModel) {
		
		// set title for main frame
		super("Card Game");
		
		// Create New Components that we need
		// Sub components that are not visible all of the time
		this.addPlayerSubView = new AddPlayerPanel();
		this.removePlayerSubview = new RemovePlayerPanel(theModel);
		this.allPlayersTable = new AllPlayersTable(theModel);		
		this.thePlaceBetPanel = new PlaceBetPanel(theModel);
		// main components
		// WEST
		this.toolbar = new CardGameToolBar(JToolBar.VERTICAL, this);	
		MatteBorder matteBorder = new MatteBorder(1, 1, 1, 1, Color.BLUE);
		this.toolbar.setBorder(matteBorder);
		this.toolbar.setOrientation(JToolBar.VERTICAL);
		//SOUTH
		this.statusBar = new StatusBar();		
		//NORTH
		this.menuBar = new CardGameMenuBar(this);
		// Tabbed Pane
		this.tabbedPane = new TabbedPane(this);
		
		

		// comment out for now as not working as expected




		
		// do this last so that user doesn't see frame being built

		// creates a new panel
//		JPanel playerPanel = new JPanel();
		
		Box theBox = Box.createVerticalBox();

//		playerPanel.add((this.tabbedPane = new CardGameTabbedPane(this)));
		
//		theBox.add((new HandPanel("Player")));
		theBox.add(tabbedPane);
//		theBox.add((new HandPanel("Dealer")));
		
		
		// set layout for the new panel
//		playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.PAGE_AXIS));
		// add components to the main
		// ADD TABBED PANE

//		playerPanel.add(tabbedPane);
//		playerPanel.add((this.tabbedPane = new CardGameTabbedPane(this)));

//		playerPanel.add((new HandPanel("Player")));
//		playerPanel.add((new HandPanel("Dealer")));

		// // ADD MENU BAR

		// add main game panel to the - might need one of these for each player added or

//		this.add(new CardGamePanel(), BorderLayout.CENTER); not sure what this is so commented out
		// add tool bar to the main frame

		// ADD TOOL BAR
		
		this.add(menuBar, BorderLayout.NORTH);
		this.add(toolbar, BorderLayout.WEST);
		this.add(statusBar, BorderLayout.SOUTH);
		this.add(theBox, BorderLayout.CENTER);
//		this.add(theBox);
		
//		this.add(playerPanel, BorderLayout.CENTER);
//		this.add(subview); // add subview to the main frame but won't be visible until addPlayer button is clicked on 
		// SET SIZE of Main Frame
		
		// Settings for the Main Frame
// don't need to call this if you want Flow which is default
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		pack();
		setSize(screenSize.width/3,screenSize.height/2);
//		this.setSize(800, 1200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Determines what happens when press close buttons
		this.setVisible(true); // by default frame is not visible

	}
	// Getters for the main frame and attached components

	public AddPlayerPanel getAddPlayerSubView() {
		return this.addPlayerSubView;

	}

	public RemovePlayerPanel getRemovePlayerPanel() {
		return this.removePlayerSubview;
	}

	public CardGameToolBar getToolBar() {
		return this.toolbar;
	}

	public TabbedPane getTabbedPane() {
		return this.tabbedPane;
	}
	
	public AllPlayersTable getAllPlayersTable() {
		return this.allPlayersTable;
	}
	public PlaceBetPanel getPlaceBetPanel() {
		return this.thePlaceBetPanel;
	}

	public xxxMainGameFrame getCardGameMainView() {
		return this;
	}
	
	public void doRePaintMain() {
		this.repaint();
	}

}