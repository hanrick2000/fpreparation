/*
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

public class UsingSorting {

}
