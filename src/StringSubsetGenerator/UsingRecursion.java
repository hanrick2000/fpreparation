/*
Question: Prints all unique subsets of the string. 
Given a string write a function which prints all the 
subsets of the string. Now make the function to return only unique solutions.

Question Source: http://www.careercup.com/question?id=4859932243394560


Algorithm:
1) first remove duplicates from the string 
2) Use recursion and inside each call the same function, 
one using the character at that position and other without it.


NOTE: The total number of possible solution is 2^n where n = unique characters in the String


NOTE:  The differences between subsets and substrings are two:
    1. substrings may have repeat characters
    2. substrings are ordered ("rm" != "mr")

    Ex. For the subsets of the string "rum" there are eight: "r", "ru", "rum", "u", "um", "m", "rm", "".
    For the substrings of the string "rum" there are seven: "r", "ru", "rum", "u", "um", "m", ""
*
*/


package StringSubsetGenerator;

import java.util.ArrayList;
import java.util.Arrays;

public class UsingRecursion {

	    public static void main(String[] args) {
	        ArrayList<String> list = new ArrayList<String>();
	        StringBuilder myBuilder = new StringBuilder();
	        String original = "Worlllllld";
	        
	        original=removeDuplicates(original);


	        for(int i=0; i<original.length(); ++i)
	            genSubs(original, myBuilder, list, i);

	        System.out.println(list.toString());
	        System.out.println("Total unique substrings: "+list.size());


	    }

	private static String removeDuplicates(String original) {
			char[] array = original.toCharArray();
			Arrays.sort(array);
			StringBuilder sb = new StringBuilder();
			sb.append(array[0]);
			for(int i=1;i<original.length();i++)
				if(array[i]!=array[i-1])
					sb.append(array[i]);
			return sb.toString();
		}

	static void genSubs(String original, StringBuilder current, ArrayList<String> myList, int index){

	    current.append(original.charAt(index));

	    //System.out.println(current.toString());

	    myList.add(current.toString());


	    for(int i=index+1; i<original.length(); ++i)
	        genSubs(original, current, myList, i);

	    current.deleteCharAt(current.toString().length()-1);


	    return;
	}

	}
/*
Analysis:
Time Complexity = 
Space Complexity = O(2^n) where n = number of unique characters in the string
*/