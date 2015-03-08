package PowerSetFromSetORPrintPermutations;

import java.util.Scanner;

public class PowerSetORPermutationIOfChracterArrayUsingBitIncrement {
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