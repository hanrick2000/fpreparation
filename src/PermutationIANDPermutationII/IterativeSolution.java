package PermutationIANDPermutationII;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class IterativeSolution {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to print the PERMUTATIONS of a given STRING");
			
			System.out.println("Enter the size of integer array");
			int n = in.nextInt();
			int[] a=new int[n];
			System.out.println("Enter the array elements WITHOUT repetition");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			ArrayList<ArrayList<Integer>> result = permute(a);
			for(ArrayList<Integer> i: result)
				System.out.println(i.toString());
			
			System.out.println("Enter the size of integer array");
			int n1 = in.nextInt();
			int[] a1=new int[n1];
			System.out.println("Enter the array elements WITH repetition");
			for(int i=0;i<n1;i++)
				a1[i]=in.nextInt();
			ArrayList<ArrayList<Integer>> result1 = permuteUnique(a1);
			for(ArrayList<Integer> i: result1)
				System.out.println(i.toString());
		}
		finally{
			in.close();
		}
	}
	
	// Source: http://www.programcreek.com/2013/02/leetcode-permutations-java/
	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		
		result.add(new ArrayList<Integer>());         // Add an empty ArrayList
	 
		for (int i = 0; i < num.length; i++) {
			ArrayList<ArrayList<Integer>> current = new ArrayList<ArrayList<Integer>>();
	 
			for (ArrayList<Integer> list : result) {

				for (int j = 0; j < (list.size()+1); j++) {
					// + add num[i] to different locations
					list.add(j, num[i]);
					ArrayList<Integer> temp = new ArrayList<Integer>(list);
					list.remove(j);
					current.add(temp);
				}
			}
	 
			result = new ArrayList<ArrayList<Integer>>(current);                    // VERY IMP: Reinitialize Result
		}
	 
		return result;
	}
	/* Analysis:
		 * Time Complexity = O(n*n!) where n = length of string
		 * Space Complexity = O(n!) where n = length of string
		 */
	
	
	
	
	// Handling repetitions
	// Source: http://www.programcreek.com/2013/02/leetcode-permutations-ii-java/
	
	public static ArrayList<ArrayList<Integer>> permuteUnique(int[] num) {
		
		ArrayList<ArrayList<Integer>> returnList = new ArrayList<ArrayList<Integer>>();
		returnList.add(new ArrayList<Integer>());
	 
		for (int i = 0; i < num.length; i++) {                                        // iterate through input
			Set<ArrayList<Integer>> currentSet = new HashSet<ArrayList<Integer>>();
			for (List<Integer> list : returnList) {                                   // iterate through result element
				for (int j = 0; j < (list.size() + 1); j++) {						  // iterate though each element
					list.add(j, num[i]);
					ArrayList<Integer> T = new ArrayList<Integer>(list);
					list.remove(j);
					currentSet.add(T);
				}
			}
			returnList = new ArrayList<ArrayList<Integer>>(currentSet);        // VERY IMP: Reinitialize Result
		}
	 
		return returnList;
	}
	/* Analysis:
	 * Time Complexity = O(n*n!) where n = length of string
	 * Space Complexity = O(n!) where n = length of string
	 */
}

