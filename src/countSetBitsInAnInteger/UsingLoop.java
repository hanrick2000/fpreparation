/*
Question: Count set bits in an integer
Source: http://www.geeksforgeeks.org/count-set-bits-in-an-integer/
*/
package countSetBitsInAnInteger;

import java.util.Scanner;

public class UsingLoop {

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	System.out.println("Enter a integer number to check for set bits in it");
	int n = in.nextInt();
	System.out.println("The number of set bits using loop is: "+usingLoop(n));
	}
	finally{
	in.close();
	}
}
private static int usingLoop(int n) {
	int count = 0;
	for(int i=0;i<32;i++){
		if((n&(1<<i))!=0)
			count++;
	}
	return count;
}
/*
Analysis:
	Time Complexity = O(32) // 32 since the loop will run 32 times
	Space Complexity = O(1)
*/
}