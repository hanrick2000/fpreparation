package Array.MoveZeroToTheLeftOrRightOfNonZero;

import java.util.Scanner;

public class MoveZeroToRightUsingSinglePointer {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	System.out.println("Enter the number of elements in the array");
	int n = in.nextInt();
	System.out.println("Enter the elements of the array - zero and non zero");
	int[] a = new int[n];
	for(int i=0;i<n;i++)
		a[i] = in.nextInt();
	a = moveElements(a);
	printArray(a);
	}
	finally{
		in.close();
		}
	}
	private static int[] moveElements(int[] a) {
		int zeroPoisitionPointer = 0;    // initialize a pointer which points to the element which is 0 in the array.
		                                 // assume initially this pointer is at position 0
		for(int i=0;i<a.length;i++){     // This loop is only for iterating, it doesn't act like a second pointer.
										 // Hence, there is only one pointer in this program(zeroPositionPointer)
			if(a[i]!=0){                 // if the element is not 0, then shift to 0 position
				a[zeroPoisitionPointer++] = a[i]; 
			}
		}
		for(;zeroPoisitionPointer<a.length;zeroPoisitionPointer++) // fill the remaining array elements with 0
			a[zeroPoisitionPointer]=0;
		return a;
	}
	private static void printArray(int[] a) {
		for(int i=0;i<a.length;i++)
			System.out.print(a[i]+" ");
		System.out.println();
	}

}
/*
Analysis:
	Time Complexity = O(n)
	Space Complexity = O(1)
*/