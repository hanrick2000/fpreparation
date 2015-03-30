/*
 * Question: You are given a set of unique characters and a string. 

Find the smallest substring of the string containing all the characters in the set. 

Example:
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Question Source: http://www.careercup.com/question?id=5092414932910080

 * Answer Source: http://articles.leetcode.com/2010/11/finding-minimum-window-in-s-which.html
 * 
 * IMP Sources:
https://linchicoding.wordpress.com/2014/08/20/leetcode-minimum-window-substring/
http://rleetcode.blogspot.com/2014/01/minimum-window-substring-java.html
http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
http://mattcb.blogspot.com/2012/12/minimum-window-subs	tring.html
*/
package String.MinWindowSubstring;

import java.util.Scanner;

public class UsingTwoHashMapAndTwoPointers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter sentence");
			String big = in.nextLine();
			System.out.println("Enter text which is small than sentence");
			String small = in.nextLine();
			int minWindowBegin=0;
			int minWindowEnd=0;
			System.out.println(minWindow(big.toCharArray(), small.toCharArray(), minWindowBegin,minWindowEnd));
		}
		finally{
			in.close();
		}
	}
	
	// Returns false if no valid window is found. Else returns 
	// true and updates minWindowBegin and minWindowEnd with the 
	// starting and ending position of the minimum window.
	// Source: http://articles.leetcode.com/2010/11/finding-minimum-window-in-s-which.html
	
	/*
	 * Algorithm:
	 * 
	 * Given: S = “acbbaca” and T = “aba“
	 * 
	 * The idea is to have two pointers (begin and end position of the window) 
	 * and two arrays (needToFind and hasFound) while traversing S. needToFind stores the total count
	 * of a character in T and hasFound stores the total count of a character met so far. We also 
	 * use a count variable to store the total characters in T that’s matched so far (not counting characters 
	 * where hasFound[x] exceeds needToFind[x]). When count equals T‘s length, we know a valid window is found.
	 */
	
	public static boolean minWindow(char[] S, char[] T, int minWindowBegin, int minWindowEnd) {
	  int sLen = S.length;
	  int tLen = T.length;
	  int[] needToFind = new int[256];
	 
	  for (int i = 0; i < tLen; i++)
	    needToFind[T[i]]++;              // Given: S = “acbbaca” and T = “aba“
	 
	  int[] hasFound=new int[256];
	  int minWindowLen = Integer.MAX_VALUE;
	  int count = 0;
	  for (int begin = 0, end = 0; end < sLen; end++) {        // FOR LOOP of begin and end pointers
	    // skip characters not in T
	    if (needToFind[S[end]] == 0) 
	    	continue;
	    // since the character in T matches character in S, we increment hasFound
	    hasFound[S[end]]++;
	    
	    /*
	     * use a count variable to store the total characters in T that’s met so far 
	     * (NOTE: not counting characters where hasFound[x] exceeds needToFind[x])
	     */
	    if (hasFound[S[end]] <= needToFind[S[end]])
	      count++;
	 
	    // When count equals T‘s length, we know a valid window is found
	    if (count == tLen) {
	    // advance begin index as far right as possible,
	    // stop when advancing breaks window constraint(window constraint means count should always equal to T.length)
	    // Assume that begin points to an element x, we check if hasFound[x] is greater than needToFind[x]. 
	    // If it is, we can decrement hasFound[x] by one and advancing begin pointer without breaking the constraint. 
	    // On the other hand, if it is not, we stop immediately as advancing begin pointer breaks the window constraint.
	    // To understand this, refer here: http://articles.leetcode.com/2010/11/finding-minimum-window-in-s-which.html 
	      while (needToFind[S[begin]] == 0 || hasFound[S[begin]] > needToFind[S[begin]]) {
	    	  
	        if (hasFound[S[begin]] > needToFind[S[begin]])
	          hasFound[S[begin]]--;
	        
	        begin++;
	      }
	 
	      // update minWindow if a minimum length is met
	      int windowLen = end - begin + 1;
	      if (windowLen < minWindowLen) {
	        minWindowBegin = begin;
	        minWindowEnd = end;
	        minWindowLen = windowLen;
	      } // end if
	    } // end if
	  } // end for
	 
	  return (count == tLen) ? true : false;
	}
}
/*
Analysis:
Time Complexity = O(n) where n = length of big string(Sentence)   [O(n) considering substring() is O(1) in some languages but not in JAVA. In JAVA it is O(n)]
Space Complexity = O(1) since we use set of 256 characters which is constant memory
*/