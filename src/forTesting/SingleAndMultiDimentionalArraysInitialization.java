package forTesting;

public class SingleAndMultiDimentionalArraysInitialization {
public static void main(String[] args) {
// Initializing single dimensional arrays. Doing initialization in this way, does not require use of 'new' operator.
	String[] OneDArray = {"hello","world","my","name","is"};  
	int[] intArray = {1,2,3,4,5,6,7,8};
	
// Initializing 2d array. Doing initialization in this way, does not require use of 'new' operator.
	String[][] TwoDArray = {{"hello","world"},{"hi","bye"},{"me","tu"},{"aapli","aapla"}}; // 4*2 array
	int[][] intTwoArray = {{1,2,3},{4,5,6},{8,9,10},{11,12,13},{14,15,16}}; // 3*5 array
	
// Accessing number of rows and columns in multidimentional arrays
	int rows = TwoDArray.length;       // Gives number of rows
	int columns = TwoDArray[0].length;   // Gives number of coulmns
	
	// Print Rows and Columns
	System.out.println(rows);
	System.out.println(columns);
	
	// Print arrays by calling the custom toDtring() method
	System.out.println(OneDArray);
	System.out.println(intArray);
	System.out.println(TwoDArray);
	System.out.println(intTwoArray);
	
	// Print the value of characters
	System.out.println('c'*'a'*'r'*'s');//  125895330
	System.out.println('c'*'b'*'p'*'s');//	124961760
	System.out.println('a'*'r'*'c'*'s');//	125895330
}

}
