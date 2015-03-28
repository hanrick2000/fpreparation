
/*
 *  Question: Given a LL with next and random pointers which point to any other node in LL
 *  Devise a algorithm to copy this LL
 * 
 * 	Source: http://www.careercup.com/question?id=5412018236424192
 * 
 *  Algorithm:
 * 
 * 
I. Using Intelligent Algorithm:

Node* CopyLinkedList(Node* head) {

Node* n = head;

// First pass, insert a copy next to the code.
while (n) {
Node* n1 = new Node();
n1->data = n->data;
n1->next = n->next;
n->next = n1;
n = n->next->next;
}

// Second pass, set random pointer.
n = head;
while (n) {
n->next->random = n->random->next;
n = n->next->next;
}

// Third pass, detach two lists.
n = head;
Node* head1 = n->next;
while (n) {
Node* temp = n->next->next;
n->next->next = temp ? temp->next : nullptr;
n->next = temp;
n = temp;
}
return head1;
}













II. Using HashMap

A good linear way is to use a map. 

1) Go through your linked list, and for each node v, create a new node u, such that u->data = v->data. 
Now store (v,u) in your map. 
{Note, doesn't matter where you set the u->next, just leave the new nodes dangling in the air} 

2) Now go through your original linked list again, and visit every v. 
Now do lookups in the map for every v in your original linked list.... 
Look up v to get u. 
Call v->next as x 
Call v->random as y 
Now set u->next->map[x], u->random=map[y] .

CONS OF USING HASHMAP:
hash maps need something to hash on.. what are you assuming that is? 
The value of the node? What if several nodes have the same value? 
Your map is going to get messed up pretty quick

VERY IMP NOTE:
HENCE, HASHMAP CAN ONLY BE USED IF EVERY NODE.DATA IS UNIQUE WHEREAS THE FIRST APPROACH
OF USING INTELLIGENT ALGORITHM CAN BE USED FOR ANY CASE (EVEN IF NODE.DATA IS NOT UNIQUE)
*/


package LinkedList.RandomPointer;

public class UsingInteligentAlgorithms {
public static void main(String[] args) {
	// create the head node
	Node head=new Node(10);
	// create the LL
	head.appendToTail(20).appendToTail(30).appendToTail(40).appendToTail(50);
	
	// set the random pointers
	head.random=head.next.next.next;   //10.random = 40 
	head.next.random = head;  // 20.random=10
	head.next.next.random = head.next.next.next.next; //30.random=50
	head.next.next.next.random = head.next; // 40.random=20
	head.next.next.next.next.random = head.next.next; //50.random = 30

	// print original LL
	System.out.println("Original LL: ");
	printLL(head);
	
	// copy the linkedlist
	Node head1 = copyLLWithRandomPointer(head);
	
	// print the copied linked list
	System.out.println("Copied LL: ");
	printLL(head1);
	
	
	}

private static Node copyLLWithRandomPointer(Node head) {
	
	// First pass, insert a copy next to the code. Example: a a' b b' c c' NULL 
	Node n = head;
	while(n!=null){
		Node copy = new Node(n.data);
		copy.next = n.next;
		n.next = copy;
		// traverse through the LL
		n=n.next.next;
	}
	
	// Second pass, set random pointer.
	n=head;
	while(n!=null){
		n.next.random = n.random.next;
		// traverse through the LL
		n=n.next.next;
	}
	
	// Third pass, detach two lists.
	n = head;
	Node head1 = n.next;
	while(n!=null){
		Node temp = n.next.next;
		if(temp!=null)
			n.next.next = temp.next;
		else
			n.next.next = null;
		n.next = temp;
		// traverse through the LL
		n=temp;
	}
	
	return head1;
}

private static void printLL(Node head) {
	Node n = head;
	while(n!=null){
		System.out.println("Data:"+n.data+" Random:"+n.random.data);
		n=n.next;
	}
	System.out.println();
}
}

class Node{
	public int data;
	public Node next;
	public Node random;
	
	public Node(int data){
		this.data=data;
		this.next=null;
		this.random=null;
	}
	public Node appendToTail(int data){
			Node n = this;
			Node prev = null;
			while(n!=null){
				prev=n;
				n=n.next;
			}
			prev.next=new Node(data);
			return prev.next;
	}
}
/*
 * Analysis: 
 *    Time Complexity: we run 3 passes hence 3n, asymptotically it is O(n)
 *    Space Complexity: O(1)
 */

