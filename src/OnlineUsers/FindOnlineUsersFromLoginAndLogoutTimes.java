/*
Question: A period of time where users login and logout, given a sets of login and logout 
time pairs, write a function that can show the number of users online at any given time.

Question Source: http://www.careercup.com/question?id=14797777
	
IMP Sources: 
	http://www.careercup.com/question?id=14797777
	http://www.careercup.com/question?id=5979695413723136
	
Algorithm:
Method 1: Interval Search Tree
Construction of Interval Search Tree will take = O(nlgn) time, since (lgn) time for searching the 
right position and this operation would be repeated for n elements
Searching in the Interval Search Tree would take O(lgn) time
Hence if we have 'd' queries for searching then the total effective time complexity = O(nlgn + dlgn) = O((n+d)lgn)
[Source Code: http://www.geeksforgeeks.org/interval-tree/]


Method 2: Sort all the login times in one list (nlgn)
Sort all the logout times in another list (nlgn)
Now, when a query comes, do a binary search (lgn) to count the number of logins and logouts before the 
specified time
Thus for 'd' queries the search time would be dlgn.
Thus, the total number of online users = loggedins - loggedouts	
Effective Time Complexity = O(nlgn+dlgn) = O((n+d)lgn)

*/
package OnlineUsers;

public class FindOnlineUsersFromLoginAndLogoutTimes {
	
}
