package model.card;

public class CardImpl implements Card, Comparable<Card> {

	// these are instance variables
	private Suit suit;
	private Rank rank;
	private int value;

	public CardImpl(Suit suit, Rank rank) {
		// assign the values from the constructor to instance variables
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
	public int compareTo(Card card) {
		// variables for the method
		int valCurrCard = this.rank.ordinal() + 1;
		int valOtherCard = card.getValue();

		int valCurrSuit = this.suit.ordinal();
		int valOtherSuit = card.getSuit().ordinal();

		// check if suits are the same - if they are then we need to check the ranks

		if (valCurrSuit == valOtherSuit) {

			if (valCurrCard > valOtherCard) {
				System.out.print(
						"Current card" + this.rank.name() + " is Greater than " + this.rank.name() + card.getRank());
//			System.out.print("value of Other Card is " + card.getRank());
				return 1;
			}
			if (valCurrCard < valOtherCard) {
				return -1;
			} else {
				System.out.print("Cards are equal");
				return 0;
			}
		}
		// if suite are not the same then check if current suit is greater than the
		// other suit
		if (valCurrSuit > valOtherSuit) {
			return 1;
		}
		// if current suit is not the same as other suit and greater than other suite
		// then must be less than
		else {
			return -1;
		}
	}

	@Override
	public String toString() {
		return rank + " of " + suit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((rank == null) ? 0 : rank.hashCode());
		result = prime * result + ((suit == null) ? 0 : suit.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardImpl other = (CardImpl) obj;
		if (rank != other.rank)
			return false;
		if (suit != other.suit)
			return false;
		return true;
	}

}
