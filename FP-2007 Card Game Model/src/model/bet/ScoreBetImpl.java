package model.bet;

import model.Player;
import model.card.Hand;

public class ScoreBetImpl implements ScoreBet {

	private Player player;
	private int amount;
	private int multiplier = 1; // assume this is one - can change if we learn more about the betting multiplier
	BetResult result;

	public ScoreBetImpl(Player player, int amount) throws NullPointerException, IllegalArgumentException {

		// values passed from constructor assigned to the instance variables
		this.player = player;
		this.amount = amount;
		this.result = BetResult.UNDETERMINED;

	}

	@Override
	public Player getPlayer() {
		// this should work
		return this.player;
	}

	@Override
	public int getAmount() {
		// this should work
		return this.amount;
	}

	@Override
	public int getMultiplier() {
		// // this should work
		return this.multiplier;
	}

	@Override
	public BetResult finaliseBet(Hand houseHand) {
		// Finalises a bet based on the supplied house hand and returns a BetResult to
		// indicate the result of the bet.
		// This result should also be stored in the bet for later use
		// TODO do not know how to implement this atm

//		Player Loss The total score of the player�s hand is less than that of the House Player loses 100
//		Draw The total score of the player�s hand is the same as that of the House No change (bet returned)
//		Player Win The total score of the player�s hand is more than that of the House Player wins 200
//		
		Hand playerhand = player.getHand();
		int playerScore = playerhand.getScore();

		if (playerScore < houseHand.getScore()) {
//			System.out.println("player Loss" + this.player.getName() + " has lost");
			this.result = BetResult.PLAYER_LOSS;
		}
		if (playerScore == houseHand.getScore()) {
//			System.out.println("player Draw" + this.player.getName() + " has Drawn");
			this.result = BetResult.DRAW;
		}
		if (playerScore > houseHand.getScore()) {
//			System.out.println("player Win" + this.player.getName() + " has Won");
			this.result = BetResult.PLAYER_WIN;
		}

//		You need to a) indicate that the bet has been finalised (you'll see in some of the other bet functions it tells you to return differently if the bet isn't yet finalised)
//	b) compare the players hand to the houses hand and determine whether the player won, drew or lost, the way of doing so differs between score and suit bets
		return this.result;

	}

	@Override
	public BetResult getResult() {
		// TODO Auto-generated method stub
		// Getter that returns the result of a bet.
		// Before the bet has been finalised this method should return
		// BetResult.UNDETERMINED
		return this.result; // this will return BetResult.UNDETERMINED unless someone updates the BetResult
							// variable
	}

	@Override
	public int getOutcome() {
		// Returns the outcome of the bet; i.e. the amount won or lost as a result of
		// the bet.
		// If this method is called prior to the bet being finalised then it should
		// return 0,
		// otherwise is should return a negative value for a loss and a positive value
		// for a win,
		// both of which should be bases on the bet amount and the bet multiplier. A
		// draw should return 0.
		if (this.result == BetResult.UNDETERMINED) { // means bet has not been finalised
			return 0;
		}
		if (this.result == BetResult.PLAYER_LOSS) { // means bet has not been finalised
			return getAmount() * 2;
		}
		if (this.result == BetResult.DRAW) { // means bet has not been finalised
			return 0;
		}
		if (this.result == BetResult.PLAYER_WIN) { // means bet has not been finalised
			return getAmount() * getMultiplier();
		}
		return 0;
	}

	@Override
	public int getOutcome(BetResult result) {
		// TODO Auto-generated method stub

		return getOutcome();
	}

	@Override
	public int compareTo(Bet bet) {
//		 * Returns a negative integer, zero, or a positive integer as this Bet value is less than, 
//		 * equal to, or greater than the supplied Bet.
		if (this.amount < bet.getAmount()) {
			return -1;
		}
		if (this.amount > bet.getAmount()) {
			return 1;
		}

		return 0;
	}

	@Override
	public String toString() {
		return "Score Bet for " + getAmount();
	}

}
