/*
Question: You have a number of meetings (with their start and end times). 
		  You need to schedule them using the minimum number of rooms. Return the list of meetings in every room.


Question Source: Facebook Interview Question

IMP Sources:
http://stackoverflow.com/questions/24657695/optimal-room-count-and-sizes-for-n-overlapping-meeting-schedules
	https://nuttynanaus.wordpress.com/2014/04/26/software-engineer-interview-questions-3/
		https://hellosmallworld123.wordpress.com/2014/05/30/arranging-the-meeting-room/
*/
package Intervals.MinMeetingRooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class UsingGreedyApproach {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			List<Meeting> meetings=Meeting.createMeetings();
			firstProgram();
			System.out.println(solveFirstProgram(meetings));
			//secondProgram();
		}
		finally{
			in.close();
		}
	}

	private static int solveFirstProgram(List<Meeting> meetings) {
		Collections.sort(meetings, 
				new Comparator<Meeting>(){
			public int compare(Meeting a, Meeting b){
				return (a.end-b.end);
			}
		});
		
/*
 * NOTE: Arrays.sort, Collections.sort etc use quicksort which is inplace sorting algo. Hence these methods are void
 */
		// Stack maintains maximum possible non-overlapping meetings
		//Stack<Meeting> s = new Stack<Meeting>();
		Iterator<Meeting> iter = meetings.iterator();
		
		Meeting curr=null;
		Meeting prev=null;
		int count=1;
		while(iter.hasNext()){
			curr=iter.next();
			
			if(prev!=null && curr.start<prev.end){
				count++;
				// here the previous remains the same. It doesn't change
			}
			else
				prev=curr;
		}
		return count;
	}

	private static void firstProgram() {
		System.out.println("Program I");
		System.out.println("You have ONLY ONE room, what is the maximum number of meetings you can scheduled into that room.");
		System.out.println("Algorithm:");
		/*
		 * IMP Sources: http://www.careercup.com/question?id=15551781
		 * http://www.careercup.com/question?id=5142448749674496
		 */
		System.out.println("1. sort the meetings by finishing time, this is because we greedily choose the meeting that finishes first.");
		System.out.println("2. go through all the meetings, schedule the meeting into the room if the room is not occupied at its start time, and increase the count by one.");
		System.out.println("3. no of count will be the max number of meetings you can schedule into the room.");
		System.out.println("-----------------------------------------------------------------------------");
	}
	private static void secondProgram() {
		System.out.println("Program II");
		System.out.println("You are given a set of meetings with start time and end time, what is the minimum number of meeting rooms you need to have to hold all the meetings.");
		System.out.println("Algorithm:");
		System.out.println("1. We sort the meetings by start time");
		System.out.println("2. Iterate through all the meetings, if subsequent meetings dont overlap then fine, otherwise increment count");
		System.out.println("3. return the count");
		System.out.println("-----------------------------------------------------------------------------");
	}

}
class Meeting{
	int start;
	int end;
	public Meeting(int start, int end){
		this.start=start;
		this.end = end;
	}
	public static List<Meeting> createMeetings(){
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(1,2));
		meetings.add(new Meeting(2,5));
		meetings.add(new Meeting(10,14));
		meetings.add(new Meeting(4,8));
		meetings.add(new Meeting(3,6));
		meetings.add(new Meeting(6,10));
		meetings.add(new Meeting(2,3));
		meetings.add(new Meeting(7,9));
		meetings.add(new Meeting(5,7));
		return meetings;
	}
}