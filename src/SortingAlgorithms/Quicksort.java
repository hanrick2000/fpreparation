/*
Sources:
Partition Function of QuickSort/QuickSelect:
http://stackoverflow.com/questions/18167528/how-to-write-a-quicksort-partition-function
QuickSort Java code with Partition Function:
http://www.algolist.net/Algorithms/Sorting/Quicksort


Importance of Partition: (Source: http://stackoverflow.com/questions/10846482/quickselect-algorithm-understanding)
Partition in quick sort picks a pivot.
Then it rearranges the list in a way that all elements less than pivot are on left side of pivot
and others on right. It then returns index of the pivot element.

Now here we are finding kth smallest element. After partition cases are:

1. k == pivot. Then you have already found kth smallest. This is because the way partition is working. 
There are exactly k - 1 elements that are smaller than the kth element.
2. k < pivot. Then kth smallest is on the left side of pivot.
3. k > pivot. Then kth smallest is on the right side of pivot. And to find it you actually have to find k-pivot
smallest number on right.

*/
package SortingAlgorithms;

public class Quicksort {
    
	private static int[] input;
     
    public static void main(String a[]){
       
        input = new int[]{24,2,45,20,56,75,2,56,99,53,12};
        
        System.out.println("Before Sorting");
        print(input);
        System.out.println();
        
        
        quickSort(input,0,input.length-1);
        
        
        System.out.println("After Sorting");
        print(input);
        }


	public static int partition(int arr[], int left, int right)
    {
          int i = left, j = right;
          int tmp;
          int pivot = arr[left+(right-left)/ 2];
         
          while (i <= j) {
                while (arr[i] < pivot)
                      i++;
                while (arr[j] > pivot)
                      j--;
                
                if(i>j)
                	break;   
                else { // if(i<=j)
                      tmp = arr[i];
                      arr[i] = arr[j];
                      arr[j] = tmp;
                      // increment i and j
                      i++;
                      j--;
                }
          };
         
          return i;   // return the index of the pivot element
    }
     
    public static void quickSort(int arr[], int left, int right) {
          int index = partition(arr, left, right);
          if (left < index - 1)                      
                quickSort(arr, left, index - 1);     // exclude the index position
          if (index < right)     
                quickSort(arr, index, right);        // include the index position
    }
    
    private static void print(int[] a) {
		for(int i: a)
			System.out.print(i+" ");
	}

}
/*
Analysis:
	Time Complexity = O(nlgn)
	Space Complexity = O(1)
*/

