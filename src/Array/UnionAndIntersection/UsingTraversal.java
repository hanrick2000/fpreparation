
/*
 * Question: Union and Intersection of SORTED ARRAYS (Asked in one of the FB interviews)
 * Question and Answer Source: http://www.geeksforgeeks.org/union-and-intersection-of-two-sorted-arrays-2/
 */

package Array.UnionAndIntersection;

import java.util.Scanner;

public class UsingTraversal {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Proagram to print the UNION and INTERSECTION elements of two SORTED arrays");
			System.out.println("Enter the number of elements in the first SORTED array");
			int m = in.nextInt();
			int[] a1= new int[m];
			System.out.println("Enter the elements of the first array");
			for(int i=0;i<m;i++)
				a1[i]=in.nextInt();
			System.out.println("Enter the number of elements in the second SORTED array");
			int n = in.nextInt();
			int[] a2 = new int[n];
			System.out.println("Enter the elements of the second array");
			for(int j=0;j<n;j++)
				a2[j]=in.nextInt();
			System.out.println("Union of the SORTED arrays");
			union(a1,a2);
			System.out.println();
			System.out.println("Intersection of the SORTED arrays");
			intersection(a1,a2);
		}
		finally{
			in.close();
		}
	}

	private static void intersection(int[] a1, int[] a2) {
		int i=0;  // iterator for a1
		int j=0;  // iterator for a2
		while(i<a1.length && j<a2.length){
			
			if(a1[i]<a2[j])                               // Either this
				i++;
			else if(a2[j] < a1[i])                        // Either this
				j++;
			else{ // a1[i] == a2[j] Both are EQUAL        // Either this
				System.out.print(a1[i]+" "); // Print either a1 or a2 and increment i and j
				i++;
				j++;
			}
		}
	}
	/*
	 * Analysis:
	 * Time Complexity = O(m+n) where m = length of 1st sorted array and n = length of 2nd sorted array
	 * Space Complexity = O(1)
	 */
	private static void union(int[] a1, int[] a2) {
		int i=0;  // iterator for a1
		int j=0;  // iterator for a2
		while(i<a1.length && j<a2.length){
			
			if(a1[i]<a2[j])                               // Either this
				System.out.print(a1[i++]+" ");
			else if(a2[j] < a1[i])                        // Either this
				System.out.print(a2[j++]+" ");
			else{ // a1[i] == a2[j] Both are EQUAL        // Either this
				System.out.print(a1[i]+" "); // Print either a1 or a2 and increment i and j
				i++;
				j++;
			}
		}
		
		if(i<a1.length)
			System.out.print(a1[i++]);
		if(j<a2.length)
			System.out.print(a2[j++]);
	}
	/*
	 * Analysis:
	 * Time Complexity = O(m+n) where m = length of 1st sorted array and n = length of 2nd sorted array
	 * Space Complexity = O(1)
	 */
}
