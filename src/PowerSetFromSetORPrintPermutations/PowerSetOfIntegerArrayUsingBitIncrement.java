/*
NOTE: POWERSET and PERMUTATION are DIFFERENT things
For Example: input = [1,2,3]
Then Powerset = [null,1,2,3,12,23,13,123]
and Permutation = [123,132,312,321,213,231]

BUT POWERSET and SUBSETS are one and the SAME

1. For Example: input = [1,2,3]     <----- UNIQUE elements
Then Powerset = [[],1,2,3,12,23,13,123]
Then Subsets = [[],1,2,3,12,23,13,123]   

NOTE: This question is know as subsets I question in leetcode

1. For Example: input = [1,2,2]     <----- DUPLICATE elements
Then Powerset = [[],1,2,12,22,122]
Then Subsets = [[],1,2,12,22,122]

NOTE: This question is know as subsets II question in leetcode

VERY IMP SUMMARY:
1. Powerset and subsets ARE SAME
2. Powerset and Permutations ARE DIFFERENT
3. Powerset with UNIQUE input is known as Subsets I question in leetcode
4. Powerset with DUPLICATE input is known as Subsets II question in leetcode
*/
package PowerSetFromSetORPrintPermutations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class PowerSetOfIntegerArrayUsingBitIncrement {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the size of the integer array");
			int n = in.nextInt();
			System.out.println("Enter the elements of the integer array for powerset calculation");
			int[] set = new int[n];
			for(int i=0;i<n;i++)
				 set[i] = in.nextInt();
			printPowerSet(set);
			
			// Using ArrayList
			ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
			list = subsets(set);
			Iterator<ArrayList<Integer>> itr=list.iterator();
			while(itr.hasNext())
				System.out.println(itr.next());
		}
		finally{
			in.close();
		}
	}

	private static void printPowerSet(int[] set) {
		/*
		 * VERY IMP NOTE: If interviewer says that the input set contains duplicates and
		 * that we need to only print powerset elements which are NOT DUPLICATES,
		 * then in this case first call a REMOVE_DUPLICATES method which removes the 
		 * duplicate set elements from the input set and after the removal of duplicates when
		 * we get ALL UNIQUE elements in the set, then at that time we need to call 
		 * this pringPowerSet function with the UniqueElementSet passed as parameter
		 */
		
		for(int i=0;i<(int)Math.pow(2,set.length);i++){
			for(int j=0;j<set.length;j++){ // loop which checks which bit is set in integer i
				if(((i)&(1<<j))!=0) // HandRun this to understand how to check for set bits in an integer
// For each bit of integer i, check which of the bits are set.// HandRun the above statement in if condition, to understand how to check for set bits in an integer
				System.out.print(set[j]);  // If bit is set, then print the corresponding character
			}
			
			System.out.println();
		}
	}
	/*
	Analysis:
		Time Complexity = O(n*2^n)
		Space Complexity = O(1)*/
	public static ArrayList<ArrayList<Integer>> subsets(int[] S) {
		if (S == null)
			return null;
	 
		Arrays.sort(S);  // NOTE: NOT Sorting the input does not change the result. Sorting is only done for the output to look pretty
	 
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
	 
		for (int i = 0; i < S.length; i++) {
			ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>();
	 
			//get sets that are already in result
			for (ArrayList<Integer> a : result) {
				temp.add(new ArrayList<Integer>(a));
			}
	 
			//add S[i] to existing sets
			for (ArrayList<Integer> a : temp) {
				a.add(S[i]);
			}
	 
			//add S[i] only as a set
			ArrayList<Integer> single = new ArrayList<Integer>();
			single.add(S[i]);
			temp.add(single);
	 
			result.addAll(temp);
		}
	 
		//add empty set
		result.add(new ArrayList<Integer>());
	 
		return result;
	}
}
