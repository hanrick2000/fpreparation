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
			System.out.println("Using Binary Search Algorithm: "+usingNlgNAlgorithm(a,a.length));
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
		 
		 int longestSubseqLength=1; // the longest subsequence length would at least be 1 for array size > 0
	       
	     return usingRecursionSolution(a,n,longestSubseqLength);
	        
	    }
	    private static int usingRecursionSolution(int[] a, int n, int longestSubseqLength) {
	    	
	    	if(n==1)       // if the length of the array is 1 then longestSubseqLength=1
	            return 1;
	            
	        int res=1;
	        int subseqLength = 1;  // length of LIS ending with arr[n-1]
	        /* Recursively get all LIS ending with arr[0], arr[1] ... ar[n-2]. If 
	        arr[i-1] is smaller than arr[n-1], and max ending with arr[n-1] needs
	        to be updated, then update it */
	        for(int i=1;i<n;i++){
	            res = usingRecursionSolution(a,i,longestSubseqLength);
	            if(a[n-1] > a[i-1])
	            	subseqLength = Math.max(subseqLength, res+1);
	        }
	        
	        if(subseqLength>longestSubseqLength)
	        	longestSubseqLength = subseqLength;
	        
	        return longestSubseqLength;
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
	
	 /*
    Analysis:
    Time Complexity = O(n^2)
    Space Complexity = O(1)
    */
	
	
	
	
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
		public static int usingNlgNAlgorithm(int A[], int size) {
		    // Add boundary case, when array size is one
			
			/*Algorithm Source:
			http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
			http://robentan.blogspot.com/2011/11/more-efficient-algorithm-for-longest.html
			http://stackoverflow.com/questions/6129682/longest-increasing-subsequenceonlogn
			
			*
			*
			*
			*Our strategy determined by the following conditions,

1. If A[i] is smallest among all end candidates of active lists, we will start new active list of length 1.

2. If A[i] is largest among all end candidates of active lists, we will clone the largest active list, and extend 
it by A[i].

3. If A[i] is in between, we will find a list with largest end element that is smaller than A[i]. Clone and extend
 this list by A[i]. We will discard all other lists of same length as that of this modified list.

Note that at any instance during our construction of active lists, the following condition is maintained.

“END ELEMENT OF SMALLER LIST IS SMALLER THAN END ELEMENTS OF LARGER LISTS”
			*
			*
			*/
		    
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
