/*
Question: Write a function that takes a string and returns true if the entire string is a palindrome,
otherwise return false. The function should be case-insensitive and ignore any whitespace or punctuation. 

For example, return true for: 
"A man, a plan, a canal: Panama."

Question & Solution Source: http://www.careercup.com/question?id=16239684

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
		
		if(s.length()==0||s==null)
			return true;
		int start = 0;
		int end = s.length()-1;
		while(start<end){
			
			if(!isAlphabet(s.charAt(start))){
				start++;
				continue;
			}
			if(!isAlphabet(s.charAt(end))){
				end--;
				continue;
			}
			
			if(s.charAt(start)==s.charAt(end)){
				start++;
				end--;
			}
			else // s.charAt(start)!=s.charAt(end)
				return false;
			
		}
		return true;
		
		}

	private static boolean isAlphabet(char c) {
		int value = (int)c;
		if(value >=97 && value <=122)
			return true;
		else
			return false;
	}
	/*
	 * Remember the following properties of ASCII table:
	 * 0 to 9 = 48 to 57 both inclusive
	 * A to Z = 65 to 90 both inclusive
	 * a to z = 97 to 122 both inclusive
	 * NULL = 0 in ascii table
	 */
}
/*
 * Analysis:
 * Time Complexity  = O(n) where n = length of the input string
 * Space Complexity = O(1)
 */
