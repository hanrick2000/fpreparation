/*
Question: Find Maximum size square sub-matrix with all 1's
Source: 	
Algorithm:
	1. create a AUX matrix 
	2. Copy the 0th row as it is
	3. Copy the 0th column as it is
	4. iterate from 1st row and 1st column till the end
		 if(original[i][j]==1)
			change solution[i][j] to Math.min(input[i][j-1],input[i-1][j],input[i-1][j-1])+1;
		 else
			solution[i][j]=0
		 Math.max(solution[i][j],max)
    5. return max*max
			
NOTE: This only works to find SQUARE SUB MATRIX
*/
package HistogramAndMatrix;

class maxSquareAreaInMatrix{

	    public static void main(String[] args){
	        
	        int[][] knows = new int[][]{{1,0,0,1},
	                                    {0,1,1,1},
	                                    {0,1,1,0},
	                                    {1,1,1,0}};
	                                    
	                                    
	        System.out.println("The max area is: "+findLargest(knows));
	    }
	    public static int findLargest(int[][] original){

	        if(original==null||original.length==0)
	            return -1;
	        
	        int[][] aux = new int[original.length][original[0].length];
	        int max = 0;
	        
	        for(int i=0;i<original.length;i++)
	            aux[i][0] = original[i][0];
	            
	        for(int j=0;j<original[0].length;j++)
	            aux[0][j] = original[0][j];
	        
	        for(int i=1;i<original.length;i++){
	            for(int j=1;j<original[0].length;j++){
	                if(original[i][j]==1)
	                	aux[i][j] = Math.min(original[i-1][j-1],Math.min(original[i-1][j],original[i][j-1]))+1; // Math.min though we are finding max area VERY VERY IMP
	                else
	                	aux[i][j]=0;
	                max=Math.max(aux[i][j], max);
	            }
	        }
	       
	        
	        return max*max;               // <----- VERY VERY IMP
	        
	    }
	}
/*
 * Analaysis:
 * 			Time Complexity = O(m*n) where original = number of rows
 * 										   n = number of columns
 * 			Space Complexity = O(m*n)
*/
