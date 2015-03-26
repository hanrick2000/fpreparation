
/*
 * 
Question: 
A robot has to move in a grid which is in the form of a matrix. It can go to 
1.) A(i,j)--> A(i+1,j) (Down) 
2.) A(i,j)--> A(i,i+1) (Right)

VERY VERY IMP NOTE: This question is different from minSteps question in the sense that 
  * in that question the robot can move (i+j,j) and (i,i+j) BUT here it is (i+1,j) and (i,j+1)
 
Find the number of uniue paths in which the robot can reach destination (m,n) from (1,1) 

Question Source: http://www.careercup.com/question?id=5697293959299072
Solution Source: 
http://rleetcode.blogspot.com/2014/06/unique-paths-java.html
http://articles.leetcode.com/2010/11/unique-paths.html
 */

package Robot;

public class UniqueSteps {
	public static void main(String[] args) {
		System.out.println("The number of UNIQUE PATHS in which the robot can reach destination location (m,n)");
		System.out.println(recursiveBacktrack(1,1,5,8)); // where 1,1 is the start position and 5,8 is the destination position
		System.out.println(uniquePaths1(5, 8));
		System.out.println(uniquePaths2(5, 8));
	}
	 
	 /*
	 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

	 The robot can only move either down or right at any point in time. 
	 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

	 How many possible unique paths are there?
	 */
	  
	
	public static int recursiveBacktrack(int r, int c, int m, int n) {
		  if (r == m && c == n)
		    return 1;
		  if (r > m || c > n)
		    return 0;
		 
		  return recursiveBacktrack(r+1, c, m, n) + recursiveBacktrack(r, c+1, m, n);
		}
	
	
	 // 1 Dimensional DP
	
	     public static int uniquePaths1(int m, int n) { // where m,n is the destination position
	         if (m<0||n<0){
	             return 0;
	         }
	         if (m==0 || n==0 ){
	             return 1;
	         }
	         
	         int[] arr=new int[n];
	         arr[0]=1;                      // VERY IMP
	         
	         for (int i=0; i<m; i++)
	             for (int j=1; j<n; j++)                // VERY IMP
	                 arr[j]=arr[j]+arr[j-1];

	         return arr[n-1];
	 }
	 // 2 Dimensional DP
	
	     public static int uniquePaths2(int m, int n) { // where m,n is the destination position
	         if (m<0||n<0){
	             return 0;
	         }
	         if (m==0 || n==0 ){
	             return 1;
	         }
	         
	         int[][] matrix=new int[m][n];
	         for (int i=0; i<m; i++){			// VERY IMP
	             matrix[i][0]=1;
	         }
	         for (int i=0; i<n; i++){
	             matrix[0][i]=1;
	         }
	         
	         for (int i=1; i<m; i++){
	             for (int j=1; j<n; j++){
	                 matrix[i][j]=matrix[i-1][j]+matrix[i][j-1];        
	             }
	         }
	         
	         return matrix[m-1][n-1];
	         
	     }
	 
}
