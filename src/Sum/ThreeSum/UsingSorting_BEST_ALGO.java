/*
 * Question:
Given an array of integers, return one set of 3 elements such that the 3 numbers add up to zero
(VERY IMP NOTE: REPETITIONS OF ELEMENTS ARE ALLOWED) 
{10, -2, -1, 3} -> true 
{10, -2, 1} -> true -2 + 1 +1 =0
 *
 * Question and Answer Source: http://www.programcreek.com/2012/12/leetcode-3sum/ 
 * http://www.geeksforgeeks.org/find-a-triplet-that-sum-to-a-given-value/
 * 
 * Algorithm : This is a THREE SUM PROBLEM:
 *             Sort the array and then apply the Two Sum Logic
 *             1. Sort the array
 *             2. Run a loop starting from i=0 to (arraySize-2) 
 *                2.1 Take a fixed element as fixedElement = array[i]
 *                2.2 Find the other two elements from the SORTED ARRAY CORNERS
 *                    low = [i+1]    // Next Element
 *                    high = [arraySize-1]     // last element of the array
 *                         2.2.1 while(low<high)
 *                         		 Check if(fixed+low+high == sum). If yes then print the elements and break
 *                                     if(fixed+low+high < sum). Then low++
 *                                     if(fixed+low+high > sum). Then high--
 */


package Sum.ThreeSum;

import java.util.Arrays;
import java.util.Scanner;

public class UsingSorting_BEST_ALGO {
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
		usingSorting(array,sum);
	}
	finally{
		in.close();
	}
}

private static void usingSorting(int[] array, int sum) {
	// EXTREME CASE
	if(array.length<3 || array==null)
		System.out.println("Three sum cannot be found as MIN 3 numbers are required in the array");
	
	int low=0;
	int high=0;
	/* Sort the elements */
	Arrays.sort(array);
	/* Now fix the first element one by one and find the
    other two elements */
	outerloop:
	for(int i=0;i<(array.length-2);i++){
		// To find the other two elements, start two index variables
        // from two corners of the array and move them toward each
        // other
		low=i+1;
		high = array.length-1;
		while(low<high){
			if(array[i]+array[low]+array[high]==sum){
				System.out.println(array[i]+" "+array[low]+" "+array[high]);
				break outerloop;
			}
			else if(array[i]+array[low]+array[high]<sum)
				low++;
			else //(array[i]+array[low]+array[high]>sum)
				high--;
			
		}
	}
}



}
/*
 * Analysis:
 * Time Complexity = O(n^2) due to nested for and while loop
 * Space Complexity = O(1)
 */
