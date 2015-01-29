package LongestIncreasingSubsequence;

import java.util.Scanner;

public class UsingRecursion {
	 public static void main(String[] args){
		   
		   Scanner in = new Scanner(System.in);
		   try{
		    System.out.println("Enter the number of elements of the array");
		    int n = in.nextInt();
		    int[] a = new int[n];
		    System.out.println("Enter the elements of the array");
		    for(int i=0;i<n;i++)
		        a[i]= in.nextInt();
		        
		    System.out.println("The length of longest increasing subsequence of the array is: "+usingRecursionSolution(a,a.length));
		    
		   }
		   finally{
			   in.close();
		   }
		   }

	
	 public static int usingRecursionSolution(int[] a, int n){
	       
		 if(a.length==0 || a==null)
	    		return -1;
		 
		 int maxDiff=1; // the maxDifference would at least be 1
	       
	     return usingRecursionSolution(a,n,maxDiff);
	        
	    }
	    private static int usingRecursionSolution(int[] a, int n, int maxDiff) {
	    	if(n==1)
	            return 1;
	            
	        int res=1;
	        int maxEnding = 1;
	        
	        for(int i=1;i<n;i++){
	            res = usingRecursionSolution(a,i,maxDiff);
	            if(a[n-1] > a[i-1])
	                maxEnding = Math.max(maxEnding, res+1);
	        }
	        
	        if(maxEnding>maxDiff)
	            maxDiff = maxEnding;
	        
	        return maxDiff;
	    }
	    /*
	    Analysis:
	    Time Complexity = O(n^2)
	    Space Complexity = O(1)
	    */
}
