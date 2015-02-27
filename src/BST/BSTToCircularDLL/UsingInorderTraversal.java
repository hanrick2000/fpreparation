/*
 * Question: Convert a binary search tree to a SORTED circular doubly-linked list
 * 
 * Iterative Solution Source: http://www.geekviewpoint.com/java/bst/to_circular_doubly_linked_list_iterative
 * Recursive Solution Source: http://www.careercup.com/question?id=5156120807079936
 * 
 * Algorithm: 1. Visit every node using in-order traversal, In every visit keep track of previous node
 * 			  2. Make previous.next = current
 * 				 Make current.previous = previous
 */

package BST.BSTToCircularDLL;

import java.util.Stack;

public class UsingInorderTraversal {
	
	static Node prev,head;
	public static void main(String[] args) {
	BST bst=BinSearchTree.makeTree();
	System.out.println("Recursive Method");
	recursiveConvertBSTToCircularDLL(bst.root);
	printDLL(head);
	
	
	
	BST bst1=BinSearchTree.makeTree();
	System.out.println("Iterative Method");
	Node tempHead=iterativeBSTToSortedCircularLL(bst1.root);
	printDLL(tempHead);
	}

private static Node iterativeBSTToSortedCircularLL(Node root) {
		
	Node head = null, tail = null;
	  Stack<Node> stack = new Stack<Node>();
	  Node n = root;
	  //SAME AS ITERSTIVE INORDER TRAVERSAL LOOP : https://github.com/nkatre/geeksforgeeksANDcareercup/blob/master/src/BST/ITERATIVEInorderPreorderAndPostOrder/AllTraversalsByIterativeApproach.java
	  while (n!=null || !stack.isEmpty()) {
	    //traverse left
	    if (n!=null) {
	      stack.push(n);
	      n = n.lchild;
	    }
	    else {//visit
	      n = stack.pop(); // get the previous pushed element in the stack
	      	if (head==null) {
	      		head = n;
	      		tail = n;
	      	}
	      	else {
	        tail.rchild = n;//link right
	        n.lchild = tail;//link left
	        tail = tail.rchild;//reassign tail
	      	} // else
	      	//traverse right
	      	n = n.rchild;
	    }//else
	  }//while
	 
	  //make circular
	  if (null != head) {
	    tail.rchild = head;
	    head.lchild = tail;
	  }//if
	  
	  return head;
		
	}

private static void printDLL(Node head) {
	Node n = head;
	System.out.println("The SORTED CIRCULAR DLL is: ");
	while(n.rchild!=head){
		System.out.print(n.data+" ");
		n=n.rchild;
	}
	System.out.print(n.data+" ");
	System.out.println();
}

private static void recursiveConvertBSTToCircularDLL(Node n) {
	
	// VERY IMP NOTE: Make prev and head as GLOBAL VARIABLES (class data members). SEE declaration of this class
	// to check whether prev and head are GLOBAL VARIABLES
	
	
	if(n==null)
		return;   // VERY IMP return "void"
	recursiveConvertBSTToCircularDLL(n.lchild);
	if(prev==null){  // FIRST NODE IN LIST
	   head=n;
	}
	else{
		// Store prev in current left and store current in prev.right
		n.lchild = prev;
		prev.rchild = n;
	}
	// update prev to current
	prev = n;
	// traverse right
	recursiveConvertBSTToCircularDLL(n.rchild);
	
	// These statements are only to link the head with last and last with head
	if(prev.rchild==null){ // LAST NODE IN LIST
		head.lchild = prev; // If we do not want list to be circular then change this statement to head.lchild=null;
		prev.rchild = head; // If we do not want list to be circular then change this statement to prev.rchild=null;     
	}
}
/*
 * Analysis:
 *      Time Complexity = O(n) where n = number of nodes in the BST
 *      Space Complexity = O(1)
 */

}
class Node{
	public int data;
	public Node lchild;   // Note that: for DLL, left will act as Previous Node
	public Node rchild;   // Note that: for DLL, right will act as Next Node
	
	public Node(int data) {
	this.data=data;
	lchild=null;
	rchild=null;
	}
}

class BST {
public Node root=null;

	public void addNode(Node n){
		if(root==null)
		{
			root=n;
			System.out.println(n.data+" added as the root to the tree");
		}
		else{
			
			Node current=root;
			Node parent;
			while(true){
				parent=current;
				
				if(n.data<current.data){
					current=current.lchild;
					if(current==null){
						parent.lchild=n;
						return;
					}
				}
				else{
					current=current.rchild;
					if(current==null){
						parent.rchild=n;
						return;
					}
				}
				
			}
		}
		
	}
	public void display(){
		display(root);
		System.out.println();
	}
	
	public void display(Node n){
		Node tempNode=n;
		if(tempNode==null)
			return;
		else{
		    display(tempNode.lchild);
			System.out.print(tempNode.data+" ");
			display(tempNode.rchild);
		}
	}
	
}
class BinSearchTree{
	
	public static BST makeTree() {
		BST myTree=new BST();
		System.out.println("Adding the elemets");
		myTree.addNode(new Node(40));
		myTree.addNode(new Node(50));
		myTree.addNode(new Node(30));
		myTree.addNode(new Node(80));
		myTree.addNode(new Node(20));
		myTree.addNode(new Node(10));
		myTree.addNode(new Node(5));
		myTree.addNode(new Node(85));
		myTree.addNode(new Node(35));
		myTree.addNode(new Node(45));
		myTree.addNode(new Node(32));
		myTree.addNode(new Node(15));
		myTree.addNode(new Node(38));
		myTree.addNode(new Node(36));
		myTree.display();
		
		return myTree;
	}
}