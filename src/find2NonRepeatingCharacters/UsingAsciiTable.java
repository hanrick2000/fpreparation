package find2NonRepeatingCharacters;

import java.util.Scanner;

/*
 * NOTE: This method is applicable for not just 2 NON-repeating characters but for n Non-repeating characters.
*/

public class UsingAsciiTable {
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		try{
			System.out.println("Enter the string to be processing for non-repeatig characters");
			String s = in.nextLine();
			nonRepeatingCharacters(s);
		}
		finally{
			in.close();
		}
	}

	private static void nonRepeatingCharacters(String s) {
	    int[] asciiTable = new int[256];   // integer array. ASCII Table
	    for(int i=0;i<s.length();i++){
	    	asciiTable[s.charAt(i)]++;// in integer array we are storing characters(Ofcourse asii value of characters)
	    	// char(lower datatype) to int(higher datatype) takes place
            // automatically in JAVA. Since there won't be an overflow from char to int
	    }
	    
	    // check for the count of each character in the array
	    for(int i=0;i<s.length();i++){
	    	if(asciiTable[s.charAt(i)]==1){
	    		char c = s.charAt(i);
	    		System.out.println("The non-repeating character is: "+c);
	    	}
	    }
	}

}
/*
Analysis:
	Time Complexity = O(n)
	Space Complexity = O(n), actually O(256) which is constant 
*/