package BST;


import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBST {
	public static void main(String[] args) {
	BST tree = BinSearchTree.createTree();
	tree.display(tree.root);
	System.out.println();
	String treeString = serialize(tree.root);
	NodeClass deserializedRoot = deserialize(treeString);
	tree.display(deserializedRoot);
	System.out.println();
	}


	private static String serialize(NodeClass root) {
		StringBuilder sb = new StringBuilder();
		recursiveSerialize(sb,root);
		return sb.toString().trim();
	}

	private static void recursiveSerialize(StringBuilder sb, NodeClass node) {
		
		// PREORDER TRAVERSAL
		if(node==null)
			return;
		
		sb.append(node.data);
		sb.append(" ");
		
      if (node.lchild != null) 
		  recursiveSerialize(sb, node.lchild);
     
      else {
              sb.append("NULL");
              sb.append(" ");
      	}
      
      if (node.rchild != null) 
    	  recursiveSerialize(sb, node.rchild);
      
      else {
              sb.append("NULL");
              sb.append(" ");
      	}
	}
	 public static NodeClass deserialize(String str) {
         if (str == null || str.isEmpty())
                 return null;
         
         String[] data = str.split(" ");
         Queue<NodeClass> q = new LinkedList<NodeClass>();
         
         for(String s : data) {     
                 if (s.equals("NULL"))
                       q.add(null);
                 else 
                       q.add(new NodeClass(Integer.parseInt(s)));    
         }
         NodeClass root = recursiveDeserialize(q, q.remove()); // removes the first node
         return root;
	 }
	 private static NodeClass recursiveDeserialize(Queue<NodeClass> q, NodeClass node){
         if(node == null)
            return null;
         node.lchild = recursiveDeserialize(q, q.remove());
         node.rchild= recursiveDeserialize(q, q.remove()); 
         return node;
	 }
}
class NodeClass{
	public int data;
	public NodeClass lchild;
	public NodeClass rchild;
	
	public NodeClass(int data) {
	this.data=data;
	lchild=null;
	rchild=null;
	}
}

class BST {
public NodeClass root=null;

	public void addNode(NodeClass n){
		if(root==null)
		{
			root=n;
			System.out.println(n.data+" added as the root to the tree");
		}
		else{
			
			NodeClass current=root;
			NodeClass parent;
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
	public void display(NodeClass n){
		NodeClass tempNode=n;
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
		myTree.addNode(new NodeClass(40));
		myTree.addNode(new NodeClass(50));
		myTree.addNode(new NodeClass(30));
		myTree.addNode(new NodeClass(80));
		myTree.addNode(new NodeClass(20));
		myTree.addNode(new NodeClass(10));
		myTree.addNode(new NodeClass(5));
		myTree.addNode(new NodeClass(85));
		myTree.addNode(new NodeClass(35));
		myTree.addNode(new NodeClass(45));
		myTree.addNode(new NodeClass(32));
		myTree.addNode(new NodeClass(15));
		myTree.addNode(new NodeClass(38));
		myTree.addNode(new NodeClass(36));
		return myTree;
		
	}
}