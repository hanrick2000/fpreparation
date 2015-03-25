/*
Question: Given an array, find all UNIQUE THREE-MEMBER SUBSETS within the array
For Example: If the array is:
a = [4,8,2,8]
then [2,4,8], [2,8,8], [4,8,8] are unique subset WITH UNIQUE meaning that, [8,4,2] and [4,2,8] are the same set. 
Also the program should run faster than 2^n time

Question and Answer Source: http://www.careercup.com/question?id=16760663

IMP USEFUL RESOURCES:
https://interviewalgorithm.wordpress.com/sortingordering/median-of-medians-algorithm/
http://functionspace.org/articles/19
http://geekmeal.blogspot.com/2013/02/median-of-medians-algorithm.html
https://github.com/email4rohit/interview-java-algo/blob/master/MedianOfMedians.java

*/
package Array.UniqueThreeMemberSubset;

import java.util.Arrays;
import java.util.Scanner;

public class UsingAlgorithm {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
		System.out.println("Enter the number of elements in the array");
		int n = in.nextInt();
		int[] a = new int[n];
		System.out.println("Enter the elements of the array");
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		solve(a);
		}
		finally{
			in.close();
		}
	
	}
	public static void solve(int[] in){
		  Arrays.sort(in);
		  int N = in.length;
		  int count =0;                          // count for unique subsets
		  for(int i=0;i<N-2;i++){
		     if (i>0 && in[i]==in[i-1]) continue;
		     for(int j=i+1;j<N-1;j++){
		        if (j>i+1 && in[j]==in[j-1]) continue;
		        for(int k=j+1;k<N;k++){
		           if (k>j+1 && in[k]==in[k-1]) continue;
		           System.out.println(in[i]+","+in[j]+","+in[k]);
		           count++;
		        }
		    }
		  }
		  System.out.println("Total unique subsets are: "+count);
		}
	/*
	 * Analysis:
	 * Time Complexity = O(n^3)
	 * Space Complexity = O(1)
	 */
}
