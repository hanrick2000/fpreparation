package BST.maxDepth;

import java.util.Stack;


public class UsingPostOrderTraversal {
	public static void main(String[] args) {
		BST bst = BinSearchTree.makeTree();
		System.out.println("Iterative Solution for max depth is: "+postorder(bst.root));
		System.out.println("Recursive Solution for max depth is: "+height(bst.root));
	}
public static int postorder(Node root){
	/*
	 * Algorithm:
	 * Post-order traversal guarantees to return exactly one level above a node that is popped off the stack. 
	 * Therefore, we could devise a solution utilizing post-order traversal without modifying the existing 
	 * tree structure. We keep track of the current depth and update the maximum depth as we traverse the tree.
	 * 
	 * Other Solutions are using BFS and Inorder Traversal
	 */
	if (root==null) 
		return 0;
	  Stack<Node> s=new Stack<Node>();
	  s.push(root);
	  int maxDepth = 0;
	  Node prev = null;
	  while (!s.empty()) {
	    Node curr = s.peek();
	    if (prev==null || prev.left == curr || prev.right == curr) {  // i.e. if(previous is the parent of current)
	      if (curr.left!=null)
	        s.push(curr.left);
	      else if (curr.right!=null)  // either left or right. NOT BOTH hence used "else if"
	        s.push(curr.right);
	    } 
	    else if (curr.left == prev) {          // i.e. if (current.left is previous )
	      if (curr.right!=null)
	        s.push(curr.right);
	    }
	    else {                               
	      s.pop();
	    }
	    prev = curr;
	    if (s.size() > maxDepth)
	      maxDepth = s.size();
	  }
	  return maxDepth;
	}// end of method


    //Find maxDepth or height of the tree
	public static int height(Node root){
		if(root==null)
			return 0;
		else{
			int ltree= height(root.left);
			int rtree= height(root.right);
			return Math.max(ltree+1,rtree+1);
		}
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n)
	 * Space Complexity = O(n)
	 */
}
class Node{
	public int data;
	public Node left;   // Note that: for DLL, left will act as Previous Node
	public Node right;   // Note that: for DLL, right will act as Next Node
	
	public Node(int data) {
	this.data=data;
	left=null;
	right=null;
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
					current=current.left;
					if(current==null){
						parent.left=n;
						return;
					}
				}
				else{
					current=current.right;
					if(current==null){
						parent.right=n;
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
		    display(tempNode.left);
			System.out.print(tempNode.data+" ");
			display(tempNode.right);
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
		