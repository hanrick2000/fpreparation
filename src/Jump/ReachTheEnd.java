/*	Question: 
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Determine if you are able to reach the last index.
    For example:
    A = [2,3,1,1,4], return true.
    A = [3,2,1,0,4], return false.

    Question Source: http://www.careercup.com/question?id=5728188153987072 
    
    Answer Source: https://github.com/walnutown/CodingInTheDeep/blob/master/LeetCode/JumpGame.java
*/

package Jump;

import java.util.Scanner;

public class ReachTheEnd {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elemenets in the array");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the elements of the array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("The frog will reach the other end ? "+willReach(a));
		}
		finally{
			in.close();
		}
	}
	
	// BEST SOLUTION TO GIVE IN INTERVIEWS
	private static boolean willReach(int[] a) {
		/* 
		  Algorithm: (BEST SOLUTION TO GIVE IN INTERVIEWS)
		  For each element determine the maximum index we may jump
		  For each element update the max
		  If the current index position is greater than max then return false as there is no jump that can take to this index position
		  Otherwise at the end of array iteration return true
		  Time: O(n); Space: O(1)
		*/
		
		// Extreme Case
		if(a.length==0||a==null)
			return true;

		int max = 0;                            // VERY IMP STEP
		for(int i=0;i<a.length;i++){
			if(i>max)
				return false;
			else
				max = Math.max(max,i+a[i]);
		}
		return true;
		
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n)
	 * Space Complexity = O(1)
	 */
	
	
	
	
	// Other way of solving the same question using two max (currMax and prevMax)
	// Time Complexity = O(n), Space Complexity = O(1)
	public boolean canJump(int[] A) {
        if (A==null || A.length<=1) 
        	return true;
        int N = A.length, prevMax=0, currMax=0;
        for (int i=0; i<N; i++){
            if (i > prevMax) 
            	prevMax = currMax;
            currMax = Math.max(currMax, A[i] + i);
            if (currMax == i && i!=N-1) 
            	return false;     // notice here, i!= N-1
        }
        return true;
    }
	/*
	 * Analysis:
	 * Time Complexity = O(n)
	 * Space Complexity = O(1)
	 */
}
