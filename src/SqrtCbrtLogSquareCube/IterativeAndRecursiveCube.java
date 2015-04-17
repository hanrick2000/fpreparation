package SqrtCbrtLogSquareCube;

import java.util.Scanner;

public class IterativeAndRecursiveCube {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter a number to find cube in lgn time without using * operator");
			int n = in.nextInt();
			System.out.println("The cube of the number iteratively is: "+getCubeIteratively(n));
			System.out.println("The cube of the number recursively is: "+getCubeRecursively(n));
		}
		finally{
			in.close();
		}
	}
public static int getCubeIteratively(int value) {
	int multiplier = value;          
	int original = value;            // store the original value
	boolean odd = value % 2 != 0;
	
	while (multiplier > 1) {
		value = value<<2;
		multiplier = multiplier/2;
	}

	return odd ? value + original : value;
}
/*
 * Analysis:
 * Time Complexity = O(lgn)
 * Space Complexity = O(1)
 */
public static int getCubeRecursively(int value) {
	return cube(value, value);
}

public static int cube(int value, int multiplier) {

	if (multiplier == 1) {
		return value;
	}
	
	if (multiplier % 2 == 0) 
		return cube (value << 2, multiplier / 2);
	
	return cube(value << 2, multiplier / 2) + value;
}
/*
 * Analysis:
 * Time Complexity = O(lgn)
 * Space Complexity = O(1)
 */
}
