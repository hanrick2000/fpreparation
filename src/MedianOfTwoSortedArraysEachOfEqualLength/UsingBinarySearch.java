/*
Question: We have two SORTED arrays, each of length n. We have to find the median of UNION of both arrays.

Question and Answer Source: http://www.geeksforgeeks.org/median-of-two-sorted-arrays/



Algorithm:

Method: By doing binary search for the median:
The basic idea is that if you are given two arrays ar1[] and ar2[] and know the length of each,
 you can check whether an element ar1[i] is the median in constant time. Suppose that the median
  is ar1[i]. Since the array is sorted, it is greater than exactly i values in array ar1[]. 
  Then if it is the median, it is also greater than exactly j = n – i – 1 elements in ar2[].
It requires constant time to check if ar2[j] <= ar1[i] <= ar2[j + 1]. If ar1[i] is not the median,
 then depending on whether ar1[i] is greater or less than ar2[j] and ar2[j + 1], 
 you know that ar1[i] is either greater than or less than the median. Thus you can
  binary search for median in O(lg n) worst-case time.

For two arrays ar1 and ar2, first do binary search in ar1[]. If you reach at the end 
(left or right) of the first array and don't find median, start searching in the second 
array ar2[].

1) Get the middle element of ar1[] using array indexes left and right.  
   Let index of the middle element be i.
2) Calculate the corresponding index j of ar2[]
     j = n – i – 1 
3) If ar1[i] >= ar2[j] and ar1[i] <= ar2[j+1] then ar1[i] and ar2[j]
   are the middle elements.
     return average of ar2[j] and ar1[i]
4) If ar1[i] is greater than both ar2[j] and ar2[j+1] then 
     do binary search in left half  (i.e., arr[left ... i-1])
5) If ar1[i] is smaller than both ar2[j] and ar2[j+1] then
     do binary search in right half (i.e., arr[i+1....right])
6) If you reach at any corner of ar1[] then do binary search in ar2[]
Example:

   ar1[] = {1, 5, 7, 10, 13}
   ar2[] = {11, 15, 23, 30, 45}
Middle element of ar1[] is 7. Let us compare 7 with 23 and 30, since 7 smaller than both 23 
and 30, move to right in ar1[]. Do binary search in {10, 13}, this step will pick 10. 
Now compare 10 with 15 and 23. Since 10 is smaller than both 15 and 23, again move to right.
 Only 13 is there in right side now. Since 13 is greater than 11 and smaller than 15, 
 terminate here. We have got the median as 12 (average of 11 and 13)

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

private static int medianOfSortedArraysEachOfEqualLength(int[] a1, int[] a2, int low1, int high1,
		int low2, int high2) {
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
/*
Analysis:
	Time Complexity = O(log(n+m))
    Space Complexity = O(1) */
