package BST.SubtreeMirrorDoubleSameisSymmetric;

public class SubtreeMirrorDoubleSameisSymmetric {
	
	// Check if tree is balanced
	public static boolean balTree(Node root){
		if(root==null)
			return true;
		else{
			int lheight=height(root.lchild);
			int rheight=height(root.rchild);
			if(Math.abs(lheight-rheight)>1)
				return false;
			else 
				return true;
		}
	}
	
	// Find maxDepth or height of the tree
	public static int height(Node root){
		if(root==null)
			return 0;
		else{
			int ltree= height(root.lchild);
			int rtree= height(root.rchild);
			return Math.max(ltree+1,rtree+1);
		}
	}
	
	// Find totalNodes OR size of tree
	public static int totalNodes(Node root){
			if(root==null)
				return 0;
			else{
				int ltree=totalNodes(root.lchild);
				int rtree=totalNodes(root.rchild);
				return (ltree+1+rtree);			
			}
	}
	
	/** Double the tree
	 Changes the tree by inserting a duplicate Node 
	 on each nodes's .lchild. 
	  
	 
	 So the tree... 
	    2 
	   / \ 
	  1   3

	 Is changed to... 
	       2 
	      / \ 
	     2   3 
	    /   / 
	   1   3 
	  / 
	 1

	 Uses a recursive helper to recur over the tree 
	 and insert the duplicates. 
	*/ 
	@SuppressWarnings("unused")
	private static void doubleTree(Node root) { 
	  if (root == null)
	        return;

	  // Go to the leaf nodes by recursive traversing
	  doubleTree(root.lchild); 
	  doubleTree(root.rchild);

	  // duplicate this Node to its lchild 
	  Node oldLeft = root.lchild; 
	  root.lchild = new Node(root.val); 
	  root.lchild.lchild = oldLeft; 
	} 
	
	/**
	 isSubTree
	 check whether one tree is subtree of another
	*/
	public static boolean isSubtree(Node main, Node sub){
        if(main==null) return false;
        if(sub == null) return true;
        return isSubtreeHelper(main, sub);
	}


	public static boolean isSubtreeHelper(Node main, Node sub){
        if(main == null) return false;
        
        if(main.val == sub.val)
                if (matchTwoTrees(main,sub)) return true;//don't use "return matchTwoTrees(main,sub)"
        //don't use if... else return isSub... here. 
        return isSubtreeHelper(main.lchild,sub)&&isSubtreeHelper(main.rchild,sub);
	}

	public static boolean matchTwoTrees(Node n1, Node n2){
        if(n1== null && n2 == null) return true;
        if(n1==null || n2 == null) return false;
        
        if(n1.val!=n2.val) return false;
        else
                return matchTwoTrees(n1.lchild,n2.lchild) && matchTwoTrees(n1.rchild,n2.rchild);
        
	}
	
	/** MIRROR
	 Changes the tree into its mirror image.

	 So the tree... 
	       4 
	      / \ 
	     2   5 
	    / \ 
	   1   3

	 is changed to... 
	       4 
	      / \ 
	     5   2 
	        / \ 
	       3   1

	 Uses a recursive helper that recurs over the tree, 
	 swapping the left/right pointers. 
	*/ 
	public static Node mirror(Node n){

		if(n==null)   // node does not exist
			return n;
			
		if(n.lchild!=null)  // left child present
			mirror(n.lchild);
			
		if(n.rchild!=null)  // rignt child present
			mirror(n.rchild);
		
		Node temp=n.lchild;  // swap left and right
		n.lchild=n.rchild;
		n.rchild=temp;
		
		return n;
	}
	
	
	/**  SAME TREE: Checks whether two trees are structurally same
	
	 Compares the receiver to another tree to 
	 see if they are structurally identical. 
	
	 Recursive helper -- recurs down two trees in parallel, 
	 checking to see if they are identical. 
	*/ 
	boolean sameTree(Node root1, Node root2) { 
	  // 1. both empty -> true 
	  if (root1==null && root2==null) return(true);

	  // 2. both non-empty -> compare them 
	  else if (root1!=null && root2!=null) { 
	    return( 
	      root1.val == root2.val && 
	      sameTree(root1.lchild, root2.lchild) && 
	      sameTree(root1.rchild, root2.rchild) 
	    ); 
	  } 
	  // 3. one empty, one not -> false 
	  else return(false); 
	} 
	
	
	/** isSymmetric
	  Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

      For example, this binary tree is symmetric:

          1
         / \
        2   2
       / \ / \
      3  4 4  3
      But the following is not:
          1
         / \
        2   2
         \   \
         3    3
      Note:
      Bonus points if you could solve it both recursively and iteratively. */
	
	public boolean isSymmetric(Node n){
		if (n==null)
			return true;
		else return isSubTreesSymmetric(n.lchild,n.rchild);
	}
	public boolean isSubTreesSymmetric(Node n1, Node n2){

		if(n1==null && n2==null)  // if both nodes are empty
			return true;
			
		else if(n1!=null && n2!=null)  // if both nodes are not empty
		                              // please note that n1.left compared with n2.right and vice-versa to check for mirror images
		return (n1.val==n2.val && isSubTreesSymmetric(n1.lchild, n2.rchild)&& isSubTreesSymmetric(n1.rchild, n2.lchild));
			
			
		else return false;  // if one of the nodes is empty and the other is not
	}
}
class Node{
	int val;
	Node lchild;
	Node rchild;
	public Node(int val){
		this.val = val;
		this.lchild = null;
		this.rchild = null;
	}
}