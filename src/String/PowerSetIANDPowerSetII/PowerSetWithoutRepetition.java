/*
Question: We are given a set of integers with repeated occurences of elements.
For Example, S={1,2,2}. 
We need to print the power set of S ensuring that the repeated elements of the power
set are printed only once. 
For the above S, the power set will be 
{NULL, {1}, {2}, {2}, {1,2}, {1,2}, {2,2}, {1,2,2}}. 
So, as per the question requirements, we need to print 
{NULL, {1}, {2}, {1,2}, {2,2}, {1,2,2}}

Question Source: http://www.careercup.com/question?id=6189585818189824
Answer Source:
http://shanjiaxin.blogspot.com/2014/02/subsets-ii-leetcode.html
http://www.programcreek.com/2013/01/leetcode-subsets-ii-java/
https://www.google.com/webhp?sourceid=chrome-instant&ion=1&espv=2&ie=UTF-8&client=ubuntu#q=subset%20ii%20leetcode

---------------------------------------------------------------------------------------
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
-------------------------------------------------------------------------------------
*/
package String.PowerSetIANDPowerSetII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class PowerSetWithoutRepetition {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program which prints the power set of a set which contains REPEATED elements BUT does not "
					+ "repeat repetitions in the powerset");
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			int[] a= new int[n];
			System.out.println("Enter the integers with duplicates");
			for(int i=0;i<n;i++)
				a[i] = in.nextInt();
			
			// ITERATIVE SOLUTION
			System.out.println("Iterative Solution: ");
			ArrayList<ArrayList<Integer>> itrerativePSet=iterativeSubsetsWithDup(a);
			Iterator<ArrayList<Integer>> itr1 = itrerativePSet.iterator();
			while(itr1.hasNext())
				System.out.println(itr1.next());
			System.out.println();
			
			// RECURSIVE SOLUTION
			System.out.println();
			System.out.println("Recursive Solution: ");
			ArrayList<ArrayList<Integer>> recursivePSet=iterativeSubsetsWithDup(a);
			Iterator<ArrayList<Integer>> itr2 = recursivePSet.iterator();
			while(itr2.hasNext())
				System.out.println(itr2.next());
			
		}
		finally{
			in.close();
		}
	}
	
	
	
	// ------------------------  ITERATIVE SOLUTION  --------------------------------
	public static ArrayList<ArrayList<Integer>> iterativeSubsetsWithDup(int[] num) {
		if (num == null)
			return null;
	 
		Arrays.sort(num);                                                            // 1.
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();  // 2.
		ArrayList<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();    // 3.
	 
		for (int i = 0; i <num.length; i++) {           // VERY IMP: Go from LEFT to RIGHT
	 
			/*
			 * if (i == num.length - 1 || num[i] != num[i + 1])
			 * conditions are only applied for 1st and 3rd case
			 */
			
			// 1. add all result sets to prev only if current element is different with previous
			if (i == num.length - 1 || num[i] != num[i + 1] || prev.size() == 0) {
				
				prev = new ArrayList<ArrayList<Integer>>();                          // initialize prev
				for (ArrayList<Integer> temp : result)
					prev.add(new ArrayList<Integer>(temp));
			}
	 
			// 2. add each single number to each of the previous sets 
			for (ArrayList<Integer> temp : prev) {
				temp.add(num[i]);                                                 
			}
	 
			// 3. add each single number as a single set, only if current element is different with previous
			if (i == num.length - 1 || num[i] != num[i + 1]) {     // This is the reason why we sort the input array (Arrays.sort(num))
				ArrayList<Integer> temp = new ArrayList<Integer>();
				temp.add(num[i]);
				prev.add(temp);
			}
	 
			// 4. add all prev sets to result
			for (ArrayList<Integer> temp : prev) {
				result.add(new ArrayList<Integer>(temp));
			}
		}
	 
		//add empty set
		result.add(new ArrayList<Integer>());       // add the EMPTY SET
	 
		return result;
	}
	
	
	
	// ----------------------   RECURSIVE SOLUTION  ----------------------------------
	public static ArrayList<ArrayList<Integer>> recursiveSubsetsWithDup (int[] num) {
		
		Arrays.sort(num);
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> list = new ArrayList<Integer>();
 
		subsetsWithDupHelper(result, list, num, 0);
 
		return result;
	}
 
 
	private static void subsetsWithDupHelper(ArrayList<ArrayList<Integer>> result,
			ArrayList<Integer> list, int[] num, int position) {
		
		result.add(new ArrayList<Integer>(list));
 
		for (int i = position; i < num.length; i++) {
			if (i != position && num[i] == num[i-1]){
				continue;
			}
			
			list.add(num[i]);
			subsetsWithDupHelper(result, list, num, i+1);
			list.remove(list.size() - 1);
		}
	}
}
/*
Analysis:
Time Complexity = O(2^n * length of each string)
Space Complexity = O(2^n * length of each string) where n = number of unique characters in the string
*/
