/*
 * Question: Detect cycle in Undirected graph
 * Question and Answer Source: http://www.geeksforgeeks.org/detect-cycle-undirected-graph/
 * Explanation:
 *  We can use DFS to detect cycle in an undirected graph in O(V+E) time. 
 *  We do a DFS traversal of the given graph. For every visited vertex ‘v’, 
 *  if there is an adjacent ‘u’ such that u is already visited and u is not parent of v, 
 *  then there is a cycle in graph. If we don’t find such an adjacent for any vertex, 
 *  we say that there is no cycle. 
 *  
 *  NOTE: The assumption of this approach is that there are no 
 *  parallel edges between any two vertices.
 * 
 */


package Graph.DetectCycleInUndirectedGraph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


class Edge{
	int src;
	int dest;
	public Edge(int src, int dest){
		this.src = src;
		this.dest = dest;
	}
}
public class Graph
{
    int V;    // No. of vertices
    List<Edge> adj;    // Pointer to an array containing adjacency lists
    
    public Graph(int V){  // Constructor
    	this.V = V;
    	this.adj = new ArrayList<Edge>();
    }

    public void addEdge(int v, int w){
    adj.add(new Edge(v,w)); // Add w to v’s list.
    }
	 
	// A recursive function that uses visited[] and parent to detect
	// cycle in subgraph reachable from vertex v.
	public boolean isCyclicUtil(int v, boolean[] visited, int parent)
	{
	    // Mark the current node as visited
	    visited[v] = true;
	 
	    // Recur for all the vertices adjacent to this vertex
	    Iterator<Edge> itr = adj.iterator();
	    while(itr.hasNext())
        {
        	Edge e = itr.next();
        	if(e.src==v){
	        // If an adjacent is not visited, then recur for that adjacent
        		if (!visited[e.dest])
        		{
        			if (isCyclicUtil(e.dest, visited, v))
	              return true;
        		}
	 
        		// If an adjacent is visited and not parent of current vertex,
        		// then there is a cycle.
        		else if (e.dest != parent)
        			return true;
        	}
	    }
	    return false;
	}
	 
	// Returns true if the graph contains a cycle, else false.
	public boolean isCyclic(){
	    // Mark all the vertices as not visited and not part of recursion
	    // stack
	    boolean[] visited = new boolean[V];
	    for (int i = 0; i < V; i++)
	        visited[i] = false;
	 
	    // Call the recursive helper function to detect cycle in different
	    // DFS trees
	    for (int u = 0; u < V; u++)
	        if (!visited[u]) // Don't recur for u if it is already visited
	          if (isCyclicUtil(u, visited, -1))
	             return true;
	 
	    return false;
	}
	 
	// Driver program to test above functions
	public static void main(String[] args){
	    Graph g1=new Graph(5);
	    g1.addEdge(1, 0);
	    g1.addEdge(0, 2);
	    g1.addEdge(2, 0);
	    g1.addEdge(0, 3);
	    g1.addEdge(3, 4);
	    String s1 = g1.isCyclic()? "Graph contains cycle\n":"Graph doesn't contain cycle\n";
	    System.out.println(s1);
	    
	    Graph g2=new Graph(3);
	    g2.addEdge(0, 1);
	    g2.addEdge(1, 2);
	    String s2 = g2.isCyclic()? "Graph contains cycle\n": "Graph doesn't contain cycle\n";
	    System.out.println(s2);
	}
}
/*
Analysis:
Time Complexity= The program does a simple DFS Traversal of graph and graph is 
represented using adjacency list. So the time complexity is O(V+E)
Space Complexity = O(V+E)
*/