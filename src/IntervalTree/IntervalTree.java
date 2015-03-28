package IntervalTree;


	class IntervalNode {
	    int startPos;
	    IntervalNode left;
	    IntervalNode right;
	    IntervalNode parent;
	   
	    public IntervalNode(int pos, IntervalNode par) {
	        if(startPos!=0)
	        	startPos = pos;
	        else
	        	startPos=0;
	        
	        left = right = null;
	        
	        if(par!=null)
	        	parent = par;
	        else
	        	parent=null;
	    }
	}
	public class IntervalTree {   
	    IntervalNode root;
	    int intervalSize;
	   
	    void insert( IntervalNode curNode, int pos ) {
	        if (pos < curNode.startPos) {
	            if (curNode.left!=null) 
	            	insert( curNode.left , pos );
	            else 
	            	curNode.left = new IntervalNode(pos, curNode);
	        }
	        else {
	            if (curNode.right!=null) 
	            	insert( curNode.right , pos );
	            else 
	            	curNode.right = new IntervalNode(pos, curNode);
	        }
	    }
	    boolean find(IntervalNode cur, int pos) {
	        if (cur == null)
	            return false;
	        if (cur.startPos == pos ) return true;
	        else if (cur.startPos > pos ) return find(cur.left, pos );
	        else return find(cur.right, pos);
	    }
	    void erase( IntervalNode cur, int pos ) {
	        if (cur == null)
	            return;
	        if (cur.startPos == pos) {
	            @SuppressWarnings("unused")   // tmp is unused
				IntervalNode tmp = cur, par = cur.parent, ptr;
	            if (par == null)     // root
	                ptr = root;
	            else
	                ptr = (par.left == cur) ? par.left : par.right;
	           
	            if (cur.right == null)
	                ptr = cur.left;
	            else {
	                ptr = cur.right;
	                if (cur.left != null) {
	                    IntervalNode leftsubtree = cur.right.left, it;
	                    cur.right.left = cur.left;
	                    cur = cur.right;
	                    cur.left.parent = cur;
	                    cur.parent = par;
	                    it = cur.left;
	                    while (it.right!=null)
	                        it = it.right;
	                    it.right = leftsubtree;
	                }
	            }

	        }
	        else if (cur.startPos < pos) erase( cur.left, pos);
	        else erase( cur.right, pos);
	    }

	    public IntervalTree() {
	        intervalSize = -1;  
	        root = null;
	    }
	    public void insert( int start, int end ) {
	        if (root == null) {
	            intervalSize = end-start;
	            root = new IntervalNode(start,null);
	        }
	        else
	            insert(root, start);
	    }
	    public boolean find(int start, int end) {
	        return find( root, start );
	    }
	    public void erase(int start, int end) {
	        erase(root, start);
	    }
	};