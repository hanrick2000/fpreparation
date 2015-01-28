/*
Question: Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set 
with sum equal to given sum.




VERY VERY IMPORTANT NOTE: The Recursive & DP approach WON'T WORK for NEGATIVE Numbers present either in ARRAY ELEMENTS OR SUM



Examples: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
Output:  True  //There is a subset (4, 5) with sum 9.
Let isSubSetSum(int set[], int n, int sum) be the function to find whether there is a subset of set[] with 
sum equal to sum. n is the number of elements in set[].


Source: http://www.geeksforgeeks.org/dynamic-programming-subset-sum-problem/

YouTube Helper Links: https://www.youtube.com/watch?v=GdZSzita5V8
					  https://www.youtube.com/watch?v=WRT8kmFOQTw
					  https://www.youtube.com/watch?v=hi-Ec4jYyII

*/
package SubsetSumProblem;

import java.util.Scanner;

public class UsingResursiveAndDPApproach {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the number of elements in the array");
		int n =in.nextInt();
		System.out.println("Enter the elements of the array");
		int[] a=new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		System.out.println("Enter the sum, which you need to find");
		int sum = in.nextInt();
		System.out.println("Using recursion, the result is: "+usingRecursion(a,a.length,sum));
		System.out.println("Using Dynamic Programming, the result is: "+usingDP(a,sum));
	}
	finally{
		in.close();
	}
}

/*
VERY VERY IMPORTANT NOTE: The Recursive & DP approach WON'T WORK for NEGATIVE Numbers present either in ARRAY ELEMENTS OR SUM
*/
private static boolean usingRecursion(int[] a,int length, int sum) {
	/*
	VERY VERY IMPORTANT NOTE: The Recursive & DP approach WON'T WORK for NEGATIVE Numbers present either in ARRAY ELEMENTS OR SUM
	*/
	// 1. Base Cases
	if(sum==0)
		return true;
	if(length==0 && sum!=0)
		return false;
	
	// 2. To avoid unnecessary steps, we will optimize the recursion method by avoiding 
	//    recursive calls to areas where we are definite that we can SAFELY ignore the case since
	//    the SOLUTION does not exist there.
	
	// If last element is greater than sum, then ignore it
	if(a[length-1]>sum)
		return usingRecursion(a,length-1,sum);
	
	// 3. This is the recursion step where we will call the method again and again
	/* else, check if sum can be obtained by any of the following
    (a) including the last element
    (b) excluding the last element   */
	return (usingRecursion(a, length-1, sum-a[length-1])|| usingRecursion(a, length-1, sum));
	
}
/*
Analysis:
	Time Complexity = O(2^n)
	Space Complexity =       // Don't know
*/

/*
VERY VERY IMPORTANT NOTE: The Recursive & DP approach WON'T WORK for NEGATIVE Numbers present either in ARRAY ELEMENTS OR SUM
*/
private static boolean usingDP(int[] a, int sum) {
	// using boolean matrix for DP
	boolean dp[][] = new boolean[a.length+1][sum+1];  // +1 in row and column

	/*
	VERY VERY IMPORTANT NOTE: The Recursive DP approach WON'T WORK for NEGATIVE Numbers present either in ARRAY ELEMENTS OR SUM
	*/
	
	// if the length of the array is variable (and sum is 0) then fill TRUE, since the SUM=0 
	for(int row=0;row<dp.length;row++){
		dp[row][0] = true;    // NOTE: dp[length=VARIABLE][sum=0], thus we satisfy the condition where length is VARIABLE
		                      // and the SUM=0
	}
	
	// if the SUM is variable and length is 0 then FALSE, since (sum=variable && length=0)
	for(int column=1;column<dp[0].length;column++){
		dp[0][column] = false;  // NOTE: dp[length=0][sum=VARIABLE], thus we satisfy the condition where 
		                        // (length=0 && sum=variable)
	}
	
	for(int i=1;i<dp.length;i++){
		for(int j=1;j<dp[0].length;j++){
			
			
			/* Check if sum can be obtained by any of the following
		      (a) including the last element
		      (b) excluding the last element   */
			
			
			// VERY VERY IMP: This is same as "excluding the last element" which is represented in DP 
			dp[i][j] = dp[i-1][j]; // the current position[i][j] would be same as previous position.
			                       // the previous position means that SUM is ACHIEVED OR NOT-ACHIEVED
			                       // int the previous position then it will ofcourse be ACHIEVED or NOT-ACHIEVED
			                       // in the current position.
			
			
			// VERY VERY IMP: This is same as "including the last element" which is represented in DP 
			// if the column[ sum is represented in column of the matrix i.e this sum exist] > = sum-a[last_index]
            // then decrease the sum
			if(j>=a[i-1])   // i.e sum >= array[last index element]. If it is true then include this last element by
				            // deducting it from the total sum
				dp[i][j] = dp[i-1][j] || dp[i-1][j-a[i-1]];  // VERY VERY IMP NOTE: This step resembles the case
			// where either we include the last element or exclude the last element
			
		}
	}
	return dp[a.length][sum];
}

/*
Analysis:
	Time Complexity = O(a.length*sum)
	Space Complexity = O(a.length*sum)
*/
}