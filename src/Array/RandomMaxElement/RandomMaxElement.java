/*
 * Question: Given an array of integers. We have to find the max element of the array, which is at
 * multiple places in the array and return any one of the indices randomly.
 * 
 * Question and Answer Source: http://www.careercup.com/question?id=5764338593824768
 * 
 * Algorithm:
1. Go through the array once, find the max and the number of occurrences (n). 
2. Generate a random number (r) between 1 and n. 
3. Go through the array again, return rth occurrence. 

Time: O(n) 
Space: O(1)
 */

package Array.RandomMaxElement;

import java.util.Random;
import java.util.Scanner;

public class RandomMaxElement {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the elements");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println("The random max element index is: "+maxRandomElement(a));
		}
		finally{
			in.close();
		}
	}
	public static int maxRandomElement(int[] a){
		
		int currMaxElement = a[0];
		int prevMaxElement = a[0];
		int maxElementCount = 1;
		for(int i=0;i<a.length;i++){
			currMaxElement = Math.max(prevMaxElement, a[i]);       // find the maxElement
			if(currMaxElement!=prevMaxElement)                     // if maxElement has changed
				maxElementCount=1;
			else if(i!=0 && currMaxElement==prevMaxElement && currMaxElement==a[i]) // maxElement has not changed And currentElement is a maxElement
				maxElementCount++;
			prevMaxElement = currMaxElement;
		}
		Random r = new Random();
		int random = r.nextInt(maxElementCount); // returns random number from 0(inclusive) to maxElementCount(exclusive)
		System.out.println(currMaxElement);
		System.out.println(maxElementCount);
		System.out.println(random);
		int count=0;
		int i=0;
		for(i=0;i<a.length;i++){
			if(a[i]==currMaxElement){
				if(count==random)
					return i;    // return index
				count++;
			}
		}
		if(count==random)   // For Example: maxElementCount = 4 and randomElement = 3 and count = 3
			return i-1;     // in the end i will point to a.length and NOT a.length-1
		else
			return -1;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n) actually it is (2n) by asymptotically it is O(n)
	 * Space Complexity = O(1)
	 */
}
