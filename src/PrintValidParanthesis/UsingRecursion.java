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
		printParanthesis(sb,n/2,n/2);
	}
	finally{
		in.close();
	}
	
}

private static void printParanthesis(StringBuilder sb, int open, int close) {
	if((open==0) && (close==0)){
		System.out.println(sb.toString());
		return;
	}
	if(open>=close)   // if open parenthesis are more than close parenthesis then return
		return;
	
	if(open>0)
		printParanthesis(sb.append('<'), open-1, close); // using this step open will be less than close
	if(close>0)
		printParanthesis(sb.append('>'), open, close-1);
		
	
	}
}
/*
Analysis:
Time Complexity = O()
*/