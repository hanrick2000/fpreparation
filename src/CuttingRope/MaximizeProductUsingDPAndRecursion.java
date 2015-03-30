/*
 * Question: Given a rope of length n meters, cut the rope in different parts of integer lengths in a way 
 * that maximizes product of lengths of all parts. You must make at least one cut. 
 * Assume that the length of rope is more than 2 meters.

Question and Answer Source: http://www.geeksforgeeks.org/dynamic-programming-set-36-cut-a-rope-to-maximize-product/

Examples:

Input: n = 2
Output: 1 (Maximum obtainable product is 1*1)

Input: n = 3
Output: 2 (Maximum obtainable product is 1*2)

Input: n = 4
Output: 4 (Maximum obtainable product is 2*2)

Input: n = 5
Output: 6 (Maximum obtainable product is 2*3)

Input: n = 10
Output: 36 (Maximum obtainable product is 3*3*4)
 * 
 */

package CuttingRope;

import java.util.Scanner;

public class MaximizeProductUsingDPAndRecursion {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
	    try{
	    	System.out.println("Enter the length of the rope");
	    	int n = in.nextInt();
	    	System.out.println("Max Product using intelligent and most efficient algorithm: "+usingIntelligentAlgorithm(n));
	    	System.out.println("Max Product possible using recursion is: "+maxProductUsingRecursion(n));
	    	System.out.println("Max Product possible using DP is: "+maxProductUsingDP(n));
	    }
	    finally{
	    	in.close();
	    }
	}
	private static int usingIntelligentAlgorithm(int n) {
/*
 * Algorithm:
 * If we see some examples of this problems, we can easily observe following pattern.
The maximum product can be obtained be repeatedly cutting parts of size 3 while size is greater than 4, 
keeping the last part as size of 2 or 3 or 4. For example, n = 10, the maximum product is obtained by 3, 3, 4. 
For n = 11, the maximum product is obtained by 3, 3, 3, 2.
 */
		
		
		
		// n equals to 2 or 3 must be handled explicitly
		   if (n == 2 || n == 3) 
			   return (n-1);
		 
		   // Keep removing parts of size 3 while n is greater than 4
		   int res = 1;
		   while (n > 4)
		   {
		       n -= 3;
		       res *= 3; // Keep multiplying 3 to res
		   }
		   return (n * res); // The last part multiplied by previous parts
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n/3)
	 * Space Complexity = O(1)
	 */
	
	
	
	private static int maxProductUsingDP(int n) {
		int[] val=new int[n+1];
		   val[0] = val[1] = 0;
		  
		   // Build the table val[] in bottom up manner and return
		   // the last entry from the table
		   for (int i = 1; i <= n; i++)
		   {
		      int maxValue = 0;
		      for (int j = 1; j <= i/2; j++)
		         maxValue = Math.max(maxValue, Math.max((i-j)*j, j*val[i-j]));
		      val[i] = maxValue;
		   }
		   return val[n];
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n^2) where n = length of rope
	 * Space Complexity = O(n) where n = length of rope
	 */
	
	
	
	// The main function that returns maximum product obtainable
	// from a rope of length n
	public static int maxProductUsingRecursion(int n)
	{
/*
 * Algorithm:
We can get the maximum product by making a cut at different positions and comparing the values obtained
after a cut. We can recursively call the same function for a piece obtained after a cut.

Let maxProd(n) be the maximum product for a rope of length n. maxProd(n) can be written as following.

maxProd(n) = max(i*(n-i), maxProdRec(n-i)*i) for all i in {1, 2, 3 .. n}
 * 
 */
	    // Base cases
	    if (n == 0 || n == 1) 
	    	return 0;
	 
	    // Make a cut at different places and take the maximum of all
	    int maxValue = 0;
	    for (int i = 1; i < n; i++)
	      maxValue = Math.max(maxValue, Math.max(i*(n-i), maxProductUsingRecursion(n-i)*i));
	 
	    return maxValue;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n^2)
	 * Space Complexity = O(1)
	 */
}
