/*
Question: Divide a list of numbers into group of consecutive numbers but their original order should be preserved? 
		e.g. 
		8,2,4,7,1,0,3,6 

		2,4,1,0,3 and 8,7,6 

		obviously in shortest time and space.

Question Source: http://www.careercup.com/question?id=65732
	
Answer Source: 
*/
package Array.ConsecutiveGroups;

import java.util.Scanner;

public class ConsecutiveGroups {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the elements of the array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println(consecutiveNumbers(a, n));
		}
		finally{
			in.close();
		}
	}
	public static String consecutiveNumbers(int a[], int n) {
		  // Validate 
		  if(n <= 0) 
			  return null;
		  
		  // parse the input array and mark off values seen
		  int[] valueSeen=new int[n+1];
		  for(int i=0; i<n; i++)
		    valueSeen[a[i]] = i;
		  
		  
		  // parse valueSeen and figure out consecutive numbers
		  // bucket the result into groups and output the result in original order
		  String result = "";
		  for(int i=0; i<n; i++){
		    if(valueSeen[i] != 0) {
		      result+= a[valueSeen[i]] + " ";
		    }
		    else {
		      int len = result.length();
		      if(result.charAt(len) != ',') 
		    	  result += ",";
		    }
		  }
		  return result;
		}
}
