
/*
 * Question: Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST.
 * 
 * Calling next() will return the next smallest number in the BST.

   Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
   
Solution Source: http://www.shuatiblog.com/blog/2015/04/15/Binary-Search-Tree-Iterator/

 */


package BST.BSTIterator;

import java.util.Stack;

class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
}
public class BSTIterator {
	Stack<TreeNode> stack = new Stack<TreeNode>();

    public BSTIterator(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        if (!hasNext()) {
            return 0;
        }
        TreeNode next = stack.pop();
        TreeNode node = next.right;
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        return next.val;
    }
    /*
     * Analysis:
     * Time Complexity = O(n)
     * Space Complexity = O(h) where h = height of the tree
     */
}