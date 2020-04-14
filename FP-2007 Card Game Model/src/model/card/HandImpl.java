package model.card;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class HandImpl implements Hand {

	// these are instance variables for hand
	int currentScore;
	Collection<Card> hand = new ArrayList<Card>();

	// this is used to store the current hand for the player
//	Collection<Card> hand = new ArrayList<Card>();
	// not sure we will need this but being used by one method here to reset the
	// score
//	private static int currentScore = 0;

//	private static int getCurrentScore() {
//		return currentScore;
//	}
//	private static void setCurrentScore(int newCurrentScore) {
//		currentScore = newCurrentScore;
//	}

	public HandImpl() {
		// create a new hand for the player
		this.hand = new ArrayList<Card>();
		// set players hand score to zero
		this.currentScore = 0;
	}

	@Override
	public boolean dealCard(Card card) {
//		 	
//		The supplied Card is dealt to hand.
		// TODO not sure how to make sure the card has been successfully added to the
		// hand as add() does not return anything
		if (this.hand.add(card)) {
//			System.out.println("card as been added to the hand: "+ card);
			return true;
		}
		;
		return false;
	}

	@Override
	public boolean isEmpty() {
		// Returns true if the hand contains no cards
		return this.hand.isEmpty();

	}

	@Override
	public int getNumberOfCards() {
//		Returns the number of cards currently held by the hand.
		return this.hand.size();

	}

	@Override
	public int getScore() {
		// TODO this might need to be worked on
//		for card in
		int total = 0;	
		for (Card card : hand) { 		      
			int valueOfCard = card.getValue(); 	
//			System.out.println("card is: " + card);
//			System.out.println("value of card is: " + card.getValue());
			
			total += valueOfCard;}
		this.currentScore = total;
		return this.currentScore;
	}

	@Override
	public int getSuitCount(Suit suit) {
//		Returns the total number of cards in the hand of the specified Suit//
//		If there are no cards in the hand whose suit matches that of the supplied parameter the method shall return 0. 
//		It should also return 0 if the supplied parameter is null.
		// first check if suit passed in is null
		if (suit == null) {
			return 0;
		}

		int numClubs = 0;
		int numDiamonds = 0;
		int numHearts = 0;
		int numSpades = 0;
		// figure out what suit is being passed in
		int checkedSuite = suit.ordinal();
		// we know its CLUBS
		if (checkedSuite == 0) {
			for (Card card : this.hand) {

				if (card.getSuit() == Suit.CLUBS) {
					numClubs += 1;
				}
				return numClubs;
			}

		}
		// we know its DIAMONDS
		if (checkedSuite == 1) {
			for (Card card : this.hand) {

				if (card.getSuit() == Suit.DIAMONDS) {
					numDiamonds += 1;
				}
				return numDiamonds;
			}

		}
		// we know its HEARTS
		if (checkedSuite == 2) {
			for (Card card : this.hand) {

				if (card.getSuit() == Suit.HEARTS) {
					numHearts += 1;
				}
				return numHearts;
			}

		}
		// we know its SPADES
		if (checkedSuite == 3) {
			for (Card card : this.hand) {

				if (card.getSuit() == Suit.SPADES) {
					numSpades += 1;
				}
				return numSpades;
			}

		}
		// none of the above then return 0
		return 0;
	}

	@Override
	public Collection<Card> getCards() {
		// Returns an unmodifiable collection (shallow copy) of all cards currently in
		// the hand
		// this should work by taking unmodifiable copy of what is already in hand
		// might need to change this to use the clone() method
		List<Card> currentHand = new ArrayList<Card>(this.hand);
		return currentHand;
	}

	@Override
	public void reset() {
		// set currentScore back to zero
		this.currentScore = 0;
		// removes all elements from the list
		this.hand.clear();

	}

	@Override
	public String toString() {
		if (hand.isEmpty()){
			return "Empty Hand";
		}
		return "HandImpl [currentScore=" + currentScore + ", hand=" + hand + "]";
	}
	

}
