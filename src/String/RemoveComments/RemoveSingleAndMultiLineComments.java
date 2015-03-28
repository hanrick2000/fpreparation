
/*
 * Question: Implement a method called printNonComments() which prints out a extract of text with comments removed. 

For example, the input: 

hello <startMultiLine> this is a 
multi line comment </endMultiLine>all 

NOTE: You have access to a method called getNextLine() which returns the next line in the input string.

Should produce: 

hello 
all 

Question Source: http://www.careercup.com/question?id=4849108141473792

Answer Source: http://geeksquiz.com/remove-comments-given-cc-program/

*/


package String.RemoveComments;

public class RemoveSingleAndMultiLineComments {
	public static void main(String[] args) {
		String s = "   /* Test program */ \n"+
                "   int main()  \n"+
                "   {           \n"+
                "      // variable declaration \n"+
                "      int a, b, c;    \n"+
                "      /* This is a test  \n"+
                "          multiline     \n"+
                "          comment for   \n"+
                "          testing */      \n"+
                "      a = b + c;       \n"+
                "   }  ";
		System.out.println("With comments: "+s);
		System.out.println("Without comments: "+removeComments(s));
	}
	public static String removeComments(String s)
	{
	    int n = s.length();
	    StringBuilder res = new StringBuilder();
	 
	    // Flags to indicate that single line and multiple line comments
	    // have started or not.
	    boolean s_cmt = false;
	    boolean m_cmt = false;
	 
	 
	    // Traverse the given program
	    for (int i=0; i<n; i++)
	    {
	        // If single line comment flag is on, then check for end of it
	        if (s_cmt == true && s.charAt(i) == '\n'){
	        	res.append(s.charAt(i));    // since single line comment ends and new line starts hence append end of line('\n') in result
	        	s_cmt = false;
	        }
	 
	        // If multiple line comment is on, then check for end of it
	        else if  (m_cmt == true && s.charAt(i) == '*' && s.charAt(i+1) == '/'){
	            m_cmt = false;
	            i++;
	        }
	 
	        // If this character is in a comment, ignore it
	        else if (s_cmt || m_cmt)
	            continue;
	 
	        // Check for beginning of comments and set the approproate flags
	        else if (s.charAt(i) == '/' && s.charAt(i+1) == '/'){
	            s_cmt = true;
	            i++;
	        }
	        else if (s.charAt(i) == '/' && s.charAt(i+1) == '*'){
	            m_cmt = true;
	            i++;
	        }
	 
	        // If current character is a non-comment character, append it to res
	        else  
	        	res.append(s.charAt(i));
	    }
	    return res.toString();
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n)
	 * Space Complexity = O(m) where m = length of string without comments. In the worst case it is O(n)
	 */
}
