/*
 * Question: Divide array into two subsets such that difference of sum of two sub sets is minimum,
 * 
 * Some times problem is asked in set different way: There are 22 players and each player has set value associated with him.
 * Divide them into two teams of eleven each, so that difference between overall values of teams is minimum.
 * 
 * Question and Answer Source: http://www.algorithmsandme.com/2014/04/balanced-partition-problem.html#.VRjXNN_0_VM
 * http://www.quora.com/What-are-the-top-10-most-popular-dynamic-programming-problems-among-interviewers
 * 
 * IMP Sources: https://www.youtube.com/watch?v=GdnpQY2j064
 * 
 * 
 */
package BalancedPartition;

public class MinDifferenceBetweenPartitions {
	public static void main(String[] args) {
		int a[] = {1,7,4,11};
		System.out.println("Min difference between two subsets: "+minSubsetDifference(a));
	}
	public static int minSubsetDifference(int[] set){
		 /*The value of subset[i][j] will be true if there is set subset 
		     of set[0..j-1] with sum equal to i */
		
				
		        int i,j;
		        int sum =0;
		 
		        for(i =0; i<=set.length-1; i++){
		                sum += set[i];
		        }
		 
		        boolean[][] subset=new boolean[sum+1][set.length-1+1];
		        // If sum is 0, then answer is true
		        for (i = 0; i <= set.length-1; i++)
		                subset[0][i] = true;
		 
		        // If sum is not 0 and set is empty, then answer is false
		        for (i = 1; i <= sum; i++)
		                subset[i][0] = false;
		 
		 
		        // Fill the subset table in bottom up manner
		        for (i = 1; i <= sum; i++)
		        {
		         for ( j = 1; j <= set.length-1 ; j++)
		         {
		           subset[i][j] = subset[i][j-1];
		           if (i >= set[j-1]){
		              subset[i][j] = subset[i][j] ||subset[i-set[j-1]][j-1];
		           }
		         }
		        }
		 
		        int min =Integer.MAX_VALUE;
		    
		        for(i=1; i<=sum; i++){
		           for(j=1; j<=set.length-1; j++){
		           /* If there is s subset with sum i, then check if the 
		              difference between overall sum and twice this sum is least or not.
		              If yes update the min */
		              
		              if(subset[i][j] == true){
		                   if(Math.abs(sum - 2*i) < min){
		                       min  = Math.abs(sum - 2 *i);
		                   }
		              }
		           }
		        }
		 
		        return min;
		}
	/*
	 * Analysis:
	 * Time Complexity = O(nN) where n = number of elements in the array and N = total sum of the array
	 * Space Complexity = O(nN) where n = number of elements in the array and N = total sum of the array 
	 */
}
