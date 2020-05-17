package view;

public class PlayersSample {
	String playerName;
	int playerScore;
	int betAmount;
	String betType;
	String betSuit;
	public PlayersSample(String playerName, int playerScore) {
		super();
		this.playerName = playerName;
		this.playerScore = playerScore;
		
	
	}
	public PlayersSample(String playerName, int playerScore, int betAmount, String betType, String betSuit) {
		super();
		this.playerName = playerName;
		this.playerScore = playerScore;
		this.betAmount = betAmount;
		this.betType = betType;
		this.betSuit = betSuit;
	}

	
	/**
	 * @return the playerName
	 */
	public String getPlayerName() {
		return playerName;
	}
	/**
	 * @return the playerScore
	 */
	public int getPlayerScore() {
		return playerScore;
	}
	/**
	 * @return the betAmount
	 */
	public int getBetAmount() {
		return betAmount;
	}
	/**
	 * @return the betType
	 */
	public String getBetType() {
		return betType;
	}
	/**
	 * @return the betSuit
	 */
	public String getBetSuit() {
		return betSuit;
	}
	@Override
	public String toString() {
		String text1 = String.format("Player: %s with a score of: %d",this.playerName, this.playerScore);
		String text2 = String.format(" Bet Amount: %d Bet Type of: %s Bet Suit of: %s",this.betAmount, this.betType, this.betSuit);
		return text1 + "<br/>" + text2 + "<br/>"; 
	}
	
	
	

}
