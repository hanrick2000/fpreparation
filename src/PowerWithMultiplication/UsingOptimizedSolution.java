
/*
 * Question: Implement EFFICIENT power method
 * 
 * Question and Answer Source: http://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
 * 
 */


package PowerWithMultiplication;

import java.util.Scanner;

public class UsingOptimizedSolution {
	
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("lgn algorithm to calculate power");
		System.out.println("Enter the two number to calculate the power in the form a^b repectively");
		System.out.println("Only positive numbers should be entered");
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println("The result is: "+pow(a,b));
	}
	finally{
		in.close();
	}
	}

	private static int pow(int a, int b) {
		
		if(b==0)
			return 1;
		int temp = pow(a,b/2);
		if(b%2==0)
			return temp*temp;
		else{
			if(b>0)
				return (a*temp*temp);
			else
				return (temp*temp)/a;
		}
	}
	/*
	 * Analysis:
	 * Time Complexity = Since we divide b into 2 parts and discard one part,
	 * the time complexity = O(lgn)
	 * Space Complexity = O(1)
	 */
}
