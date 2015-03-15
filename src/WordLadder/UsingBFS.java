/*
Question: Given two words (start and end), and a dictionary, 
find the length of shortest transformation sequence from start to end, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the dictionary
For example,

Given:

start = "hit"
end = "cog"
dict = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog", the program should return its length 5.

Question and Answer Source: http://www.programcreek.com/2012/12/leetcode-word-ladder/

Algorithm:
Breath First Search

So we quickly realize that this looks like a tree searching problem for which breath first guarantees the optimal solution.
Assuming we have some words in the dictionary, and the start is "hit" as shown in the diagram below.
word-ladder
We can use two queues to traverse the tree, one stores the nodes, the other stores the step numbers.
*/

package WordLadder;

import java.util.HashSet;
import java.util.LinkedList;

public class UsingBFS {
	public static void main(String[] args) {
		
	}
	public int ladderLength(String start, String end, HashSet<String> dict) {
		if (dict.size() == 0)
			return 0;
	 
		dict.add(end);
	 
		LinkedList<String> wordQueue = new LinkedList<String>();
		LinkedList<Integer> distanceQueue = new LinkedList<Integer>();
	 
		wordQueue.add(start);
		distanceQueue.add(1);
	 
		//track the shortest path
		int result = Integer.MAX_VALUE;
		while (!wordQueue.isEmpty()) {
			String currWord = wordQueue.pop();
			Integer currDistance = distanceQueue.pop();
	 
			if (currWord.equals(end)) {
				result = Math.min(result, currDistance);
			}
	 
			for (int i = 0; i < currWord.length(); i++) {
				char[] currCharArr = currWord.toCharArray();
				for (char c = 'a'; c <= 'z'; c++) {
					currCharArr[i] = c;
	 
					String newWord = new String(currCharArr);
					if (dict.contains(newWord)) {
						wordQueue.add(newWord);
						distanceQueue.add(currDistance + 1);
						dict.remove(newWord);
					}
				}
			}
		}
	 
		if (result < Integer.MAX_VALUE)
			return result;
		else
			return 0;
	}
}
