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

Algorithm:
for each element of input : 
If it is visited for the first time, just add it to all sets that has been added to powerset. 

else check hashmap to find number of this element that has been visited, then add new element to 
set(s) that has exactly this number of duplication.
*/
package PowerSetFromSet;

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
		ArrayList<Integer> set = new ArrayList<Integer>();
		powerSet.add(set);   // size of powerSet is increased by 1
		
		// HashMap is used to keep the VISIT COUNT of each element in the input
		HashMap<Integer, Integer> hm = new HashMap<>(); 
		
		int focoused;
		int counter=0,dupCounter;
		
		
		if (input.isEmpty())
			System.out.println("null");
		else {
			while (!input.isEmpty()) {
				// remove the element under consideration
				focoused = input.remove(0);   
				
				int psize = powerSet.size();     // get the size of the powerSet
				
				counter=0;
				dupCounter=0;  
				{
					if(hm.containsKey(focoused))     // if the input element is ALREADY VISITED
					{
						hm.put(focoused, hm.get(focoused)+1); // increment the VISIT COUNT
						dupCounter = hm.get(focoused);  // get the VISIT COUNT indicating how many times the input element is visited
						
						for (int i = 0; i < psize; i++) {
							
							for(Integer ii : powerSet.get(i))
								if(ii==focoused)
									counter++;
							
							
							if(counter==dupCounter-1)
							{

								// add the current element to EACH ARRAYLIST ELEMENT of the powerEet
								
								set = (ArrayList<Integer>) powerSet.get(i).clone(); // get the first element(and type cast it to ArrayList) of the powerSet and clone it
								set.add(focoused); // add the current input element to this 
								powerSet.add(set); // add this ArrayList back to the powerSet
							}
							
							// make the counter 0
							counter=0;
						
						}
					} 
					
					else{  // if the input element is NOT VISITED BEFORE
						hm.put(focoused, 1);   // mark it as visited in the HashMap
						
						for (int i = 0; i < psize; i++) {   // iterate through all the elements of the powerSet
							
							// add the current element to EACH ARRAYLIST ELEMENT of the powerEet
							
							set = (ArrayList<Integer>) powerSet.get(i).clone(); // get the first element(and type cast it to ArrayList) of the powerSet and clone it
							set.add(focoused); // add the current input element to this 
							powerSet.add(set); // add this ArrayList back to the powerSet
						}
					}
				}
			}
			System.out.println(powerSet.toString());
		}
	}
}
