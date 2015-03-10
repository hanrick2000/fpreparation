package DutchFlagProblem;

/*
Question And Answer Source : http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/

Algorithm:
Examine a[Mid]. There are three possibilities: a[Mid] is (0) red, (1) white or (2) blue.
Case (0) a[Mid] is red, swap a[Lo] and a[Mid]; Lo++; Mid++

0 0 0 0 1 1 1 ? ? ? 2 2 2
^     ^   ^
|     |   |
Lo    Mid Hi

Case (1) a[Mid] is white, Mid++

0 0 0 1 1 1 1 ? ? ? 2 2 2
^       ^   ^
|       |   |
Lo      Mid Hi

Case (2) a[Mid] is blue, swap a[Mid] and a[Hi]; Hi-- ;

0 0 0 1 1 1 ? ? ? 2 2 2 2
^     ^   ^
|     |   |
Lo    Mid Hi

Continue until Mid>Hi.
*
*/

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class LinkedListImplementationOfDutchFlagProblem {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	List<Integer> linkedList = new LinkedList<Integer>();
	System.out.println("Enter the number of elements to be entered in the List");
	int n = in.nextInt();
	System.out.println("Enter the elements");
	for(int i=0;i<n;i++)
		linkedList.add(in.nextInt());
	linkedList = LLDutchFlagImplementation(linkedList);
	printLL(linkedList);
	}
	finally{
		in.close();
		}
	}

	private static void printLL(List<Integer> linkedList) {
	Iterator<Integer> iter = linkedList.iterator();
	System.out.println("LL Elements:");
	while(iter.hasNext()){
		System.out.print(iter.next()+" ");
	}
	System.out.println();
}

	public static List<Integer> LLDutchFlagImplementation(List<Integer> linkedList){
		
		
		/*
		 * Can be solved using HashMap where,
		 * key = listNode.data
		 * value = count of nodes with same data value
		 */
		
		Iterator<Integer> iter = linkedList.iterator();
		HashMap<Integer, Integer> map = new HashMap<Integer,Integer>();
		while(iter.hasNext()){
			int key = iter.next();
			if(!map.containsKey(key))
				map.put(key, 1);
			else
				map.put(key, map.get(key)+1);
		}
		linkedList.clear();
		Set<Map.Entry<Integer, Integer>> set = map.entrySet();
		Iterator<Map.Entry<Integer, Integer>> itr = set.iterator();
		while(itr.hasNext()){
			Map.Entry<Integer, Integer> obj = itr.next();
			int key = obj.getKey();
			int value = obj.getValue();
			while(value>0){
				linkedList.add(key);
				value--;
			}
		}
		return linkedList;
	}
}
/*
 * Analysis:
 * Time Complexity = O(n)
 * Space Complexity = O(2n) where O(n) used by HashMap and O(n) used by HashSet
 */

