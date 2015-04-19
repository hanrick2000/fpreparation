/*
 * Question: Check if a string is a pangram
 * Question Source: http://www.careercup.com/question?id=5699257984090112
 * 
 * Explanation: Pangram is a string which contains all 26 characters of the alphabets.
 * The characters can be repeated but all 26 characters should be included
 * Source: http://www.fun-with-words.com/pang_explain.html
 */


package Pangram;

import java.util.Scanner;

public class CheckIfPangram {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter a string to check for pangram");
			String s = in.nextLine();
			System.out.println("The string is pangram ? "+checkIfPangram(s));
		}
		finally{
			in.close();
		}
	}

	private static boolean checkIfPangram(String s) {
		s = s.toLowerCase(); // convert all characters to lower case
		boolean[] booleanArray = new boolean[26];
		int count=0;       // count number of unique characters visited in the string
		for(char c : s.toCharArray()){
			if(c!=' '&& !booleanArray[c-'a']){         // if not space and not visited previously then visit it
				booleanArray[c-'a']=true;
				count++;
			}
		}
		return (count==26);
	}
	/*
	 * Time Complexity = O(n) where n = length of string
	 * Space Complexity = O(1)
	 */
}
