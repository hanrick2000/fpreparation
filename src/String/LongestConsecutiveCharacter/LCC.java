/*
Question: First they did ask to find pattern of this


'this is a test sentence' => [t, h, i, s, i, s, a, t, e, s, t, s, e, n, t, e, n, c, e]
'thiis iss a teest seentennce' => [i, s, e, e, n]
'thiiis iss aa teeest seentennnce' => [i, e, n]
'thiiiis iss a teeest seeentennncccce' => [i, c]
after i have to do body of function


getLongestConsecutiveChar

Question and Answer Source: http://www.careercup.com/question?id=5096352075743232

*/

package String.LongestConsecutiveCharacter;

import java.util.ArrayList;
import java.util.List;

public class LCC {
	public static void main(String[] args) {
		String s1="this is a test sentence";
		String s2="thiis iss a teest seentennce";
		String s3="thiiis iss aa teeest seentennnce";
		String s4="thiiiis iss a teeest seeentennncccce";
		System.out.println(getLongestConsecutiveChar(s1));
		System.out.println(getLongestConsecutiveChar(s2));
		System.out.println(getLongestConsecutiveChar(s3));
		System.out.println(getLongestConsecutiveChar(s4));
	}
	private static List<Character> getLongestConsecutiveChar(String s) {
        int maxLength=0;      // max Length
        int len=1;            // every character has longest consecutive char length of 1
        List<Character> res=new ArrayList<Character>();
        for(int i=0;i<s.length()-1;i++){
        	if(s.charAt(i)==' '){                          // if the current character is empty space then len=1 and continue
        		len=1;
        		continue;
        	}
            while(i<s.length()-1 && s.charAt(i)==s.charAt(i+1)){  // if match is found with every next character
                len++;                  
                i++;                 // We increment i here. Hence the time complexity of for loop is O(n)
            }
            if(len>maxLength){              
                res.clear();
                res.add(s.charAt(i));
                maxLength=len;
            } 
            else if(len==maxLength){
                res.add(s.charAt(i));
            }
            len=1;
        }        
        return res;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n)
	 * Space Complexity = O(n)
	 */
}
