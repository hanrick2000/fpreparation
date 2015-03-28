/*
Question: Print all the permutaion of a given string. 

1) explain time\space complexity? 

2) how can you improve time\space complexity?

Question and Answer Source: http://www.careercup.com/question?id=15317787
http://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/
http://www.geeksforgeeks.org/print-all-permutations-with-repetition-of-characters/

Algorithm:
A permutation, also called an “arrangement number” or “order,” is a rearrangement of the elements of 
an ordered list S into a one-to-one correspondence with S itself. A string of length n has n! permutation.

Below are the permutations of string ABC.
ABC, ACB, BAC, BCA, CAB, CBA

Here is a solution using backtracking.
*/
package PermutationIANDPermutationII;

import java.util.ArrayList;
import java.util.Scanner;


public class UsingBacktracking {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to print the PERMUTATIONS of a given STRING");
			System.out.println("Enter the string");
			String s = in.nextLine();
			System.out.println("Using BackTracking WITHOUT handling REPEATED characters:");
			ArrayList<ArrayList<Character>> res = new ArrayList<ArrayList<Character>>();
			res=permute(s.toCharArray());
			for(ArrayList<Character> l: res)
				System.out.println(l.toString());
			System.out.println("Enter the size of integer array");
			int n = in.nextInt();
			int[] a=new int[n];
			System.out.println("Enter the array elements with repetition");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			ArrayList<ArrayList<Integer>> result = permuteUnique(a);
			for(ArrayList<Integer> i: result)
				System.out.println(i.toString());
		}
		finally{
			in.close();
		}
	}
	/* Function to print permutations of string
	   This function takes three parameters:
	   1. String
	   2. Starting index of the string
	   3. Ending index of the string. */
	
	public static ArrayList<ArrayList<Character>> permute(char[] c) {
		ArrayList<ArrayList<Character>> result = new ArrayList<ArrayList<Character>>();
		permute(c, 0, c.length-1, result);
		return result;
	}
	 
	private static void permute(char[] s, int start, int end, ArrayList<ArrayList<Character>> list) {
			if(start>=end){
				ArrayList<Character> l = convertToList(s);
				list.add(l);
			}
			else{
				for(int i=start;i<=end;i++){
					swap(s,start,i);
					permute(s,start+1,end,list);
					swap(s,i,start);  // backtrack
				}
			}
		}
	private static ArrayList<Character> convertToList(char[] s) {
		ArrayList<Character> list = new ArrayList<Character>();
		for(char c: s)
			list.add(c);
		return list;
	}

	/* Algorithm Paradigm: Backtracking
	 * Analysis:
	 * Time Complexity = O(n*n!) where n = length of string
	 * Space Complexity = O(n!) where n = length of string
	 */
	private static void swap(char[] s, int from, int to) {
		char temp = s[from];
		s[from] = s[to];
		s[to] = temp;
	}
	
	/*
	 * Is there a better time complexity solution ?
	 * http://www.quora.com/What-is-the-fastest-algorithm-to-find-all-possible-permutations-of-a-string
	 * http://stackoverflow.com/questions/20991167/improving-the-time-complexity-of-all-permutations-of-a-given-string
	 * https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8&client=ubuntu#q=best%20possible%20time%20complexity%20for%20finding%20all%20permutations%20in%20a%20given%20string
	 * 
	 * Ans:
	 * An optimal permutation algorithm has to generate all the possible n! permutation, 
	 * each with n characters. So the best time complexity one can attain would be O(n*n!), 
	 * which is same as the complexity of almost all the permutation algorithms/code you can find online.
	 * 
	 */
	
	
	
	
	
	
	
	
	
	/* 
	 * EXPLANATION:
	 * 
	 * If all characters in the string are distinct there are exactly 
	 * n! permutations that must be stored and computed. The naive answer is 
	 * the optimal one for all choices of strings.

	  I think what you mean is that in the case of repeated letters you can reduce 
	  the complexity to (n \choose \lambda) where \lambda is the frequency count of the letters.
	 * 
	 */
	
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		permuteUnique(num, 0, num.length-1, result);
		return result;
	}
	 
	private static void permuteUnique(int[] num, int start, int end, ArrayList<ArrayList<Integer>> result) {
	 
		if (start >= end) {
			ArrayList<Integer> item = convertArrayToList(num);
			result.add(item);
		}
		else{
			for (int i = start; i <= end; i++) {
				if (isUnique(num, start, i)) {
					swap(num, start, i);
					permuteUnique(num, start + 1, end, result);
					swap(num, start, i);
				}
		    }
		}
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n*n!)
	 * Space Complexity = O(n!)
	 */
	private static ArrayList<Integer> convertArrayToList(int[] num) {
		ArrayList<Integer> item = new ArrayList<Integer>();
		for (int h = 0; h < num.length; h++) {
			item.add(num[h]);
		}
		return item;
	}
	 
	private static boolean isUnique(int[] arr, int start, int end) {
		for (int i = start; i < end; i++) {          // check for every element in the array except LAST ELEMENT
			if (arr[i] == arr[end]) {
				return false;                        // does not have Unique Elements hence return false
			}
		}
		return true;
	}
	 
	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

}
