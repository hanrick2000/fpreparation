/*
 * Question: Find the cube of a number without using * sign. Algorithm should be in O(lgn) time
 * 
 */

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
	int multiplier1 = value;
	int multiplier2 = value;
	int original = value;            // store the original value
	boolean odd = value % 2 != 0;
	
	while (multiplier1 > 1) {
		value = value<<1;
		multiplier1 = multiplier1/2;
	}

	value = odd ? value + original : value;
	original = value;                        // original is now changed
	
	while (multiplier2 > 1) {
		value = value<<1;
		multiplier2 = multiplier2/2;
	}
	return odd ? value + original : value;
}
/*
 * Analysis:
 * Time Complexity = O(2 * lgn)
 * Space Complexity = O(1)
 */
public static int getCubeRecursively(int value) {
	int newValue = cube(value, value);
	return cube(newValue,value);
}

public static int cube(int value, int multiplier) {

	if (multiplier == 1) {
		return value;
	}
	
	if (multiplier % 2 == 0) 
		return cube (value << 1, multiplier / 2);
	else
		return cube(value << 1, multiplier / 2) + value;
}
/*
 * Analysis:
 * Time Complexity = O(2 * lgn)
 * Space Complexity = O(1)
 */
}
