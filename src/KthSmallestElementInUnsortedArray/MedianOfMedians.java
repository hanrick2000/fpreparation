package KthSmallestElementInUnsortedArray;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
 
/**
 * Calculate Kth smallest element in an unsorted array using Median of Medians. Worst case is O(N)
 * Question Source: 
 * Solution Source: http://javatroops.blogspot.com/2012/10/median-of-medians-to-find-kth-smallest.html
 * VERY VERY IMP SOURCE OF MIT EXPLAINING THIS ALGORITHM:
 * http://ocw.mit.edu/courses/electrical-engineering-and-computer-science/6-046j-design-and-analysis-of-algorithms-spring-2012/lecture-notes/MIT6_046JS12_lec01.pdf
 */
public class MedianOfMedians {
 
	public static void main(String[] args) {
 
		Scanner in = new Scanner(System.in);
		try{
		System.out.println("Enter the number of elements");
		int n = in.nextInt();
		Integer[] a = new Integer[n];
		System.out.println("Enter the elements of the array");
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		System.out.println("Length of the array: "+a.length);
		System.out.println("Array elements are: "+Arrays.toString(a));
		System.out.println("Enter k to search for kth smallest number. Starts from 1 to "+a.length);
		int k = in.nextInt();   // Starts from 1 to a.length
		int res = select(a, k);	
		System.out.println("Array elemnts using median of medians: "+Arrays.toString(a));
		System.out.println("Using median of medians: "+res);
		Arrays.sort(a);
		System.out.println("Using sorting: "+a[k-1]);
		System.out.println("Sorted array usig sorting: "+Arrays.toString(a));
		}
		finally{
			in.close();
		}
	}
 
 
 
	private static int select(Integer[] a, int k)
	{
		if (a.length <= 10)
		{
			Arrays.sort(a);
			return a[k-1];
		}
		int n = a.length;
		//partition L into subsets S[i] of five elements each
		//    (there will be n/5 subsets total).
		List<Integer[]> list = new ArrayList<Integer[]>();
 
		int cnt = 0;
		int noOfArraySets = n/5;
		for( int i = 0; i < noOfArraySets; i++ ) {
			Integer[] arr = new Integer[5];
			for( int j = 0; j < 5; j++ ) {
				if( cnt == n ) 
					break;
				arr[j] = a[cnt++];
			}
			Arrays.sort(arr);
			list.add(arr);
		}
 
		Integer[] medians = new Integer[noOfArraySets];
		for (int i = 0; i< noOfArraySets; i++ ) {
			medians[i] = list.get(i)[2];
		}
        
		// take a pivot element
		int v = medians[0];
		if(medians.length > 2) {
			v = (medians.length%2 == 0)? medians[medians.length/2-1]: medians[medians.length/2];
		}
 
		//partition L into L1<M, L2=M, L3>M
		Integer[] l = partition_l( a, v );
		Integer[] r = partition_r( a, v );
		
		if( k == l.length+1 ) {
			return v;
		} else if( k <= l.length ){
			return select(l,k);								
		} else {
			return select(r,k-l.length-1);							
		}		
 
	}
 
	private static Integer[] partition_l( Integer[] a, int pivot ) {
		if( a.length == 0)
			return a;
		int j = 0;
		Integer[] b = new Integer[a.length];
		for( int i = 0; i < a.length; i++ ) {
			if(a[i] < pivot) {
				b[j++] = a[i];
			}
		}
		Integer[] l = new Integer[j];
		System.arraycopy(b, 0, l, 0, j);
		return l;
	}
 
	private static Integer[] partition_r( Integer[] a, int pivot ) {
		if( a.length == 0)
			return a;
		int j = 0;
		Integer[] b = new Integer[a.length];
		for( int i = 0; i < a.length; i++ ) {
			if(a[i] > pivot) {
				b[j++] = a[i];
			}
		}
		Integer[] r = new Integer[j];
		System.arraycopy(b, 0, r, 0, j);
		return r;
	}
 /*
  * Analysis:
  * We have used EXTRA SPACE FOR THIS MEDIANS OF MEDIANS ALGORITHM
  * The time complexity = O(n)
  * The space complexity = O(n)  // HOWEVER, IF implemented properly the traditional space complexity of median of medians is O(1)
  */
}