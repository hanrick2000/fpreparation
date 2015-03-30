/*
 * Question:
Code a function that receives a string composed by words separated by spaces and returns
 a string where words appear in the same order but than the original string, but every word is inverted. 
Example, for this input string
 * 
 * Question Source: http://www.careercup.com/question?id=5106757177180160
 * 
 * Answer Source: Same Folder, the other file named: ReverseWordsInSentence.java
 * 
 */


package ReverseWordsInSentenseInConstantMemory;

import java.util.Scanner;

public class InvertWords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the sentence whose words needs to be reversed");
			char[] s = in.nextLine().toCharArray();
			s=reverseSentence(s);
			System.out.println(String.valueOf(s));
			
		}finally{
			in.close();
		}
	}
	/*  Preconditions of the input string given in the question:
	1) no double spaces 
	2) no empty words 
	3) no spaces at the ends of a sentence
	*/
	public static void reverseWord(char[] s,int start, int end){
		for(;start<end;start++,end--){
			// Swap start and end characters In Place
		    s[start] = (char)(s[start]^s[end]);
		    s[end] = (char)(s[start]^s[end]);
		    s[start] = (char)(s[start]^s[end]);
		}
	}
	public static char[] reverseSentence(char[] s){ // VERY IMP: char array
		int start = 0;
		int end = 0;
		for(int i=0;i<s.length;i++){

			if(s[i]==' '){  // either when we get empty space
				end=i-1;
				reverseWord(s, start, end);
				start=i+1;
			}
			if(i==(s.length-1)){  // If we reach the end of the string
				end=i;
				reverseWord(s, start, end);
			}
		}
		return s;
		}
	}
	/*
	 * Analysis:
	 *       Time Complexity = O(n) where n = length of the string
	 *       Space Complexity = O(1)
	 */

