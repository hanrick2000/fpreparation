package find2NonRepeatingNumbers;

/*
 * NOTE: This method is applicable ONLY for 2 NON-repeating numbers and NOT for n Non-repeating numbers.
*/

import java.util.Scanner;

public class UsingXOR {
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
	int xorAll = a[0];
	for(int i=1;i<a.length;i++)
		xorAll^=a[i];
	
	int firstNonRepeatedNumber=0; 
	int secondNonRepeatedNumber=0;
	
	// get the rightmost set bit
	int getRightmostSetBit = xorAll & ~(xorAll-1);
	
	// divide the xorAll value into 2 sets
	for(int i=0;i<a.length;i++){
	if((getRightmostSetBit & a[i])>0)     // If the & operation results in set bit
		firstNonRepeatedNumber^=a[i];
	else                                  // If the & operation results in unset bit
		secondNonRepeatedNumber^=a[i];
	}
	System.out.println(firstNonRepeatedNumber);
	System.out.println(secondNonRepeatedNumber);
}
}
/*Analysis:
	Time Complexity=O(n)
	Space Complexity = O(1)
	
	*
	*TODO: Try using HashMap. NOT EFFICIENT. The only problem is that this would take O(n) space complexity along with O(n) time complexity
	*	 : Try using Sorting. NOT EFFICIENT. The problem is that this would take O(nlgn) time complexity.
	*	 : Try the same thing for characters as well(i.e. String with 2 non-repeating characters).
	*    : Try the same thing for single non-repeating number.
	*/
