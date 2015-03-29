/*
Question : Check whether a BST is valid BST

Question & Answer Source: http://www.careercup.com/question?id=5632735657852928
	
Algorithm:
	1. Recursively go to each node starting from root
	2. if node== null then return true    // null tree is BST
	3. if node is leaf then return true   // all leaf nodes are BST
	4. if node.value > MIN and node.value < MAX then
			BOTH left and right child should also satisfy the same property
	   else if node.value < MIN and node.value > MAX then return false
*/

package BST.isBST;

public class CheckWhetherBSTIsValid {
	public static void main(String[] args) {
		Node a = new Node(10);
	    Node b = new Node(5);
	    Node c = new Node(20);
	    Node d = new Node(1);
	    Node e = new Node(9);
	    Node f = new Node(15);
	    Node g = new Node(12);
	    Node h = new Node(17);
	    Node i = new Node(25);
	    a.left = b;
	    a.right = c;
	    b.left = d;
	    b.right = e;
	    c.left = f;
	    f.left = g;
	    f.right = h;
	    c.right = i;
	    System.out.println("Tree is valid BST, true or false ? Ans: "+isValidBST(a,Integer.MIN_VALUE,Integer.MAX_VALUE));
	}

	private static boolean isValidBST(Node a, int minValue, int maxValue) {
		if(a==null)
			return true;    // null tree is a valid BST
		if(a.left==null && a.right==null)  
			return true;    // leaf node is a valid BST
		if(a.value > minValue && a.value<maxValue)   // check for the left and right to satify the 
// property that the   "minValue<node.value<maxValue" . If BOTH left and right satify the property then TRUE else FALSE
			return (isValidBST(a.left, minValue, a.value) && isValidBST(a.right, a.value, maxValue));
		else
			return false;
	}
	/*
	 * Analysis:
	 * Time Coplexity = O(n)
	 * Space Complexity = O(1)
	 */
	
	
}
class Node{
	int value;
	Node left;
	Node right;
	
	public Node(int data){
		this.value = data;
	}
}
