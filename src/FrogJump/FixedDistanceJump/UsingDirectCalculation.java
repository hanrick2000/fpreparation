/*
Queston: A small frog wants to get to the other side of the road.
The frog is currently located at position X and wants to get to a position greater than or equal to Y.
The small frog always jumps a fixed distance, D. 
Count the minimal number of jumps that the small frog must perform to reach its target.

Question And Answer Source: http://www.jordanterry.co.uk/blog/2014/10/26/frog-jump/

Algorithm:
	calculate distance
	(distance/D + (distance%D > 0 ? 1:0) )
*/
package FrogJump.FixedDistanceJump;

import java.util.Scanner;

public class UsingDirectCalculation {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
		System.out.println("Enter value for X");
		int X = in.nextInt();
		System.out.println("Enter value for Y");
		int Y = in.nextInt();
		System.out.println("Enter value for D");
		int D = in.nextInt();
		System.out.println("The jumps required to reach Y is: "+minJumps(X,Y,D));
		}
		finally{
			in.close();
		}
	}

	private static int minJumps(int X, int Y, int D) {
		int dist = Y-X;
		return ( (dist/D)+(dist%D > 0 ? 1:0) );
	}
}
/*
 * Analysis:
 * Time Complexity = O(1)
 * Space Complexity = O(1)
 */
