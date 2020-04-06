package model.card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//import card.Rank;
//import card.Suit;

public class DeckImpl implements Deck {
	
	private DeckImpl () {
	}
	// this is from the interface Deck
	private static int totalCards = Deck.TOTAL_NUM_CARDS;
	static List<Card> deckOfCards = new ArrayList<>(totalCards);
	static List<String> deckOfCards2 = new ArrayList<>(totalCards);
	
	
	// Deck should be sorted by default as we create the deck in order
	public static Deck createShuffledDeck() {
		 for (Suit suit : Suit.values()) {
			 for (Rank rank : Rank.values()) {
			     deckOfCards.add(new CardImpl(suit, rank));	 
			     }
		 }
		Collections.shuffle(deckOfCards);
		return (Deck) deckOfCards;
	}
	
	
	// Deck should be sorted by default as we create the deck in order
	public static Deck createSortedDeck() {
		 for (Suit suit : Suit.values()) {
			 for (Rank rank : Rank.values()) {
//			     System.out.print(rank + " of " );
//			     System.out.print(suit + " ");
			     deckOfCards.add(new CardImpl(suit, rank));
//			     deckOfCards2.add(rank + " of " + suit);			 
			     }
		 }
		return (Deck) deckOfCards;
	}
	
	@Override
	public Card removeNextCard() throws IllegalStateException {
		// TODO Auto-generated method stub
		Card card = null;
		Iterator<Card> itr = deckOfCards.iterator();
		if (itr.hasNext() == true)
		{
			card = itr.next();
			return card;
		}
		return card;
	}

	@Override
	public int cardsInDeck() {
		// gets the size of the deck of cards
		return deckOfCards.size();
	}

	@Override
	public void shuffleDeck() {
		// TODO Auto-generated method stub
		
	}


}
