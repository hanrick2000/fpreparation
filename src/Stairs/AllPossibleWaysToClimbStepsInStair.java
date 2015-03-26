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
		    	printAllpossibleSteps("", steps);
		    }
		    finally{
		    	in.close();
		    }
	    }
	 	// recursive solution
	    public static void printAllpossibleSteps(String path, int steps) {
	        if(steps > 0){
	            printAllpossibleSteps(path+" 1",steps-1);
	            printAllpossibleSteps(path+" 2",steps-2);
	        }
	        else if(steps == 0)
	            System.out.println(path);
	    }
}
