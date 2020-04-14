package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import javax.security.auth.callback.Callback;

import model.card.Card;
import model.card.Deck;
import model.card.DeckImpl;
import model.card.Hand;
import model.card.HandImpl;
import model.card.Suit;
import view.GameCallback;
import view.GameCallbackCollection;
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
		Player player = players.get(playerId);//get player object from array via playerId string	
		GameCallback callback = getCallBack();
		//NB: make sure logg removing player before removing player otherwise it won't work
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
		new ScoreBetImpl(players.get(playerId), amount);
		GameCallback callback = getCallBack();
		callback.betUpdated(player);

	}

	@Override
	public void placeBet(String playerId, int amount, Suit suit) throws NullPointerException, IllegalArgumentException {
		// this will create a new suit bet
		new SuitBetImpl(players.get(playerId), amount, suit);

	}
	
	
	@Override
	public void dealPlayer(String playerId, int delay)
			throws NullPointerException, IllegalArgumentException, IllegalStateException {
		
		// prolly need loop here for each player do the following
		Player currentPlayer = players.get(playerId);
		// a card is removed from the deck and dealt to the player
//		HandImpl playerHand = new HandImpl();
		// 1 get the next card from the deck
		Card nextCard = mydeck.removeNextCard();
	
//		// 2 get a hand for the current player
		Hand currentPlayerHand = currentPlayer.getHand();
		// 3 check the score of the hand	
		while (currentPlayerHand.getScore() <= currentPlayerHand.BUST_SCORE) {
			currentPlayerHand.dealCard(nextCard);
		}
		// 4  add the current card to the players hand
		
//		if nextCard.getValue();		
		
//		Deals a hand to the specified player.
//
//		Cards are dealt to the specified player in the following manner
//
//		    a card is removed from the deck and dealt to the player
//		    a delay occurs, of the specified time in ms, between the card being removed from the deck and it being dealt to the player
//		        if the card does not bust in player's hand:
//		            the GameCallback.playerCard(Player, model.card.Card) is invoked on all the GameCallback objects that have been registered, notifying the player and the card dealt (all get the same information!)
//		            the process is then repeated for the next card until a bust occurs 
//		        if the card does bust in the player's hand
//		            the GameCallback.playerBust(Player, model.card.Card) is invoked on all the GameCallback objects that have been registered, notifying the player and the card that was attempted to be dealt to the player 
//
//		Note: A bust card is burnt, and not returned to the deck or dealt to any subsequent player.
//		
//		hand.dealCard();

	}

	@Override
	public void dealHouse(int delay) throws IllegalArgumentException {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetAllBetsAndHands() {
		// TODO Auto-generated method stub

	}

}
