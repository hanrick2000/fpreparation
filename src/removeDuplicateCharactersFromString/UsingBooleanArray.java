package removeDuplicateCharactersFromString;

import java.util.Scanner;

public class UsingBooleanArray {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	System.out.println("Enter the string");
	String s = in.nextLine();
	System.out.println(removeDuplicates(s));
	}
	finally{
		in.close();
	}
}
public static String removeDuplicates(String s){
	boolean[] asciiTable = new boolean[256];
	StringBuilder sb = new StringBuilder();
	for(char c: s.toCharArray()){
		if(!asciiTable[c]){
			asciiTable[c]=true;
			sb.append(c);
		}
	}
	return sb.toString();
}
}
/*
Analysis:
	Time Complexity: O(n)
	Space Complexity: O(n)*/