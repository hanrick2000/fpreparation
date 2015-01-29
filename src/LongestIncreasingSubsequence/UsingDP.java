package LongestIncreasingSubsequence;

import java.util.Scanner;

public class UsingDP {
	   public static void main(String[] args){
		   
		   Scanner in = new Scanner(System.in);
		   try{
		    System.out.println("Enter the number of elements of the array");
		    int n = in.nextInt();
		    int[] a = new int[n];
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
		        
		        
		        for(int i=0;i<a.length;i++){
		            aux[i]=1 ;    // initialize the aux with 1 since the length of longest subsequence would atleast be 1
		            for(int j=0;j<i;j++){
		                if(a[i]>a[j])
		                    aux[i] = Math.max(aux[j]+1,aux[i]);                
		            }
		        }
		        
		        
		        
		        int max = 0;
		        for(int i=0;i<aux.length;i++)
		            if(aux[i]>max)
		                max = aux[i];
		        
		        return max;       
		    
		    }
}
/*
 * Analysis:
 * Time Eomplexity = O(n^2)
 * Space Complexity = O(n) used by the aux array
 */
