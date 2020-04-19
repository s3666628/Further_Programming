package model.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//import card.Rank;
//import card.Suit;

public class DeckImpl implements Deck {

	private DeckImpl() {

	}

	// this is from the interface Deck
	private int totalCards = Deck.TOTAL_NUM_CARDS;


	List<Card> mainDeckOfCards = new ArrayList<>(totalCards);
	Iterator<Card> itr = mainDeckOfCards.iterator();

	

	// Deck should be sorted by default as we create the deck in order
	public static Deck createShuffledDeck() {
		DeckImpl deckOfCards = new DeckImpl();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new CardImpl(suit, rank);
				deckOfCards.mainDeckOfCards.add(card);
//				System.out.println(card.toString());
			}
		}
		deckOfCards.shuffleDeck();
		
		
		return deckOfCards;
	}
	

	// Deck should be sorted by default as we create the deck in order
	public static Deck createSortedDeck() {
		DeckImpl deckOfCards = new DeckImpl();
		for (Suit suit : Suit.values()) {
			for (Rank rank : Rank.values()) {
				Card card = new CardImpl(suit, rank);
				deckOfCards.mainDeckOfCards.add(card);
				System.out.println(card.toString());
			}
		}
		return deckOfCards;
	}
// this doesn't crash code but always removes the same card
//	@Override
//	public Card removeNextCard() throws IllegalStateException {
//		// TODO Auto-generated method stub
//		itr = mainDeckOfCards.iterator();
//		Card card = null;		
//		if (itr.hasNext() == true) {
//			card = itr.next();
//			return card;
//		}
//		return card;
		
		@Override
		public Card removeNextCard() throws IllegalStateException {
		// TODO Auto-generated method stub
		Card removeCard = mainDeckOfCards.get(0);
		mainDeckOfCards.remove(removeCard);
		return removeCard;}
	

	@Override
	public int cardsInDeck() {
		// gets the size of the deck of cards
		return mainDeckOfCards.size();
	}

	@Override
	public void shuffleDeck() {
		// calling this method should shuffle the deck of cards
		Collections.shuffle(mainDeckOfCards);

	}

	@Override
	public String toString() {
//		return "DeckImpl [totalCards=" + totalCards + "]";
		return "A new deck of cards was created with " + Deck.TOTAL_NUM_CARDS + " cards";
	}
	

}
