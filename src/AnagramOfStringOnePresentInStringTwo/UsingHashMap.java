package AnagramOfStringOnePresentInStringTwo;

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
Space Complexity =O(n+m) where n = length of largest string, m = length of smallest string
*/