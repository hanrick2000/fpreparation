package Intervals.MeetingRooms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class MaxNonOverlappingMeetings {
	public static void main(String[] args) {
		/*
		 * Answer Source: https://github.com/nkatre/geeksforgeeksANDcareercup/blob/master/src/Intervals/findNonOverlappingIntervals/UsingSortingOnStartDateUsingComparator.java
		 */
		List<Meeting> meetings=Meeting.createMeetings();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Program III");
		System.out.println("Find the number of maximum possible non-overlapping meetings");
		System.out.println("Algorithm:");
		System.out.println("1. We sort the meetings by START TIME");
		System.out.println("2. Push the first meeting in a stack. The stack only maintains NON-OVERLAPPING meetings");
		System.out.println("3. Iterate through all the meetings");
		System.out.println(" \t if current meeting overlaps with stack.peek() meeting \n \t\t "+
		"the meeting which ends first should be in the stack");
		System.out.println(" \t else \n \t\t push the current meeting on the stack");
		System.out.println("3. return stack.size()");
		System.out.println("Answer is: "+maxNonOverlappingMeetings(meetings));
	}
	private static int maxNonOverlappingMeetings(List<Meeting> meetings) {
		
		// Extreme case
		if(meetings==null||meetings.size()==0)
			return 0;
		
		Collections.sort(meetings,new Comparator<Meeting>(){
			public int compare(Meeting a, Meeting b){
				return (a.start-b.start);
			}
		});
		
		Stack<Meeting> stack = new Stack<Meeting>();
		stack.push(meetings.get(0));
		for(int i=1;i<meetings.size();i++){
		
			Meeting prev = stack.peek();
			Meeting cur = meetings.get(i);
			if(cur.start < prev.end){ // overlap
				if(cur.end < prev.end){      // current interval ends first
					stack.pop();
					stack.push(cur);
				}
			}
			else // no overlap
				stack.push(cur);
		}
		return stack.size();
	}
	/*
	 * Analysis:
	 * Time Complexity = O(nlgn) where n = number of meetings
	 * Space Complexity = O(n) where n = number of meetings because we have used Stack
	 */
}
