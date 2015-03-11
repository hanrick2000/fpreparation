/*
Question: A k-palindrome is a string which transforms into a palindrome on removing at most k characters. 

Given a string S, and an integer K, print "YES" if S is a k-palindrome; otherwise print "NO". 
Constraints: 
S has at most 20,000 characters. 
0<=k<=30 

Sample Test Case#1: 
Input - abxa 1 
Output - YES 
Sample Test Case#2: 
Input - abdxa 1 
Output - No

Question and Answer Source: http://www.careercup.com/question?id=6287528252407808
http://ajeetsingh.org/2013/08/29/algorithm-to-verify-a-string-for-k-palindrome-with-on-compexity/

*/
package String.KPalindromeString;
import java.util.Scanner;

public class KPalindromeString {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the string first and then the integer");
		String s = in.nextLine();
		int k = in.nextInt();
		if(usingRecursion(s, k))
			System.out.println("YES");
		else
			System.out.println("NO");
		
		
		StringBuilder rev = new StringBuilder();
		for(int i=s.length()-1;i>=0;i--)
			rev.append(s.charAt(i));
	
		if(editDistance(s,k))
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	finally{
		in.close();
	}
}
public static boolean editDistance(String source, int k){
    int n= source.length();
    int[][] distance=new int[n+1][n+1];   // Row and column are the SAME
    for(int i=0;i<=n;i++)
        distance[i][0]=i;
    
    for(int j=0;j<=n;j++)
        distance[0][j]=j;
    
    /*
     * TR: 
     * (i-1) == (n-j) Comparison
     */
    
    for(int i=1;i<=n;i++){ 
      for(int j=1;j<=n;j++){ 
    	  // Substitution
        if(source.charAt(i-1)==source.charAt(n-j)) // TR: Compare the FIRST and LAST character   i.e.(i-1 == n-j)
            distance[i][j]=distance[i-1][j-1];
        else // Insertion and Deletion
            distance[i][j]= Math.min((distance[i-1][j]+1),(distance[i][j-1]+1));
      }
    }
    return(k<=distance[n][n]/2);   // returns boolean value
  }
/*
 * Analysis:
 * Time Complexity = O(n^2)
 * Space Complexity = O(n^2)
 */

public static boolean usingRecursion(String s, int k){
	/*
	 * Definition: A k-palindrome is a string which transforms into a palindrome on REMOVING AT MOST K characters.
	 * 
	 *  WE NEED TO CHECK FOR 4 CONDITIONS:
	 *  1. Extreme case
	 *  2. while loop
	 *  3. k==0
	 *  4. Remove first/last character
	 */
	
	// 1. Extreme Case
	if(s.length()==0 || s.length() == 1)
		return true;
	
	// 2. WHILE LOOP of palindrome check
	while(s.charAt(0)==s.charAt(s.length()-1)){  // since start and end chars are equal hence no need to decrement k
		s=s.substring(1,s.length()-1);
		
		if(s.length()==0 || s.length() == 1) // If the substring is decremented till the point where the length is 0 or 1, then return true
			return true;
	}
	 
	// 3. Check on k
	if(k==0)    // If there is a mismatch, then check if the k is already 0
		return false;
	
	// 4. Remove the first OR Remove the last character
	return usingRecursion(s.substring(0,s.length()-1), k-1) || usingRecursion(s.substring(1,s.length()), k-1);
	// decrement the k and check for the remaining string leaving behind the character which led to the mis-matach
	
	}
}
/*
 * Analysis:
 * Time Complexity = O(n^2)
 * Space Complexity = O(n^2)
 */





/*
public static int dynamicProgrammingSolution (String s, String rev, int k){  // INVALID - GIVES WRONG ANSWERS. DONOT FOLLOW THIS
	
	
	
	 * Algorithm:
The question asks if we can transform the given string S into its reverse deleting at most K letters.
 
We could modify the traditional Edit-Distance algorithm, considering only deletions, and check if 
this edit distance is < 2K. There is a problem though. S can have length = 20,000 and the 
Edit-Distance algorithm takes O(N^2). Which is too slow. 

(From here on, I'll assume you're familiar with the Edit-Distance algorithm and its DP matrix) 

However, we can take advantage of K. We are only interested to delete K letters. 
This means that any position more than K positions away from the main diagonal is useless because 
its edit distance must exceed those K deletions. 

Since we are comparing the string with its reverse, we will do at most K deletions 
and K insertions (to make them equal). Thus, we need to check if the ModifiedEditDistance is <= 2*K 

Since in this algorithm, we are making the string and its reverse equal. THEY BOTH HAVE
N CHARACTERS SO IF WE REMOVE K CHARACTERS, WE NEED TO INSERT K CHARACTERS SO AS TO 
MAINTAIN SIZE = N.

The correspondence between characters inserted and deleted is done because we're transforming 
the input string into its reverse AND DOING NOTHING TO THE REVERSE STRING because Edit Distance
Algorithm only modifies one string out of the given two strings in input.
So those operations will lead to a palindrome. 

"You can do (1 insertion + 1 deletion)*n times, and you will still be in the main diagonal" 
Sure, but the cost will be 2*N. As explained above, the final step is to compare DP[N][N] with 2*K. 
only then we decide the answer.

Here's the code:
	 
	
	
	
	int i,j,n=s.length();
	
	int[][] dp = new int[n+1][n+1];
	// INVALID - GIVES WRONG ANSWERS. DONOT FOLLOW THIS
	
	for (i = 0 ; i < n; i++)
		dp[i][0] = dp[0][i] = i;

	for (i = 1; i <= n; i++) {
		int from = Math.max(1, i-k), to = Math.min(i+k, n);
		for (j = from; j <= to; j++) {
			if (s.charAt(i-1) == rev.charAt(j-1))			// same character
				dp[i][j] = dp[i-1][j-1];	
			// note that we don't allow letter substitutions
			
			dp[i][j] = Math.min(dp[i][j], 1 + dp[i][j-1]); // delete character j
			dp[i][j] = Math.min(dp[i][j], 1 + dp[i-1][j]); // insert character i
		}
	}
	return dp[n][n];
	}
}

 * Analysis:
 * We only process (2*K+1) columns per row. So this algorithm works in O(N*K) which is fast enough.
 * Time Complexity = O(NK)
 * Space Complexity = O(N^2)
 
*/