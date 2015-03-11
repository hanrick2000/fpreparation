/*
Question: Clone a graph
Question Source: http://leetcode.com/2012/05/clone-graph-part-i.html
Answer Source: http://www.programcreek.com/2012/12/leetcode-clone-graph-java/
IMP Sources: http://leetcode.com/2012/05/clone-graph-part-i.html
*/
package Graph.CloneADirectedORUndirectedGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * We can clone a graph using BFS or DFS Traversal. Here we will use BFS Traversal
 * VERY IMP NOTE: The same code can be used for DIRECTED OR UNDIRECTED Graphs WITH OR WITHOUT CYCLES
 * 1. Code works for DIRECTED AS WELL AS UNDIRECTED graphs
 * 2. Code works for graphs WITH CYCLES OR WITHOUT CYCLES
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
 
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = 
                                   new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
 
        UndirectedGraphNode newHead = new UndirectedGraphNode(node.label);              // CLONE
 
        queue.add(node);          // ADD
        map.put(node, newHead);   // MAP
 
        while(!queue.isEmpty()){
            UndirectedGraphNode curr = queue.poll();  // remove the node
            ArrayList<UndirectedGraphNode> currNeighbors = curr.neighbors; // get the neighbors 
 
            for(UndirectedGraphNode aNeighbor: currNeighbors){
                if(!map.containsKey(aNeighbor)){
                    UndirectedGraphNode copy = new UndirectedGraphNode(aNeighbor.label); // CLONE
                    queue.add(aNeighbor);         // ADD
                    map.put(aNeighbor,copy);      // MAP
                    map.get(curr).neighbors.add(copy);     // this is same as the below line "map.get(curr).neighbors.add(map.get(aNeighbor))"
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