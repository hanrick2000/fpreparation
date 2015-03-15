/*
Question: Given dividend and divisor, return the quotient without using / operator
Solution Source: 
	http://www.careercup.com/question?id=5647672717344768
	http://www.prasannatech.net/2009/01/division-without-division-operator_24.html
		
ALGORITHM:
	For the sake of completeness, I would like to highlight the algorithm, which is quite simple. 
	Before that one should understand some basics of bit shifting.

1. Left shifting an unsigned number by 1 multiplies that number by 2.
2. Right shifting an unsigned number by 1 divides that number by 2.

Therefore the procedure for the division algorithm, given a dividend and a divisor would be to 
left shift (multiply by 2) the divisor till it reaches dividend/2, then continue this routine with the 
difference between the dividend and divisor and divisor till the point where dividend is less than divisor 
or their difference is zero. This is similar to finding an element in a sorted list using the binary search 
algorithm, the Java code is furnished below.
	
	
VERY IMP NOTE: With modifications in the main method as mentioned in the below program,
the program does work for negative numbers also.
*/
package DivideTwoNumbersWithoutUsingDivisionOperator;

import java.util.Scanner;

public class UsingShiftOperators {
	static int divident;
	static int divisor;
	static int remainder;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the divident and divisor respectively");
			System.out.println("Works for both negative and positive numbers of divident and divisor");
			divident = in.nextInt();
			divisor = in.nextInt();
			int ans = divide(divident,divisor);
			System.out.println(ans);
		}
		finally{
			in.close();
		}
	}
	
	
	
	/*
	 * Analysis:
We can keep subtract divisor from dividend until dividend is smaller than 0, than count the subtract numbers.
 But it will costs a very long time if the divisor is very small comparing to dividend.

Shift can be used to solve this problem. We shift the divisor left until it just smaller than dividend but 
if we keep shifting one more bit, it’s larger than dividend. Than we can add the shifted value to the result
 and subtract the shifted value from dividend. Keep doing this until dividend is smaller than divisor. 
 In fact, every integer can be represented by a set of base 2 so that shifting can be used.

One thing needs to be mentioned is that we need to convert the integer to long type. Otherwise the Math.abs() 
value of Integer.MIN_VALUE will be quite strange.
	 */
	
	
	 // Source: http://www.lifeincode.net/programming/leetcode-divide-two-integers-java/
	
	 public static int divide(int dividend, int divisor) {
	        long tempDivident = Math.abs((long)dividend);
	        long tempDivisor = Math.abs((long)divisor);
	        
	        int ret = 0;
	        while (tempDivident >= tempDivisor) {
	            int counter = 0;
	            while (tempDivident >= (tempDivisor << counter)) {
	                counter++;
	            }
	            ret += 1 << (counter - 1);
	            tempDivident -= tempDivisor << (counter - 1);
	        }
	        
	        // compare the arguments passed in this method
	        if (dividend == Integer.MIN_VALUE && divisor == -1)
	            return Integer.MAX_VALUE;
	            
	        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0))
	            return ret;
	        else
	            return -ret;
	    }
	 /*Analysis:
	    If n = dividend and m = divisor, then
		Time Complexity = O(lgn) where n = dividend
		Space Complexity = O(1)
	*/
	
	
	
	
	
	
	
	
/*
	private static int getQuotient(int tempDivident, int tempDivisor) {
	
		int quotient = 1;
		
		if(tempDivisor==tempDivident){
			remainder = 0;
			return 1;
		}
		if(tempDivisor > tempDivident){
			remainder = tempDivident;
			return 0;
		}
		
		while(tempDivident >= tempDivisor){
			 Here divisor <> divisor and quotient 
			tempDivisor=tempDivisor<<1;     // Multiply by 2
			quotient=quotient<<1;           
		}
		
		 We have reached the point where divisor > dividend, therefore divide divisor and quotient by 2 
		tempDivisor=tempDivisor>>1;         // Divide by 2
		quotient=quotient>>1;

		 Call division recursively for the difference to get the exact quotient 
		return quotient+getQuotient(tempDivident-tempDivisor, divisor);
		
	}
	Analysis:
    If n = dividend and m = divisor, then
	Time Complexity = O(lgn) where n = dividend
	Space Complexity = O(1)

	*/
	


}
