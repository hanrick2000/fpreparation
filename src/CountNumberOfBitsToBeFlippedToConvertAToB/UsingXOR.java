/*
Question: You are given two numbers A and B. Write a program to count number 
		  of bits needed to be flipped to convert A to B.
Source: http://www.geeksforgeeks.org/count-number-of-bits-to-be-flipped-to-convert-a-to-b/
*/
package CountNumberOfBitsToBeFlippedToConvertAToB;

import java.util.Scanner;

public class UsingXOR {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the two integers");
		int a=in.nextInt();
		int b=in.nextInt();
		System.out.println("Using XOR, the number of bits to be flipped to convert A to B is: "+usingXOR(a,b));
	}
	finally{
		in.close();
	}
}

private static int usingXOR(int a, int b) {
	int n = a^b;
	return countSetBits(n);
}

private static int countSetBits(int n) {
	int count = 0;
	while(n>0){
		n&=(n-1);
		count++;
	}
	return count;
	}
}
