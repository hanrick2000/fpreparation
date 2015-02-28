/*
Question: SLIDING WINDOW SUM
	 Given a sequence of positive integers A and an integer T, return whether there is a continuous sequence of A that sums up to exactly T 
			Example 
			[23, 5, 4, 7, 2, 11], 20. Return True because 7 + 2 + 11 = 20 
			[1, 3, 5, 23, 2], 8. Return True because 3 + 5 = 8 
			[1, 3, 5, 23, 2], 7 Return False because no sequence in this array adds up to 7
			
Question Source: http://www.careercup.com/question?id=6305076727513088
*/

package SubstringAndSubsequenceProblems.Subsequence;

import java.util.Scanner;

public class SlidingWindowSumORContinuousSubsequenceSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			System.out.println("Enter the elements of the array");
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("Enter the sum");
			int target = in.nextInt();
			System.out.println("The sum is present continuously? "+isContinuousSubseqSum(a,target));
			System.out.println("Other Solution: The sum is present? "+findSum(a,target));
		}
		finally{
			in.close();
		}
	}

	private static boolean isContinuousSubseqSum(int[] a, int target) {
		if(a==null||a.length==0)
			return (target==0);
		
		// first pass: to calculate the sum
		int arraySum=0;
		for(int i:a)
			arraySum+=i;
		
		// second pass: check if deleting the values from left result in the sum
		int temp1 = arraySum;
		for(int i:a){
			temp1-=i;
			if(temp1==target)
				return true;
		}
		
		// third pass: check if deleting values from the right result in sum
		int temp2=arraySum;
		for(int i=a.length-1;i>=0;i--){
			temp2-=a[i];
			if(temp2==target)
				return true;
		}
		
		return false;
	}
	/*
	Analysis:
	Time Complexity = O(3n)
	Space Complexity = O(1)
	*/
	
	
	public static boolean findSum (int [] A ,int T){
		// Extreme Case
		if(A==null||A.length==0)
			return (T==0);
		
		
		int sum = 0 ;
		int j = 0;
		for (int i = 0 ; i < A.length ; i++) {
			// using while loop for sliding window
			while (j < A.length &&  sum < T) {
				sum += A[j] ;
				j++;
			}			
			if (sum == T)
				return true ;
			sum -= A[i] ;
		}
						
		return false ;
	}
	/*
	Analysis:
	Time Complexity = O(n)
	Space Complexity = O(1)
	*/
}
