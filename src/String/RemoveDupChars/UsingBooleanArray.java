package String.RemoveDupChars;

import java.util.Scanner;

public class UsingBooleanArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter a string WITH DUPLICATES");
			String s = in.nextLine();
			System.out.println("Using boolean array, the string after removing duplicates is: "+removeDup(s));
		}
		finally{
			in.close();
		}
	}

	private static String removeDup(String s) {
		boolean[] asciiTable = new boolean[256];
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<s.length();i++){
			char c = s.charAt(i);
			if(!asciiTable[(int)c]){
				sb.append(c);
				asciiTable[(int)c]=true;
			}
		}
		return sb.toString();
	}
}
