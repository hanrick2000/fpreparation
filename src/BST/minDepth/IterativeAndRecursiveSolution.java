/*
Question: Find the min depth of the BST
Question Source: http://www.careercup.com/question?id=4476686
Iterative Solution Source: http://www.programcreek.com/2013/02/leetcode-minimum-depth-of-binary-tree-java/
Recursive Solution Source: https://oj.leetcode.com/discuss/9792/my-solution-to-minimum-depth-of-binary-tree
*/
package BST.minDepth;

import java.util.LinkedList;

public class IterativeAndRecursiveSolution {
	public static void main(String[] args) {
		
	}
	public int iterativeMinDepth(TreeNode root) {
		// Iterative Solution Source: http://www.programcreek.com/2013/02/leetcode-minimum-depth-of-binary-tree-java/
        if(root == null){
            return 0;
        }
 
        LinkedList<TreeNode> nodes = new LinkedList<TreeNode>();
        LinkedList<Integer> counts = new LinkedList<Integer>();
 
        nodes.add(root);
        counts.add(1);
 
        while(!nodes.isEmpty()){
            TreeNode curr = nodes.remove();
            int count = counts.remove();
 
            if(curr.left != null){
                nodes.add(curr.left);
                counts.add(count+1);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                counts.add(count+1);
            }
 
            if(curr.left == null && curr.right == null){
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
	 public static int recursiveMinDepth(TreeNode root) {
		 // This is done using pre-order traversal, where we recurse through the whole tree and then determine what
		 // the minimum depth would be.
		 // Recursive Solution Source: https://oj.leetcode.com/discuss/9792/my-solution-to-minimum-depth-of-binary-tree


		    if (root == null)
		    {
		        return 0;
		    }

		    int left = recursiveMinDepth(root.left);
		    int right = recursiveMinDepth(root.right);

		    if (left == 0 && right == 0) // leaf
		    {
		        return 1;
		    } else if (left == 0) 
		    {
		        return 1 + right;
		    } else  if (right == 0)
		    {
		        return 1 + left;
		    } else
		    {
		        return 1 + Math.min(left, right);
		    }
		}
	 /*
	  * Analysis:
	  * Time Complexity = O(n)
	  * Space Complexity = O(1)
	  */
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }
