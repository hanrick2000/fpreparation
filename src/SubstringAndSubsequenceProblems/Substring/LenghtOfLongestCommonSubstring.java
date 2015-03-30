/*
Question: Find the longest common SUBSTRING between two strings

Question and Answer Source: http://www.geeksforgeeks.org/longest-common-substring/
	
Algorithm: Using Dynamic Programming
	1. declare a dp matrix of length [row+1][column+1] 
    2. Fill the 0th row and 0th column with 0 indicating that the previous matches is 0
    3. for i = 1 to s1.length+1
    		for j=1 to s2.length+1
    			if(s1[i-1]==s2[j-1])
    				then dp[i][j] = dp[i-1][j-1]+1;  // current character matches then the totalmatches are previous matches + 1	
    			else
    				dp[i][j]=0 since the characters donot match
    			result = max(result,dp[i][j])
    				
    4. return result
 */   					
package SubstringAndSubsequenceProblems.Substring;

import java.util.Scanner;

public class LenghtOfLongestCommonSubstring {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("LONGEST COMMON SUBSTRING PROGRAM");
			System.out.println("Enter the two strings");
			String s1 = in.nextLine();
			String s2 = in.nextLine();
			System.out.println("The Longest common SUBSTRING using DP is: "+usingDP(s1,s2));
		}
		finally{
			in.close();
		}
	}

	 private static int usingDP(String s1, String s2) {
	        
	        int[][] dp = new int[s1.length()+1][s2.length()+1];  
	        // additional +1 to store the previous match result which is 0
	        
	        // fill the row with s1
	        for(int i=0;i<(s1.length()+1);i++)
	            dp[i][0] = 0;
	            
	        // fill the column with s2
	        for(int j=0;j<(s2.length()+1);j++)
	            dp[0][j] = 0;
	        
	         
	        int result = 0; // to store the length of MAX COMMON SUBSTRING MATCH
	        
	        // fill the remaining rows and columns based on matches
	        for(int i=1;i<(s1.length()+1);i++){
	            for(int j=1;j<(s2.length()+1);j++){
	                
	                // if current characters match then the length of the substring is previous matches + 1
	                if(s1.charAt(i-1)==s2.charAt(j-1))
	                    dp[i][j] = dp[i-1][j-1]+1;
	                
	                else  // if doesnt match then fill with 0
	                    dp[i][j] = 0;
	                    
	                result = Math.max(result,dp[i][j]);  // this is to check the maximum match found
	                
	            }
	        }
	        //printTable(dp);
	        return result;
	    }

	/*private static void printTable(int[][] dp) {
		for(int i=0;i<dp.length;i++){
			for(int j=0;j<dp[0].length;j++)
				System.out.print(dp[i][j]+" ");
			System.out.println();
		}
	}*/
}
