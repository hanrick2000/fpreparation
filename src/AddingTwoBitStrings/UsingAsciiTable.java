
/*
Question:
	Add two bit strings
Source: http://www.geeksforgeeks.org/add-two-bit-strings/

Algorith,: 1. Make the two strings equal in length
		   2. Sum = XOR             // SUM = a ^ b ^ carry
		   3. c = a&b|a&c|b&c;      // CARRY = (PREVIOUS CARRY & a) | (PREVIOUS CARRY & b) | (a & b)
		   where a = bit of string a
		   		 b = bit of string b
		   		 c = carry
*/
package AddingTwoBitStrings;

import java.util.Scanner;

public class UsingAsciiTable {
	public static void main(String[] args) {
		
Scanner in = new Scanner(System.in);
try{
	System.out.println("Enter the two bit strings");
	String s1 = in.nextLine();
	String s2 = in.nextLine();
	System.out.println("The addition of the two strings are: "+addition(s1,s2));
}
finally{
	in.close();
	}
}
private static String addition(String s1, String s2) {
	
	// make the length of the strings equal
	
	if(s1.length()>s2.length())
		s2=makeLengthEqual(s1,s2);
	
	if(s2.length()>s1.length())
		s1=makeLengthEqual(s2,s1);
	
	
	// do the addition
	
	int carry = 0;
	int sum = 0;
	
	int firstNumberBit = 0;
	int secondNumberBit = 0;
	
	String result = new String();
	
	
	for(int i=(s1.length()-1);i>=0;i--){
		firstNumberBit = s1.charAt(i)-'0';
		secondNumberBit = s2.charAt(i)-'0';
		
		sum = firstNumberBit^secondNumberBit^carry;
		result = (char)(sum+'0')+result; // FIRST Convert the sum into a character by appending '0' and then concatenate the two strings
		
		carry = (firstNumberBit & secondNumberBit)|(secondNumberBit & carry)|(firstNumberBit & carry);
		
	}
	
	return result;
	
	}
private static String makeLengthEqual(String big, String small) {
	

		StringBuilder sb = new StringBuilder();
		for(int i=0;i<big.length()-small.length();i++)
			sb.append("0");
		
		char[] smallArray = small.toCharArray();
		for(char c: smallArray)
			sb.append(c);
		return sb.toString();
	
	}
}
/*
Analysis:
Time Complexity = O(n) where n = length of the largest string among the two strings
Space Complexity = O(1)
*/