package PrintValidParanthesis;

import java.util.Scanner;

public class UsingRecursion {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the number of paranthesis");
		System.out.println("ONLY EVEN NUMBERS");
		int n = in.nextInt();
		StringBuilder sb = new StringBuilder();
		printParanthesis(n/2,n/2,sb);
	}
	finally{
		in.close();
	}
}

private static void printParanthesis(int left, int right, StringBuilder sb) {
	if(left==0 && right==0)
		System.out.println(sb.toString());
	
	if(left>right)
		return;
	
	if(left>0)
		printParanthesis(left-1, right, sb.append('('));
	
	if(right>0)
		printParanthesis(left, right-1, sb.append(')'));

	}
}
/*
Analysis:
Time Complexity = O()
*/