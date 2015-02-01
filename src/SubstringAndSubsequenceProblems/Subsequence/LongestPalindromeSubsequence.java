package SubstringAndSubsequenceProblems.Subsequence;

/*
Question : Find the longest palindrome subsequence using Recursion and Dynamic Programming

Question & Answer Source: http://www.geeksforgeeks.org/dynamic-programming-set-12-longest-palindromic-subsequence/

Algorithm:
1. if single character in the string then palindrome and 1 character match
2. If 2 characters in the string and j==i+1 then palindrome and 2 characters match
3. If first and last characters match then s[i]==[length-1] then s[i+1][length-2] +2 characters match 

*/

import java.util.Scanner;

public class LongestPalindromeSubsequence {
	
	public static void main(String[] args) {
		
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the string to check for Longest Palindrome Subsequence");
		String orig = in.nextLine();
		
		// Create a reverse string
		StringBuilder rev = new StringBuilder();
		for(int i=orig.length()-1;i>=0;i--)
			rev.append(orig.charAt(i));
		
		System.out.println("Using the longest common subsequence algorithm: "+usingLCSubSequence(orig,rev.toString()));
		System.out.println("Using Dynamic Programming: "+usingDP(orig));
		System.out.println("Using Recursion: "+usingRecursion(orig));
	}
	finally{
		in.close();
	}
	}

	private static int usingLCSubSequence(String orig, String rev) {
		
		/*
		 * Algorithm:
This problem is close to the Longest Common Subsequence (LCS) problem. In fact, we can use LCS as a subroutine to solve this problem. Following is the two step solution that uses LCS.
1) Reverse the given sequence and store the reverse in another array say rev[0..n-1]
2) LCS of the given sequence and rev[] will be the longest palindromic sequence.
This solution is also a O(n^2) solution.
		 */
		
		
		int[][] dp = new int[orig.length()+1][rev.length()+1]; // dp array of length +1 of both strings to store the result of previous matches
		
		// fill the 0th row with 0 indicating no previous matches
		for(int i=0;i<(orig.length()+1);i++)
			dp[i][0] = 0;
		
		// fill the 0th column with 0 indicating no previous matches
		for(int j=0;j<(rev.length()+1);j++)
			dp[0][j] = 0;
		
		int result = 0; // stores the longest common subsequence found in the entire matrix
		
		// fill the remaining rows and columns
		
		for(int i=1;i<(orig.length()+1);i++){
			for(int j=1;j<(rev.length()+1);j++){
				
				if(orig.charAt(i-1)==rev.charAt(j-1))
					dp[i][j] = dp[i-1][j-1]+1;
				
				else
					dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
				
				result = Math.max(result, dp[i][j]);
				
			}
		}
		return result;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n^2)
	 * Space Complexiy = O(n^2)
	 */
	private static int usingDP(String s) {
		int[][] dp = new int[s.length()][s.length()];
		
		// if the length of the string is 1 then fill 1 in those boxes
		for(int i=0;i<s.length();i++)
			dp[i][i] = 1;
		
		// if the length of the string is 2 to string.length then do the following
		int end = 0; 
		for(int len=2;len<=s.length();len++){ // len is length of the substring
			
			for(int start=0; start<s.length()-len+1;start++){
				end = start+len-1;
				if(s.charAt(start)==s.charAt(end) && len==2)
					dp[start][end]=2;
				else if(s.charAt(start)==s.charAt(end))
					dp[start][end] = dp[start+1][end-1] + 2;
				else
					dp[start][end] = Math.max(dp[start][end-1],dp[start+1][end]);
			}
			
		}
		return dp[0][s.length()-1];
		
	}
/*
 * Analysis:
 * Time Complexity = O(n^2)
 * Space Complexiy = O(n^2)
 */
	private static int usingRecursion(String s) {
		if(s==null||s.length()==0)
			return -1;
		
		if(s.length()==1)
			return 1;
		
		if(s.length()==2 && s.charAt(0)==s.charAt(1))
			return 2;
		
		if(s.charAt(0)==s.charAt(s.length()-1))
			return usingRecursion(s.substring(1, s.length()-1)) + 2;
		
		else               //if(s.charAt(0)!=s.charAt(s.length()-1))
			return Math.max(  usingRecursion(s.substring(1, s.length())),usingRecursion(s.substring(0,s.length()-1))) ;
		
		
		}
	/*
	 * Analysis:
	 * Time Complexity = O()
	 * Space Complexiy = O(1)
	 */
}
