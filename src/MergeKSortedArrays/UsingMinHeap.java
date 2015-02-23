/*
Question: Merge K Sorted Arrays

Question Source: http://www.geeksforgeeks.org/merge-k-sorted-arrays/

Answer Source: http://www.geeksforgeeks.org/merge-k-sorted-arrays/
*/


package MergeKSortedArrays;


public class UsingMinHeap {
	public static void main(String[] args) {
		int[][] a =  new int[][]{ {1, 3, 5, 7},
	            				  {2, 4, 6, 8},
	            				  {0, 9, 10, 11}} ;
		int k = 3;
		mergeKSortedArrays(a,k);
	}

	private static void mergeKSortedArrays(int[][] a, int k) {
		
		HeapElement[] heap = new HeapElement[k]; 
		for(int i=0;i<k;i++)
			heap[i]=new HeapElement();
		
		/*
		 * Question:How to create array of class in Java
		 * Answer: 
			A[] a = new A[4];
			NOW, initialize the individual array object 
		    for(int i=0;i<4;i++)
				a[i] = new A();
		 * Answer Source: http://stackoverflow.com/questions/5364278/creating-an-array-of-objects-in-java
		 */
		
		
		// build the initial heap
		for(int i=0;i<k;i++){
			heap[i].value=a[i][0];
			heap[i].arrayIndex=i;
			heap[i].nextElementIndex=1;
		}
		Heap.buildHeap(heap);
		//System.out.println(Arrays.toString(heap));
		
		// calculate total elements
		int totalElements = 0;
		for(int i=0;i<k;i++){
			totalElements+=a[i].length;
		}
		
		int[] result = new int[totalElements];
		
		for(int i=0;i<totalElements;i++){
			
			// Get the minimum element and store it in output
			result[i]=heap[0].value;
			// Find the next element that will replace current
	        // root of heap. The next element belongs to same
	        // array as the current root.
			if(heap[0].nextElementIndex < a[heap[0].arrayIndex].length){  // if the nextIndex < totalLength
				heap[0].value = a[heap[0].arrayIndex][heap[0].nextElementIndex];
				heap[0].nextElementIndex ++;
			}
			// If root was the last element of its array
			 else
				 heap[0].value=Integer.MAX_VALUE; //INT_MAX is for infinite
			
			Heap.minHeapify(heap, 0);
		}
		
		printResult(result);
	}

	private static void printResult(int[] result) {
		for(int i: result)
			System.out.print(i+" ");
	}
}	

class HeapElement{
	
	int value;
	int arrayIndex; // index of the array among all the k arrays
	int nextElementIndex; // Index of next element to be picked in the array
	
	public HeapElement(){
		value=0;
		arrayIndex=0;
		nextElementIndex=0;
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
	
	public static void buildHeap(HeapElement[] a){
		for(int i=(a.length-1)/2;i>=0;i--)
			minHeapify(a,i);
	}
	public static void minHeapify(HeapElement[]  a, int index) {
			
		int leftIndex = left(index);
		int rightIndex = right(index);
		
		int smallest=index;
		if((leftIndex <=a.length-1) && (a[leftIndex].value<a[index].value))
			smallest = leftIndex;
		if((rightIndex<=a.length-1)&&(a[rightIndex].value<a[smallest].value))
			smallest = rightIndex;
		if(smallest!=index){
			swap(a,index,smallest);
			minHeapify(a, smallest);
		}
	}
	public static void swap(HeapElement[] a, int index, int smallest) {
		//swap all the data members value, arrayIndex and nextElementIndex
		HeapElement temp = new HeapElement();
		temp.value = a[index].value;
		temp.arrayIndex = a[index].arrayIndex;
		temp.nextElementIndex = a[index].nextElementIndex;
		
		a[index].value=a[smallest].value;
		a[index].arrayIndex=a[smallest].arrayIndex;
		a[index].nextElementIndex = a[smallest].nextElementIndex;
		
		a[smallest].value=temp.value;
		a[smallest].arrayIndex=temp.arrayIndex;
		a[smallest].nextElementIndex=temp.nextElementIndex;
	}

}
/*
Analysis:
Time Complexity = O(n*k*lgk)
where n = average number of elements in each array
k = total number of arrays

This can also be represented as m*lgk where m = n*k  
m = total number of elements combined from all the k arrays

Space Complexity = O(k)
*/