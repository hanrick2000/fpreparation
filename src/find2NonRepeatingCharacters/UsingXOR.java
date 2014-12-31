package find2NonRepeatingCharacters;

/*
 * NOTE: This method is applicable ONLY for 2 NON-repeating characters and NOT for n Non-repeating characters.
*/

import java.util.Scanner;

public class UsingXOR {
public static void main(String[] args) {
	Scanner in= new Scanner(System.in);
	try{
		System.out.println("Enter the string to be processing for non-repeatig characters");
		String s = in.nextLine();
		nonRepeatingCharacters(s);
	}
	finally{
		in.close();
	}
}

private static void nonRepeatingCharacters(String s) {
	int xorAll = s.charAt(0);    // char(lower datatype) to int(higher datatype) takes place
	                             // automatically in JAVA. Since there won't be an overflow from char to int
	int firstNonRepeatingCharacter = 0;
	int secondNonRepeatingCharacter = 0;
	
	for(int i=1;i<s.length();i++)
		xorAll^=s.charAt(i);
	
	int getRightmostSetBit = xorAll & ~(xorAll-1);
	
	for(int i=0;i<s.length();i++){
	if((getRightmostSetBit & s.charAt(i)) >0)
		firstNonRepeatingCharacter^=s.charAt(i);
	else
		secondNonRepeatingCharacter^=s.charAt(i);
	}
	char firstCharacter = (char)firstNonRepeatingCharacter;// int(higher datatype) to char(lower datatype) needs
	// explicit mention of "type casting" since int to char can cause overflow, since int being a bigger datatype than char
	char secondCharacter = (char)secondNonRepeatingCharacter;// int(higher datatype) to char(lower datatype) needs
	// explicit mention of "type casting" since int to char can cause overflow, since int being a bigger datatype than char
	System.out.println("First non-repeating character is: "+firstCharacter);  
	System.out.println("Second non-repeating character is: "+secondCharacter);
}
}
/*
Analysis:
	Time Complexity = O(n)
	Space Complexity = O(1) 
*/