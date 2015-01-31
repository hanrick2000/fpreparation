/*
Question: Find the longest increasing subsequence in the array:
	10,22,9,33,21,50,41,60,80
Question Source: http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/

	Solution Source: http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
		https://www.youtube.com/watch?v=U-xOVWlcgmM&index=3&list=PL962BEE1A26238CA3
	
*/
package dynamicProgramming;

import java.util.Scanner;

public class LongestIncreasingSubsquence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("This program will find the longest increasing subsequence in an array of negative"
					+ "and positive integers");
			System.out.println("Enter the size of the array");
			int n = in.nextInt();
			System.out.println("Enter the elements of the array");
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("Using Dynamic Programming: "+usingDynamicProgramming(a));
			System.out.println("Using Recursion algorithm: "+usingRecursionSolution(a,a.length));
		}
		finally{
			in.close();
			}
	}

	 public static int usingRecursionSolution(int[] a, int n){
	       
		 if(a.length==0 || a==null)
	    		return -1;
		 /*
		  * Algorithm: http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
		  */
		 
		 int maxDiff=1; // the maxDifference would at least be 1
	       
	     return usingRecursionSolution(a,n,maxDiff);
	        
	    }
	    private static int usingRecursionSolution(int[] a, int n, int maxDiff) {
	    	if(n==1)
	            return 1;
	            
	        int res=1;
	        int maxEnding = 1;
	        
	        for(int i=1;i<n;i++){
	            res = usingRecursionSolution(a,i,maxDiff);
	            if(a[n-1] > a[i-1])
	                maxEnding = Math.max(maxEnding, res+1);
	        }
	        
	        if(maxEnding>maxDiff)
	            maxDiff = maxEnding;
	        
	        return maxDiff;
	    }
	    /*
	    Analysis:
	    Time Complexity = O(n^2)
	    Space Complexity = O(1)
	    */

	private static int usingDynamicProgramming(int[] a) {
		
		if(a.length==0 || a==null)
    		return -1;
		
		/*
		 * Algorithm: https://www.youtube.com/watch?v=U-xOVWlcgmM&index=3&list=PL962BEE1A26238CA3
		 * 				
		 */
		
		
		int[] dp = new int[a.length];
		dp[0] = a[0];
		
		for(int i=0;i<a.length;i++){
			dp[i]=1;
			for(int j=0;j<i;j++){
				if(a[i] > a[j])
					dp[i] = Math.max(dp[i],1+dp[j]);
			}
		}
		
		int longestIncreasingSubsequenceLength = 0;
		for(int i=0;i<dp.length;i++)
			longestIncreasingSubsequenceLength = Math.max(longestIncreasingSubsequenceLength,dp[i]);
		
		return longestIncreasingSubsequenceLength;
	}
}
