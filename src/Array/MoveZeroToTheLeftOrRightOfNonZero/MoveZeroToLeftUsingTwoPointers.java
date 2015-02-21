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
			System.out.println("Enter the elements of the array - zero and non zero");
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
		
		// If we have to move 0 to the left then we have to start from right
		// Both the pointers start from the last element in the array
		
		int source = a.length-1;  
		int dest = a.length-1;     
		
		while(source>=0){
			
			if(a[source]!=0){  
				if(a[source]!=a[dest])  // if both the elements are different then copy source to dest and decrement both the pointers
					a[dest--]=a[source--];
				else{ // if the elements are the same then dont copy but decrement both source and dest
					dest--;
					source--;
				}
			}
			else{ // if a[source] is 0 then ONLY decrement source BUT NOT dest
				source--;
			}
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
