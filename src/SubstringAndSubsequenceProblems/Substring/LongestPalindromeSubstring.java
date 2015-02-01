

package SubstringAndSubsequenceProblems.Substring;

/*
Question : Find the longest palindrome substring using Dynamic Programming
		   http://www.careercup.com/question?id=245679

Question & Answer Source: http://www.geeksforgeeks.org/longest-palindromic-substring-set-2/

Algorithm:
1. we can reverse the String
2. Use the Longest Common Substring Algorithm for comparison between origina and reverse Strings to
   find the Longest Palindrome Substring

*/


import java.util.Scanner;

public class LongestPalindromeSubstring {
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the string to check for Longest Palindrome SUBSTRING");
			String orig = in.nextLine();
			
			// Create a reverse string
			StringBuilder rev = new StringBuilder();
			for(int i=orig.length()-1;i>=0;i--)
				rev.append(orig.charAt(i));
			
			
			/* Using Intelligent Algorithm
			 * INTELLIGENT ALGORITHM BECAUSE THE SPACE COMPLEXITY OF THIS ALGORITHM IS O(1)
			 */
			usingIntelligentAlgorithm(orig);
			/*
			 * VERY VERY IMPORTANT:
			 * We cannot use Longest Common Substring Algorithm to find the Longest Palindrome Substring
			 * like we did for SubSequence Problem.
			 * 
			 * The reason being that, for inputs such as "geeksforgeeksrof" it gives output as 3
			 * whereas the Longest Palindrome SubString length is 2 which is "ee"
			 * The reason why it gives wrong output is because it compares "for" and "rof" in the input "geeksforgeeksrof"
			 * and gives output as 3 whereas for and rof individually are wrong answers
			 * 
			 */
		}
		finally{
			in.close();
		}
		}

		private static void usingIntelligentAlgorithm(String orig) {
		
			
			// This function prints the longest palindrome substring (LPSubstring)
			// of str[]. It also returns the length of the longest palindrome substring
			
			int maxLength = 1; // The length of the LPSubstring is atleast 1
			
			int start = 0;
			
			int low = 0;
			int high = 0;
			
			for(int i=1;i < orig.length();i++){   // start from 1 to string.length()
				
				// Find the longest even length palindrome with center points
		        // as i-1 and i.
				
				low = i-1;
				high = i;
				while(low >=0 && high < orig.length() && orig.charAt(low)==orig.charAt(high)){ // check whether it is a palindrome
					
					if(high - low + 1 > maxLength){
						start = low;
						maxLength=high-low+1;
					}
					--low;
					++high;
				}
				
				
				// Find the longest odd length palindrome with center 
		        // point as i
				
				low = i-1;
				high = i+1;
				
				while(low >=0 && high < orig.length() && orig.charAt(low)==orig.charAt(high)){ // check whether it is a palindrome
					
					if(high - low + 1 > maxLength){
						start = low;
						maxLength=high-low+1;
					}
					--low;
					++high;
					
				}
				
				
			}
			
			
			// Print the palindrome string
			System.out.println("Longest Palindrome Substring is using Intelligent Algorithm: ");
			System.out.println(orig.substring(start,start+maxLength));
			
			// Print the length of the palindrome string
			System.out.println("The length of the longest Palindrome Substring is using Intelligent Algorithm: "+maxLength);
			
		}
/*
 * Analysis:
 * Time Complexity = O(n^2)
 * Space Complexity = O(1)
 * 
 * 
 */
}
