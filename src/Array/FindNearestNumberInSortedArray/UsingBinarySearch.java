/*
Question: Given - a number (n) and a sorted array 
Find a number in the array having least difference with the given number (n).

Question Source: http://www.careercup.com/question?id=20982670
	
Answer Source: Facebook Question: https://sites.google.com/site/spaceofjameschen/home/search/find-a-number-in-the-array-having-least-difference-with-the-given-number-n----facebook
*/
package Array.FindNearestNumberInSortedArray;

import java.util.Scanner;

public class UsingBinarySearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements in the SORTED array");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the elements of the array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("Enter a number to find the nearest element in the array");
			int find = in.nextInt();
			System.out.println("The nearest number in the SORTED array is: "+findNearestElementInSORTEDArray(a,find));
		}
		finally{
			in.close();
		}
	}
	
	/*
	 * Works for all cases including negative and positive numbers
	 */
	private static int findNearestElementInSORTEDArray(int[] a, int find) {
		
		if(a.length==0||a==null)
			return -1;
		
		// CHECK FOR 3 CASES
		
		//CASE I. If there is only one element in the array then return that element as the nearest element
		if(a.length==1)
			return a[0];
		
		//CASE II. If the find element is less than the first element
		if(find<a[0])
			return a[0];
		
		//CASE III. If the find element is larger than the last element in the array
		if(find>a[a.length-1])
			return a[a.length-1];
		
		// Now we search the nearest element using Binary Search
		
		int low = 0;
		int high = a.length-1;
		int mid = 0;
		while(low<=high){
			
			mid = low+(high-low)/2;
			
			if(find == a[mid])
				return a[mid];
			
			if(find<a[mid])
				high=mid-1;
			
			else
				low=mid+1;
			
		}
		
		return (Math.abs(a[low]-find) < Math.abs(a[high]-find) ? a[low]:a[high]);
	}
}
/*
Analysis:
Time complexity = O(lgn)
Space complexity = O(1)
*/