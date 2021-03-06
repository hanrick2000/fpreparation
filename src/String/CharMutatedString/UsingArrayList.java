/*
Question: Facebook Interview Question for Software Engineer / Developers
facebook-interview-questions5
		OR
 Implement a suggestion function that generates alternative  
 strings for given password strings like "facebook" => "F@ceß00k" and "fæc€Bo0K" or sth. 
 
Answers
Given a hashmap M which is a mapping of characters to arrays of substitute characters,
and an input string S, return an array of all possible mutations of S 
		(where any character in S can be substituted with one of its substitutes in M, if it exists). 

What is the time complexity? What is the space complexity? Can you optimize either?

Example input:
	M = { f: [F, 4], b: [B, 8] }
	S = fab

Expected output:
	[fab, Fab, 4ab, faB, FaB, 4aB, fa8, Fa8, 4a8]
	

Question Source: http://www.careercup.com/question?id=15419952
Answer Source: http://www.mitbbssg.com/article_t/Recommend/31379437.html 
*/
package String.CharMutatedString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class UsingArrayList {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			HashMap<Character,char[]> M = new HashMap<Character,char[]>();
			char[] c1= new char[2];
			c1[0]='@';
			c1[1]='4';
			char[] c2=new char[2];
			c2[0]='O';
			c2[1]='0';
			M.put('a', c1);
			M.put('o', c2);
			System.out.println("Enter the string to be mutated");
			String S = in.nextLine();
			System.out.println("The possible mutations are: "+getMutation(S,M).toString());
		}
		finally{
			in.close();
		}
	}

	
	
	
	
	private static ArrayList<String> getMutation(String str, HashMap<Character, char[]> map) {
		 
		    // Declare a ArrayList of String to store mutated strings
		    ArrayList<String> result = new ArrayList<String>();

            // If the string is null or length of string is 0 
	        if(str.length() == 0 || str==null){
	            return result;
	        }
	        
	        // If there are NO MUTATIONS
	        if(map.isEmpty()){
	            result.add(str);     // if no mapping then the original string would be returned
	            return result;
	        }
	        
	        // Check whether Mutation is present for ALL CHARACTERS of the string. Hence mutation array is of string.length()
	        char[] mutation = new char[str.length()];
	        getMutation(str, map, result, mutation, 0);
	        
	        return result;  // return the ArrayList
	    }
	
		public static void getMutation(String str, HashMap<Character, char[]> map, ArrayList<String> result, char[] mutation, int index){
			
			// BASE CASE
	    	if(index == str.length()){                    // NOTE: index is compared with string.length() AND NOT (string.length()-1)                                
	            String newItem = new String(mutation);
	            result.add(newItem);
	        }
	    	// RECURSIVE CASE
	        char current = str.charAt(index);              // get the current char of the string 
	        if(map.containsKey(current)){                                        // if the char mutation is present in HashMap
	        	char[] choice = map.get(current); 
	            for(int i = 0; i <= choice.length;i++){
	                if(i == 0){                                                  // 0th mutation is keeping the character itself      
	                    mutation[index] = current;
	                    getMutation(str, map,result, mutation, index+1);
	                }
	                else{
	                    mutation[index] = choice[i-1];
	                    getMutation(str, map, result, mutation, index+1);
	                }  
	            }
	        }
	        else{                                                                // else if the mutation is NOT PRESENT in HashMap then append the char and continue to next index
	            mutation[index] = current;
	            getMutation(str, map, result, mutation, index+1);
	        }
	    }
}
/*
Analysis:
Time Complexity = O(n*m) 
where n = length of string and 
m = highest length of choice array for a character
Space Complexity = Approximately close to O(n*m)
where n = length of string and 
m = highest length of choice array for a character
*/




/*
Another possible solution

USING TRIE
Source: http://www.careercup.com/question?id=15419952


There is also a tricky solution with very good time and space complexities. We do not have any 
restrictions about output format of resultant word set, so it will be absolutely legal to output 
them as a trie. The main idea of algorithm is following: 
Given a source string and map of substitutions, let's construct a trie with a single word - source string:



(start)
       |
      (f)
       |
       |
      (a)
       |
       |
      (b)
       |
     (end)
Now, lets iterate over trie nodes. If we see a node with a character that presents in a map, 
let's transform this node to a cuple of nodes with all possible substitutions for that character, i.e.


|           / | \
 (f) ->  (f)(F)(4) 
  |        \ | /
Applying this procedure to all nodes, we will get a trie with all possible substitutions, like


(start)
        / | \
     (f)(F)(4)
        \ | /
          |
         (a)
          |
        / | \
    (b)(B)(8)
      /   |   \
   (end)(end)(end)
So that, in worst case, time and space complexity is O(n*k), where n is length of the string and 
k is length of longest array in the map of substitutions.
*/