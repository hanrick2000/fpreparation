
/*
 * 
 * Question: Given a list of strings, return a list of lists of strings that groups all anagrams. 

Ex. given {trees, bike, cars, steer, arcs} 
return { {cars, arcs}, {bike}, {trees, steer} } 

m = # of words 
n = length of longest word 

Source: http://www.careercup.com/question?id=5723872416497664
NOTE:
1. PLEASE READ THROUGH ALL THE "ANSWERS AND THEIR RESPECTIVE COMMENTS" TO UNDERSTAND THE REASON WHY MULTIPLE ANSWERS 
TO THIS QUESTION IS GIVEN
2. PLEASE UNDERSTAND THAT:
	TIME COMPLEXITY(SOLUTION USING HASHMAP) < TIME COMPLEXITY(SOLUTION NOT USING HASHMAP)
3. KEEP IN mind "ALL" the four solutions. LEARN "ALL THE HASH CALCULATION TECHNIQUES ON STRING" (each char value, RLE, XOR)

 */

package anagramGroups;

import java.util.ArrayList;
import java.util.HashMap;
//import java.util.Iterator;
import java.util.Scanner;

public class SolutionUsingHashMap {

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	System.out.println("Enter the number of elements in the array");
	int n = in.nextInt();
	String[] strArray = new String[n];
	for(int i=0;i<n;i++)
		strArray[i] = in.next();
	HashMap<Long,ArrayList<String>> map = new HashMap<Long,ArrayList<String>>();
	for(String s : strArray){
		long hash = calculateHash(s);
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
public static void printHashMap(HashMap<Long, ArrayList<String>> map) {
	for(ArrayList<String> s: map.values()){    // VERY IMP: values() method of HashMap returns a Collection of values in the HashMap
		System.out.println(s);    // print the object of ArrayList by calling the toString method
	}
	
}
public static long calculateHash(String s){
	long hash=1;
	for(int i=0;i<s.length();i++)
		hash*=s.charAt(i);
	return hash;
}
/*public static String myString(ArrayList<String> a){
	StringBuilder sb = new StringBuilder();
	Iterator<String> iter = a.iterator();
	while(iter.hasNext()){
		sb.append(iter.next());
	}
	return sb.toString();
}*/
}

/*Analysis:
	Time Complexity: O(m*n), where m = No of Strings in String Array
							       n = Length of each string
	Space Complexity: O(m*n)
*/