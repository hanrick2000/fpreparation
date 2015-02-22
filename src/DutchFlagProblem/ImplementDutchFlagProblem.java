package DutchFlagProblem;

/*
Question And Answer Source : http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

Algorithm:

int low = 0;
int mid = 0;
int high = a.length-1;
Examine a[mid]. 


There are three possibilities: a[Mid] is (0) red, (1) white or (2) blue.
Case (0) a[Mid] is red, swap a[Lo] and a[Mid]; Lo++; Mid++

0 0 0 0 1 1 1 ? ? ? 2 2 2
^     ^   ^
|     |   |
Lo    Mid Hi

Case (1) a[Mid] is white, Mid++

0 0 0 1 1 1 1 ? ? ? 2 2 2
^       ^   ^
|       |   |
Lo      Mid Hi

Case (2) a[Mid] is blue, swap a[Mid] and a[Hi]; Hi-- ;

0 0 0 1 1 1 ? ? ? 2 2 2 2
^     ^   ^
|     |   |
Lo    Mid Hi

Continue until Mid>Hi.
*
*/

import java.util.Scanner;

public class ImplementDutchFlagProblem {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the number of elements in the array");
		int n =in.nextInt();
		System.out.println("The elements of the array should be 0,1,2 in random order. Enter them");
		int[] array = new int[n];
		for(int i=0;i<n;i++){
			array[i] = in.nextInt();
		}
		printArrayElements(array);
		array = implementation(array);
		printArrayElements(array);
	}
	finally{
		in.close();
	}
}

public static int[] implementation(int[] a){
	if(a==null||a.length==0)
		return null;
	if(a.length==1)
		return a;
	int low = 0;
	int mid = 0;
	int high = a.length-1;
	
	while(mid<=high){ // VERY IMP: MID IS LESS THAN OR EQUAL TO HIGH
		if(a[mid]==0){   // If the mid is 0, then swap the low with mid, increment BOTH low and mid
			a=swap(a,mid,low);
			mid++;
			low++;
		}
		if(a[mid]==1){	// If the mid is 1 then, just increment the mid
			mid++;
		}
		if(a[mid]==2){	// If the mid is 2, then swap high with mid, decrement the high
			a=swap(a,mid,high);
			high--;
		}
	}
	return a;	
}
private static int[] swap(int[] array,int i, int j) {
	int temp = array[i];
	array[i] = array[j];
	array[j] = temp;
	return array;
}

public static void printArrayElements(int[] array){
	System.out.println("Array Elements:");
	for(int i=0;i<array.length;i++){
		System.out.print(array[i]+" ");
	}
	System.out.println();
}
}
/*
 Analysis:
	Time Complexity - O(n)
	Space Complexity - O(1)
*/

