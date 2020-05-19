package view;

import model.GameEngine;
import model.Player;
import model.card.Card;
import model.card.Deck;
import model.card.Hand;
import view.MainGameFrame;


public class GuiCallback  implements GameCallback {
	
	private MainGameFrame theFrame;
	

	public GuiCallback(GameEngine engine, MainGameFrame theFrame) {
		// TODO Auto-generated constructor stub
		this.theFrame = theFrame;
	}
	
	
	

	@Override
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub
		TabbedPane theTabbedPane = theFrame.getTabbedPane();
		theTabbedPane.addNewPlayerToTabbedFrame(player);
		
	}

	@Override
	public void removePlayer(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void betUpdated(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void newDeck(Deck deck) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void playerCard(Player player, Card card) {
		// TODO Auto-generated method stub
		
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
