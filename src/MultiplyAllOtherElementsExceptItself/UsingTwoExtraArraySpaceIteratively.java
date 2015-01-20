

/*
 * Question:  Multiply all fields except it's own position. 
input [2,3,1,4] 
output [12,8,24,6] 

RESTRICTIONS: 
1. no use of division 
2. complexity in O(n)

Source: http://www.careercup.com/question?id=5179916190482432
 * 
 * ALGORITHM: 1. Create 2 arrays, forward and backward of the same length
 *            2. Store 1 as first element of forward and 1 as last element of backward
 *            3. Run loop (n-1) times
 *            			calculate FORWARD multiplication of array elements till the current position starting from index 1 to (input.length-1)
 *            			calculate BACKWARD multiplication of array elements till the current position starting from (input.length-2)  to 0
 *            4. Run loop from 0 to n-1
 *            			output[i] = forward[i]*backward[i]
 *            
 * Explanation of Algorithm:
 * arr = 2, 3, 1, 4

// maintain two arrays which can be done in O(n)

arr1 = 2,  6,   6,  24 (arrays multiply each number with previous and current)
arr2 = 24, 12, 4, 4    (arrays multiplied from end)

In above two arrays, replace beginning of arr1 with 1 and ending with 1
arr1 = 1,  6,   6,  24
arr2 = 24, 12, 4, 1

Then to find number at index 'i' you would just do:

arr1[i]*arr2[i+1]
 */

package MultiplyAllOtherElementsExceptItself;

import java.util.Arrays;
import java.util.Scanner;

public class UsingTwoExtraArraySpaceIteratively {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	System.out.println("Enter the number of elements in the array");
	int n = in.nextInt();
	System.out.println("Enter the elements of the array");
	int[] a= new int[n];
	for(int i=0;i<n;i++)
		a[i]=in.nextInt();
	System.out.println("Elements of the array are: "+multiplyElements(a));
	
	}
	finally{
		in.close();
	}
	
	}

private static String multiplyElements(int[] input) {
	int[] forward = new int[input.length];
	int[] backward = new int[input.length];
	
	// store the initial elements 
	forward[0]=1;                           // first element of forward is 1
	backward[input.length-1]=1;             // last element of backward is 1
	
	// Use loop to calculate forward multiplication
	for(int i=1;i<forward.length;i++)                        
		forward[i] = forward[i-1]*input[i-1];
	
	// Use loop to calculate backward multiplication
	for(int i=(backward.length-2);i>=0;i--)
		backward[i]=backward[i+1]*input[i+1];
	
	
	
	// store the result in output array
	int[] output = new int[input.length];
	for(int i=0;i<output.length;i++)
		output[i]=forward[i]*backward[i];
	
	// return the result
	return Arrays.toString(output);
		
}
/*
Analysis:
	Time Complexity,
			3n since we pass n elements thrice, asymptotically it is = O(3n)
			where n = number of elements in the input array
	Space Complexity,
			3n since forward, backward and output array is used = O(3n)
*/

}
