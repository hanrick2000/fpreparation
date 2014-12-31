package find2NonRepeatingCharacters;

/*
 * NOTE: This method is applicable for not just 2 NON-repeating characters but for n Non-repeating characters.
*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UsingHashMap {
	public static void main(String[] args) {
		Scanner in= new Scanner(System.in);
		try{
			System.out.println("Enter the string to be processing for non-repeatig characters");
			String s = in.nextLine();
			nonRepeatingCharacters(s);
		}
		finally{
			in.close();
		}
	}

	private static void nonRepeatingCharacters(String s) {
		HashMap<Character, Integer> hash = new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++){
			if(!hash.containsKey(s.charAt(i))){
				hash.put(s.charAt(i), 1);
			}
			else{
				int count = hash.get(s.charAt(i));
				count++;
				hash.put(s.charAt(i), count);
			}
		}
		
		Set<Map.Entry<Character,Integer>> set = hash.entrySet();
		Iterator<Map.Entry<Character,Integer>> iter = set.iterator();
		while(iter.hasNext()){
			Map.Entry<Character, Integer> element = iter.next();
			if(element.getValue()==1){
				char c = element.getKey();
				System.out.println("Non-repeating character is: "+c);
			}
		}
	}
}
/*
Analysis:
	Time Complexity = O(n)
	Space Complexity = O(n)
*/