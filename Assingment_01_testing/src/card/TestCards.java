package card;

public class TestCards {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 for (Suit s : Suit.values()) {
//		     System.out.println(s);
			 for (Rank r : Rank.values()) {
			     System.out.print(r + " of " );
			     System.out.print(s + " ");
			 }
		 }
		
//		 for (Rank r : Rank.values()) {
//		     System.out.println(r);
//		 }
		
//		for (Cards card : deck)
//		{ 
//		    System.out.println(card.rank() + " of " +  card.suit() + ",");  
//		} 
	}

}
