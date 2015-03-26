package LinkedList.ReverseLL;

public class UsingIterativeAndRecursiveApproach {
/* Reverse a LinkedList both recursively and iteratively.
LOGIC:
1. Always remember for reversing the nodes, we require 3 references - PREV, CURRENT & NEXT.
Out of which NEXT can be easily found since every node in a singly LL has data and next as parameters.
THUS, NEXT can be found easily.
2. Then we just have to point CURRENT.next to PREV
3. Continue doing 1. and 2. till NEXT=null is reached (i.e. reached the end of LL)
*/


//Iterative code
public static Node reverseIteratively(Node head)
{
   if(head==null)
           return null;
           
   Node pre=null;  // this statement 
   Node current=head;  // this statement is the same as the recursive approach
   Node next=null;
   
   while(current!=null)
   {
           next=current.next;  // this statement
           current.next=pre;    // and this statement are the same from the recursive method above
           
           pre=current;
           current=next;
   }
   return pre;        
}
/*
 * Analysis:
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

//Recursive code
public static Node reverseRecursively(Node current, Node prev)
{
   if(current==null)
      return prev;
      
   Node next = current.next;
   current.next = prev;
   
   return reverseRecursively(next,current);
      
}

/*
 * Analysis:
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */
}

class Node{
	int value;
	Node next;
	
	public Node(int data){
		this.value=data;
		this.next=null;
	}
}