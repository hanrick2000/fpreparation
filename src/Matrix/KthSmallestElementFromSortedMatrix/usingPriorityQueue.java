/*
Question: Find the kth smallest element in a matrix sorted rowise and columnwise

Question And Answer Source: http://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/

Example:
10  20  30  40
15  25  35  45
24  29  37  48
32  33  39  50

The 3rd smallest element is 20 and 8th smallest element is 32
*/
package Matrix.KthSmallestElementFromSortedMatrix;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;


public class usingPriorityQueue{

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of rows of the matrix");
			int r = in.nextInt();
			System.out.println("Enter the number of columns of the matrix");
			int c = in.nextInt();
			int[][] matrix = new int[r][c];
			System.out.println("Enter the elements of the matrix");
			System.out.println("the matrix to be entered is sorted BOTH ROWWISE AND COLUMNWISE");
			for(int i=0;i<matrix.length;i++){
				for(int j=0;j<matrix[0].length;j++)
					matrix[i][j] = in.nextInt();
			}
			
			System.out.println("PROGRAM TO PRINT THE KTH SMALLEST ELEMENT IN THE SORTED MATRIX");
			System.out.println("Enter the value of k");
			int k = in.nextInt();
			System.out.println("The kth smallest element in the SORTED matrix is: "+kthSmallest(matrix,k));
		}
		finally{
			in.close();
		}
	}

	private static int kthSmallest(int[][] matrix, int k) {
		
		// k must be greater than 0 and smaller than n*n
	    if (k <= 0 || k > matrix.length*matrix[0].length)
	       return Integer.MAX_VALUE;
	    
		// create a minHeap of total number of columns
		PriorityQueue<MatrixElement> minHeap = new PriorityQueue<MatrixElement>(matrix[0].length, new Comparator<MatrixElement>(){
			public int compare(MatrixElement a, MatrixElement b){
				return (a.value-b.value);
			}
		});
		/*
		PriorityQueue(int initialCapacity, Comparator)
		Creates a PriorityQueue with the specified initial capacity that orders its elements according to 
		their natural ordering.
		 */
		
		// add the first row to the minHeap
		for(int i=0;i<matrix[0].length;i++)
			minHeap.add(new MatrixElement(matrix[0][i], 0, i));
		
		MatrixElement lowest=null;
		// Do the following k times
		for(int i=0;i<k;i++){
			lowest = minHeap.remove();
			
			// Get the next VALUE from the matrix in the NEXT ROW, SAME COLUMN
			int nextRow = lowest.row+1;      
			int nextColumn = lowest.column;
			
			if(nextRow<matrix.length) // if the nextRow is not out of bounds then add the element
				minHeap.add(new MatrixElement(matrix[nextRow][nextColumn], nextRow, nextColumn));
			else
				minHeap.add(new MatrixElement(Integer.MAX_VALUE, nextRow, nextColumn));
		}
		return lowest.value;
	}
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