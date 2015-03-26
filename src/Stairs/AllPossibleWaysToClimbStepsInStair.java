/*
 * Question: Implement stairs(N) that (collect the solutions in a list) prints all the ways to climb up
 a N-steps-stair where one can either take a single step or double step. 

We'll use 1 to represent a single step, and 2 to represent a double step. 

Example:
stairs(3) 
111 
12 
21

Question and Answer Source: http://www.careercup.com/question?id=5696794451247104 

 * 
 */
package Stairs;

import java.util.Scanner;

public class AllPossibleWaysToClimbStepsInStair {
	 public static void main(String[] args) {
		    Scanner in = new Scanner(System.in);
		    try{
		    	System.out.println("Enter the number of steps in the stair");
		    	int steps = in.nextInt();
		    	System.out.println("All unique paths are: ");
		    	printAllPossibleSteps("", steps);
		    	System.out.println("Total number of unique paths possible using DP: "+totalNumberOfUniquePathsPossible(steps));
		    }
		    finally{
		    	in.close();
		    }
	    }
	 	// recursive solution for find all unique paths
	    public static void printAllPossibleSteps(String path, int steps) {
	        if(steps > 0){
	            printAllPossibleSteps(path+" 1",steps-1);
	            printAllPossibleSteps(path+" 2",steps-2);
	        }
	        else if(steps == 0)
	            System.out.println(path);
	    }
	    /*
	     * Analysis:
	     * Time Complexity = O(n)
	     * Space Complexity = O(n)
	     */
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
