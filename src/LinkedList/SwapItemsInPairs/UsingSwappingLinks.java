/*
 * Question: Swap the elements of the LinkedList in pairs
 * Example: If the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5.
 * 
 * Question Source: http://www.careercup.com/question?id=6313112158339072
 * Answer Source: http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
 * 
 * NOTE:  If data contains many fields, there will be many swap operations. 
 * So changing links is a better idea in general. 
 * 
 * Algorithm:  (Swap ACTUAL LINKS instead of just data)
 */

package LinkedList.SwapItemsInPairs;

public class UsingSwappingLinks {
		static ListNode head = null;
	
	public static void main(String[] args) {
		head = makeLL();
		System.out.println("Before Swapping data of LL Node");
		printLL();
		System.out.println("Iterative: After swapping LINKS of LL Node");
		iterativePairwiseSwapLinks();
		printLL();
		System.out.println("Recursive: After swapping LINKS of LL Node");
		head = recursivePairwiseSwapLinks(head);
		printLL();
	}
	private static void iterativePairwiseSwapLinks() {
		// If linked list is empty or there is only one node in list
		if(head==null || head.next == null)
			return;
		
		// Initialize previous and current pointers
		ListNode prev = head;
		ListNode curr = head.next;
		
		// Change head before proceeding
		head = curr;
		
		while(true){
			
			// Store the next node
			ListNode next = curr.next;
			
			// Set back pointing LINK
			curr.next = prev;
			
			// if next is null OR last node then set the front pointing LINK and break
			if(next==null || next.next == null){
				prev.next = next;
				break;
			}
			
			// set the front pointing link
			prev.next = next.next;
			
			// update the prev and curr
			prev = next;
			curr = next.next;
		}
		
	}
	
	private static ListNode recursivePairwiseSwapLinks(ListNode head) {
	
		// Base Case: The list is empty or has only one node   -----> BASE
	    if (head == null || head.next == null)
	        return head;
	    
	    // Store the remaining nodes            ------> Store
	    ListNode remaining = head.next.next;
	    
	    // Store the newHead node               ------> Store
	    ListNode newHead = head.next;
	    
	    // Set the back pointing LINK           ------> Set BACK LINK
	    head.next.next = head;
	    
	    // Set the front point LINK             ------> Set FRONT LINK
	    head.next = recursivePairwiseSwapLinks(remaining);
	    
	    return newHead;                      // -------> return newHead
	}
	
	public static ListNode makeLL(){
		ListNode n1 = new ListNode(1);
		ListNode n2 = new ListNode(2);
		ListNode n3 = new ListNode(3);
		ListNode n4 = new ListNode(4);
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		
		return n1;
	}
	private static void printLL() {
		ListNode node = head;
		while(node!=null){
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
	}
}
