/*Question: You're given a dictionary of strings, and a key. Check if the key is composed of an 
		  arbitrary number of concatenations of strings from the dictionary. 

For example: 

dictionary: "world", "hello", "super", "hell" 
key: "helloworld" --> return true 
key: "superman" --> return false 
key: "hellohello" --> return true
Source: http://www.careercup.com/question?id=5705581721550848
*/
package WordBreak;


public class UsingRecursion {
	public static void main(String[] args) {
		String[] array = {"world","hello","super","hell"};
		System.out.println(usingRecursion("helloworld", array));
	
	}
	private static boolean usingRecursion(String search, String[] dict) {
		
		if(search.length()==0)
			return true;
		
		// Try all prefixes of lengths from 1 to (string.length()+1)
		for(int i=1;i<(search.length()+1);i++)
			if(dictContains(dict,search.substring(0, i)) && 
				usingRecursion(search.substring(i, search.length()), dict))
				return true;
			
		// If we have tried all prefixes and none of them worked
		return false;
		
	}
	// We can either use this dictContains method OR we can use HashSet which gives O(1) search, but HashSet
	// requires where O(n*m) space where
	//  n = length of each dictionary string
	//  m = number of strings in the dictionary
	// This search method has O(m) search time where m = number of strings in the dictionary 
	private static boolean dictContains(String[] dict, String substring) {
		
		for(String s: dict){
			if(s.equals(substring))
				return true;
		}
		return false;
	}
	
}
/*
Analysis:
	Time Complexity = 
	Space Complexity = 
*/