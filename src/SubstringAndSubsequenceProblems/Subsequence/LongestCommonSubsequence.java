/*
Question: Find the longest common subsequence between two strings

Question and Answer Source: http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/

Algortihm: 1. declare a matrix of s1.length()+1 and s2.length()+1.
              +1 is to store the results of the previous matches
           2. initialize row = 0 OR column = 0 to 0 which indicates that the previous matches was 0
           3. for i=1 to s1.length+1 
           		for j=1 to s2.length+1
           			if(s1.charAt(i-1)==s2.charAt(j-1))
           				dp[i][j]= dp[i-1][j-1]+1 // current match = previous match +1 
           			else
           				dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]) 
           			result = max(result,dp[i][j])
           4. return result				
           		// if the characters don't then the current matches = max of(previous matches)
           				
*/

package SubstringAndSubsequenceProblems.Subsequence;

import java.util.Scanner;


public class LongestCommonSubsequence {
	
	
	private static int[][] dp;  // matrix to store the match results
	 
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("LONGEST COMMON SUBSEQUENCE PROGRAM");
			System.out.println("Enter the two strings");
			String s1 = in.nextLine();
			String s2 = in.nextLine();
			System.out.println("The Longest common SUBSTRING using DP is: "+usingDP(s1,s2));

			// Printing the Logest Common Subsequence
			int lengthOfLCSubSequence = usingDP(s1,s2);
			// we will construct a String of LCS from right to left. Hence we will use char array
			// instead of using StringBuilder which is used to construct the string from left to right
			
			char[] LCSubSequence = new char[lengthOfLCSubSequence];
			
			// pass this char array along with the matrix and 2 strings to get the result of matches
			String longestCommonSubsequence = buildLCSubsequence(LCSubSequence,s1,s2);
			
			System.out.println("The Longext Common SubSequence is: "+longestCommonSubsequence);
		}
		finally{
			in.close();
		}
	}



	private static int usingDP(String s1, String s2) {
	        
	        dp = new int[s1.length()+1][s2.length()+1];  // additional +1 to store the previous match result which is 0
	        
	        // fill the row with s1
	        for(int i=0;i<(s1.length()+1);i++)
	            dp[i][0] = 0;
	            
	        // fill the column with s2
	        for(int j=0;j<(s2.length()+1);j++)
	            dp[0][j] = 0;
	        
	         
	        int result = 0; // to store the length of MAX COMMON SUBSEQUENCE MATCH
	        
	        // fill the remaining rows and columns based on matches
	        for(int i=1;i<(s1.length()+1);i++){
	            for(int j=1;j<(s2.length()+1);j++){
	                
	                // if current characters match then the length of the substring is previous matches + 1
	                if(s1.charAt(i-1)==s2.charAt(j-1))
	                    dp[i][j] = dp[i-1][j-1]+1;
	                
	                else  // if doesnt match then current match = Max of (previous matches)
	                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
	                    
	                result = Math.max(result,dp[i][j]);  // this is to check the maximum match found
	                
	            }
	        }
	        
	        return result;
	    }
	
	 private static String buildLCSubsequence(char[] LCSubSequence, String s1, String s2) {
			
		 
		 	int i = s1.length();
		 	int j = s2.length();
		 	
		 	int index = LCSubSequence.length-1;
		 	
		 	while(i>0 && j>0){ // greater than 0 because there is nothing at 0th row and 0th column in the match matrix
		 	
		 		if(s1.charAt(i-1)==s2.charAt(j-1)){// -1 because i and j start from their respective lengths
		 			// append the character
		 			LCSubSequence[index]=s1.charAt(i-1);
		 			// decrement the index
		 			index--;
		 			// decrement the i and j pointers
		 			i--;
		 			j--;
		 		}
		 		
		 		// if the characters do not match then go in the max direction in the match matrix
		 		
		 		else if(dp[i-1][j]>dp[i][j-1])  // HERE CONSIDER THE dp TABLE FOR MATCHING. THE ABOVE WE CONSIDERED
		 										// THE TWO STRINGS
		 			i--;
		 		
		 		else
		 			j--;
		 	}
		 	
		 	return String.valueOf(LCSubSequence);  // convert char array to string and return
		}
}
