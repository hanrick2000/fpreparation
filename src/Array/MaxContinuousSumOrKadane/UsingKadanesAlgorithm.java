/*
 * Question : Find the maximum continuous subsequence sum in an array
 * Source: http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
 * 		   https://www.youtube.com/watch?v=hXlv88ddcgw&list=PL962BEE1A26238CA3
 * 
 * Algorithm:
 * Initialize:
    max_so_far = 0
    max_ending_here = 0

Loop for each element of the array
  (a) max_ending_here = max_ending_here + a[i]
  (b) if(max_ending_here < 0)
            max_ending_here = 0
  (c) if(max_so_far < max_ending_here)
            max_so_far = max_ending_here
return max_so_far

Example:
1. Array = -2 -3 -4 -8 -2 -6 -5 -3  (Extreme Case: All negative numbers)
Output: The max sum in the array is: -2

2. Array = -2 -3 4 -1 -2 1 5 -3
Output: The max sum in the array is: 7
*/

package Array.MaxContinuousSumOrKadane;

import java.util.Scanner;

public class UsingKadanesAlgorithm {
	  public static void main(String[] args){
	        Scanner in = new Scanner(System.in);
	        try{
	            System.out.println("Enter the number of array elements");
	            int n = in.nextInt();
	            int[] a = new int[n];
	            System.out.println("Enter the array elements");
	            for(int i=0;i<n;i++)
	                a[i]=in.nextInt();
	            System.out.println("The max sum in the array is: "+maxSubArraySum(a));   // Handles negative numbers (DP technique)
	            System.out.println("The max sum in the array is: "+usingKadanesAlgorithm(a));  // Does not handle negative numbers
	        }
	        finally{
	        in.close();
	        }
	    }
	  
	       /*
	  	   Example:
	  			1. Array = -2 -3 -4 -8 -2 -6 -5 -3  (Extreme Case: All negative numbers)
	  			Expected Output: The max sum in the array is: -2
		  		Actual Output using this method: The max sum in the array is: -2
		  	
	       VERY IMP NOTE: This method handles the Extreme Case: All negative numbers
		   This Solution uses Dynamic Programming
		   Source: http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
			*/   
		public static int maxSubArraySum(int a[]){
		   int maxSoFar = a[0], i;
		   int currMax = a[0];
		 
		   for (i = 1; i < a.length; i++)
		   {
			   currMax = Math.max(a[i], currMax+a[i]);
			   maxSoFar = Math.max(maxSoFar, currMax);
		   }
		   return maxSoFar;
		}
		/*
		 * Analysis:
		 * Time Complexity = O(n)
		 * Space Complexity = O(1)
		 */
		
		
		
		
		// NOTE: This method DOES NOT handle the Extreme Case: All negative numbers
				/*
	  	   		Example:
	  			1. Array = -2 -3 -4 -8 -2 -6 -5 -3  (Extreme Case: All negative numbers)
	  			Expected Output: The max sum in the array is: -2
		  		Actual Output using this method: The max sum in the array is: 0
		  		*/
	private static int usingKadanesAlgorithm(int[] a) {
		if(a==null||a.length==0)
			return -1;
		
		int maxTillHere=0;
		int overallMax=0;
		
		for(int i=0;i<a.length;i++){
			maxTillHere = maxTillHere + a[i];
			if(maxTillHere<0)
				maxTillHere=0;
			overallMax = Math.max(maxTillHere, overallMax);
		}
		return overallMax;
		
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n)
	 * Space Complexity = O(1)
	 */
}
