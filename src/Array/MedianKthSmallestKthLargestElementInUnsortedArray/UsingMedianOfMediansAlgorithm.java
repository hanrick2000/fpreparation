/*
Question: Given an array of real numbers A of length n, and some integer k such that 0 <= k < n,
write a function that returns the kth largest number in A, where k=0 refers to the largest number. 

What is the time complexity? What is the space complexity? Can you optimize either?
Example input: A = [0.5, 2.5, 1], n=3, k=1
Expected output: 1

Question Source: http://www.careercup.com/question?id=15435963
	
Answer Source: http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/

* PARTITION ALGORITHM: 
Two Types of Partition Exists in QuickSort

Source: http://cs.stackexchange.com/questions/11458/quicksort-partitioning-hoare-vs-lomuto

1. Lomuto -> To understand this watch this video: https://www.youtube.com/watch?v=MZaf_9IZCrc
2. Hoare -> Normal i and j counter partition

The code for Hoare parition is:
private static int partition(int[] a, int low, int high) {
		
		int i = low;
		int j = high;
		int temp = 0;
		
		int pivot = a[low+(high-low)/2];
		
		while(i<=j){
			while(a[i]<pivot)
				i++;
			while(a[j]>pivot)
				j--;
			if(i>j)
				break;
			else{ // if(i<=j)
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
				j--;
			}
		}
		return i; // return the pivot index
		
	}
*
*
*/
package Array.MedianKthSmallestKthLargestElementInUnsortedArray;

import java.util.Arrays;
import java.util.Scanner;

public class UsingMedianOfMediansAlgorithm {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
		System.out.println("Program to print the kth Largest element in the array");
		System.out.println("Enter the number of elements in the array");
		int n = in.nextInt();
		System.out.println("Enter the elements of the array");
		int[] a= new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		System.out.println("Enter the value of k");
		int k = in.nextInt();
		System.out.println("The kth largest element in the array is: "+usingMedianOfMedians(a,0,a.length-1,k));
		}
		finally{
			in.close();
		}
	}

	private static int usingMedianOfMedians(int[] a, int low, int high, int k) {
		
		if(k>0 && k<=a.length){
			
			int m = (a.length+4)/5;
			int[] medianArray = new int[m];
			// Divide a[] in groups of size 5, calculate median
	        // of every group and store it in median[] array.
			int i=0;
			for(i=0;i<m-1;i++){
				int startIndex = (low+i*5);
				if((high-startIndex+1)>4)
					medianArray[i] = sortAndFindMedian(a,startIndex,startIndex+5);
			}
			if (i*5 < a.length) //For last group with less than 5 elements
	        {
				int startIndex = (low+i*5);
				medianArray[i] = sortAndFindMedian(a,startIndex, startIndex+(a.length%5)); 
	            i++;
	        } 
			 // Find median of all medians using recursive call.
	        // If median[] has only one element, then no need
	        // of recursive call
			int medOfMed = (i==1)?medianArray[i-1] : usingMedianOfMedians(medianArray, 0, m-1, m/2);
			
			// Partition the array around a random element and
	        // get position of pivot element in sorted array
			int pivotIndex = partitionUsingLomutoAlgorithm(a, low, high, medOfMed);
			
			// If position is same as k
	        if (pivotIndex-low == k-1)
	            return a[pivotIndex];
	        if (pivotIndex-low > k-1)  // If position is more, recur for left
	            return usingMedianOfMedians(a, low, pivotIndex-1, k);
	 
	        // Else recur for right sub array
	        return usingMedianOfMedians(a, pivotIndex+1, high, (k-pivotIndex+low-1));
			
		}
		// If k is more than number of elements in array
		return Integer.MAX_VALUE;
		
	}
	private static int partitionUsingLomutoAlgorithm(int[] a, int low, int high, int pivot) {
		
		// Search for medOfMed in a[low..high] and move it to end
	    int i=0;
		for (i=low; i<high; i++)
	        if (a[i] == pivot)
	           break;
	    swap(a,i,high); // swap pivot with the rightmost element
	 
	    // Standard partition algorithm
	    i = low;
	    for (int j = low; j <= high - 1; j++)
	    {
	        if (a[j] <= pivot)
	        {
	            swap(a,i,j);
	            i++;
	        }
	    }
	    swap(a,i,high); // where the element at index position high is the pivot element
	    return i;       // return the index of pivot element
	}

	private static void swap(int[] a, int i, int j) {
		a[i]=a[i]^a[j];
		a[j]=a[i]^a[j];
		a[i]=a[i]^a[j];
	}

	private static int sortAndFindMedian(int[] a, int start, int totalLength){
	
		Arrays.sort(a,start,start+totalLength);
		return a[(start+totalLength)/2];
	}
}
