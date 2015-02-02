/*
Question:  merge sorted arrays 'a' and 'b', each with 'length' elements, 
	 in-place into 'b' to form a sorted result. assume that 'b' 
	 has 2*length allocated space. 
	 e.g. a = [1, 3, 5], b = [2, 4, 6] => b = [1, 2, 3, 4, 5, 6] 

	HOW TO DO IT WITHOUT REARANGING THE B ARRAY

Question & Answer Source: http://www.careercup.com/question?id=5435439490007040
	
Algorithm: 
	The idea is merging from the back of the b array so the write op of the merge is 
	never interfered with read op from b
	
*/	
	
package MergeTwoSortedArraysInPlace;

public class UsingMergeOfMergeSort {
	public static void main(String[] args) {
		
	}
	public static int[] merge(int[] a, int[] b){
		/*
		 * Read the question and implement the solution yourself. This is trivial hence I am not
		 * implementing it right now
		 * 
		Algorithm:
		int i_a = a.size() - 1;
		int i_b = b.size() - 1;
		int i_ab = a.size() + b.size() - 1;
			
		for ( ; i_a >= 0 && i_b >=0; )
		    if (a[i_a] > b[i_b])  b[i_ab--] = a[i_a--];
		    else b[i_ab--] = b[i_b--];	
			
		if (i_a > 0) {
		    for (;i_a >=0;)
		        b[i_ab--] = a[i_a--]; 
		} else  { // There is nothing to do if i_b > 0 as we merge onto b
		}*/
		return null;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(m+n)
	 * Space Complexity = O(1) since we are reusing array b to store the results
	 */
}
