/*
Question:
	Given a regular expression with characters a-z, ' * ', ' . ' 
	the task was to find if that string could match another string with characters from: a-z 
	where ' * ' can delete the character before it, and ' . '
	could match whatever character. ' * ' always appear after a a-z character. 
	Example: 
		isMatch("a*", "") = true; 
		isMatch(".", "") = false; 
		isMatch("ab*", "a") = true; 
		isMatch("a.", "ab") = true; 
		isMatch("a", "a") = true;
		isMatch("ab*", "ab") = true;
		
Question & Answer Source: http://www.careercup.com/question?id=6631993756352512
*/
package REGEXStarDotProblem;


public class UsingRecursion {
	public static void main(String[] args) {
		System.out.println(isMatch("a*", ""));
		System.out.println(isMatch(".", ""));
		System.out.println(isMatch("ab*", "a"));
		System.out.println(isMatch("a.", "ab"));
		System.out.println(isMatch("a", "a"));
		System.out.println(isMatch("aaaa*a.", "aaaab"));
		System.out.println(isMatch("ab*", "ab"));
	}
	static boolean isMatch(String regex, String s)
	{
	    return IsMatch(regex, s, regex.length() - 1, s.length() - 1);
	}

	static boolean IsMatch(String regex, String s, int i, int j)
	{
	    if (i < 0) // If the regex is over
	    {
	        return j < 0;   // return true if the string is also over OR ELSE return false
	    }

	    boolean result = false;

	    if (j >= 0)
	    {
	        if (regex.charAt(i) == '.' || regex.charAt(i) == s.charAt(j) ) 
	        	result = IsMatch(regex, s, i - 1, j - 1);
	    }

	    if (regex.charAt(i)  == '*')
	    	result = IsMatch(regex, s, i - 2, j) || IsMatch(regex, s, i - 1, j);

	    return result;
	}
}
