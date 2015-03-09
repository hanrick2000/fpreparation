/*
Question: Detect if two integers have opposite signs

Source: http://www.geeksforgeeks.org/detect-if-two-integers-have-opposite-signs/

*/
package MathematicalOperations;

import java.util.Scanner;

public class CheckIfTwoNumbersHaveOppositeSign {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	System.out.println("Enter the two numbers to check for opposite signs");
	int a = in.nextInt();
	int b = in.nextInt();
	System.out.println("Using COMPARISON OPERATORS, the answer is: "+usingComparisonOperator(a,b));
	System.out.println("Using BITSHIFT OPERATORS, the answer is: "+usingBitwiseOperator(a,b));
	}
	finally{
		in.close();
	}
}

private static boolean usingComparisonOperator(int a, int b) {
	if((a>=0 && b<0)||(b>=0 && a<0))
		return true;
	else
		return false;
}

private static boolean usingBitwiseOperator(int a, int b) {
	/*
	Algorithm:
		Let the given integers be x and y. The sign bit is 1 in negative numbers, and 0 in positive numbers. 
		The XOR of x and y will have the sign bit as 1 iff they have opposite sign. In other words,
		XOR of x and y will be negative number number iff x and y have opposite signs.
	*/
	
	int result = (a^b);
	return ((result)&(1<<31))!=0;     // Check whether the sign bit is set or not
}
}
/*
Analysis:
	Time Complexity = O(1)
	Space Complexity = O(1)*/
