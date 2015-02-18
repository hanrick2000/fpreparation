/*
Source: http://examples.javacodegeeks.com/core-java/mergesort-algorithm-in-java-code-example/
*/

package SortingAlgorithms;

public class MergeSort {

	private static int []a;
	public static void main(String[] args) {
		a = getArray();
		printArray(a);
		sort();
		System.out.println();
		printArray(a);
		
	}
	
	public static void sort(){
		int []tempArray = new int[a.length];
		mergeSort(tempArray,0,a.length-1);
	}
	public static void mergeSort(int []tempArray,int lowerIndex,int upperIndex){
		if(lowerIndex == upperIndex){
			return;
		}else{
			int mid = (lowerIndex+upperIndex)/2;
			mergeSort(tempArray, lowerIndex, mid);
			mergeSort(tempArray, mid+1, upperIndex);
			merge(tempArray,lowerIndex,mid,mid+1,upperIndex);
		}
	}
	
	public static void merge(int []tempArray,int start1,int end1,int start2,int end2){
		int tempIndex=0;  // index of the solution array
		int lowerIndex = start1;   // store the start of the solution array
		int higherIndex = end2;    // store the end of the solution array
		int totalItems = higherIndex-lowerIndex+1;
		
		// Variables used here are start1,end1,start2,end2
		while(start1 <= end1 && start2 <= end2){
			if(a[start1] < a[end2]){ // compare the elements of the input array and store the answer in tempArray
				tempArray[tempIndex++] = a[start1++];
			}else{
				tempArray[tempIndex++] = a[start2++];
			}
		}
		
		while(start1 <= end1){
			tempArray[tempIndex++] = a[start1++];
		}
		
		while(start2 <= end2){
			tempArray[tempIndex++] = a[start2++];
		}
		// END OF Variables used here are start1,end1,start2,end2
		
		// This loop copies the solution to the input array(i.e. a[])
		for(int i=0;i<totalItems;i++){
			a[lowerIndex+i] = tempArray[i];  // lowerIndex is stored at the start of the loop
		}
	}
	
	public static void printArray(int []array){
		for(int i : array){
			System.out.print(i+" ");
		}
	}
	
	public static int[] getArray(){
		int size=10;
		int []array = new int[size];
		int item = 0;
		for(int i=0;i<size;i++){
			item = (int)(Math.random()*100); 
			array[i] = item;
		}
		return array;
	}

}
/*
Analysis:
	Time Complexity = O(nlgn)
	Space Complexity = O(n)
	
	
	
Algorithm of MergeSort
			public class MergeSort {

		void mergeSort(int list[], int start, int end) {
			int[] solution = new int[list.length];
			if(start>=end) {
				return;
			}
			
			int mid = (start+end)/2 + start;
			mergeSort(list, start, mid);
			mergeSort(list,mid+1, end);
			merge(list, start, mid, mid+1, end, solution);
		}
		//TODO: consider generic objects
		private void merge(int[] list, int startList1, int endList1, int startList2, int endList2, int[] solution) {
			int j = 0;
			while(startList1 <= endList2 && startList2 <= endList2) {	
				if(list[startList1] > list[startList2]) {
					solution[j] = list[startList2];
					startList2++;
				}
				else {
					solution[j] = list[startList1];
					startList1++;
				}
				j++;
			}
			while(startList1<=endList1) {
				solution[j] = list[startList1];
				j++;
				startList1++;
			}
			while(startList2<=endList2) {
				solution[j] = list[startList2];
				j++;
				startList2++;
			}
		}
	}

*/