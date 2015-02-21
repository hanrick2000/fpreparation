package Array.MoveZeroToTheLeftOrRightOfNonZero;

import java.util.Scanner;

public class MoveZeroToRightUsingTwoPointersInTheArray {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the number of elements of the array");
		int n = in.nextInt();
		System.out.println("Enter the elements - zero and non-zero");
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		a = moveElements(a);
		printArray(a);
	}
	finally{
		in.close();
	}
}

private static void printArray(int[] a) {
	for(int i=0;i<a.length;i++)
		System.out.print(a[i]+" ");
	System.out.println();
}

private static int[] moveElements(int[] a) {
	int low = 0;
	int high = a.length-1;
	while(low<high){
		if(a[low]==0 && a[high]!=0){
			a=swap(a,low,high);
			high--;
			low++;
			continue;
			}
		if(a[low]==0 && a[high]==0){
			high--;
		}
		if(a[low]!=0 && a[high]==0){
			low++;
			high--;
			}
		if(a[low]!=0 && a[high]!=0){
			low++;
		}
		}
	return a;
	}

private static int[] swap(int[] a, int low, int high) {
	a[low] = a[low]^a[high];
	a[high] = a[low]^a[high];
	a[low] = a[low]^a[high];
	return a;
	}
}
/*
Analysis:
	Time Complexity = O(n)
	Space Complexity = O(1)
*/