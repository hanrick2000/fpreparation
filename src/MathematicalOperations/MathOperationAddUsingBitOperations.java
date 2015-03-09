package MathematicalOperations;

import java.util.Scanner;

public class MathOperationAddUsingBitOperations {
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter two integers for addition");
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println("Addition result is: "+additionUsingBitwiseShiftOperators(a,b));
			System.out.println("Using bitwise operators recursively: "+usingRecursiveBitwiseShiftOperators(a,b));
		}
		finally{
			in.close();
		}
	}
	public static int additionUsingBitwiseShiftOperators(int a, int b){
		
		// EXOR gives SUM
		int sum=0;
		// AND gives CARRY
		int carry=0;
		while(b!=0){
			sum = a^b;
			carry = a&b<<1;
			// copy sum to X
			a=sum;
			// copy left shift carry by 1 to Y
			b=carry;
		}
		return a;
	}
	public static int usingRecursiveBitwiseShiftOperators(int a, int b){
		if(b==0)
			return a;
		else
			return usingRecursiveBitwiseShiftOperators((a^b),(a&b)<<1);
	}
}
/*
 Analysis:
	Time Complexity = O(n), since we are dealing with while loop 
	Space Complexity = O(1)
*/
