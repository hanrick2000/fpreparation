/*

Question: Use a quickselect algorithm to find the kth smallest element in the array

Question Source: 	http://www.careercup.com/question?id=15435963
	http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
*/

package KthSmallestElementInUnsortedArray;

import java.util.Scanner;

public class IterativeQuickSelect {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to find the kth SMALLEST element in the array");
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			int[] a=new int[n];
			System.out.println("Enter the elements of the array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("Enter the kth element");
			int k = in.nextInt();
			System.out.println("The kth smallest element in the array is: "+usingIterativeQuickSelect(a,0,a.length-1,k));
		}
		finally{
			in.close();
		}
	}

	private static String usingIterativeQuickSelect(int[] a, int i, int j, int k) {
		// TODO Auto-generated method stub
		return null;
	}


}
/*
Analysis:
(Analysis Source: http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/)
Worst Case Time Complexity = O(n^2)
Best and Average Case Time Complexity = O(n)
Space Complexity = O(1)
*/