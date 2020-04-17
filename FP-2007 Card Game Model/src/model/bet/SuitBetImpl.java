package model.bet;

import model.Player;
import model.card.Hand;
import model.card.Suit;

public class SuitBetImpl implements SuitBet {

	Player player;
	int amount;
	Suit suit;
	int multiplier = 1;
	BetResult result;

	public SuitBetImpl(Player player, int amount, Suit suit) throws NullPointerException, IllegalArgumentException {
		// set up the instance variables correctly
		this.player = player;
		this.amount = amount;
		this.suit = suit;
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
		// this should work
		return this.multiplier;
	}


	@Override
	public BetResult finaliseBet(Hand houseHand) {
		// Finalises a bet based on the supplied house hand and returns a BetResult to
		// indicate the result of the bet.
		// This result should also be stored in the bet for later use
		// TODO do not know how to implement this atm
		
//		Player Loss The total number of cards of the nominated suit in the player’s hand
//		is less than or equal to the total number of cards of the same suit in
//		the House’s hand
//		Player loses 100
//		Player Win The total number of cards of the nominated suit in the player’s hand
//		is exceeds the total number of cards of the same suit in the House’s
//		hand
//		Player wins 400
//		
		Hand playerhand = player.getHand();
		Bet playerBet = player.getBet(); // need this so we know what player has bet
		playerBet.getAmount();
		int playerClubs = playerhand.getSuitCount(suit.CLUBS);
		int playerDiamonds = playerhand.getSuitCount(suit.DIAMONDS);
		int playerHearts = playerhand.getSuitCount(suit.HEARTS);
		int playerSpades = playerhand.getSuitCount(suit.SPADES);
		int playerTotals = playerClubs + playerDiamonds + playerHearts + playerSpades;
		
		int dealerClubs = houseHand.getSuitCount(suit.CLUBS);
		int dealerDiamonds = houseHand.getSuitCount(suit.DIAMONDS);
		int dealerHearts = houseHand.getSuitCount(suit.HEARTS);
		int dealerSpades = houseHand.getSuitCount(suit.SPADES);
		int dealerTotals = dealerClubs + dealerDiamonds + dealerHearts + dealerSpades;
		
		if (playerTotals  <= dealerTotals) {
//			System.out.println("player Suit Loss " + this.player.getName() + " has lost");
			this.result = BetResult.PLAYER_LOSS;
			
			
			
			
			
		}
		else {
//			System.out.println("player Suit Win " + this.player.getName() + " has lost");
			this.result = BetResult.PLAYER_WIN;
		}
//		if (playerScore  > houseHand.getScore()) {
//			System.out.println("player Win" + this.player.getName() + " has lost");
//			this.result = BetResult.PLAYER_WIN;
//		}
//		
		
//		You need to a) indicate that the bet has been finalised (you'll see in some of the other bet functions it tells you to return differently if the bet isn't yet finalised)
//	b) compare the players hand to the houses hand and determine whether the player won, drew or lost, the way of doing so differs between score and suit bets
		return this.result;

	}

	@Override
	public BetResult getResult() {
		// this should work returns bet result which is of type BetResult
		return this.result;
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
			return getAmount() * getMultiplier();
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
	public Suit getSuit() {
		// this should work
		return this.suit;
	}

	@Override
	public String toString() {
		return "Suit Bet for " + getAmount() + " on suit " + getSuit();
	}

}
