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
 
EXAMPLE:  If S=10 and S'=6. The lead could have changed 4 times: 

given an array which can score possible {0,2,3}

Final score is 10 : 6

FIRST WAY:
10:6
7:6
5:6
5:4
3:4
3:2         <--- Team starts from 3:2 is CORRECT since score possible {0,2,3}
1:2			<--- Team starts from 1:2 is INCORRECT since score possible {0,2,3}
1:0         <--- Team starts from 1:0 is INCORRECT since score possible {0,2,3}

SECOND WAY:
10:6
7:6
4:6
4:3
2:3         <---- Team starts from 2:3 is CORRECT since score possible {0,2,3}
2:1			<---- Team starts from 2:1 is INCORRECT since score possible {0,2,3}
0:1			<---- Team starts from 0:1 is INCORRECT since score possible {0,2,3}
VERY IMP NOTE: If you hand run the above, you will understand that the correct answer is 7 and not 4

Thus, correct answer is 4
*/
package LeadChange;


public class ComputeLeadChange {
	 
	 public static void main(String[] args){  
	  
	  //team a,b's final score
	  int S1=10;
	  int S2=6;

	  //possible score for each round
	  int[] scores={0,2,3};
	  System.out.println(count(scores,S1,S2));
	 }
	 
	// Correct Answer
		 // Source: https://codemeforever.wordpress.com/2014/11/12/count-lead-changes/
		 public static int count(int[] scores, int S1, int S2){
			 
		        int[][] dp=new int[S1+1][S2+1];  // create a DP array of scores
		        
		        for(int i = 0; i <= S1; i ++)
		            for(int j = 0; j <= S2; j ++)
		                dp[i][j] = -1;           // initialize all scores with -1
		        
		        dp[0][0] = 0;                    // initialize the start point as 0 score for both teams
		        
		        for(int i = 0; i <= S1; i ++){
		            for(int j = 0; j <= S2; j ++){
		                for(int k = 0; k < scores.length; k ++){
		                    int t1 = S1 - scores[k];    // team1 final score - current earn score1        
		                    int t2 = S2 - scores[k];    // team2 final score - current earn score2
		                    
		                    if(t1 >= 0){       			// score grater than or equal to 0
		                        int last = dp[t1][j]; 	// get the last score
		                         
		                        if(last != -1 && last > dp[i][j])   // if the last score is NOT -1 AND last score is greater than current score
		                            dp[i][j] = last;
		                        if(t1 <= j && i > j && last >= dp[i][j]){  // if the current score is less than or equal to  jth score && last score is >= current score and 
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
		 /*
		  * Analysis:
		  * Time Complexity = O(S1*S2*scores)
		  * Space Complexity = O(S1*S2)
		  */
	 
	 
	 
	 
/*
	 // INCORRECT ANS
	 // Source: http://ideone.com/RMVsXk
	 public static int incorrectCount(int[]scores, int OS1, int OS2) {
			
			int[][] R = new int[OS1+1][OS2+1];            // create a DP array of scores
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
							
							LEAD CHANGE CONDITION
							(team1 score < team 2score) && 
							(team1 score - current earn score1 >= team2 score - current earn score2)
							OR
							(team1 score > team 2score) && 
							(team1 score - current earn score1 <= team2 score - current earn score2)
							OR
							(team1 score == team 2score) && 
							(team1 score - current earn score1 != team2 score - current earn score2)
							OR
							(team1 score != team 2score) && 
							(team1 score - current earn score1 == team2 score - current earn score2)
							
							if ((S1 < S2 && S1-s1 >= S2-s2) || 
							    (S1 > S2 && S1-s1 <= S2-s2) ||
								(S1 == S2 && S1-s1 != S2-s2)|| 
								(S1 != S2 && S1-s1 == S2-s2)
								){
								R[S1][S2] = Math.max(R[S1][S2], 1+R[S1-s1][S2-s2]);
							}
							else {
								R[S1][S2] = Math.max(R[S1][S2], R[S1-s1][S2-s2]);
							}
						} // end of s2 for
					} // end of s1 for
				} // end of OS2 for
			} // end of OS1 for
			return R[OS1][OS2];
		}
	 
	  * Analysis:
	  * Time Complexity = O(S1*S2*scores*scores)
	  * Space Complexity = O(S1*S2)
	  
	 */
	 
	 
	}
