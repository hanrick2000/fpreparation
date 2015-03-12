/*
Question: Find the kth smallest element in a matrix sorted rowise and columnwise

Question And Answer Source: http://www.geeksforgeeks.org/kth-smallest-element-in-a-row-wise-and-column-wise-sorted-2d-array-set-1/

*/

package Matrix.KthSmallestElement;

import java.util.Scanner;

public class KthSmallestInSortedMatrix {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of rows of the matrix");
			int r = in.nextInt();
			System.out.println("Enter the number of columns of the matrix");
			int c = in.nextInt();
			int[][] m = new int[r][c];
			System.out.println("Enter the elements of the matrix");
			for(int i=0;i<m.length;i++){
				for(int j=0;j<m[0].length;j++)
					m[i][j] = in.nextInt();
			}
			
			System.out.println("PROGRAM TO PRINT THE KTH SMALLEST ELEMENT IN THE SORTED MATRIX");
			System.out.println("Enter the value of k");
			int k = in.nextInt();
			System.out.println("The kth smallest element in the SORTED matrix is: "+kthSmallest(m,k));
		}
		finally{
			in.close();
		}
	}

	private static int kthSmallest(int[][] m, int k) {
		
		
		// k must be greater than 0 and smaller than n*n
	    if (k <= 0 || k > m.length*m[0].length)
	       return Integer.MAX_VALUE;
		
	    // Create a min heap of elements FROM FIRST ROW of 2D array
		HeapNode[] minHeap = new HeapNode[m[0].length];
		
		int nodeCount=0;
		for(int column=0;column<m[0].length;column++){
				minHeap[nodeCount++] = new HeapNode(m[0][column], 0, column);;
		}
		Heap.buildHeap(minHeap);
		
		//  Do following k times
		HeapNode root=null;
		for(int i=0;i<k;i++){
			 
			 // Get current heap root
		     root = minHeap[0];
			
		     // Get the next VALUE from the matrix in the NEXT ROW, SAME COLUMN
		     int nextVal = (root.row < (m.length-1))? m[root.row + 1][root.column]: Integer.MAX_VALUE;
		     
		     // Update heap array root with next value
		     minHeap[0] = new HeapNode(nextVal, root.row+1, root.column);
		     
		     Heap.minHeapify(minHeap, 0);    // minHeapify from the replaced node index (Here root index)
		}
		
		return root.value;
		
	}
	
	
}
class HeapNode{
	int value;
	int row;
	int column;
	
	public HeapNode(int n, int r, int c){
		this.value=n;
		this.row=r;
		this.column=c;
	}
}
class Heap{
	public static int parent(int i){
		return i;
	}
	public static int left(int i){
		return 2*i+1;
	}
	public static int right(int i){
		return 2*i+2;
	}
	
	public static void buildHeap(HeapNode[] a){
		int start = (a.length-1/2);
		for(int i=start; i>=0; i--)     // reverse iteration starting from (A.length-1/2) to 0
			minHeapify(a,i);
	}
	public static void minHeapify(HeapNode[] a, int index) {
		int leftIndex = left(index);
		int rightIndex = right(index);
		int smallest = index;
		if(leftIndex<a.length && a[leftIndex].value<a[smallest].value)
			smallest=leftIndex;
		if(rightIndex<a.length && a[rightIndex].value<a[smallest].value)
			smallest=rightIndex;
		if(smallest!=index){
			swap(a,index,smallest);
			minHeapify(a, smallest);
		}
	}
	private static void swap(HeapNode[] a, int index1, int index2) {
		HeapNode temp=a[index1];
		a[index1]=a[index2];
		a[index2]=temp;
	}
}
/*
Analaysis:
Time Complexity
1) Build a min heap which takes O(n) time  (CLRS Book Page number 159 mentions buildHeap is a linear time operation)
2) Heapify k times which takes O(kLogn) time.
Therefore, overall time complexity is O(n + kLogn) time.
Space Complexity = O(k/)
*/