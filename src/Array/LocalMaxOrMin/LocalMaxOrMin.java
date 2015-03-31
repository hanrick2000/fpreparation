/*
 * Question: Given an array such that every next element differs from the previous by +/- 1. 
 * (i.e. a[i+1] = a[i] +/-1 ) Find the local max OR min in O(1) time. The interviewer mentioned one more 
 * condition that the min or max should be non-edge elements of the array 
Example: 1 2 3 4 5 4 3 2 1 -> Local max is 5 
1 2 3 4 5 -> No local max or min exists 
5 4 3 2 1 -> No local max or min exists

Question Source: http://www.careercup.com/question?id=5113392333324288
 */
package Array.LocalMaxOrMin;

import java.util.Scanner;

public class LocalMaxOrMin {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the elements of the array");
			int n = in.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("Local minimum or maximum is: "+localMaxOrMin(a));
		}
		finally{
			in.close();
		}
	}

	private static int localMaxOrMin(int[] A) {
		return A[0] + (A[ A.length -1 ] + A.length - A[0])/2;
	}
}
