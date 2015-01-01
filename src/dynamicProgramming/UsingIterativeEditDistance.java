package dynamicProgramming;

import java.util.Scanner;

public class UsingIterativeEditDistance {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the two strings");
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		System.out.println(calculateCost(s1,s2));
	}
	finally{
		in.close();
	}
}

private static int calculateCost(String s1, String s2) {
	int m = s1.length();
	int n = s2.length();
	
	int[][] table = new int[m+1][n+1];
	
	for(int i=0;i<=m;i++)
		table[i][0] = i;
	
	for(int i=0;i<=n;i++)
		table[0][i] = i;
	
	//printTable(table,table.length,table[0].length);
	int left=0;
	int top=0;
	int corner=0;
	
	for(int i=1;i<=m;i++){
		for(int j=1;j<=n;j++){
			
			left = table[i-1][j] + 1;
			top = table[i][j-1] + 1;
			corner = table[i-1][j-1] + check(s1.charAt(i-1),s2.charAt(j-1));// It seems as if we are calling the check() method on
			//the previous characters. This is not the case, the check method is called on the current characters. Please construct the 
			// 'table' to understand that the call is on current characters and not previous characters. 
			// To make it easy, construct the table for small strings such as 'me','tu'.
			
			table[i][j] = Math.min(Math.min(left,top),corner);
		}
	}
	printTable(table,table.length,table[0].length);
	
	return table[m][n];
}

private static void printTable(int[][] table, int m, int n) {
	//System.out.println(m);
	//System.out.println(n);
	for(int i=0;i<m;i++){
		for(int j=0;j<n;j++){
			System.out.print(table[i][j]);
			System.out.print(" ");
		}
		System.out.println();
	}
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
	 Space Complexity = O(n^2)*/