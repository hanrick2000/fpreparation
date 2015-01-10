package smallestOfThreeNumbersWithoutComparisonOperator;

import java.util.Scanner;

public class UsingDifferentAlgorithms {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter three numbers, to find the minimum among them");
		int a = in.nextInt();
		int b = in.nextInt();
		int c = in.nextInt();
		System.out.println("Using repetative substraction algorithm, the minimum of the three numbers is: "+usingRepetativeSubstraction(a,b,c));
	}
	finally{
		in.close();
	}
}

private static int usingRepetativeSubstraction(int a, int b, int c) {
	int count = 0;
	while( (a>0)&&(b>0)&&(c>0) ){
		a--;
		b--;
		c--;
		count++;
	}
	return count;
}
/*
Analysis:
	Time Complexity = O(min(a,b,c))
	Space Complexity = O(1)
*/
}
