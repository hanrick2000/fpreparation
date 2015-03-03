package SubstringAndSubsequenceProblems.Subsequence;


import java.util.Scanner;

public class MaxContiguousSubsequenceSum {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("This program will find the maximum subsequence sum in an array of negative"
				+ "and positive integers");
		System.out.println("Enter the size of the array");
		int n = in.nextInt();
		System.out.println("Enter the elements of the array");
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		System.out.println("Using Dynamic Programming: "+usingDynamicProgramming(a));
		System.out.println("Using Kadane's algorithm: "+usingKadanesAlgorithm(a));
	}
	finally{
		in.close();
		}
	}

private static int usingKadanesAlgorithm(int[] a) {
	/*
	 * Source: http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
	 * Algorithm: 
	 * 			int positveSum = 0 . This variable only maintains ONLY the positive sum
	 * 			Iterate through all array elements and add then individually to the positiveSum
	 * 			if(positiveSum+a[i]<0) then positiveSum=0
	 * 			otherwise we retain this positiveSum in the next iteration
	 * 			At the same time we maintian another variable called overallMax which compares 
	 * 			previous positiveSum with current positiveSum and whichever is greater would be the overallMax
	 * 
	 */
	
	int positiveSum = 0;  // only the positiveSum of previous sum and current element
	int overallMax  = 0;  // gives the overall contiguous max in the array
	for(int i=0;i<a.length;i++){
		positiveSum+=a[i];
		if(positiveSum<0)
			positiveSum=0;
		
		// check if this positiveSum is greater than the previous positiveSum
		overallMax = Math.max(positiveSum,overallMax);
	}
	return overallMax;
	
	}

/*
 * Analysis: Time Complexity = O(n)
 * Space Complexity = O(1)
 */
private static int usingDynamicProgramming(int[] a) {
	/*
	 * Source: http://www.geeksforgeeks.org/largest-sum-contiguous-subarray/
	 * Algorithm: dp[i] = max{dp[i-1]+a[i],a[i]}
	 * 			  Iterate over the dp matrix and get the max element which is the max
	 */
	int[] dp = new int[a.length];
	dp[0] = a[0];
	int max = 0;
	for(int i=1;i<a.length;i++){
		dp[i] = Math.max(dp[i-1]+a[i],a[i]);
		if(dp[i]>max)
			max = dp[i];
	}
		return max;
	}
/*
 * Analysis: Time Complexity = O(n)
 * Space Complexity = O(n)
 */

}
