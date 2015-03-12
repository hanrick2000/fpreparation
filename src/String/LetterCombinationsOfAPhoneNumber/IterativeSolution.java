package String.LetterCombinationsOfAPhoneNumber;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IterativeSolution {
	
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
	public static List<String> letterCombinations(String digits) {
		
		if(digits==null||digits.length()==0)
			return null;
		
        String[] alphaKeypad = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> list = new LinkedList<>();
        list.add(""); // VERY IMP: Add an empty string in the list
        for (int i = 0; i < digits.length(); i++) {
        	
        	 // Get the numeric number and size of the list
        	
            int num = digits.charAt(i) - '2'; // -'2' because the digits in the phone number start from 2
            int size = list.size(); // get the size of the list
            
            for (int j = 0; j < size; j++) { // iterate through all the elements of the list
            
            	String s = list.removeFirst();   // VERY IMP: REMOVE THE FIRST ELEMENT OF THE LL.
                
            	for (int k = 0; k < alphaKeypad[num].length(); k++) 
                
            		list.add(s + alphaKeypad[num].charAt(k));
            }
        }
        
        return list;
    }
    
}
/*
Analysis:
Time Complexity
Assuming the average number of letters on every number is m, and the length of digits string is n, 
then the complexity is O(m^n)     [lettersOnNumber^input]
Space Complexity = O(m^n)
where m = average number of letters on every number
	  n = length of digits string
*/