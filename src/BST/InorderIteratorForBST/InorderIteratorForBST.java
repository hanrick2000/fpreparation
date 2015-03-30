/* Question: In order iterator for BST
 * Question Source: http://vosggll.blogspot.com/2014/12/fb.html
 * Answer Source: http://stackoverflow.com/questions/12850889/in-order-iterator-for-binary-tree
 * 
 * EXAMPLE:
 * Consider the following tree:

     d
   /   \
  b     f
 / \   / \
a   c e   g
The first element is "fully left from the root"
a does not have a right child, so the next element is "up until you come from left"
b does have a right child, so iterate b's right subtree
c does not have a right child. It's parent is b, which has been traversed. The next parent is d,
 which has not been traversed, so stop here.
d has a right subtree. Its leftmost element is e.
...
g has no right subtree, so walk up. f has been visited, since we've come from right. d has been visited.
 d has no parent, so we cannot move further up. We have come from the rightmost node and we're done iterating.
 */



package BST.InorderIteratorForBST;

import java.util.NoSuchElementException;

public class InorderIteratorForBST {
		  private Node next;

		  public InorderIteratorForBST(Node root){
		     next = root;
		     if(next == null)
		       return;
		     while (next.left != null)
		       next = next.left;
		  }

		  public boolean hasNext(){
		     return next != null;
		  }

		  public Node next(){
		     if(!hasNext()) 
		    	 throw new NoSuchElementException();
		     Node r = next;
		     // if you can walk right, walk right, then fully left.
		     // otherwise, walk up until you come from left.
		     if(next.right != null){
		       next = next.right;
		       while (next.left != null)
		         next = next.left;
		       return r;
		     }else while(true){
		       if(next.parent == null){
		         next = null;
		         return r;
		       }
		       if(next.parent.left == next){
		         next = next.parent;
		         return r;
		       }
		       next = next.parent;
		     }
		   }
		 }
class Node{
	Node parent;
	Node left;
	Node right;
}