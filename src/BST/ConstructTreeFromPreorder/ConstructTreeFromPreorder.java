/*
 * Question: Construct BST from preorder traversal
 * Question and Answer Source: 
 * Recursive Solution:   http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
 * 						 http://www.fusu.us/2013/07/re-creating-binary-search-tree-given.html
 * Iterative Solution:   http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversal-set-2/
 *
 * 
 * Recursive Algorithm:
 * The idea used here is inspired from method 3 of this post. The trick is to set a range {min .. max} 
 * for every node. Initialize the range as {INT_MIN .. INT_MAX}. The first node will definitely be in range,
 * so create root node. To construct the left subtree, set the range as {INT_MIN …root->data}.
 * If a values is in the range {INT_MIN .. root->data}, the values is part part of left subtree.
 * To construct the right subtree, set the range as {root->data..max .. INT_MAX}.
 * 
 * ITERATIVE ALGORITHM:
1. Create an empty stack.
2. Make the first value as root. Push it to the stack.
3. Keep on popping while the stack is not empty and the next value is greater than stack’s top value.
Make this value as the right child of the last popped node. Push the new node to the stack.
4. If the next value is less than the stack’s top value, make this value as the left child of the 
stack’s top node. Push the new node to the stack.
5. Repeat steps 2 and 3 until there are items remaining in pre[].
 */

package BST.ConstructTreeFromPreorder;

import java.util.Stack;

public class ConstructTreeFromPreorder {
	private static int preOrderIndex=0;
	
	public static void main(String[] args) {
		int[] preOrder = new int[]{10, 5, 1, 7, 40, 50};
		Node root = constructTree(preOrder);
		System.out.println("Inorder traversal of the constructed tree is: ");
		iterativeInorder(root);
	}


	private static Node constructTree(int[] preOrder) {
		return recursiveConstructTreeUtil(preOrder,preOrder[0],Integer.MIN_VALUE,Integer.MAX_VALUE);
	}

	
	/**
	* NOTE:
	* @param preOrderIndex = private static global variable
	*/
	private static Node recursiveConstructTreeUtil(int[] preOrder, int key, int minValue, int maxValue) {
		
		// If the preOrder array is all visited (BASE CASE)
		if(preOrderIndex >= preOrder.length)
			return null;
		
		Node root = null;
		
		// If current element of preOrder array is in range then it is a part of the tree
	    if( key > minValue && key < maxValue){
	    	
	    	
	    	// Allocate memory for root of this subtree and increment preOrderIndex
	        root = new Node(key);
	        preOrderIndex++;
	    
	        // If the preOrder array is not completely visited 
	        if(preOrderIndex<preOrder.length){
	        	
			// Construct the subtree under root. All nodes which are in range {min .. key} will go in left
            root.left = recursiveConstructTreeUtil(preOrder, preOrder[preOrderIndex], minValue, key);
  
            // All nodes which are in range {key..max} will go in right
            root.right = recursiveConstructTreeUtil(preOrder,preOrder[preOrderIndex],key, maxValue);
			}
		
	    }
	    
	    return root;
	}

	private static void iterativeInorder(Node root) {
		Node current  = root;
		if(current==null)
			return;
		
		Stack<Node> s= new Stack<Node>();
		while(!s.isEmpty()||current!=null){
			
			if(current!=null){
				s.push(current);
				current=current.left;
			}
			else{
				current=s.pop();
				System.out.print(current.value+" ");
				current=current.right;
			}
		}
		
	}
}
class Node{
	int value;
	Node left;
	Node right;
	
	public Node(int n){
		this.value = n;
		this.left = null;
		this.right = null;
	}
}