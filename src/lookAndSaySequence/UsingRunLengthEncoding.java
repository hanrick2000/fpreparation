/*
Question:
	Write a program to find pattern. 

	0: 1 
	1: 11 
	2: 21 
	3: 1211 
	4: 111221 
	5: 312211 

	Iterate over the previous number, and find count for same number number. Append that count before number. 
	
	You're given number n and your task is to return nth look-and-say sequence.

	Wiki:

	In mathematics, the look-and-say sequence is the sequence of integers beginning as follows:

	1, 11, 21, 1211, 111221, 312211, 13112221, 1113213211, ... (sequence A005150 in OEIS).
	To generate a member of the sequence from the previous member, read off the digits of the previous member, 
	counting the number of digits in groups of the same digit. For example:

	1 is read off as "one 1" or 11.
	11 is read off as "two 1s" or 21.
	21 is read off as "one 2, then one 1" or 1211.
	1211 is read off as "one 1, then one 2, then two 1s" or 111221.
	111221 is read off as "three 1s, then two 2s, then one 1" or 312211.

Source: http://blog.lckymn.com/2012/09/09/look-and-say-sequence/

*/

package lookAndSaySequence;

import java.util.Scanner;

public class UsingRunLengthEncoding {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the number from 0 to n, which would give you the look-and-say sequence");
		int n = in.nextInt();
		String input = "1";
		String pattern = "";
		for (int i = 0; i < n; i++)
        {
            pattern = giveLookAndSaySequence(input);
            input = pattern;
        }
        System.out.println(pattern);
	}
	finally{
		in.close();
	}
}


private static String giveLookAndSaySequence(String s) {
	if(s==null || s.isEmpty())
		return "";
	StringBuilder sb = new StringBuilder();
	int index = 0;
	int firstCharacterIndex = 0;
	while(index<s.length()){
		if(s.charAt(firstCharacterIndex)!=s.charAt(index)){
			sb.append(s.substring(firstCharacterIndex, index).length()).append(s.charAt(firstCharacterIndex));
			firstCharacterIndex = index;
			}
		index++;
		}
	sb.append(s.substring(firstCharacterIndex, s.length()).length()).append(s.charAt(firstCharacterIndex));
	return sb.toString();	
	}
}
/*
Analysis:
	Time Complexity= O(n*m) where n is the length of the pattern string and m is the integer number entered
	Space Complexity = O(n*m) where m is the length of encoded string returned and n is the number of times such
	string pattern is returned
*/
