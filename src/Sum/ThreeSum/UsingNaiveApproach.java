/*
 * Question:
Given an array of integers, return one set of 3 elements such that the 3 numbers add up to zero
(VERY IMP NOTE: REPETITIONS OF ELEMENTS ARE ALLOWED) 
{10, -2, -1, 3} -> true 
{10, -2, 1} -> true -2 + 1 +1 =0
 *
 * Source: http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 * 
 * Algorithm : This is a THREE SUM PROBLEM:
 *             Generate all possible three set sums and check whether any of them matches with the given sum.
 * 			   1. Run first loop from i to arraySize
 *  		      1.1 Run second loop from j=i+1 to arraySize
 *                    1.1.1 Run third loop from k=j+1 to arraySize
 *                          Check if array[i]+array[j]+array[k]=Sum
 *                          
 */


package Sum.ThreeSum;

import java.util.Scanner;

public class UsingNaiveApproach {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the number of elements in the array");
		int n = in.nextInt();
		int[] array = new int[n];
		System.out.println("Enter the elements of the array");
		for(int i=0;i<n;i++)
			array[i]=in.nextInt();
		System.out.println("Enter the sum that you need to find in the array");
		int sum = in.nextInt();
		System.out.println("The elements whose addition returns the sum are: ");
		usingNaiveApproach(array,sum);
	}
	finally{
		in.close();
	}
}

private static void usingNaiveApproach(int[] array, int sum) {
	outerloop:                               // label the outer loop
	for(int i=0;i<array.length;i++)
		for(int j=i+1;j<array.length;j++)
			for(int k=j+1;k<array.length;k++)
				if(array[i]+array[j]+array[k]==sum){
					System.out.println(array[i]+" "+array[j]+" "+array[k]);
					break outerloop;         // break the outer loop so that all internal loops are also broken           
				}
}

}
/*
 * Analysis:
 * Time Complexity = O(n^3)
 * Space Complexity = O(1)
 */
