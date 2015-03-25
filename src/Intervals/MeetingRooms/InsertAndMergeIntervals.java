package Intervals.MeetingRooms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class InsertAndMergeIntervals {
	public static void main(String[] args) {
		// Question: Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).
		// Question Source: http://www.programcreek.com/2012/12/leetcode-insert-interval/
		
		List<Meeting> meetings= Meeting.createNonOverLappingMeetings();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Program V");
		System.out.println("INSERT/MERGE INTERVALS QUESTION: Given a set of non-overlapping & sorted intervals, insert a new interval into the intervals (merge if necessary).");
		System.out.println("Enter the new meeting which you wish to INSERT/MERGE");
		
		Scanner in = new Scanner(System.in);
		try{
		System.out.println("Enter the START time");
		int start = in.nextInt();
		System.out.println("Enter the end time");
		int end = in.nextInt();
		Meeting newMeeting = new Meeting(start,end);
		System.out.println("Answer is: ");
		insertAndMergeIntervals(meetings,newMeeting);
		}
		finally{
			in.close();
		}
	}
	public static List<Meeting> createNonOverLappingMeetings(){
		List<Meeting> meetings = new ArrayList<Meeting>();
		meetings.add(new Meeting(1,3));
		meetings.add(new Meeting(4,8));
		meetings.add(new Meeting(10,15));
		meetings.add(new Meeting(20,28));
		meetings.add(new Meeting(32,36));
		meetings.add(new Meeting(56,68));
		return meetings;
	}
	private static void insertAndMergeIntervals(List<Meeting> meetings, Meeting newMeeting){
		ArrayList<Meeting> result = new ArrayList<Meeting>();
		 
		
		/*
		 * Algorithm:  (VERY VERY IMP)
		 * Whichever meeting(interval) ENDS FIRST AND DOES NOT OVERLAP, that meeting is added to the result
		 */
		
        for(Meeting currentMeeting: meetings){
            if( currentMeeting.end  < newMeeting.start){ 
            	/*
            	currentMeeting ENDS FIRST since newMeeting starts after currentMeeting.end hence 
            	currentMeeting will obviously end after newMeeting ends. THUS currentMeeting ends first
            	So add currentMeeting to result and NOW WE SHOULD CHECK for the next meeting which is newMeeting
                */
                result.add(currentMeeting);
            }
            else if(newMeeting.end < currentMeeting.start){ 
            	/*
            	1. newMeeting ENDS FIRST since currentMeeting starts after newMeeting.end hence 
            	newMeeting will obviously end after currentMeeting ends. THUS newMeeting ends first
            	2. So add newMeeting to result and NOW WE SHOULD CHECK for the next meeting which is
            	currentMeeting, hence currentMeeting becomes newMeeting
                */
                result.add(newMeeting);
                newMeeting = currentMeeting;        
            }
            else if(newMeeting.start <= currentMeeting.end|| newMeeting.end >= currentMeeting.start){  // VERY IMP: OR condition
            	/*
            	 * Here newMeeting and currentMeeting overlap hence, newMeeting will have
            	 * start = Math.min
            	 * end = Math.max
            	 * 
            	 * WE DONOT ADD any meetings to the result since there is OVERLAP and in result
            	 * we only store meetings which do not overlap
            	 */
            	
            	newMeeting = new Meeting(Math.min(currentMeeting.start, newMeeting.start), Math.max(newMeeting.end, currentMeeting.end));
            }
        }
 
        result.add(newMeeting);     // In the end, add the newMeeting
 
        // printResult
        Iterator<Meeting> itr=result.iterator();
        while(itr.hasNext())
        	System.out.println(itr.next());
	}
	/*
	 * Analysis:
	 * Time Complexity = NO SORTING involved, hence the time complexity = O(n)
	 * Space Complexity = O(n) used by result list
	 */
}
