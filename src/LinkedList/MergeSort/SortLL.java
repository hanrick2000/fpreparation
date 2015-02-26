
/*
 * Question: Sort a LL 
 * Question and Answer Source: http://www.programcreek.com/2012/11/leetcode-solution-merge-sort-linkedlist-in-java/
 *
 *   MERGESORT IS THE MOST PREFERRED SORT TO SORT LL
 *   Analysis:
 *   Due to inherent nature of LL, mergesort has space complexity of O(1), unlike mergesort on arrays which has O(n) space complexity
 *   The time complexity is (nlgn) as with most other sorting algorithms
 */

package LinkedList.MergeSort;


public class SortLL {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(2);
		ListNode n2 = new ListNode(3);
		ListNode n3 = new ListNode(4);
 
		ListNode n4 = new ListNode(3);
		ListNode n5 = new ListNode(4);
		ListNode n6 = new ListNode(5);
 
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
 
		n1 = mergeSortList(n1);
		printList(n1);
	}
 
	// merge sort
		public static ListNode mergeSortList(ListNode head) {
	 
			if (head == null || head.next == null)
				return head;
	 
			// count total number of elements
			int count = 0;
			ListNode p = head;
			while (p != null) {
				count++;
				p = p.next;
			}
	 
			// break up to two list
			int middle = count / 2;
	 
			ListNode l = head, r = null;
			ListNode p2 = head;
			int countHalf = 0;
			while (p2 != null) {
				countHalf++;
				ListNode next = p2.next;
	 
				if (countHalf == middle) {
					p2.next = null;
					r = next;
					break;
				}
				p2 = next;
			}
	 
			// now we have two parts l and r, recursively sort them
			ListNode h1 = mergeSortList(l);
			ListNode h2 = mergeSortList(r);
	 
			// merge together
			ListNode merged = merge(h1, h2);
	 
			return merged;
		}
	 
		public static ListNode merge(ListNode l, ListNode r) {
			
			if(l==null)
				return r;
			if(r==null)
				return l;
			
			ListNode leftItr = l; // left iterator
			ListNode rightItr = r; // right iterator
	 
			ListNode fakeHead = new ListNode(0);  // fake node
			ListNode actualHead=fakeHead;
			
			while(leftItr != null && rightItr!=null){
				
				if(leftItr.val<rightItr.val){
					fakeHead.next = new ListNode(leftItr.val);
					leftItr=leftItr.next;
					fakeHead=fakeHead.next;
				}
				else{//(leftItr.val>=rightItr.val)
					fakeHead.next = new ListNode(rightItr.val);
					rightItr=rightItr.next;
					fakeHead=fakeHead.next;
				}
			}
			
			while(leftItr != null){
				fakeHead.next = new ListNode(leftItr.val);
				leftItr=leftItr.next;
				fakeHead=fakeHead.next;
			}
			while(rightItr!=null){
				fakeHead.next = new ListNode(rightItr.val);
				rightItr=rightItr.next;
				fakeHead=fakeHead.next;
			}
			return actualHead.next;  // return the next node as the first node is fake node
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
 *   MERGESORT IS THE MOST PREFERRED SORT TO SORT LL
 *   Analysis:
 *   Due to inherent nature of LL, mergesort has space complexity of O(1), unlike mergesort on arrays which has O(n) space complexity
 *   The time complexity is (nlgn) as with most other sorting algorithms
 */
