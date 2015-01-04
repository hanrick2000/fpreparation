/*
Source: http://www.java2novice.com/java-sorting-algorithms/bubble-sort/
*/
package SortingAlgorithms;

public class Bubblesort {
	  
    // logic to sort the elements
    public static void bubble_srt(int array[]) {
        int n = array.length;
        for(int i=0;i<n;i++){
        	for(int j=i;j<n;j++){
        		if(array[j]<array[i])
        			swapNumbers(i, j, array);
        	}
        }
        printNumbers(array);
    }
  
    private static void swapNumbers(int i, int j, int[] array) {
  
        int temp;
        temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
  
    private static void printNumbers(int[] input) {
          
        for (int i = 0; i < input.length; i++) {
            System.out.print(input[i] + ", ");
        }
        System.out.println("\n");
    }
  
    public static void main(String[] args) {
        int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };
        bubble_srt(input);
  
    }
}
/*
Time Complexity:
	Time Complexity = O(n^2)
	Space Complexity = O(1)
*/
