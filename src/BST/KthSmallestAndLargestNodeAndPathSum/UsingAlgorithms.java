/*
Question: Find the k'th smallest and largest element in a binary search tree.
Question Source: http://www.careercup.com/question?id=15645665
Answer Source: http://geekyjumps.blogspot.com/2013/09/find-kth-largest-element-in-binary.html

Algorithm:
1. For Largest element -> Do a POSTORDER traversal
2. For Smallest element -> Do a PREORDER traversal
*/

package BST.KthSmallestAndLargestNodeAndPathSum;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


public class UsingAlgorithms { 
	
	private static int index=0;
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		try{
		
		System.out.println("Enter the number elements of the SORTED array");
		int n = in.nextInt();
		int[] a = new int[n];
		System.out.println("Enter the elements");
		for(int i=0;i<n;i++)
			a[i]=in.nextInt();
		
		Node root = createTree(a,0,a.length-1);
		System.out.println("Enter the kth largest element to be found in the tree");
		int k = in.nextInt();
		System.out.println("The kth smallest element in the tree is: ");
		findKthSmallestNode(root,k);
		index=0;
		System.out.println("The kth largest element in the tree is: ");
		findKthLargestNode(root,k);
		// PathSum
		System.out.println("Enter the path sum to be checked in the BST");
		int sum = in.nextInt();
		System.out.println("The BST has the pathSum ? by recursive solution "+recursiveHasPathSum(root, sum));
		System.out.println("The BST has the pathSum ? by iterative solution "+recursiveHasPathSum(root, sum));
		}
		finally{
			in.close();
		}
	}
	
	public static boolean recursiveHasPathSum(Node root, int sum){
		if(root==null)
			return (sum==0);
		else{
			int subSum = sum - root.value;
			boolean left = recursiveHasPathSum(root.left, subSum);
			boolean right = recursiveHasPathSum(root.right, subSum);
			return (left||right);
		}
	}
	
	public static boolean iterativeHasPathSum(Node root, int sum) {
		
		/* This is a BFS traversal. The while loop is a BFS traversal
		 * Source: http://www.programcreek.com/2013/01/leetcode-path-sum/
		 */
		
        if(root == null) 
        	return false;
 
        Queue<Node> nodes = new LinkedList<Node>();
        Queue<Integer> values = new LinkedList<Integer>();
 
        nodes.add(root);
        values.add(root.value);
 
        while(!nodes.isEmpty()){
            Node curr = nodes.remove();
            int sumValue = values.remove();
 
            if(curr.left == null && curr.right == null && sumValue==sum){  // VERY IMP CONDITION
                return true;
            }
 
            if(curr.left != null){
                nodes.add(curr.left);
                values.add(sumValue+curr.left.value);
            }
 
            if(curr.right != null){
                nodes.add(curr.right);
                values.add(sumValue+curr.right.value);
            }
        }
 
        return false;
    }
/*
 * Analysis:
 * Time Complexity = O(n)
 * Space Complexity = O(2n)
 */
	
private static void findKthLargestNode(Node root,int k) { 

	
	/*
	 * TR: I.  kth LARGEST = FIRST RIGHT THEN LEFT
	 *     II. Global Variable = index
	 */
		if(root==null)
			return;
		findKthLargestNode(root.right,k);  // First RIGHT
		if(++index==k){
			System.out.println(root.value);
			return;
		}
		findKthLargestNode(root.left, k);  // then LEFT
	}
/*
 * Analysis:
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */
private static void findKthSmallestNode(Node root, int k) {
	
	/*
	 * TR: I.  kth SMALLEST = FIRST LEFT THEN RIGHT
	 *     II. Global Variable = index
	 */
	if(root==null)
		return;

	findKthSmallestNode(root.left,k);     // First LEFT
	if(++index==k){
		System.out.println(root.value);    
		return;
	}
	findKthSmallestNode(root.right,k);   // then RIGHT
}
/*
 * Analysis:
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */
public static Node createTree(int[] a,int low, int high) {
	// create tree using sorted array by modified binary search algorithm
	
	if(high<low)
		return null;
	
	int mid = low+(high-low)/2;
	Node root = new Node(a[mid]); // call Node constructor
	root.left= createTree(a, low, mid-1); // recursive call
	root.right = createTree(a, mid+1, high); // recursive call
	
    return root;
	}
}
class Node{
int value;
Node left;
Node right;

	public Node(int data){
		this.value = data;
	}
}
/*
 * Analysis for each program, kth smallest and kth largest:
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */
