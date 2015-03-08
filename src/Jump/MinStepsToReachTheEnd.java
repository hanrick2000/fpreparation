/*
 * 
 * Question:
 * 
    Given an array of non-negative integers, you are initially positioned at the first index of the array.
    Each element in the array represents your maximum jump length at that position.
    Your goal is to reach the last index in the minimum number of jumps.
    
    For example:
    Given array A = [2,3,1,1,4]
    The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)
	
	Question and Answer Solution: https://github.com/walnutown/CodingInTheDeep/blob/master/LeetCode/JumpGame2.java
*
*/



package Jump;

import java.util.Scanner;

public class MinStepsToReachTheEnd {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elemenets in the array");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the elements of the array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("The min steps for the frog to reach the other end: "+EfficientMinStepsAlgo(a));
		}
		finally{
			in.close();
		}
}

	private static int EfficientMinStepsAlgo(int[] a) {      // BEST ALGO: TO BE GIVEN IN INTERVIEWS
		  
		        if (a==null || a.length==0)
		            return 0;
		        int step = 0, prevMax = 0, currMax = 0;
		        
		        for (int i=0; i<a.length; i++){
		            if (i>prevMax){
		                prevMax = currMax;
		                step++;
		            }
		            currMax = Math.max(currMax, i+a[i]);
		        }
		        
		        return step;
		    }
	
/*
Analysis:
Time Complexity = O(n)
Space Complexity = O(1)
*/

}
