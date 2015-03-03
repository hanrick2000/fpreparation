package SubstringAndSubsequenceProblems.Subsequence;

	/*
	Question: Find the Minimum Number of Insertions required to form a palindrome

	Question and Answer Source: http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/

	Algorithm:

		I. Using Recursion
			This problem can be subdivided into THREE subproblems:
				Let the input string be str[l……h]. The problem can be broken down into three parts:
					1. Find the minimum number of insertions in the substring str[l+1,…….h].
					2. Find the minimum number of insertions in the substring str[l…….h-1].
					3. Find the minimum number of insertions in the substring str[l+1……h-1].
		   Recursive Solution
		   The minimum number of insertions in the string str[l…..h] can be given as:
					minInsertions(str[l+1…..h-1]) if str[l] is equal to str[h]
					(min {minInsertions(str[l…..h-1]), minInsertions(str[l+1…..h])}  +  1) otherwise
		
	
		*/


	import java.util.Scanner;

	public class MinInsertionsReqToFormPalindrome {
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			try{
				System.out.println("Program to find the MIN INSERTIONS REQ FOR FORMING PALINDROME");
				System.out.println("Enter the string");
				String orig = in.nextLine();
				
				// Using DP algorithm of Longest Palindrome Subsequence
				StringBuilder rev = new StringBuilder();
				for(int i=orig.length()-1;i>=0;i--)
					rev.append(orig.charAt(i));
				System.out.println("The MIN INSERTIONS REQ FOR FORMING PALINDROME "
						+ "using LONGEST PALINDROME SUBSEQUENCE ALGORITHM is: "+usingLongestPalinSubSequence(orig,rev.toString()));
		
				
				// Using Dynamic Programming Table
				System.out.println("The MIN INSERTIONS REQ FOR FORMING PALINDROME "
						+ "using DYNAMIC PROGRAMMING TABLE is: "+usingDPTable(orig));
				
				// Using Recursion. DONOT GIVE THIS SOLUTION IN INTERVIEW SINCE DP SOLUTIONS EXISTS WHICH ARE BETTER THAN RECURSION SOLUTION
				
				System.out.println("The MIN INSERTIONS REQ FOR FORMING PALINDROME "
						+ "using RECURSION is: "+usingRecursion(orig,0,orig.length()-1));
				
				
			}
			finally{
				in.close();
			}
		}




		private static int usingLongestPalinSubSequence(String orig, String rev) {
			return (orig.length() - usingLPSubSequenceAlgorithm(orig,rev));
		}

		private static int usingLPSubSequenceAlgorithm(String orig, String rev) {
			
			/*
			 * Algorithm Source: http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
			 *
			 *III. Using (by Dynamic Programming) LONGEST PALINDROME SUBSEQUENCE Algorithm
			Find the length of  LONGEST PALINDROME SUBSEQUENCE between original and reverse string
			Now the Minimum Number of Insertions required to form a palindrome = Original String length - length of  LONGEST PALINDROME SUBSEQUENCE
		
			 */
			
			
			int[][] dp = new int[orig.length()+1][rev.length()+1]; // +1 to store the previous matches
			
			// fill the 0th row
			for(int i=0;i<(orig.length()+1);i++)
				dp[i][0] = 0;
			
			// fill the 0th column
			for(int j=0;j<(rev.length()+1);j++)
				dp[0][j] = 0;
			
			int result = 0; // stores the length of longest palindrome SUBSEQUENCE
			
			// fill the remaining rows and columns
			for(int i=1;i<(orig.length()+1);i++){
				for(int j=1;j<(rev.length()+1);j++){
					
					if(orig.charAt(i-1)==rev.charAt(j-1))
						dp[i][j] = dp[i-1][j-1]+1;
					
					else
						dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
					
					result = Math.max(result,dp[i][j]);
					
				}
			}
			return result;
			
		}
		/*
		 * Analysis:
		 * Time Complexity = O(n^2)
		 * Space Complexity = O(n^2)
		 */
		
		
		private static int usingDPTable(String s) {
			
			/*
			 * Algorithm Source: http://www.geeksforgeeks.org/dynamic-programming-set-28-minimum-insertions-to-form-a-palindrome/
			 *
			 *	II. Using Dynamic Programming
		The table should be filled in diagonal fashion. 
		For the string abcde, 0….4, the following should be order in which the table is filled:

			Gap = 1:
			(0, 1) (1, 2) (2, 3) (3, 4)

			Gap = 2:
			(0, 2) (1, 3) (2, 4)

			Gap = 3:
			(0, 3) (1, 4)

			Gap = 4:
			(0, 4)
		
			
			// Fill the table
	    for (gap = 1; gap < n; ++gap)
	        for (l = 0, h = gap; h < n; ++l, ++h)
	            table[l][h] = (str[l] == str[h])? table[l+1][h-1] :
	                          (min(table[l][h-1], table[l+1][h]) + 1);
	 
	    // Return minimum number of insertions for str[0..n-1]
	    return table[0][n-1];
			
			 */
			
			int[][] dpMatrix = new int[s.length()][s.length()];  // dp matrix of exactly the same length
			
			int low = 0;
			int high = 0;
			
			int gap = 0;
			
			// Fill the table
			for(gap = 1 ; gap < s.length() ; gap++)
				
				for(low=0,high=gap ; high < s.length() ; low++,high++)
					
					dpMatrix[low][high] = (
							             (s.charAt(low)==s.charAt(high)) ? 
							             (dpMatrix[low+1][high-1])   :  // reduce the search space
							             (Math.min(dpMatrix[low+1][high], dpMatrix[low][high-1])+1)// reduce the search space
							             );
			
			
			return dpMatrix[0][s.length()-1]; // Return minimum number of insertions for str[0..n-1]
						
		}
		
		/*
		 * Analysis:
		 * Time Complexity = O(n^2)
		 * Space Complexity = O(n^2)
		 */
		
		

		private static int usingRecursion(String s, int low, int high) {
			
			// We have THREE BASE CASES
			if(low > high)
				return Integer.MAX_VALUE;
			
			if(low==high)  // 1 character is present in the string
				return 0; // return 0 because 1 character itself is palindrome, hence no insertions required to form palindrome
			
			if(low==high-1) // 2 characters are present in the string
				return (s.charAt(low)==s.charAt(high) ? 0 : 1); //if both the characters are EQUAL then 0 otherwise 1 insertion required to form palindrome
					
			return ((s.charAt(low)==s.charAt(high))  ?
					(usingRecursion(s,low+1,high-1)) :  // reduce the search space
				    (Math.min(usingRecursion(s,low+1,high),usingRecursion(s, low, high-1))+1) // reduce the search space
	  				);
		}
		/*
		 * Analysis:
		 * Time Complexity = O()
		 * Space Complexity = O()
		 */
	}

