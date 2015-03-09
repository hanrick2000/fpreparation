/*
Question: Interleave two linked lists

Question and Answer Source: 
http://www.fgdsb.com/2015/01/03/interleave-two-linked-list/
https://answers.yahoo.com/question/index?qid=20100209132231AAMZS8q

Example:
Given
1->2->3->4
5->6
return 1->5->2->6->3->4
*/

package LinkedList.InterleaveTwoLL;


public class InterLeaveLL {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
		ListNode n4 = new ListNode(5);
		
		ListNode n11 = new ListNode(20);
		ListNode n21 = new ListNode(30);
		ListNode n31 = new ListNode(40);
		ListNode n41 = new ListNode(50);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		
		n11.next = n21;
		n21.next = n31;
		n31.next = n41;
 
		ListNode result= interleaveLL(n1,n11);
		System.out.println("Interleave LL WITH ExtraSpace");
		printList(result);
		
		ListNode resultHead = interleaveLLWithoutExtraSpace(n1,n11);
		System.out.println("Interleave LL WITHOUT ExtraSpace");
		printList(resultHead);
		
	}
 

	public static ListNode interleaveLL(ListNode first, ListNode second) {
			
			if(first==null&&second==null)
				return null;
			if(first==null)
				return second;
			if(second==null)
				return first;
			
			ListNode fakeNode = new ListNode(0);
			ListNode actualNode = fakeNode;
			
			ListNode firstItr = first;
			ListNode secondItr = second;
			
			while(firstItr!=null && secondItr!=null){
				fakeNode.next = new ListNode(firstItr.val);
				firstItr=firstItr.next;
				fakeNode=fakeNode.next;
				fakeNode.next=new ListNode(secondItr.val);
				secondItr=secondItr.next;
				fakeNode=fakeNode.next;
			}
			
			while(firstItr!=null){
				fakeNode.next = new ListNode(firstItr.val);
				firstItr=firstItr.next;
				fakeNode=fakeNode.next;
			}
			
			while(secondItr!=null){
				fakeNode.next=new ListNode(secondItr.val);
				secondItr=secondItr.next;
				fakeNode=fakeNode.next;
			}
			
			return actualNode.next;
		}
	
	public static ListNode interleaveLLWithoutExtraSpace(ListNode first, ListNode second) {
		
		if(first==null&&second==null)
			return null;
		if(first==null)
			return second;
		if(second==null)
			return first;
		
		
		ListNode resultHead = first;
		
		/*
		 * Key Thinking:
		 * Store the firstNext, secondNext and prev
		 */
		
		ListNode firstNext=null;
		ListNode prev=null;
		ListNode secondNext=null;
		
		while(first!=null && second!=null){
			
			firstNext = first.next;
			secondNext = second.next;
			
			prev=second;
			
			first.next = second;
			first=first.next;
			
			first.next = firstNext;
			first=first.next;
			
			first=firstNext;
			second=secondNext;
			
		}
		
		while(second!=null){
			prev.next=second;
			second=second.next;
			prev=prev.next;
		}
		
		while(first!=null){
			first = first.next;
		}
		
		return resultHead;
	}
	public static void printList(ListNode x) {
		if(x != null){
			System.out.print(x.val + " ");
			while (x.next != null) {
				System.out.print(x.next.val + " ");
				x = x.next;
			}
			System.out.println();
		}
 
	}
}
class ListNode {
	int val;
	ListNode next;
 
	ListNode(int x) {
		val = x;
		next = null;
	}
}
/*
 * Analysis:
 * Time Complexity = O(m+n)
 * Space Complexity = O(1)
 * 
 */
