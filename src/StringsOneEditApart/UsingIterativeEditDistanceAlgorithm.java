package StringsOneEditApart;

import java.util.Scanner;

public class UsingIterativeEditDistanceAlgorithm {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the two strings for comparison");
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		if(iterativeEditDistanceAlgorithm(s1,s2)==1)
			System.out.println("True");
		else
			System.out.println("False");
	}
	finally{
		in.close();
	}
}
private static int iterativeEditDistanceAlgorithm(String s1, String s2) {
	int[][] table = new int[s1.length()+1][s2.length()+1];
	for(int i=0;i<table.length;i++)
		table[i][0]=0;
	for(int i=0;i<table[0].length;i++)
		table[0][i]=0;
	
	int left = 0;
	int top = 0;
	int corner=0;
	for(int i=1;i<table.length;i++){
		for(int j=1;j<table[0].length;j++){
			left = table[i-1][j] + 1;
			top = table[i][j-1] +1;
			corner = table[i-1][j-1] + check(s1.charAt(i-1),s2.charAt(j-1));
			table[i][j] = Math.min(Math.min(left,top), corner);
		}
	}
	return table[table.length-1][table[0].length-1];
}

private static int check(char c1, char c2) {
	if(c1==c2)
		return 0;
	return 1;
}
}
/*
Analysis:
	Time Complexity = O(n^2)
	Space Complexity = O(n^2)
	*/