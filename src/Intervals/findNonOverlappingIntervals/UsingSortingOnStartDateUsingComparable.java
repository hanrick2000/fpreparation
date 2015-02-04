
/*NOTE: This question is implemented both using Comparable(natural ordering) and Comparator(custom defined ordering) interfaces
 * 
 * Question: Find the maximum number of non-intersecting events in a calendar.
 * Source: http://www.careercup.com/question?id=5666830939062272
 * 
 * Algorithm: 1. Sort the array of intervals on start time
 *            2. Push first interval in stack or arrayList or any other array (NOTE: we just need a storage data structure)
 *            3. Check if the next interval overlap with the first interval
 *               3.a. If NO, then add the element into the data structure
 *               3.b. If YES, the Intervals overlap. Check which interval ends first, that interval should remain in the stack
 *               
 *  VERY IMP Question: How to check if an interval overlaps with another interval ?
 *  VERY IMP Answer: If there are two intervals a and b.
 *  Then if (a.endTime < b.startTime) OR (a.startTime > b.endTime) then the intervals DONOT OVERLAP, otherwise they do overlap.
 *  Thus, we only need to check the startTime of one with endTime of the other OR vice-versa to check for OVERLAP condition
 */

package Intervals.findNonOverlappingIntervals;

import java.util.Arrays;
import java.util.Stack;

public class UsingSortingOnStartDateUsingComparable {
public static void main(String[] args) {
	IntervalOfTime[] intervals = new IntervalOfTime[]{new IntervalOfTime(1,4),
			                              new IntervalOfTime(2,3),
			                              new IntervalOfTime(5,8),
			                              new IntervalOfTime(4,5),
			                              new IntervalOfTime(3,7),
			                              new IntervalOfTime(6,10),
			                              new IntervalOfTime(7,8),
			                              new IntervalOfTime(9,12)};
	System.out.println("The maximum number of non-overlapping intervals USING SORTING: "+usingSorting(intervals));
	}

private static int usingSorting(IntervalOfTime[] intervals) {
	Stack<IntervalOfTime> stack = new Stack<IntervalOfTime>();
	Arrays.sort(intervals);  // Natural Ordering of Arrays.sort() method, URL: http://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort(java.lang.Object[])
	// push the first interval in the stack
	stack.push(intervals[0]);
	// start with the second interval and start comparing with the last interval in the stack
	for(int i=1;i<intervals.length;i++){
		IntervalOfTime last = stack.peek();
		IntervalOfTime current = intervals[i];
		// check for overlap
		if(last.endTime <= current.startTime) // does not overlap, push into stack. 
			/*
			 * 	NOTE: Since we have sorted according to start times hence we DO NOT need to check if (last.startTime >= current.endTime)
			 */
		
			stack.push(current);
		else  // Intervals overlap. Check which interval ends first, that interval should remain in the stack
			if(current.endTime < last.endTime){
			stack.pop();
			stack.push(current);
		}
	}
	return stack.size(); // since the stack contains all non-overlapping intervals
}

/*
 * Analysis:
 * Time Complexity = O(nlgn) where n is the number of intervals
 * Space Complexity = O(n)
 * 
 */


}
/*
 * If natural ordering is specified means we have to use (java.lang package) i.e. Comparable<Object> interface
 * If Comparator is specified then we have to use (java.util package) i.e. Comparator<Object> interface
 * VERY VERY VERY IMPORTANT: For deep understanding of custom defined Comparator, please refer this URL: http://www.programcreek.com/2013/11/arrays-sort-comparator/
 * 
 * 
 * VERY IMP: natural ordering = java.lang
 *           customer defined ordering = java.util 
 * 
 *  NOTE: In case of sort method of arrays, we have both variations of sort method.
 *  
 *  1. Arrays.sort(array) with natural ordering URL: http://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort(java.lang.Object[])
 *  2. Arrays.sort(array, Comparator Object) without natural ordering URL: http://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort(T[],%20java.util.Comparator)
 * VERY VERY VERY IMPORTANT: For deep understanding of custom defined Comparator, please refer this URL: http://www.programcreek.com/2013/11/arrays-sort-comparator/
 */

class IntervalOfTime implements Comparable<IntervalOfTime>{
	int startTime;
	int endTime;

public IntervalOfTime(int startTime, int endTime){
	this.startTime = startTime;
	this.endTime = endTime;
	}
/*
 * VERY VERY VERY IMP NOTE: If we are using Comparable, then we DONOT need a separate class, since we are NOT PASSING any instance to Arrays.sort() method
*/
@Override
public int compareTo(IntervalOfTime o) {
	return this.startTime - o.startTime;
	}
}