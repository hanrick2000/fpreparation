package Intervals.MeetingRooms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
/*
 * Algorithm:
 * 1. Sort according to start time
 * 2. Check whether meetings overlap (i.e. compare START TIME OF CURRENT WITH END TIME OF PREV meeting)
 */
public class CanSinglePersonAttendAllMeetings {
	public static void main(String[] args){
		/*
		 * Answer Source: http://www.fgdsb.com/2015/01/30/meeting-rooms/
		 */
		List<Meeting> meetings=Meeting.createMeetings();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Program II");
		System.out.println("Given a array of pairs where each pair contains the start and end time of a meeting"+
"Determine if a single person can attend all the meetings");
		System.out.println("Algorithm:");
		System.out.println("1. Sort all meetings by START TIME");
		System.out.println("2. for(int i=1;i<meetings.size(),i++)");
		System.out.println("  \t if(meeting.get(i).startTime < meeting.get(i-1).endTime) \n\t\t return false;");
		System.out.println("3. return true");
		System.out.println("Answer: All meetings can be attended by a single person? "+canSinglePersonAttendAllMeetings(meetings));
	}
private static boolean canSinglePersonAttendAllMeetings(List<Meeting> meetings) {
		
		// Extreme case
		if(meetings==null||meetings.size()==0)
			return false;
		
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
}
