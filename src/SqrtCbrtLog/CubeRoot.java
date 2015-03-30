

/*
 * Question: Find the cube root of a number
 * 
 * Source: http://codinggeeks.blogspot.com/2010/04/computing-square-cube-roots.html
 * http://codinggeeks.blogspot.com/2010/04/computing-derivatives.html
 * 
 */


package SqrtCbrtLog;

import java.util.Scanner;

public class CubeRoot {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to find the CUBE ROOT OF A NUMBER WITH PRECSION IN FAST TIME");
			System.out.println("Enter the number");
			int n = in.nextInt();
			System.out.println("The cube root of the number is: "+cubeRoot(n));
		}
		finally{
			in.close();
		}
	}
	public static int cubeRoot(int n) {

		int result=0;
		for (int i=1;i<n;i++){
			
			if (i*i*i == n){
				result =i;
				break;
			}
			if (i*i*i>n){
				result = i-1;
				break;
			}
		}
		
		return result; 


	}
	/*
	 * Analysis:
	 * Time complexity = O()
	 * Space Complexity = O(1)
	 */
}
