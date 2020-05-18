package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.security.auth.callback.Callback;

import model.card.Card;
import model.card.Deck;
import model.card.DeckImpl;
import model.card.Hand;
import model.card.HandImpl;
import model.card.Suit;
import view.GameCallback;
import view.GameCallbackCollection;
import model.bet.Bet;
import model.bet.BetResult;
import model.bet.ScoreBetImpl;
import model.bet.SuitBetImpl;

public class GameEngineImpl implements GameEngine, GameCallbackCollection {

	// hashmap for storing players (key = playerID, value = player object)

	HashMap<String, Player> players = new HashMap<String, Player>();
	
	static // collection for the callback logger
	List<GameCallback> callBackList = new ArrayList<>();

	// this should give us a shuffled deck of cards - will be used to deal cards to
	// the player
	Deck mydeck = DeckImpl.createShuffledDeck();
	// need this for the sleep function
	Thread thread;

	private static int NumberOfDeckMessage = 0;

	// could not run for loop inside other bit of code but works if add it to method
	// and then call method
	private static void callBackPlayerCard(Player player, Card card) {
		// run the callback for Player Card
		for (GameCallback cb : callBackList) {
			cb.playerCard(player, card); // log the card
		}

	}

//	playerBust(currentPlayer, bustCard)

	private static void callBackplayerBust(Player player, Card bustcard) {
		// run the callback for Player Card
		for (GameCallback cb : callBackList) {
			cb.playerBust(player, bustcard); // log the card
		}
	}

//	callback.houseCard(houseHand, nextCard);

	private static void callBackHouseCard(Hand houseHand, Card nextCard) {
		// run the callback for Player Card
		for (GameCallback cb : callBackList) {
			cb.houseCard(houseHand, nextCard); // log the card
		}
	}

//	callback.houseBust(houseHand, bustCard);

	private static void callBackHouseBust(Hand houseHand, Card bustCard) {
		// run the callback for Player Card
		for (GameCallback cb : callBackList) {
			cb.houseBust(houseHand, bustCard); // log the card
		}
	}
	
//	callback.newDeck(mydeck)
	
	private static void callBackNewDeck(Deck deck) {
		// run the callback for Player Card
		for (GameCallback cb : callBackList) {
			cb.newDeck(deck); // log the card
		}
	}

//	private GameCallback getCallBack() {
//		GameCallback callback = callBackList.get(0);
//		return callback;
//	}

	// no argument constructor
	public GameEngineImpl() {
	}

	@Override
	public void registerCallback(GameCallback callback) {
		// callback - the GameCallback to be added to the collection.
		callBackList.add(callback);

	}

	@Override
	public void removeCallback(GameCallback callback) {
//		Removes supplied GameCallback from the collection of registered callbacks.
		callBackList.remove(callback);

	}

	@Override
	public void addPlayer(Player player) throws NullPointerException, IllegalArgumentException {
		
		if (player == null) {
			throw new NullPointerException("Player ID cannot be Null");
		}
		if (player.getId().isEmpty()) {
			throw new IllegalArgumentException("Player ID has not been populated");
		}
		

		players.put(player.getId(), player); // add player to the collect of players

		// notify everyone that player has been added
		for (GameCallback cb : callBackList) {
			cb.addPlayer(player);

		}
	}

	@Override
	public void removePlayer(String playerId) throws NullPointerException, IllegalArgumentException {
		
		if (playerId == null) {
			throw new NullPointerException("Player ID cannot be Null");
		}
		if (playerId.isEmpty()) {
			throw new IllegalArgumentException("Player ID has not been populated");
		}
		
		// this should work - removes playerId that is passed in from the hash map
		Player player = players.get(playerId);// get player object from array via playerId string
//		GameCallback callback = getCallBack();
		// NB: make sure log removing player before removing player otherwise it won't
//		callback.removePlayer(player);

		for (GameCallback cb : callBackList) {
			cb.removePlayer(player);

		}
		// remove the player

		players.remove(playerId);

	}

	@Override
	public Collection<Player> getAllPlayers() {
		// TODO this has not been worked out properly
//		Collection<Player> allPlayers = (Collection<Player>) players.clone();
		
		HashMap<String, Player>clonedMapOfPlayers = (HashMap<String, Player>) players.clone(); 
		return (Collection<Player>) clonedMapOfPlayers;
	}

