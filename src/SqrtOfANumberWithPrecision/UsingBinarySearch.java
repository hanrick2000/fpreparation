/*
Question:
	Write a function which returns the square root of a given number upto a precision of 0.0001.
	Only arithematic operations like addition, subtraction, division and multiplication are allowed.

Question and Answer Source: http://www.careercup.com/question?id=4635417542393856

Algorithm:
	Yes. We can apply Binary Search only in a monotonic function (increasing, decreasing, 
	non-increasing or non-decreasing function). 

	We're applying Binary Search to the function F(x) = x^2. This function is strictly increasing 
	(for x >= 0), so we know that for any 3 values A, B, C, with A < B < C, F(A) < F(B) < F(C) 

	So if F(mid) is larger than the number, we need to go for values less then mid. Go 
	for larger values otherwise.
*/
package SqrtOfANumberWithPrecision;

import java.util.Scanner;

public class UsingBinarySearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to find the SQRT OF A NUMBER WITH PRECSION IN FAST TIME");
			System.out.println("Enter the number");
			double n = in.nextDouble();
			System.out.println("SQRT OF THE NUMBER WITH PRECISION is: "+findSqrtWithPrecision(n));
		}
		finally{
			in.close();
		}
	}

	private static double findSqrtWithPrecision(double n) {
		
		
		double PRECISION = 0.0001;
		
		if(n<PRECISION)     // the number should be greater than the precision
			return -1.0;
		
		
		double left = 0.0;
		double right = n;
		double mid = 0.0;
		while((left+PRECISION) < right){
			mid = (left+right)/2.0;
			if(mid*mid>n)
				right = mid;
			else
				left = mid;
		}
		return left;
	}
}
/*
 * Analysis:
 * Time Complexity = O(lgn)
 * Space Complexity = O(1)
 */