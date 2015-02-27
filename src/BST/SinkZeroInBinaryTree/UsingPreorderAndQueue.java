
/*
 * 
 Question: Sink Zero in Binary Tree. Swap zero value of a node with non-zero value of one of its descendants 
so that no node with value zero could be parent of node with non-zero.

Question Source: http://www.careercup.com/question?id=5344154741637120

Algorithm:
void sinkzero(Node& node, deque<int>& d) {
	if (node == null) return;
	if (node->val == 0) d.push_back(node);
	else {
		swap(node->val, d.front()->val);
		d.pop_front();
		d.push_back(node);
	}
	sinkzero(node->left, d);
	sinkzero(node->right, d);
	if (!d.empty() && d.back() == node) d.pop_back();   // Even if this step is NOT done its fine OR instead replace this
	                                                    // step with queue.clear() 
}
 
 */


package BST.SinkZeroInBinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class UsingPreorderAndQueue {
	public static void main(String[] args) {
		Node root = makeTree();
		printTree(root);
		System.out.println();
		
		Queue<Node> q = new LinkedList<Node>();
		sinkZeroUsingPreOderAndQueue(root,q);
		printTree(root);
		System.out.println();
	}

	private static void sinkZeroUsingPreOderAndQueue(Node n, Queue<Node> q) {
		if(n==null)
			return;
		if(n.data==0) // current node.data==0 then add to the queue
			q.add(n);
		else{
	// remove the front element, swap node.value of current with the removed and add current node to the queue
			Node element = q.remove();
			// swap the node.data values
			int d = n.data;
			n.data=element.data;
			element.data=d;
			q.add(n);
		}
		sinkZeroUsingPreOderAndQueue(n.left,q);
		sinkZeroUsingPreOderAndQueue(n.right, q);
		

	}
	private static void printTree(Node n) {
		if(n==null)
			return;
		System.out.print(n.data+" ");
		printTree(n.left);
		printTree(n.right);
	}
	private static Node makeTree() {
		Node one = new Node(0);
		Node two = new Node(3);
		Node three = new Node(0);
		Node four = new Node(1);
		Node five = new Node(6);
		Node six = new Node(44);
		Node seven = new Node(0);
		Node eight = new Node(0);
		Node nine = new Node(0);
		Node ten= new Node(0);
		Node eleven = new Node(8);
		Node twelve = new Node(12);
		Node thirteen = new Node(22);
		Node fourteen = new Node(20);
		Node fifteen = new Node(2);
		Node sixteen = new Node(23);
		Node seventeen = new Node(0);
		Node eighteen = new Node(0);
		Node nineteen = new Node(46);
		
		one.left=two;
		one.right=three;
		
		two.left=four;
		two.right=five;
		
		three.left=six;
		three.right=seven;
		
		four.left=eight;
		four.right=nine;
		
		five.left = ten;
		five.right=eleven;
		
		six.left=twelve;
		six.right=thirteen;
		
		seven.left=fourteen;
		seven.right=fifteen;
		
		eight.left=sixteen;
		eight.right=seventeen;
		
		nine.left=eighteen;
		nine.right=nineteen;
		
		return one;
		
	}
}
/*
Analysis: 
Time Complexity = O(n) since each node is visited only once
Space Complexity = O(n) used by the queue
*/