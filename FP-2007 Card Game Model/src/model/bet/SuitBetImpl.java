package model.bet;

import model.Player;
import model.card.Hand;
import model.card.Suit;

public class SuitBetImpl implements SuitBet {
	
	public SuitBetImpl(Player player, int amount, Suit suit)throws NullPointerException, IllegalArgumentException{
		
	}

	@Override
	public Player getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAmount() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMultiplier() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public BetResult finaliseBet(Hand houseHand) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BetResult getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getOutcome() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getOutcome(BetResult result) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int compareTo(Bet bet) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Suit getSuit() {
		// TODO Auto-generated method stub
		return null;
	}

}
