
/*
Question: If a=1, b=2, c=3,....z=26. Given a string, find all possible codes that string can generate.
Give a count as well as print the strings. 

For example: 
Input: "1123". You need to general all valid alphabet codes from this string.

Output List 
aabc //a = 1, a = 1, b = 2, c = 3 
kbc // since k is 11, b = 2, c= 3 
alc // a = 1, l = 12, c = 3 
aaw // a= 1, a =1, w= 23 
kw // k = 11, w = 23

Question Source: http://www.careercup.com/question?id=19300678

Answer Source: http://techinterviewsolutions.net/2014/07/03/string-decode-problem/
*/
package DecodeToString;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DecodeToString {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the numeric string to be decoded");
			String num = in.nextLine();
			Set<String> result = decode("",num);
			System.out.println("Number of decoded strings: "+result.size());
			System.out.println(result.toString());
		}
		finally{
			in.close();
		}
	}
	
	// Using recursion we can find this
	public static Set<String> decode(String prefix, String code) {
		Set<String> set = new HashSet<String>();
		if (code.length() == 0 || code==null) {
			set.add(prefix);
			return set;
		}

		if (code.charAt(0) == '0')
			return set;

		
		set.addAll(decode(
				prefix + (char) (code.charAt(0) - '1' + 'a'), 
				code.substring(1))
				);

		
		if (code.length() >= 2 && code.charAt(0) == '1') {   // from 10 to 19
			set.addAll(decode(
					prefix + (char) (10 + code.charAt(1) - '1' + 'a'),
					code.substring(2))
					);
		}
		
		if (code.length() >= 2 && code.charAt(0) == '2' && code.charAt(1) <= '6') {   // from 20 to 26
			set.addAll(decode(
					prefix + (char) (20 + code.charAt(1) - '1' + 'a'),
					code.substring(2))
					);
		}
		
		return set;
}

}
