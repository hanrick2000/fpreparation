/*
Question: Find maximum number in an array which is first increasing and then decreasing

Question and Answer Source: http://www.geeksforgeeks.org/find-the-maximum-element-in-an-array-which-is-first-increasing-and-then-decreasing/

Algorithm:
	We can modify the standard Binary Search algorithm for the given type of arrays.
	i) If the mid element is greater than both of its adjacent elements, then mid is the maximum.
	ii) If mid element is greater than its next element and smaller than the previous element then maximum 
	lies on left side of mid. Example array: {3, 50, 10, 9, 7, 6}
	iii) If mid element is smaller than its next element and greater than the previous element then maximum 
	lies on right side of mid. Example array: {2, 4, 6, 8, 10, 3, 1}
	

Extreme Cases: No decreasing part OR No increasing part

Input: arr[] = {8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1}
Output: 500

Input: arr[] = {1, 3, 50, 10, 9, 7, 6}
Output: 50

Corner case (No decreasing part)
Input: arr[] = {10, 20, 30, 40, 50}
Output: 50

Corner case (No increasing part)
Input: arr[] = {120, 100, 80, 20, 0}
Output: 120


*/
package Array.FindMaxInIncreasingDecreasingArray;

import java.util.Scanner;

public class UsingBinarySearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the elements of the array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("The max element is: "+usingBinarySearch(a,0,a.length-1));
		}
		finally{
			in.close();
		}
	}

	private static int usingBinarySearch(int[] a, int low, int high) {
		
		 /* Base Case: Only one element is present in arr[low..high]*/
		
		
		/*
		 * This if case handles the case when there is only one element in the array
		 */
		
		if(low==high)
			return a[low];
		
		
		/*
		 * The below TWO if cases handles the cases when there are
		 * EXACTLY two elements in the array
		 */
		
		
		/* If there are two elements and first is greater then
	      the first element is maximum */
		if((high==low+1)&&(a[low]>a[high]))
			return a[low];
		
		/* If there are two elements and second is greater then
	      the second element is maximum */
		if((high==low+1)&&(a[high]>a[low]))
			return a[high];
		
		
		
		/*
		 * The below code handles the cases when there are
		 * EXACTLY three OR more than three elements in the array
		 */
		
		
		
		int mid = low+(high-low)/2;
		
		 /* If we reach a point where arr[mid] is greater than both of
	     its adjacent elements arr[mid-1] and arr[mid+1], then arr[mid]
	     is the maximum element*/
		if((a[mid]>a[mid-1] && a[mid]>a[mid+1]))
			return a[mid];
		
		/* If arr[mid] is greater than the next element and smaller than the previous 
	    element then maximum lies on left side of mid */
		if((a[mid]>a[mid+1]) && (a[mid]<a[mid-1]))
			return usingBinarySearch(a, low, mid-1);
		else// when arr[mid] is greater than arr[mid-1] and smaller than arr[mid+1]
			return usingBinarySearch(a, mid+1,high);
				
		
	}
}
/*
 * Analysis:
 * Time Complexity = O(lgn)
 * Space Complexity = O(1)
 */
