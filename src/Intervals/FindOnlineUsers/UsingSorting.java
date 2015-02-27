/*
 * 
 * 
 Question: A period of time where users login and logout, given a sets of login and logout time pairs, 
 write a function that can show the number of users online at any given time.

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
		int loggedinUsers = binarySearch(sortedLogins,time);
		int loggedoutUsers = binarySearch(sortedLogouts,time);
		return (loggedinUsers-loggedoutUsers);
	}

	private static int binarySearch(List<Integer> punchTimes, int time) {
		int low = 0;
		int high = punchTimes.size()-1;
		int mid=0;
		int result=0;
		while(low<=high){
			mid=low+(high-low)/2;
			if(punchTimes.get(mid)==time){
				result = mid;
				break;
			}
			else if(punchTimes.get(mid)<time)
				low=mid+1;
			else //(punchTimes.get(mid)>time)
				high=mid-1;
		}
		
		result = Math.abs(time-punchTimes.get(low)) < Math.abs(time-punchTimes.get(high)) ? low:high;
		return result;
		
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
	/*
	// Duplicated Logged Logedout times
	public static List<User> createUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(1,2));
		users.add(new User(2,5));
		users.add(new User(10,14));
		users.add(new User(4,8));
		users.add(new User(3,6));
		users.add(new User(7,9));
		users.add(new User(5,7));
		users.add(new User(6,10));
		users.add(new User(2,3));
		return users;
	}
	
	*/
	public static List<User> createUsers(){
		List<User> users = new ArrayList<User>();
		users.add(new User(1,2));
		users.add(new User(3,5));
		users.add(new User(10,12));
		users.add(new User(4,8));
		users.add(new User(7,9));
		users.add(new User(6,11));
		return users;
	}
}
