/*
 * Question: Integers in an array are unique and increasingly sorted. Please write a function/method to find an 
 * integer from the array who equals to its index. 
 * Example: In the array {-3, -1, 1, 3, 5}, the number 3 equals its index 3.
 * Question and Answer Source: http://codercareer.blogspot.in/
 * 
 * Algorithm: 
 	If we scan all integers in the array from beginning to end, we may check whether every element equals
 	its index. Obviously, this solution costs O(n) time.
	Since numbers are sorted in the array, let's try to utilize the binary search algorithm to optimize.
 	Supposing we reach the ith element in the array at some step. If the value of element is also i, 
 	it is a target integer and let's return it.
	What would happen when the value m is greater than the index i? For any k (k>0), the value of 
	element with index i+k should be greater than or equal to m+k, because integers are unique and 
	increasingly sorted in the array. Additionally because m>k, m+k>i+k. Therefore, every element on 
	the right side of index i should be greater than its index in such a case.
	Similarly, when the value of element with index i is less than i, every integer on the left side
 	should be less than its index. Please prove it if you are interested.
 */

package Array.NumberSameAsIndex;

import java.util.Scanner;

public class GetNumberSameAsIndex {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the elements");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("Index which has the same number is: "+getNumberSameAsIndex(a));
		}
		finally{
			in.close();
		}
	}
	public static int getNumberSameAsIndex(int[] numbers) {
	    if(numbers == null || numbers.length == 0) {
	        return -1;
	    }
	       
	    int left = 0;
	    int right = numbers.length - 1;
	    while(left <= right) {
	        int middle = left + ((right - left) >>> 1);
	        if(numbers[middle] == middle) {
	            return middle;
	        }
	           
	        if(numbers[middle] > middle) {
	            right = middle - 1;
	        }
	        else {
	            left = middle + 1;
	        }
	    }
	       
	    return -1;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(lgn) where n = total number of elements in the array
	 * Space Complexity = O(1)
	 */
}	
