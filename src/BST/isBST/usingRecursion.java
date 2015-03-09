/*
Question: Check whether a tree is a BST
Question and Answer Source: http://www.programcreek.com/2012/12/leetcode-validate-binary-search-tree-java/
*/
package BST.isBST;


//Definition for binary tree
class TreeNode {
int val;
TreeNode left;
TreeNode right;

TreeNode(int x) {
	val = x;
}
}

public class usingRecursion {

public static boolean isValidBST(TreeNode root) {
	return validate(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
}

public static boolean validate(TreeNode root, int min, int max) {
	if (root == null) {
		return true;
	}

	// not in range
	if (root.val <= min || root.val >= max) {
		return false;
	}

	// left subtree must be < root.val && right subtree must be > root.val
	return validate(root.left, min, root.val) && validate(root.right, root.val, max);
}
}
