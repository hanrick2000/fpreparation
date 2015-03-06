/*
Question: Given an array of real numbers A of length n, and some integer k such that 0 <= k < n,
write a function that returns the kth largest number in A, where k=0 refers to the largest number. 

What is the time complexity? What is the space complexity? Can you optimize either?
Example input: A = [0.5, 2.5, 1], n=3, k=1
Expected output: 1

Question Source: http://www.careercup.com/question?id=15435963
	
Answer Source: https://yiqi2.wordpress.com/2013/07/03/median-of-medians-selection-algorithm/
http://javatroops.blogspot.com/2012/10/median-of-medians-to-find-kth-smallest.html
*/
package Array.MedianKthSmallestKthLargestElementInUnsortedArray;

import java.util.Arrays;
import java.util.Scanner;

public class MedianOfMedians {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
		System.out.println("MEDIAN OF MEDIANS: Program to print the kth Largest element in the array");
		System.out.println("Enter the number of elements in the array");
		int n = in.nextInt();
		System.out.println("Enter the elements of the array");
		int[] a = new int[]{88, 30, 11, 17, 22, 16, 39, 8, 31, 55, 29, 63, 77, 69, 99, 90, 81, 2, 20, 53, 62, 5, 88, 33, 44, 6, 1};
		/*
		int[] a= new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		*/
		System.out.println("Enter the value of k");
		int k = in.nextInt();
		System.out.println("The kth smallest element in the array is: "+find(a,0,a.length-1,k));
		}
		finally{
			in.close();
		}
	}
	
	private static int find(int[] a, int s, int n, int k ) {
	    // start point s, length n, find k-th number
	    if ( n == 1 && k == 1 )
	        return a[s];
	     
	    int m = (n+4)/5;
	    int[] mid = new int[m]; // array to store the median elements
	    
	    for (int i=0; i<m; i++) {
	        int t = s+i*5;      // 5-elements block pointer
	        if ( n-t > 4 ) {
	            Arrays.sort(a, t, t+5);      // sort 5 elements
	            mid[i] = a[t+2];
	        }
	        else {      // less than 5 left
	            Arrays.sort(a, t, t+(n%5));    // sort the rest 
	            mid[i] = a[t+(n-t-1)/2];
	        }
	    }
	     
	    int pivot = find(mid, 0, m, (m+1)/2);
	    // replace the pivot with the last element 
	    for (int i=0; i<n; i++) {        // find pivot location
	        if (a[s+i] == pivot ) {
	            swap(a, s+i, s+n-1);
	            break;
	        }
	    }
	    
	    // partition logic
	    int pos = 0;
	    for (int i=0; i<n-1; i++) {      // using pivot to part
	        if ( a[s+i] < pivot ) {
	            if ( i != pos )
	                swap(a, s+i, s+pos);
	            pos++;
	        }
	    }
	    swap(a, s+pos, s+n-1);
	     
	    if ( pos == (k-1) )
	        return pivot;
	    else if ( pos > (k-1))
	        return find(a, s, pos, k);
	    else
	        return find(a, s+pos+1, n-pos-1, k-pos-1);
	}
	private static void swap(int[] a, int i, int j) {
		a[i]=a[i]^a[j];
		a[j]=a[i]^a[j];
		a[i]=a[i]^a[j];
	}
}
/*
 * Analysis:
 * Time Complexity = O(n)   [Worst case complexity O(n)]
 * Space Complexity = O()
 */
