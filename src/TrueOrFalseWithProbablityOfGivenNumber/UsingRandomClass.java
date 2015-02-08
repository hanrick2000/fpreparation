/*
Question: Given a number x, less than 100. How will you generate true with probability x/100. So if x = 65, 
how will you generate true with probability 65/100. You can represent true by 1 and false by 0.

Question Source: http://www.careercup.com/question?id=22106665

	Answer Source: 
		https://sites.google.com/site/csharpofjameschen/home/math/generate-true-or-false-with-given-probability----facebook
		https://sites.google.com/site/spaceofjameschen/home/math/generate-true-of-false-with-specifed-probability	
*/

package TrueOrFalseWithProbablityOfGivenNumber;

import java.util.Random;
import java.util.Scanner;

public class UsingRandomClass {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
		System.out.println("Program to generate true or false with given probability");
		for(int i=0;i<100;i++){  // the number should be less than 100
			generateTrueOrFalseWithGivenProbability(i);
		}
		}
		finally{
			in.close();
		}
	}

	private static void generateTrueOrFalseWithGivenProbability(int number) { // the number should be less than 100
		Random r = new Random();
		// nextInt() method of Random number is instance method hence we need to create an object of Random class
		
		int random = r.nextInt()%100; // random number should be less than 100
		boolean result = false;
		if(number>random)     // if number>random then return true else return false
			result = true;
		System.out.println(number+" has random number "+random+" hence, ----- "+result);
	}
}
/*
Analysis:
Time Complexity = O(1)
Space Complexity = O(1)
*/