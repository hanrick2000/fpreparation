package MathematicalOperations;

import java.util.Scanner;

public class MathOperationSubstractUsingBitOpeartions {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
		System.out.println("Substraction Operation.");
		System.out.println("The first number can be greater or smaller. Similarly second number can be greater or smaller.");
		System.out.println("DONOT ENTER - SIGN. THE PROGRAM WILL CONSIDER THE SECOND NUMBER AS NEGATIVE");
		System.out.println("Enter the first positive number");
		int a = in.nextInt();
		System.out.println("Enter the second positive number");
		int b = in.nextInt();
		System.out.println("Substraction Result using + sign is: "+usingPlusSign(a,b));
		System.out.println("Substraction Result using bitwise operators is: "+usingBitwiseOperators(a,b));	
		}
		finally{
			in.close();
		}
	}
	private static int usingBitwiseOperators(int a, int b) {
		return add(a,add(~b,1));
	}

	private static int add(int i, int j) {
		int sum = 0;
		int carry = 0;
		while(j!=0){
			sum = i^j;
			carry = (i&j)<<1;
			i=sum;
			j=carry;
		} 
		return i;
	}
	private static int usingPlusSign(int a, int b) {
		int twosComplementOfSecondNumber = (~b+1);
		return (a+twosComplementOfSecondNumber);
	}
}
/*
Analysis:
	Time Complexity = O(n) for using bitwise shift operators since while loop is there
					= O(1) for using + operator
	Space Complexity = O(1)
*/