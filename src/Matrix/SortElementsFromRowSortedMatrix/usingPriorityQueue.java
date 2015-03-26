
/*
Question:
Given an m x n matrix where each row element is sorted, but the columns do not appear in sorted order, 
write a function to print each matrix element in sorted order. 

Example matrix: 
matrix = [ 
[20, 40, 80], 
[5, 60, 90], 
[45, 50, 55] 
] 

Your function should print 5, 20, 40, 45, 50, 55, 60, 80, 90. 

Add on: Assume that we are space-constrained such that we can only hold one column(i.e. total number of rows) 
in memory at a time. Optimize your function to work under such constraints as efficiently as possible.

Question and Answer Source: http://www.careercup.com/page?pid=facebook-interview-questions
*/

package Matrix.SortElementsFromRowSortedMatrix;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class usingPriorityQueue {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{20, 40, 80}, {5, 60, 90}, {45, 50, 55}}; // row elements are already sorted
		List<Integer> result = printSortedElements(matrix);		
		System.out.println(result.toString());
	}
	public static List<Integer> printSortedElements(int[][] matrix){
		
		
		// create a minHeap of number of rows
		PriorityQueue<MatrixElement> minHeap = new PriorityQueue<MatrixElement>(matrix.length, new Comparator<MatrixElement>(){
			public int compare(MatrixElement a, MatrixElement b){
				return (a.value-b.value);
			}
		});
		/*
		PriorityQueue(int initialCapacity, Comparator)
		Creates a PriorityQueue with the specified initial capacity that orders its elements according to 
		their natural ordering.
		 */
		
		List<Integer> result = new ArrayList<Integer>();
		
		for(int i=0;i<matrix.length;i++){
			minHeap.add(new MatrixElement(matrix[i][0], i, 0));
		}
		
		while(!minHeap.isEmpty()){
			MatrixElement lowest = minHeap.remove();
			
			result.add(lowest.value);
			
			int nextRow = lowest.row;      // row will be the same of the next Element
			int nextColumn = lowest.column+1; // we will get the next matrix element from the previousColumn+1
			
			if(nextColumn<matrix[lowest.row].length)                  // if the nextColumn is not out of bounds then add the element
				minHeap.add(new MatrixElement(matrix[nextRow][nextColumn], nextRow, nextColumn));
			
		}
		return result;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(m*n)
	 * Space Complexity = O(m*n) used by ArrayList to store the result
	 */
}
class MatrixElement{
	int value;
	int row;
	int column;
	public MatrixElement(int value, int row, int column){
		this.value=value;
		this.row = row;
		this.column = column;
	}
}