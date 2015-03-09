/*
Question: All Questions are written in the program itself
IMP Sources:
	Good Amount of Question Here -> https://hellosmallworld123.wordpress.com/2014/05/30/arranging-the-meeting-room/
	Solution -> http://www.fgdsb.com/2015/01/30/meeting-rooms/
*/
package Intervals.MeetingRooms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/*
 * VERY IMP EXPLANATION:
 * 
 * Reason why we have NOT USED interval search trees.
 * 
 * QUESTION FROM INTERVIEWER: Why not use interval search trees, since searching in interval search trees
 * in O(lgn) time.
 * ANSWER: Yes, it is true that searching in interval search trees in O(lgn) times similar to BST but,
 * Constructing the Interval Search Trees from Intervals takes O(nlgn) time similar to constructing BST
 * Also extra space is required at each node for left, right pointers.
 * Hence it is better to use sorting which also takes O(nlgn) time similar to contructing a interval search tree for intervals
 * But advantage of sorting is that it is inplace and does not require extra memory unlike interval search tree node
 * 
 */
public class UsingGreedyApproach {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			firstProgram();
			secondProgram();
			thirdProgram();
			fourthProgram();
			fifthProgram();
			sixthProgram();
			
			/*
			 * VERY VERY IMP NOTE:
			 * 
			 * Collections.sort(userDefinedClass, new Comparator)    v.s    Arrays.sort(list, new Comparator)
			 * 
			 * Always remember that, 
			 * 1. To sort USERDEFINED class use Arrays  -> http://docs.oracle.com/javase/7/docs/api/java/util/Arrays.html#sort(T[],%20java.util.Comparator)
			 * 2. To sort LIST use Collections  -> http://docs.oracle.com/javase/7/docs/api/java/util/Collections.html#sort(java.util.List,%20java.util.Comparator)
			 */
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
	 * Time Complexity = O(nlgn) where n = number of meetings
	 * Space Complexity = O(2n) where n = number of meetings. Every meeting will have start and end time hence 2n
	 */
	private static boolean solveSecondProgram(List<Meeting> meetings) {
		
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
	private static int solveThirdProgram(List<Meeting> meetings) {
		
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
	
private static int solveFourthProgram(List<Meeting> meetings) {
		
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
	private static void solveFifthProgram(List<Meeting> meetings, Meeting newMeeting){
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
	
	public static void solveSixthProgram(List<Meeting> list){
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
				prev = merged;          // UPDATE prev
			}
			else {
				result.add(prev);        
				prev = curr;            // add AND UPDATE prev
			}
		}
 
		result.add(prev);
 
		// printResult
        Iterator<Meeting> itr=result.iterator();
        while(itr.hasNext())
        	System.out.println(itr.next());
	}
	
	private static void firstProgram() {
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
		System.out.println("Answer is: "+solveFirstProgram(meetings));
	}
	private static void secondProgram(){
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
		System.out.println("Answer: All meetings can be attended by a single person? "+solveSecondProgram(meetings));
	}

	private static void thirdProgram() {
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
		System.out.println("Answer is: "+solveThirdProgram(meetings));
	}
	
	private static void fourthProgram() {
		// Source: https://haixiaoyang.wordpress.com/2012/03/19/find-the-point-intersect-with-most-intervals/
		// Source: https://gist.github.com/sundeepblue/11291774
		List<Meeting> meetings=Meeting.createMeetings();
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Program IV");
		System.out.println("The maximum overlaps are: "+solveFourthProgram(meetings));
	}
	private static void fifthProgram(){
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
		solveFifthProgram(meetings,newMeeting);
		}
		finally{
			in.close();
		}
	}
	private static void sixthProgram()
	{
		System.out.println("-----------------------------------------------------------------------------");
		System.out.println("Program VI");
		System.out.println("Given a collection of intervals, merge all overlapping intervals.");
		System.out.println("Source: http://www.programcreek.com/2012/12/leetcode-merge-intervals/");
		System.out.println("Solve from the above mentioned source");
		List<Meeting> meetings= Meeting.createMeetings();
		System.out.println("Result of merging overlapping intervals are: ");
		solveSixthProgram(meetings);
	}
}
class Meeting{
	int start;
	int end;
	public Meeting(int start, int end){
		this.start=start;
		this.end = end;
	}
	public String toString(){
		return "["+start+","+end+"]";
	}
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
}