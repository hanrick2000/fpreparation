/*
Question: Given an expression (in single variable) like 4x+13(x-(4x+x/3)) = 9, evaluate x 
The expression is a string and the variable is always x.

Question and Answer Source: http://www.careercup.com/question?id=15468738

Algorithm:
If there is only X i.e one degree expression,then we can use 2 stacks here, 
Stack 1: for keeping all the operators 
Stack 2: for keeping terms 
keep pushing data to stacks,when you hit a left parenthesis ')' pop 1 element
from stack 1 and 2 elements from stack 2,then apply the operator to the terms and push
the result again on the stack..you will end up with a simple expression in X that can be solved easily
*/

package EvaluateMathematicalExpression;

import java.util.Stack;

public class ExpressionWithOneUnknown {
	public static void main(String[] args) {

		String input = "4x+13(x-(4x+x/3)) = 99";
		input = input.replace(" ", "");
		System.out.println(" input " + input);
		int resultOfEquation = getEquationResult(input);
		System.out.println(" result is " + resultOfEquation);
		double xCount = proccessCalculations(input);
		System.out.println("x count is " + xCount);
		double finalvalue = resultOfEquation/xCount;
		System.out.println("finalvalue is " + finalvalue);
	}

	private static double proccessCalculations(String input) {
		Stack<String> values = new Stack<>();
		Stack<String> operations = new Stack<String>();
		int start = 0;
		for (int i = 0; i < input.length(); i++) {
			char c = input.charAt(i);
			// If  x is encountered then push into values stack
			if (isX(c)) { 
				values.push(input.substring(start, i + 1));
				start = i + 1;
				continue;
			}
			// If the character is operator then push in operations stack
			if (isOperation(c)) {
				operations.push(input.substring(start, i + 1));
				start = i + 1;
				continue;
			}
			// If the character is '(' then push to values stack
			if (isBeginSkobka(c)){
				if (start != i){
					values.push(input.substring(start, i));
					operations.push("*");
				}
				start = i + 1;
				continue;
			}
			// If the character is ')' then push to values stack
			if (isEndSkobka(c)) {
				if (start != i){
					values.push(input.substring(start, i));
				}
				
				String valueRight = values.pop();
				String valueLeft = values.pop();
				String operation = operations.pop();
				values.push(computeX(valueLeft, valueRight, operation));
				start = i + 1;
			}

		}
		
		
		
		while (!operations.isEmpty()){
			perforfmOP(values, operations);
		}

		System.out.println(" VALUES: ");
		for (String s : values) {
			System.out.println(s);
		}

		System.out.println(" OPERATIONS: ");
		for (String s : operations) {
			System.out.println(s);
		}

		return Double.valueOf(values.pop().replace("x", ""));
	}
	
	private static void perforfmOP(Stack<String> values, Stack<String> operations){
		String valueRight = values.pop();
		String valueLeft = values.pop();
		String operation = operations.pop();
		values.push(computeX(valueLeft, valueRight, operation));
	}

	private static String computeX(String valueLeft, String valueRight,
			String operation) {

		System.out.println("performing op " + valueLeft + " " + operation + " "
				 +valueRight);

		if (valueLeft.equals("x") || valueLeft.equals("X"))
			valueLeft = "1";
		else
			valueLeft = valueLeft.replace("x", "");

		if (valueRight.equals("x") || valueRight.equals("X"))
			valueRight = "1";
		else
			valueRight = valueRight.replace("x", "");

		if (operation.equals("*")) {
			return (Double.valueOf(valueLeft) * Double.valueOf(valueRight))
					+ "x";
		} else if (operation.equals("/")) {
			return (Double.valueOf(valueLeft) / Double.valueOf(valueRight))
					+ "x";
		}
		if (operation.equals("+")) {
			return (Double.valueOf(valueLeft) + Double.valueOf(valueRight))
					+ "x";
		} else if (operation.equals("-")) {
			return (Double.valueOf(valueLeft) - Double.valueOf(valueRight))
					+ "x";
		}

		return null;
	}

	private static boolean isEndSkobka(char c) {
		return c == ')';
	}
	
	private static boolean isBeginSkobka(char c) {
		return c == '(';
	}

	private static boolean isOperation(char c) {
		// TODO Auto-generated method stub
		return c == '+' || c == '/' || c == '-' || c == '*';
	}

	private static boolean isX(char c) {
		return c == 'x' || c == 'X';
	}

/*	private static int isInt(char c) {
		return c - '0';
	}
*/
	private static int getEquationResult(String s) {

		for (int j = s.length() - 1; j > 0; j--) {
			if (s.charAt(j) == '=')
				return Integer.valueOf(s.substring(j + 1, s.length()));
		}
		return 0;
	}
}
/*
Analysis:
Time Complexity = O(n)
Space Compexity = O(n)
*/