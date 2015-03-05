
/*
 * Question: Write a progam to rotate a matrix by 90 degrees
 * Source: http://www.careercup.com/question?id=83756
 * 		   http://www.geeksforgeeks.org/turn-an-image-by-90-degree/
 * 
 * 
 * VERY IMP POINTS:
 * 1. Square matrix CAN be rotated in place
 * 2. Rectangular matrix CANNOT be rotated in place BECAUSE WE CANNOT CHANGE DIMENSIONS
 * Example: If original is 2x3 matrix then the rotated with also be 2x3 which is INCORRECT
 * In order to make it correct we need 3x2 matrix with values swapped. Since we are NOT ALLOWED
 * to change the dimensions of original matrix in case of IN PLACE rotation hence we cannot
 * ACHIEVE the correct result of IN PLACE rotateion in case of RECTANGULAR MATRIX 
 * 3. BOTH square and rectangular matrix can be rotated using extra memory (i.e. aux[][] matrix)
 * 
 * 
 * Solution Source: 
 * BEST EXPLANATION SOURCE: http://stackoverflow.com/questions/25882480/rotating-a-nxn-matrix-in-java
 * http://stackoverflow.com/questions/20773692/rotate-matrix-in-place
 * http://www.programcreek.com/2013/01/leetcode-rotate-image-java/
 * 
 * Algorithm:
 * Consider a sample matrix could look like this:

ABCD
EFGH
IJKL
MNOP
For the purposes of my explanation, ABCD is considered as row 0, EFGH is row 1, and so on. The first pixel of row 0 is A.

Also, when I talk about the outer shell, I am referring to:

ABCD
E  H
I  L
MNOP
First let's look at the code that moves the values.

    int top = matrix[first][i]; // save top
The first line caches the value in the top position. This refers to the position on the top 
row of the matrix identified by [first][i]. Eg: saving the A.

    // left -> top
    matrix[first][i] = matrix[last-offset][first];          
The next part moves the value from the left position into the top position. Eg: taking the
 M and putting it where the A is.

    // bottom -> left
    matrix[last-offset][first] = matrix[last][last - offset]; 
The next part moves the value from the bottom position into the left position. Eg: taking the
 P and putting it where the M is.

    // right -> bottom
    matrix[last][last - offset] = matrix[i][last]; 
The next part moves the value from the right position into the bottom position. Eg: taking the
D and putting it where the P is.

    // top -> right
    matrix[i][last] = top; // right <- saved top
The last part moves the value from the cache (what was the top position) into the right position. 
Eg: putting the A from the first step where the D is.

Next the loops.

The outer loop runs from row 0 to half the total number of rows. This is because when you rotate row 0,
 it also rotates the last row and when you rotate row 1, it also rotates the second-to-last row, and so on.

The inner loop runs from the first pixel position (or column) in the row to the last. Keep in mind that 
for row 0, this is from pixel 0 to the last pixel, but for row 1, this is from pixel 1 to the second-to-last
 pixel, since the first and last pixels are rotated as part of row 0.

So the first iteration of the outer loop makes the outer shell rotate. In other words:

ABCD
EFGH
IJKL
MNOP
becomes:

MIEA
NFGB
OJKC
PLHD
See how the outer shell has rotated clockwise, but the inner core has not moved.

Then the second iteration of the outer loop causes the second row to rotate (excluding the first 
and last pixels) and we end up with:

MIEA
NJFB
OKGC
PLHD
 */

package RotateMatrix90Degrees;

import java.util.Scanner;


public class InplaceRotationAndUsingAuxMatrix {
public static void main(String[] args) {
	

	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the number of rows");
		int rows=in.nextInt();
		System.out.println("Enter the number of columns");
		int cols = in.nextInt();
		int[][] image = new int[rows][cols];
		System.out.println("Enter the elements of the matrix");
		for(int i=0;i<rows;i++)
			for(int j=0;j<cols;j++)
				image[i][j]=in.nextInt();
		int[][] copyImage = image;
		System.out.println("Original Matrix: ");
		printImage(image);
		System.out.println();
		rotateMatrixUsingAuxArray(image);
		System.out.println();
		System.out.println("Original Matrix: ");
		printImage(copyImage);
		rotateMatrixInPlace(copyImage, copyImage.length);
		System.out.println("Rotated Matrix in place: ");
		printImage(copyImage);

	}
	finally{
		in.close();
		}

	}
public static void rotateMatrixInPlace(int[][] matrix, int n){
	
	// NOTE: Only SQUARE matrices can be rotated using INPLACE method
	
	for (int layer = 0; layer < n/2; layer++) {
        int first = layer;
        int last = n - 1 - first; // last = total-1-first
        for(int i = first; i < last; ++i) {   // iterate from first to last
            
        	int offset = i - first;  // COMPLEMENT OF i. This offset is is VERY IMP
        	
            /*int leftTop = matrix[first][i];
            int rightTop = matrix[i][last]; 
            int leftBottom = matrix[last-offset][first];
            int rightBottom = matrix[last][last - offset];        
            */
        	
        	
            // save the leftTop in temp variable
            int temp = matrix[first][i];
            
            // copy leftBottom to leftTop
            matrix[first][i]=matrix[last-offset][first];
            
            // copy rightBottom to leftBottom
            matrix[last-offset][first]=matrix[last][last - offset]; 
            
            // copy rightTop to rightBottom
            matrix[last][last - offset]=matrix[i][last]; 
            
            // copy temp variable to rightTop
            matrix[i][last]=temp;
          
        }
    }

}
	/*
	 * Analysis:
	 * Time Complexity = O(mn)
	 * Space Complexity = O(1) since NO aux array is used
	 */
	private static void rotateMatrixUsingAuxArray(int[][] image) {
	int[][] aux = new int[image[0].length][image.length]; // rows becomes columns and columns becomes rows
	for(int i=0;i<image.length;i++)
		for(int j=0;j<image[0].length;j++)
			aux[j][image.length-i-1] = image[i][j];  // row and columns are swapped in aux matrix
	System.out.println("Rotated Matrix using AUX matrix: ");
	printImage(aux);
		
}
/*
 * Analysis:
 * Time Complexity = O(mn)
 * Space Complexity = O(mn) due to use of aux array
 */
	
	public static void printImage(int[][] image){
		for(int i=0;i<image.length;i++){
			for(int j=0;j<image[0].length;j++)
				System.out.print(image[i][j]+" ");
		    System.out.println();
		}
	}
}
