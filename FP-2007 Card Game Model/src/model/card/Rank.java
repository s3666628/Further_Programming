package model.card;

import java.util.EnumMap;
import java.util.HashMap;

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
public enum Rank {
    ACE
    {
    	private int aceValue =1;
    	
    	public int getRankValue()
    	{
			return aceValue;
    		
    	}
    },  //calls constructor with value 3
    TWO
    {
    	private int twoValue =2;
    	
    	public int getRankValue()
    	{
			return twoValue;
    		
    	}
    },  //calls constructor with value 2
    THREE
    {
    	private int threeValue =3;
    	
    	public int getRankValue()
    	{
			return threeValue;
    		
    	}
    },   //calls constructor with value 1
    FOUR
    {
    	private int fourValue =4;
    	
    	public int getRankValue()
    	{
			return fourValue;
    		
    	}
    },  //calls constructor with value 2
    FIVE
    {
    	private int fiveValue =5;
    	
    	public int getRankValue()
    	{
			return fiveValue;
    		
    	}
    },  //calls constructor with value 2
    SIX
    {
    	private int sixValue =6;
    	
    	public int getRankValue()
    	{
			return sixValue;
    		
    	}
    },  //calls constructor with value 2
    SEVEN
    {
    	private int sevenValue =7;
    	
    	public int getRankValue()
    	{
			return sevenValue;
    		
    	}
    },  //calls constructor with value 2
    EIGHT
    {
    	private int eightValue =8;
    	
    	public int getRankValue()
    	{
			return eightValue;
    		
    	}
    },  //calls constructor with value 2
    NINE
    {
    	private int nineValue =9;
    	
    	public int getRankValue()
    	{
			return nineValue;
    		
    	}
    },  //calls constructor with value 2
    TEN
    {
    	private int tenValue =10;
    	
    	public int getRankValue()
    	{
			return tenValue;
    		
    	}
    },  //calls constructor with value 2
    JACK
    {
    	private int jackValue =10;
    	
    	public int getRankValue()
    	{
			return jackValue;
    		
    	}
    },  //calls constructor with value 2
    QUEEN
    {
    	private int queenValue =10;
    	
    	public int getRankValue()
    	{
			return queenValue;
    		
    	}
    },  //calls constructor with value 2
    KING    {
    	private int kingValue =10;
    	
    	public int getRankValue()
    	{
			return kingValue;
    		
    	}
    }
    ; 
//    
    public int getRankValue() {
        
    	return 0;}
//    }
//    public void test() {
//	for (Rank c : Rank.values())
//	    System.out.println(c);}
//	
//	
	
//	public static Rank[] values()
////	Returns an array containing the constants of this enum type, in the order they are declared. This method may be used to iterate over the constants as follows:
//	for (Rank c : Rank.values())
//	    System.out.println(c);
//		
//	
}
