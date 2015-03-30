/*
Question: Given some dollar value in cents (e.g. 200 = 2 dollars, 1000 = 10 dollars), 
find all the combinations of coins that make up the dollar value. 
There are only penny, nickel, dime, and quarter. (quarter = 25 cents, dime = 10 cents, nickel = 5 cents, 
penny = 1 cent)

For example, if 100 was given, the answer should be...
4 quarter(s) 0 dime(s) 0 nickel(s) 0 pennies
3 quarter(s) 1 dime(s) 0 nickel(s) 15 pennies
etc.
Question And Answer Source: http://stackoverflow.com/questions/1106929/find-all-combinations-of-coins-when-given-some-dollar-value
*/

package CoinDenominations;

import java.util.Arrays;

public class AllPossibleCombinationsUsingRecursion {

	public static void main(String[] args) {
		int[] denom = new int[]{1,5,10,25};
		int[] result = new int[denom.length];
		giveAllPossibleCombinationsrecursively(0, denom, 30, result);
	}
	 public static void giveAllPossibleCombinationsrecursively(int index, int[] denom,int amount,int[] result){
		 	// If amount is EXHAUSTED then PRINT,RETURN
		 	if(amount==0){
		        System.out.println(Arrays.toString(result));
		        return;
		    }
		    // If denominations are EXHAUSTED then RETURN
		    if(index == (denom.length))
		    	return;
		    // get the denominationAmount and find the coins required of this denomination
		    int currdenom = denom[index];
		    for(int i=0;i<=(amount/currdenom);i++){
		    	result[index] = i;
		    	giveAllPossibleCombinationsrecursively((index+1),denom,(amount-(i*currdenom)),result);
		    }
		 }
}
