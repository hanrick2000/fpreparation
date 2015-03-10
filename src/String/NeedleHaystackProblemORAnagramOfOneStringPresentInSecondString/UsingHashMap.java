

/*
 * Question: bool anaStrStr (string needle, string haystack) 
{
}
Write a function that takes 2 strings , search returns true if any anagram of string1(needle)
is present in string2(haystack)

For Example: cat, actor -> T
car, actor -> F

Source: http://www.careercup.com/question?id=5671785349513216

Algorithm: 
The below solution is an O(n) time and O(n) space algorithm, although I assumed that the 2 strings can contain 
any character (that is, the primitive type char in Java - 16-bit Unicode characters). We could conclude that it
 is O(1) space also, because char can only have 65535 different values, therefore the Map's size is limited 
 (has an upper bound). 

1. We first build a map that contains the needle's characters and their number of occurences. 
2. At this point we assume that the difference between the needle and the haystack is the length of
 the needle, since we haven't read yet anything from the haystack. 
3. We also create a map for the haystack (similar to that of the needle's map, but we will fill it
 up along the way, it is empty first). 
4. Then we iterate over the haystack and at every character we update the map of the haystack by looking 
at the last n characters of the haystack (where n is the length of the needle). We can actually do this in 
constant steps because we just remove an occurence of the character at the current-n position from the 
haystack's map and add an occurence at the newly read position. Meanwhile, we keep track of the difference 
between the needle and the current haystack "window". If at any point this difference is 0, then we return 
true (the current part of the haystack is an anagram with the needle). Otherwise, if we reach the end of the 
haystack without finding an anagram of the needle, then we return false. 

It runs in O(n) time because we iterate over the haystack only once and at every step we do constant operations.
 * 
 */

package String.NeedleHaystackProblemORAnagramOfOneStringPresentInSecondString;

import java.util.HashMap;
import java.util.Map;

public class UsingHashMap {
public static void main(String[] args) {
	System.out.println(anaStrStr("hello","worldelloh"));
}
	
	public static boolean anaStrStr(String needle, String haystack) {
		if (haystack == null || haystack.length() == 0 || needle == null)
			return false;
		else if (needle.length() == 0)
			return true;
		Map<Character, Integer> needleMap = new HashMap<Character, Integer>();
		for (int i = 0; i < needle.length(); i++) {
			inc(needleMap, needle.charAt(i));
		}
		int diffChars = needleMap.keySet().size();
		char[] h = haystack.toCharArray();
		Map<Character, Integer> haystackMap = new HashMap<Character, Integer>();
		for (int i = 0; i < haystack.length(); i++) {
			if (i >= needle.length()) {
				diffChars += diff(haystackMap, needleMap, h[i - needle.length()], false);
			}
			diffChars += diff(haystackMap, needleMap, h[i], true);
			if (diffChars == 0)
				return true;
		}
		return false;
	}

	private static int diff(Map<Character, Integer> map1, Map<Character, Integer> map2, char key, boolean inc) {
		int value = getValue(map1, key);
		int value2 = getValue(map2, key);
		if (inc)
			inc(map1, key);
		else
			dec(map1, key);
		int valueMod = getValue(map1, key);
		if (value != value2 && valueMod == value2)
			return -1;
		if (value == value2 && valueMod != value2)
			return 1;
		return 0;
	}

	private static int getValue(Map<Character, Integer> map, char key) {
		return map.get(key) == null ? 0 : map.get(key);
	}

	private static void inc(Map<Character, Integer> map, char key) {
		if (!map.containsKey(key))
			map.put(key, 1);
		else
			map.put(key, map.get(key) + 1);
	}

	private static void dec(Map<Character, Integer> map, char key) {
		if (!map.containsKey(key))
			return;
		else if (map.get(key) == 1)
			map.remove(key);
		else
			map.put(key, map.get(key) - 1);
	}
}
/*
Analysis:
Time Complexity = O(n) where n = length of the largest string
Space Complexity =O(n) where n = length of largest string
*/