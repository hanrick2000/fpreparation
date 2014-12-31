package find1NonRepeatingNumber;

/*
 * NOTE: This method is applicable ONLY for 1 NON-repeating number and NOT for n Non-repeating numbers.
*/
import java.util.Scanner;

public class UsingXOR {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("The size of the array should be 2n+1");
		System.out.println("Enter the number of elements in the array");
		int n = in.nextInt();
		System.out.println("Enter the elements of the array, one should be non-repeating and the others should be repeting EXACTLY even number of times");
		int[] a = new int[n];
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		System.out.println("The non-repeating number is: "+findSingleNonRepeatingNumber(a));
	}
	finally{
		in.close();
	}
}

private static int findSingleNonRepeatingNumber(int[] a) {
	int xorAll = a[0];
	for(int i=1;i<a.length;i++)
		xorAll^=a[i];
	return xorAll;
}
}
/*
Analysis:
	Time Complexity = O(n)
	Space Complexity = O(1)
	TODO: Device a solution using HashMap
		: Device a solution using sorting
		: Solve the problem for String, using XOR, where exactly one character is non repeating and others are repeated even number of times
		: Device solution for above String problem using HashMap
		: Device solution for above String problem using asciiTable
		
		All the above solutions are similar to:
		1. For Numbers = https://github.com/nkatre/Opearations-Variants-in-an-array/blob/master/Find2NonRepeatingNumbers
		2. For Characters = https://github.com/nkatre/Opearations-Variants-in-an-array/blob/master/Find2NonRepeatingCharacters
*/
