/*
Question: Given n, output the numbers from 0 to 2^n-1 (inclusive) 
in n-bit binary form, in such an order that adjacent numbers in the list differ by exactly 1 bit.

Question And Answer Source: http://www.careercup.com/question?id=15532723
http://www.geeksforgeeks.org/given-a-number-n-generate-bit-patterns-from-0-to-2n-1-so-that-successive-patterns-differ-by-one-bit/

Examples:

Following is 2-bit sequence (n = 2)
  00 01 11 10
Following is 3-bit sequence (n = 3)
  000 001 011 010 110 111 101 100
And Following is 4-bit sequence (n = 4)
  0000 0001 0011 0010 0110 0111 0101 0100 1100 1101 1111 
  1110 1010 1011 1001 1000
*
*/

package GrayCode;

import java.util.Scanner;

public class PrintNBitGrayCodes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to print 0 to 2^(n)-1 numbers such that ADJ NUMBERS differ by 1 bit");
			System.out.println("Enter n");
			int n = in.nextInt();
			printNumbers(n);
		}
		finally{
			in.close();
		}
	}

	private static void printNumbers(int n) {
		for(int i=0;i<(int)Math.pow(2, n);i++){
			System.out.println(Integer.toBinaryString( (i>>1)^(i) )); //EXOR Operation between (i) and (i>>1)    
		}	
	}
	/*
	 *  Analysis:
	 * Time Complexity = O(2^n) where n = input integer
	 * Space Complexity = O(1)
	 */
}
