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
 * class GraphNode {
 *     int label;
 *     ArrayList<GraphNode> neighbors;
 *     GraphNode(int x) { label = x; neighbors = new ArrayList<GraphNode>(); }
 * };
 */
public class UsingBFS {
		
	// IMP: http://www.programcreek.com/2012/12/leetcode-clone-graph-java/
	
    public GraphNode cloneGraph(GraphNode node) {
        if(node == null)
            return null;
        
        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        HashMap<GraphNode, GraphNode> map = new HashMap<GraphNode,GraphNode>();
        
        // CAM = THREE IMP POINTS (Clone, Add, Map)
        GraphNode newHead = new GraphNode(node.label); // CLONE
        queue.add(node);          // ADD
        map.put(node, newHead);   // MAP
 
        while(!queue.isEmpty()){
            GraphNode curr = queue.remove();  // remove the node
            ArrayList<GraphNode> currNeighbors = curr.neighbors; // get the neighbors 
            
            for(GraphNode aNeighbor: currNeighbors){
               
            	
            	if(!map.containsKey(aNeighbor)){
            		// CAM = THREE IMP POINTS (Clone, Add, Map)
                    GraphNode copy = new GraphNode(aNeighbor.label); // CLONE
                    queue.add(aNeighbor);         // ADD
                    map.put(aNeighbor,copy);      // MAP
                    // Add cloned neighbor to cloned node
                    map.get(curr).neighbors.add(copy); // this is same as the below line "map.get(curr).neighbors.add(map.get(aNeighbor))"
                }
                else{
                    map.get(curr).neighbors.add(map.get(aNeighbor));
                }
            	
            	
            }
        }
        return newHead;
    }
}
class GraphNode {
	      int label;
	      ArrayList<GraphNode> neighbors;
	      
	      public GraphNode(int x) {
	    	  label = x;
	    	  neighbors = new ArrayList<GraphNode>(); 
	      }
	 }