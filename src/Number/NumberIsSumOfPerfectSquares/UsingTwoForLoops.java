package Number.NumberIsSumOfPerfectSquares;

import java.util.Scanner;

public class UsingTwoForLoops {
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

private static void sumOfPerfectSquares(int n) {
	int first = 0;
	int second = 0;
	for(int i=1;i<=n;i++){
		first = i*i;
		for(int j=2;j<=n;j++){
			second = j*j;
			if(first+second==n)
				System.out.println("Pair is: "+i+" and "+j);
		}
	}
}
}
/*
Analysis:
	Time Complexity= O(n^2)
	Space Complexity= O(1)
*/	