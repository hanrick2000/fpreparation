/*
 * 
 * 
 Question: A period of time where users login and logout, given a sets of login and logout time pairs, 
 write a function that can show the number of users online at any given time.
 
 You're given a period of time where users log in and log out and a set of login and log out times for 
 those users. Facebook is asking you to create an efficient algorithm that will calculate a simple, 
 but extremely important, metric.

Read more: http://www.businessinsider.com/15-brain-bending-interview-questions-that-every-facebook-engineer-can-answer-2012-3?op=1#ixzz3SvjAdcn8

Question and Answer Source: http://www.careercup.com/question?id=14797777
 
Algorithm:
Method 1: Interval Search Tree
Construction of Interval Search Tree will take = O(nlgn) time, since (lgn) time for searching the 
right position and this operation would be repeated for n elements
Searching in the Interval Search Tree would take O(lgn) time
Hence if we have 'd' queries for seacrching then the total effective time complexity = O(nlgn + dlgn) = O((n+d)lgn)
[Source Code: http://www.geeksforgeeks.org/interval-tree/]


Method 2: Sort all the login times in one list (nlgn)
Sort all the logout times in another list (nlgn)
Now, when a query comes, do a binary search (lgn) to count the number of logins and logouts before the 
specified time
Thus for 'd' queries the search time would be dlgn.
Thus, the total number of online users = loggedins - loggedouts	
Effective Time Complexity = O(nlgn+dlgn) = O((n+d)lgn)

Effective Solution: http://javatroops.blogspot.com/2012/12/facebook-write-function-that-can-show.html

*/
package Intervals.FindOnlineUsers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;


public class UsingSorting {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
		List<User> users = User.createUsers();
		System.out.println("Enter the time at which you want to check the logged in users");
		int time = in.nextInt();
		System.out.println("The number of online users are: "+findOnlineUsers(users,time));
		}
		finally{
			in.close();
		}
	}

	private static int findOnlineUsers(List<User> users, int time) {

		List<Integer> sortedLogins = sortLogins(users);
		List<Integer> sortedLogouts = sortLogouts(users);
		int loggedinUsers = binarySearch(sortedLogins,time)+1; // +1 due to index starting from 0
		int loggedoutUsers = binarySearch(sortedLogouts,time)+1; // +1 due to index starting from 0
		return (loggedinUsers-loggedoutUsers);
	}

	private static int binarySearch(List<Integer> punchTimes, int time) {
		
		/*
		 * Now, we need a binary search algorithm with the following properties:
		 * I. If key is present in the array (which contains duplicates)
		 * 			then return the last occurence of the key
		 * II. If key is not present
		 * 			then return all logged in users before this key(i.e. search for a newKey where newKey=key-1)
		 * NOTE: The second point (i.e. II) is very nicely explained here -> http://javatroops.blogspot.com/2012/12/facebook-write-function-that-can-show.html
		 * 
		 * The MOST IMP part in the above link and I quote.
		 * "Will see with an example. In the figure above, at time 37411 we had 1 user. 
		 * At time 37506 we had 2 users. So if I query for time 37506 we can directly say 2. 
		 * If we query for 37500 we have 1 user. How did we arrive at this? At 37500 the value was -1. 
		 * So we navigate left and at 37411 we get  value 1. That is the result."
		 */
		
		
		if(punchTimes==null || punchTimes.size()==0)  // no punchTimes given then return 0
			return 0;
		
		if(time<=0)  // no login before this time hence return 0
			return 0;
		
		int low = 0;
		int high = punchTimes.size()-1;
		int mid=0;
		int result=0;
		boolean found=false;
		while(low<=high){
			mid=low+(high-low)/2;
			if(punchTimes.get(mid)==time){
				result = mid;
				found=true;
				low=mid+1;  // binary search for finding last occurrence of repeated numbers
			}
			else if(punchTimes.get(mid)<time)
				low=mid+1;
			else //(punchTimes.get(mid)>time)
				high=mid-1;
		}
		if(found)
			return result;
		else
			return binarySearch(punchTimes, time-1); // even if (time-1) goes to <=0 then also this condition is handled at the start of this method
	}

	private static List<Integer> sortLogins(List<User> users) {
		Collections.sort(users, new Comparator<User>(){
			public int compare(User a, User b){
				return (a.loginTime-b.loginTime);
			}
		});
		List<Integer> sortedLogins = new ArrayList<Integer>();
		for(int i=0;i<users.size();i++)
			sortedLogins.add(users.get(i).loginTime);
		return sortedLogins;
	}
	private static List<Integer> sortLogouts(List<User> users) {
		Collections.sort(users, new Comparator<User>(){
			public int compare(User a, User b){
				return (a.logoutTime-b.logoutTime);
			}
		});
		List<Integer> sortedLogouts = new ArrayList<Integer>();
		for(int i=0;i<users.size();i++)
			sortedLogouts.add(users.get(i).logoutTime);
		return sortedLogouts;
	}
}

class User{
	int loginTime;
	int logoutTime;
	public User(int a, int b){
		loginTime=a;
		logoutTime=b;
	}
	
	public static List<User> createUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(1,2));
		users.add(new User(2,5));
		users.add(new User(2,3));
		users.add(new User(3,6));
		users.add(new User(4,8));
		users.add(new User(5,7));
		users.add(new User(6,10));
		users.add(new User(7,9));
		users.add(new User(10,14));
		return users;
	}
}
/*
Analysis:
I. Time Complexity
1. Sorting = O(nlgn) where n = number of intervals
   Query searching = O(lgn) where n = number of login/logout times (same as number of intervals)
   Total = O((n+1)lgn) for 1 query
   For d queries, the overall time complexity is = O((n+d)lgn) time
II. Space Complexity = O(2n) where n = number of intervals which is used by two list which maintains
login and logout times in separate lists
*/