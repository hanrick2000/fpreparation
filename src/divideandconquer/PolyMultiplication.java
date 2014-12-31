package divideandconquer;

import java.util.Scanner;

public class PolyMultiplication {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the length of first array");
			int m = in.nextInt();
			System.out.println("Enter the array elements");
			int[] array1=new int[m];
			for(int i=0;i<m;i++)
				array1[i]=in.nextInt();
			System.out.println("Enter the length of second array");
			int n = in.nextInt();
			int[] array2=new int[n];
			for(int i=0;i<n;i++)
				array2[i]=in.nextInt();
			
			// Start multiplication
			
			int[] result = new int[(m-1)+(n-1)+1]; // size of the resultant array
			for(int i=0;i<m;i++){
				for(int j=0;j<n;j++){
					result[i+j] += array1[i] * array2[j];
				}
			}
			System.out.println("Result of Multiplication:");
			for(int i=0;i<(m+n-1);i++){				
				System.out.println(result[i]);
			}
		}
		finally{
			in.close();
		}
	}
}

/*Analysis:
	Running time = O(m*n)
	Space complexity O(m+n-1)
*/
