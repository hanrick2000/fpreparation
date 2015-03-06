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
			System.out.println("Enter the kth element");
			int k = in.nextInt();
			System.out.println("The kth smallest element in the array is: "+usingIterativeQuickSelect(a,k));
		}
		finally{
			in.close();
		}
	}

	private static int usingIterativeQuickSelect(int[] x, int k) {
		if(x==null||x.length==0)
			return -1;
		
		
		int left = 0;
    	int right = x.length-1;
 
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
    		
    		int pivotValue = x[pivot]; // Move pivot to end
    		x[pivot] = x[right];
    		x[right]=pivotValue;
    		
    		// Now the pivot is the element which is at right index
    		
    		int storage=left; // store the left index
    		
    		// from (left) to (right-1)
    		for(int i =left; i < right; i++){
    	// for each number i, if i is less than the pivot, swap i and storage and increment storage
    			if(x[i] < pivotValue){
    				int temp =x[storage];
    				x[storage] = x[i];
    				x[i]=temp;
    				// increment the stored value of left
    				storage++;
    			}
    		}
    		// swap the storage and right
    		x[right]=x[storage];
    		x[storage]=pivotValue;//move the pivot to its correct absolute location in the list
 
    	//pick the correct half of the list you need to parse through to find your K, and ignore the other half
    		if(storage < k)
    			left = storage+1;
    		else//storage>= k
    			right = storage;
 
    	}
    	
    	return x[k];
 
	}


}
/*
Analysis:
(Analysis Source: http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/)
Worst Case Time Complexity = O(n^2)
Best and Average Case Time Complexity = O(n)
Space Complexity = O(1)
*/