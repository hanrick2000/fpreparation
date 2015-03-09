package MathematicalOperations;

import java.util.Scanner;

public class PowerUsingOptimalAlgorithm {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the two number to calculate the power in the form a^b repectively");
			System.out.println("Only positive numbers should be entered");
			int a = in.nextInt();
			int b = in.nextInt();
			System.out.println("Using multiplcative recursion we get "+pow(a,b));
			
			/*
			 * pow function using % and / operators
			 * 
			 */
		}
		finally{
			in.close();
		}
	}

	private static int pow(int a, int b) {
		
		if(b==0)
			return 1;
		int temp = pow(a,b>>1);         // (b>>1)  is  (b/2)
		
		if(b%2==0)
			return temp*temp;
		else{
			if(b>0)
				return (temp*temp*a);
			else
				return (temp*temp/a);
		}
	}
}
/*
 * Analysis:
 * Time Complexity = O(lgn)
 * Space Complexity = O(1)
 */
