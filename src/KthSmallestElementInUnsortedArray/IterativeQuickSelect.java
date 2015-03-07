/*

Question: Use a quickselect algorithm to find the kth smallest element in the array

Question Source: 	http://www.careercup.com/question?id=15435963
	http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array/
*/

package KthSmallestElementInUnsortedArray;

import java.util.Scanner;

public class IterativeQuickSelect {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to find the kth SMALLEST element in the array");
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			int[] a=new int[n];
			System.out.println("Enter the elements of the array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("Enter the kth element");  // STARTS FROM 0th index to (a.length-1)
			int k = in.nextInt();
			System.out.println("The kth smallest element in the array is: "+usingIterativeQuickSelect(a,k));
		}
		finally{
			in.close();
		}
	}

	private static int usingIterativeQuickSelect(int[] arr, int k) {
		if(arr==null||arr.length==0)
			return -1;
		
		
		int left = 0;
    	int right = arr.length-1;
 
    	//we stop when our indices have crossed
    	while (left < right){
    		/* get pivot and pivotValue
    		 * Swap right <-> pivotValue
    		 * store the left index
    		 * 
    		 * start loop from left to right-1
    		 * if -> i<pivotValue, swap i and storage. Then storage++
    		 * at the end of loop, swap right with storage
    		 * 
    		 * if(storage<k) -> LEFT = storage+1
    		 *     else      -> RIGHT = storage
    		 */
    		int pivot = left+((right - left)/2); //this can be whatever
    		
    		int pivotValue = arr[pivot]; // store the pivot value
    		swap(arr,pivot,right); // Swap the pivot with the right OR move the pivot to the right
    		
    		// Now the pivot is the element which is at right index
    		
    		int storage=left; // store the left index
    		
    		// from (left) to (right-1)
    		for(int i =left; i < right; i++){
    	// for each number i, if i is less than the pivot, swap i and storage and increment storage
    			if(arr[i] < pivotValue){
    				swap(arr,i,storage); // swap i with storage
    				storage++;           // increment the stored value of left
    			}
    		}
    		// swap the storage and right (i.e. move the pivot to its correct absolute location in the list)
    		swap(arr,storage,right);
 
    	//pick the correct half of the list you need to parse through to find your K, and ignore the other half
    		if(storage < k)
    			left = storage+1;
    		else//storage>= k
    			right = storage;
 
    	}
    	
    	return arr[k];
 
	}
	public static void swap(int[] arr, int index1, int index2)
	{
	    int temp = arr[index1];
	    arr[index1] = arr[index2];
	    arr[index2] = temp;
	}
}
/*
Analysis:
(Analysis Source: http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/)
Worst Case Time Complexity = O(n^2). VERY IMP NOTE: THIS IS WOST CASE COMPLEXITY HENCE "O" is used.
Best and Average Case Time Complexity = THETA(n)
Space Complexity = O(1)
*/