	@Override
	public void placeBet(String playerId, int amount) throws NullPointerException, IllegalArgumentException {
		// this will create a new score bet
		
		if (playerId == null) {
			throw new NullPointerException("Player ID cannot be Null");
		}
		if (playerId.isEmpty()) {
			throw new IllegalArgumentException("Player ID has not been populated");
		}
		if (amount < 0) {
			throw new IllegalArgumentException("Bet Amount cannot be negative");
		}

		Player player = players.get(playerId);
		ScoreBetImpl Scorebet = new ScoreBetImpl(players.get(playerId), amount);
		player.assignBet(Scorebet);

		for (GameCallback cb : callBackList) {
			cb.betUpdated(player);

		}

	}

	@Override
	public void placeBet(String playerId, int amount, Suit suit) throws NullPointerException, IllegalArgumentException {
		
		
				
		// null pointer exceptions
		if (playerId == null) {
			throw new NullPointerException("Player ID cannot be Null");
		}
		if (suit == null) {
			throw new NullPointerException("Suit cannot be Null");
		}
		
		// illegal argument exceptions
		
		if (playerId.isEmpty()) {
			throw new IllegalArgumentException("Player ID has not been populated");
		}
				
		if (!players.containsKey(playerId)) { // if player is not in the list
			throw new IllegalArgumentException(String.format ("Player ID: %s does not exist", playerId));
		}
		if (amount < 0) {
			throw new IllegalArgumentException("Bet Amount cannot be negative");
		}
		if (players.get(playerId).getPoints() < amount ) {
			throw new IllegalArgumentException(String.format ("Player ID: %s has placed bet for Bet Amount: %d which is greater than number of points %d", playerId, amount, players.get(playerId).getPoints()));
		}
		
		//TODO Add another Exception 
		//From Java Docs: if, when replacing an existing bet, the bet amount is not greater the existing bet 
		
		// this will create a new suit bet
		Player player = players.get(playerId);
		SuitBetImpl Suitbet = new SuitBetImpl(players.get(playerId), amount, suit);
		player.assignBet(Suitbet);
//		GameCallback callback = getCallBack();
//		callback.betUpdated(player);
		for (GameCallback cb : callBackList) {
			cb.betUpdated(player);

		}

	}

