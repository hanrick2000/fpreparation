/*
Question: Solve 0-1 Knapsack Question

Question Source: http://www.careercup.com/question?id=134810

Answer Source: http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
*/
package Knapsack01ByDP;

import java.util.Scanner;

public class UsingDPAndRecursion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of weights and corresponding values");
			int n=in.nextInt();
			int[] weights = new int[n];
			int[] values = new int[n];
			System.out.println("Enter the weights");
			for(int i=0;i<n;i++)
				weights[i]=in.nextInt();
			System.out.println("Enter the values");
			for(int i=0;i<n;i++)
				values[i]=in.nextInt();
			System.out.println("Enter the total weight KNAPSACK can carry");
			int Kweight=in.nextInt();
			System.out.println("Using Recursion: "+recursiveSoln(Kweight,weights,values,n));
			System.out.println("Using Dynamic Programming: "+dpSoln(Kweight,weights,values,n));
		}
		finally{
			in.close();
		}
	}

	private static int dpSoln(int Kweight, int[] weights, int[] values, int n) {
		
		// EXTREME CASE
		if (n == 0 || Kweight == 0 || weights.length==0 || values.length==0 || weights==null||values==null)
		       return 0;
		
		int[][] dp = new int[n+1][Kweight+1];   // VERY IMP : dp matrix comprises of "Number of ITEMS" and "TOTAL KNAPSACK WEIGHT" 
		
		// if the ITEM=0 and Knapsack weight is variable
		for(int sackWt=0;sackWt<(Kweight+1);sackWt++)
			dp[0][sackWt]=0;
		
		// if the Kweight=0 and ITEM is variable
		for(int item=0;item<(n+1);item++)
			dp[item][0]=0;
		
		for(int item=1;item<=n;item++){
			for(int sackWt=1;sackWt<=Kweight;sackWt++){
				
				if(weights[item-1]>sackWt)                  // VERY IMP CONDITION
					dp[item][sackWt] = dp[item-1][sackWt];
				
				else  // (weights[item-1] <= Kweight)
					dp[item][sackWt] = Math.max(
							values[item-1] + dp[item-1][sackWt-weights[item-1]],           // INCLUDED
						    dp[item-1][sackWt]											   // NOT INCLUDED
						    );
				
			}
		}
		
		return dp[n][Kweight];
		
	}
	/*
	 * Analysis:
	 * Time Complexity = O(items*KnapSackCapacity)
	 * Space Complexity = O(items*KnapSackCapacity)
	 */

	private static int recursiveSoln(int Kweight, int[] weights, int[] values, int n) {
		
		// Base Case
		   if (n == 0 || Kweight == 0)
		       return 0;
		
		// If weight of the nth item is more than Knapsack capacity W, then
		// this item cannot be included in the optimal solution
		   if(weights[n-1]>Kweight)
			   return recursiveSoln(Kweight,weights,values,n-1);
		   
		// Return the maximum of two cases: (1) nth item included (2) not included
		   else
			   return Math.max(
					   values[n-1]+recursiveSoln(Kweight-weights[n-1], weights, values, n-1),  // included
					   recursiveSoln(Kweight, weights, values, n-1)                            // NOT included
					   );
					   		   
	}
	/*
	 * Analysis:
	 * Time Complexity = 2^n where n = items. Hence Exponential
	 * Space Complexity = O(1) + stack frames used for recursive calls
	 */
}
