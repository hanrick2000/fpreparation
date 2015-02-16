/*
Two Types of Partition Exists in QuickSort

Source: http://cs.stackexchange.com/questions/11458/quicksort-partitioning-hoare-vs-lomuto

1. Lomuto -> To understand this watch this video: https://www.youtube.com/watch?v=MZaf_9IZCrc
2. Hoare -> Normal i and j counter partition

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
*/



package Array.MedianKthSmallestKthLargestElementInUnsortedArray;

import java.util.Scanner;

public class UsingChangeOfPartitionMethodOfQuickSelect {
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
			System.out.println("The kth smallest element in the array is: "+kthSmallest(a,0,a.length-1,k));
		}
		finally{
			in.close();
		}
}

	private static int kthSmallest(int[] arr, int l, int r, int k) {
		// If k is smaller than number of elements in array
	    if (k > 0 && k <= r - l + 1)
	    {
	        // Partition the array around a random element and
	        // get position of pivot element in sorted array
	        int pos = randomPartition(arr, l, r);
	 
	        // If position is same as k
	        if (pos-l == k-1)
	            return arr[pos];
	        if (pos-l > k-1)  // If position is more, recur for left sub array
	            return kthSmallest(arr, l, pos-1, k);
	 
	        // Else recur for right sub array
	        return kthSmallest(arr, pos+1, r, k-pos+l-1);
	    }
	 
	    // If k is more than number of elements in array
	    return Integer.MAX_VALUE;
	}
	public static int randomPartition(int arr[], int l, int r)
	{
	    int n = r-l+1;
	    int pivot = (int) (Math.random() % n);
	    swap(arr, l+pivot, r);
	    return partition(arr, l, r);
	}

	private static int partition(int[] arr, int l, int r) {
		int x = arr[r], i = l;
	    for (int j = l; j <= r - 1; j++)
	    {
	        if (arr[j] <= x)
	        {
	            swap(arr, i, j);
	            i++;
	        }
	    }
	    swap(arr,i,r);
	    return i;
	}

	private static void swap(int[] a, int i, int j) {
		a[i]=a[i]^a[j];
		a[j]=a[i]^a[j];
		a[i]=a[i]^a[j];
	}
}