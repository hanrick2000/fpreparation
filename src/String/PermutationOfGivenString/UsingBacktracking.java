/*
Question: Print all the permutaion of a given string. 

1) explain time\space complexity? 

2) how can you improve time\space complexity?

Question and Answer Source: http://www.careercup.com/question?id=15317787
http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
http://www.geeksforgeeks.org/print-all-permutations-with-repetition-of-characters/

Algorithm:
A permutation, also called an “arrangement number” or “order,” is a rearrangement of the elements of 
an ordered list S into a one-to-one correspondence with S itself. A string of length n has n! permutation.

Below are the permutations of string ABC.
ABC, ACB, BAC, BCA, CAB, CBA

Here is a solution using backtracking.
*/
package String.PermutationOfGivenString;

/*
import java.util.HashSet;
import java.util.Set;
*/
import java.util.Scanner;

public class UsingBacktracking {
	//private static Set<Character> set;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to print the PERMUTATIONS of a given STRING");
			System.out.println("Enter the string");
			String s = in.nextLine();
			System.out.println("Using BackTracking WITHOUT handling REPEATED characters:");
			permute(s.toCharArray(),0,s.length()-1);
			/*
			System.out.println("Using BackTracking WITH handling REPEATED characters:");
			printPermutations(s.toCharArray(), 0);
			System.out.println(set.toString());
			*/
		}
		finally{
			in.close();
		}
	}
	/* Function to print permutations of string
	   This function takes three parameters:
	   1. String
	   2. Starting index of the string
	   3. Ending index of the string. */
	private static void permute(char[] s, int start, int end) {
			if(start==end)
				System.out.println(String.valueOf(s));
			else{
				for(int i=start;i<=end;i++){
					swap(s,start,i);
					permute(s,start+1,end);
					swap(s,start,i);  // backtrack
				}
			}
		}

	private static void swap(char[] s, int from, int to) {
		char temp = s[from];
		s[from] = s[to];
		s[to] = temp;
	}
	
	/*
	 * Is there a better time complexity solution ?
	 * http://www.quora.com/What-is-the-fastest-algorithm-to-find-all-possible-permutations-of-a-string
	 * http://stackoverflow.com/questions/20991167/improving-the-time-complexity-of-all-permutations-of-a-given-string
	 * https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8&client=ubuntu#q=best%20possible%20time%20complexity%20for%20finding%20all%20permutations%20in%20a%20given%20string
	 * 
	 * Ans:
	 * An optimal permutation algorithm has to generate all the possible n! permutation, 
	 * each with n characters. So the best time complexity one can attain would be O(n*n!), 
	 * which is same as the complexity of almost all the permutation algorithms/code you can find online.
	 * 
	 */
	
	
	
	/* Algorithm Paradigm: Backtracking
	 * Analysis:
	 * Time Complexity = O(n*n!) where n = length of string
	 * Space Complexity = O(n) where n = length of string
	 * 
	 * 
	 * 
	 * 
	 * If all characters in the string are distinct there are exactly 
	 * n! permutations that must be stored and computed. The naive answer is 
	 * the optimal one for all choices of strings.

	  I think what you mean is that in the case of repeated letters you can reduce 
	  the complexity to (n \choose \lambda) where \lambda is the frequency count of the letters.
	 * 
	 */
	
/* //Extending the solution to support repeating characters
 
   private static void printPermutations(char s[], int pos) {
		if (pos == s.length) {
			System.out.println(new String(s));
			return;
		}
		set = new HashSet<Character>();
		for (int i = pos; i < s.length; ++i) {
			if (set.contains(s[i])) {
				continue;
			}
			swap(s, i, pos);
			printPermutations(s, pos + 1);
			swap(s, i, pos);
			set.add(s[i]);
		}
	}*/
}
