package LetterCombinationsOfAPhoneNumber;


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
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        LinkedList<String> list = new LinkedList<>();
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '2';
            int size = list.size();
            for (int k = 0; k < size; k++) {
                String tmp = list.pop();
                for (int j = 0; j < letters[num].length(); j++)
                    list.add(tmp + letters[num].charAt(j));
            }
        }
        List<String> rec = new LinkedList<>();
        rec.addAll(list);
        return rec;
    }
    
}
