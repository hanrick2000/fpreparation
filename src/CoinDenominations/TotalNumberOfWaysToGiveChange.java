/*
 * Question: Given a value N, if we want to make change for N cents, 
 * and we have infinite supply of each of denominatons = { S1, S2, .. , Sm} valued coins, 
 * how many ways can we make the change? The order of coins doesn’t matter.

Example: For N = 4 and denominatons = {1,2,3}, there are four solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}. 
So output should be 4. For N = 10 and denominatons = {2, 5, 3, 6}, there are 
five solutions: {2,2,2,2,2}, {2,2,3,3}, {2,2,6}, {2,3,5} and {5,5}. 
So the output should be 5.
 * 
 * Question and Answer Source: http://www.geeksforgeeks.org/dynamic-programming-set-7-coin-change/
 */
package CoinDenominations;

public class TotalNumberOfWaysToGiveChange {
	public static void main(String[] args) {
		int[] denominations = new int[]{1,2,3};
		int total = 4;
		System.out.println("Total number of ways using Recursion: "+countUsingRecursion(denominations,denominations.length,total));
		System.out.println("Total number of ways using DP: "+countUsingDP(denominations,denominations.length,total));
	}
	
	public static int countUsingDP(int[] denominatons, int len, int total){
		int i, j, x, y;
		 
	    // We need total+1 rows as the table is consturcted in bottom up manner using 
	    // the base case 0 value case (total = 0)
	    int[][] table=new int[total+1][len];
	    
	    // Fill the enteries for 0 value case (total = 0)
	    for (i=0; i<len; i++)
	        table[0][i] = 1;     // When total is 0 then 1 way to get the answer and that is NOT to include any coin from denominations
	 
	    // Fill rest of the table enteries in bottom up manner  
	    for (i = 1; i < total+1; i++)
	    {
	        for (j = 0; j < len; j++)
	        {
	            // Count of solutions INCLUDING denominatons[j]
	            x = (i-denominatons[j] >= 0)? table[i - denominatons[j]][j]: 0;
	 
	            // Count of solutions EXCLUDING denominatons[j]
	            y = (j >= 1)? table[i][j-1]: 0;
	 
	            // total count
	            table[i][j] = x + y;
	        }
	    }
	    return table[total][len-1];
	}
	/*
	 * Analysis:
	 * Time Complexity = O(lengthOfDenominationsArray * totalAmount)
	 * Space Complexity = O(lengthOfDenominationsArray * totalAmount)
	 */
	
	// Returns the count of ways we can sum  denominatons[0...len-1] coins to get sum total
	public static int countUsingRecursion(int[] denominatons, int len, int total)
	{
	    // If total is 0 then there is 1 solution (do not include any coin)
	    if (total == 0)
	        return 1;
	     
	    // If total is less than 0 then no solution exists
	    if (total < 0)
	        return 0;
	 
	    // If there are no coins and total is greater than 0, then no solution exist
	    if (len <=0 && total >= 1)
	        return 0;
	 
	    // count is sum of solutions (i) including denominatons[len-1] (ii) excluding denominatons[len-1]
	    return countUsingRecursion( denominatons, len - 1, total ) + countUsingRecursion( denominatons, len, total-denominatons[len-1] );
	}
	/*
	 * Analysis:
	 * Time Complexity = O(lengthOfDenominationsArray * totalAmount)
	 * Space Complexity = O(1)
	 */
}
