package model.card;

import java.util.ArrayList;
import java.util.List;

//import card.Rank;
//import card.Suit;

public class DeckImpl implements Deck {
	
	private DeckImpl () {
	}
	// this is from the interface Deck
	private static int totalCards = Deck.TOTAL_NUM_CARDS;
	static List<Card> deckOfCards = new ArrayList<>(totalCards);
	
	private static void addCardsToDeck() {
		 for (Suit s : Suit.values()) {
//		     System.out.println(s);
			 for (Rank r : Rank.values()) {
			     System.out.print(r + " of " );
			     System.out.print(s + " ");
//			     new CardImpl(Suit.HEARTS, Rank.TWO)
			     deckOfCards.add(new CardImpl(s, r));

			 }
		 }
	}
	
	
	
//	private static List<Card> protoDeck = new ArrayList<Card>();
	
//	private void addCards (){
//		protoDeck.add(Card.class);
	

	
	public static Deck createShuffledDeck() {
//		List<Suit, Rank> deckOfCards = new ArrayList<Suit, Rank>(totalCards);
//		deckOfCards.add(Suit.CLUBS.ordinal());
		
		
		return null;		
	}
	public static Deck createSortedDeck() {
		return null;
	}
	
	@Override
	public Card removeNextCard() throws IllegalStateException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int cardsInDeck() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void shuffleDeck() {
		// TODO Auto-generated method stub
		
	}


}
