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
	// collection for the callback logger
	List<GameCallback> callBackList = new ArrayList<>();

	// this should give us a shuffled deck of cards - will be used to deal cards to
	// the player
	Deck mydeck = DeckImpl.createShuffledDeck();
	// need this for the sleep function
	Thread thread;

	private static int NumberOfDeckMessage = 0;

	private GameCallback getCallBack() {
		GameCallback callback = callBackList.get(0);
		return callback;
	}

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
//		//adds new player to the hashmap 
//		key = playerID, value = player object)
		players.put(player.getId(), player);
		// logg information
		GameCallback callback = getCallBack();
		callback.addPlayer(player);
	}

	@Override
	public void removePlayer(String playerId) throws NullPointerException, IllegalArgumentException {
		// this should work - removes playerId that is passed in from the hash map
		Player player = players.get(playerId);// get player object from array via playerId string
		GameCallback callback = getCallBack();
		// NB: make sure log removing player before removing player otherwise it won't
		callback.removePlayer(player);
		players.remove(playerId);

	}

	@Override
	public Collection<Player> getAllPlayers() {
		// TODO this has not been worked out properly
		Collection<Player> allPlayers = (Collection<Player>) players.clone();
		return allPlayers;
	}

	@Override
	public void placeBet(String playerId, int amount) throws NullPointerException, IllegalArgumentException {
		// this will create a new score bet
		Player player = players.get(playerId);
		ScoreBetImpl Scorebet = new ScoreBetImpl(players.get(playerId), amount);
		player.assignBet(Scorebet);
		GameCallback callback = getCallBack();
		callback.betUpdated(player);

	}

	@Override
	public void placeBet(String playerId, int amount, Suit suit) throws NullPointerException, IllegalArgumentException {
		// this will create a new suit bet
		Player player = players.get(playerId);
		SuitBetImpl Suitbet = new SuitBetImpl(players.get(playerId), amount, suit);
		player.assignBet(Suitbet);
		GameCallback callback = getCallBack();
		callback.betUpdated(player);

	}

	public void dealPlayer(String playerId, int delay)
			throws NullPointerException, IllegalArgumentException, IllegalStateException {

		Player currentPlayer = players.get(playerId); // get player object
		GameCallback callback = getCallBack(); // create callback object
		if (NumberOfDeckMessage == 0) { // we only want to call the new deck logging method once when first player is
										// dealt hand
			callback.newDeck(mydeck); // log the new deck
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
				try { // sleep to add delay when cards being dealth
					Thread.sleep(delay * 10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				currentPlayerHand.dealCard(nextCard);// add next card to players hand
				callback.playerCard(currentPlayer, nextCard); // log the card
			}

		}

		callback.playerBust(currentPlayer, bustCard); // if player is bust then this gets called

	}

	@Override
	public void dealHouse(int delay) throws IllegalArgumentException {

//TODO could make this into a static method as a lot of the same code used in both of these methods.

		GameCallback callback = getCallBack(); // create callback object
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
					Thread.sleep(delay * 10);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				houseHand.dealCard(nextCard);
//				callback.playerCard(dealer, nextCard);
				callback.houseCard(houseHand, nextCard);
			}

		}
//
		callback.houseBust(houseHand, bustCard);
		// check final results

		for (Player player : players.values()) {
			Bet playerBet = player.getBet();
			playerBet.finaliseBet(houseHand);
			player.applyBetResult(houseHand); // apply results

			// This is output as print string and not logger message
			System.out.println(player.toString());
			// logic to print out different information for players where getOutcome returns 0		
			if (playerBet.getOutcome() > 0){
				System.out.println("Player: " + player.getId() + "\t" + "   " + player.getName() + "\t"
						+ formatBetResult(playerBet.getResult()) + "\t" + playerBet.getOutcome());;
			}
			else {
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
		GameCallback callback = getCallBack();
		for (Player player : players.values()) {
			// reset bets for all players
			player.resetBet();
			// call bet log message
			callback.betUpdated(player);
		}

	}

}
