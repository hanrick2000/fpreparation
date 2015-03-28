/*
Question: Remove Duplicate Nodes from unsorted LL
Question and Answer Source: http://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/
*/
package LinkedList.RemoveDuplicates;

import java.util.HashMap;

public class RemoveDupFromUnsortedLL {
	
	public static LLNode solution(LLNode head){  
		if(head == null || head.next == null)
            return head;
		
		LLNode newHead = head;
		LLNode previous = null;  
		HashMap<Integer,Boolean> map = new HashMap<Integer,Boolean>();  
        while(head.next != null){  
            if(map.containsKey(head.val)) 
            	previous.next = head.next;  
            else{  
                previous = head;  
                map.put(head.val, true);  
            }  
            head = head.next;  
        } 
        return newHead;
    }
	/*
	 * Analysis:
	 * Time Complexity = O(n)
	 * Space Complexity = O(n) used by HashMap<Integer,Boolean>
	 */
}	
class LLNode {
    int val;
    LLNode next;
    LLNode(int x) {
        val = x;
        next = null;
    }
}