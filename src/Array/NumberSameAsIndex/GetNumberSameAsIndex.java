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
