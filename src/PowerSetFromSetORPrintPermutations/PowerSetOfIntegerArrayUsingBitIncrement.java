
/*
NOTE: powerset and permutation are different things
For Example: input = [1,2,3]
Then Powerset = [null,1,2,3,12,23,13,123]
and Permutation = [123,132,312,321,213,231]
*/
package PowerSetFromSetORPrintPermutations;

import java.util.Scanner;

public class PowerSetOfIntegerArrayUsingBitIncrement {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the size of the integer array");
			int n = in.nextInt();
			System.out.println("Enter the elements of the integer array for powerset calculation");
			int[] set = new int[n];
			for(int i=0;i<n;i++)
				 set[i] = in.nextInt();
			printPowerSet(set);
		}
		finally{
			in.close();
		}
	}

	private static void printPowerSet(int[] set) {
		/*
		 * VERY IMP NOTE: If interviewer says that the input set contains duplicates and
		 * that we need to only print powerset elements which are NOT DUPLICATES,
		 * then in this case first call a REMOVE_DUPLICATES method which removes the 
		 * duplicate set elements from the input set and after the removal of duplicates when
		 * we get ALL UNIQUE elements in the set, then at that time we need to call 
		 * this pringPowerSet function with the UniqueElementSet passed as parameter
		 */
		
		for(int i=0;i<(int)Math.pow(2,set.length);i++){
			for(int j=0;j<set.length;j++){ // loop which checks which bit is set in integer i
				if(((i)&(1<<j))!=0) // HandRun this to understand how to check for set bits in an integer
// For each bit of integer i, check which of the bits are set.// HandRun the above statement in if condition, to understand how to check for set bits in an integer
				System.out.print(set[j]);  // If bit is set, then print the corresponding character
			}
			
			System.out.println();
		}
	}
}
/*
Analysis:
	Time Complexity = O(n*2^n)
	Space Complexity = O(1)*/