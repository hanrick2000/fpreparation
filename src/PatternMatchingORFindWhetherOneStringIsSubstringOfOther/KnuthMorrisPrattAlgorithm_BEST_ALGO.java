
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


Explanation of KMP Algorithm:
Source: http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/

		
Question Source: http://www.careercup.com/question?id=6196366774632448

Algorithm: Algorithm is very well explained in these two sources:
http://jakeboxer.com/blog/2009/12/13/the-knuth-morris-pratt-algorithm-in-my-own-words/
http://www.geeksforgeeks.org/searching-for-patterns-set-2-kmp-algorithm/
*/

package PatternMatchingORFindWhetherOneStringIsSubstringOfOther;

import java.util.Scanner;

public class KnuthMorrisPrattAlgorithm_BEST_ALGO {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the text");
			String text = in.nextLine();
			System.out.println("Enter the pattern");
			String pattern = in.nextLine();
			usingKMPAlgorithm(text,pattern); // Returns the index if pattern lies in text OR else returns NOTHING
			
			
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

	private static void usingKMPAlgorithm(String text, String pattern) {
		
		// create longestPrefixSuffixTable that will hold the longest prefix suffix values for pattern
		int[] longestPrefixSuffixTable = new int[pattern.length()];
		
		// populate the table
		populateTable(pattern,longestPrefixSuffixTable);
		
		int textIterator = 0;  // iterator for text
		int patternIterator=0; // iterator for pattern
		
		while(textIterator<text.length()){
			
			if(pattern.charAt(patternIterator)==text.charAt(textIterator)){  // if characters in pattern and text match
				patternIterator++;
				textIterator++;
			}
			
			if(patternIterator==pattern.length()){     // if pattern is fully visited
				System.out.println("Found pattern at index: "+(textIterator-patternIterator));
				patternIterator=longestPrefixSuffixTable[patternIterator-1];
			}
			
			// mismatch after patternIterator matches
			else if(textIterator<text.length() && pattern.charAt(patternIterator)!=text.charAt(textIterator)){
				
				// Do not match longestPrefixSuffixTable[0..longestPrefixSuffixTable[j-1]] characters,
		        // they will match anyway
				if(patternIterator!=0)
					patternIterator=longestPrefixSuffixTable[patternIterator-1];
				else
					textIterator=textIterator+1;
			}
			
		}
	}

	private static void populateTable(String pattern, int[] longestPrefixSuffixTable) {
		
		int i=1;  // index for iterating over the pattern string
		longestPrefixSuffixTable[0] = 0; // longestPrefixSuffixTable[0] is always 0
		int previousLength = 0; // length of the previous longest prefix suffix
		
		while(i<pattern.length()){    // the loop calculates longestPrefixSuffixTable[i] for i = 1 to M-1
			
			if(pattern.charAt(i)==pattern.charAt(previousLength)){
				longestPrefixSuffixTable[i]=previousLength+1;
				previousLength++;    // increment the previous Length
				i++;   // increment the iterator
			}
			else{   // if(pattern.charAt(i)!=pattern.charAt(previousLength))
				
				if(previousLength!=0)
					previousLength = longestPrefixSuffixTable[previousLength-1];
				
				else{ //(previousLength==0)
					longestPrefixSuffixTable[i]=0;
					i++;
				}
			}
		}		
	}
}
/*
Analysis:
	Time Complexity = O(n) where n = length of TEXT
	Space Complexity = O(m) where m = length of PATTERN
*/