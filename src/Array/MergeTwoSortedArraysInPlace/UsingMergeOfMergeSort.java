/*
Question:  merge sorted arrays 'a' and 'b', each with 'length' elements, 
	 in-place into 'b' to form a sorted result. assume that 'b' 
	 has 2*length allocated space. 
	 e.g. a = [1, 3, 5], b = [2, 4, 6] => b = [1, 2, 3, 4, 5, 6] 

	HOW TO DO IT WITHOUT REARANGING THE B ARRAY

Question & Answer Source: http://www.careercup.com/question?id=5435439490007040
	
Algorithm: 
	The idea is merging from the back of the b array so the write op of the merge is 
	never interfered with read op from b
	
	
	/*  IMP NOTE:
		// 1. ASSUME THAT ARRAY 'B' = LENGTH OF ARRAY A + NO OF ELEMENTS IN ARRAY B
		// 2. ALSO ASSUME THAT ARRAY B IS FILLED IN FRONT AND THE LAST POSITIONS OF ARRAY B ARE EMPTY
		 * 
		Algorithm:
		int i_a = a.size() - 1;
		int i_b = noOfElementsInArrayB-1;   // since array b is filled in front and the last positions of array b are empty
		int i_AB = a.length+noOfElementsInArrayB-1;
			
		while(i_a >= 0 && i_b >=0)
		{
		    if (a[i_a] > b[i_b])  
		    		b[i_AB--] = a[i_a--];             // GREATEST ELEMENT GETS APPENDED FIRST
		    else 
		    		b[i_AB--] = b[i_b--];	
		}
		
		
		while(i_a >=0)
		        b[i_AB--] = a[i_a--]; 
		
		
		while(i_b>=0){
			// There is nothing to do if i_b >= 0 as we merge onto b
		}
		
		return b;
*/	
	
package Array.MergeTwoSortedArraysInPlace;

import java.util.Arrays;
import java.util.Scanner;

public class UsingMergeOfMergeSort {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements of the first array");
			int n = in.nextInt();
			int[] a= new int[n];
			System.out.println("Enter the elements of the first array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("Enter the number of elements of the second array");
			System.out.println("THE SIZE OF B SHOULD BE ABLE TO INCORPORATE THE SIZE OF A AS WELL");
			int m = in.nextInt();
			int[] b = new int[m];
			System.out.println("Enter the elements to be entered in b");
			int noOfElementsInArrayB = in.nextInt();
			System.out.println("Enter the elements of the second array");
			System.out.println("FILLING THE ELEMENTS IN ARRAY B FROM THE FRONT AND LEAVING THE BACK EMPTY");
			for(int i=0;i<noOfElementsInArrayB;i++)
				b[i]=in.nextInt();
			System.out.println("Inplace merge result is: "+Arrays.toString(merge(a,b,noOfElementsInArrayB)));
		}
		finally{
			in.close();
		}
	}
	public static int[] merge(int[] a, int[] b, int noOfElementsInArrayB){
		
		if(a==null && b==null)
			return null;
		
		if(a==null)
			return b;
		
		if(b==null)
			return a;
		
		// assume that array 'b' has 2*length allocated space to merge in place
		// also assume that array b is filled in front and the last positions of array b are empty
		int iteratorA = a.length-1;
		int iteratorB = noOfElementsInArrayB-1;
		int iteratorAB = a.length+noOfElementsInArrayB-1;
		
		
		while(iteratorA>=0 && iteratorB>=0){
			if( a[iteratorA] > b[iteratorB] )
				b[iteratorAB--]=a[iteratorA--];
			else
				b[iteratorAB--]=b[iteratorB--];
		}
		
		while(iteratorA>=0)
			b[iteratorAB--]=a[iteratorA--];
		
		while(iteratorB>=0){
			// There is nothing to do if iteratorB >= 0 as we merge onto b
		}
		
		return b;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(m+n)
	 * Space Complexity = O(1) since we are reusing array b to store the results
	 */
}
