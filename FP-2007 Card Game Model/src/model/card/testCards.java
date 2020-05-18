package model.card;

//import model.CardPack;

public class testCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		for (ComponentNames names : ComponentNames.values()) { // gets an array of enums
		
		for (Rank ranks : Rank.values()) { // gets an array of enums
			System.out.println(ranks.getRankValue());
			System.out.println(ranks.toString());
		}
		
		
		Deck mydeck = DeckImpl.createShuffledDeck();
		
		int numberCards = mydeck.cardsInDeck();
		int counter = 0;
		while (counter < numberCards) {
			
			Card card = mydeck.removeNextCard();
//			System.out.println("The card " + card + " has been removed from the deck");
//			System.out.println(card.getRank());
//			System.out.println(card.getValue());
//			System.out.println(card.getSuit());
			System.out.println(card.toString());
			
			counter+=1;
		}

	}

}
