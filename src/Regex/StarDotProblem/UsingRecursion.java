/*
Question:
	Given a regular expression with characters a-z, ' * ', ' . ' 
	the task was to find if that string could match another string with characters from: a-z 
	where ' * ' may or may not delete the character before it, 
	and ' . ' could match whatever character. 
	' * ' always appear after a a-z character. 
	Example: 
		isMatch("a*", "") = true; 
		isMatch(".", "") = false; 
		isMatch("ab*", "a") = true; 
		isMatch("a.", "ab") = true; 
		isMatch("a", "a") = true;
		isMatch("ab*", "ab") = true;
		
Question & Answer Source: http://www.careercup.com/question?id=6631993756352512

Hints:
Think carefully how you would do matching of ‘*’. Please note that ‘*’ in regular expression
 is different from wildcard matching, as we match the previous character 0 or more times. 
 But, how many times? If you are stuck, recursion is your friend.
 
 THUS, THIS PROGRAM CAN ONLY BE SOLVED EFFECTIVELY USING RECURSION
 
 IMP Sources:
 http://www.programcreek.com/2012/12/leetcode-regular-expression-matching-in-java/
 http://leetcode.com/2011/09/regular-expression-matching.html
*/
package Regex.StarDotProblem;


public class UsingRecursion {
	public static void main(String[] args) {
		System.out.println(isMatch("a*", ""));
		System.out.println(isMatch(".", ""));
		System.out.println(isMatch("ab*", "a"));
		System.out.println(isMatch("a.", "ab"));
		System.out.println(isMatch("a", "a"));
		System.out.println(isMatch("aaaa*a.", "aaaab"));
		System.out.println(isMatch("ab*", "ab"));
		System.out.println(isMatch("F.c.bo*k","Facebk"));
	}
	static boolean isMatch(String regex, String s)
	{
	    return IsMatch(regex, s, regex.length() - 1, s.length() - 1);
	}

	static boolean IsMatch(String regex, String s, int regIndex, int strIndex)
	{
	    if (regIndex < 0) // If the regex is over
	    {
	        return strIndex < 0;   // return true if the string is also over OR ELSE return false
	    }

	    boolean result = false;

	    if (strIndex >= 0) // if the string exists
	    {
	        if (regex.charAt(regIndex) == '.' || regex.charAt(regIndex) == s.charAt(strIndex) ) 
	        	result = IsMatch(regex, s, regIndex - 1, strIndex - 1);
	    }

	    if (regex.charAt(regIndex)  == '*')
	    	result = IsMatch(regex, s, regIndex - 2, strIndex) || IsMatch(regex, s, regIndex - 1, strIndex);

	    return result;
	}
}
