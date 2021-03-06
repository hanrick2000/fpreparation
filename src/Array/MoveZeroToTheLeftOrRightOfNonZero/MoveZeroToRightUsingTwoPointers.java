package Array.MoveZeroToTheLeftOrRightOfNonZero;

import java.util.Arrays;
import java.util.Scanner;

public class MoveZeroToRightUsingTwoPointers {
	public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	System.out.println("Enter the number of elements in the array");
	int n = in.nextInt();
	System.out.println("Enter the elements of the array - zero and non zero");
	int[] a = new int[n];
	for(int i=0;i<n;i++)
		a[i] = in.nextInt();
	System.out.println(Arrays.toString(a));
	a = moveZeroToRightUsingTwoPointers(a);
	System.out.println(Arrays.toString(a));
	}
	finally{
		in.close();
		}
	}
	private static int[] moveZeroToRightUsingTwoPointers(int[] a) {
		
		// If we have to move 0 to the right then we have to start from left
		// Both the source and dest pointers start from left
		int source = 0;
		int dest = 0; 
		
		while(source < a.length){
			
			if(a[source]!=0){ 
				
				if(a[source]!=a[dest]) // if both the elements are DIFFERENT then COPY SOURCE TO DEST and increment both the pointers
					a[dest++]=a[source++];
				else{ // if the elements are the SAME then DONT COPY BUT INCREMENT both source and dest
					source++;
					dest++;
				}
			}
			else{  // if source is equal to 0 then increment source BUT NOT dest
				source++;	
			}
		}
		
		// fill the 0's at the end
		while(dest<a.length)
			a[dest++]=0;
		
		
		return a;
	}
	

}
/*
 * Analysis:
 *  Time Complexity = O(n)
 *  Space Complexity = O(1)
 */ 