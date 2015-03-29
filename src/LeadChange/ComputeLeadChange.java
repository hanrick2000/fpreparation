/*
 * Question: 
 * Given an array of positive integers that represents possible points a team could score in an 

individual play.Now there are two teams play against each other.

Their final scores are S and S'. 

How would you compute the maximum number of times the team that leads could have changed? 



For example, if S=10 and S'=6. The lead could have changed 4 times: 



Team 1 scores 2, then Team 2 scores 3 (lead change); 2:3 

Team 1 scores 2 , Team 2 score 0 (lead change); 4:3

Team 1 scores 0, Team 2 scores 3 (lead change); 4:6

Team 1 scores 3, Team 2 scores 0 (lead change); 7:6

Team 1 scores 3, Team 2 scores 0 (no lead change)10:6

given an array which can score possible {0,2,3}

final score is 10 : 6

question is asking count the lead change 
 * 

 Question Source: http://www.careercup.com/question?id=5659765149532160
 
 Answer Source: http://www.javainterview.net/facebook/compute-lead-change
 
 Algorithm
//my approach is use a dynamic programming model

//BUT starting from the final score 

//KEY is to form a lead change condition at each round

//e.g: (team1 score > team 2score) &&

       (team1 score - current earn score1 < team2 score - current earn score2)
       
       
1. start from 10 : 6

2. screen the possible cases 0:0, 2:0, 3:0 , 0:2 , 2:2, 2:3, 3:0, 3:2, 3:3

   which will lead         10:6, 8:6, 7:6 , 10:4 , 8:4, 8:3, 7:6, 7:4, 7:3 

3. count lead change and move forward

4. start from 3 , but the starting score is the result form steps no 3

5. iterate above till either team reaches the final score recursive call

6. compare the max and return
 
 */


package LeadChange;

public class ComputeLeadChange {
	 
	 public static void main(String[] args){  
	  
	  //team a,b's final score
	  int a=10;
	  int b=6;

	  //possible score for each round
	  int[] p={0,2,3};
	  
	  //counter for lead change
	  int c=0;
	  
	  int m=solve(a,b,c,p);
	  
	  System.out.println(m);
	  
	 }
	 
	 static int solve(int a,int b,int c,int[] p){
	  
	  //both team scores meet the start
	  if(a==0 && b==0) return c;
	  //error , wrong caculation
	  else if(a <0 || b<0) return -1;

	  //maximum value of counter
	  int max=0;
	  
	  //iterate each combination
	  for(int i=0;i<p.length;i++){  
	   for(int j=0;j<p.length;j++){

	    int a1=p[i];
	    int b1=p[j];
	    
	    if(a1==0 && b1==0) continue;
	    
	    boolean leadChange=false;
	    
	    //condition if lead change occurs
	    if(
	     (
	      (a>b) && (a-a1<b-b1) && (a-a1>=0) && (b-b1>=0) && (a-a1!=1) && (b-b1!=1)
	      )
	      ||
	         (
	         (a<b) && (a-a1>b-b1) && (a-a1>=0) && (b-b1>=0) && (a-a1!=1) && (b-b1!=1)
	         )        
	       ){
	     
	     leadChange=true;              
	    }
	    //move to next score case
	    int x=solve(a-a1,b-b1,c+(leadChange?1:0),p);
	    
	    if(x>max)
	     max=x;    
	   }
	  }

	  return max;  
	 }
	}
