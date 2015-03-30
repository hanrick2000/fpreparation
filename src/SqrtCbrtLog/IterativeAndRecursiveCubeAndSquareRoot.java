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

package SqrtCbrtLog;

import java.util.Scanner;

public class IterativeAndRecursiveCubeAndSquareRoot {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter a number to find the square root");
			double n = in.nextDouble();
		    double sqrt = Sqrt(n);
		    double cbrt = Cbrt(n);
		    System.out.println("Recursive square root: "+sqrt);
		    System.out.println("Recursive cubic root: "+cbrt);
		    System.out.println("Iterative sqrt: "+iterativeGetSquareRoot(n));
		    System.out.println("Iterative cubic root: "+iterativeGetCubicRoot(n));
		}
		finally{
			in.close();
		}
	}
	// Program for square root
	public static double Sqrt(double n){
	    return GetSquareRoot(n, 0, n);
	}
	public static double GetSquareRoot(double n, double low, double high) {
	    double errorMargin = 0.001;        
	    double sqrt = (low + high) / 2;
	    double diff = sqrt*sqrt - n;
	    if ( diff > errorMargin)
	        return GetSquareRoot(n, low, sqrt);
	    if ( -diff > errorMargin)
	        return GetSquareRoot(n, sqrt, high);
	    return sqrt;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(lgn)
	 * Space Complexity = O(1)
	 */
	
	
	public static double iterativeGetSquareRoot(double n) {
		double low=0.0;
		double high=n;
	    double errorMargin = 0.001;        
	    double sqrt=0.0;
	    double diff=0.0;
	    while(low+errorMargin<high){
	    	
	    sqrt = (low + high) / 2;
		diff = sqrt*sqrt - n;
		    
	    if ( diff > errorMargin)
	        high=sqrt;
	    if ( -diff > errorMargin)
	        low=sqrt;
	    }
	    return sqrt;
	}
	
	
	// Program for cubic root
	public static double Cbrt(double n) {
	    return GetCubicRoot(n, 0, n);
	}
	public static double GetCubicRoot(double n, double low, double high) {
	    double errorMargin = 0.001;        
	    double cbrt = (low + high) / 2;
	    double diff = cbrt*cbrt*cbrt - n;
	    if ( diff > errorMargin)
	        return GetCubicRoot(n, low, cbrt);
	    if ( -diff > errorMargin)
	        return GetCubicRoot(n, cbrt, high);
	    return cbrt;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(lgn)
	 * Space Complexity = O(1)
	 */
	
	public static double iterativeGetCubicRoot(double n) {
		double low=0.0;
		double high=n;
	    double errorMargin = 0.001;        
	    double cbrt=0.0;
	    double diff=0.0;
	    while(low+errorMargin<high){
	    	
	    cbrt = (low + high) / 2;
		diff = cbrt*cbrt*cbrt - n;
		    
	    if ( diff > errorMargin)
	        high=cbrt;
	    if ( -diff > errorMargin)
	        low=cbrt;
	    }
	    return cbrt;
	}
}
