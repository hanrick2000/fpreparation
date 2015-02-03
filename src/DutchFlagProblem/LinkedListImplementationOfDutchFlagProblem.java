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
		linkedList.add(1);
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
		
		Iterator<Integer> iter = linkedList.iterator();
		HashMap<Integer, Integer> hash = new HashMap<Integer,Integer>();
		while(iter.hasNext()){
			int key = iter.next();
			if(!hash.containsKey(key))
				hash.put(key, 1);
			else{
			int count = hash.get(key);
			count+=1;
			hash.put(key, count);
			}
		}
		linkedList.clear();
		Set<Map.Entry<Integer, Integer>> set = hash.entrySet();
		Iterator<Map.Entry<Integer, Integer>> loop = set.iterator();
		while(loop.hasNext()){
			Map.Entry<Integer, Integer> obj = loop.next();
			int key = obj.getKey();
			int value = obj.getValue();
			while(value>0)
				linkedList.add(key);	
		}
		return linkedList;
	}
}

