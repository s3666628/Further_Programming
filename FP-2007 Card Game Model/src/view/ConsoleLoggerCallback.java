package view;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.GameEngine;
import model.Player;
import model.bet.Bet;
import model.card.Card;
import model.card.Deck;
import model.card.Hand;

/**
 * An implementation of GameCallback which uses a Logger to log game events to
 * the console.
 * 
 * <p>
 * <b>Important!</b> DO NOT EDIT THE STATIC BLOCK THAT SETS UP THE LOGGER OR
 * IT'S DECLARATION!
 * 
 * <p>
 * <b>Note:</b> Logging message format should be consistent with the output
 * trace.
 * 
 * @author Ross Nye
 * 
 * @see view.GameCallback
 * @see view.GameCallbackCollection
 *
 */
public class ConsoleLoggerCallback implements GameCallback {
	public ConsoleLoggerCallback(GameEngine engine) {
// TODO Auto-generated constructor stub
	}

	/**
	 * A static {@link java.util.logging.Logger} object used for logging information
	 * (in this case to the console)
	 * 
	 * DO NOT EDIT!
	 */
	public static final Logger LOGGER;

	static {
// DO NOT EDIT THIS STATIC BLOCK!!

// Creating consoleHandler, add it and set the log levels.
		LOGGER = Logger.getLogger(ConsoleLoggerCallback.class.getName());
		LOGGER.setLevel(Level.FINER);
		ConsoleHandler handler = new ConsoleHandler();
		handler.setLevel(Level.FINER);
		LOGGER.addHandler(handler);
		LOGGER.setUseParentHandlers(false);
	}

	@Override
	public void addPlayer(Player player) {
// TODO hand is not displayed correctly on log output
		LOGGER.info("Added " + player.toString());

	}

	@Override
	public void removePlayer(Player player) {
// this should work
		LOGGER.info("Removed " + player.toString());

	}

	@Override
	public void betUpdated(Player player) {
// TODO Auto-generated method stub
// player.getBet();
		LOGGER.info("Bet updated for " + player.getName() + " to " + player.getBet());

	}

	@Override
	public void newDeck(Deck deck) {
// TODO Auto-generated method stub
		LOGGER.info(deck.toString());

	}

	@Override
	public void playerCard(Player player, Card card) {
// System.out.println("testing player Card");
		LOGGER.fine("Player " + player.getId() + " dealt " + card.toString());
// Player P2 dealt Ace of Clubs

	}

	@Override
	public void playerBust(Player player, Card card) {
		Hand playerHand = player.getHand();
		LOGGER.fine("Player " + player.getId() + " bust on " + card.toString());
		LOGGER.fine("Player " + player.getId() + " score is " + playerHand.getScore());
	}

	@Override
	public void houseCard(Hand houseHand, Card card) {
//	Hand playerHand = player.getHand();
//	LOGGER.fine("House " + player.getId() + " bust on " + card.toString());
//	LOGGER.fine("House Test Message");
	LOGGER.fine("House dealt " + card.toString());


	}

	@Override
	public void houseBust(Hand houseHand, Card card) {
// TODO Auto-generated method stub
		LOGGER.fine("House bust on " + card.toString());
//		House Hand: Hand of 2 cards [Queen of Clubs, King of Spades] Score: 20
		LOGGER.info("House Hand: Hand of "+houseHand.getNumberOfCards() +" cards " + houseHand.getCards() + " Score: " + houseHand.getScore());
		LOGGER.info("Final Results:");

		
//		Player id=P1, name=Player One, points=900, Score Bet for 100, Hand of 2 cards [Queen of Spades, 10 of Diamonds] Score: 20

	}

}