/*
Question: Check whether a p string lies in the t string ?
		
VERY IMP NOTE: 
The difference between them, can early be made out from the following readings:
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
1. Naive String Matching Algorithm: http://www.geeksforgeeks.org/searching-for-ps-set-1-naive-p-searching/
2. Rabin-Karp String Matching Algorithm: http://www.geeksforgeeks.org/searching-for-ps-set-3-rabin-karp-algorithm/
3. Knuth-Morris-Pratt String Matching Algorithm: http://www.geeksforgeeks.org/searching-for-ps-set-2-kmp-algorithm/

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
http://www.geeksforgeeks.org/searching-for-ps-set-2-kmp-algorithm/
*/

package String.PatternMatchingORFindWhetherOneStringIsSubstringOfOther;

import java.util.Scanner;

public class KnuthMorrisPrattAlgorithm_BEST_ALGO {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the text");
			String t = in.nextLine();  // text
			System.out.println("Enter the pattern");
			String p = in.nextLine();  // pattern
			int result = usingKMPAlgorithm(t,p); // Returns the index if p lies in t OR else returns NOTHING
			if(result==-1)
				System.out.println("Pattern NOT PRESENT in Text");
			else
				System.out.println("Pattern PRESENT in Text at INDEX: "+result);
			/*
			// Understand how substring and subsequence methods are implemented in String class
			String substring = t.substring(0,3);
			CharSequence sequence = t.subSequence(0, 3);
			System.out.println(substring);
			System.out.println(sequence);
			*/
		}
		finally{
			in.close();
		}
	}

	private static int usingKMPAlgorithm(String t, String p) {   // t = text and p = pattern
		/*
		NOTE: THREE IMP THINGS TO REMEMBER ABOUT THIS FUNCTION
		
		I. When there is a match between characters
			tI++ && pI++
	    II. When pattern completely visited
	    	return tI-pI
		II. When there is NO MATCH between characters
			a. Check if pI==0 then INCREMENT tI
			b. Check if pI!=0 then UPDATE pI using the table
		*/
		

		
		// create longestPrefixSuffixTable that will hold the longest prefix suffix values for p
		int[] table = new int[p.length()];
		
		// populate the table
		table = populateTable(p,table);
		
		int tI = 0;  // iterator for t
		int pI=0; 	 // iterator for p
		
		while(tI<t.length()){
			
			if(p.charAt(pI)==t.charAt(tI)){  // if characters in p and t match
				pI++;
				tI++;
			}
			
			if(pI==p.length()){     // if p is COMPLETELY VISITED
				return (tI-pI);     // index where the pattern is present in the text
			}
			
			// mismatch after pI matches
			else if(tI<t.length() && p.charAt(pI)!=t.charAt(tI)){
				
				// Do not match table[0..table[j-1]] characters,
		        // they will match anyway
				if(pI==0)
					tI++;
				else
					pI=table[pI-1];  // skip these many locations
			}
			
		}
		return -1;
	}

	private static int[] populateTable(String p, int[] table) {
		/*
		NOTE: TWO IMP THINGS TO REMEMBER ABOUT THIS FUNCTION
		table[0]=0   ,   i=1   ,   previousLength=0   
		I. When there is a match between characters
			Update table, i and previousLength
		II. When there is NO MATCH between characters
			a. Check if peviousLength==0   --> fill table, increment i
			b. Check if previousLength!=0  --> update previousLength
		*/
		table[0] = 0; // table[0] is always 0
		int i=1;  // index for iterating over the p string
		int previousLength = 0; // length of the previous longest prefix suffix
		
		while(i<p.length()){    // the loop calculates table[i] for i = 1 to M-1
			
			if(p.charAt(i)==p.charAt(previousLength)){
				table[i]=previousLength+1;
				previousLength++;    // increment the previous Length
				i++;   				 // increment the iterator
			}
			else{   				 // if(p.charAt(i)!=p.charAt(previousLength))
				
				if(previousLength==0) {  
					table[i]=0;
					i++;
				}
				else{ //(previousLength!=0) VERY IMP, here we ONLY UPDATE the previousLength	
					previousLength = table[previousLength-1];
				}
			}
		}
		return table;
	}
}
/*
Analysis:
	Time Complexity = O(n) where n = length of t
	Space Complexity = O(m) where m = length of p
*/