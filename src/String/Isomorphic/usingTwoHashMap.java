/*
 * Question:
	
	Given Two (dictionary) words as Strings, Determine if THEY are Isomorphic. 

	Two words are Called Isomorphic if the Letters in one Word CAN be remapped to get the Second Word. 

	Remapping a Letter means Replacing All occurrences of it while with the Ordering Another Letter,
	of the Letters Remains Unchanged 

	No Map Two Letters to the Same Letter May, BUT a Letter May Map to Itself. 

	 Example: 

	Given "foo", "app"; Returns true WE CAN Map f -> a and o> P 
	Given "bar", "foo"; returns false we can not map both 'a' and 'r' to 'o'
	given "ab", "ca"; returns true we can map 'a' -> 'b' and 'c' -> 'a'

	The most direct way is to see the correspondence between the two HashMap maintain live characters, O (n)
	

Question and Answer Source: http://blog.csdn.net/fightforyourdream/article/details/17311575
http://www.fgdsb.com/2015/01/14/isomorphic-string/
	*/
package String.Isomorphic;

import java.util.HashMap;
import java.util.Scanner;

public class usingTwoHashMap {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the first string");
			String s = in.next();
			System.out.println("Enter the second string");
			String t = in.next();
			if(check(s,t))
				System.out.println("Isomorphic");
			else
				System.out.println("Not Isomorphic");
		}
		finally{
			in.close();
		}
	}
	public static boolean check(String s,String t){
		
		if(s.length()!=t.length()) 
			return false;
		
		HashMap<Character,Character> map1=new HashMap<Character, Character>();
		HashMap<Character,Character> map2=new HashMap<Character, Character>();
		
		for(int i=0;i<s.length();i++){
			
			char c1=s.charAt(i);
			char c2=t.charAt(i);
			
			if(!map1.containsKey(c1))
				map1.put(c1,c2);
			else{
				if(map1.get(c1)!=c2) 
					return false;
			}
			
			if(!map2.containsKey(c2))
				map2.put(c2, c1);
			else{
				if(map2.get(c2)!=c1) 
					return false;
			}
			
		}
		return true;
	}
}
/*
Analysis:
Time Complexity = O(n) where n = length of one of the string (if both string are equal in length)
Space Complexity = O(2n) where n = length of each string (if both string are equal in length)
*/