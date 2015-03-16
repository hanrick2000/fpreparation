/*
Question: Remove BST keys outside the given range
Question and Answer Source: http://www.geeksforgeeks.org/remove-bst-keys-outside-the-given-range/
*/

	
package BST.MinMaxSpanSubtree;

import java.util.Scanner;


public class UsingRecursion {
	
		public static void main(String[] args) {
			Scanner in = new Scanner(System.in);
			try{
			@SuppressWarnings("unused")
			BST bst = BinSearchTree.makeTree();
			BST.display();
			System.out.println("Enter the min value of subtree");
			int min = in.nextInt();

			System.out.println("Enter the max value of subtree");
			int max = in.nextInt();
			Node subtreeRoot = removeOutsideRange(BST.root,min,max);
			BST.display(subtreeRoot);
			}
			finally{
				in.close();
			}
		}
/*
 * Source: http://www.geeksforgeeks.org/remove-bst-keys-outside-the-given-range/
 */
		private static Node removeOutsideRange(Node root, int min, int max) {
			
			// Base Case
			   if (root == null)
			      return null;
			   
			   // First fix the left and right subtrees of root (POST ORDER TRAVERSAL)
			   root.left =  removeOutsideRange(root.left, min, max);
			   root.right =  removeOutsideRange(root.right, min, max);
			   
			// Now fix the root.  There are 2 possible cases for toot
			   // 1.a) Root's key is smaller than min value (root is not in range)
			   if (root.val < min)
			   {
			       Node rchild = root.right;
			       return rchild;
			   }
			   // 1.b) Root's key is greater than max value (root is not in range)
			   if (root.val > max)
			   {
			       Node lchild = root.left;
			       return lchild;
			   }
			   // 2. Root is in range
			   return root;
			
		}
	
}
class Node {
    int val;
    Node left;
    Node right;
    Node(int x) { val = x; }
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
		
		return myTree;
	}
}
class BST {
	public static Node root=null;

		public void addNode(Node n){
			if(root==null)
			{
				root=n;
				System.out.println(n.val+" added as the root to the tree");
			}
			else{
				
				Node current=root;
				Node parent;
				while(true){
					parent=current;
					
					if(n.val<current.val){
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
		public static void display(){
			display(root);
			System.out.println();
		}
		
		public static void display(Node n){
			Node tempNode=n;
			if(tempNode==null)
				return;
			else{
			    display(tempNode.left);
				System.out.print(tempNode.val+" ");
				display(tempNode.right);
			}
		}
}