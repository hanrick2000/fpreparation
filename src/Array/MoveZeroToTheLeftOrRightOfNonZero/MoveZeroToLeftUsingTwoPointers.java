package Array.MoveZeroToTheLeftOrRightOfNonZero;

import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroToLeftUsingTwoPointers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the elements in the array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println(Arrays.toString(a));
			a=moveZeroToLeftUsingTwoPointers(a);
			System.out.println(Arrays.toString(a));
		}
		finally{
			in.close();
		}
	}

	private static int[] moveZeroToLeftUsingTwoPointers(int[] a) {
		
		int source = a.length-1;
		int dest = a.length-1;     
		
		while(source>=0){
			if(a[source]!=0){  // if not zero then move this to the zero'th element index
				if(a[source]!=a[dest])  // dont swap if same elements
					a[dest--]=a[source];
				else // both source and destination are equal
					dest--;
			}
			
			source--;
		}
		while(dest>=0)  // fill the zeros
			a[dest--]=0;
		
		
		return a;
	}
}
/*
 * Analysis:
 *  Time Complexity = O(n)
 *  Space Complexity = O(1)
 */ 
