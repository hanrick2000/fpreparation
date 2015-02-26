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
import java.util.List;
import java.util.Scanner;


public class UsingGreedyApproach {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			List<Meeting> meetings=Meeting.createMeetings();
			firstProgram(meetings);
			secondProgram(meetings);
		}
		finally{
			in.close();
		}
	}

	private static int solveFirstProgram(List<Meeting> meetings) {
	
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
		int right=0;
		for(Integer i:list){
			if(i>=0)
				right=Math.max(right, ++cur);
			else
				--cur;
		}
		
		return right;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(nlgn) where n = number of meetings
	 * Space Complexity = O(2n) where n = number of meetings. Every meeting will have start and end time hence 2n
	 */
	private static boolean solveSecondProgram(List<Meeting> meetings) {
		
		Collections.sort(meetings,new Comparator<Meeting>(){
			public int compare(Meeting a, Meeting b){
				return (a.start-b.start);
			}
		});
		
		for(int i=1;i<meetings.size();i++){
			if(meetings.get(i).start < meetings.get(i-1).end)
				return false;
		}
		return true;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(nlgn) where n = number of meetings
	 * Space Complexity = O(1)
	 */
	private static void firstProgram(List<Meeting> meetings) {
		/*
		 * Answer Source: http://www.fgdsb.com/2015/01/30/meeting-rooms/
		 */
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Program I");
		System.out.println("You are given a set of meetings with start time and end time, what is the minimum number of meeting rooms you need to have to hold all the meetings.");
		System.out.println("Algorithm:");
		System.out.println("1. Add the (startTime) and -(endTime) to an array");
		System.out.println("2. Sort the array by ABSOLUTE VALUES");
		System.out.println("3. Iterate through array");
		System.out.println("\t if(arrayElement >= 0) \n"+
		"\t\t right = max(right,++cur); \n"+
		"\t else \n"+
		"\t\t --cur; \n");
		System.out.println("4. return cur;");
		System.out.println("Answer is: "+solveFirstProgram(meetings));
	}
	private static void secondProgram(List<Meeting> meetings){
		/*
		 * Answer Source: http://www.fgdsb.com/2015/01/30/meeting-rooms/
		 */
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Program II");
		System.out.println("Given a array of pairs where each pair contains the start and end time of a meeting"+
"Determine if a single person can attend all the meetings");
		System.out.println("Algorithm:");
		System.out.println("1. Sort all meetings by START TIME");
		System.out.println("2. for(int i=1;i<meetings.size(),i++)");
		System.out.println("  \t if(meeting.get(i).startTime < meeting.get(i-1).endTime) \n\t\t return false;");
		System.out.println("3. return true");
		System.out.println("Answer: All meetings can be attended by a single person? "+solveSecondProgram(meetings));
	}

	private static void thirdProgram() {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Program III");
		System.out.println("You have ONLY ONE room, what is the maximum number of meetings that can be scheduled into that room.");
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
		
		return meetings;
	}
}