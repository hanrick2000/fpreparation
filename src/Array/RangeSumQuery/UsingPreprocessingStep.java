/*
Question: How to find sum of elements from given index interval (i, j) in constant time?
Given an array. How can we find sum of elements in index interval (i, j) in constant time. 
You are allowed to use extra space.
Example:
Array: 3 2 4 7 1 -2 8 0 -4 2 1 5 6 -1 
 * 
 * Question Source: http://www.careercup.com/question?id=14582042
 * 
 * Answer Source: http://stackoverflow.com/questions/2473114/how-to-find-sum-of-elements-from-given-index-interval-i-j-in-constant-time
 * http://www.careercup.com/question?id=14582042
 */

package Array.RangeSumQuery;

import java.util.Arrays;
import java.util.Scanner;

public class UsingPreprocessingStep {
	static int[] array;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
		System.out.println("Enter the number of elements in the array");
		int n = in.nextInt();
		System.out.println("Enter the elements of the array");
		array=new int[n];
		for(int i=0;i<n;i++)
			array[i]=in.nextInt();
		int[] aux=preprocessing(array);
		
		System.out.println("Solution: "+solveQuery(aux,0,3));
		}
		finally{
			in.close();
		}
	}

	private static int solveQuery(int[] aux, int i, int j) {
		if(i<0 || j>array.length-1)
			return -1;
		
		return (aux[j+1]-aux[i]);   // return(J+1 - I)   [TR: (plus,plus,minus) Jadeja scored +1 and returned to India]
	}

	private static int[] preprocessing(int[] array) {
		if(array.length==0||array==null)
			return null;
		
		int[] aux=new int[array.length+1];
		aux[0]=0;
		
		for(int i=1;i<=array.length;i++)
			aux[i]=aux[i-1]+array[i-1];     // This loop calculates the SUM OF ALL PREVIOUS elements in the array
		
		System.out.println(Arrays.toString(aux));
		return aux;
	}
}
/*
Analysis:
PreProcessing Step :
	Time Complexity = O(n)
	Space Complexity = O(n)
Query Step:
	Time Complexity = O(1)
	Space Complexity = O(1)
*/