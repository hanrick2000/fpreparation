/*Question: You have given a mathematical expression in string format. 
Example: "3+12*3-4/7" 
You need to write function which will return final result of the given expression.
Don't use Expression Tree and start scanning from left to write. 

Question Source: http://www.careercup.com/question?id=5184156424208384
	
Algorithm: Convert infix to postfix and then evaluate postfix expression

Youtube Link: https://www.youtube.com/watch?v=vq-nUF0G4fI
*/

package MathematicalOperations;

import java.util.Stack;

public class InfixToPostfix {
	public static Stack<Character> stack = new Stack<Character>();
	
public static void main(String[] args) {
	String s  =  "3+2*3-4/7";
	char[] a = s.toCharArray();
	StringBuilder postfix = new StringBuilder();
	for(int i=0;i<a.length;i++){
		if(!isOperator(a[i])){
			postfix.append(a[i]);
			continue;
		}
		if(isOperator(a[i])){
			int prevPrecedence = getPrecedence(stack.peek());
			int currPrecedence = getPrecedence(a[i]);
			if(stack.isEmpty()||(currPrecedence>prevPrecedence)){
				stack.push(a[i]);
				continue;
				}
			else{
				while(!stack.isEmpty()){
						postfix.append(stack.pop());
				}
				stack.push(a[i]);
				continue;
				}
		}
	}
	while(!stack.isEmpty()){
			postfix.append(stack.pop());
	}
		System.out.println(postfix.toString());
		
}
private static int getPrecedence(char c) {
	int precedence=0;
	if(c=='*'||c=='/')
		precedence = 6;
	else if(c=='+'||c=='-')
		precedence=4;
	else
		precedence=0;
	return precedence;
}
private static boolean isOperator(char c){
	return (c=='+'||c=='-'||c=='/'||c=='*');
}

}
/*
Analysis:
	Time Complexity = O(n)
	Space Complexity = O(n)
*/

