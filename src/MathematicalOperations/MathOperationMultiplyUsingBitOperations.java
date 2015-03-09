package MathematicalOperations;

import java.util.Scanner;

public class MathOperationMultiplyUsingBitOperations {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the two numbers for multiplication");
			int a = in.nextInt();
			int b = in.nextInt();
			if((a<0 && b<0)||(a>0 && b>0))
				System.out.println(multiplyUsingRussianPeasantAlgorithm(Math.abs(a),Math.abs(b)));
			else
				System.out.println(-(multiplyUsingRussianPeasantAlgorithm(Math.abs(a),Math.abs(b))));
		}
		finally{
			in.close();
		}
	}

	private static int multiplyUsingRussianPeasantAlgorithm(int a, int b) {
		int result = 0;
		while(b>0){
			
			if((b&1)!=0)   // check if multiplicant(i.e. second number) is odd
				result=result+a;
			
			// double first number
			a=a<<1;
			
			// half the second number
			b=b>>1;
		}
		return result;
	}
}
/*
Analysis:
	Time Complexity = O(nlgn) where n = 2nd number
	Space Complexity = O(1)
*/