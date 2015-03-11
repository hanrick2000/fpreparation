package Sum.SubsetSumProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Question: Find a subset of elements that are selected from a given set whose sum adds
 * up to a given number K. Assume that the set contains non-negative, unique
 * values.
 * 
 * Source: http://www.careercup.com/forumpost?id=5355201013743616
 * 		   https://github.com/kowshik/big-o/blob/master/java/src/general/SubsetSum.java
 *         http://www.geeksforgeeks.org/backttracking-set-4-subset-sum/ <- DONOT FOLLOW THIS SOLUTION. FOLLOW THE SOLUTION MENTIONED BELOW
 */
public class SubsetSum {
	public static List<Integer> findSubsetSum(int[] numbers, int sum) {
		ArrayList<Integer> subset = new ArrayList<Integer>();
		for (int i = 0; i < numbers.length; i++) {
			if (findSubsetSum(numbers, i, subset, sum)) {
				return subset;
			}
		}

		return null;
	}

	private static boolean findSubsetSum(int[] numbers, int index,
			ArrayList<Integer> subset, int sum) {
		if (index >= numbers.length) {
			return false;
		}

		if (sum - numbers[index] == 0) {
			subset.add(numbers[index]);
			return true;
		}

		if (sum - numbers[index] < 0) {
			return false;
		}

		sum -= numbers[index];
		for (int i = index + 1; i < numbers.length; i++) {
			if (findSubsetSum(numbers, i, subset, sum)) {
				subset.add(numbers[index]);
				return true;
			}
		}

		return false;
	}

	public static void main(String[] args) {
		int values[] = { 1,2,3,4,5,6};
		System.out.println(Arrays.toString(values));
		System.out.println(findSubsetSum(values,12));  // Returns only one subset. Does not return all the subsets
	}
}
/*
Analysis:
	Time Complexity = O()
	Space Complexity = O()
*/