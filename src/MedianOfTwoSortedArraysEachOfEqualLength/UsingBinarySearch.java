/*
Question: We have two SORTED arrays, each of length n. We have to find the median of UNION of both arrays.

* TODO: This solution is INCOMPLETE
*/
package MedianOfTwoSortedArraysEachOfEqualLength;

import java.util.Scanner;

public class UsingBinarySearch {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	System.out.println("Enter the size of each of the two arrays");
	int n = in.nextInt();
	int[] a1= new int[n];
	int[] a2 = new int[n];
	System.out.println("Enter the elements of the first array");
	for(int i=0;i<n;i++)
		a1[i] = in.nextInt();
	System.out.println("Enter the elements of the second array");
	for(int i=0;i<n;i++)
		a2[i] = in.nextInt();
	
	System.out.println(medianOfSortedArraysEachOfEqualLength(a1,a2,0,a1.length-1,0,a2.length-1));
	}
	finally{
		in.close();
	}
}

private static int medianOfSortedArraysEachOfEqualLength(int[] a1, int[] a2, int low1, int high1, int low2, int high2) {
	// Using Binary Search
	int mid1 = findMedian(a1, low1, high1);
	int mid2 = findMedian(a2, low2, high2);

	if((a1[mid1] >= a2[mid2]) && (a1[mid1] <= a2[mid2+1]) && (mid1<=high1 && mid1>=low1) && (mid2<=high2 && mid2>=low2))
		return ((a1[mid1]+a2[mid2])/2);
	
	if((a1[mid1] <= a2[mid2]) && (a1[mid1] <= a2[mid2+1]) && (mid1<=high1) && (mid2<=high2)){
		low1 = mid1+1;   // for traversal in first array
		high2 = mid2-1;  // for traversal in second array
		medianOfSortedArraysEachOfEqualLength(a1,a2,low1,high1,low2,high2);
	}
	
	if((a1[mid1] >= a2[mid2]) && (a1[mid1] >= a2[mid2+1])  && (mid1<=high1 && mid1>=low1) && (mid2<=high2 && mid2>=low2)){
		high1=mid1-1;  // for traversal in first array
		low2 = mid2+1; // for traversal in second array
		medianOfSortedArraysEachOfEqualLength(a1,a2,low1,high1,low2,high2);
	}	
	
	return 0;
	
}

private static int findMedian(int[] a, int low, int high) {
	return ((low+high)/2);
}
}
