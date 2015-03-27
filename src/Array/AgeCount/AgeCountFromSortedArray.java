/*
Question:
Given an array of ages (integers) sorted lowest to highest, output the number of occurrences for each age. 
For instance: 
[8,8,8,9,9,11,15,16,16,16] 
should output something like: 
8: 3 
9: 2 
11: 1 
15: 1 
16: 3 

This should be done in less than O(n).

Example:
8
8
8
9
9
11
15
16
16
16
Output should be: {16=3, 8=3, 9=2, 11=1, 15=1}
 * 
 */

package Array.AgeCount;

import java.util.HashMap;
import java.util.Scanner;

public class AgeCountFromSortedArray {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements of the sorted array");
			int n = in.nextInt();
			int[] input = new int[n];
			System.out.println("Enter the elements");
			for(int i=0;i<n;i++)
				input[i]=in.nextInt();
			System.out.println(count(input).toString());
		}
		finally{
			in.close();
		}
	}
	public static HashMap<Integer,Integer> count(int[] input) {
		
		if(input==null||input.length==0)
			return null;
		// Use HashMap where key = unique age and value = repetition count of this age in the array
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		count (input, 0, input.length-1, map);
		return map;
	}
		
	private static void count(int[] input, int begin, int end, HashMap<Integer,Integer> map) {
		
		if (input[begin] == input[end]) {
			if(map.get(input[begin])==null)        // if key not present in map
				map.put(input[begin],end-begin+1);
			else                                   // if key present in map then add to the previous value
				map.put(input[begin],map.get(input[begin])+(end-begin+1));
		}
		else {
			count(input, begin, (begin+end)/2, map);
			count(input, (begin+end)/2 + 1, end, map);
		}		
	}
	/*
	 * Analysis:
	 * Time Complexity = O(mlgn) where m = unique number of ages and n = total number of elements
	 * Since m is practically a constant (unfortunately our age is bound), the time complexity is log n.
	 * Space Complexity = O(m) where m = unique number of ages
	 */
}
