package removeDuplicateCharactersFromString;

import java.util.HashSet;
import java.util.Scanner;

public class UsingHashSet {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the string");
		String s = in.nextLine();
		System.out.println(removeDupCharacters(s));
	}
	finally{
		in.close();
	}
}

private static String removeDupCharacters(String s) {
	HashSet<Character> set = new HashSet<Character>();
	StringBuilder sb = new StringBuilder();
	for(char c: s.toCharArray()){
		if(!set.contains(c)){
			set.add(c);
			sb.append(c);
		}
	}
	return sb.toString();
}
}
/*Analysis:
	Time Complexity = O(n)
	Space Complexity = O(n), used for HashSet*/