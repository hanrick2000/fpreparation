/*
Question:
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
		
Question Source: http://www.careercup.com/question?id=6631993756352512
Answer Source: http://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/

Hints:
Think carefully how you would do matching of ‘*’. Please note that ‘*’ in regular expression
 is different from wildcard matching, as we match the previous character 0 or more times. 
 But, how many times? If you are stuck, recursion is your friend.
 
 THUS, THIS PROGRAM CAN ONLY BE SOLVED EFFECTIVELY USING RECURSION
 
 IMP Sources:
 http://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/
 http://leetcode.com/2011/09/regular-expression-matching.html
 
 
ALGORITHM:
The problem should be simplified to handle 2 basic cases:

the second char of pattern is "*"	
the second char of pattern is not "*"

For the 1st case, if the first char of pattern is not ".", the first char of pattern and string 
should be the same. Then continue to match the left part.
For the 2nd case, if the first char of pattern is "." or first char of pattern == the first i char of string, 
continue to match the left.

*/
package Regex.StarDot;


public class UsingRecursion {
	public static void main(String[] args) {
		
		// REGEX, STRING
		System.out.println(isMatch( "ab", ".*"));
		System.out.println(isMatch("","."));
		System.out.println(isMatch( "a", "ab*"));
		System.out.println(isMatch("ab","a."));
		System.out.println(isMatch("a", "a"));
		System.out.println(isMatch( "aaab","b*a.*."));
		System.out.println(isMatch("abbbbbb","ab*"));
		System.out.println(isMatch("Facebk","F.c.bo*k"));
	}
	public static boolean isMatch(String s, String p) {
		// base case
		if (p.length() == 0) {
			return s.length() == 0;
		}
	 
		// special case
		if (p.length() == 1) {
	 
			// if the length of s is 0, return false
			if (s.length() < 1) {
				return false;
			}
	 
			//if the first does not match, return false
			else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			}
	 
			// otherwise, compare the rest of the string of s and p.
			else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}
	 
		// case 1: when the second char of p is not '*'
		if (p.charAt(1) != '*') {
			if (s.length() < 1) {
				return false;
			}
			else if ((p.charAt(0) != s.charAt(0)) && (p.charAt(0) != '.')) {
				return false;
			} 
			else {
				return isMatch(s.substring(1), p.substring(1));
			}
		}
	 
		// case 2: when the second char of p is '*', complex case.
		else {
			//case 2.1: single previous character & '*' can stand for 0 element
			// character repeated 0 times
			if (isMatch(s, p.substring(2))) {
				return true;
			}
	 
			//case 2.2: single previous character & '*' can stand for 1 or more preceding element, 
			//so try every sub string
			// character repeated 1 time
			int i = 0;
			while (i<s.length() && (s.charAt(i)==p.charAt(0) || p.charAt(0)=='.')){
				if (isMatch(s.substring(i + 1), p.substring(2))) {
					return true;
				}
				i++;
			}
			return false;
		}
	}
}
