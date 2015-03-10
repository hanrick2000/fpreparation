/*
Question: A robot has to move in a grid which is in the form of a matrix. It can go to 
1.) A(i,j)--> A(i+j,j) (Down) 
2.) A(i,j)--> A(i,i+j) (Right) 

Given it starts at (1,1) and it has to go to A(m,n), find the minimum number of STEPS it has to take to get to (m,n) and write 
public static int minSteps(int m,int n) 

For instance to go from (1,1) to m=3 and n=2 it has to take (1, 1) -> (1, 2) -> (3, 2) i.e. 2 steps

Question Source: http://www.careercup.com/question?id=5697293959299072
*/

package Robot;

public class MinSteps {
	public static void main(String[] args) {
		
	}
	int minSteps(int m, int n)
	
	/*
	 * There is only one way to get to (m,n). 
	 * If m>n, robot must come from (m-n,n). Otherwise comes from (m, n-m). So Here is my code
	 */
	{
		if(m<1 || n <1) 
			return -1;
		int count = 0;
		while(Math.abs(m-n)>0 && m>=1 && n>=1)
		{
			if(m>n)
				m=m-n;
			else n = n-m;
			count++;
		}
		if(m==1 && n==1)
			return count;
		else 
			return -1;
	}
}
