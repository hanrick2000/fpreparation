package DutchFlagProblem;

/*
Question Source : http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

Answer Source: http://blog.csdn.net/feliciafay/article/details/19024897

Algorithm:

int low = 0;
int mid = 0;
int high = a.length-1;
    while (mid <= high) {  
        switch(input[mid]) {                      // switch case is VERY IMP. DONOT use if condition instead of switch case
            case  0:  
                swap(input, low, mid);  
                low ++;  
                mid ++;  
                break ;  
            case  1:  
                mid ++;  
                break ;  
            case  2:  
                swap(input, mid, high);  
                high--;  
                break ;  
        }  
    }
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
		array = DutchFlag(array);
		printArrayElements(array);
	}
	finally{
		in.close();
	}
}
public static int[]  DutchFlag (int[] input) {  
    
	if(input==null||input.length==0)  
        return null;  
    
    int  low = 0;
    int mid = 0;
    int high = input.length-1;
    
    while (mid <= high) {  
        switch(input[mid]) {                      // switch case is VERY IMP. DONOT use if condition instead of switch case
            case  0:  
                swap(input, low, mid);  
                low ++;  
                mid ++;  
                break ;  
            case  1:  
                mid ++;  
                break ;  
            case  2:  
                swap(input, mid, high);  
                high--;  
                break ;  
        }  
    }
    return input;
}  
/*
Analysis:
	Time Complexity - O(n)
	Space Complexity - O(1)
*/

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


