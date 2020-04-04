package model.card;

/**
 * This enum represent the rank for each card
 * 
 * <p>
 * The natural order of rank should be Ace, 2, 3, ... 9, 10, Jack, Queen, King
 * 
 * <p>
 * <b>Note: </b>You must provide the method {@link Rank#getRankValue()} in the
 * enum and/or for each of it's values.
 * 
 * <p>
 * <b>Hint: </b>You may find it useful to override methods in the enum and/or
 * on each of the value.
 * 
 * <p>
 * <b>Hint: </b>Be sure to follow naming conventions for your enum values
 * 
 * <p>
 * <b>Note: </b> The {@link Rank#valueOf(String)} and {@link Rank#values()}
 * methods are provided by the API - you do not need to write or override them
 * yourself.
 * 
 * @author Ross Nye
 * 
 * @see model.card.Card
 * @see model.card.Suit
 *
 */
public enum Rank
{ ACE,
  TWO,
  THREE,
  FOUR,
  FIVE,
  SIX,
  SEVEN,
  EIGHT,
  NINE,
  TEN,
  JACK,
  QUEEN,
  KING;
	//TODO this doesn't do anything and always returns 0 
	//TODO so need to figure out how to return an actual value based on the Rank
	public int getRankValue() {
		return 0;
		}
		
		
	

//	public static final Rank ACE;
   
//      ACE(1),
//      TWO(2),
//      THREE(3),
//      FOUR(4),
//      FIVE(5),
//      SIX(6),
//      SEVEN(7),
//      EIGHT(8),
//      NINE(9),
//      TEN(10),
//      JACK(11),
//      QUEEN(12),
//      KING(13);
//	    
//	  int rank;
//	     
//	   Rank(int rank)
//	      {          
//	        this.rank = rank;
//	      }
//	       
//	      public int getRank()  {	         
//	        return rank;
//	      }

	
}
