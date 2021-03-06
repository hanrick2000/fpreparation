
/*
 * 

Question:
The closest common ancestor in a tree forest in O(1) memory.


class Node {
    Node* parent; // == null for root of tree
    Node* left;
    Node* right;
}

Node* tree_forest[]; // array of pointers which points to roots of each tree respectively

Node* closest_common_ancestor(Node* n1, Node* n2) {
    // your solution
}
Example:


|    a     |   j
|   / \    |  /
|  b   c   | h
| /   / \  |
|d   e   f |
for e and d CCA is a 
for e and f CCA is c 
for e and c CCA is c 
for h and d CCA is null 

CONSTRAINS: O(1) ADDITIONAL MEMORY


Source: http://www.careercup.com/question?id=6715482117767168

 * ALGORITHM AND HINT:
 
Interviewer gave me a hint: it's better to consider the case when n1 and n2 lays on the same level of tree 
(in my example b, c, h lays on same level of trees) 

Case 1. 
Let's assume that n1 and n2 lays on the same level. 
In this case we can just go up over the tree simultaneously. 
Then we face situation when n1 == n2 we done. 

Case 2. 
1) We need to count level for both nodes. 
2) Align levels by following parent on node with higher level. 
3) Do Case 1 solution.
 
* Algorithm:
	        1. GET LEVELS of the two nodes
	        2. Make the LEVELS EQUAL irrespective of the fact whether nodes are in SAME tree or DIFFERENT tree
	        3. TRAVERSE THE PARENTS unless both parents are equal OR either parent is null 

*/

package BST.LCAInTreeForestAndSameTree;


public class UsingNodeLevels {

	public static void main(String[] args) {
		
		Node a = new Node('a');
		Node b = new Node('b');
		Node c = new Node('c');
		Node d = new Node('d');
		Node e = new Node('e');
		Node f = new Node('f');
		
		Node j = new Node('j');
		Node h = new Node('h');
		
		// Create the first tree BOTTOM UP fashion
		
		// Part 1: Set Parent
		e.parent=c;
		f.parent=c;
		d.parent=b;
		b.parent=a;
		c.parent=a;
		// Part 2: Set Left and Right Child
		a.left=b;
		a.right=c;
		b.left=d;
		c.left=e;
		c.right=f;
		
		// Create the second tree BOTTOM UP fashion
		
		// Part 1: Set Parent
		h.parent=j;
		// Part 2: Set Left and Right Child
		j.left=h;
		
		
		// Create a forest
		Node[] treeForest = new Node[2]; // array of pointers which points to roots of each tree respectively
		treeForest[0]=a;
		treeForest[1]=j;
		
		System.out.println("The LCA of e and h which are in DIFFERENT LEVEL DIFFERENT TREES is: "+getLCA(e, h));
		System.out.println("The LCA of c and h which are in SAME LEVEL DIFFERENT TREES is: "+getLCA(c, h));
		System.out.println("The LCA of d and c which are in DIFFERENT LEVEL SAME TREES is: "+getLCA(d, c));
		System.out.println("The LCA of f and e which are in SAME LEVEL SAME TREES is: "+getLCA(f, e));
		
		System.out.println(iterativeLCA(a, c, b));
		System.out.println(recursiveLCA(d, e, f));
	}
	
	
	
	public static Character getLCA(Node a, Node b){
		int level1 = getLevel(a);
		int level2 = getLevel(b);
		
		// make the two levels equal
		
		while(level1>level2){
			a=a.parent;
			level1--;
		}
		
		while(level2>level1){
			b=b.parent;
			level2--;
		}
		
		// Now both the levels are same
		
		/*
		 * Since both the levels are now same, 
		 * hence traverse the parents of the node until the parents are EQUAL
		 */
		
		while(a!=b && a!=null && b!=null){
			a=a.parent;
			b=b.parent;
		}
		
		
		if(a==b) // if a and b belong to same trees then either return a.data OR b.data
			return a.data;
		else //if a and b belong to different trees
			return null;
		
		
	}

	public static int getLevel(Node n){
		int level = 0;
		while(n!=null){
			n=n.parent;
			level++;
		}
		return level;
	}
	
	
	private static Node iterativeLCA(Node root, Node a, Node b) {
		
		if(root==null||a==null||b==null)
			return null;
		
		while(root!=null){
			if(a.data<root.data && b.data<root.data)
				root=root.left;
			else if(a.data>root.data && b.data>root.data)
				root=root.right;
			else break;
		}
		return root;
	}

	private static Node recursiveLCA(Node root, Node a, Node b) {
		
		// TR: THREE if, NO else
		
		
		if(root==null||a==null||b==null)
			return null;
		if(a.data<root.data && b.data<root.data)
			recursiveLCA(root.left,a,b);
		if(a.data>root.data && b.data>root.data)
			recursiveLCA(root.right,a,b);
		return root;
	}

}

class Node {
    Node parent; // == null for root of tree
    Node left;
    Node right;
    char data;
    
    public Node(char data){
    	this.data = data;
    	this.parent = null;
    	this.left = null;
    	this.right = null;
    }
}

/*
Analysis:
		Time Complexity = O(max(levelA,levelB))
		Space Complexity = O(1)
*/



/*   LCA in SAME TREE
 
 ITERATIVE SOLUTION:
 public Node LCA(Node root, Node n1, Node n2)
 {
    while (root != NULL)
    {
         // If both n1 and n2 are smaller than root, then LCA lies in left
        if (root.data > n1 && root.data > n2)
           root = root.left;
 
        // If both n1 and n2 are greater than root, then LCA lies in right
        else if (root.data < n1 && root.data < n2)
           root = root.right;
 
        else break;
    }
    return root;
 }
 
 RECURSIVE SOLUTION:
 public Node LCA(Node rootNode, Node p, Node q) {
         if (rootNode == null || p == null || q == null)
                 return null;
         if ((p.data < rootNode.data)&&(q.data < rootNode.data))
                 return LCA(rootNode.lchild, p, q);
         if ((p.data > rootNode.data)&&(q.data > rootNode.data))
                 return LCA(rootNode.rchild, p, q);
         return rootNode;
 }

 */