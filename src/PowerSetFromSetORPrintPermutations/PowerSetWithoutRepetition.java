/*
Question: We are given a set of integers with repeated occurences of elements.
For Example, S={1,2,2}. 
We need to print the power set of S ensuring that the repeated elements of the power
set are printed only once. 
For the above S, the power set will be 
{NULL, {1}, {2}, {2}, {1,2}, {1,2}, {2,2}, {1,2,2}}. 
So, as per the question requirements, we need to print 
{NULL, {1}, {2}, {1,2}, {2,2}, {1,2,2}}

Question And Answer Source: http://www.careercup.com/question?id=6189585818189824
http://fisherlei.blogspot.com/2013/01/leetcode-subsets-ii.html
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

Algorithm:
for each element of input : 
If it is visited for the first time, just add it to all sets that has been added to powerset. 

else check hashmap to find number of this element that has been visited, then add new element to 
set(s) that has exactly this number of duplication.


VERY IMP NOTE: Debug this program to understand it
*/
package PowerSetFromSetORPrintPermutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PowerSetWithoutRepetition {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program which prints the power set of a set which contains REPEATED elements BUT does not "
					+ "repeat repetitions in the powerset");
			System.out.println("Enter the number of elements in the array list");
			int n = in.nextInt();
			System.out.println("Enter the integers with duplicates");
			ArrayList<Integer> list = new ArrayList<Integer>();
			for(int i=0;i<n;i++)
				list.add(in.nextInt());
			powerSet(list);
		}
		finally{
			in.close();
		}
	}

	@SuppressWarnings("unchecked")
	public static void powerSet(ArrayList<Integer> input) {
		
		ArrayList<ArrayList<Integer>> powerSet = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> set = new ArrayList<Integer>();  // create a NULL set
		
		powerSet.add(set);   // add the NULL set to the powerSet
		
		// HashMap is used to keep the VISIT COUNT of each element in the input
		HashMap<Integer, Integer> hm = new HashMap<>(); 
		
		int focoused;
		int counter=0,dupCounter;
		
		
		if (input.isEmpty())
			System.out.println("null");
		else {
			while (!input.isEmpty()) {
				// remove the element under consideration
				focoused = input.remove(0);    // remove the integer from input array list
				
				int psize = powerSet.size();     // get the size of the powerSet
				
				counter=0;
				dupCounter=0;
				{
					if(hm.containsKey(focoused))     // if the input element is ALREADY VISITED
					{
						hm.put(focoused, hm.get(focoused)+1); // increment the VISIT COUNT
						dupCounter = hm.get(focoused);  // get the VISIT COUNT indicating how many times the input element is visited
						for (int i = 0; i < psize; i++) {
							// get only those ArrayList element of the powerSet which contains single element
							for(Integer ii : powerSet.get(i)) // if get(i) returns object of ArrayList then Integer ii would be null
								if(ii==focoused)
									counter++;
							if(counter==dupCounter-1)
							{// clone each element of powerSet, add the current input element and add this new ArrayList element to the powerSet
								set = (ArrayList<Integer>) powerSet.get(i).clone(); // get EACH element(and type cast it to ArrayList) of the powerSet and clone it
								set.add(focoused); // add the current input element to this new cloned ArrayList
								powerSet.add(set); // add this new cloned ArrayList element as a NEW ARRAYLIST element to the powerSet
							}
							// make the counter 0
							counter=0;
						}
					} 
					
					else{  // if the input element is NOT VISITED BEFORE
						hm.put(focoused, 1);   // mark it as visited in the HashMap
						for (int i = 0; i < psize; i++) {   // iterate through all the elements of the powerSet							
			// clone each element of powerSet, add the current input element and add this new ArrayList element to the powerSet			
							set = (ArrayList<Integer>) powerSet.get(i).clone(); // get EACH element(and type cast it to ArrayList) of the powerSet and clone it
							set.add(focoused); // add the current input element to this new cloned ArrayList
							powerSet.add(set); // add this new cloned ArrayList element as a NEW ARRAYLIST element to the powerSet
						}
					}
				}
			}
			System.out.println(powerSet.toString());
		}
	}
}
/*
 * Analysis:
 * Time Complexity = O()
 * Space Complexity = O()
 * 
 */