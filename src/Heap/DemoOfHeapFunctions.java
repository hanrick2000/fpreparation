package Heap;

/*
Sample Heapify, BuildHeap functions

The MinHeapify, MaxHeapify function require the following three helper fnctions
*/
	public class DemoOfHeapFunctions{
		public static int Parent(int i){
			return i;
		}
		public static int Left(int i){
			return (2*i+1);
		}
		public static int Right(int i){
			return (2*i+2);
		}
/*
Now, the Heaify function can be written RECURSIVELY as:
*/
	public static void MinHeapify(int[] A, int index){    // this is for min heap
		int leftIndex = Left(index);
		int rightIndex = Right(index);
		int smallest = index;          // ASSUME THAT THE SMALLEST IS PRESENT AT INDEX
		if(leftIndex <= (A.length-1) && (A[leftIndex] < A[index]))    // compare the index and the array element
			smallest = leftIndex;       
		if(rightIndex <= (A.length-1) && (A[rightIndex] < A[smallest])) // compare the index and the smallest array element
			smallest = rightIndex;
		if(smallest != index){         // This means our assumption is wrong & smallest is not present at index
			swap(A[index],A[smallest]);
			MinHeapify(A,smallest);     // Recursively continue the heapify process for the newly obtained "smallest" to check whether
		}                       // it is smallest in the entire array (not just smallest for only three elements-left,right,index)
	}

	public static void BuildHeap(int[] A){
		for(int i = (A.length-1/2) ; i>=0; i--)     // reverse iteration starting from (A.length-1/2) to 0
			MinHeapify(A,i);
	}

	public static void swap(int a, int b){   // swap function
		int temp = a;
		a=b;
		b=temp;
	}




//Similarly MaxHeapify can be written as:
	
	
public static void MaxHeapify(int[] A, int index){    // this is for min heap
	int leftIndex = Left(index);
	int rightIndex = Right(index);
	int largest = index;          // ASSUME THAT THE LARGEST IS PRESENT AT INDEX
	if(leftIndex <= (A.length-1) && (A[leftIndex] > A[index]))    // compare the index and the array element
    	largest = leftIndex;       
	if(rightIndex <= (A.length-1) && (A[rightIndex] > A[largest])) // compare the index and the largest array element
		largest = rightIndex;
	if(largest != index){         // This means our assumption is wrong & largest is not present at index
		swap(A[index],A[largest]);
		MaxHeapify(A,largest);     // Recursively continue the heapify process for the newly obtained "largest" to check whether
    }                       // it is largest in the entire array (not just largest for only three elements-left,right,index)
}

/* Analysis:
Time Complexity of Heapify funtion is O(Lg(n)), where n is the total elements in the array.
Time Compexity of BuildHeap is O(nLg(n)), since BuildHeap calls Heapify function on n/2 elements of the array. 
Hence in totality the time complexity of buildHeap method is O(nLg(n)).
*/
}