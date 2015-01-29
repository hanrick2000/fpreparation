
/*
 * Question: Find the length of the longest INCREASING subsequence in an array
 * 
Solution Source: http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
https://www.youtube.com/watch?v=U-xOVWlcgmM
http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
http://robentan.blogspot.com/2011/11/more-efficient-algorithm-for-longest.html
http://stackoverflow.com/questions/6129682/longest-increasing-subsequenceonlogn


 */
package LongestIncreasingSubsequence;

import java.util.Scanner;

public class UsingNlogNAlgorithm {
	 public static void main(String[] args){
		   
		   Scanner in = new Scanner(System.in);
		   try{
		    System.out.println("Enter the number of elements of the array");
		    int n = in.nextInt();
		    int[] a = new int[n];
		    System.out.println("Enter the elements of the array");
		    for(int i=0;i<n;i++)
		        a[i]= in.nextInt();
		        
		    System.out.println("The length of longest increasing subsequence of the array is: "+LongestIncreasingSubsequenceLength(a,a.length));
		    
		   }
		   finally{
			   in.close();
		   }
		   }
	 
	 
	// Binary search (note boundaries in the caller)
	// A[] is ceilIndex in the caller
	public static int CeilIndex(int A[], int l, int r, int key) {
	    int m;
	 
	    while( r - l > 1 ) {
	        m = l + (r - l)/2;
	        if(A[m] >= key)
	        	r=m;
	        else
	        	l=m;
	    }
	 
	    return r;
	}
	public static int LongestIncreasingSubsequenceLength(int A[], int size) {
	    // Add boundary case, when array size is one
	 
	    int[] tailTable   = new int[size];
	    int len; // always points empty slot
	
	 
	    tailTable[0] = A[0];
	    len = 1;
	    for( int i = 1; i < size; i++ ) {
	        if( A[i] < tailTable[0] )
	            // new smallest value
	            tailTable[0] = A[i];
	        else if( A[i] > tailTable[len-1] )
	            // A[i] wants to extend largest subsequence
	            tailTable[len++] = A[i];
	        else
	            // A[i] wants to be current end candidate of an existing subsequence
	            // It will replace ceil value in tailTable
	            tailTable[CeilIndex(tailTable, -1, len-1, A[i])] = A[i];
	    }

	 
	    return len;
	}
/*
 * Analysis:
 * Time Complexity = O(nlgn)
 * Space Complexity = O(n) used by tail table array
 */
	
}
