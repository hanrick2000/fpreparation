

/*
 * Question: Two sum Question
 * Question and Answer Source: https://oj.leetcode.com/discuss/19298/very-short-and-simple-java-code-for-two-sum
 */

package Sum.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class UsingHashMap {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			int[] array = new int[n];
			System.out.println("Enter the elements of the array");
			for(int i=0;i<n;i++)
				array[i]=in.nextInt();
			System.out.println("Enter the sum that you need to find in the array");
			int sum = in.nextInt();
			System.out.println("The elements whose addition returns the sum are: ");
			int[] k = twoSum(array,sum);
			System.out.println(Arrays.toString(k));
		}
		finally{
			in.close();
		}
	}

	 public static int[] twoSum(int[] numbers, int target) {

	        if(numbers.length>=2)    // Minimum two numbers should be present in the array
	        {
	            HashMap<Integer,Integer> h = new HashMap<Integer,Integer>();
	            for(int i=0; i<numbers.length; i++){
	                
	            	
	            	if(!h.isEmpty() && h.containsKey(target-numbers[i]))
	                {
	                    int[] k = {h.get(target-numbers[i])+1,i+1};
	                    return k;
	                }

	                h.put(numbers[i],i);
	            }
	        }

	        int[] k = {-1,-1};
	        return k;
	    }
}
/* 
 * Analysis:   (THIS IMPLEMENTATION OF HASHMAP CAN HANDLE "DUPICATE ELEMENTS" IN THE ARRAY)
 * Time Complexity = O(n)
 * Space Complexity = O(n)
 * 
 * We can also use sorting BUT, it will take O(nlgn) time, hence best is to use HashMap with KEY as array value and
 * VALUE as array index
 */
