

/*	Question: 
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Determine if you are able to reach the last index.
    For example:
    A = [2,3,1,1,4], return true.
    A = [3,2,1,0,4], return false.
    
    Question and Answer Source: https://github.com/walnutown/CodingInTheDeep/blob/master/LeetCode/JumpGame.java
    
    
*/

// Algorithm:
// Maintain the max distance we can reach
// Traverse the array and update the max
// Once we find that current distance out of reach, return false
// time: O(n); space: O(1)

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

	private static boolean willReach(int[] a) {
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
}
