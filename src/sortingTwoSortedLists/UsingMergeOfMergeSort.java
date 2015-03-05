/*
Question: Sort two sorted lists in ascending order
Source: http://www.careercup.com/question?id=5674416807608320
*/
package sortingTwoSortedLists;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class UsingMergeOfMergeSort {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	System.out.println("Enter the size of the first list");
	int m = in.nextInt();
	System.out.println("Enter elements of the first list");
	LinkedList<Integer> l1=new LinkedList<Integer>();
	for(int i=0;i<m;i++)
		l1.add(in.nextInt());
	System.out.println("Enter the size of the second list");
	int n = in.nextInt();
	System.out.println("Enter elements of the second list");
	LinkedList<Integer> l2=new LinkedList<Integer>();
	for(int i=0;i<n;i++)
		l2.add(in.nextInt());
	LinkedList<Integer> result = sortSortedLists(l1,l2);
	System.out.println("Result of sorting the two list is: "+print(result));
	}
	finally{
		in.close();
	}
}

private static String print(LinkedList<Integer> result) {
	StringBuilder sb = new StringBuilder();
	Iterator<Integer> iter = result.iterator();
	while(iter.hasNext()){
		sb.append(iter.next()+" ");
	}
	return sb.toString();
}

private static LinkedList<Integer> sortSortedLists(LinkedList<Integer> l1,
		LinkedList<Integer> l2) {
	LinkedList<Integer> result = new LinkedList<Integer>();
	int i=0;  // This will iterate through first list
	int j=0;  // This will iterate through second list
	while((i<l1.size())&&(j<l2.size())){
		/*
		 * VERY IMP: listObject.get(index i) FUNCTION
		 */
		if(l1.get(i)<l2.get(j)){
			result.add(l1.get(i));
			i++;
		}
		else{
			result.add(l2.get(j));
			j++;
		}
	}
	while(i<l1.size()){
		result.add(l1.get(i));
		i++;
	}
	while(j<l2.size()){
		result.add(l2.get(j));
		j++;
	}
	return result;
}
}
/*
Analysis:
	Time Complexity = O(m+n)
	Space Complexity = O(m+n)
*/