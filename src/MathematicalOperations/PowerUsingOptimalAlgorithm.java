
/*
 * Question: Implement EFFICIENT power method
 * 
 * Question and Answer Source: http://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
 * 
 */


package MathematicalOperations;

import java.util.Scanner;

public class PowerUsingOptimalAlgorithm {
	
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("lgn algorithm to calculate power");
		System.out.println("Enter the two number to calculate the power in the form a^b repectively");
		System.out.println("Works for both positive and negative numbers of a and b");
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println("The result is: "+pow(a,b));
	}
	finally{
		in.close();
	}
}
	
	
	public static double pow(double x, int n) {
		if (n < 0) 
			return 1 / power(x, -n);
		else 
			return power(x, n);
	}
	
	public static double power(double x, int n) {
		if (n == 0)
			return 1;
	 
		double v = power(x, n / 2);
	 
		if (n % 2 == 0) 
			return v * v;
		else 
			return v * v * x;
	}
	 



	/*
	 * Analysis:
	 * Time Complexity = Since we divide b into 2 parts and discard one part,
	 * the time complexity = O(lgn)
	 * Space Complexity = O(1)
	 */
}
