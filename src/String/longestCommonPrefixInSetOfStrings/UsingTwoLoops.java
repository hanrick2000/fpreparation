/*
Question: Longest Common Prefix in an array of Strings (Facebook Interview Question)

Question and Answer Source: http://codereview.stackexchange.com/questions/46965/longest-common-prefix-in-an-array-of-strings

Other Sources: https://miafish.wordpress.com/2015/02/17/leetcode-oj-c-longest-common-prefix/
http://www.programcreek.com/2014/02/leetcode-longest-common-prefix-java/ 
*/
package String.longestCommonPrefixInSetOfStrings;

import java.util.Scanner;

public class UsingTwoLoops {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of strings");
			int n = in.nextInt();
			String[] strArray = new String[n];
			for(int i=0;i<n;i++)
				strArray[i]=in.next();
			System.out.println("The longest common prefix among the set of strings is: "+longestCommonPrefix(strArray));
		}
		finally{
			in.close();
		}
	}

	private static String longestCommonPrefix(String[] strArray) {
		
		
		/*
		 * Algorithm:
		 * To solve this problem, we need to find the two loop conditions. 
		 * One is the length of the shortest string. The other is iteration over every element of the string array.
		 */
		
		
		if (strArray.length == 0 || strArray==null) {
	        return null;   // Or maybe return empty String
	    }
		// consider that the first String is the smallest String
	    for (int prefixLen = 0; prefixLen < strArray[0].length(); prefixLen++) {
	        char c = strArray[0].charAt(prefixLen);        // get each character of the smallest String
	        for (int i = 1; i < strArray.length; i++) {    // loop from the second string to all the strings in the String array
	            if ( prefixLen >= strArray[i].length() ||
	            		strArray[i].charAt(prefixLen) != c ) {  // match all the characters of the minLength string with characters 
	            												// of all the strings present in the String array
	                // Mismatch found
	                return strArray[i].substring(0, prefixLen); // from 0 to mismatch index (because before mismatch all characters do match)
	            }
	        }
	    }
	    return strArray[0];
	}
}
/*
Analysis:
Worst-case time complexity: O(n m) to scan every character in every string
Space complexity: O(1)
*/