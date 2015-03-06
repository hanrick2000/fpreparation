/*
Question: http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
Source: http://algorithmsandme.blogspot.com/2014/12/find-median-of-two-sorted-arrays-of.html#.VLNiR5_0_VN
		http://algorithmsandme.blogspot.in/2014/12/fins-kth-smallest-element-in-two-sorted.html#.VLNiz5_0_VN
	    http://www.geeksforgeeks.org/median-of-two-sorted-arrays/
	    http://www.programcreek.com/2012/12/leetcode-median-of-two-sorted-arrays-java/
*/
package MedianBetween2SortedArraysOfUnequalLength;

import java.util.Arrays;
import java.util.Scanner;

public class UsingKthSmallestElementLogic_BEST_ALGO {
	
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
		System.out.println("Median of the two SORTED arrays is: "+findMedian(array1,array2,array1.length,array2.length));
	}
	finally{
		in.close();
	}
}
private static int findMedian(int[] a, int[] b,
		int aLength, int bLength) { 
	
	int left = (aLength+bLength+1)>>1;
	int right = (aLength+bLength+2)>>1;
	return ((findKthSmallestElement(a,b,a.length,b.length,left)+findKthSmallestElement(a,b,a.length,b.length,right))/2);
}
private static int findKthSmallestElement(int[] a, int[] b,
		int aLength, int bLength, int k) {                    // All the 5 parameters passed are VERY VERY IMP
	
	/* to maintain uniformity, we will assume that size_a is smaller than size_b
    else we will swap array in call :) */
	if(aLength>bLength)
		return findKthSmallestElement(b, a, bLength, aLength, k);
	
	/* We have TWO BASE CASES
	 * Now case when size of smaller array is 0 i.e there is no elemt in one array*/
    //BASE CASE 1. If the smallest array length is 0
	if(aLength == 0 && bLength > 0)
            return b[k-1]; // due to zero based index
    
    /* case where k==1 that means we have hit limit */
	//BASE CASE 2. If k==1
	if(k==1)
            return Math.min(a[0], b[0]);

    /* Now the divide and conquer part */
    int i =  Math.min(aLength, k/2) ; // k should be less than the size of array  
    int j =  Math.min(bLength, k/2) ; // k should be less than the size of array  

    if(a[i-1] > b[j-1])
            // Now we need to find only K-j th element
            return findKthSmallestElement(a, Arrays.copyOfRange(b, j, b.length), a.length, b.length -j, k-j);
    else
            return findKthSmallestElement(Arrays.copyOfRange(a, i, a.length), b, a.length-i, b.length,  k-i);
}
}
/*
Analysis:
	Time Complexity = O(log(n+m))
    Space Complexity = O(1) */