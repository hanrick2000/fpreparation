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