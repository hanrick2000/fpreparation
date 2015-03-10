
/*
Question: Given a number N, write a program that returns all possible combinations of numbers that add up to N,
as lists. (Exclude the N+0=N) 

For example, if N=4 return {{1,1,1,1},{1,1,2},{2,2},{1,3}}

Question Source: http://www.careercup.com/question?id=6321181669982208
Solution Source: 
				https://www.youtube.com/watch?v=wp7FBc-idCI    -> Explanation for NP Hard Problems
				https://github.com/nkatre/geeksforgeeksANDcareercup/tree/master/src/SubsetSumProblem
*/

package printAllPossibleCombinationThatAddUpToN;

import java.util.Scanner;
import java.util.Stack;

public class UsingStack {
	private static int sumInStack;
    private static Stack<Integer> stack = new Stack<Integer>();
    
    public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    try{
        System.out.println("This program will find ALL POSSIBLE COMBINATIONS of elements that make the SUM in an array of negative and positive integers");
        System.out.println("Enter the size of the array");
        int n = in.nextInt();
        System.out.println("Enter the elements of the array");
        int[] a = new int[n];
        for(int i=0;i<n;i++)
            a[i]=in.nextInt();
        System.out.println("Enter the sum for which the combinations need to be print");
        int sum = in.nextInt();
        System.out.println("The possible combinations are: ");
        usingStack(a,sum, 0, a.length);
    }
    finally{
        in.close();
        }
    }

    public static void usingStack(int[] a,int targetSum, int fromIndex, int endIndex){
        /*
        It is a NP Hard Problem
             1. first check whether the stackSum == targetSum. If yes, then print the elements of the stack
             2. run a loop through all elements of the array
                     2.1. check whether the currentElement + stackSum <= targetSum.
                             2.1.1. If yes then push the current element in the stack
                             2.1.2. increase the stacksum
                             2.1.3. recursively call the function with the currentIndex being incremented
                             2.1.4. Pop the top element of the stack
        
        */
        if(sumInStack == targetSum)
            print(stack);
            
        for(int currentIndex = fromIndex; currentIndex<endIndex;currentIndex++){
            
            if(sumInStack+a[currentIndex] <= targetSum){
                stack.push(a[currentIndex]);
                sumInStack += a[currentIndex];
                
                usingStack(a,targetSum, currentIndex+1, endIndex);
                sumInStack -= (Integer)stack.pop();
            
            }
        }
        
    
    
    }
    public static void print(Stack<Integer> stack){
        StringBuilder sb = new StringBuilder();
        for(Integer i : stack){
            sb.append(i).append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
    /*
     * Analysis:
     * Time Complexity = O(2^n) since it is a NP Hard Problem
     * Space Complexity = O(elements forming the target sum would be present in the stack)
     */
    
}
