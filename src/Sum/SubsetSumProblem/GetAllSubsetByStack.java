/*
 * 
NOTE: The elements in this array can also be NEGATIVE. The program finds all the subsets even it negative numbers
are present.
Question:Print all subset of a given set which sums up to ZERO 
		{8,3,5,1,-4,-8} 
		so answer will be : {8,-8} 
		{3,5,-8} 
		{3,1,-4} 

Question Source: http://www.careercup.com/forumpost?id=5355201013743616
				 http://www.careercup.com/question?id=12899672
				 http://www.careercup.com/question?id=6241189850251264
	
Solution Source:https://www.youtube.com/watch?v=wp7FBc-idCI    -> Explanation for NP Hard Problems 
				http://codereview.stackexchange.com/questions/36214/find-all-subsets-of-an-int-array-whose-sums-equal-a-given-target


Algorithm:
Perform a recursive DFS - the element from an array can either be or not be in the set, 
hence the solution is O(2^n) time complexity, where n = number of elements in the input array.
Pick one number with index 'i' and check the sum with arrayElement + stack_sum is less than or equal to
the target sum. If yes, then add the element to the stack and also add the element to the stack_sum 

The key point is to keep a track of a sequence of numbers in each recursive call. 
To achieve this one can use a single Stack. The number of elements on the stack corresponds 
on a depth of recursion. Once the elements on the stack sums to Target_Sum the stack is printed out.
However, we still continue with the recursion. 


*/
package Sum.SubsetSumProblem;

import java.util.Stack;

public class GetAllSubsetByStack {

	
	/*
	 * 3 parameters are global in this program:
	 * 1. Stack
	 * 2. sumInStack
	 * 3. targetSum 
	 */
	
    /** Set a value for target sum */
    //public static final int TARGET_SUM = 8;    // global & final
    
    private Stack<Integer> stack = new Stack<Integer>();  // global

    /** Store the sum of current elements stored in stack */
    //private int sumInStack = 0;                // global

    public void populateSubset(int[] data, int left, int right, int TARGET_SUM, int sumInStack) {

        /*
        * Check if sum of elements stored in Stack is equal to the expected
        * target sum.
        * 
        * If so, call print method to print the candidate satisfied result.
        */
    	
        if (sumInStack == TARGET_SUM) {
            print(stack, TARGET_SUM);
            /*
             * If we need to print only ONE SUBSET instead of all subsets we can add a BREAK statement here 
             * (Similar to next program which prints only one subset and NOT ALL SUBSETS)
             */
        }
        else{
        for (int i = left; i <= right; i++) {

            if (sumInStack + data[i] <= TARGET_SUM) {
                stack.push(data[i]);
                sumInStack += data[i];

                /*
                * Make the left as (i +1), and then use recursion to proceed
                * further.
                */
                populateSubset(data, (i + 1), right,TARGET_SUM,sumInStack);
                sumInStack -= (Integer) stack.pop(); // backtracking
            }
        }
        }
    }

    /**
    * Print satisfied result. i.e. 15 = 4+6+5
    */

    private void print(Stack<Integer> stack, int TARGET_SUM) {
        StringBuilder sb = new StringBuilder();
        sb.append(TARGET_SUM).append(" = ");
        for (Integer i : stack) {
            sb.append(i).append("+");
        }
        System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
    }
 
    public static void main(String[] args) {
    	
    	int[] DATA = { 10,5,1,-2,4,3};   // Negative Numbers are also accepted

        GetAllSubsetByStack get = new GetAllSubsetByStack();
        get.populateSubset(DATA, 0, DATA.length-1, 8, 0);
        
    }
}
/*
Analysis:
	Time Complexity = O(2^n) where n is the number of elements in the input array
	Space Complexity = O(n)
*/