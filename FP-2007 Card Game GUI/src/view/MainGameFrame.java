package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.border.MatteBorder;

import model.GameEngineImpl;

@SuppressWarnings("serial")
public class MainGameFrame extends JFrame {

	private AddPlayerPanel addPlayerSubView;
	private RemovePlayerPanel removePlayerSubview;
	private CardGameToolBar toolbar;
	private TabbedPane tabbedPane;
	private AllPlayersTable allPlayersTable;
	private PlaceBetPanel thePlaceBetPanel;
	private StatusBar statusBar ;
	private CardGameMenuBar menuBar;
	private JPanel dealerPanel;
	
	public MainGameFrame(GameEngineImpl theModel) {
		
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
		this.statusBar = new StatusBar("status1", "status2");		
		//NORTH
		this.menuBar = new CardGameMenuBar(this);
		// Tabbed Pane
		this.tabbedPane = new TabbedPane(this);
		
		

		// comment out for now as not working as expected




		
		// do this last so that user doesn't see frame being built

		// creates a new panel
		this.dealerPanel = new JPanel();		
		Box theBox = Box.createVerticalBox();
		theBox.add(tabbedPane);


		// ADD TOOL BAR
		
		this.add(menuBar, BorderLayout.NORTH);
		this.add(toolbar, BorderLayout.WEST);
		this.add(statusBar, BorderLayout.SOUTH);
		theBox.add(dealerPanel);
		this.add(theBox, BorderLayout.CENTER);
		
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
	
	public JPanel getDealerPane() {
		return this.dealerPanel;

	}
	


	public RemovePlayerPanel getRemovePlayerPanel() {
		return this.removePlayerSubview;
	}

	public CardGameToolBar getToolBar() {
		return this.toolbar;
	}
	
	public CardGameMenuBar getCardGameMenuBar() {
		return this.menuBar;
	}

	public TabbedPane getTabbedPane() {
		return this.tabbedPane;
	}
	public StatusBar getStatusBar() {
		return this.statusBar;
	} ;
	
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
