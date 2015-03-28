/*
Question: Given a mapping of alphabets to integers as follows: 

1 = A 
2 = B 
3 = C 
... 
26 = Z 

Given any combination of the mapping numbers as string, return the number of ways in which the input 
string can be split into sub-strings and represented as character strings.
For e.g. given 
"111" -> "AAA", "AK", "KA" -> 3 
Valid combinations are ({1,1,1}, {1,11},{11,1}) = 3 

Question Source: http://www.careercup.com/question?id=5705619461898240

Answer Source: http://shanjiaxin.blogspot.com/2014/04/decode-ways-leetcode.html

Algorithm:
 * Solution: Linear DP
 * Nums [i] before representatives 0 digit number can be in the solution. 
 * 1. For each non-zero, num [i] = num [i-1]. Here only a single digit calculation problem 
 * 2. For two digit, look at whether the 10-26 range, if num [i] + = num [i-2] solution species equal
 *    num [i-2], which is focused on the front, such that Several
 * 3. test case, the last one if it is 0, the range, that is, num [i-2] possible, if not, the String is not legal.
 * 
*/


package String.DecodeToString;

import java.util.Scanner;


public class NumberOfWaysToDecode {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the numeric string to be decoded");
			String num = in.nextLine();
			System.out.println("Number of ways to decode the String: "+numDecodings(num));
		}
		finally{
			in.close();
		}
	}
	public static int numDecodings(String s) {

		if (s == null || s.length() == 0) {
			return 0;
		}
		int[] nums = new int[s.length() + 1];
		nums[0] = 1;                               // (To get started) [Initially '1' to '9' can be decoded in 1 way]
		nums[1] = s.charAt(0) != '0' ? 1 : 0;           
		// character at position 0 is Not '0' then 1 decoding possible
		// that means any other character present from '1' to '9' can be decoded in 1 way 
		// because mappings are present for all numbers from '1' to '9' 
		
		for (int i = 2; i <= s.length(); i++) {
			if (s.charAt(i - 1) != '0')                           // If character is NOT '0' 
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
