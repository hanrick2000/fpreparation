/*
Question: Multiply two numbers using bitwise operations
Source: http://www.geeksforgeeks.org/fast-multiplication-method-without-using-multiplication-operator-russian-peasants-algorithm/

Algorithm:
	Let the two given numbers be 'a' and 'b'
	1) Initialize result 'res' as 0.
	2) Do following while 'b' is greater than 0
	   a) If 'b' is odd, add 'a' to 'res'
	   b) Double 'a' and halve 'b'
	3) Return 'res'. 
*/
package MultiplyTwoNumbersUsingBitwiseOperators;

import java.util.Scanner;

public class UsingRussianPeasantAlgorithm {
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
		
		if((b&1)!=0)   // check if 2nd number is odd
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