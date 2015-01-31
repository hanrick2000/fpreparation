
/*
Question: Given "n", generate all valid parenthesis strings of length "2n". 

Example: 
Given n=2 

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



package PrintValidParanthesis;

import java.util.Scanner;

public class UsingRecursion {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Given 'n', this program will generate all valid parenthesis strings of length '2n");
		System.out.println("Enter n");
		int n = in.nextInt();
		char[] str = new char[20];  // VERY VERY IMPORTANT NOTE: Donot use StringBuilder, because it will not work
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
	
	if(open>close)
		return;
	
	else if(open<n){ // VERY IMP: This else if is very IMPORTANT. Please NOTE this is "else if" and NOT ONLY "if" . If "else if" is not used then the program output will be wrong
		str[pos]='{'; 
		printParanthesis(str, pos+1, open+1, close, n);
	}
	else if(close<n){       // VERY IMP: This else if is very IMPORTANT. Please NOTE this is "else if" and NOT ONLY "if" . If "else if" is not used then the program output will be wrong
		str[pos]='}';
		printParanthesis(str, pos+1, open, close+1, n);
	}
		
}

private static void printParanthesis(char[] str, int pos,int open, int close, int n) {
	// Algorithm Source (GeeksForGeeks): http://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
	
	if(close==n)
		System.out.println(String.valueOf(str));
	else{
		if(open>close){
			str[pos]='}';
			printParanthesis(str, pos+1,open, close+1, n);
		}
		if(open<n){    // NOTE: This should NOT be else if. It should be ONLY if
			str[pos]='{';
			printParanthesis(str, pos+1,open+1, close, n);
		}
	}
	}
}
/*
Analysis:
Time Complexity = O()
Space Complexity = O()
*/