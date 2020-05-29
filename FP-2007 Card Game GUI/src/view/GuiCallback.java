package view;

import model.GameEngine;
import model.GameEngineImpl;
import model.Player;
import model.card.Card;
import model.card.Deck;
import model.card.Hand;
import view.xxxMainGameFrame;

public class GuiCallback implements GameCallback {

	private xxxMainGameFrame theFrame;
	private GameEngine theEngine;

	public GuiCallback(GameEngine engine, xxxMainGameFrame theFrame) {
		// TODO Auto-generated constructor stub
		this.theFrame = theFrame;
		this.theEngine = engine;
	}

	@Override
	public void addPlayer(Player player) {
		// get the GUI elements we want to update
		TabbedPane theTabbedPane = theFrame.getTabbedPane();
		RemovePlayerPanel theRemovePlayerPanel = theFrame.getRemovePlayerPanel();
		PlaceBetPanel thePlaceBetPanel = theFrame.getPlaceBetPanel();
//		AllPlayersTable theAllPlayersTable = theFrame.getAllPlayersTable();
		// call the methods in the GUI
		theTabbedPane.addNewPlayerToTabbedFrame(player);
		theRemovePlayerPanel.addPlayerToCombo(player.getId());
		thePlaceBetPanel.addPlayerToCombo(player.getId());
//		theAllPlayersTable.updateAllPlayersTable((GameEngineImpl) theEngine);
		

	}

	@Override
	public void removePlayer(Player player) {
		RemovePlayerPanel theRemovePlayerPanel = theFrame.getRemovePlayerPanel();
		TabbedPane theTabbedPane = theFrame.getTabbedPane();
		PlaceBetPanel thePlaceBetPanel = theFrame.getPlaceBetPanel();
		theRemovePlayerPanel.remPlayerFromCombo(player.getId());
		theTabbedPane.removePlayerFromTabbedFrame(player);// remove the tabbed pane for this player
		thePlaceBetPanel.remPlayerFromCombo(player.getId());
		

	}

	@Override
	public void betUpdated(Player player) {
		// TODO Auto-generated method stub
		TabbedPane theTabbedPane = theFrame.getTabbedPane();
		System.out.println("GUI Callback Bet Updated");
		theTabbedPane.refreshTabbedPane(player);

	}

	@Override
	public void newDeck(Deck deck) {
		// TODO Auto-generated method stub

	}

	@Override
	public void playerCard(Player player, Card card) {
		System.out.println("Player+"+player.getName() + card.toString()+"dealt");

	}

	@Override
	public void playerBust(Player player, Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void houseCard(Hand houseHand, Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void houseBust(Hand houseHand, Card card) {
		// TODO Auto-generated method stub

	}

}
