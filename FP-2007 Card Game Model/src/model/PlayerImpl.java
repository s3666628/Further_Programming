package model;

import model.bet.Bet;
import model.card.Hand;

public class PlayerImpl implements Player {
	
	private String id;
	private String name;	
	private int points;
//	java.lang.String id, java.lang.String name, int points)

	public PlayerImpl(String id, String name, int points) throws NullPointerException, IllegalArgumentException {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.name = name;
		this.points = points;
		System.out.print("a new player has been created.");
		
	}

	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return this.points;
	}

	@Override
	public int getTotalPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void assignBet(Bet bet) {
		// TODO Auto-generated method stub

	}

	@Override
	public Bet getBet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Hand getHand() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void applyBetResult(Hand houseHand) {
		// TODO Auto-generated method stub

	}

	@Override
	public void resetBet() {
		// TODO Auto-generated method stub

	}

}
