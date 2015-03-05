/*
Question: A Rotated Sorted Array contains duplicate elements
		  Find the first and last occurance of an element in the REPEATED SORTED ARRAY
		
Quetion And Answer Source: https://www.youtube.com/watch?v=OE7wUUpJw6I

Algorithm:

*/
package RotatedSortedArray;

import java.util.Scanner;

public class FindFirstAndLastOccuranceOfNumberInSortedArray {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		try{
		System.out.println("Find FIRST and LAST occurance of an element in a SORTED array, NOT ROTATED");
		System.out.println("THIS ARRAY IS NOT ROTATED");
		System.out.println("Enter the number of elements in the array");
		int n = in.nextInt();
		System.out.println("Enter the elements");
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		System.out.println("Enter the element of search");
		int find = in.nextInt();
		System.out.println("The FIRST occurance is at "+usingModifiedBS(a,find,true)+" index");
		System.out.println("The LAST occurance is at "+usingModifiedBS(a,find,false)+" index");
		}
		finally{
			in.close();
		}
	}

	private static int usingModifiedBS(int[] a, int find, boolean firstOccurance) {
		
		
		int result = -1;
		int low = 0;
		int high = a.length-1;
		int mid = 0;
		while(low<=high){
			
			mid = low+(high-low)/2;
			
			if(a[mid]==find){
				result = mid;
				if(firstOccurance)
					high=mid-1;
				else
					low=mid+1;
			}
			
			else if(a[mid]>find)
				high=mid-1;
			else
				low=mid+1;
			
		}
		
		return result;
		
	}
}
/*
 * Analysis:
 * Time Complexity = O(lgn)
 * Space Complexity = O(1)
 */
