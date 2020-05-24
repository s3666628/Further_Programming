package model;

import model.bet.Bet;
import model.bet.BetResult;
import model.card.Hand;
import model.card.HandImpl;

public class PlayerImpl implements Player {

	private String id;
	private String name;
	private int points;
	// these are the no instance variables
	private Bet bet = Bet.NO_BET;
	private Hand hand = null;;
//	java.lang.String id, java.lang.String name, int points)

	public PlayerImpl(String id, String name, int points) throws NullPointerException, IllegalArgumentException {

		if (id == null) {
			throw new NullPointerException("Player cannot be created without a Player ID");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("Player cannot be created without a Name");
		}
		if (points < 0) {
			throw new IllegalArgumentException("Player cannot be created with less than 1 Point");
		}

		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.points = points;
		// this creates a new hand which is associated with player object
		this.hand = new HandImpl();
		new HandImpl();

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
		// if there is a current bet then need to remove the current bet amount from the
		// points
//		if (this.bet.getAmount() > 0) { //if bet amount is zero then means there is no bet
//			System.out.println(this.bet.getAmount());
//			return this.points;
//			
//		}
		return this.points = this.points - bet.getAmount(); // original
//		
	}

//	@Override
//	public int getTotalPoints() {
//
//		// does player have current bet
//
//		int totalPoints = 0;
//		Bet playerBet = getBet();
//		if (playerBet.getAmount() > 0) {
//			totalPoints = totalPoints + this.points + playerBet.getAmount();
//			return totalPoints;
//		} // player does not have bet just return current points
//		else {
//			return this.points;
//
//		}

//	}

	@Override
	public int getTotalPoints() {

//		Returns the current total points for a player, which includes any amount currently bet.
//		Hint: If the player doesn't have a current bet this method should return the current points, otherwise add the bet's value to it.
		Bet bet = getBet();
		return points + bet.getAmount();

	}

	@Override
	public void assignBet(Bet bet) {

//		Assigns the supplied bet placed for the player via the GameEngine (DONE)
//		The players points should be adjusted accordingly and the supplied bet parameter assigned to an appropriate instance variable.
//		Take care when replacing a bet as the original bet amount has already been deducted from the current points.
//
//		Hint: Try to ensure you don't duplicate code between the Game Engine, Bet and Player when dealing with bets.
		this.bet = bet; // assign player bet to the instance variable
		this.points = getTotalPoints() - bet.getAmount(); // adjust the current points

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
		BetResult result = this.bet.finaliseBet(houseHand);
		Bet playerBet = this.bet;
		if (result == BetResult.PLAYER_LOSS) {
//			System.out.println("points before applying result" + this.points);
			this.points = this.points - playerBet.getAmount();

//			System.out.println(this.name + " player Bet Amount on Loss" + playerBet.getAmount());
//			System.out.println("points AFTER applying result" + this.points);
		}
		if (result == BetResult.PLAYER_WIN) {
//			System.out.println("points before applying result" + this.points);
			this.points = this.points + playerBet.getAmount();
//			System.out.println(this.name + " player Bet Amount on Win" + playerBet.getAmount());
		}
		if (result == BetResult.DRAW) {
			this.points = this.points;
//			System.out.println(this.name + " player Draw" + playerBet.getAmount());
		}
		if (houseHand == null) {
//			System.out.println("houseHand is empty - so cannot apply result");
		}

	}

	@Override
	public void resetBet() {
		// resets the bet to NO_BET
		this.bet = Bet.NO_BET;

	}

	@Override
	public String toString() {
		// if player has empty hand no print out the score
		if (this.hand.isEmpty() || this.bet == Bet.NO_BET) {
			return "Player id=" + id + ", name=" + name + ", points=" + getPoints() + ", " + bet + ", "
					+ hand.toString();
		} else {
			return "Player id=" + id + ", name=" + name + ", points=" + getPoints() + ", " + bet + ", "
					+ hand.toString() + " Score: " + this.hand.getScore();
		}

	}

}
