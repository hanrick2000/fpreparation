package anagramGroups;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SolutionUsingIntelligentHash {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	System.out.println("Enter the number of elements in the array");
	int n = in.nextInt();
	String[] strArray = new String[n];
	for(int i=0;i<n;i++)
		strArray[i] = in.next();
	HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
	for(String s : strArray){
		String hash = intelligentHashFunction(s);
		if(!map.containsKey(hash))
			map.put(hash, new ArrayList<String>());
		map.get(hash).add(s);
	}
	printHashMap(map);
	}
	finally{
		in.close();
	}
}
	
	// Run Length Encoding HashFunction
	public static String intelligentHashFunction(String s){
		int[] charArray = new int[52];
		for(int i=0;i<s.length();i++){
			charArray[s.charAt(i)-'A']++;
		}
		StringBuilder str = new StringBuilder();
		for(int i=0;i<charArray.length;i++){
			if(charArray[i]!=0){
				str.append((char)(i+'A')).append(charArray[i]);
			}
		}
		return str.toString();
	}
	public static void printHashMap(HashMap<String, ArrayList<String>> map) {
		for(ArrayList<String> s: map.values()){    // VERY IMP: values() method of HashMap returns a Collection of values in the HashMap
			System.out.println(s);    // print the object of ArrayList by calling the toString method
		}
	}
}
/*Analysis:
Time Complexity: O(m*n), where m = No of Strings in String Array
						       n = Length of each string
Space Complexity: O(m*n)
*/