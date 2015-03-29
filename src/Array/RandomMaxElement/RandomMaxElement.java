/*
 * Question: Given an array of integers. We have to find the max element of the array, which is at
 * multiple places in the array and return any one of the indices randomly.
 * 
 * Question and Answer Source: http://www.careercup.com/question?id=5764338593824768
 * 
 * Algorithm:
 * 
 * METHOD I: Number of passes = 2n 
1. Go through the array once, find the max and the number of occurrences (n). 
2. Generate a random number (r) between 1 and n. 
3. Go through the array again, return rth occurrence. 
Time: O(n). Number of passes = 2n 
Space: O(1)

METHOD II: Number of passes = n 
	First go through the array and find max with all indices(store indices in arrayList). 
	This can be done in O(n). 
	Now with newly created indices arraylist, return the random element.
	Time: O(n). Number of passes = n 
	Space: O(1)

 */

package Array.RandomMaxElement;

import java.util.ArrayList;
import java.util.List;
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
			System.out.println("Method I : Number of passes = 2n");
			System.out.println("The random max element index is: "+maxRandomElement1(a));
			System.out.println("Method II : Number of passes = n");
			System.out.println("The random max element index using another algorithm is: "+maxRandomElement2(a));
		}
		finally{
			in.close();
		}
	}
	public static int maxRandomElement1(int[] a){
		
		/*
		 METHOD I: Number of passes = 2n 
				 1. Go through the array once, find the max and the number of occurrences (n). 
				 2. Generate a random number (r) between 1 and n. 
				 3. Go through the array again, return rth occurrence. 
				 Time: O(n). Number of passes = 2n 
				 Space: O(1)
		*/
		
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
		System.out.println("Max Element is: "+currMaxElement);
		System.out.println("Max Element count is: "+maxElementCount);
		System.out.println("Random Element generated is: "+random);
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
	
	
public static int maxRandomElement2(int[] a){
		
		/*
		 METHOD II: Number of passes = n 
				 First go through the array and find max with all indices(store indices in arrayList). 
				 This can be done in O(n). 
				 Now with newly created indices arraylist, return the random element.
				 Time: O(n). Number of passes = n 
				 Space: O(1)
		*/
		
		List<Integer> indicesList = new ArrayList<Integer>();
		int currMaxElement = 0;
		for(int i=0;i<a.length;i++){
			if(a[i]>currMaxElement){
				currMaxElement = a[i];
				indicesList.clear();    // clear the indexList as the maxElement has changed
			}
			if(a[i]==currMaxElement)
				indicesList.add(i);     // add the index
		}
		Random r = new Random();
		int random = r.nextInt()%indicesList.size();
		return indicesList.get(random);
	/*
	 * Analysis:
	 * Time Complexity = O(n) No of passes = 1
	 * Space Complexity = O(n) in the worst case if all the elements of the array are max
	 */
}
}
