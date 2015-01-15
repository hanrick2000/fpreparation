
/*
Question: Given an array of ages (integers) sorted lowest to highest, 
output the number of occurrences for each age. 
For instance: 
[8,8,8,9,9,11,15,16,16,16] 
should output something like: 
8: 3 
9: 2 
11: 1 
15: 1 
16: 3 

This should be done in less than O(n).

Source: http://www.careercup.com/question?id=5129701993480192
*/
package CountNumberOfOccurancesInSortedArray;

import java.util.HashMap;
import java.util.Scanner;

public class UsingBinarySearch {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	System.out.println("Enter the number of elements in the array");
	int n = in.nextInt();
	System.out.println("Enter the elements of the SORTED array");
	int[] a=new int[n];
	for(int i=0;i<n;i++)
		a[i]=in.nextInt();
	System.out.println("The number of occurances of each of the element is:");
    // We use a hashMap to store the count of each element
	HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
	findOccurances(a,0,a.length-1,map);
	}
	finally{
		in.close();
	}
	}

private static void findOccurances(int[] a, int start, int end, HashMap<Integer, Integer> map) {
	if(a[start]==a[end]){  // if we find the matching elements then count its occurrence  
		if(map.get(a[start])!=null){            // key exists
			int count = map.get(a[start]);
			map.put(a[start],count+(end-start+1));
		}
		else     // key does not exist
			map.put(a[start], (end-start+1));
	}
	else{   // do a binary search
		findOccurances(a, start, (start+end)/2, map);
		findOccurances(a, ((start+end)/2+1), end, map);
		if(end==a.length-1 && start==0)        // This condition is induced so that the HashMap would be printed only once
			System.out.println(map);
		}
	}
}
/*
Analysis:
Please NOTE, in the program,
n = TOTAL number of elements in the array
m = number of UNIQUE elements in the array
k = COUNT of each element in the array
Time Complexity = O(mlgk)
Thus, if all data are unique then it would be O(m log 1) == O(m) == O(n)

Space Complexity = O(m) where m = number of UNIQUE elements in the array
*/