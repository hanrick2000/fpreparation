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
 */

package Array.MaxContinuousSumInArray;

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
	            System.out.println("The max sum in the array is: "+usingKadanesAlgorithm(a));
	        }
	        finally{
	        in.close();
	        }
	    }

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
