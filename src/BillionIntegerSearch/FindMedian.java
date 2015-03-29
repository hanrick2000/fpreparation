/*
Question: Let's say you have 10,000 servers, each with a billion integers. How do you find the median?

Question Source: http://www.careercup.com/question?id=5175812277927936
*/
package BillionIntegerSearch;

public class FindMedian {

	/*
	 * 
	 * Clearly, there are two kinds of costs involved here:
	 * 1. cost of computation happening within a server , 2. Cost of communicating between servers. 
Also worth noting is that the second cost is going to be the bottleneck here, so we better focus on saving bandwidth,
 and simultaneously, try not to over strain each server individually. Inspired by the classic quick select algorithm,
  I propose something that we could call distributed quick select algorithm: 
1. Select a control/master server. Probably the one with the least IP addr. Standard protocol, not a big deal.
[something similar to the spaning tree protocol would do] 
2. Control/master server selects a pivot from its own array and broadcasts the value to the est 
3. Each slave server partitions its own array based on this pivot value and sends the left , central and right count
 to the master server. 
4. Based on the total number of elements in each slave server and those that the master itself has, master selects
 one of the left, or right partitions to work on . Each of the slave servers will now be working on this partition. 
5. if total_left_count>=n/2: work on left partitions;repeat 2 to 4 
else If total_left_count+total_central_count<=n/2: pivot is the median; 
Else work on right partition; repeat 2 to 4 

Total internal computation :Linear 
Total number of network communications: nlogn [we will have to run an average logn cycles, each cycle taking 
linear number of communications] 
The second cost would improve if we used a multicast network.
	 * 
	 */
}
