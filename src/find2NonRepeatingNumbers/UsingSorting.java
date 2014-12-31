package find2NonRepeatingNumbers;

import java.util.Arrays;
import java.util.Scanner;

public class UsingSorting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of number of elements in the array");
			int n = in.nextInt();
			System.out.println("Enter the 2 non repeating and the others as repeating elements in the array");
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			get2NonRepeatingNumbers(a);
		}
		finally{
			in.close();
		}
	}

	private static void get2NonRepeatingNumbers(int[] a) {
		Arrays.sort(a);
		int i=0;
		while(i<(a.length-1)){    // this loop runs (n-1) times, to compare every element with the next element.
			if(a[i]==a[i+1])
				i=i+2;
			if(a[i]!=a[i+1]){
				System.out.println("The non-repeating number is: "+a[i]);
				i=i+1;
				if(i==a.length-1) // last element
					System.out.println("The non-repeating number is: "+a[i]);
			}
		}
	}
}
/*
Analysis:
	Time Complexity = O(nlgn)
	Space Complexity = O(1)
*/