package SqrtCbrtLogSquareCube;

import java.util.Scanner;

public class IterativeAndRecursiveSquare {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter a number to find square in lgn time without using * operator");
			int n = in.nextInt();
			System.out.println("The square of the number iteratively is: "+getSquareIteratively(n));
			System.out.println("The square of the number recursively is: "+getSquareRecursively(n));
		}
		finally{
			in.close();
		}
	}
public static int getSquareIteratively(int value) {
	int multiplier = value;          
	int original = value;            // store the original value
	boolean odd = value % 2 != 0;
	
	while (multiplier > 1) {
		value = value<<1;
		multiplier = multiplier/2;
	}

	return odd ? value + original : value;
}
/*
 * Analysis:
 * Time Complexity = O(lgn)
 * Space Complexity = O(1)
 */
public static int getSquareRecursively(int value) {
	return square(value, value);
}

public static int square(int value, int multiplier) {

	if (multiplier == 1) {
		return value;
	}
	
	if (multiplier % 2 == 0) 
		return square (value << 1, multiplier / 2);
	
	return square(value << 1, multiplier / 2) + value;
}
/*
 * Analysis:
 * Time Complexity = O(lgn)
 * Space Complexity = O(1)
 */
}