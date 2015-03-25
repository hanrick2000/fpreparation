package Intervals.MeetingRooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinMeetingRooms {
	public static void main() {
		/*
		 * Answer Source: http://www.fgdsb.com/2015/01/30/meeting-rooms/
		 * 
		 * HINT: The MAX number of overlaps = MIN meeting rooms required
		 * 
		 */
		List<Meeting> meetings=Meeting.createMeetings();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Program I");
		System.out.println("The same program denotes the MAX Overlaps in the give set of intervlas");
		System.out.println("MAX OVERLAPS = MIN MEETING ROOMS REQUIRED");
		System.out.println("You are given a set of meetings with start time and end time, what is the minimum number of meeting rooms you need to have to hold all the meetings.");
		System.out.println("Algorithm:");
		System.out.println("1. Add the (startTime) and -(endTime) to an array");
		System.out.println("2. Sort the array by ABSOLUTE VALUES");
		System.out.println("3. Iterate through array");
		System.out.println("\t if(arrayElement >= 0) \n"+
		"\t\t current++; \n"+
		"\t else \n"+
		"\t\t current--; \n"+
		"\t maxOverlaps=Math.max(maxOverlaps,current)");
		System.out.println("4. return cur;");
		System.out.println("Answer is: "+minRooms(meetings));
	}
	private static int minRooms(List<Meeting> meetings) {

		/*
		 * Algorithm Source: http://www.fgdsb.com/2015/01/30/meeting-rooms/
		 * Algorithm:
		 * 1. Add the (startTime) and -(endTime) to a list
		 * 2. Sort the list by ABSOLUTE VALUES
		 * 3. int cur=0;
			  int maxOverlaps=0;
		   4. for(Integer i:list){
			     if(i>=0)  // if it is a start point then increment
				    cur++;
			     else
				    cur--; // if it is a end point then decrement
			     maxOverlaps=Math.max(maxOverlaps, cur);   // update the maxOverlaps
		       }
		   5. return maxOverlaps;
		 */
		
		// Extreme case
		if(meetings==null||meetings.size()==0)
			return 0;
			
		List<Integer> list = new ArrayList<Integer>();
		for(Meeting m: meetings){
			list.add(m.start);
			list.add(-m.end);
		}
		
		Collections.sort(list,new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return (Math.abs(a)-Math.abs(b));
			}
		});
		
		
		int cur=0;
		int maxOverlaps=0;
		for(Integer i:list){
			if(i>=0)  // if it is a start point then increment
				cur++;
			else
				cur--; // if it is a end point then decrement
			maxOverlaps=Math.max(maxOverlaps, cur);   // update the maxOverlaps
		}
		
		return maxOverlaps;  // the maxOverlaps gives the number of meetings rooms required
	}
	/*
	 * Analysis:
	 * Time Complexity = O(mlgm) where m = total number of start AND end times AND m = 2n where n = number of intervals
	 * Space Complexity = O(m) where m = total start and end time AND m = 2n where n = number of intervals
	 */
}