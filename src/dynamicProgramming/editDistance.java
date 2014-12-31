package dynamicProgramming;

// Recursive Program to convert one string into another. Also called as edit distance algorithm

import java.util.Scanner;

public class editDistance {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the two strings");
		String s1= in.nextLine();
		String s2=in.nextLine();
		System.out.println(editDistanceCalculation(s1.length(), s2.length(), s1, s2));
	}
	finally{
		in.close();
	}
}

private static int editDistanceCalculation(int m, int n, String s1, String s2) {
	if(m==0 & n==0)
		return 0;
	if(m==0)
		return n;
	if(n==0)
		return m;
	
	int left = editDistanceCalculation(m-1, n, s1,s2)+1;   // Deletion
	int top = editDistanceCalculation(m, n-1, s1,s2)+1;  // Insertion
	int corner = editDistanceCalculation(m-1, n-1, s1,s2) + check(s1.charAt(m-1),s2.charAt(n-1));  // Substitution
	// It seems as if we are calling the check() method on
	//the previous characters. This is not the case, the check method is called on the current characters. 
	//Please hand run the recursive calls for small strings such as 'me', 'tu', to understand that the call
	// is on current characters and not previous characters.
	//                       OR
	// Check the Explanation for dynamic programming approach to solve this problem, where clearly this thing
	// is explained that the calls are to the current characters and not previous characters. Please first
	// do the dynamic programming approach for this problem and then do the Recursive Approach to solve this problem.
	
	return Math.min(Math.min(left, top),corner);
}

private static int check(char c1, char c2) {
	if(c1==c2)
		return 0;
	return 1;
}
}
