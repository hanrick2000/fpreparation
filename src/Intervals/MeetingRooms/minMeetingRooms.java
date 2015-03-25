package Intervals.MeetingRooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class minMeetingRooms {
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
		 * 1. Add the (startTime) and -(endTime) to an array
		 * 2. Sort the array by ABSOLUTE VALUES
		 * 3. Iterate through array
		 * 		if(arrayElement >= 0)
		 * 			right = max(right,++cur)
		 * 		else
		 * 			--cur;
		 * 4. return cur;
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
	public static List<Meeting> createMeetings(){
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(1,2));
		meetings.add(new Meeting(2,5));
		meetings.add(new Meeting(10,14));
		meetings.add(new Meeting(4,8));
		meetings.add(new Meeting(3,6));
		meetings.add(new Meeting(7,9));
		meetings.add(new Meeting(5,7));
		meetings.add(new Meeting(6,10));
		meetings.add(new Meeting(2,3));
		meetings.add(new Meeting(8,9));
		meetings.add(new Meeting(8,10));
		meetings.add(new Meeting(8,11));
		return meetings;
	}
}
// NOTE 1: Arrays.sort, Collections.sort etc use quicksort which is inplace sorting algo. Hence these methods are void
/*
 * Note 2: While iterating over Collection, if we are making modification to Collection
 * then we sould use Iterator for iterating
 * 
 * If we are not making any modification, then we can use get(int index) method
 * Example: List<Meeting> meetings = new ArrayList<Meeting>();
 * int count=0;
 * Meeting curr=null;
 * Meeting prev = meetings.get(0);
 * for(int i=1;i<meetings.size();i++){
 * 	curr=meetings.get(i);
 * 	if(curr.start < prev.end)
 * 		count++;
 * 	prev=curr;
 * }
 * 
 Sources: http://stackoverflow.com/questions/5504570/iterator-vs-for-loop-and-why-iterator-was-introduced-as-we-had-for-loop
 http://stackoverflow.com/questions/2113216/which-is-more-efficient-a-for-each-loop-or-an-iterator
 */
