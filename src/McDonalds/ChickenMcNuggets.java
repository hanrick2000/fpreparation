

/*
 * 
 * Question: McDonald’s sells Chicken McNuggets in packages of 6, 9 or 20 McNuggets. 
 * Thus, it is possible, for example, to buy exactly 15 McNuggets (with one package of 6 and a
 *  second package of 9), but it is not possible to buy exactly 16 McNuggets, since no non- negative 
 *  integer combination of 6's, 9's and 20's add up to 16. To determine if it is possible to buy exactly
 *   n McNuggets, one has to find non-negative integer values of a, b, and c such that 
6a+9b+20c=n 
Write a function, called McNuggets that takes one argument, n, and returns True if it 
is possible to buy a combination of 6, 9 and 20 pack units such that the total number of
 McNuggets equals n, and otherwise returns False. Hint: use a guess and check approach.

Question Source: http://www.careercup.com/question?id=14974673
 * 
Answer Source:
https://github.com/panfayang/python-fun-box/blob/master/McNuggets%20problem.py
https://github.com/Sanket11/Quiz-6.00.1x-MITx/blob/master/Problem%207
http://www.careercup.com/question?id=14974673

Solution Helpers:
https://www.youtube.com/playlist?list=PLATr4Ip40BjZRU-ASozN6fJz6OZtyYAAK

*/
package McDonalds;

import java.util.Arrays;
import java.util.Scanner;

public class ChickenMcNuggets {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Program to check VALID mcnugget number for packs of 6,9 and 20");
			System.out.println("Enter a number");
			int n = in.nextInt();
			System.out.println(usingFrobeniusNumbers(n));
			System.out.println(usingRecursion(n));
		}
		finally{
			in.close();
		}
	}
	private static boolean usingRecursion(int n) {  // This solution is recommended in interview
		return ((n>=0)   && 
				( n==0||n%6==0||n%9==0||n%20==0 ||usingRecursion(n-6)||usingRecursion(n-9)||usingRecursion(n-20))
				);
	}
	public static boolean usingFrobeniusNumbers(int n){
		if(n<0)
			return false;
		if(n>45)
			return true;
		
		boolean[] possibleMcNuggets = new boolean[46];
		
		// enter the 0 McNugget order as false
		possibleMcNuggets[0]=false;
		
		for(int i=0;i<46;i++){
			if(possibleMcNuggets[i]){
				if(i+6<46)
					possibleMcNuggets[i+6]=true;
				if(i+9<46)
					possibleMcNuggets[i+9]=true;
				if(i+20<46)
					possibleMcNuggets[i+20]=true;
			}
		}
		System.out.println(Arrays.toString(possibleMcNuggets));
		return possibleMcNuggets[n];
	}
}
/*
 * Analysis:
 * Time Complexity = O()
 * Space Complexity = O()
 */
