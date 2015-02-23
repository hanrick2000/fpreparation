/*
Write your own Power without using multiplication(*) and division(/) operators
Source: http://www.geeksforgeeks.org/write-you-own-power-without-using-multiplication-and-division/
*/
package MathematicalOperations;

/*
 * We have 3 approaches to calculate power
 * 
 * 1. Dynamic Programming -> Time Complexity = O(lgn), Space Complexity = O(1) -> Using % and / operators
 * 2. Iterative Approach  -> Time Complexity = O(b*a), Space Complexity = O(1) -> Without using * and / operators
 * 3. Recursive Approach  -> Time Complexity = O(b^2), Space Complexity = O(1) -> Without using * and / operators
 */


import java.util.Scanner;

public class CalculatePowerWithoutUsingMultiplicationAndDivisionOperators {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the two number to calculate the power in the form a^b repectively");
		System.out.println("Only positive numbers should be entered");
		int a = in.nextInt();
		int b = in.nextInt();
		System.out.println("Using multiplcative recursion we get "+pow(a,b));
		System.out.println("Using nested loops "+usingNestedLoops(a,b));
		
		/*
		 * pow function using % and / operators
		 * 
		 */
		System.out.println("Using % and / operators we get "+usingModAndDivOperators(a,b));
	}
	finally{
		in.close();
	}
}

/*
 * Algorithm: Divide the problem into subproblems and store the solution of subproblems (memoization with divide and conquer = dynamic programming)
 * Source: http://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
 */
private static int usingModAndDivOperators(int a, int b) {
	
	if(b==0)
		return 1;
	int temp = usingModAndDivOperators(a, b/2);  // memoize step
	if(b%2==0)
		return temp*temp;
	else{
		if(b>0)
			return a*temp*temp;
		else // b=0
			return (temp*temp)/a;
	}
}
/*
 * Analysis:
 * Time Complexity = O(lgn) because we half the exponent on every call
 * Space Complexity = O(1)
 */



/*
Algorithm:
	Method 1 - (Using Iterative Approach)

	We can calculate power by using repeated addition.

	For example to calculate 8^4.
	here b = 4 and a = 8
	The outer loop is of b
	The inner loop is of a
	
	initialize increment = a;
	initialize result = a;
	
	outer loop runs (b-1) times  
	inner loop runs (a-1) times  (since we have already initialized result with a. Hence we run the inner loop (a-1) times)
	
	1) First 8 times add 8, we get 64. (8^2)
	2) Then 8 times add 64, we get 512. (8^3)
	3) Then 8 times add 512, we get 4096. (8^4)
	
	NOTE: 1. The above example has 3 steps since (b-1)=3
		  2. Inside each step, (8) times add increment = 7 times add increment + 1 intialization step where 1st iteration of (a) initializes increment to a
			 So in total 8 times in every step
			 
	Method 2 - (Using Recursion Approach)
	Recursively add a to get the multiplication of two numbers. And recursively multiply to get a raise to the
	power b.
*/
private static int usingNestedLoops(int a, int b) {
	if(b==0)
		return 1;
	
	
	
	int increment = a;   // initialize increment with a
	int result = a;      // initialize result with a
	
	
	// Hand run this program to understand it clearly
	for(int i=1;i<b;i++){     // OUTER LOOP IS b     -> VERY IMP
		for(int j=1;j<a;j++){  // INNER LOOP IS a    -> VERY IMP
			result+=increment;
		}
		increment = result;
	}
	
	
	return result;
}
/*
Analysis: Iterative Approach
	Time Complexity = O(b*a)
	Space Complexity = O(1)	
*/
private static int pow(int a, int b) {
	if(b==0)
		return 1;
	else
		return mutiply(a,pow(a,b-1));  // multiplication of (a * pow(a,b-1))
	}

private static int mutiply(int a, int b) {
	if(b==0)
		return 0;
	else
			return a+mutiply(a,b-1);
		}
}
/*
Analysis: Recursive Approach
	Time Complexity = O(b^2)
	Space Complexity = O(1) // This is not the space complexity
	
*/

