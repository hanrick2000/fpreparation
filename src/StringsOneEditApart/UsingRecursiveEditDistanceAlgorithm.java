package StringsOneEditApart;

import java.util.Scanner;

public class UsingRecursiveEditDistanceAlgorithm {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the two strings");
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		if(editDistanceAlgorithm(s1,s2, s1.length(), s2.length()) == 1)
			System.out.println("True");
		else
			System.out.println("False");
	}
	finally{
		in.close();	
	}
}

private static int editDistanceAlgorithm(String s1, String s2, int m, int n) {
	if(m==0 || n==0)
		return 0;
	if(m==0)
		return n;
	if(n==0)
		return m;
	
	int left = editDistanceAlgorithm(s1, s2, m-1, n) + 1 ;
	int top = editDistanceAlgorithm(s1, s2, m, n-1)+1;
	int corner = editDistanceAlgorithm(s1, s2, m-1, n-1)+check(s1.charAt(m-1),s2.charAt(n-1));
	
	return (Math.min(Math.min(left,top), corner));
}

private static int check(char c1, char c2) {
	if(c1==c2)
		return 0;
	else
		return 1;
}
}
/*
Analysis:
	Time Complexity = O(n^2) // However, not sure about this. Should learn calculating time compexity for recursive calls
	Since its a recursive call, if stack frames are considered in memory consumption then a lot of memory
	would be lost. The program might crash for 10^5 size strings. Hence if we need to use, edit distance algorithm,
	we should consider using Iterative Edit Distance Algorithm*/