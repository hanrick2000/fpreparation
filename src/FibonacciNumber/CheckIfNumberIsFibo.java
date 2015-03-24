/*Question: How to check if a number is fibonacci number

Question and Answer Source: http://www.geeksforgeeks.org/check-number-fibonacci-number/

HINT: A number is Fibonacci if and only if one or both of (5*n2 + 4) or (5*n2 – 4) is a perfect square

*/

package FibonacciNumber;

import java.util.Scanner;

public class CheckIfNumberIsFibo {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter a number");
			int n = in.nextInt();
			System.out.println("Number is Fibonacci: "+isFibonacci(n));
		}
		finally{
			in.close();
		}
	}
	public static boolean isPerfectSquare(int x)
	{
	    int s = (int) Math.sqrt(x);
	    return (s*s == x);
	}
	 
	// Returns true if n is a Fibinacci Number, else false
	public static boolean isFibonacci(int n)
	{
	    // n is Fibinacci if one of 5*n*n + 4 or 5*n*n - 4 or both is a perferct square
	    return isPerfectSquare(5*n*n + 4) ||
	           isPerfectSquare(5*n*n - 4);
	}
}
/*
Analysis:
Time Complexity = O(1)
Space Complexity = O(1)
*/