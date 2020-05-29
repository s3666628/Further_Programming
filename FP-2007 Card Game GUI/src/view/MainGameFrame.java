package view;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.MatteBorder;

import model.GameEngine;
import model.GameEngineImpl;

@SuppressWarnings("serial")
public class MainGameFrame extends JFrame {

	private AddPlayerPanel addPlayerSubView;
	private RemovePlayerPanel removePlayerSubview;
	private CardGameToolBar toolbar;
	private TabbedPane tabbedPane;
	private AllPlayersTable allPlayersTable;
	private PlaceBetPanel thePlaceBetPanel;

	public MainGameFrame(GameEngineImpl theModel) {
		super("Card Game");// add title
		this.addPlayerSubView = new AddPlayerPanel(); // create the Add Player window so that it is part of the main
														// Frame
		this.removePlayerSubview = new RemovePlayerPanel(theModel);
		// comment out for now as not working as expected
		this.allPlayersTable = new AllPlayersTable(theModel);
		
		//create a new place bet panel
		this.thePlaceBetPanel = new PlaceBetPanel(theModel);

		this.setDefaultCloseOperation(EXIT_ON_CLOSE); // Determines what happens when press close buttons

		setLayout(new BorderLayout()); // don't need to call this if you want Flow which is default
		// do this last so that user doesn't see frame being built

		// creates a new panel
		JPanel playerPanel = new JPanel();
		// set layout for the new panel
		playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.PAGE_AXIS));
		// add components to the main
		// ADD TABBED PANE
		this.tabbedPane = new TabbedPane(this);
		playerPanel.add(tabbedPane);
//		playerPanel.add((this.tabbedPane = new CardGameTabbedPane(this)));

//		playerPanel.add((new HandPanel("Player")));
		playerPanel.add((new HandPanel("Dealer")));

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
		StatusBar statusBar = new StatusBar();
		this.add(statusBar, BorderLayout.SOUTH);
		this.add(playerPanel, BorderLayout.CENTER);
//		this.add(subview); // add subview to the main frame but won't be visible until addPlayer button is clicked on 
		// SET SIZE of Main Frame
		setSize(800, 1200);
//		pack(); 
		setVisible(true); // by default frame is not visible

	}

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

	public MainGameFrame getCardGameMainView() {
		return this;
	}
	
	public void doRePaintMain() {
		this.repaint();
	}

}
