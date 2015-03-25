/*
Question: Divide a list of numbers into group of consecutive numbers but their original order should be preserved? 
		e.g. 
		8,2,4,7,1,0,3,6 

		2,4,1,0,3 and 8,7,6 

		obviously in shortest time and space.

Question Source: http://www.careercup.com/question?id=65732
	
Answer Source: http://www.careercup.com/question?id=65732

Algorithm:
1. Build a HashMap where key=arrayValue and value = index
2. Create an array used to indicate the group number. 
3. Take the first value of the input array and mark its corresponding group number of the array as 1. 
4. Assume the first value of the input array head is n. set MIN=n-1 and MAX=n+1
5. Check if MIN and MAX is in the HashMap. If yes, remove them from the HashMap
   and mark the corresponding element as group 1. MIN = MIN -1 if (MIN-1) is there and MAX = MAX + 1 
   if MAX +1 is identified. 
6. If both min and max cannot be identified then increment the groupNumber and update min to min-1 and max to max+1
   and continue checking the next element until there is no element in the HashMap.
8. now we have an array of group numbers with the same index as the original array and we can build the group.
*/
package Array.ConsecutiveGroups;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class ConsecutiveGroups {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the elements of the array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			consecutiveNumbers(a);
		}
		finally{
			in.close();
		}
	}
	public static void consecutiveNumbers(int a[]) {
		
		// 1. Build a HashMap where key=arrayValue and value = index
		HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++)
			map.put(a[i], i);
		
		HashMap<Integer,LinkedList<Integer>> result = new HashMap<Integer,LinkedList<Integer>>();
		
		// 2. Create an array used to indicate the group number. 
		int[] groupIndicator = new int[a.length];
		
	
		/*
		3. Take the first value of the input array and mark its corresponding group number of the array as 1. 
		4. Assume the first value of the input array head is n. set MIN=n-1 and MAX=n+1. 
		*/
		int groupNumber=1;
		groupIndicator[0] = groupNumber;
		int min = a[0]-1; // Variables used to check -1 and +1 of the element under consideration
		int max = a[0]+1;
		map.remove(a[0]);
		
		
		LinkedList<Integer> groupList = new LinkedList<Integer>();
		groupList.add(a[0]);
		result.put(groupNumber, groupList);
		
		while(!map.isEmpty()){
			
			// 5. Check if MIN and MAX is in the HashMap. If yes, remove them from the HashMap
			// and mark the corresponding element as group 1. MIN = MIN -1 if (MIN-1) is there and MAX = MAX + 1 
			// if MAX +1 is identified.
			
			if(map.containsKey(min)){
				
				int index = map.get(min);
				groupIndicator[index]=groupNumber;
				map.remove(min);
				// update the min
				min=min-1;
			}
			else if(map.containsKey(max)){
				int index = map.get(max);
				groupIndicator[index]=groupNumber;
				map.remove(max);
				// update the max
				max=max+1;
			}
			else{ 
				// 6. If both min and max cannot be identified then increment the groupNumber and update
				// min to min-1 and max to max+1 and continue checking the next element until there is no element 
				// in the HashMap. 
				groupNumber++;
				min = min-1;
				max = max+1;
			}
			
		}
		// 7. now we have an array of group numbers with the same index as the original array and we can
		// build the group.
		System.out.println("Number of Groups: "+groupNumber);
		System.out.println("Input Array:   "+Arrays.toString(a));
		System.out.println("Group Mapping: "+Arrays.toString(groupIndicator));
		
		
		formArrayList(groupNumber, a, groupIndicator);
	}
	/* Analysis for consecutiveNumbers method:
	 * Time Complexity = O(n)
	 * Space Complexity = O(2n) one used by HashMap other by groupIndicator Array
	 */
	private static void formArrayList(int totalGroups, int[] a, int[] groupIndicator) {
		System.out.println("Result (preserving the original order of the elements): ");
		for(int i=1;i<=totalGroups;i++){
			List<Integer> list = new ArrayList<Integer>();
			for(int j=0;j<a.length;j++){
				if(i==groupIndicator[j])
					list.add(a[j]);
			}
			System.out.println(list.toString());
		}
	}
	/* Analysis for formArrayList method:
	 * Time Complexity = O(totalGroups * sizeOfArray)
	 * Space Complexity = O(totalGroups * numberOfElementsInEachGroup)
	 */
		  
}

