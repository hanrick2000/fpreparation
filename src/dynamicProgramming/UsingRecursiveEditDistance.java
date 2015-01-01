package dynamicProgramming;

// Recursive Program to convert one string into another. Also called as edit distance algorithm

import java.util.Scanner;

public class UsingRecursiveEditDistance {
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
/*
Analysis:
	I. Time Complexity:  O(3^(m+n-1)). This is an EXPONENTIAL time algorithm
	
	The recursion formula is,

	T(m,n) = T(m-1,n-1) + T(m-1,n) + T(m,n-1) + 1
	T(0,n) = n
	T(m,0) = m
	is right.

	You can see, that every T(m,n) splits of into three paths. Due to every node runs in O(1) we only have to 
	count the nodes.

	A shortest path has the length min(m,n), so the (recursion)tree has at least 3min(m,n) nodes. But there are 
	some paths that are longer. 
	
	You get the longest path by alternately reduce the first and the second string.
	This path will have the length m+n-1, so the whole tree has at most 3m+n-1 nodes.

	Let m = min(m,n). The tree contains also at least

	enter image description here

	different paths, one for each possible order of reducing n.

	So Ω(2^(max(m,n))) and Ω(3^(min(m,n))) are lower bounds and O(3^(m+n-1)) is an upper bound.
	
	*
	*I. Space Complexity: The space complexity of the algorithm is also EXPONENTIAL (since multiple
	* recursive calls utilizes many stack frames. If the length of the strings is 10^5, the program might crash)
	*
	*/