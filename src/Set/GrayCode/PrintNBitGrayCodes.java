/*
Question: Given n, output the numbers from 0 to 2^n-1 (inclusive) 
in n-bit binary form, in such an order that adjacent numbers in the list differ by exactly 1 bit.

Question And Answer Source: http://www.careercup.com/question?id=15532723
http://www.geeksforgeeks.org/given-a-number-n-generate-bit-patterns-from-0-to-2n-1-so-that-successive-patterns-differ-by-one-bit/

Examples:

Definition Gray Code (Source: http://en.wikipedia.org/wiki/Gray_code):
The reflected binary code, also known as Gray code after Frank Gray, 
is a binary numeral system where two successive values differ in only one bit (binary digit). 
The reflected binary code was originally designed to prevent spurious output from electromechanical switches.
Today, Gray codes are widely used to facilitate error correction in digital communications 
such as digital terrestrial television and some cable TV systems.

Following is 2-bit sequence (n = 2)
  00 01 11 10
Following is 3-bit sequence (n = 3)
  000 001 011 010 110 111 101 100
And Following is 4-bit sequence (n = 4)
  0000 0001 0011 0010 0110 0111 0101 0100 1100 1101 1111 
  1110 1010 1011 1001 1000
*
*/

package Set.GrayCode;

import java.util.ArrayList;
import java.util.Scanner;

public class PrintNBitGrayCodes {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to print 0 to 2^(n)-1 numbers such that ADJ NUMBERS differ by 1 bit");
			System.out.println("Enter n");
			int n = in.nextInt();
			System.out.println("Using EXOR Algorithm: ");
			printNumbersUsingXOR(n);
			System.out.println("Using ArrayList: ");
			printNumbersUsingArrayList(n);
		}
		finally{
			in.close();
		}
	}


	private static void printNumbersUsingXOR(int n) {
		
		// USE THIS EFFICIENT METHOD IN INTERVIEWS
		for(int i=0;i<(int)Math.pow(2, n);i++){
			System.out.println(Integer.toBinaryString( (i>>1)^(i) )); // EXOR Operation between (value) and (value/2)    
		    // TR: toBinaryString(EXOR Operation between (value) and (value/2)) 
		}	
	}
	/*
	 *  Analysis:
	 * Time Complexity = O(2^n) where n = input integer
	 * Space Complexity = O(1)
	 */
	

	private static void printNumbersUsingArrayList(int n) {
		
		
		/*
		 * Algorithm Source: http://www.geeksforgeeks.org/given-a-number-n-generate-bit-patterns-from-0-to-2n-1-so-that-successive-patterns-differ-by-one-bit/
		 * 
		 *  ALGORITHM:
n-bit Gray Codes can be generated from list of (n-1)-bit Gray codes using following steps.
1) Let the list of (n-1)-bit Gray codes be L1. Create another list L2 which is reverse of L1.
2) Modify the list L1 by prefixing a ‘0’ in all codes of L1.
3) Modify the list L2 by prefixing a ‘1’ in all codes of L2.
4) Concatenate L1 and L2. The concatenated list is required list of n-bit Gray codes.

For example, following are steps for generating the 3-bit Gray code list from the list of 2-bit Gray code list.
L1 = {00, 01, 11, 10} (List of 2-bit Gray Codes)
L2 = {10, 11, 01, 00} (Reverse of L1)
Prefix all entries of L1 with ‘0’, L1 becomes {000, 001, 011, 010}
Prefix all entries of L2 with ‘1’, L2 becomes {110, 111, 101, 100}
Concatenate L1 and L2, we get {000, 001, 011, 010, 110, 111, 101, 100}

To generate n-bit Gray codes, we start from list of 1 bit Gray codes. 
The list of 1 bit Gray code is {0, 1}. We repeat above steps to generate 2 bit Gray codes
from 1 bit Gray codes, then 3-bit Gray codes from 2-bit Gray codes till the number of bits
 becomes equal to n. Following is C++ implementation of this approach.
*/
		
		// if n < = 0 then return
		if(n<=0)
			return;
		
		ArrayList<String> al = new ArrayList<String>();
		
		// start 1 bit pattern
		al.add(0,"0");               // 0th number. This add() method will add to a new index location
		al.add(1,"1");               // 1st number. This add() method will add to a new index location
		
		
		/*
		 * Loop to generate 2i codes from the previously generated i codes
		 * Start the loop from 2nd number to 2^(n)-1 
		 */
		
		for(int i=2;i<=n;i++){
			
			// Enter the previously generated codes again in ArrayList in reverse order
			for(int j=i-1;j>=0;j--)
				al.add(al.get(j));      // this add() method will add to a new index location
			
		
			// append 0 to the first half
			for(int j=0;j<i;j++)
				al.set(j, "0"+al.get(j)); // this set() method will overwrite the mentioned index location
									
			// append 1 to the second half
			for(int j=i;j<2*i;j++)
				al.set(j,"1"+al.get(j));  // this set() method will overwrite the mentioned index location
		}
		// print contents of ArrayList
		for(int i=0;i<al.size();i++)
			System.out.println(al.get(i));
	}
	/*
	 * NOTE: DONOT USE ARRAYLIST method in Interview. THIS METHOD IS NOT WORKING CORRECTLY
	 * Analysis:
	 * Time Complexity = O(n^2)
	 * Space Complexity = O(2^n)
	 */
}
