
/*
Question: Clone a graph

Question Source: http://leetcode.com/2012/05/clone-graph-part-i.html

Answer Source: http://www.programcreek.com/2012/12/leetcode-clone-graph-java/
	
IMP Sources: http://leetcode.com/2012/05/clone-graph-part-i.html
*/
package CloneADirectedORUndirectedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/*
 * VERY IMP NOTE: The same code can be used for DIRECTED OR UNDIRECTED Graphs WITH OR WITHOUT CYCLES
 * 1. Code works for DIRECTED AS WELL AS UNDIRECTED graphs
 * 2. Code works for graphs WITH CYCLES OR WITHOUT CYCLES
 * 
 */
/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     ArrayList<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class UsingBFS {
	
	// IMP: http://www.programcreek.com/2012/12/leetcode-clone-graph-java/
	
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node == null)
            return null;
 
        LinkedList<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = 
                                   new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
 
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);
 
        queue.add(node);          // add the node
        map.put(node, newHead);   // map the node
 
        while(!queue.isEmpty()){
            UndirectedGraphNode curr = queue.pop();  // get the node
            ArrayList<UndirectedGraphNode> currNeighbors = curr.neighbors; // get the neighbors 
 
            for(UndirectedGraphNode aNeighbor: currNeighbors){
                if(!map.containsKey(aNeighbor)){
                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label);
                    map.put(aNeighbor,copy);
                    map.get(curr).neighbors.add(copy);
                    queue.add(aNeighbor);
                }else{
                    map.get(curr).neighbors.add(map.get(aNeighbor));
                }
            }
 
        }
        return newHead;
    }
}
class UndirectedGraphNode {
	      int label;
	      ArrayList<UndirectedGraphNode> neighbors;
	      
	      UndirectedGraphNode(int x) { 
	    	  label = x; 
	    	  neighbors = new ArrayList<UndirectedGraphNode>(); 
	    	  }
	 }