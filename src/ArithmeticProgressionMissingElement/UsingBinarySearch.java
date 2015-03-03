/*
Question: Find the missing element in the Arithmetic Progression

Question Source: http://www.careercup.com/question?id=4798365246160896

Answer Source: http://www.geeksforgeeks.org/find-missing-number-arithmetic-progression/

Algorithm:
We can solve this problem in O(Logn) time using Binary Search. The idea is to go to the middle element. 
Check if the difference between middle and next to middle is equal to diff or not, 
if not then the missing element lies between mid and mid+1. 
If the middle element is equal to n/2th term in Arithmetic Series (Let n be the number of 
elements in input array), then missing element lies in right half. Else element lies in left half.
 
 			Do a recursive Binary Search
		   1. find if the mid+1 element is missing
		   2. find if the mid-1 element is missing
		   3. recur in left OR recur in right
*/
package ArithmeticProgressionMissingElement;

import java.util.Scanner;

public class UsingBinarySearch {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to find the MISSING ARITHMETIC PROGRESSION");
			System.out.println("Enter the elements of the array");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the elements of the array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("The missing element is: "+recursiveBinarySearch(a));
			// System.out.println("The missing element is: "+findMissing_binary(a));
			System.out.println("Missing element is: "+iterativeBinarySearch(a));
		}
		finally{
			in.close();
		}
	}
	 public static int recursiveBinarySearch(int[] a){
		    
	        int diff = (a[a.length-1]-a[0])/a.length;  // get the difference in the AP
	        
	        /*
	         * TR: To find diff in AP series, where 1 element is missing
	         * diff = (last-first)/length;
	         */
	        return recursiveBinarySearch(a,0,a.length-1,diff);
	    }
	    
	    public static int recursiveBinarySearch(int[] a, int low, int high, int diff){
	        
	        if(high<=low)
	            return Integer.MAX_VALUE;
	        
	        int mid = low+(high-low)/2;
	        
	        // check if mid+1 element is the missing element
	        if(a[mid+1]-a[mid]!=diff)
	            return (a[mid] + diff);
	        
	        // check if mid-1 is the missing element
	        if(a[mid]-a[mid-1]!=diff)
	            return (a[mid] - diff);
	         
	        
	        // If the elements till mid follow AP, then recur for right half
	        if(a[mid]==a[0]+(mid)*diff)  // nth AP is a_n = a_1 + (n - 1)d
	            return recursiveBinarySearch(a,mid+1,high,diff);
	        else  // Else recur for left half
	            return recursiveBinarySearch(a,low,mid-1,diff);
	        
	        
	        }
	    /*
	    public static int findMissing_binary(int[] array) {
			assert array != null && array.length > 2;
			
			int diff = Math.min(array[2]-array[1], array[1]-array[0]);

			int low = 0, high = array.length-1;
			while(low < high) {
				int mid = (low+high) >>> 1;

				int leftDiff = array[mid]-array[low];
				if(leftDiff > diff * (mid-low)) {
					if(mid-low == 1)
						return (array[mid]+array[low]) / 2;
					
					high = mid;
					continue;
				}
				
				int rightDiff = array[high]-array[mid];
				if(rightDiff > diff * (high-mid)) {
					if(high-mid == 1)
						return (array[high]+array[mid]) / 2;
					
					low = mid;
					continue;
				}
			}
			
			return -1;
		}
	    */
	    public static int iterativeBinarySearch(int[] a){
	    	
	    	if(a==null||a.length==0)
	    		return -1;
	    	
	    	
	    	int diff = (a[a.length-1]-a[0])/a.length;
	    	
	    	int mid=0;
	    	int low=0;
	    	int high=a.length-1;
	    	
	    	while(low<high){
	    		
	    		mid=low+(high-low)/2;
	    		if(a[mid+1]-a[mid]!=diff)
	    			return (a[mid]+diff);
	    		
	    		else if(a[mid]-a[mid-1]!=diff)
	    			return (a[mid]-diff);
	    		
	    		else if(a[mid]==(a[0]+mid*diff)) // nth AP is a_n = a_1 + (n - 1)d
	    			low=mid+1;
	    		
	    		else
	    			high=mid-1;
	    	}
	    	
	    	return -1;
	    	
	    }
	    
    }

/*
Analysis:
Time Complexity = O(lgn)
Space Complexity = O(1)
*/