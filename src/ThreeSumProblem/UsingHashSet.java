/*
 * Question:
Given an array of integers, return one set of 3 elements such that the 3 numbers add up to zero
(VERY IMP NOTE: REPETITIONS OF ELEMENTS ARE ALLOWED) 
{10, -2, -1, 3} -> true 
{10, -2, 1} -> true -2 + 1 +1 =0
 *
 * Source: http://www.careercup.com/question?id=5736292639834112
 * 
 * Algorithm : This is a THREE SUM PROBLEM:
 * 			   1. Store all elements in a HashSet
 *             2. for i=0 to array.length
 *                     for j = i to array.length
 *                          check if [-(i+j)] exists in HashMap OR HashSet
 *                          
 * VERY IMPORTANT NOTE:
 * 1. If the array elements can contain duplicates then we are forced to use HashMap, since HashSet would overwrite
 * on duplicate elements(thus not allowing duplicates) since same values will hash to the same bucket location
 * 
 * 2. However, if the interviewer says that duplicates are not present in the array, then we can use HashSet
 * 
 */


package ThreeSumProblem;

import java.util.HashSet;
import java.util.Scanner;

public class UsingHashSet {
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
		findThreeSumUsingHashSet(array,sum);
	}
	finally{
		in.close();
	}
}

private static void findThreeSumUsingHashSet(int[] array, int sum) {
	// store the array elements in the HashMap
	HashSet<Integer> set = new HashSet<Integer>();
	for(int element: array)
		set.add(element);
	// iterate through the array elements and check whether the third is in the HashMap
	outerloop:                          // using label in Java to break the outer loop
	for(int i=0;i<array.length;i++)
		for(int j=i+1;j<array.length;j++)  // start from the next element
			if(set.contains(sum-(array[i]+array[j]))){   // time complexity of contains method of HashSet is O(1)
				System.out.print(array[i]+" "+array[j]+" "+(sum-(array[i]+array[j])));
				break outerloop;     // we can use labels to break directly the outer loop (which in turn breaks inner loop)
			}                       // Otherwise, we would have to implement some mechanism to break both the loops simultaneously
	
	}
}
/*
 * Analysis:
 * Time Complexity = O(n^2) since time complexity of contains is O(1) and two for loops account for O(n^2) time
 * Space Complexity = O(n)
 */
