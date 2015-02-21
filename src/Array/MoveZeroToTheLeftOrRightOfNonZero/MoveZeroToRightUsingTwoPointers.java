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
	a = moveElements(a);
	System.out.println(Arrays.toString(a));
	}
	finally{
		in.close();
		}
	}
	private static int[] moveElements(int[] a) {
		
		// If we have to move 0 to the right then we have to start from left
		// Both the pointers start from the first element in the array
		int source = 0;
		int dest = 0; 
		
		while(source < a.length){
			
			if(a[source]!=0){ 
				
				if(a[source]!=a[dest]) // if both the elements are different then copy source to dest and increment both the pointers
					a[dest++]=a[source++];
				else{ // if the elements are the same then dont copy but increment both source and dest
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