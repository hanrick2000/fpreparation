/*
Write you own Power without using multiplication(*) and division(/) operators
Source: http://www.geeksforgeeks.org/write-you-own-power-without-using-multiplication-and-division/
*/
package CalculatePowerWithoutUsingMultiplicationAndDivisionOperators;

import java.util.Scanner;

public class UsingRecursiveAddition {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the two number to calculate the power in the form a^b repectively");
		System.out.println("Only positive numbers should be entered");
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println("Using multiplcative recursion we get "+pow(a,b));
		System.out.println("Using nested loops "+usingNestedLoops(a,b));
	}
	finally{
		in.close();
	}
}

private static int usingNestedLoops(int a, int b) {
	if(b==0)
		return 1;
	int increment = a;   // initialize increment with a
	int result = a;      // initialize result with a
	for(int i=1;i<b;i++){     // Hand Run this program to understand the logic
		for(int j=1;j<a;j++){
			result+=increment;
		}
		increment = result;
	}
	return result;
}
/*
Analysis:
	Time Complexity = O(a*b)
	Space Complexity = O(1)	
*/
private static int pow(int a, int b) {
	if(b==0)
		return 1;
	else
		return mutiply(a,pow(a,b-1));  // multiplication of (a * pow(a,b-1))
}

private static int mutiply(int a, int b) {
	if(b==0)
		return 0;
	else
		return a+mutiply(a,b-1);
}
}
/*
Analysis:
	Time Complexity = O(b^2)
	Space Complexity = O(1) // This is not the space complexity
	
*/