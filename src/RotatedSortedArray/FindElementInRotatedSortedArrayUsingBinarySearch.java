
/*
Question: Find an element in a sorted array which is rotated
NOTE that the elements of the array are UNIQUE

Question Source: 
Answer Source: https://www.youtube.com/watch?v=uufaK2uLnSI

Algorithm: get mid and check whether element at mid is the x element. If yes then return mid

        if(a[mid] >= a[low]){   // then the lower half is a sorted array & Now search for key in sorted array
            
            if(a[low] <=key && a[mid] > key) // if key lies here then search here
                high = mid-1;
            else
                low = mid+1;
       
        }
        
        else{ //(a[mid] <= a[high])  // then the upper half is a sorted array & Now search for key in sorted array
        // VERY IMPORTANT THAT THIS SHOULD BE "ELSE"
            if(a[mid] < key && a[high] >= key) // if key lies here then search here
                 low = mid+1;
            else
                 high = mid-1;
       
        }
*/
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
		int key = in.nextInt();
		System.out.println("The index of the element is: "+usingModifiedBS(a,key));
		}
		finally{
			in.close();
		}
	}

public static int usingModifiedBS(int[] a, int key){
        /*
         * VERY IMPORTANT: This algorithm NOT work if the elements of the array have DUPLICATES
         * for example: will not work for a={2,2,2,2,2,0,1,2}
         * and we need to key is x
         * then this algorithm MIGHT GIVE WRONG RESULTS
         * 
         * IF THERE ARE DUPLICATES IN THE ARRAY THEN WE HAVE TO LINEARLY SEARCH ON EACH ELEMENT
         * WHICH IS O(N) SOLUTION AND WE CANNOT DO BETTER THAN THIS
         * 
         */
        int low = 0;
        int high = a.length-1;
        int mid = 0;
        
        while(low<=high){
        
        mid = low+(high-low)/2;
        
        if(a[mid]==key)
            return mid;
        
        if(a[mid] >= a[low]){   // then the lower half is a sorted array & Now search for key in sorted array
            
            if(a[low] <=key && a[mid] > key) // if key lies here then search here
                high = mid-1;
            else
                low = mid+1;
        }
        
        else{ //(a[mid] < a[high])  // then the upper half is a sorted array & Now search for key in sorted array
        // VERY IMPORTANT THAT THIS SHOULD BE "ELSE"
            if(a[mid] < key && a[high] >= key) // if key lies here then search here
                 low = mid+1;
            else
                 high = mid-1;
       
        }
        
        }
        return -1;  // key not present in the array
        
    }
}

/*
 * Analysis:
 * Time Complexity = O(lgn)
 * Space Complexity = O(1)
 */
