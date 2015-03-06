/*
Question: Find the min depth of the BST
Question Source: http://www.careercup.com/question?id=4476686
Iterative Solution Source: http://www.programcreek.com/2013/02/leetcode-minimum-depth-of-binary-tree-java/
Recursive Solution Source: https://oj.leetcode.com/discuss/9792/my-solution-to-minimum-depth-of-binary-tree
*/
package BST.minDepth;

import java.util.LinkedList;
import java.util.Queue;


public class IterativeAndRecursiveSolution {
	public static void main(String[] args) {
		BST bst = BinSearchTree.makeTree();
		bst.display();
		System.out.println("Iterative Solution is: "+iterativeMinDepth(bst.root));
		System.out.println("Recursive Solution is: "+recursiveMinDepth(bst.root));		
	}
	public static int iterativeMinDepth(Node root) {
		// Iterative Solution Source: http://www.programcreek.com/2013/02/leetcode-minimum-depth-of-binary-tree-java/
        // This is a BFS traversal. The while loop is a BFS traversal
		
		if(root == null){
            return 0;
        }
 
        Queue<Node> nodes = new LinkedList<Node>();
        Queue<Integer> counts = new LinkedList<Integer>();
        
        nodes.add(root);
        counts.add(1);
        
        while(!nodes.isEmpty()){
            Node curr = nodes.remove();
            int count = counts.remove();
            
            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
 
            if(curr.left == null && curr.right == null){        // VERY IMP CONDITION
                return count;
            }
        }
 
        return 0;
    
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n)
	 * Space Complexity = O(2n)
	 */
	 public static int recursiveMinDepth(Node root) {
		 // This is done using pre-order traversal, where we recurse through the whole tree and then determine what
		 // the minimum depth would be.
		 // Recursive Solution Source: https://oj.leetcode.com/discuss/9792/my-solution-to-minimum-depth-of-binary-tree


		    if (root == null)
		        return 0;

		    int left = recursiveMinDepth(root.left);
		    int right = recursiveMinDepth(root.right);

		    if (left == 0 && right == 0) // leaf
		        return 1;
		    else if (left == 0) 
		        return 1 + right;
		    else  if (right == 0)
		        return 1 + left;
		    else
		        return 1 + Math.min(left, right);
		}
	 /*
	  * Analysis:
	  * Time Complexity = O(n)
	  * Space Complexity = O(1)
	  */
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
		myTree.display();
		
		
		return myTree;
	}
}
class BST {
	public Node root=null;

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
				System.out.print(tempNode.val+" ");
				display(tempNode.right);
			}
		}
}