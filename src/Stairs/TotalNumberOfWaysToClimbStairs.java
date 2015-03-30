package Stairs;

import java.util.Scanner;

public class TotalNumberOfWaysToClimbStairs {
	public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    try{
	    	System.out.println("Enter the number of steps in the stair");
	    	int steps = in.nextInt();
	    	System.out.println("Total number of unique ways to climb stairs using DP: "+totalNumberOfUniquePathsPossible(steps));
	    }
	    finally{
	    	in.close();
	    }
    }
public static int totalNumberOfUniquePathsPossible(int n) {
	if (n == 1)
		return 1;
	
	if (n == 2)
		return 2;
	
	int[] count = new int[n];   // count the total unique paths possible
	count[0] = 1; 
	count[1] = 2;
	
	for (int i = 2; i < n; i++) {
		count[i] = count[i - 1] + count[i - 2];
	}
	
	return count[n - 1];
}
/*
 * Analysis:
 * Time Complexity = O(n)
 * Space Complexity = O(n)
 */
}
