

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
        
Explanation of Karp-Rabin Algorithm:
Source: http://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
		http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=stringSearching
		
Question Source: http://www.careercup.com/question?id=6196366774632448

Algorithm: Algorithm is very well explained in these two sources:
http://www.geeksforgeeks.org/searching-for-patterns-set-3-rabin-karp-algorithm/
http://community.topcoder.com/tc?module=Static&d1=tutorials&d2=stringSearching
*/


package String.PatternMatchingORFindWhetherOneStringIsSubstringOfOther;

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
		
		int hashValueText = 0;      // hash value for text
		int hashValuePattern = 0;   // hash value for pattern
		
		int primeNumber = 101; // prime number for calculating hash value
		
		int i = 0; // text string iterator
		int j = 0; // pattern string iterator
		
		int N = text.length();
		int M = pattern.length();
		
		// d is the number of characters in input alphabet
		int ascii = 256;   // ASCII Table characters
		
		// The value of hash would be (hash*ascii)%primeNumber"
		int hash=1;
	    for (i = 0; i < (M-1); i++)
	        hash = (hash*ascii)%primeNumber;
	    
	    // Calculate the hash value of pattern and first window of text
	    for (i = 0; i < M; i++)
	    {
	        hashValuePattern = (ascii*hashValuePattern + pattern.charAt(i))%primeNumber;
	        hashValueText = (ascii*hashValueText + text.charAt(i))%primeNumber;
	    }
	    
	    
	    // Slide the pattern over text one by one 
	    for (i = 0; i < (N - M + 1); i++)
	    {
	        
	        // Check the hash values of current window of text and pattern
	        // If the hash values match then only check for characters on by one
	        if ( hashValuePattern == hashValueText )
	        {
	            /* Check for characters one by one */
	            for (j = 0; j < M; j++)
	            {
	                if (text.charAt(i+j) != pattern.charAt(j))
	                    break;
	            }
	            if (j == M)  // if hashValuePattern == hashValueText and pat[0...M-1] = text[i, i+1, ...i+M-1]
	            {
	                System.out.println("Pattern found at index: "+i);
	            }
	        }
	         
	        // Calculate hash value for next window of text: Remove leading digit, 
	        // add trailing digit           
	        if ( i < N-M )
	        {
	        	hashValueText = (ascii*(hashValueText - text.charAt(i)*hash) + text.charAt(i+M))%primeNumber;
	             
	            // We might get negative value of t, converting it to positive
	            if(hashValueText < 0) 
	            	hashValueText = (hashValueText + primeNumber); 
	        }
	    }
		
	}
}
/*
Analysis:
 
	Time Complexity:
		Best and Average Case = O(n+m)
		Worst Case = O(nm)
		where n = length of TEXT
			  m = length of PATTERN
    Space Complexity = O(1)
*/