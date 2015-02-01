

/*
 * Question: bool anaStrStr (string needle, string haystack) {}
Write a function that takes 2 strings , search returns true if any anagram of string1(needle)
is present in string2(haystack)

For Example: cat, actor -> T
car, actor -> F

Source: http://www.careercup.com/question?id=5671785349513216

Algorithm: 
CRUX OF ALGORITHM: Products of prime numbers ARE EQUAL ONLY when the same prime numbers are used to calculate product.

 Use the first 26 prime numbers to calculate a hash value for each string window, anagrams of the needle 
 will have the same hash value. E.g., a - 3, b - 5, c - 7, abc has hash value 3*5*7. because the products
 of prime numbers equal only when have the same prime numbers. 
*/

package NeedleHaystackProblemORAnagramOfOneStringPresentInSecondString;

import java.util.HashSet;
import java.util.Scanner;



public class UsingPrimeNumbers_BESTALGO {

public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
    try{
    	System.out.println("Enter the two strings");
    	String s1=in.nextLine();
    	String s2 = in.nextLine();
    	System.out.println("Anagram of one of the strings is present in the second string: "+findAnagrams(s1, s2));
    }
    finally{
    	in.close();
    }
}

private static boolean findAnagrams(String s1, String s2) {
	
	if(s1==null||s2==null||s2.length()==0)
        return false;
    if(s1.length()==0)
    	return true;
	
	if(s1.length()>s2.length()) // we assume that s1 is needle and s2 is haystack. If not then reverse them
        return findAnagrams(s2,s1);
	
	// generate the first 26 prime numbers
	int[] primeNumbers = firstNPrimeNumbers(26);
	
	// use HashSet to store the anagrams if they exist in the second string
	HashSet<String> set = new HashSet<String>();
	long needlePrimeProduct = getProduct(s1,primeNumbers);
	long haystackPrimeProduct = getProduct(s2.substring(0,s1.length()),primeNumbers);
	
	if(needlePrimeProduct==haystackPrimeProduct)
		set.add(s2.substring(0, s1.length()));
	
	for(int i=s1.length();i<(s2.length());i++){
		haystackPrimeProduct=updateProduct(s2.charAt(i-s1.length()),s2.charAt(i),haystackPrimeProduct,primeNumbers);
		if(needlePrimeProduct==haystackPrimeProduct)
			set.add(s2.substring(i-s1.length(), i));
	}
	
	if(set.size()>0)
		return true;
	else
		return false;
	
}

private static long updateProduct(char remove,char add, long hayProduct, int[] primeNumbers) {
	int asciiDifference = 97;
	long originalProduct = hayProduct;
	originalProduct/=primeNumbers[remove-asciiDifference];
	originalProduct*=primeNumbers[add-asciiDifference];
	return originalProduct;
}

private static long getProduct(String s, int[] primeNumbers) {
	int asciiDifference = 97;  // small a starts from 97 in the ASCII table
	long result = 1;
	for(int i=0;i<s.length();i++)
		result*=primeNumbers[s.charAt(i)-asciiDifference];  // the primeNumbers array starts from 0 to 25
	return result;
}

/*
Algorithm to find PRIME NUMBERS:

Source: http://www.wikihow.com/Check-if-a-Number-Is-Prime

TO SAVE TIME, TEST ONLY UP TO SQRT(N), ROUNDED UP. 

Testing a number n by all numbers between 2 and n-1 can quickly become prohibitively time-consuming. 
For instance, if we wanted to check whether 103 is a prime number in this way, we would have to divide 
by 3, 4, 5, 6, 7 ... and so on, all the way to 102! Luckily, it's not necessary to test by every single
possible factor. It's actually only necessary to test the factors between 2 and the square root of n.
If the square root of n isn't a whole number, round up to the nearest whole number and test up to this 
number instead. See below for an explanation:
Let's examine the factors of 100. 100 = 1 × 100, 2 × 50, 4 × 25, 5 × 20, 10 × 10, 20 × 5, 25 × 4, 50 × 2, 
and 100 × 1. Notice that after 10 × 10, the factors are the same as those before 10 × 10, only reversed. 
In general cases, we can ignore the factors of n greater than the sqrt(n) because they are just rearrangements 
of factors smaller than the sqrt(n).
Let's look at an example problem. If n = 37, we don't need to test all of the numbers 3 through 36 to 
determine whether n is prime. Instead, we can test only the numbers between 2 and sqrt(37), rounded up.
sqrt(37) = 6.08 - we'll round up to 7.
37 is not evenly divisible by 3, 4, 5, 6, and 7, so we can say confidently that it is prime.
*/
	


public static int[] firstNPrimeNumbers(int n){ // This program will calculate the first n prime numbers
	int[] primeNumbers = new int[n];
	if(n>=1)
		primeNumbers[0]=2;  // The first prime number is 2. This is the 0th prime number
	
	int divident = 3; // start checking for prime numbers starting from 3
	boolean prime=true; // we will assume that all numbers starting from 3 are prime
	
	for(int count=1;count<n;){  // start searching for the 1st prime number till count<n, so that the total will be n prime number
		
		for(int divisor=2;divisor<=(int)Math.ceil(Math.sqrt(divident));divisor++){
			if(divident%divisor==0){
				prime=false;
				break;  // number is not prime break and increment the dividend to next odd number
				//since even numbers can never be prime except 2(which is first prime number)
			}
		} // end of inner for
		if(prime){
			primeNumbers[count++]=divident;
		}
		prime=true;  // assume that all the numbers are prime
		divident=divident+2; // next odd number
	}
	
	return primeNumbers;
}

	
}

/*
Analysis:
Time Complexity = O(n) where n is the length of haystack string
Space Complexity = O(1) if hashset is not used for storing strings, since only whether true or false is required
Using hashset can give us the specific anagrams if asked by interviewer
*/