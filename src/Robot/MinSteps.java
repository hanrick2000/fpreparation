/*
Question: A robot has to move in a grid which is in the form of a matrix. It can go to 
1.) A(i,j)--> A(i+j,j) (Down) 
2.) A(i,j)--> A(i,i+j) (Right) 

Given it starts at (1,1) and it has to go to A(m,n), find the minimum number of STEPS it has to take to get to (m,n) and write 
public static int minSteps(int m,int n) 

For instance to go from (1,1) to m=3 and n=2 it has to take (1, 1) -> (1, 2) -> (3, 2) i.e. 2 steps

Question and Answer Source: http://www.careercup.com/question?id=5697293959299072

Explanation Source: 
http://rleetcode.blogspot.com/2014/06/unique-paths-java.html
http://articles.leetcode.com/2010/11/unique-paths.html

*/

package Robot;

public class MinSteps {
	public static void main(String[] args) {
		System.out.println(minSteps(5, 8));
		System.out.println(uniquePaths(5, 8));
		System.out.println(uniquePaths1(5, 8));
		System.out.println(uniquePaths2(5, 8));

		
		System.out.println("--------------------");
		
		System.out.println(minSteps(2,3));
		System.out.println(uniquePaths(2,3));
		
		
		System.out.println(minSteps(5,8));
		System.out.println(uniquePaths(5, 8));
		
	}
	public static int minSteps(int m, int n)
	
	/*
	 * There is only one way to get to (m,n). 
	 * If m>n, robot must come from (m-n,n). Otherwise comes from (m, n-m). So Here is my code
	 */
	{
		if(m<1 || n <1) 
			return -1;
		int count = 0;
		while(Math.abs(m-n)>0 && m>=1 && n>=1)
		{
			if(m>n)
				m=m-n;
			else n = n-m;
			count++;
		}
		if(m==1 && n==1)
			return count;
		else 
			return -1;
	}
	
	 public static int uniquePaths ( int m, int n) {
         int[][] dp =new int[m][n];
         // initialize dp, mx 1 for 1 whole situation 
        for ( int i = 0 ; i <m; i ++) {
            dp[i][0] = 1;
        }

        // Initialize dp, 1 xn whole situation is 1 
        for ( int j = 0 ; j <n; j ++) {
            dp[0][j] = 1;
        }

        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
	 
	 
	 /*
	 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

	 The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

	 How many possible unique paths are there?



	 */
	  
	 // 1D DP
	
	     public static int uniquePaths1(int m, int n) {
	         if (m<0||n<0){
	             return 0;
	         }
	         if (m==0 || n==0 ){
	             return 1;
	         }
	         
	         int[] arr=new int[n];
	         arr[0]=1;
	         
	         for (int i=0; i<m; i++){
	             for (int j=1; j<n; j++){
	                 arr[j]=arr[j]+arr[j-1];
	             }
	         }
	         
	         return arr[n-1];
	         
	         
	     
	 }
	 // 2D DP
	
	     public static int uniquePaths2(int m, int n) {
	         if (m<0||n<0){
	             return 0;
	         }
	         if (m==0 || n==0 ){
	             return 1;
	         }
	         
	         int[][] matrix=new int[m][n];
	         for (int i=0; i<m; i++){
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
