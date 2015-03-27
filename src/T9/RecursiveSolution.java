package T9;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class RecursiveSolution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
		    System.out.println("Enter digit of the phone number");
			String s = in.nextLine();
			List<String> result = letterCombinations(s);
			print(result);
		}
		finally{
			in.close();
		}
	}
	private static void print(List<String> result) {
		Iterator<String> iter = result.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next()+" ");
		}
	}
	
	    public static List<String> letterCombinations(String input) {
	    	
	    	if(input==null||input.length()==0)
	    		return null;
	    	
	        String[] alphaKeypad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	        List<String> list = new LinkedList<>();
	        StringBuilder sb = new StringBuilder();
	        letterCombinations(input, 0, alphaKeypad, sb, list);
	        return list;
	    }
	    
	    private static void letterCombinations(String input, int start, String[] alphaKeypad, StringBuilder sb, List<String> list) {
	        if (input.length() == start) {
	        	list.add(sb.toString());
	            return;
	        }
	        String lettersSet = alphaKeypad[input.charAt(start) - '2']; // 0 = "abc"
	        for (int i = 0; i < lettersSet.length(); i++) {
	            sb.append(lettersSet.charAt(i));
	            letterCombinations(input, start + 1, alphaKeypad, sb, list);
	            sb.deleteCharAt(sb.length() - 1);
	        }
	    }
	
}
/*
Analysis:
Time Complexity
Assuming the average number of letters on every number is m, and the length of digits string is n, 
then the complexity is O(m^n)      [lettersOnNumber^input]
Space Complexity = O(m^n)
where m = average number of letters on every number
	  n = length of digits string
*/