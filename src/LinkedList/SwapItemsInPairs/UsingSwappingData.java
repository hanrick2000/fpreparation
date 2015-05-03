/*
 * Question: Swap the elements of the LinkedList in pairs
 * Example: If the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5.
 * 
 * Question Source: http://www.careercup.com/question?id=6313112158339072
 * Answer Source: http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list/
 * 
 * Algorithm:  (Swap the "Data" of the nodes, NOT ACTUAL LINKS)
 * Start from the first node
 * Traverse further only if there are at-least two nodes left 
 * 				Swap data of current node with its next node's data
 * 				Move current node by 2 places
 */

package LinkedList.SwapItemsInPairs;



public class UsingSwappingData {

	public static void main(String[] args) {
		ListNode head = makeLL();
		System.out.println("Before Swapping data of LL Node");
		printLL(head);
		System.out.println("Iterative: After swapping data of LL Node");
		iterativePairwiseSwapData(head);
		printLL(head);
		System.out.println("Recursive: After swapping data of LL Node");
		recursivePairwiseSwapData(head);
		printLL(head);
	}
	
	
	private static void recursivePairwiseSwapData(ListNode head) {
		/* There must be at-least two nodes in the list */
		if(head!=null && head.next!=null){
			/* Swap the node's data with data of next node */
		    int temp = head.data;
		    head.data = head.next.data;
		    head.next.data = temp;
		    
		    /* Call pairWiseSwap() for rest of the list */
		    recursivePairwiseSwapData(head.next.next);
		}
	}


	private static void iterativePairwiseSwapData(ListNode head) {
		
		ListNode node = head;
		/* Traverse further only if there are at-least two nodes left */
		while(node!=null && node.next!=null){
			/* Swap data of node with its next node's data */
		    int temp = node.data;
		    node.data = node.next.data;
		    node.next.data=temp;           // end of swap data method
		 
		    /* Move temp by 2 for the next pair */
		    node = node.next.next;
		}
		
	}


	private static void printLL(ListNode head) {
		ListNode node = head;
		while(node!=null){
			System.out.print(node.data+" ");
			node = node.next;
		}
		System.out.println();
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
}
class ListNode {
	int data;
	ListNode next;
 
	ListNode(int x) {
		data = x;
		next = null;
	}
}