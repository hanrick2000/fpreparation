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
		            if (i>prevMax){                              // i > PREVMAX
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
	
	
	// Using Dynamic Programming the Time Complexity = O(n^2) and Space Complexity = O(n^2)
	public int jump(int[] A) {
        if (A==null || A.length==0) return 0;
        int N = A.length;
        int[] dp = new int[N+1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i=1; i<N; i++){
            int range = A[i];
            for (int j=1; j<=range && ((i+j)<N); j++){ 
                if (dp[i+j] == 0)   dp[i+j] = dp[i] + 1;
                else dp[i+j] = Math.min(dp[i+j], dp[i]+1);
            }
        }
        return dp[N];
    }
	/*
	Analysis:
	Time Complexity = O(n^2)
	Space Complexity = O(n^2)
	*/
}
