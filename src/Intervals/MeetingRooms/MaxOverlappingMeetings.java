package Intervals.MeetingRooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxOverlappingMeetings {
	public static void main(String[] args) {
		// Source: https://haixiaoyang.wordpress.com/2012/03/19/find-the-point-intersect-with-most-intervals/
		// Source: https://gist.github.com/sundeepblue/11291774
		List<Meeting> meetings=Meeting.createMeetings();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Program IV");
		System.out.println("The maximum overlaps are: "+maxOverlappingMeetings(meetings));
	}
	private static int maxOverlappingMeetings(List<Meeting> meetings) {
		
		if(meetings==null||meetings.size()==0)
			return 0;
		
		List<Integer> al = new ArrayList<Integer>();
		for(Meeting m:meetings){
			al.add(m.start);
			al.add(-(m.end));
		}
		
		Collections.sort(al,new Comparator<Integer>(){
			public int compare(Integer a, Integer b){
				return (Math.abs(a)-Math.abs(b));
			}
		});
		
		

		int cur=0;
		int maxOverlaps=0;
		for(Integer i:al){
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
	 * Time Complexity = O(nlgn) where n = number of meetings
	 * Space Complexity = O(2n) where n = number of meetings. Every meeting will have start and end time hence 2n
	 */
}
