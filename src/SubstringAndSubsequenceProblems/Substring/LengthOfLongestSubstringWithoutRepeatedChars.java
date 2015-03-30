/*
 * Question: Given a string, find the length of the longest substring without repeating characters.
 * Question and Answer Source: http://www.geeksforgeeks.org/length-of-the-longest-substring-without-repeating-characters/
 * Example:
 * The longest substrings without repeating characters for “ABDEFGABEF” are “BDEFGA” and “DEFGAB”, with length 6. 
 * For “BBBB” the longest substring is “B”, with length 1.
 * 
 * Algorithm:
 * Dynamic Programming Method: (Linear Time)
This solution uses extra space to store the last indexes of already visited characters. 
The idea is to scan the string from left to right, keep track of the maximum length Non-Repeating Character
 Substring (NRCS) seen so far. Let the maximum length be maxLength. When we traverse the string, 
 we also keep track of length of the current NRCS using currLength variable. For every new character, 
 we look for it in already processed part of the string (A temp array called visited[] is used for this purpose).
  If it is not present, then we increase the currLength by 1. If present, then there are two cases:
  
a) The previous instance of character is not part of current NRCS (The NRCS which is under process). 
In this case, we need to simply increase currLength of current NRCS by 1.
b) If the previous instance is part of the current NRCS, then our current NRCS changes. It becomes 
the substring staring from the next character of previous instance to currently scanned character. 
We also need to compare currLength and maxLength, before changing current NRCS (or changing currLength).
 * 
 */

package SubstringAndSubsequenceProblems.Substring;

public class LengthOfLongestSubstringWithoutRepeatedChars {
	public static int longestUniqueSubsttr(String str){
/*
Algorithm:
The idea is to scan the string from left to right, keep track of the maximum length Non-Repeating Character
 Substring (NRCS) seen so far. Let the maximum length be maxLength. When we traverse the string, 
 we also keep track of length of the current NRCS using currLength variable. For every new character, 
 we look for it in already processed part of the string (A temp array called visited[] is used for this purpose).
  If it is not present, then we increase the currLength by 1. If present, then there are two cases:
  
a) The previous instance of character is not part of current NRCS (The NRCS which is under process). 
In this case, we need to simply increase currLength of current NRCS by 1.
b) If the previous instance is part of the current NRCS, then our current NRCS changes. It becomes 
the substring staring from the next character of previous instance to currently scanned character. 
We also need to compare currLength and maxLength, before changing current NRCS (or changing currLength).
*/
	    int n = str.length();
	    int currLength = 1;  // To store the length of current NRCS
	    int maxLength = 1;  // To store the length of result(maxLength of NRCS)
	    int prevIndex;  // To store the previous index of every character
	    int i;
	    int[] visited = new int[256];    // all characters of the ASCII table
	 
	    /* Initialize the visited array as -1, -1 is used to indicate that
	       character has not been visited yet. */
	    for (i = 0; i < 256;  i++)
	        visited[i] = -1;
	 
	    /* Mark first character as visited by storing the index of first 
	       character in visited array. */
	    visited[str.charAt(0)] = 0;
	 
	    /* Start from the second character. First character is already processed
	       (currLength and maxLength are initialized as 1, and visited[str[0]] is set */
	    for (i = 1; i < n; i++)
	    {
	        prevIndex =  visited[str.charAt(i)];// get the previous index of the character.
	        									// This will be -1 if the character is visited first time
	 
	        /* If the current character is not present in the already processed
	           substring or it is not part of the current NRCS, then do currLength++ */
	        if (prevIndex == -1 || i - currLength > prevIndex)
	            currLength++;
	 
	        /* If the current character is present in currently considered NRCS,
	           then update NRCS to start from the next character of previous instance. */
	        else
	        {
	            /* Also, when we are changing the NRCS, we should also check whether 
	              length of the previous NRCS was greater than maxLength or not.*/
	            maxLength = Math.max(maxLength,currLength);
	            currLength = i - prevIndex;
	        }
	        visited[str.charAt(i)] = i; // update the index of current character
	    }
	    // Compare the length of last NRCS with maxLength and update maxLength if needed
	    maxLength = Math.max(maxLength,currLength);
	    return maxLength;
	}
	
	 
	/* Driver program to test above function */
	public static void main(String[] args) {
	    String str = "abscbedkheukloinneils";
	    System.out.println("The input string is "+str);
	    int len =  longestUniqueSubsttr(str);
	    System.out.println("The length of the longest non-repeating character substring is: "+len);
	}
	/*
	Time Complexity: O(n + d) where n is length of the input string and d is
	 number of characters in input string alphabet. 
	 Here d = 256
	 For example, if string consists of lowercase English characters then value of d is 26.
	Auxiliary Space: O(d)   Here d = 256
	Algorithmic Paradigm: Dynamic Programming
	*/
	}
