package Array.AllMissingNumbers;

import java.util.ArrayList;
import java.util.List;
/*
 * Question: Array of size (n-m) with numbers from 1..n with m of them missing. 
			 Find one all of the missing numbers in O(log). Array is sorted. 

Example: 
n = 8 
arr = [1,2,4,5,6,8] 
m=2 
Result has to be a set {3, 7}.

Question and Answer Source: http://www.careercup.com/question?id=5692698000359424

Algorithm:
We divide the array into 2 equals parts and for each sub array - 
we check if the number of elements that are actually in there (meaning the highest value minus the lowest value)
 matches the number of element of that sub array(high index - low index). 
 If yes (meaning the difference is zero) the function well return from this sub array and do nothing. 
 otherwise, we check if we got array that is actually a pair arr[i],arr[i+1] that has a difference bigger than 1. 
 if so we add all the numbers from arr[i] to arr[i+1]. 
 */
public class FindAllMissingNumbersInlgn {
	public static void main(String[] args) {
		int[] a = new int[]{1,2,4,5,6,7,10};
		System.out.println("Missing Elements are: "+findMissingNumbers(a));
	}
	public static List<Integer> findMissingNumbers(int arr[]) { 
		if(arr==null||arr.length==0)
			return null;
		List<Integer> missing = new ArrayList<Integer>();
		findMissingInSortedArrayWithNoRepetitions(arr, 0, arr.length - 1, missing);
		return missing;
	}
	public static void findMissingInSortedArrayWithNoRepetitions(int arr[], int low, int high, List<Integer> missing) {
		if(low < high) {
			if(arr[high] - arr[low] == high - low) {      // No missing elements
				return ;
			}
			else {                                          // Elements are missing
				
				// add the missing elements when 2 elements present in array
				if(high - low == 1) {            
					int temp = arr[low] + 1;
					while(temp != arr[high]) {
						missing.add(temp);
						temp = temp+1;
					}
				}
				// recursively call the left and right sub array
				else {
					int mid = low+(high-low)/2;
					findMissingInSortedArrayWithNoRepetitions(arr, low, mid, missing);        // left sub array
					findMissingInSortedArrayWithNoRepetitions(arr, mid, high, missing);       // right sub array
				}
				
				
			}
		}
	}
	
	
	/*
	 * Time Complexity = O(lgn)
	 * Actually the time complexity is m*log(n) but m = constant(m=number of missing elements)
	 * Hence Time Complexity = O(lgn)
	 * I'm assuming that m is a constant value because if m isn't constant (say m==n/2) 
	 * then it will take n/2 times to insert m elements into the set (and O(n/2)>O(log(n)))
	 * So I don't see how to implement it without the assumption m is not a constant.
	 * Space Complexity = O(m) where m = number of missing elements
	 */
}
