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

public class UsingRecursion {

	public static void main(String[] args) {
		int[] denom = new int[]{1,5,10,25};
		int[] vals = new int[denom.length];
		printAll(0, denom, 30, vals);
	}
	 public static void printAll(int ind, int[] denom,int N,int[] vals){
		    if(N==0){
		        System.out.println(Arrays.toString(vals));
		        return;
		    }
		    if(ind == (denom.length))
		    	return;             
		    int currdenom = denom[ind];
		    for(int i=0;i<=(N/currdenom);i++){
		        vals[ind] = i;
		        printAll(ind+1,denom,N-i*currdenom,vals);
		    }
		 }
}
