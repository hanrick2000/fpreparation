package RotatedSortedArray;

import java.util.Scanner;

public class FindElementInRotatedSortedArrayUsingBinarySearch {
	public static void main(String[] args) {
		Scanner in = new Scanner (System.in);
		try{
		System.out.println("Find element in ROTATED SORTED array using Binary Search");
		System.out.println("The elements of the ARRAY SHOULD BE UNIQUE");
		System.out.println("Enter the number of elements in the array");
		int n = in.nextInt();
		System.out.println("Enter the elements");
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		System.out.println("Enter the element you need to search");
		int find = in.nextInt();
		System.out.println("The index of the element is: "+usingModifiedBS(a,find));
		}
		finally{
			in.close();
		}
	}

public static int usingModifiedBS(int[] a, int find){
        
        int low = 0;
        int high = a.length-1;
        int mid = 0;
        
        while(low<=high){
        
        mid = low+(high-low)/2;
        
        if(a[mid]==find)
            return mid;
        
        if(a[mid] >= a[low]){   // then the lower half is a sorted array & Now search for find in sorted array
            
            if(a[low] <=find && a[mid] > find) // if find lies here then search here
                high = mid-1;
            else
                low = mid+1;
       
        }
        
        else{ //(a[mid] <= a[high])  // then the upper half is a sorted array & Now search for find in sorted array
        // VERY IMPORTANT THAT THIS SHOULD BE "ELSE"
            if(a[mid] < find && a[high] >= find) // if find lies here then search here
                 low = mid+1;
            else
                 high = mid-1;
       
        }
        
        }
        return -1;  // find not present in the array
        
    }
}

/*
 * Analysis:
 * Time Complexity = O(lgn)
 * Space Complexity = O(1)
 */
