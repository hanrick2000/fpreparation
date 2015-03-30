/*
 * Question: There are n houses built in a line, each of which contains some value in it. 
 * A thief is going to steal the maximal value in these houses, but he cannot steal in two adjacent 
 * houses because the owner of a stolen house will tell his two neighbors on the left and right side.
 * What is the maximal stolen value?
 * 
 * Question Source: http://codercareer.blogspot.com/2013/02/no-44-maximal-stolen-values.html
 * 
 * Example: 
 * int[] value={6,1,3,7,2};
 * Output: 13
 */

package Thief;

public class MaxStolenValueUsingDP {
	public static void main(String[] args) {
		int[] value={6,1,3,7,2};
		int[] table=sol(value);
		System.out.println(table[value.length-1]);
	}
	public static int[] sol(int[] value){
		int[] table = new int[value.length];
		int len=value.length;	
		//initialization
		table[0]=value[0];
		if(len==1) 
			return table;

		if(value[0]>value[1])
			table[1]=value[0];
		else
			table[1]=value[1];

		if(len==2) 
			return table;
		
		if(len>2){
			for(int i=2; i<len; i++){
				if( (value[i]+table[i-2]) > table[i-1]){
					table[i]=value[i]+table[i-2];
				}
				else
					table[i]=table[i-1];
			}
		}
		return table;
	}
}
