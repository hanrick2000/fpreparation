
/*
 * Question: bool anaStrStr (string needle, string haystack) 
{
}
Write a function that takes 2 strings , search returns true if any anagram of string1(needle)
is present in string2(haystack)

For Example: cat, actor -> T
car, actor -> F

Source: http://www.careercup.com/question?id=5671785349513216

Algorithm: 1. Calculate XOR of s1
		   2. Calculate XOR 0f s2.substring(s1.length)
		   		Check if both XOR value match.
		   		If not get the next substring of s2 and check for XOR value match
 * 
 */



package NeedleHaystackProblemORAnagramOfOneStringPresentInSecondString;

import java.util.Scanner;

public class UsingXOR{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        try{
        	System.out.println("Enter the two strings");
        	String s1=in.nextLine();
        	String s2 = in.nextLine();
        	System.out.println("Anagram of one of the strings is present in the second string: "+checkAnagrams(s1, s2));
        }
        finally{
        	in.close();
        }
    }
    public static boolean checkAnagrams(String s1, String s2){
    	
    	if(s1==null||s2==null||s2.length()==0)
            return false;
        if(s1.length()==0)
        	return true;
    	
    	if(s1.length()>s2.length())
            return checkAnagrams(s2,s1);
            
        int s1XOR = calXOR(s1);
        for(int i=0;i<(s2.length()-s1.length());i++){  // loop runs (n-m) times where n = length of string s2 and m= length of string s1
            String sub=s2.substring(i,s1.length());   // Substring is O(m) time complexity where m is the length of string s1
            int s2XOR = calXOR(sub);                  // calXOR is O(m) time complexity where m is the length of string s1
            if(s1XOR==s2XOR)
                return true;
        }
        return false;
    }
    public static int calXOR(String s){
        int value=(int)s.charAt(0);
        for(int i=1;i<s.length();i++)
            value^=(int)s.charAt(i);
            
        return value;
        
    }
}
/*
Analaysis:
	Time Complexity = O(mn)
	(n-m) checks would be done for each substring of length m
	Space Complexity = O(mn)
	(n-m) substrings would be created where length of each substring is m
*/