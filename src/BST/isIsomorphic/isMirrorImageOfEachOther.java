/*
Question: Find whether two trees are isomorphic(mirror images) of each other
Question and Answer Source: http://www.morwalz.com/check-if-two-trees-are-isomorphic-to-each-other-java-code/
	
Explanation:
Two trees are called Isomorphic only and only if both trees are mirror image of each other from every node.
So I wrote a function called isIsomorphic . 
This will return one if both trees are isomorphic and 0 if both are not isomorphic.

Other Sources: http://tech-queries.blogspot.com/2010/04/isomorphic-trees.html
*/
package BST.isIsomorphic;

public class isMirrorImageOfEachOther {
	public static void main(String[] args) {
		
	}
	public static int isIsomorphic(Node root1,Node root2) {
		int result =0;
		//Check if both trees are null
		    if(root1==null&& root2==null){
		        result=1;
		    }
		    //if only null
		    else if(root1==null ||root2==null){
		        result=0;
		    }
		    //if both are not null
		    else{
		        if(root1.val == root2.val)
		           {
		               if((root1.left.val==root2.right.val)&&(root1.left.val==root2.right.val))
		               {
		                   if(isIsomorphic(root1.left.left,root2.right.left)==1 && 	isIsomorphic(root1.left.right,root2.right.right)==1)
		                       result=1;
		               }
		           }
		       }

		      return result;
		    
		
	}
}
class Node {
	Node left, right;
	int val;
	Node() {
	left = right = null;
	}
}