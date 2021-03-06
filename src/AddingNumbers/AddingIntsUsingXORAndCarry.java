/*
 * Question: Add two numbers (integers) without using + or plus arithmetic operator.
 * Question Source: http://www.shuatiblog.com/blog/2014/08/08/Add-integer-without-plus-sign/
 *
 *Algorithm:
 *
 *Example: 2+3
 *	0010
 *	0011
 *
 */

package AddingNumbers;

public class AddingIntsUsingXORAndCarry {
	// Iterative Solution
	public int add(int x, int y) {
	    // add y into x (and y results to 0)
	    while (y != 0) {
	        int carry = (x & y) << 1; //NOTE: We left shift because https://github.com/nkatre/fpreparation/blob/master/src/outputImages/Addition.pdf
	        int sum = x ^ y;
	        x = sum;
	        y = carry;
	    }
	    return x;
	}
	// Recursive Solution
	public static int add_no_arithm(int a, int b) {
	    if (b == 0)
	        return a;
	    int addition = a ^ b;
	    int carry = (a & b) << 1;
	    return add_no_arithm(addition, carry);
	}
}
