package PowerSetFromSet;

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
	int totalElements = (int)Math.pow(2,set.length);
	for(int i=0;i<totalElements;i++){
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