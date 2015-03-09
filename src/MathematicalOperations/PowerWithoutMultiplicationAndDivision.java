/*
Write you own Power without using multiplication(*) and division(/) operators
Source: http://www.geeksforgeeks.org/write-you-own-power-without-using-multiplication-and-division/
*/
package MathematicalOperations;

import java.util.Scanner;

public class PowerWithoutMultiplicationAndDivision {
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
/*
Algorithm:
	Method 1 - (Using Nested Loops)

	We can calculate power by using repeated addition.

	For example to calculate 5^6.
	1) First 5 times add 5, we get 25. (5^2)
	2) Then 5 times add 25, we get 125. (5^3)
	3) Then 5 time add 125, we get 625 (5^4)
	4) Then 5 times add 625, we get 3125 (5^5)
	5) Then 5 times add 3125, we get 15625 (5^6)
	
	Method 2 - (Using Recursion)
	Recursively add a to get the multiplication of two numbers. And recursively multiply to get a raise to the
	power b.
*/
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

