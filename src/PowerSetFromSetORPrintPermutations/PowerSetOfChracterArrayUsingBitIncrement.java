/*
NOTE: POWERSET and PERMUTATION are DIFFERENT things
For Example: input = [1,2,3]
Then Powerset = [null,1,2,3,12,23,13,123]
and Permutation = [123,132,312,321,213,231]

BUT POWERSET and SUBSETS are one and the SAME

1. For Example: input = [1,2,3]     <----- UNIQUE elements
Then Powerset = [[],1,2,3,12,23,13,123]
Then Subsets = [[],1,2,3,12,23,13,123]   

NOTE: This question is know as subsets I question in leetcode

1. For Example: input = [1,2,2]     <----- DUPLICATE elements
Then Powerset = [[],1,2,12,22,122]
Then Subsets = [[],1,2,12,22,122]

NOTE: This question is know as subsets II question in leetcode

VERY IMP SUMMARY:
1. Powerset and subsets ARE SAME
2. Powerset and Permutations ARE DIFFERENT
3. Powerset with UNIQUE input is known as Subsets I question in leetcode
4. Powerset with DUPLICATE input is known as Subsets II question in leetcode
*/

package PowerSetFromSetORPrintPermutations;

import java.util.Scanner;

public class PowerSetOfChracterArrayUsingBitIncrement {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the string for powerset calculation");
		String s = in.nextLine();
		char[] set = s.toCharArray();
		printPowerSet(set);
	}
	finally{
		in.close();
	}
}

private static void printPowerSet(char[] set) {
	/*
	 * VERY IMP NOTE: If interviewer says that the input set contains duplicates and
	 * that we need to only print powerset elements which are NOT DUPLICATES,
	 * then in this case first call a REMOVE_DUPLICATES method which removes the 
	 * duplicate set elements from the input set and after the removal of duplicates when
	 * we get ALL UNIQUE elements in the set, then at that time we need to call 
	 * this pringPowerSet function with the UniqueElementSet passed as parameter
	 */
	int totalElements = (int)Math.pow(2,set.length);
	for(int i=0;i<totalElements;i++){    // i is the bitCounter which starts from 0000 and goes till 0111
		for(int j=0;j<set.length;j++){
			if(((i) & (1<<j))!=0)   // For each bit of integer i, check which of the bits are set.
				// HandRun the above statement in if condition, to understand how to check for set bits in an integer
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