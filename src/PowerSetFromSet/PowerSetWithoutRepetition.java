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
		powerSet.add(set);
		HashMap<Integer, Integer> hm = new HashMap<>();
		int focoused;
		int counter=0,dupCounter;
		if (input.isEmpty())
			System.out.println("null");
		else {
			while (!input.isEmpty()) {
				focoused = input.remove(0);
				int psize = powerSet.size();
				counter=0;
				dupCounter=0;
				{
					if(hm.containsKey(focoused))
					{
						hm.put(focoused, hm.get(focoused)+1);
						dupCounter = hm.get(focoused);
						for (int i = 0; i < psize; i++) {
							for(Integer ii : powerSet.get(i))
								if(ii==focoused)
									counter++;
							if(counter==dupCounter-1)
							{
								powerSet.get(i).contains(focoused);
								set = (ArrayList<Integer>) powerSet.get(i).clone();
								set.add(focoused);
								powerSet.add(set);
							}
							counter=0;
						}
					}
					else{
						hm.put(focoused, 1);
						for (int i = 0; i < psize; i++) {
							set = (ArrayList<Integer>) powerSet.get(i).clone();
							set.add(focoused);
							powerSet.add(set);
						}
					}
				}
			}
			System.out.println(powerSet.toString());
		}
	}
}
