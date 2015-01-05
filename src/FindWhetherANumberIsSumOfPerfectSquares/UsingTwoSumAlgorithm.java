/*Question:
	Let's say there is a double square number X, which can be expressed as the sum of two perfect squares, 
	for example, 10 is double square because 10 = 3^2 + 1^2 

	Determine the number of ways which it can be written as the sum of two squares
Source: http://www.careercup.com/question?id=5767787551129600
*/
package FindWhetherANumberIsSumOfPerfectSquares;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UsingTwoSumAlgorithm {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the number you need to check");
		int n = in.nextInt();
		sumOfPerfectSquares(n);
	}
	finally{
		in.close();
	}
}
public static void sumOfPerfectSquares(int n){
	if(n<0)
		System.out.println("The number entered is negative");
	List<int[]> list = new ArrayList<int[]>();
	// Question: How to create an ArrayList of integer array
	int low = 0;
	int high = (int) Math.floor(Math.sqrt(n));
	int calculatedNumber=0;
	while(low<=high){
		calculatedNumber =  (int)Math.pow(low, 2)+(int)Math.pow(high,2);
		if(calculatedNumber==n){  
			// every combination is UNIQUE, hence we need to increment both low and high
			int[] pair = new int[]{low,high};
			// Question: All possible ways to declare an array in JAVA: http://stackoverflow.com/questions/1200621/declare-array-in-java
			list.add(pair);
			low++;
			high--;
		}
		if(calculatedNumber<n)
			low++;
		else
			high--;
	}
	System.out.println("Pairs are: "+toString(list));
}
public static String toString(List<int[]> list){
	Iterator<int[]> iter = list.iterator();
	StringBuilder sb = new StringBuilder();
	while(iter.hasNext()){
		int[] pair = iter.next();
		sb.append(pair[0]+" and "+pair[1]+", ");
	}
	return sb.toString();
}

}
/*
Analysis:
	Time Complexity = O(n^(0.5)). O(n^constant) This is valid representation because we have other 
	time complexities which are valid such as O(n^2) OR O(n^3) etc. Hence polynomial time complexity
	always involves mention of n^constant
	Space Complexity = O(1)
*/