
/*
 * Question: Find the length of the longest INCREASING subsequence in an array
 * 
Solution Source: 
http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
https://www.youtube.com/watch?v=U-xOVWlcgmM
http://robentan.blogspot.com/2011/11/more-efficient-algorithm-for-longest.html
http://stackoverflow.com/questions/6129682/longest-increasing-subsequenceonlogn


Algorithm:
In general, we have set of active lists of varying length. We are adding an 
element A[i] to these lists. We scan the lists (for end elements) in decreasing 
order of their length. We will verify the end elements of all the lists to find 
a list whose end element is smaller than A[i] (floor value).

Our strategy determined by the following conditions,

1. If A[i] is smallest among all end candidates of active lists, we will start new active
 list of length 1.

2. If A[i] is largest among all end candidates of active lists, we will clone the largest 
active list, and extend it by A[i].

3. If A[i] is in between, we will find a list with largest end element that is smaller than 
A[i]. Clone and extend this list by A[i]. We will discard all other lists of same length as 
that of this modified list.

Note that at any instance during our construction of active lists, the following condition 
is maintained.

“end element of smaller list is smaller than end elements of larger lists”.

It will be clear with an example, let us take example from wiki 
{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15}.

A[0] = 0. Case 1. There are no active lists, create one.
0.
-----------------------------------------------------------------------------
A[1] = 8. Case 2. Clone and extend.
0.
0, 8.
-----------------------------------------------------------------------------
A[2] = 4. Case 3. Clone, extend and discard.
0.
0, 4.
0, 8. Discarded
-----------------------------------------------------------------------------
A[3] = 12. Case 2. Clone and extend.
0.
0, 4.
0, 4, 12.
-----------------------------------------------------------------------------
A[4] = 2. Case 3. Clone, extend and discard.
0.
0, 2.
0, 4. Discarded.
0, 4, 12.
-----------------------------------------------------------------------------
A[5] = 10. Case 3. Clone, extend and discard.
0.
0, 2.
0, 2, 10.
0, 4, 12. Discarded.
-----------------------------------------------------------------------------
A[6] = 6. Case 3. Clone, extend and discard.
0.
0, 2.
0, 2, 6.
0, 2, 10. Discarded.
-----------------------------------------------------------------------------
A[7] = 14. Case 2. Clone and extend.
0.
0, 2.
0, 2, 6.
0, 2, 6, 14.
-----------------------------------------------------------------------------
A[8] = 1. Case 3. Clone, extend and discard.
0.
0, 1.
0, 2. Discarded.
0, 2, 6.
0, 2, 6, 14.
-----------------------------------------------------------------------------
A[9] = 9. Case 3. Clone, extend and discard.
0.
0, 1.
0, 2, 6.
0, 2, 6, 9.
0, 2, 6, 14. Discarded.
-----------------------------------------------------------------------------
A[10] = 5. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 5.
0, 2, 6. Discarded.
0, 2, 6, 9.
-----------------------------------------------------------------------------
A[11] = 13. Case 2. Clone and extend.
0.
0, 1.
0, 1, 5.
0, 2, 6, 9.
0, 2, 6, 9, 13.
-----------------------------------------------------------------------------
A[12] = 3. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 3.
0, 1, 5. Discarded.
0, 2, 6, 9.
0, 2, 6, 9, 13.
-----------------------------------------------------------------------------
A[13] = 11. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 3.
0, 2, 6, 9.
0, 2, 6, 9, 11.
0, 2, 6, 9, 13. Discarded.
-----------------------------------------------------------------------------
A[14] = 7. Case 3. Clone, extend and discard.
0.
0, 1.
0, 1, 3.
0, 1, 3, 7.
0, 2, 6, 9. Discarded.
0, 2, 6, 9, 11.
----------------------------------------------------------------------------
A[15] = 15. Case 2. Clone and extend.
0.
0, 1.
0, 1, 3.
0, 1, 3, 7.
0, 2, 6, 9, 11.
0, 2, 6, 9, 11, 15. <-- LIS List
----------------------------------------------------------------------------
It is required to understand above strategy to devise an algorithm. Also, ensure we have
 maintained the condition, “end element of smaller list is smaller than end elements of 
 larger lists“. Try with few other examples, before reading further. It is important to 
 understand what happening to end elements.

Algorithm:

Querying length of longest is fairly easy. Note that we are dealing with end elements only.
 We need not to maintain all the lists. We can store the end elements in an array. Discarding 
 operation can be simulated with replacement, and extending a list is analogous to adding
  more elements to array.

We will use an auxiliary array to keep end elements. The maximum length of this array is 
that of input. In the worst case the array divided into N lists of size one (note that it 
does’t lead to worst case complexity). To discard an element, we will trace ceil value of 
A[i] in auxiliary array (again observe the end elements in your rough work), and replace 
ceil value with A[i]. We extend a list by adding element to auxiliary array. We also maintain 
a counter to keep track of auxiliary array length.
 */


package SubstringAndSubsequenceProblems.Subsequence;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
	 public static void main(String[] args){
		   
		   Scanner in = new Scanner(System.in);
		   try{
		    System.out.println("Enter the number of elements of the array");
		    int n = in.nextInt();
		    int[] a = new int[n];
		    System.out.println("Enter the elements of the array");
		    for(int i=0;i<n;i++)
		        a[i]= in.nextInt();
		        
		    System.out.println("The length of longest increasing subsequence of the array is: "
		    +LongestIncreasingSubsequenceLength(a));
		    
		   }
		   finally{
			   in.close();
		   }
		   }
	 
	 
	// Binary search (note boundaries in the caller)
	// a[] is ceilIndex in the caller
	public static int CeilIndex(int A[], int l, int r, int key) {         // Time Complexity = O(lgn)
	    int m=0;
	 
	    while( r - l > 1 ) {
	        m = l + (r - l)/2;
	        if(A[m] >= key)
	        	r=m;
	        else
	        	l=m;
	    }
	 
	    return r;
	}
	public static int LongestIncreasingSubsequenceLength(int a[]) { 
	    // Add boundary case, when array size is one
	 
	    int[] tailTable   = new int[a.length];
	    int length; // always points empty slot
	 
	    tailTable[0] = a[0]; // there is no active list, so lets create an active list with the fist element of the array
	    length = 1;
	    for( int i = 1; i < a.length; i++ ) {
	        if( a[i] < tailTable[0] )
	            // new smallest value
	            tailTable[0] = a[i];
	        else if( a[i] > tailTable[length-1] )
	            // A[i] wants to extend largest subsequence
	            tailTable[length++] = a[i];
	        else
	            // A[i] wants to be current end candidate of an existing subsequence
	            // It will replace ceil value in tailTable
	            tailTable[CeilIndex(tailTable, -1, length-1, a[i])] = a[i];
	    }

	 
	    return length;
	}
/*
 * Analysis:
 * Time Complexity = O(nlgn) since ceilIndex is O(lgn) and LIS method is O(n) hence together they are O(lgn)
 * Space Complexity = O(n) used by tail table array
 */
	
}
