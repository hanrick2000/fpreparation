/*
Question: Find the kth smallest element in the array

Question Source: 	http://www.careercup.com/question?id=15435963
					http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/

Answer Source: http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
	https://github.com/nkatre/Opearations-Variants-in-an-array/blob/master/SortingAlgorithms/Quicksort
	http://www.geekviewpoint.com/java/search/quickselect
	
	
Algorithm:

Algorithm Source: http://stackoverflow.com/questions/10846482/quickselect-algorithm-understanding

The important part in quick select is partition. So let me explain that first.

Partition in quick select picks a pivot (either randomly or first/last element). 
Then it rearranges the list in a way that all elements less than pivot are on left
 side of pivot and others on right. It then returns index of the pivot element.

Now here we are finding kth smallest element. After partition cases are:

1. k == pivot. Then you have already found kth smallest. This is because the way partition is working.
 There are exactly k - 1 elements that are smaller than the kth element.
2. k < pivot. Then kth smallest is on the left side of pivot.
3. k > pivot. Then kth smallest is on the right side of pivot. And to find it you actually have to 
find k-pivot smallest number on right.


Sources:
Partition Function of QuickSort/QuickSelect:
http://stackoverflow.com/questions/18167528/how-to-write-a-quicksort-partition-function
QuickSort Java code with Partition Function:
http://www.algolist.net/Algorithms/Sorting/Quicksort


*/
package Array.MedianKthSmallestKthLargestElementInUnsortedArray;

import java.util.Scanner;

public class UsingQuickSelectAlgorithm {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to find the kth SMALLEST element in the array using QUICK SELECT Algorithm");
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			int[] a=new int[n];
			System.out.println("Enter the elements of the array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("Enter the kth element");
			int k = in.nextInt();
			System.out.println("The kth smallest element in the array is: "+usingQuickSelect(a,0,a.length-1,k));
		}
		finally{
			in.close();
		}
	}

	private static int usingQuickSelect(int[] A, int l, int h, int k) {
		
	        int p = partition(A, l, h); 
	        if(p==(k-1)) 
	        	return A[p];
	        else if(p>(k-1)) 
	        	return usingQuickSelect(A, l, p ,k);  
	        else 
	        	return usingQuickSelect(A, p+1, h , k-p);
	}

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
}
/*
Analysis:
(Analysis Source: http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/)
Worst Case Time Complexity = O(n^2)
Best and Average Case Time Complexity = O(n)
Space Complexity = O(1)
*/