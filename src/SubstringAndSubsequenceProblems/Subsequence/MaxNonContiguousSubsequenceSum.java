/*
Question: 
	CONDITION: WE SHOULD NOT SELECT TWO CONTIGUOUS NUMBERS. The numbers selected should be non-contiguous
	Given a sequence of numbers A(1) ..A(n), 
	find the continuous subsequenceA(i)..A(j) for which the sum of elements is maximum.
	
Question and Answer Source: http://www.careercup.com/question?id=23594662
*/

package SubstringAndSubsequenceProblems.Subsequence;

import java.util.Scanner;

public class MaxNonContiguousSubsequenceSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			System.out.println("Enter the elements of the array");
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("The max non-contiguous sum of the array is: "+maxNonContiguousSum(a));
		}
		finally{
			in.close();
		}
	}

	private static int maxNonContiguousSum(int[] a) {
		if(a.length==0 || a==null)
			return -1;
		if(a.length==1)
			return a[0];
		if(a.length==2)
			return Math.max(a[0], a[1]);
		
		else{ 		
			for(int i=2;i<a.length;i++)
				a[i] = findMax(a[i-2],a[i-1],a[i], (a[i]+a[i-2]) ) ; 
			return a[a.length-1];
			
			/*
			 * NOTE: If we donot want to modify the original array, we can create a temp array
			 * and copy all elements of a[] into temp[] and run the for loop for temp[]
			 * VERY IMP: Its important to copy all elements of a[] into temp[]
			 */
		}
		/*
		 * Example Program:
			Enter the number of elements in the array
			8
			Enter the elements of the array
			1
			3
			5
			-1
			12
			6
			7
			11
			The max non-contiguous sum of the array is: 29
*/
		
	}

	private static int findMax(int a, int b, int c, int d) {
		int temp1 = Math.max(a, b);
		int temp2 = Math.max(c, d);
		return Math.max(temp1, temp2);
	}

}
/*
 * Analysis:
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */
