package model;

import model.bet.Bet;
import model.card.Hand;
import model.card.HandImpl;

public class PlayerImpl implements Player {

	private String id;
	private String name;
	private int points;
	// these are the no instance variables
	private Bet bet = Bet.NO_BET;
	private Hand Househand;
	private Hand hand;
//	java.lang.String id, java.lang.String name, int points)

	public PlayerImpl(String id, String name, int points) throws NullPointerException, IllegalArgumentException {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.points = points;
		// this creates a new hand which is associated with player object
		this.hand = new HandImpl();
//		System.out.println("a new player has been created with an empty hand");

	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getName() {
		// this returns player name
		return this.name;
	}

	@Override
	public int getPoints() {
		// this returns instance variable
		return this.points;
	}

	@Override
	public int getTotalPoints() {

		// Returns the current total points for a player, which includes any amount
		// currently bet.
		// Hint: If the player doesn't have a current bet this method should return the
		// current points,
		// otherwise add the bet's value to it....
		int totalPoints = this.points;
		if (this.bet != Bet.NO_BET) {
			return totalPoints;
		}
		// TODO need to figure out how to get the value of the bet as integer
		else {
			totalPoints = totalPoints; // + amount of the current bet
			return totalPoints;
		}

	}

	@Override
	public void assignBet(Bet bet) {
		// get the bet that has been passed in and assign it bet variable which is
		// stored here
		this.bet = bet;

	}

	@Override
	public Bet getBet() {
		// think this is correct
		return this.bet;
	}

	@Override
	public Hand getHand() {
		// think this is correct returns hand from variable which is stored in this
		// class
		return this.hand;
	}

	@Override
	public void applyBetResult(Hand houseHand) {
		// think this is correct
		// takes the bet that has been passed in
		// and assigns it to the variable stored in this class
		this.hand = houseHand;

	}

	@Override
	public void resetBet() {
		// resets the bet to NO_BET
		this.bet = Bet.NO_BET;

	}

	@Override
	public String toString() {
	return "Player id=" + id + ", name=" + name + ", points=" + points + ", " + bet + ", "+ hand.toString();
	}
	

}
