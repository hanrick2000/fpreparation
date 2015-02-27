
/*
 * Question: Calculate the average of each Level of a Tree. 
 * 
 * Question Source: http://vosggll.blogspot.com/2014/12/fb.html
 * 
 * Algorithm : level order traverse + average function
 */

package BST.AverageOfEachLevelOfTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;


public class UsingBFSTraversal {
	public static void main(String[] args) {
		BST bst=BinSearchTree.makeTree();
		bst.display();
		bst.bfs(bst.root);
	}
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
	public void bfs(Node n){
		Queue<Node> q = new LinkedList<Node>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		q.add(n);
		q.add(null);
		
		while(q.size()>1 || q.peek()!=null){
			Node node = q.remove();
			if(node!=null){
				list.add(node.data); // List
				if(node.lchild!=null)
					q.add(node.lchild); // Queue
				if(node.rchild!=null)
					q.add(node.rchild); // Queue
			}
			else{// node==null
				// calculate average
				int avg=calAverage(list);
				System.out.println(avg);
				list.clear(); // empty the list
				q.add(null);  // use null as 'end of certain depth' marker
			}
		}
		int avg=calAverage(list);
		System.out.println(avg);
	}
	
	/*
	 * Analysis:
	 * Time Complexity = O(n) where n = number of nodes in the tree
	 * Space Complexity = O(n) where n = number of nodes in the tree
	 */
	public static int calAverage(ArrayList<Integer> list){
		Iterator<Integer> iter = list.iterator();
		int sum = 0;
		while(iter.hasNext())
			sum+=iter.next();
		return (sum/list.size());
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
		