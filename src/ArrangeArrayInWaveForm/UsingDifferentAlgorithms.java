/*
Question: Given an unsorted array of integers, sort the array into a
		  wave like array. An array �arr[0..n-1]� is sorted in wave form if 
		  arr[0] >= arr[1] <= arr[2] >= arr[3] <= arr[4] >= �..
Source: http://www.geeksforgeeks.org/sort-array-wave-form-2/
*/
package ArrangeArrayInWaveForm;

import java.util.Arrays;
import java.util.Scanner;

public class UsingDifferentAlgorithms {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	System.out.println("Enter the size of integer array");
	int n = in.nextInt();
	int[] array = new int[n];
	int[] result1 = new int[n];
	int[] result2 = new int[n];
	System.out.println("Enter the elements of the array");
	for(int i=0;i<n;i++)
		array[i]=in.nextInt();
	result1 = usingSorting(array);
	result2 = usingIntelligentAlgorithm(array);
	System.out.println("Using sorting we get: ");
	printArray(result1);
	System.out.println("Using intelligent algorithm we get: ");
	printArray(result2);
	}
	finally{
		in.close();
	}
}

private static int[] usingIntelligentAlgorithm(int[] array) {
	for(int i=0;i<array.length;i=i+2){
		if(i>0 && (array[i-1]>array[i]))  // this will take care of last element((n-1)th element) comparison with second last element((n-2)th element)
			swapElements(array, i-1, i);
		if(i<array.length-1 && (array[i+1])>array[i])  // this will take care of 1st index element comparison with 0th index element
			swapElements(array, i+1, i);
	}
	return array;
}
/*
Analysis:
	Time Complexity = O(n)
	Space Complexity = O(1)
*/

private static void printArray(int[] array) {
	for(int i=0;i<array.length;i++)
		System.out.print(array[i]+" ");
	System.out.println();
}

private static int[] usingSorting(int[] array) {
	Arrays.sort(array);
	// Swap the elements in the alternate position
	for(int i=0;i<(array.length-1);i=i+2){ // this loop will run till (array.length-2)
		swapElements(array,i,i+1);
	}
	return array;
}
/*
Analysis:
	Time Complexity = O(nlgn)
	Space Complexity = O(1)
*/
private static void swapElements(int[] array, int i, int j) {
	array[i]=array[i]^array[j];
	array[j]=array[i]^array[j];
	array[i]=array[i]^array[j];
	//return array;
}
}
