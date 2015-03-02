package AnagramAndPalindromeProblems.PalindromeQuestions;


import java.util.Scanner;

public class FindNonPalindromeIndex {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	String str = in.nextLine();
	System.out.println(NonPalindromeIndex(str));
	}
	finally{
		in.close();
	}
}
public static int NonPalindromeIndex(String s){
	int start =0;
	int end = s.length()-1;
	while(start<end){
		if(s.charAt(start)==s.charAt(end)){
			start++;
			end--;
			continue;
		}
		if(isPalindrome(s.substring(start, end)))
			return end;
		if(isPalindrome(s.substring(start+1, end+1)))
			return start;
	}
	return -1;
}
public static boolean isPalindrome(String s){
	if(s.length()==0||s.length()==1)
		return true;
	if(s.charAt(0)==s.charAt(s.length()-1))
		return isPalindrome(s.substring(1, s.length()-1));
	return false;
}	

}
/* Analysis:
 * Time Complexity : O(n)
 * Space Complexity : O(1)
 */

/* HackerRank Solution for Q: https://www.hackerrank.com/challenges/palindrome-index/submissions/code/10639865
 * import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
public static void main(String[] args) {
	@SuppressWarnings("resource")
	Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    for(int i=0;i<n;i++){
	String str = in.nextLine();
	System.out.println(NonPalindromeIndex(str));
    }
}
public static int NonPalindromeIndex(String s){
	int start =0;
	int end = s.length()-1;
	while(start<end){
		if(s.charAt(start)==s.charAt(end)){
			start++;
			end--;
			continue;
		}
		if(isPalindrome(s.substring(start, end)))
			return end;
		if(isPalindrome(s.substring(start+1, end+1)))
			return start;
	}
	return -1;
}
public static boolean isPalindrome(String s){
	if(s.length()==0||s.length()==1)
		return true;
	if(s.charAt(0)==s.charAt(s.length()-1))
		return isPalindrome(s.substring(1, s.length()-1));
	return false;
}	

}
 * 
 */

