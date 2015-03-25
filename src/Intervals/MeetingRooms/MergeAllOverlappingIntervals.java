package Intervals.MeetingRooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MergeAllOverlappingIntervals {
	public static void main(String[] args) {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Program VI");
		System.out.println("Given a collection of intervals, merge all overlapping intervals.");
		System.out.println("Source: http://www.programcreek.com/2012/12/leetcode-merge-intervals/");
		System.out.println("Solve from the above mentioned source");
		List<Meeting> meetings= Meeting.createMeetings();
		System.out.println("Result of merging overlapping intervals are: ");
		mergeAllOverlappingMeetings(meetings);
	}
	public static void mergeAllOverlappingMeetings(List<Meeting> list){
		if (list == null || list.size() <= 1)
			return;
 
		// sort intervals by start time
		Collections.sort(list, new Comparator<Meeting>(){
			public int compare(Meeting a, Meeting b){
				return a.start-b.start;
			}
		});
 
		ArrayList<Meeting> result = new ArrayList<Meeting>();
 
		Meeting prev = list.get(0);
		for (int i = 1; i < list.size(); i++) {
			Meeting curr = list.get(i);
 
			if (curr.start <= prev.end) {   // CAN BE MERGED
				Meeting merged = new Meeting(prev.start, Math.max(prev.end, curr.end));
				prev = merged;          // UPDATE PREV
			}
			else {
				result.add(prev);        
				prev = curr;            // ADD PREV AND UPDATE PREV
			}
		}
 
		result.add(prev);
 
		// printResult
        Iterator<Meeting> itr=result.iterator();
        while(itr.hasNext())
        	System.out.println(itr.next());
	}
}

