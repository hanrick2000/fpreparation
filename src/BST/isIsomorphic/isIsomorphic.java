/*
Question: Find whether two trees are isomorphic
Question and Answer Source: 
	http://www.geeksforgeeks.org/tree-isomorphism-problem/
	http://stackoverflow.com/questions/742605/what-does-it-mean-for-two-binary-trees-to-be-isomorphic

Explanation:
Following conditions must fulfill to two trees to be isomorphic :
1. Two Tree are isomorphic if and only if they preserve same no of levels and same no of vertices in each level .

2.Two trees are isomorphic if and only if they have same degree spectrum .

3.Two trees are isomorphic if and only if they have same degree of spectrum at each level.

Total no of leaf descendant of a vertex and the level number of vertex are both tree tree isomorphic invariant .
IN Simple words :
Two trees are isomorphic is one tree can be obtained from other by performing any number of flips 
i.e swapping left childrens and right childrens of a number of node .

IMP Sources:
http://www.geeksforgeeks.org/tree-isomorphism-problem/
http://stackoverflow.com/questions/742605/what-does-it-mean-for-two-binary-trees-to-be-isomorphic
http://www.morwalz.com/check-if-two-trees-are-isomorphic-to-each-other-java-code/
*/
package BST.isIsomorphic;

public class isIsomorphic {
	public static void main(String[] args) {
		
	}
	public static boolean isIsomorphicTrees(Node root1,Node root2) {
		if(root1==null && root2==null)
			return true;
		if(root1==null||root2==null)
			return false;
		if(root1.val!=root2.val)                // NOTE: If we just want to test the Structure and NOT value of nodes then we can remove this condition
			return false;
		
		return(
				(isIsomorphicTrees(root1.left,root2.left)&&isIsomorphicTrees(root1.right,root2.right))   ||
				(isIsomorphicTrees(root1.left,root2.right)&&isIsomorphicTrees(root1.right,root2.left))
				);
	}
}
class Node {
	Node left, right;
	int val;
	
	public Node(int n) {
		val=n;
		left = null;
		right = null;
	}
}