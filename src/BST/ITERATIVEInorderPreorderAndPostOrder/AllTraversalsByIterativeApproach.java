package BST.ITERATIVEInorderPreorderAndPostOrder;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/*
 * Question: Iterative inorder, post order and preorder traversals
 * 
 * Facebook Interview Question
 * 
 */


public class AllTraversalsByIterativeApproach {
	
	
public static void main(String[] args) {
	BST tree= BinSearchTree.makeTree();
	System.out.println("Inorder: ");
	inorder(tree.root);
	System.out.println("Postoder: ");
	postorder(tree.root);
	System.out.println("Preorder OR DFS Traversal: ");
	preorderORdfs(tree.root);
	System.out.println("BFS Traversal: ");
	bfs(tree.root);
}

/*
 * Algorithm for inorder traversal (Left -> Parent -> Right)
 * 
 * 
 * Algorithm Source: http://www.algorithmsandme.com/2014/02/tree-traversal-without-recursion-using.html#.VOpYVp_0_VM
 * 
 * Algorithm is simple, we go to left child downwards till we reach the NULL node. 
 * Once we reach there, we trace back the previous node, and print that node data. 
 * Once node is printed, we go and process the right child of the node in similar manner.


1.Start from the root, let's it is current.
2.If current is not NULL, push the node on to stack.
3.Move to left child of current and go to step 2.
4.If current is NULL, and stack is not empty, pop node from the stack.
5.Print the node value and change current to right child of current.
6.Go to step 2. 
So we go on traversing all left node, as we visit the node, we will put that node into stack.
 (remember we need to visit parent after the child and as we will encounter parent first when 
 start from root, it's case for LIFO :) and hence the stack). Once we reach NULL node, we will
  take the node at the top of the stack, last node which we visited. Print it.

Check if there is right child to that node. If yes, move right child to stack and again start
 traversing left child node and put them on to stack. Once we have traversed all node, our stack
  will be empty.
 */

	public static void inorder(Node root){
		Node temp = root;
		if(temp==null)
			return;
		
		// The reason why we use Stack is because Stack can resemble recursive calls
		Stack<Node> s = new Stack<Node>();
		while(!s.isEmpty() || temp!=null){
			
			if(temp!=null){
				s.push(temp);
				temp=temp.lchild;
			}
			else{
				temp=s.pop();  // trace the previous node
				System.out.print(temp.data + " ");
				temp=temp.rchild;
			}
			
		}
		System.out.println();
	}
/*
 * Analysis:
 * Time Complexity = O(n)
 * Space Complexity = O(n)
 */
	
	
	
	
	/*
	 * Algorithm for postorder traversal(Left->Right->Parent):
	 * 
	 * NOTE: Dont follow the method mentioned at this link: http://www.algorithmsandme.com/2014/02/tree-traversal-without-recursion-using.html#.VOpYVp_0_VM
	 * because its too complex, instead follow the method mentioned in this link:
	 * https://github.com/nkatre/Operations-on-Trees/blob/master/Traversal%20in%20BST-BFS%2CDFS%2CPre%2CIn%2CPos-Both%20rec%20and%20nonrec
	 * 
	 * 
	 */
	
	
	
	public static void postorder(Node root){
		
		/*
		 * VERY IMP NOTE: For postorder traversal, we need next node record
		 * 
		 * 
		 * TWO VERY VERY IMP NOTES:
		 * 
		 * I. Maintain two pointers, curr and next
		 * II. First push RIGHT then push LEFT
		 * 
		 * 
		 * Source: https://github.com/nkatre/Operations-on-Trees/blob/master/Traversal%20in%20BST-BFS%2CDFS%2CPre%2CIn%2CPos-Both%20rec%20and%20nonrec
		 */
		
		Node curr = root;
		Node next = null;
		if(curr==null)
			return;
		
		Stack<Node> s = new Stack<Node>();
		s.push(curr);
		
		while(!s.isEmpty()){
			next = s.peek();                      // PEEK to get NEXT
		    // If the next node is parent of the current node  OR next node is leaf node
			if(next.lchild==curr || next.rchild==curr || (next.lchild==null && next.rchild==null)){
				s.pop();
				System.out.print(next.data+" ");  // PRINT NEXT
				curr=next;
			}
			else{
				// VERY IMP NOTE: First push RIGHT then LEFT
				// Everything is about next. No mention of cur here in else part
				if(next.rchild!=null)   
					s.push(next.rchild);         // PUSH NEXT.R
				if(next.lchild!=null)
					s.push(next.lchild);         // PUSH NEXT.L
			}
			
		} // end of while
		System.out.println();
	}// end of method
	
	/*
	 * Analysis:
	 * Time Complexity = O(n)
	 * Space Complexity = O(n)
	 */
	
	
	
	public static void preorderORdfs(Node root){
		/*
		 * Algorithm: Same as dfs traversal in a tree
		 * Source: https://github.com/nkatre/Operations-on-Trees/blob/master/Traversal%20in%20BST-BFS%2CDFS%2CPre%2CIn%2CPos-Both%20rec%20and%20nonrec
		 * 
		 * VERY IMPORTANT NOTE: First insert RCHILD into stack then insert LCHILD into stack
		 * 
		 */
		
		Node curr = root;
		if(curr==null)
			return;
		Stack<Node> s= new Stack<Node>();
		s.push(curr);
		
		while(!s.isEmpty()){
			Node n = s.pop();
			System.out.print(n.data+" ");
			if(n.rchild!=null)//First insert the RCHILD into STACK, reason being, the tree will be printed from LEFT TO RIGHT
				s.push(n.rchild);
			if(n.lchild!=null)  // Then insert LCHILD
				s.push(n.lchild);
		}
		System.out.println();
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n)
	 * Space Complexity = O(n)
	 */
	
	
	public static void bfs(Node n){
		if(n==null)
			return;
		Queue<Node> q = new LinkedList<Node>();
		q.add(n);
		while(!q.isEmpty()){
			Node node=q.remove();
			System.out.print(node.data+" ");
			if(node.lchild!=null)
				q.add(node.lchild);
			if(node.rchild!=null)
				q.add(node.rchild);
		}
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n)
	 * Space Complexity = O(1)
	 */
	
}// end of class
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
		
		