	public void dealPlayer(String playerId, int delay)
			throws NullPointerException, IllegalArgumentException, IllegalStateException {
		
		Player currentPlayer = players.get(playerId); // get player object
		
		if (playerId == null) {
			throw new NullPointerException("Player ID cannot be Null");
		}
		
		if (!players.containsKey(playerId)) { // if player is not in the list
			throw new IllegalArgumentException(String.format ("Player ID: %s does not exist", playerId));
		}
		
		if (delay < 0) {
			throw new IllegalArgumentException(String.format ("Delay: %d is not greater than zero please enter a positive number for the delay", delay));
		}
		
//		if the player with the supplied playerId has not placed a bet 
		if (currentPlayer.getBet() == Bet.NO_BET)

		{
			throw new IllegalStateException("Player has not place a bet - you must place bet before cards can be dealt");
			
		}
		//TODO not sure how to implement this - if it's by card dealt or by whether player has a hand or not.
		
//		if ((currentPlayer.getHand() == null))
//
//		{
//			throw new IllegalStateException(String.format ("Player ID : %s has already been dealt cards so cannot be dealt again", playerId));
//		}


//		GameCallback callback = getCallBack(); // create callback object
		if (NumberOfDeckMessage == 0) { // we only want to call the new deck logging method once when first player is
										// dealt hand
//			callback.newDeck(mydeck); // log the new deck
			callBackNewDeck(mydeck);
			NumberOfDeckMessage += 1;
		}

		Card bustCard = null; // need this to know which card player went bust on
//		// 2 get a hand for the current player
		Hand currentPlayerHand = currentPlayer.getHand();
		int loopCheck = 0;
		// 3 check the score of the hand
		int bustScore = 21;
		// if card does not bust player
		while (loopCheck <= bustScore && loopCheck == 0) {

			// see what the next card is
			Card nextCard = mydeck.removeNextCard();
			// these are to hold some values
			int valueOfNextCard = nextCard.getValue();
			int valueOfScore = currentPlayerHand.getScore();
			int potentialScore = valueOfNextCard + valueOfScore;
			// check if next card will bust player or not
			if (potentialScore >= bustScore) {
				// if next card will bust player then update loop check to 1 to stop running
				bustCard = nextCard;
				// get the score for the current hand
				currentPlayerHand.getScore();
				loopCheck = 1;
			} else {
				try { // sleep to add delay when cards being dealt - reference - this code was copied
						// from https://www.tutorialspoint.com/java/lang/thread_sleep_millis.htm
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				currentPlayerHand.dealCard(nextCard);// add next card to players hand
//				callback.playerCard(currentPlayer, nextCard); // this can be removed as called via function which updates all callbacks
				callBackPlayerCard(currentPlayer, nextCard);
			}

		}

//		callback.playerBust(currentPlayer, bustCard); // if player is bust then this gets called
		callBackplayerBust(currentPlayer, bustCard);

	}

	@Override
	public void dealHouse(int delay) throws IllegalArgumentException {
		
		if (delay < 0) {
			throw new IllegalArgumentException(String.format ("Delay: %d is not greater than zero please enter a positive number for the delay", delay));
		}


//TODO could make this into a static method as a lot of the same code used in both of these methods.

		Player dealer = new PlayerImpl("DXX", "DEALER", 0); // create player for the dealer
		Card bustCard = null; // card dealer goes bust on
//		// 2 get a hand for the current player
		Hand houseHand = dealer.getHand();
		int loopCheck = 0;
		// 3 check the score of the hand
		int bustScore = 21;
		// if card does not bust player
		while (loopCheck <= bustScore && loopCheck == 0) {

//			System.out.println("current hand score: "+currentPlayerHand.getScore());

			// see what the next card is
			Card nextCard = mydeck.removeNextCard();
			// these are to hold some values
			int valueOfNextCard = nextCard.getValue();
			int valueOfScore = houseHand.getScore();
			int potentialScore = valueOfNextCard + valueOfScore;
			// check if next card will bust player or not
			if (potentialScore >= bustScore) {
				// if next card will bust player then update loop check to 1 to stop running
				bustCard = nextCard;
				// get the score for the current hand
				houseHand.getScore();

				loopCheck = 1;
			} else {
				try {
					Thread.sleep(delay);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				houseHand.dealCard(nextCard);
//				callback.playerCard(dealer, nextCard);
//				callback.houseCard(houseHand, nextCard);

				callBackHouseCard(houseHand, nextCard);

			}

		}
//
//		callback.houseBust(houseHand, bustCard);
		// check final results

		callBackHouseBust(houseHand, bustCard);

		for (Player player : players.values()) {
			Bet playerBet = player.getBet();
			playerBet.finaliseBet(houseHand);
			player.applyBetResult(houseHand); // apply results

			// This is output as print string and not logger message
			System.out.println(player.toString());
			// logic to print out different information for players where getOutcome returns
			// 0
			if (playerBet.getOutcome() > 0) {
				System.out.println("Player: " + player.getId() + "\t" + "   " + player.getName() + "\t"
						+ formatBetResult(playerBet.getResult()) + "\t" + playerBet.getOutcome());
				;
			} else {
				System.out.println("Player: " + player.getId() + "\t" + "   " + player.getName() + "\t"
						+ formatBetResult(playerBet.getResult()) + "\t");

			}

		}

	}

// this is to get information on results so we can print out the right strings e.g. 'Loss'
	private String formatBetResult(BetResult result) {
		if (result == BetResult.PLAYER_LOSS) {
			return " Loss";
		}
		if (result == BetResult.PLAYER_WIN) {
			return " Win";
		}
		if (result == BetResult.DRAW) {
			return " Draw";
		}
		if (result == BetResult.UNDETERMINED) {
			return " No Bet";
		}

		return null;

	}

	@Override
	public void resetAllBetsAndHands() {
		// TODO Auto-generated method stub
//		GameCallback callback = getCallBack();
		for (Player player : players.values()) {
			// reset bets for all players
			player.resetBet();
			// call bet log message
//			callback.betUpdated(player);
			for (GameCallback cb : callBackList) {
				cb.betUpdated(player); // log the card
			}
		}

	}

}
