

/*
 * Question: Find the length of the longest INCREASING subsequence in an array
 * 
Solution Source: http://www.geeksforgeeks.org/dynamic-programming-set-3-longest-increasing-subsequence/
https://www.youtube.com/watch?v=U-xOVWlcgmM
http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
http://robentan.blogspot.com/2011/11/more-efficient-algorithm-for-longest.html
http://stackoverflow.com/questions/6129682/longest-increasing-subsequenceonlogn


 */

package LongestIncreasingSubsequence;


import java.util.Scanner;

public class UsingDP {
	   public static void main(String[] args){
		   
		   Scanner in = new Scanner(System.in);
		   try{
		    System.out.println("Enter the number of elements of the array");
		    int n = in.nextInt();
		    int[] a = new int[n];
		    System.out.println("BOTH DP and NlgN algorithm, only calculates the "+
		    		"longest increasing subsequence LENGTH but does not give the ACTUAL "+
		    		"ELEMENTS of longest increasing subsequence");
		    System.out.println("Enter the elements of the array");
		    for(int i=0;i<n;i++)
		        a[i]= in.nextInt();
		        
		    System.out.println("The length of longest increasing subsequence of the array is: "+longestIncreasingSubsequence(a));
		    
		   }
		   finally{
			   in.close();
		   }
		   }
		    public static int longestIncreasingSubsequence(int[] a){
		    
		    	if(a.length==0 || a==null)
		    		return -1;
		    	
		        int[] aux = new int[a.length];
		        
		        
		        
		        for(int i=0;i<a.length;i++)                                      //VERY VERY IMP
		        	a[i]=1;   // The LIS would be atleast one for every individual array element
		        
		        for(int i=0;i<a.length;i++){
		            for(int j=0;j<i;j++){
		                if(a[i]>a[j])
		                    aux[i] = Math.max(aux[j]+1,aux[i]);        // current=max(previous+1,current)
		            }
		        }
		        
		        
		        // System.out.println(Arrays.toString(aux));
		        
		        int max = 0;
		        for(int i=0;i<aux.length;i++)
		            max = Math.max(aux[i], max);
		        
		        return max;       
		    
		    }
}
/*
 * Analysis:
 * Time Eomplexity = O(n^2)
 * Space Complexity = O(n) used by the aux array
 */
