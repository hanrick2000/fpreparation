/*
 * Question: There are n houses built in a line, each of which contains some value in it. 
 * A thief is going to steal the maximal value in these houses, but he cannot steal in two adjacent 
 * houses because the owner of a stolen house will tell his two neighbors on the left and right side.
 * What is the maximal stolen value?
 * 
 * Question Source: http://codercareer.blogspot.com/2013/02/no-44-maximal-stolen-values.html
 * 
 * Example: 
 * int[] values={6,1,3,7,2};
 * Output: 13
 */

package Thief;

public class MaxStolenValueUsingDP {
	public static void main(String[] args) {
		int[] values={6,1,3,7,2};
		int[] table=usingDP(values);
		System.out.println("Maximum value that can be stolen is: "+table[values.length-1]);
	}
	public static int[] usingDP(int[] values){
		int[] table = new int[values.length];
		int len=values.length;	
		//initialization
		table[0]=values[0];
		if(len==1) 
			return table;

		if(values[0]>values[1])
			table[1]=values[0];
		else
			table[1]=values[1];

		if(len==2) 
			return table;
		
		if(len>2){
			for(int i=2; i<len; i++){
				if( (values[i]+table[i-2]) > table[i-1]){       // thief can take from non-adjacent houses
					table[i]=values[i]+table[i-2];
				}
				else
					table[i]=table[i-1];
			}
		}
		return table;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n) where n = length of values array
	 * Space Complexity = O(n) where n = length of values array
	 */
}
