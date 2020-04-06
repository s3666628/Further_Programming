package model.card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;



public class CardImpl implements Card, Comparable<Card> {

	
	// these are instance variables
	private Suit suit;
	private Rank rank;
	private int value;
	
//	static HashMap<Rank, Integer> hmap = new HashMap<Rank, Integer>();
	
	
	public CardImpl(Suit suit, Rank rank){
		//assign the values from the constructor to instance variables
		this.suit = suit;
		this.rank = rank;		
	}

	@Override
	public Suit getSuit() {
		// gets the Suit which is passed in as part of the constructor for the CardImpl
		return suit;

	}

	@Override
	public Rank getRank() {
		// gets the Rank of a card from the instance var when CardImpl is created
		return rank;
	}

	@Override
	// gets the value of the rank from the Rank enum
	// calls the getRankValue which is in the Rank enum
	public int getValue() {
		// TODO Auto-generated method stub
		value = rank.getRankValue();
		return value;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof CardImpl)) {
			return false;
		}
		CardImpl other = (CardImpl) obj;
		return rank == other.rank && suit == other.suit;
	}

	@Override
	public int compareTo(Card card) {
		
		int valCurrCard = this.rank.ordinal()+1;
		int valOtherCard = card.getValue();		
		
		int valCurrSuit = this.suit.ordinal();
		int valOtherSuit = card.getSuit().ordinal();
		
		System.out.print("value of current suit");
		System.out.print(valCurrSuit);
		System.out.print("value of Other suit");
		System.out.print(valOtherSuit);
		
//		System.out.println();
//		System.out.print("calling the CompareTo method");
//		System.out.println();
//		System.out.print("value of Current Card is " + this.rank.name());
//		System.out.print("value of Other Card is " + card.getRank());
		// 1 - check if cards are same suit if they are then check the ranks
		if (valCurrSuit == valOtherSuit) {
		
		if (valCurrCard > valOtherCard) {
			System.out.print("Current card"+ this.rank.name() + " is Greater than " + this.rank.name() + card.getRank());
//			System.out.print("value of Other Card is " + card.getRank());
			return 1;}
		if (valCurrCard < valOtherCard) {
			return -1;}
		else {
			System.out.print("Cards are equal");
			return 0;}
		}
		// if suite are not the same then check if current suit is greater than the other suit
		if (valCurrSuit > valOtherSuit) {
			return 1;
		}
		// if current suit is not the same as other suit and greater than other suite then must be less than
		else {
			return -1;}
	}
	
	
	
	

//		if (this.suit.or == card.getSuit())
//		{
//			
//		}
//		Override Comparable.compareTo(Object) Compares this Card with the supplied Card for order. 
//		Returns a negative integer, zero, or a positive integer if this Card is less than, equal to, or greater than the supplied Card.
//		If the two cards are of the same suit the card ranks used to make the comparison, using the natural order or rank (Ace, 2, ... 10, Jack, Queen, King). 
//		However if the cards are of different suit, then the suit order is used which determined by ascending alphabetical order: clubs (lowest), 
//		followed by diamonds, hearts, and spades (highest)
//		value = rank.ordinal ();
//		
//		
//		return value;
		//		return card !=null ? this.getValue() == card.getValue() : false;
	
	@Override
	public int hashCode() {
		return Objects.hash(rank, suit);
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}
	
	
	}
