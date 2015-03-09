package WordBreak;

import java.util.HashSet;

public class UsingDynamicProgramming {
	public static void main(String[] args) {
		String[] array = {"world","hello","super","hell"};
		HashSet<String> dict = createHashSetDictionary(array);
		System.out.println(usingDP("helloworld", dict));
	
	}

	private static boolean usingDP(String search, HashSet<String> dict) {

		boolean[] locations = new boolean[search.length()+1];
		
		locations[0]=true; //set first to be true, why? , Answer. Because we need initial state
		
		for(int i=0;i<search.length();i++){
			
			for(int j = i;j>=0;j--){     
				
				String substring = search.substring(j, i+1); //(i+1) because i should be included in substring
				
				if(dict.contains(substring))
					if(locations[j]==true)      // Here we deal with "j" index
						locations[i+1]=true;   // Here we deal with "i" index

			} // end of inner for
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
	
Time Complexity= O(n^3) if substring is taken to be O(n) operation
*/