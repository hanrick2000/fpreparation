package RotatedSortedArray;

import java.util.Scanner;

public class FindNumberOfRepeatedElementsInTheSortedArray {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		try{
		System.out.println("Find number of occurances in SORTED ARRAY, NOT ROTATED");
		System.out.println("THIS ARRAY IS NOT ROTATED");
		System.out.println("Enter the number of elements in the array");
		int n = in.nextInt();
		System.out.println("Enter the elements");
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		System.out.println("Enter the element to fnd its occurance");
		int find = in.nextInt();
		int first=usingModifiedBS(a,find,true);
		int last = usingModifiedBS(a,find,false);
		System.out.println("The number of occurances are: "+(last-first+1));
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
