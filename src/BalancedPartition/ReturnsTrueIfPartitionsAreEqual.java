/*
 * Question:
 * Partition problem is to determine whether a given set can be partitioned into two subsets
 *  such that the sum of elements in both subsets is same.

Question and Answer Source: http://www.geeksforgeeks.org/dynamic-programming-set-18-partition-problem/

Example:

a[] = {1, 5, 11, 5}
Output: true 
The array can be partitioned as {1, 5, 5} and {11}

a[] = {1, 5, 3}
Output: false 
The array cannot be partitioned into equal sum sets.
 * 
 * 
Algorithm:
Following are the two main steps to solve this problem:
1) Calculate sum of the array. If sum is odd, there can not be two subsets with equal sum, so return false.
2) If sum of array elements is even, calculate sum/2 and find a subset of array with sum equal to sum/2.
 */

package BalancedPartition;

public class ReturnsTrueIfPartitionsAreEqual {
	public static void main(String[] args) {
		int[] a = new int[]{3, 1, 1, 2, 2, 1};
		System.out.println("Equal partitions using DP: "+usingDP(a, a.length));
		System.out.println("Equal partitions using Recursion: "+usingRecursion(a, a.length));
	}
	
	public static boolean usingDP(int[] a, int n){
/*
Algorithm:
Dynamic Programming Solution
The problem can be solved using dynamic programming when the sum of the elements is not too big. 
We can create a 2D array part[][] of size (sum/2)*(n+1). And we can construct the solution in bottom up manner 
such that every filled entry has following property

part[i][j] = true if a subset of {a[0], a[1], ..a[j-1]} has sum 
             equal to i, otherwise false
*/
		
	    int sum = 0;
	    int i, j;
	   
	    // Calculate sum of all elements
	    for (i = 0; i < n; i++)
	      sum += a[i];
	     
	    if (sum%2 != 0)  
	       return false;
	   
	    boolean[][] part= new boolean[sum/2+1][n+1];
	     
	    // initialize top row as true
	    for (i = 0; i <= n; i++)
	      part[0][i] = true;                      // If sum = 0 then every element can form the sum by not choosing that every element, hence true
	       
	    // initialize leftmost column, except part[0][0], as 0
	    for (i = 1; i <= sum/2; i++)
	      part[i][0] = false;                     // If n = 0 then no elements to choose from to form the sum hence false
	      
	     // Fill the partition table in bottom up manner 
	     for (i = 1; i <= sum/2; i++)  
	     {
	       for (j = 1; j <= n; j++)  
	       {
	         part[i][j] = part[i][j-1];
	         if (i >= a[j-1])
	           part[i][j] = part[i][j] || part[i - a[j-1]][j-1];
	       }        
	     }    
	      
	    /* // uncomment this part to print table 
	     for (i = 0; i <= sum/2; i++)  
	     {
	       for (j = 0; j <= n; j++)  
	          printf ("%4d", part[i][j]);
	       printf("\n");
	     } */
	      
	     return part[sum/2][n];
	}
	/*
	 * Analysis:
	 * Time Complexity = O(nN) where n = number of elements in the array and N = total sum of the array
	 * Space Complexity = O(nN) where n = number of elements in the array and N = total sum of the array 
	 */
	
	
	
	
	
			// Returns true if a[] can be partitioned in two subsets of
			// equal sum, otherwise false
			public static boolean usingRecursion (int a[], int n){
				/*
				 * Algorithm:
				 * Recursive Solution
				Following is the recursive property of the second step mentioned above.

				Let isBalancedSum(a, n, sum/2) be the function that returns true if 
				there is a subset of a[0..n-1] with sum equal to sum/2

				The isBalancedSum problem can be divided into two subproblems
				 a) isBalancedSum() without considering last element 
				    (reducing n to n-1)
				 b) isBalancedSum considering the last element 
				    (reducing sum/2 by a[n-1] and n to n-1)
				If any of the above the above subproblems return true, then return true. 
				isBalancedSum (a, n, sum/2) = isBalancedSum (a, n-1, sum/2) ||
				                              isBalancedSum (a, n-1, sum/2 - a[n-1])
				 */
				
			    // Calculate sum of the elements in array
			    int sum = 0;
			    for (int i = 0; i < n; i++)
			       sum += a[i];
			 
			    // If sum is odd, there cannot be two subsets with equal sum
			    if (sum%2 != 0)
			       return false;
			 
			    // Find if there is subset with sum equal to half of total sum
			    return isBalancedSum (a, n, sum/2);
			}
	public static boolean isBalancedSum(int[] a, int n, int sum){

		// Base Cases
		   if (sum == 0)
		     return true;
		   if (n == 0 && sum != 0)
		     return false;
		 
		   // If last element is greater than sum, then ignore it
		   if (a[n-1] > sum)
		     return isBalancedSum (a, n-1, sum);
		 
		   /* else, check if sum can be obtained by any of the following
		      (a) including the last element
		      (b) excluding the last element
		   */
		   return isBalancedSum (a, n-1, sum) || isBalancedSum (a, n-1, sum-a[n-1]);
		}
	/*
	 * Analysis:
	 * Time Complexity = O(nN) where n = number of elements in the array and N = total sum of the array
	 * Space Complexity = O(1) 
	 */
}
