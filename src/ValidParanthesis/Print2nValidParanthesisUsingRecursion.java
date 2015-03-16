
/*
Question: Given "n", generate all valid parenthesis strings of length "2n". 

Example: 
Given n=2 
 q q
Output: 
(()) 
()()


Question Source: http://www.careercup.com/question?id=6234634354425856

Solution Source: http://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/  -> First Algorithm Solution Source	
http://www.careercup.com/question?id=6234634354425856   -> Another Algorithm Solution Source
 
 
Algorithm: We will do this using RECURSION

WE WILL MAINTAIN THE COUNT OF OPEN AND CLOSE PARANTHESIS

1. Base Case:
When close parenthesis == n then the solution is reached and hence we print the result

2. Recursive Step

FIRST check if open > close then append } and increase close count and call the method again
SECOND check if the open count < n then append { , increase open count and call the method again


Algorithm by GeeksForGeeks:
Keep track of counts of open and close brackets. Initialize these counts as 0. 
Recursively call the _printParenthesis() function until open bracket count is less 
than the given n. If open bracket count becomes more than the close bracket count, 
then put a closing bracket and recursively call for the remaining brackets. If open 
bracket count is less than n, then put an opening bracket and call _printParenthesis() 
for the remaining brackets.
 * 
 */



package ValidParanthesis;

import java.util.Scanner;

public class Print2nValidParanthesisUsingRecursion {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Given 'n', this program will generate all valid parenthesis strings of length '2n");
		System.out.println("Enter n");
		int n = in.nextInt();
		char[] str = new char[2*n];  // VERY VERY IMPORTANT NOTE: Donot use StringBuilder, because it will not work
		// due to append function it appends but does not remove what it has appended. HENCE we should use
		// char array for BOTH the below algorithms
		
	
		printParanthesis(str,0,0,0,n);
		str=null;
		str=new char[20];
		printUsingAnotherAlgorithm(str,0,0,0,n);
	}
	finally{
		in.close();
	}
	
}

/*
Another Algorithm:

1. If open==close print
2. if open> close then return because now we need to work on closing braces
3. if open < n then add opening brace
4. If close < n then add closing brace

 */

private static void printUsingAnotherAlgorithm(char[] str, int pos, int open, int close,int n) {
	
	// Algorithm Source: http://www.careercup.com/question?id=6234634354425856
	
	if(open==close)
		System.out.println(String.valueOf(str));

	if(open>close)    // Please remember that: ONLY ONE of the conditional statements would be executed
		              // That's why I have written "else if" and "else if" in the below two conditional statements
					  // which means only ONE will execute including this "if" statement.
		              // SO EITHER "open>close" OR "open<n" OR "close<n", only ONE among three will be executed in EACH RECURSIVE CALL.
		return;
	
	else if(open<n){ // VERY IMP: This else if is very IMPORTANT. Please NOTE this is "else if" and NOT ONLY "if" . If "else if" is not used then the program output will be wrong
		str[pos]='{'; 
		printUsingAnotherAlgorithm(str, pos+1, open+1, close, n);
	}
	else if(close<n){       // VERY IMP: This else if is very IMPORTANT. Please NOTE this is "else if" and NOT ONLY "if" . If "else if" is not used then the program output will be wrong
		str[pos]='}';
		printUsingAnotherAlgorithm(str, pos+1, open, close+1, n);
	}
		
}

private static void printParanthesis(char[] str, int pos,int open, int close, int n) {
	// Algorithm Source (GeeksForGeeks): http://www.geeksforgeeks.org/pri	nt-all-combinations-of-balanced-parentheses/
	
	if((close==n)&&(open==n))
		System.out.println(String.valueOf(str));
	else{
		if(open>close){
			str[pos]='}';
			printParanthesis(str, pos+1,open, close+1, n);
		}
		if(open<n){    // NOTE: This should NOT be else if. It should be ONLY if. The reason being both the if's the above one and this
			// one can be executed. Whereas in the above algorithm only one of the 3 statements of if can be executed
			str[pos]='{';
			printParanthesis(str, pos+1,open+1, close, n);
		}
	}
	}
}
/*
Analysis:
The number of valid parenthesis with number n is the nth Catalan number. 
Catalan Numbers are calculated as O(n).

Time Complexity Source: http://stackoverflow.com/questions/2535472/what-would-be-the-time-complexity-of-counting-the-number-of-all-structurally-dif
http://www.geeksforgeeks.org/program-nth-catalan-number/

The first Catalan numbers for n = 0, 1, 2, 3, … are

1, 1, 2, 5, 14, 42, 132, 429, 1430, 4862, 16796, 58786, 208012, 742900, 2674440, 9694845, 35357670,
129644790, 477638700, 1767263190, 6564120420, 24466267020, 91482563640, 343059613650, 1289904147324, 
4861946401452, … (sequence A000108 in OEIS).



Time Complexity = O(n)
Space Complexity = O(1)
*
*/