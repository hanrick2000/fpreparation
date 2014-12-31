package divideandconquer;

import java.util.Scanner;

public class KPalindromeString {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the string first and then the integer");
		String s = in.nextLine();
		int k = in.nextInt();
		if(KPalinString(s, k))
			System.out.println("YES");
		else
			System.out.println("NO");
		if(dynamicProgrammingSolution("abxa","axba",k) <= 2*k)
			System.out.println("YES");
		else
			System.out.println("NO");
	}
	finally{
		in.close();
	}
}
public static boolean KPalinString(String s, int k){
	if(s.length()==0 || s.length() == 1)
		return true;
	
	while(s.charAt(0)==s.charAt(s.length()-1)){
		s=s.substring(1,s.length()-1);
		
		if(s.length()==0 || s.length() == 1)// If the substring is decremented till the point where the length is 0 or 1, then return true
			return true;
	}
	 
	if(k==0)    // If there is a mismatch, then check if the k is already 0
		return false;
	
	return KPalinString(s.substring(0,s.length()-1), k-1) || KPalinString(s.substring(1,s.length()), k-1); // decrement the k and check for the remaining string leaving behind the character which led to the mis-matach
	
}

public static int dynamicProgrammingSolution (String s, String rev, int k){
	int n = s.length();
	
	int[][] dp = new int[n+1][n+1];
	for(int i=0;i<n;i++)
		dp[i][0]=dp[0][i]=i;
	
	for(int i=1;i<=n;i++){
		int from = Math.max(1, i-k);
		int to = Math.min(i+k, n);
		for(int j=from;j<=to;j++){
			if(s.charAt(i-1)==rev.charAt(j-1))
				dp[i][j] = dp[i-1][j-1];
			
			dp[i][j] = 	Math.min(Math.min(dp[i][j], 1 + dp[i][j-1]),1 + dp[i-1][j]); // delete character j
			
		}
	}
	return dp[n][n];	
}

}