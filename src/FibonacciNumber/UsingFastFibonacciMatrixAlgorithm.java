
/*
 * Question: Calculate nth fibonacci number in O(lgn) time and O(1) space
 * 
 * Question and Answer Source: http://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
 * 
 * Algorithm:
 * If we n times multiply the matrix M = {{1,1},{1,0}} to itself (in other words calculate power(M, n )), 
 * then we get the (n+1)th Fibonacci number as the element at row and column (0, 0) in the resultant matrix.
 * 
 * The above gives O(n) time, we can further optimize the algorithm by calculating power using 
 * this method: http://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
 * where we subdivide power(a,b) into power(a,b/2) and SAVE IT, 
 * thus DISCARDING HALF CALCULATIONS IN EVERY RECURSIVE CALL
 * which gives (lgn) time
 * 
 */

package FibonacciNumber;

import java.util.Scanner;

public class UsingFastFibonacciMatrixAlgorithm {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Fibnonacci series can either start from 0 or from 1");
			System.out.println("In this program the fibonacci series starts from 0 such that 0,1,1,2,3,5,8,....");
			System.out.println("This means the 0th fibo no is '0', 1st is '1', 2nd is '1', 3rd is '2' and so on....");
			System.out.println("Enter n");
			int n = in.nextInt();
			System.out.println("The "+n+"th fibonacci number is: "+fibo(n));
		}
		finally{
			in.close();
		}
	}

	private static int fibo(int n) {
		if(n==0)                      // The 0th fibonacci number is 0
			return 0;
		
		int[][] F = new int[][]{{1,1},{1,0}};
		power(F,n-1);  // power(matrix,n-1) will give nth fibonacci number at matrix[0][0] location
		return F[0][0];
	}

	private static void power(int[][] F, int n) {
		
		if(n==0||n==1)       // The 1st fibonacci number is 1, the 2nd fibonacci number is 1. Hence return, since
			                 // this return will cause fibo(matrix,n) method to return F[0][0] which is 1
			return;
		power(F,n/2);
		multiply(F,F);
// till here the F is already modified and its no longer {{1,1},{1,0}}. Hence we use another matrix M such that M = {{1,1},{1,0}} 
		int[][] M = new int[][]{{1,1},{1,0}};
		if(n%2!=0)
			multiply(F,M);
	}

	private static void multiply(int[][] F, int[][] M) {
		int a = F[0][0]*M[0][0] + F[0][1]*M[1][0];
		int b = F[0][0]*M[1][0] + F[0][1]*M[1][1];
		int c = F[1][0]*M[0][0] + F[1][1]*M[1][0];
		int d = F[1][0]*M[1][0] + F[1][1]*M[1][1];
		
		F[0][0]=a;
		F[0][1]=b;
		F[1][0]=c;
		F[1][1]=d;
	}
}
/*
 * Analysis:
 * Time Complexity = O(lgn)
 * Space Complexity = O(1), since the matrix is 2*2 matrix
 */
