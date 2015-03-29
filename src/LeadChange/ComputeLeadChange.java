/*
 * Question: 
Given an array of positive integers that represents possible points a team could score in an 
individual play.Now there are two teams play against each other.
Their final scores are S and S'. 
Given an array which can score possible {0,2,3}
How would you compute the maximum number of times the team that leads could have changed? 

Question Source: http://www.careercup.com/question?id=5659765149532160
 
Answer Source: 
http://ideone.com/RMVsXk                                                   <---- Gives answer 7
https://codemeforever.wordpress.com/2014/11/12/count-lead-changes/         <---- Givers answer 4
 
Example:  If S=10 and S'=6. The lead could have changed 4 times: 

given an array which can score possible {0,2,3}

final score is 10 : 6

Team 1 scores 2, then Team 2 scores 3 (lead change); 2:3 

Team 1 scores 2 , Team 2 score 0 (lead change); 4:3

Team 1 scores 0, Team 2 scores 3 (lead change); 4:6

Team 1 scores 3, Team 2 scores 0 (lead change); 7:6

Team 1 scores 3, Team 2 scores 0 (no lead change)10:6


VERY IMP NOTE: If you hand run the above, you will understand that the correct answer is 7 and not 4

*/


package LeadChange;


public class ComputeLeadChange {
	 
	 public static void main(String[] args){  
	  
	  //team a,b's final score
	  int S1=10;
	  int S2=6;

	  //possible score for each round
	  int[] scores={0,2,3};
	  System.out.println(properCount(scores,S1,S2));
	  System.out.println(count(scores,S1,S2));
	 }

	 // This method returns the count 7 (which I think is correct)
	 // Source: http://ideone.com/RMVsXk
	 public static int properCount(int[]scores, int OS1, int OS2) {
			
			int[][] R = new int[OS1+1][OS2+1];
			for (int S1 = 0; S1 <= OS1; ++S1) {
				for (int S2 = 0; S2 <= OS2; ++S2) {
					for (int s1 : scores) {
						if (s1 > S1) {
							continue;
						}
						for (int s2 : scores) {
							if (s1 == s2 || s2 > S2) {
								continue;
							}
							if ((S1 < S2 && S1-s1 >= S2-s2) || (S1 > S2 && S1-s1 <= S2-s2) ||
								(S1 == S2 && S1-s1 != S2-s2) || (S1 != S2 && S1-s1 == S2-s2)) {
								R[S1][S2] = Math.max(R[S1][S2], 1+R[S1-s1][S2-s2]);
							}
							else {
								R[S1][S2] = Math.max(R[S1][S2], R[S1-s1][S2-s2]);
							}
						}
					}
				}
			}
			return R[OS1][OS2];
		}
	 
	 
	 
     // This method returns the count 4 (which I DON't think is correct)
	 // Source: https://codemeforever.wordpress.com/2014/11/12/count-lead-changes/
	 public static int count(int[] scores, int S1, int S2){
		 
	        int[][] dp=new int[S1+1][S2+1];
	        
	        for(int i = 0; i <= S1; i ++)
	            for(int j = 0; j <= S2; j ++)
	                dp[i][j] = -1;
	        
	        dp[0][0] = 0;
	        
	        for(int i = 0; i <= S1; i ++){
	            for(int j = 0; j <= S2; j ++){
	                for(int k = 0; k < scores.length; k ++){
	                    int t1 = S1 - scores[k];   // team1 score - current earn score1        
	                    int t2 = S2 - scores[k];   // team1 score - current earn score1
	                    if(t1 >= 0){
	                        int last = dp[t1][j];
	                         
	                        if(last != -1 && last > dp[i][j])
	                            dp[i][j] = last;
	                        if(t1 <= j && i > j && last >= dp[i][j]){
	                            dp[i][j] = last + 1;
	                        }
	                    }
	                    if(t2 >= 0){
	                        int last = dp[i][t2];
	                         
	                        if(last != -1 && last > dp[i][j])
	                            dp[i][j] = last;
	                        if(t2 <= j && i > j && last >= dp[i][j]){
	                            dp[i][j] = last + 1;
	                        }
	                    }
	                }
	            }
	        }
	        return dp[S1][S2];
	    }
	}
