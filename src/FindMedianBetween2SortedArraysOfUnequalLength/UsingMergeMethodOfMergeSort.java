/*
Question: http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
Source: http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
		http://theoryapp.com/find-median-of-two-sorted-arrays/
*/
package FindMedianBetween2SortedArraysOfUnequalLength;

import java.util.Scanner;

public class UsingMergeMethodOfMergeSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements in the first SORTED array");
			int n = in.nextInt();
			int[] array1 = new int[n];
			System.out.println("Enter the elements of the first SORTED array");
			for(int i=0;i<n;i++)
				array1[i]=in.nextInt();
			System.out.println("Enter the number of elements in the second SORTED array");
			int m = in.nextInt();
			int[] array2 = new int[m];
			System.out.println("Enter the elements of the second SORTED array");
			for(int i=0;i<m;i++)
				array2[i]=in.nextInt();
			System.out.println("Median of the two SORTED arrays is: "+findMedianUsingMergeOfMergeSort(array1,array2));
		}
		finally{
			in.close();
		}
	}
	private static int findMedianUsingMergeOfMergeSort(int[] a, int[] b) {
		
	/*  a1 array and a2 array can be of different lengths.
		For Example:
	  1.
		a1.length = 3
		a2.length = 6
		totalElements = 3+6=9 (odd number)
	  2.
		a1.length = 4
		a2.length = 4
		totalElements = 4+4=8 (even number)
	*/
		int totalElements = a.length+b.length;  // totalElements is the addition of the individual array lengths
		int currentMedian = 0;
		int prevMedian = 0;
		int i=0; // Index for traversing array1
		int j=0; // Index for traversing array2
		for(int k=0;k<totalElements;k++){    // k is index for traversing the totalElements of array1 and array2
			
			
		/*NOTE: In this entire for loop, the "if", "else" and "else if" is VERY IMP. DONOT interchange among them*/
			
			// if array1 is exhausted
			if(i==a.length)
				currentMedian=b[j++]; // elements of the second array would be considered
			

			// if array2 is exhausted
			else if(j==b.length)
				currentMedian=a[i++]; // elements of the first array would be considered
			
			else if(a[i]<b[j])
				currentMedian=a[i++];
			
			else //(b[j]<=a[i])            // this condition is ONLY "else" and not "if" OR "else if"
				currentMedian=b[j++];
			 
			if(k==totalElements/2) // we reached the middle of the totalElements where the median of the combined arrays is found
				break;                 
			
			prevMedian = currentMedian;
			
		}
		
		// if the totalElements are odd
		if(totalElements%2!=0)
			return currentMedian;
		else
			return (prevMedian+currentMedian)/2;
	}
}
/*
Analysis:
	Time Complexity = Linear Time, O((m+n)/2)
	Space Complexity = O(1)
*/