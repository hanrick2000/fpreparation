/*
Question: Find how many times is a sorted array rotated?

Question and Answer Source: https://www.youtube.com/watch?v=4qjprDkJrjY 

Algorithm: We need find an element which has the following property. We will call this element as PIVOT
			a[pivot] < a[next]
			a[pivot] < a[previous]
			
			The index of the pivot element is the number of times the SORTED array is ROTATED
			
			
			To find such an element we will use Binary Search

	IMP NOTE: The elements of the ARRAY SHOULD BE UNIQUE. If not unique then the answer 
			  MIGHT not be correct
		
*/
package RotatedSortedArray;

import java.util.Scanner;

public class NumberOfTimesSortedArrayIsRotated {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		try{
		System.out.println("Find how many times is a sorted array ROTATED");
		System.out.println("The elements of the ARRAY SHOULD BE UNIQUE");
		System.out.println("Enter the number of elements in the array");
		int n = in.nextInt();
		System.out.println("Enter the elements");
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		System.out.println("The SORTED array is ROTATED "+usingModifiedBS(a)+" times");
		}
		finally{
			in.close();
		}
	}

	private static int usingModifiedBS(int[] a) {
		
		if(a==null||a.length==0)
			return -1;
		
		int low = 0;
		int high = a.length-1;
		int mid = 0;
		
		while(low<=high){
			
			// EXACTLY one number in the array
			if(low==high)
				return low;
			
			// EXACTLY two numbers in the array where a[low]<=a[high]
			if((low==high-1) && (a[low] <= a[high]))
				return low;
			
			// EXACTLY two numbers in the array where a[low]>a[high]
			if((low==high-1) && (a[low] > a[high]))
				return high;
					
			
			
			
			
			
			
			
			
			
			// MORE than two numbers present in the array
			
			// We handle 4 cases. VERY IMP CASE is Case 1: NOT ROTATED
			mid = low+(high-low)/2;
			
			// case 1: Not rotated
			if(a[low] <= a[high])
				return low;
			
			// find the next and the previous index which are required by the REMAINING CASES
			int prev = (mid-1+a.length)%a.length;
			int next = (mid+1+a.length)%a.length;
			
			
			// case 2: the mid is the pivot
			if(a[mid]<=a[next] && a[mid]<=a[prev])
				return mid;
			
			// case 3: the lower half is sorted hence pivot is in upper half
			else if(a[mid] >= a[low])
				low=mid+1;                                                          // VERY IMP
			
			// case 4: the upper half is sorted hence the pivot is in lower half
			else if(a[mid]<=a[high])
				high=mid-1;															// VERY IMP
		}
		
		return -1; // the array is not sorted
	}
}
/*
 * Analysis:
 * Time Complexity = O(lgn)
 * Space Complexity = O(1)
 */
