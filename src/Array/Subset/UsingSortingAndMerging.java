/*
Question: Find whether FIRST array is subset of SECOND array (Asked in Facebook Interview)
Question and Answer Source: http://www.geeksforgeeks.org/find-whether-an-array-is-subset-of-another-array-set-1/

Algoritm:
	I. USING HASHSET
	NOTE: DOES NOT HANDLE DUPLICATES
	1) Create a Hash Table for all the elements of arr1[].
	2) Traverse arr2[] and search for each element of arr2[] in the Hash Table. 
	If element is not found then return 0.
	3) If all elements are found then return 1.
		
	II. USING SORTING AND BINARY SEARCH
	NOTE: DOES NOT HANDLE DUPLICATES
	1) Sort arr1[] O(mLogm)
	2) For each element of arr2[], do binary search for it in sorted arr1[].
	         a) If the element is not found then return 0.
	3) If all elements are present then return 1.
			
	III. Using Sorting and Merging
	(METHOD WHICH HANDLES DUPLICATES)
	1) Sort both arrays: arr1[] and arr2[] O(mLogm + nLogn)
	2) Use Merge type of process to see if all elements of sorted arr2[] are present in sorted arr1[]
			
	Note that method 1 and method 2 don’t handle the cases when we have duplicates in arr2[]. 
	For example, {1, 4, 4, 2} is not a subset of {1, 4, 2}, but these methods will print it as a subset.
	
	THUS, the third method should be used which handles DUPLICATES
	
	TODO:
	IV. Using HashMap (BEST METHOD WHICH HANDLES DUPLICATES)
	key = integer and value = count of repetition (used in case of duplicates)
	Store the big array in HashMap
	Iterate through the smallArray and for every element check whether map.get(small[i]) >=1
	Also for every hit, decrement the value in map
	If, map.get(small[i]) is NOT >=1 OR map does not contain small[i] then return false
	
	 NOTE: This handles duplicates and is O(n) time and O(n) space algorithm where n = length of big array
	
*/
package Array.Subset;

import java.util.Arrays;
import java.util.Scanner;

public class UsingSortingAndMerging {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to check whether FIRST array is subset of SECOND array where DUPLICATES can be present in EITHER ARRAYS");
			System.out.println("Enter the number of elements in the first array");
			int m = in.nextInt();
			int[] a1=new int[m];
			System.out.println("Enter the elements of the first array");
			for(int i=0;i<m;i++)
				a1[i]=in.nextInt();
			System.out.println("Enter the number of elements in the second array");
			int n = in.nextInt();
			int[] a2=new int[n];
			System.out.println("Enter the elements of the second array");
			for(int i=0;i<n;i++)
				a2[i]=in.nextInt();
			System.out.println("Is one of the array a subset of another ? "+subset(a1,a2));
		}
		finally{
			in.close();
		}
	}

	private static boolean subset(int[] a1, int[] a2) {
		
		
		// Sort the arrays
		Arrays.sort(a1);
		Arrays.sort(a2);
		
		int i = 0; // iterator for a1
		int j = 0; // iterator for a2
		
		int matchCount = 0;
		
		while(i<a1.length && j<a2.length){
			
			/*
			Since both arrays are sorted and the  SECOND array starts with element which is greater 
			than first element of FIRST array means SOME or ALL elements of the first array does not lie in 
			in the second array. Hence return false
			*/
				
			if(a2[j] > a1[i]) 
				return false; 			
			
			else if(a2[j] < a1[i])
				j++;
			
			else{ // a2[j]==a1[i]
				j++;
				i++;
				matchCount++;
			}
			
		}
		// check whether all the elements of the FIRST array are checked and match found for all elements
		if(matchCount==a1.length && i==a1.length-1) 
			return true;
		else
			return false;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(mlgm + nlgn) where m = length of FIRST array and n = length of SECOND array
	 * Space Complexity = O(1)
	 */
}
/*
NOTE: You can implement the remaining algorithms but they are NOT full proof.
They dont handle the case where the first array contains duplicates
For example, {1, 4, 4, 2} is not a subset of {1, 4, 2}, but implementing method I and method II 
will print true saying that it as a subset whereas it is not.
	
THUS, although time complexity is O(mlgm + nlgn), METHOD III of SortingAndMerging is the BEST.
*/