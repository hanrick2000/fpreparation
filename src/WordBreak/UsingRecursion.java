/*Question: You're given a dictionary of strings, and a key. Check if the key is composed of an 
		  arbitrary number of concatenations of strings from the dictionary. 

For example: 

dictionary: "world", "hello", "super", "hell" 
key: "helloworld" --> return true 
key: "superman" --> return false 
key: "hellohello" --> return true

Question and Answer Source: http://www.careercup.com/question?id=5705581721550848
http://www.geeksforgeeks.org/dynamic-programming-set-32-word-break-problem/
*/
package WordBreak;

import java.util.HashSet;


public class UsingRecursion {
	public static void main(String[] args) {
		String[] array = {"world","hello","super","hell"};
		HashSet<String> dict = createHashSetDictionary(array);
		System.out.println(usingRecursion("helloworld", dict));
	
	}
	private static boolean usingRecursion(String search, HashSet<String> dict) {
		
		if(search.length()==0)
			return true;
		
		// Try all prefixes of lengths from 1 to (string.length()+1)
		for(int i=1;i<(search.length()+1);i++)
			if(dict.contains(search.substring(0, i)) && 
				usingRecursion(search.substring(i, search.length()), dict))
				return true;
			
		// If we have tried all prefixes and none of them workedJennifer Lawrence
		return false;
		
	}
	private static HashSet<String> createHashSetDictionary(String[] array) {
		HashSet<String> dictionary = new HashSet<String>();
		for(String s : array)
			dictionary.add(s);
		return dictionary;
	}
	/*
	Analysis: 
		Time Complexity = O()    maybe O(n^3) considering substring is O(n) otherwise O(n^2)
		Space Complexity = O()
	*/
	
	
}
