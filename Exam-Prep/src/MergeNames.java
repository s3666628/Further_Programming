public class MergeNames {
    
    public static String[] uniqueNames(String[] names1, String[] names2) {
    		String[] startList = new String[names1.length + names2.length];
            int counter = 0;
            for( int i = 0; i < names1.length; i++)
            {
//              
                
            	startList[counter] = names1[i];
            	System.out.println(names1[i]);
            	
            	startList[counter+1] = names2[i];
            	System.out.println(names2[i]);
            	
            	System.out.println(counter);
            	System.out.println(counter+1);
            	counter+=2;
                
            }

            
            
			return startList;
    }
    
    public static void main(String[] args) {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        System.out.println(String.join(", ", MergeNames.uniqueNames(names1, names2))); // should print Ava, Emma, Olivia, Sophia
    }
}