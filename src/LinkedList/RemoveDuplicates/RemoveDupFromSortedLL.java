
/*
 * Question: Remove duplicate nodes from sorted LL
 * Question and Answer Source: http://www.programcreek.com/2013/01/leetcode-remove-duplicates-from-sorted-list/
 * 
 */


package LinkedList.RemoveDuplicates;

public class RemoveDupFromSortedLL {
	public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null)
            return head;
 
        ListNode prev = head;    
        ListNode p = head.next;
 
        while(p != null){
            if(p.val == prev.val){
                prev.next = p.next;
                p = p.next;
                //no change prev
            }else{
                prev = p;
                p = p.next; 
            }
        }
 
        return head;
    }
	/*
	 * Analysis:
	 * Time Complexity = O(n)
	 * Space Complexity = O(1)
	 */
}
class ListNode {
     int val;
     ListNode next;
     ListNode(int x) {
         val = x;
         next = null;
     }
 }
