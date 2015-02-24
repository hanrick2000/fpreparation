
/*
Question: Merge K Sorted Lists
Question and Answer Source: http://gongxuns.blogspot.com/2012/12/leetcode-merge-k-sorted-lists.html
*/
package MergeKSortedListsAndArrays;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {
	public static void main(String[] args) {
		ListNode n1 = new ListNode(10);
		n1.appendToTail(20).appendToTail(30).appendToTail(40).appendToTail(50);
		ListNode n2 = new ListNode(5);
		n2.appendToTail(15).appendToTail(25).appendToTail(35).appendToTail(45);
		ListNode n3 = new ListNode(4);
		n3.appendToTail(8).appendToTail(12).appendToTail(16).appendToTail(24);
		ArrayList<ListNode> lists = new ArrayList<ListNode>();
		lists.add(n1);
		lists.add(n2);
		lists.add(n3);
		ListNode resultHead = mergeKLists(lists);
		print(resultHead);
		
	}
    private static void print(ListNode resultHead) {
		ListNode temp = resultHead;
		while(temp!=null){
			System.out.println(temp.val+" ");
			temp=temp.next;
		}
	}
	public static ListNode mergeKLists(ArrayList<ListNode> lists) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if(lists.size()==0 || lists==null) 
        	return null;
        PriorityQueue<ListNode> q = new PriorityQueue<ListNode>(
            lists.size(),
        	new Comparator<ListNode>(){
        	public int compare(ListNode a, ListNode b){
        		return (a.val - b.val);
        		}
        	} // end of comparator
        );
        
        for(ListNode list:lists){
            if(list!=null) 
            	q.add(list);
        }
                
        ListNode head = new ListNode(0);
        ListNode prev = head;
        while(q.size()!=0){
            ListNode temp = q.poll(); // Retrieves and removes the head of this priority queue, or returns null if this queue is empty.
            prev.next = temp;  // join the train
            if(temp.next!=null) 
            	q.add(temp.next);
            prev = prev.next; // iterate forward
        }
        return head.next;
    }
}
class ListNode{
	public int val;
	public ListNode next;
	public ListNode(int n){
		this.val = n;
		this.next = null;
	}
	public ListNode appendToTail(int n){
		ListNode temp=new ListNode(n);
		this.next=temp;
		return this.next;
	}
}
/*
Analysis:
Time Complexity = O(n*k*lgk)
where n = average number of elements in each array
k = total number of arrays

This can also be represented as m*lgk where m = n*k  
m = total number of elements combined from all the k arrays

Space Complexity = O(k)
*/