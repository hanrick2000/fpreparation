/*
 * Question: Let's say there is a double square number X, which can be expressed as the sum of two perfect squares, 
 * for example, 10 is double square because 10 = 3^2 + 1^2 

Determine the number of ways which it can be written as the sum of two squares

Question and Answer Source: http://www.careercup.com/question?id=5767787551129600

Algorithm:
This algorithm is similar to the 2-sum algorithm 
In this algorithm, the lower bound is zero, while the upper bound is the square root of N.
We set a cursor on the lower bound, and it only moves in +1 steps. 
Also, we set another cursor on the upper bound, and it only moves in -1 steps. 
Whenever the sum of squares is greater than N, we need to decrease the sum. 
In order to do so, we move the upper cursor down (j = j-1).
Whenever the sum is lower than N, we move the lower cursor up (i = i+1). 
Else, when we find a match, we move both.
 */
package Sum.SumOfTwoPerfectSquares;

import java.util.Scanner;

public class SumOfTwoSquares {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to find the number of ways to find SUM of Squares");
			System.out.println("Enter a number to find sum of squares");
			int n = in.nextInt();
			System.out.println("Total possible ways to achieve sum of squares is: "+sumOfSquares(n));
		}
		finally{
			in.close();
		}
	}
	public static int sumOfSquares(int n){
		
		int low = 0;
		int high = (int)Math.floor(Math.sqrt(n));
		int sumOfSquares = 0;
		
		int noOfWays = 0;
		
		while(low<=high){
			sumOfSquares = (low*low)+(high*high);
			if(sumOfSquares==n){
				System.out.println(low+" and "+high);
				noOfWays++;
				low++;
				high++;
			}
			else if(n<sumOfSquares)
				high=high-1;
			else
				low=low+1;
				
		}
		return noOfWays;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(sqrt(n))
	 * Space Complexity = O(1)
	 */
}
