/*
 * Question: Connect every node with the right node at every level in BST
 * Question Source: http://www.careercup.com/question?id=5678808906596352
 * Answer Source: https://zhongyinzhang.wordpress.com/2014/02/12/populating-next-right-pointers-in-each-node-ii/
 * https://zhongyinzhang.wordpress.com/2014/02/11/populating-next-right-pointers-in-each-node/
 * http://www.geeksforgeeks.org/connect-nodes-at-same-level-with-o1-extra-space/
 * 
 * Algorithm:
 * The idea is to find the next node that you can point to, by looking up the neighbors on the parent node.

Several cases need take into account,

1. If current node has left child and right child, just connect left child and right child, where the left child 
next will point to right child.

2. If current node has only one child, check current node neighbor and its left child if it exists, otherwise its
 right child if it exists. If the neighbor does not have any child, update the neighbor to neighbor neighbor where
  the neighbor is root.next;

3. In order to handle next pointers, during recursion, connect right tree first then left tree. This is to make sure
 the parent can find the valid neighbor.
 * 
 * 
 */

package BST.NextPointer;

class TreeLinkNode {
	      int val;
	      TreeLinkNode left, right, next;
	      TreeLinkNode(int x) {
	    	  val = x; 
	      }
}
public class NextPointer {
	// Recursive Solution (Tree can be any tree, perfect or not perfect)
	 public void connect(TreeLinkNode root) {
	        if(root == null){
	            return;
	        }
	        if(root.left != null){
	            if(root.right!=null){
	                root.left.next = root.right;
	            }else{
	                TreeLinkNode temp = root.next;
	                //find the first non-empty neighbor on parent level
	                while(temp!=null &&  temp.left == null &&  temp.right == null){
	                    temp = temp.next;
	                }
	                if(temp != null){
	                    if(temp.left != null){
	                        root.left.next = temp.left;
	                    }else if(temp.right != null){
	                        root.left.next = temp.right;
	                    }
	                }
	            }
	 
	        }
	 
	        if(root.right != null){
	            TreeLinkNode temp = root.next;
	            while(temp!=null && temp.left == null &&  temp.right == null){
	                temp = temp.next;
	            }
	            if(temp!=null){
	                if(temp.left!=null){
	                    root.right.next = temp.left;
	                }else if(temp.right != null){
	                    root.right.next = temp.right;
	                }
	            }
	        }
	 
	        //Connect right tree first
	         //so that the left node can connect to a valid right node
	        connect(root.right);
	        connect(root.left);
	    }
	 
	 // Recursive Solution (Tree has be perfect BST for this solution to work)
	 public void recursiveConnect(TreeLinkNode root) {
	        if(root == null){
	            return;
	        }
	        recursiveConnect(root.left, root.right);
	         
	    }
	    public void recursiveConnect(TreeLinkNode node1, TreeLinkNode node2){
	        if(node1 == null && node2 == null){
	            return;
	        }
	        node1.next = node2;
	        recursiveConnect(node1.left, node1.right);
	        recursiveConnect(node1.right, node2.left);
	        recursiveConnect(node2.left, node2.right);
	    }
}
