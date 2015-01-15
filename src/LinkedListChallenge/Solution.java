package LinkedListChallenge;

public class Solution {
	public static void main(String[] args) {
		Node num1=new Node(5);
		num1.appendToTail(4);
		num1.appendToTail(9);
		num1.appendToTail(12);
		num1.appendToTail(16);
		num1.appendToTail(20);
		num1.appendToTail(24);
		num1.appendToTail(41);
		num1.appendToTail(53);
		num1.appendToTail(34);
		int[] removalRequests = new int[]{1,3,5,8};
		Node firstNode = LinkedList.Remove(num1,removalRequests,removalRequests.length);
		printLinkedList(firstNode);
		
	}
	/*
	 * Helper Method to print the LinkedList
	 */
	private static void printLinkedList(Node firstNode) {
		Node n=firstNode;
		while(n!=null){
			System.out.println(n.getData());    // add this method in the helper section
			n=n.next;
		}
	}
}
class Node {
	private int data;
	public Node next;
	public Node(int d)
	{
		this.data=d;
	    this.next=null;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}

	void appendToTail(int d)
	{
	    // Create a new node which will be appended to the end
		Node end=new Node(d);
		// traverse till you reach the current end then append the end node
		Node n=this;
		while(n.next!=null)
		{
		
			n=n.next;
		}
		n.next=end;
		
	}

}
class LinkedList{
	/*
	 * Preconditions: 1. removalRequests is a sorted array containing positions in the linked list where nodes need be removed.
	 *                2. The array is sorted from smallest to largest
	 *                3. No duplicate.
	 *                4. No negative position number.
	 *                5. No out-of-range position number.
	 *                6. It NEVER requests removing of the head node (index=0)
	 *  
	 *  Given ALL the preconditions, I propose the following method for Node Removal
	 */
	public static Node Remove(Node firstNode, int[] removalRequests, int removalRequestsLength) 
	{
		int index = 0;             // counter for iterating over linked list
		int requestCounter = 0;    // counter for iterating over removalRequests array
		Node current = firstNode;  
		Node previous = null;
		while(current!=null){
			if(requestCounter<removalRequestsLength){   
				if(index==removalRequests[requestCounter]){  // remove the current
					Node next = current.next;
					if(next!=null)            // if next is not null then point the previous.next to current.next
						previous.next=next;
					if(next==null)            // if next is null then we reached the end of linked list
						previous.next=null;   
					requestCounter++;
				}
			}
			index++;
			previous=current;
			current=current.next;
		}
		return firstNode;
	
	} 
}
/*
Analysis:
	Time Complexity = O(n), where n = number of elements in the LinkedList
	Space Complexity = O(1)
*/