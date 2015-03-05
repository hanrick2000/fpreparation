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

*/
package Array.MaxDifferenceBetweenTwoElementsInArray;

import java.util.Scanner;

public class MaxStockProfit {
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
		
		int maxProfit = a[1]-a[0];
		int minStockPrice = a[0];
		
		for(int i=1;i<a.length;i++){
			maxProfit = Math.max(a[i]-minStockPrice,maxProfit);
			minStockPrice = Math.min(minStockPrice,a[i]);
		}	
		
		return maxProfit;
		}
}
/*
 * Analysis:
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */
