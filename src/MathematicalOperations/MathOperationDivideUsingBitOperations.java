package MathematicalOperations;

import java.util.Scanner;

public class MathOperationDivideUsingBitOperations {
	
	
	static int divident;
	static int divisor;
	static int remainder;
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the divident and divisor respectively");
			divident = in.nextInt();
			divisor = in.nextInt();
			int ans = getQuotient(Math.abs(divident),Math.abs(divisor));
			if((divident>0&&divisor>0)||(divident<0&&divisor<0))
				System.out.println(ans);
			else if(((divident>0&&divisor<0)||(divident<0&&divisor>0)))
				System.out.println(-ans);
		}
		finally{
			in.close();
		}
	}
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
			/* Here divisor <> divisor and quotient */
			tempDivisor=tempDivisor<<1;     // Multiply by 2
			quotient=quotient<<1;           
		}
		
		/* We have reached the point where divisor > dividend, therefore divide divisor and quotient by 2 */
		tempDivisor=tempDivisor>>1;         // Divide by 2
		quotient=quotient>>1;

		/* Call division recursively for the difference to get the exact quotient */
		return quotient+getQuotient(tempDivident-tempDivisor, divisor);
		
	}
}
/*Analysis:
If n = dividend and m = divisor, then
Time Complexity = O(lgn) where n = dividend
Space Complexity = O(1)
*/
