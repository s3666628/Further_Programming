package controller;

import view.AddPlayerPanel;
import view.AllPlayersTable;
import view.CardGameMenuBar;
import view.MainGameFrame;
import view.PlaceBetPanel;
import view.RemovePlayerPanel;
import view.CardGameToolBar;
import model.GameEngineImpl;

public class CardGameController {
	// instance variables
	private MainGameFrame theView;
	private GameEngineImpl theModel;
	private CardGameToolBar theToolBar;
	private AddPlayerPanel addPlayerSubView;
	private RemovePlayerPanel remPlayerSubView;
	private AllPlayersTable allPlayerSubView;
	private PlaceBetPanel thePlaceBetPanel;
	private CardGameMenuBar theMenuBar;
	private int addPlayerNum = 1;
	private int remPlayerNum = 2;
	private int vwAllPlyrNum = 3;
	private int placeBetNum = 4;

	// Constructor which takes Model and View
	public CardGameController(MainGameFrame theView, GameEngineImpl theModel) {
		this.theView = theView; // assigns what is passed in to the instance variables
		this.theModel = theModel;
		this.theToolBar = theView.getToolBar();
		this.addPlayerSubView = theView.getAddPlayerSubView();
		this.remPlayerSubView = theView.getRemovePlayerPanel();
		this.allPlayerSubView = theView.getAllPlayersTable();
		this.thePlaceBetPanel = theView.getPlaceBetPanel();
		this.theMenuBar = theView.getCardGameMenuBar();
		
		// Add Tool Bar Listeners
		theToolBar.addPlayerListerner(new AddRemovePlayerButtonActionListener(theView, theModel, addPlayerNum));
		theToolBar.remPlayerListerner(new AddRemovePlayerButtonActionListener(theView, theModel, remPlayerNum));
		theToolBar.viewAllPlayerActionListener(
				new AddRemovePlayerButtonActionListener(theView, theModel, vwAllPlyrNum));
		theToolBar.placeBetActionListener(new AddRemovePlayerButtonActionListener(theView, theModel, placeBetNum));
		theToolBar.autoDealActionListener(new AutoDealActionListener(theView, theModel));
		
		// add Menu Bar listeners
		
		// Add Tool Bar Listeners
		theMenuBar.addPlayerListerner(new AddRemovePlayerButtonActionListener(theView, theModel, addPlayerNum));
		theMenuBar.remPlayerListerner(new AddRemovePlayerButtonActionListener(theView, theModel, remPlayerNum));
		theMenuBar.viewAllPlayerActionListener(
				new AddRemovePlayerButtonActionListener(theView, theModel, vwAllPlyrNum));
		theMenuBar.placeBetActionListener(new AddRemovePlayerButtonActionListener(theView, theModel, placeBetNum));
		theMenuBar.autoDealActionListener(new AutoDealActionListener(theView, theModel));
		// adds action listener to the view
//		theToolBar.addRemPlayerListerner(new RemovePlayerButtonActionListener(theView, theModel)); 

		// add player sub window - for Submit button this calls the listeners that affect the game
		addPlayerSubView.addSubmitListener(new SubmitNewPlayerButtonActionListener(theView, theModel));
		remPlayerSubView.addSubmitRemoveListener(new SubmitRemPlayerButtonActionListener(theView, theModel));
		thePlaceBetPanel.addSubmitBetListener(new SubmitBetButtonActionListener(theView, theModel));
		
		// Close Button Listeners
		addPlayerSubView.cancelButtonListener(new CloseButtonActionListener(theView, 2));
		remPlayerSubView.cancelButtonListener(new CloseButtonActionListener(theView, 3));
		allPlayerSubView.cancelButtonListener(new CloseButtonActionListener(theView, 4));
		thePlaceBetPanel.cancelButtonListener(new CloseButtonActionListener(theView, 5));

	}


}