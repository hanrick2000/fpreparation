package Intervals.MeetingRooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class IntervalWithMostOverlaps {
	public static void main(String[] args) {
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Program VII");
		System.out.println("The section which intersects with the largest number of intervals.");
		System.out.println("Source: https://csjobinterview.wordpress.com/2012/04/02/the-section-which-intersects-with-the-largest-number-of-intervals/");
		List<Meeting> meetings= Meeting.createMaxOverlappingIntervals();	
		System.out.println("Meeting interval with most overlaps: "+intervalWithMostOverlaps(meetings).toString());
		System.out.println("Meeting interval with most overlaps: "+pointWithMostOverlaps(meetings).toString());
	}
public static Meeting intervalWithMostOverlaps(List<Meeting> meetings){
		
	/*
	The algorithm goes as following
	 1) Sort the starting/ending points in ascending order, which keep records about which points 
	 are starting points and which are ending ones.
	 2) Start from the begining of the point list or array, if we meet a starting point, 
	 then add the counter by 1. If we meet an ending point,then decrease counter by 1.
	 3) The place where we obtain the largest counter is the starting point of the expected interval, 
	 and the place +1 is the ending point.
	*/
	
		if(meetings==null||meetings.size()==0)
			return null;
		
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
	
	
	int count=0;
	int max=0;
	
	int currentNewIntervalStartTime=0;
	int currentNewIntervalEndTime=0;
	
	int finalStart=0;
	int finalEnd=0;
	
	int maxDiff=0;
	
	boolean startTimeSet = false;
	boolean endTimeSet = false;
	
	for(Integer i:list){
		if(i>=0)  // if it is a start point then increment
			count++;
		else
			count--; // if it is a end point then decrement
		if(count>max){
			max=count;
			currentNewIntervalStartTime=i;
			startTimeSet=true;
		}
		if(startTimeSet){
			if(count<max){
				endTimeSet=true;
				currentNewIntervalEndTime= -(i);
			}
		}
		if(startTimeSet&&endTimeSet){
			if((currentNewIntervalEndTime-currentNewIntervalStartTime)>maxDiff){
				finalStart=currentNewIntervalStartTime;
				finalEnd=currentNewIntervalEndTime;
			}
			
				currentNewIntervalStartTime=0;
				currentNewIntervalEndTime=0;
				startTimeSet=false;
				endTimeSet=false;
			
		}
	}
	
	return new Meeting(finalStart,finalEnd);  // the maxOverlaps gives the number of meetings rooms required
}
/*
 * Analysis:
 * Time Complexity = O(nlgn) where n = number of meetings
 * Space Complexity = O(2n) where n = number of meetings. Every meeting will have start and end time hence 2n
 */
	private static Meeting pointWithMostOverlaps(List<Meeting> meetings){
		/*
		The algorithm goes as following
		 1) Sort the starting/ending points in ascending order, which keep records about which points 
		 are starting points and which are ending ones.
		 2) Start from the beginning of the point list or array, if we meet a starting point, 
		 then add the counter by 1. If we meet an ending point,then decrease counter by 1.
		 3) The place where we obtain the largest counter is the starting point of the expected interval, 
		 and the place +1 is the ending point.
		*/
    if(meetings==null||meetings.size()==0)
			return null;
		
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
	
	int count=0;
	int max=0;
	
	
	
	for(Integer i: list){
		if(i>=0)
			count++;
		else
			count--;
		max = Math.max(count,max);
	}
	/*
	 * Start from the begining of the point list or array, if we meet a starting point, 
		 then add the counter by 1. If we meet an ending point,then decrease counter by 1.
	 */
	int newIntervalStartTime=max;
	int newIntervalEndTime=max+1;
	
	return new Meeting(newIntervalStartTime,newIntervalEndTime);
	}

}
