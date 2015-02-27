package BST.SerializeAndDesirializeBST;

import java.util.LinkedList;
import java.util.Queue;

public class UsingQueue {
	public static void main(String[] args) {
	BST tree = BinSearchTree.createTree();
	tree.display(tree.root);
	System.out.println();
	String treeString = serialize(tree.root);
	Node deserializedRoot = deserialize(treeString);
	tree.display(deserializedRoot);
	System.out.println();
	}


	private static String serialize(Node root) {
		StringBuilder sb = new StringBuilder();
		serialize(sb,root);
		return sb.toString().trim();
	}

	private static void serialize(StringBuilder sb, Node node) {
		if(node==null)
			return;
		
		sb.append(node.data);
		sb.append(" ");
		
		  if (node.lchild != null) {
              serialize(sb, node.lchild);
      }
      else {
              sb.append("NULL");
              sb.append(" ");
      }
      
      if (node.rchild != null) {
              serialize(sb, node.rchild);
      }
      else {
              sb.append("NULL");
              sb.append(" ");
      }
	}
	 public static Node deserialize(String str) {
         if (str == null || str.isEmpty()) {
                 return null;
         }
         String[] data = str.split(" ");
         Queue<Node> q = new LinkedList<Node>();
         
         //System.out.println(Arrays.toString(data));

         for(String s : data) {
                
                 if (s.equals("NULL")) {
                         q.add(null);
                 } else {
                         q.add(new Node(Integer.parseInt(s)));
                 }
         }
         Node root = deserialize(q, q.remove());
         return root;
 }
	 private static Node deserialize(Queue<Node> q, Node node) {
         if (node == null) {
                 return null;
         }
         node.lchild = deserialize(q, q.remove());
         node.rchild= deserialize(q, q.remove());
         
         return node;
 }
}
class Node{
	public int data;
	public Node lchild;
	public Node rchild;
	
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
	
	public static BST createTree() {
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
		return myTree;
		
	}
}