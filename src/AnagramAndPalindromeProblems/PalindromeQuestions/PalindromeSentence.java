/*
Question:Given a string containing letter, digit, and other characters, write a function to 
check palindrome for only letter and digit. The implementation need to be in-place, 
no extra memory is allowed to create another string or array. 

For example: 

"ABA" is palindrome 
"A!#A" is palindrome 
"A man, a plan, a canal, Panama!" is palindrome


Question & Solution Source: 
http://www.careercup.com/question?id=16239684
http://www.careercup.com/question?id=5085545090777088

Algorithm:

	Convert the string to lower case

	start = 0
	end = s.length()-1
	while(start<end){
		if start is not alphabet
			start++;
			continue;
		if end is not alphabet
			end--;
			continue;
		if(s.charAt(start)==s.charAt(end))
			start++;
			end--;
		else
			return false;
	}
	return true;
	
	
*/
package AnagramAndPalindromeProblems.PalindromeQuestions;

import java.util.Scanner;

public class PalindromeSentence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the sentence");
			String s = in.nextLine();
			System.out.println("The sentence is palindrome ? "+isPalindromeSentence(s.toLowerCase()));
		}
		finally{
			in.close();
		}
	}

	private static boolean isPalindromeSentence(String s) {
		// Extreme Case
		if(s.length()==0||s==null)
			return true;
		
		
		int start = 0;
		int end = s.length()-1;
		while(start<end){
		
			/*
			 * VERY IMP NOTE:
			 * 1. AND CONDITION between NOT-alphabet AND NOT-letter
			 * 2. continue after every skipped character
			 */
			if(!isAlphabet(s.charAt(start)) && !isLetter(s.charAt(start))){ // NOT-alphabet AND NOT-letter then skip
				start++;
				continue;
			}
			
			if(!isAlphabet(s.charAt(end)) && !isLetter(s.charAt(end))){ // NOT-alphabet AND NOT-letter then skip
				end--;
				continue;
			}
			
			if(s.charAt(start)==s.charAt(end)){
				start++;
				end--;
				continue;
			}
			else // s.charAt(start)!=s.charAt(end)
				return false;
			
		}
		return true;
		
		}

	private static boolean isAlphabet(char c) {
		int value = (int)c;
		if(value >=(int)'a' && value <=(int)'z')
			return true;
		else
			return false;
	}
	private static boolean isLetter(char c) {
		int value = (int)c;
		if(value >=(int)'0' && value <=(int)'9')
			return true;
		else
			return false;
	}
	/*
	 * Remember the following properties of ASCII table:
	 * 0 to 9 = 48 to 57 both inclusive
	 * A to Z = 65 to 90 both inclusive
	 * a to z = 97 to 122 both inclusive
	 * NULL = 0 in ASCII table
	 */
}
/*
 * Analysis:
 * Time Complexity  = O(n) where n = length of the input string
 * Space Complexity = O(1)
 */
