package find1NonRepeatingCharacter;

/*
 * NOTE: This method is applicable ONLY for 1 NON-repeating character and NOT for n
 *  Non-repeating characters.
*/

import java.util.Scanner;

public class UsingXOR {
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		try{
			System.out.println("Enter the string to be processing for non-repeatig characters");
			String s = in.nextLine();
			System.out.println("The non-repeating character is: "+nonRepeatingCharacters(s));
		}
		finally{
			in.close();
		}
	}

	private static char nonRepeatingCharacters(String s) {
		int xorAll = s.charAt(0);// char(lower datatype) to int(higher datatype) takes place
                                 // automatically in JAVA. Since there won't be an overflow from char to int
		for(int i=1;i<s.length();i++)
			xorAll^=s.charAt(i);
		char c = (char)xorAll;// int(higher datatype) to char(lower datatype) needs
		// explicit mention of "type casting" since int to char can cause overflow, since int being a bigger datatype than char
		return c;
	}
}
/*
Analysis:
	Time Complexity = O(n)
	Space Complexity = O(1)*/