package Regex.DictionaryStar;

import java.util.HashMap;
import java.util.Scanner;

/*
Question: WAP that answers YES/NO search queries containing * placeholders.
Example: if the data you have is (nikhil, katre, prakash, jayashri)
Then you should answer as follows for:
	nikhil:YES
	ka*re:YES
	pra**sh:YES
	**ri:NO
	jayash**:YES
	********:YES

	
NOTE WITH THIS PROGRAM: The interviewer said that your program 
should be able to answer each search query in O(1)

Question and Answer Source: http://www.careercup.com/question?id=5669407776833536
*/



public class UsingRecursion{

/*
Solution Approach: Since given that each query should be answered in O(1) time
Hence we need to create a HashMap for the data given to us
*/

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of strings forming the dictionary data");
			int n = in.nextInt();
			String[] dictionary = new String[n];
			System.out.println("Enter the strings");
			for(int i=0;i<n;i++)
				dictionary[i]=in.next();
			HashMap<String,Boolean> map = new HashMap<String,Boolean>();
			hasDictionaryWithStar(map,dictionary);
			System.out.println("How many queried do you want to run? ");
			int m = in.nextInt();
			String[] queries = new String[m];
			System.out.println("Enter your queries");
			for(int i=0;i<m;i++)
				queries[i]=in.next();
			printQueryResults(map,queries);
		}
		finally{
			in.close();
		}
	}

	private static void printQueryResults(HashMap<String, Boolean> map,	String[] queries) {
		
		// Extreme Case
		if(map==null||queries==null||queries.length==0)
			return;
		
		for(int i=0;i<queries.length;i++){
			if(map.containsKey(queries[i]))
				System.out.println(map.get(queries[i]));
			else
				System.out.println("false");
		}
	}

	private static void hasDictionaryWithStar(HashMap<String, Boolean> map,	String[] dictionary) {
		
		// Extreme Case
		if(dictionary==null||dictionary.length==0)
			return;
		
		for(int i=0;i<dictionary.length;i++){
			populateHashMap(map,dictionary[i],"",0);
		}
	}

	private static void populateHashMap(HashMap<String, Boolean> map, String orig, String edited, int curCharIndex) {
		if(curCharIndex>=orig.length()){
			map.put(edited,true);
			return;
		}
		populateHashMap(map, orig, edited+orig.charAt(curCharIndex), curCharIndex+1);
		populateHashMap(map, orig, edited+"*", curCharIndex+1);
	}
}
/*
 * Analysis:
 * I. TIME COMPLEXITY
 * 1. O(n*2^n) time required to form 2^n possible strings where n = average length of each string
 * We have m strings in the dictionary therefore O(m*n*2^n) where
 * m = number of strings in the dictionary
 * n = average length of each string in the dictionary
 * 2. O(1) time required to search each query  <-- AS REQUIRED IN THE QUESTION TO SEARCH EACH QUERY IN O(1) TIME
 * Thus, overall the time complexity = O(m*n*2^n)
 * II. SPACE COMPLEXITY
 * (2^n) possible string where n = average length of each string
 * We have m strings in the dictionary therefore O(m*2^n) overall space complexity where
 * m = number of strings in the dictionary
 * n = average length of each string in the dictionary
 */
