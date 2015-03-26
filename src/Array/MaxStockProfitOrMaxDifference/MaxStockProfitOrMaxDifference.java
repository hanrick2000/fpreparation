/*
Question: Given a stock prices 20,50,52,10,45,34 and each day the stock 
price will buy and sold in another n days. Calculate the maxProfit.

Question And Answer Source: http://www.careercup.com/question?id=16097677

Algorithm:
We can get max profit when the stock is bought at lowest price and sold at highest price after buying them
Thus, buying will take place before selling
Thus, for the given example, 20,50,52,10,45,34
we will buy when stockPrice=10 and sell when stockPrice=45 to get maxProfit of 35

Hence, this algorithm is same as finding maxDifference (b-a) between two elements in the array
such that b occurs after a.



---------------------------------------- SIMILAR ANOTHER QUESTION ---------------------------------


 Question: Maximum difference between 2 elements in an array such that 2nd element occurs later after 1st ?
 * Question Source: http://www.careercup.com/question?id=6051351341563904
 * 
 
 * 
 * Examples: If array is [2, 3, 10, 6, 4, 8, 1] then returned value should be 8 (Diff between 10 and 2). 
 * If array is [ 7, 9, 5, 6, 3, 2 ] then returned value should be 2 (Diff between 7 and 9)
 * 
 *Solution Source: http://www.geeksforgeeks.org/maximum-difference-between-two-elements/
 *
 * Algorithm:
 * 1. MIN = arr[0]
 * 2. max_diff = arr[1] - MIN
 * 3. FROM i=1 to n
 * 		check for arr[i]-MIN > max_diff. If true then replace max_diff with arr[i]-MIN
 * 		also check for min element in the array. if(arr[i]<MIN) then update MIN with value of arr[i]
 * 

*/
package Array.MaxStockProfitOrMaxDifference;

import java.util.Scanner;

public class MaxStockProfitOrMaxDifference {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements in the STOCK PRICE array");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the STOCK PRICES");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("The MAX PROFIT value is: "+findMaxProfit(a));
		}
		finally{
			in.close();
		}
	}

	private static int findMaxProfit(int[] a) {
		
		if(a.length==0||a==null)
			return -1;
		
		// The array should have at least two elements to represent buying and selling
		if(a.length<2)
			return -1;
		
		
		int minStockPrice = a[0];
		int maxProfit = a[1]-minStockPrice;
		
		for(int i=1;i<a.length;i++){
			maxProfit = Math.max(a[i]-minStockPrice,maxProfit);
			minStockPrice = Math.min(a[i],minStockPrice);
		}	
		
		return maxProfit;
		}
}
/*
 * Analysis:
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */
