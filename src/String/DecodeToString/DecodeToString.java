
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
package String.DecodeToString;

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
			System.out.println(result.toString());
			System.out.println("Number of ways to decode the String: "+numDecodings(num));
		}
		finally{
			in.close();
		}
	}
	
	// Using recursion we can find this
	public static Set<String> decode(String prefix, String s) {
	
		Set<String> set = new HashSet<String>();
		
		// 1. BASE CASE
		if (s.length() == 0 || s==null) {    
			set.add(prefix);                 // add and return
			return set;
		}
		
		// 2. EXTREME CASE  ('0' is not a valid encoding, hence return set)
		if (s.charAt(0) == '0')             
			return set;

		
		
		// 3. Add without condition
		set.addAll(decode(  
				prefix + (char) (s.charAt(0) - '1' + 'a'),  // add first character of the string to the prefix
				s.substring(1))
				);

		// 4. Number from 10 to 19
		if (s.length() >= 2 && s.charAt(0) == '1') {   // from 10 to 19
			set.addAll(decode(
					prefix + (char) (10 + s.charAt(1) - '1' + 'a'),   // convert "12" to integer 12
					s.substring(2))
					);
		}
		
		// 5. Number from 20 to 26
		if (s.length() >= 2 && s.charAt(0) == '2' && s.charAt(1) <= '6') {   // from 20 to 26
			set.addAll(decode(
					prefix + (char) (20 + s.charAt(1) - '1' + 'a'),   // convert "22" to integer 22
					s.substring(2))
					);
		}
		
		return set;
}
	
	/*
	Analysis:
	Time Complexity = O()
	Space Complexity = O()
	*/
	
	
	
	// Number of ways to decode the String is given by DP solution mentioned below
	// Preferred method to calculate number of ways because the Time Complexity = O(n)
	public static int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] nums = new int[s.length() + 1];
		nums[0] = 1;
		nums[1] = s.charAt(0) != '0' ? 1 : 0;           
		// character is Not '0' then 1 
		// that means any other character present from '1' to '9' can be decoded in 1 way 
		// because mappings are present for all numbers from '1' to '9' 
		
		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) != '0') 
				nums[i] = nums[i - 1];                            // Current = Previous
			int twoDigits = (s.charAt(i - 2) - '0') * 10 + (s.charAt(i - 1) - '0'); 
			if (twoDigits >= 10 && twoDigits <= 26) 
				nums[i] = nums[i] + nums[i - 2];                  // Current = Current + Previous(Previous)
		}
		return nums[s.length()];
    }
	/*
	Analysis:
	Time Complexity = O(n) where n = length of the string
	Space Complexity = O(n)
	*/
}
