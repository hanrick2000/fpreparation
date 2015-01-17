

/*
Question: Check whether a pattern string lies in the text string ?
		
VERY IMP NOTE: 
The difference between them, can cearly be made out from the following readings:
http://en.wikipedia.org/wiki/Subsequence
http://en.wikipedia.org/wiki/Substring

In actual understanding, subsequence and substring are DIFFERENT.
	However Java developers implemented these two methods to return the same output.
	For Example:
	(Example Source: http://mytactics.blogspot.com/2013/10/difference-between-subsequence-and.html)
	class StringSeqSub{
    public static void main(String args[])
    	{
        String str = "Hello World.!!";
        // String s1 = str.subSequence(0, 5);    // this line will throw error
        CharSequence s1 = str.subSequence(0, 5);
        String s2 = str.substring(0, 5);
        System.out.println(s1);
        System.out.println(s2);
    	} 
	}
Output - 
Hello
Hello

GeeksForGeeks Links for the following String Matching algorithms:
1. Naive String Matching Algorithm: http://www.geeksforgeeks.org/searching-for-patterns-set-1-naive-pattern-searching/
2. Rabin-Karp String Matching Algorithm: http://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
3. Knuth-Morris-Pratt String Matching Algorithm: http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/

The ALGORITHMS for finding both are also DIFFERENT:
1. For Subsequnece:
  We use the traditional LCS algorithm
2. For Substring:
  We use,
        1. KMP (Knuth–Morris–Pratt) algorithm
        URL: http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
             http://www.quora.com/What-is-the-best-resource-to-learn-KMP-Algorithm
        2. Rabin-Karp algorithm
        URL: http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=stringSearching
        
Explanation of Rabin-Karp Algorithm:
Source: http://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
		http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=stringSearching
		
Question Source: http://www.careercup.com/question?id=6196366774632448

Algorithm: Algorithm is very well explained in these two sources:
http://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=stringSearching
*/


package PatternMatching;

import java.util.Scanner;

public class KarpRabinAlgorithm {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the text");
			String text = in.nextLine();
			System.out.println("Enter the pattern");
			String pattern = in.nextLine();
			usingKarpRabinAlgorithm(text,pattern); // Returns the index if pattern lies in text OR else returns NOTHING
			
			
			/*
			// Understand how substring and subsequence methods are implemented in String class
			String substring = text.substring(0,3);
			CharSequence sequence = text.subSequence(0, 3);
			System.out.println(substring);
			System.out.println(sequence);
			*/
		}
		finally{
			in.close();
		}
	}

	private static void usingKarpRabinAlgorithm(String text, String pattern) {
		
	}
}
