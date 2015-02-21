package WordBreak;

import java.util.HashSet;

public class UsingDynamicProgramming {
	public static void main(String[] args) {
		String[] array = {"world","hello","super","hell"};
		System.out.println(usingDP("helloworld", array));
	
	}

	private static boolean usingDP(String search, String[] array) {
		
		HashSet<String> dictionary=createHashSetDictionary(array);
			
		// Create a boolean array of s.length()+1
		boolean[] locations = new boolean[search.length()+1];
		
		locations[0]=true;   // IF AN EMPTY SEARCH STRING IS PRESENT THEN RETURN TRUE
		
		for(int i=0;i<search.length();i++){
			for(int j = i;j>=0;j--){                 // Please remember (j>=0) condition
				// Create substrings and check for existence in dictionary
				String substring = search.substring(j, i+1); //(i+1) because i should be included in substring
				if(dictionary.contains(substring)){
					if(locations[j]==true)      // Here we deal with "j" index
						locations[i+1]=true;   // Here we deal with "i" index
				}
			}// end of inner for
		} // end of outer for
		return locations[search.length()];    // last location in boolean array of length=s.length()+1
		
	}

	private static HashSet<String> createHashSetDictionary(String[] array) {
		HashSet<String> dictionary = new HashSet<String>();
		for(String s : array)
			dictionary.add(s);
		return dictionary;
	}
}
/*
Analysis:
	Time complexity of predefined methods:
		substring = O(n)
		contains = O(1) or if all the strings entered are same then their hash values are same and hence in worst 
		case it is O(n) if all strings are same
	
	Time Complexity = O(n^3) where n = length of search string
	Space Complexity = O(n*m)
	where n = length of each string in the dictionary
		  m = number of strings in the dictionary
*/