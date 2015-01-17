/*
Question: Check whether a pattern string lies in the text string ?
		
VERY IMP NOTE: 
The difference between them, can cearly be made out from the following readings:
http://en.wikipedia.org/wiki/Subsequence
http://en.wikipedia.org/wiki/Substring


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



Explanation of KMP Algorithm:
Source: http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/

		
Question Source: http://www.careercup.com/question?id=6196366774632448

Algorithm: For i = 0 to (1 + text.length - pattern.length)
			 For j=0 to pattern.length
			 	Check if (text[i+j]==pattern[])
*/
	
package PatternMatching;

import java.util.Scanner;

public class NaiveAlgorithm {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the text");
		String text = in.nextLine();
		System.out.println("Enter the pattern");
		String pattern = in.nextLine();
		System.out.println("The pattern present in the text: "+usingNaiveAlgorithm(text,pattern));
		
		
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

private static boolean usingNaiveAlgorithm(String text, String pattern) {
	int i=0;
	int j=0;
	for(i=0;i<(1+text.length()-pattern.length());i++){
		for(j=0;j<pattern.length();j++){
			if(text.charAt(i+j)!=pattern.charAt(j))
				break;
			}
		if(j==pattern.length())
	    	return true;	
		}
	return false;
	}
	
}
/*
Analysis: 
	Time Complexity = (n*m)
	where n = Length of Text
		  m = Length of Pattern
    Space Complexity = O(1)
*/