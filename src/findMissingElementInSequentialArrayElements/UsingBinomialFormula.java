package findMissingElementInSequentialArrayElements;

import java.util.Scanner;

public class UsingBinomialFormula {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		/*
		For Example: If the array is {2,3,4,5} and the missing element is 1.
		Then the size of the array is 5.
		Thus, like this the input will be taken only for 4 elements since 1 element is missing.
		Thus, when asked to input the size of the array, enter the TOTAL SIZE=NO of elements currently present+1 missing element
		*/
		System.out.println("Enter the size of the array");
		int n = in.nextInt();
		int[] array = new int[n];
		System.out.println("Enter EQUALLY SPACED elements of the array without the MISSING element");
		for(int i=0;i<(n-1);i++){    // (n-1) because n is the total size(with the missing element)
			array[i]=in.nextInt();   // Thus, we will take only (n-1) elements
		}
		System.out.println(findSingleMissingElementInSequentialArray(array));
	}
	finally{
		in.close();
	}
}
public static int findSingleMissingElementInSequentialArray(int[] a){
	int binomialTotal = (a.length)*(a.length+1)/2;
	int arrayTotal = 0;
	
	for(int i=0;i<(a.length-1);i++)  // this loop runs (n-1) times. Since one SINGLE element is MISSING
		arrayTotal+=a[i];
	
	return (binomialTotal-arrayTotal);
}
}
/*
Analysis: 
	Time Complexity = O(n)
	Space Complexity = O(1)
	
	*
	* Similar to XOR approach, this method will work only if the2 IMP conditions are satisfied.
	* 
	* This code works only if 2 IMP conditions are satisfied:
 	* 1. SINGLE (not more than 1) missing element.
 	* 2. array elements are SEQUENTIAL STARTING FROM 1 to n.
 	* 
 	* NOTE:  Array elements can be sorted, reverse-sorted or random
 	* 
  NOTE: This XOR approach will NOT WORK IF:
 1. Equally SPACED array elements
 For Example: array={50,100,150,250} and array size is 5 with the missing element as 200. All the elements are 
 equally spaced with a distance of 50
 2. UNEQUALLY SPACED array elements
 For Example: array = {50,60,150,90} and array size is 5 with the missing element(say) 20. All the elements are
 unequally spaced with respect to each other
 3. Sequential array elements starting from number!=1
 For Example: array = {3,4,5,6} and the array size is 5 with the missing element 2. All elements are sequential,
 but does not start from 1 to n where n= array size. However, if we can get the min and max from the array
 and calculate 'xorCalulated' from min to max element of the array, then above code will work for this case.
 However, if no such modification of min and max is done, then the above code will NOT give the right answer.
 Also, even if modification of min and max is done, then also the code wont work for cases where the 
 missing number either belongs to extreme left OR extreme right.
 For Example: array={3,4,5,6}, array size - 5 and missing number is 2. Then the code with min max modification
 will fail since the missing number is 2(extreme left). This is because, the min in the array would come as '3'
 whereas it actually should be '2'. But since '2' is missing, hence the min comes as '3'.
 Similar is the case with extreme right missing.
 For Example: array={3,4,5,6}, array size - 5 and missing number is 7. The max would come as '6' whereas it actually
 should be '7', but since '7' is missing hence he max comes out as '6'.
 
 THUS, IN SHORT, for all the above 3 cases, this code will "NOT WORK". Learn all the above 3 cases, its very important
 
	*/

