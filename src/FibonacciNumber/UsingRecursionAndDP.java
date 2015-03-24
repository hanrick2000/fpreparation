/*
Question: Print the nth fibonacci number
Question and Answer Source: http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
	
The fibonacci numbers start from 0
The Fibonacci numbers are the numbers in the following integer sequence.

0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 141, ……..

*/

package FibonacciNumber;

import java.util.Scanner;

public class UsingRecursionAndDP {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter a number");
			int n = in.nextInt();
			System.out.println("Using recursion: "+usingRecursion(n));
			System.out.println("Using Dynamic Programming: "+usingDP(n));
		}
		finally{
			in.close();
		}
	}



	private static int usingRecursion(int n) {
		if (n <= 1)
		      return n;
		return usingRecursion(n-1) + usingRecursion(n-2);
	}
	/*
	Analysis:
	Time Complexity: T(n) = T(n-1) + T(n-2) which is exponential.
	Space Complexity = O(1), ignoring stack frame space
	*/
	
	
	private static int usingDP(int n) {
		int a = 0;
		int b = 1;
		int c = 0;
		if( n == 0)
		   return 0;
		for(int i = 2; i <= n; i++){
		   c = a + b;
		   a = b;
		   b = c;
		}
		return b;
	}
	/*
	Analysis:
	Time Complexity = O(n)
	Space Complexity = O(1)
	*/
}
