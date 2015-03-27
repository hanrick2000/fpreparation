package AnagramAndPalindromeProblems.AnagramQuestions;

	import java.util.ArrayList;
	import java.util.HashMap;
	import java.util.Scanner;

	public class AnagramGroupsUsingXORHash {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
		System.out.println("Enter the number of elements in the array");
		int n = in.nextInt();
		String[] strArray = new String[n];
		for(int i=0;i<n;i++)
			strArray[i] = in.next();
		anagramGroups(strArray);
		}
		finally{
			in.close();
		}
	}
	public static void anagramGroups(String[] strArray){
		HashMap<Integer,ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();
		for(String s : strArray){
				int hash = calculateXORHash(s);
				if(!map.containsKey(hash))
					map.put(hash, new ArrayList<String>());
				map.get(hash).add(s);
		}
			printHashMap(map);
		}
	public static void printHashMap(HashMap<Integer, ArrayList<String>> map) {
		for(ArrayList<String> s: map.values()){    // VERY IMP: values() method of HashMap returns a Collection of values in the HashMap
			System.out.println(s.toString());    // print the object of ArrayList by calling the toString method
		}
		
	}
	public static int calculateXORHash(String s){
		int xorValue = s.charAt(0);
		for(int i=1;i<s.length();i++)
			xorValue ^=s.charAt(i);
		return xorValue;
	}
	}


	/*Analysis:
		Time Complexity: O(m*n), where m = No of Strings in String Array
								       n = Length of each string
		Space Complexity: O(m*n)
	*/