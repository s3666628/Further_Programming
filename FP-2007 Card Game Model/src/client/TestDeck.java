package client;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;

import model.GameEngine;
import model.GameEngineImpl;
import model.PlayerImpl;
import model.card.Card;
import model.card.CardImpl;
import model.card.Deck;
import model.card.DeckImpl;
import model.card.Hand;
import model.card.HandImpl;
import model.card.Rank;
import model.card.Suit;

public class TestDeck {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

//		List<Card> mainDeckOfCards = new ArrayList<>()
		Deck mydeck1 = DeckImpl.createShuffledDeck();
//		Deck mydeck1 = DeckImpl.createShuffledDeck();
//		Deck mydeck2 = DeckImpl.
		GameEngine engine = new GameEngineImpl();
		engine.addPlayer(new PlayerImpl("P1", "Player One", 1000));
		

//		mydeck.cardsInDeck();
		
//		for(Deck item : mydeck)
//		{
//		    System.out.println(item);
//		}
//		Iterator<Deck> card = mydeck.iterator();
		

		Hand playerHand = new HandImpl();
//		mydeck.cardsInDeck();
//		
//		System.out.println(mydeck1.cardsInDeck());
		System.out.println(mydeck1.removeNextCard());
//		System.out.println(mydeck1.removeNextCard());
		System.out.println(mydeck1.removeNextCard());
		
		
//		System.out.println(playerHand.dealCard(nextCard));
//		System.out.println(playerHand.isEmpty());
//		playerHand.isEmpty();

//		mydeck.forEach((suit) -> System.out.println(suit));
//		java.util.Iterator<Card> i = mydeck.iterator();
//		Iterator i = aList.iterator();
//		forEach((n) -> System.out.println(n)); 
		
//		create a new player and deal some cards
//		PlayerImpl phil = new PlayerImpl("S1", "Phi", 100);
//		Hand philHand = phil.getHand();
		
//		System.out.println(philHand.dealCard(nextCard));
//		System.out.println(philHand.dealCard(nextCard));
//		System.out.println(philHand.isEmpty());
//		System.out.println(philHand.BUST_SCORE);
//		System.out.println(philHand.getScore());
//		mydeck.removeNextCard();
		
//		while (philHand.getScore() <= philHand.BUST_SCORE) {
////			System.out.println(philHand.dealCard(nextCard));
//			philHand.dealCard(mydeck.removeNextCard());
//			System.out.println("Your Score is: "+philHand.getScore());
//			
//		}



		
	
	}
}
