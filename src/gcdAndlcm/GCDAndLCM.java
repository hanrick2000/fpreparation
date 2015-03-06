/*
Question: Write a c++ program to find the LCM of all the elements of an array.

Question and Answer Source: 
http://stackoverflow.com/questions/17689529/lcm-of-all-the-numbers-in-an-array-in-java
http://www.careercup.com/question?id=7937661
http://www.careercup.com/question?id=12475663
*/



package gcdAndlcm;

import java.util.Scanner;

public class GCDAndLCM {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements of the array");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the elements of the array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("LCM of the entire array is: "+lcmOfArray(a,0,a.length-1));
		}
		finally{
			in.close();
		}
	}

	
		/*
		 * Algorithm:
		 * LCM (a, b, c) = LCM(LCM (a, b), c)
		 * 
		 *  Also we know that LCM(a, b) = (a * b)/ GCD(a, b)

		 */
		
		public static int lcmOfArray(int[] arr, int start, int end){
		    if ((end-start)==1)  // if only two elements present in the array
		    	return lcm(arr[start],arr[end-1]);
		    else 
		    	return (lcm (arr[start], lcmOfArray(arr, start+1, end))); // if more than two elements present in the array
		}
	
	
	private static int gcd(int a, int b){
		// We assume that the first argument is bigger and the second argument is smaller
		
		if(b>a)
			return gcd(b,a);
		
		if(b==0)
			return a;
		else
			return gcd(b,a%b);
		
	}
	
	private static int lcm(int a, int b){
		return ((a*b)/gcd(a,b));
	}
}
