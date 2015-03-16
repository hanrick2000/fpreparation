/*
 * 
 Question: Sink Zero in Binary Tree. Swap zero value of a node with non-zero value of one of its descendants 
so that no node with value zero could be parent of node with non-zero.

Question Source: http://www.careercup.com/question?id=5344154741637120

Algorithm:
1. First do a pre-order traversal
2. Now do a post-order traversal
	The result would be sinkZero Tree
 
OR vise-versa where we do first post-order and then pre-order traversal
 
 */


package BST.SinkZeroInBinaryTree;


public class UsingPreorderFollowedByPostOrder {
	public static void main(String[] args) {
		Node root = makeTree();        // make a small tree for hand running an example
		printTree(root);
		System.out.println();
		sinkZeroByPreOrder(root);
		printTree(root);
		System.out.println();
		sinkZeroByPostOrder(root);
		printTree(root);
		System.out.println();
		
	}


	private static void sinkZeroByPostOrder(Node n) {
		if(n==null)
			return;
		
		sinkZeroByPostOrder(n.left);
		sinkZeroByPostOrder(n.right);
		if(n.data==0){
			if(n.left!=null && n.left.data!=0){
				n.data=n.left.data;
				n.left.data=0;
			}
			else if(n.right!=null && n.right.data!=0){
				n.data=n.right.data;
				n.right.data=0;
			}
		}
		
	}
	

	private static void printTree(Node n) {
		if(n==null)
			return;
		
		System.out.print(n.data+" ");
		printTree(n.left);
		printTree(n.right);
	}

	private static void sinkZeroByPreOrder(Node n) {
		if(n==null)
			return;
		if(n.data==0){
			if(n.left!=null && n.left.data!=0){
				n.data=n.left.data;
				n.left.data=0;
			}
			else if(n.right!=null && n.right.data!=0){
				n.data=n.right.data;
				n.right.data=0;
			}
		}
		sinkZeroByPreOrder(n.left);
		sinkZeroByPreOrder(n.right);
	}

	private static Node makeTree() {
		Node one = new Node(0);
		Node two = new Node(3);
		Node three = new Node(0);
		Node four = new Node(1);
		Node five = new Node(6);
		Node six = new Node(44);
		Node seven = new Node(0);
		Node eight = new Node(0);
		Node nine = new Node(0);
		Node ten= new Node(0);
		Node eleven = new Node(8);
		Node twelve = new Node(12);
		Node thirteen = new Node(22);
		Node fourteen = new Node(20);
		Node fifteen = new Node(2);
		Node sixteen = new Node(23);
		Node seventeen = new Node(0);
		Node eighteen = new Node(0);
		Node nineteen = new Node(46);
		
		one.left=two;
		one.right=three;
		
		two.left=four;
		two.right=five;
		
		three.left=six;
		three.right=seven;
		
		four.left=eight;
		four.right=nine;
		
		five.left = ten;
		five.right=eleven;
		
		six.left=twelve;
		six.right=thirteen;
		
		seven.left=fourteen;
		seven.right=fifteen;
		
		eight.left=sixteen;
		eight.right=seventeen;
		
		nine.left=eighteen;
		nine.right=nineteen;
		
		return one;
		
	}
	/*private static Node makeSmallTree() {
		Node one = new Node(0);
		Node two = new Node(3);
		Node three = new Node(0);
		Node four = new Node(1);
		Node five = new Node(6);
		Node six = new Node(44);
		Node seven = new Node(0);
		Node eight = new Node(0);
		
		
		one.left=two;
		one.right=three;
		
		two.left=four;
		two.right=five;
		
		three.left=six;
		three.right=seven;
		
		four.left=eight;
		
		return one;
	}
*/
}
class Node{
	int data;
	Node left;
	Node right;
	
	public Node(int data){
		this.data = data;
		this.left=null;
		this.right=null;
	}
}
/*
Analysis: 
Time Complexity = O(2n) since each node is visited twice
Space Complexity = O(1)
*/