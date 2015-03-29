/*
 * Question: Detect cycle in directed graph
 * Question and Answer Source: http://www.geeksforgeeks.org/detect-cycle-in-a-graph/
 * 
 * Explanation:
 * Depth First Traversal can be used to detect cycle in a Graph. DFS for a connected graph produces a tree. 
 * There is a cycle in a graph only if there is a back edge present in the graph. 
 * A back edge is an edge that is from a node to itself (selfloop) or one of its ancestor in the tree produced by DFS.

To detect a back edge, we can keep track of vertices currently in recursion stack of function for DFS traversal. 
If we reach a vertex that is already in the recursion stack, then there is a cycle in the tree. 
The edge that connects current vertex to the vertex in the recursion stack is back edge. 
We have used recStack[] array to keep track of vertices in the recursion stack.
 */


package Graph.DetectCycleInDirectedGraph;

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
class Graph
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
 
    public boolean isCyclicUtil(int v, boolean[] visited, boolean[] recStack)
    {
    if(visited[v] == false)
    {
        // Mark the current node as visited and part of recursion stack
        visited[v] = true;
        recStack[v] = true;
 
        // Recur for all the vertices adjacent to this vertex
        Iterator<Edge> itr = adj.iterator();
        while(itr.hasNext())
        {
        	Edge e = itr.next();
        	if(e.src==v){
        		if ( !visited[e.dest] && isCyclicUtil(e.dest, visited, recStack) )
        			return true;
        		else if (recStack[e.dest])
        			return true;
        	}
        }
 
    }
    recStack[v] = false;  // remove the vertex from recursion stack
    return false;
}
 
// Returns true if the graph contains a cycle, else false.
// This function is a variation of DFS() in http://www.geeksforgeeks.org/archives/18212
public boolean isCyclic()
{
    // Mark all the vertices as not visited and not part of recursion
    // stack
    boolean[] visited = new boolean[V];
    boolean[] recStack = new boolean[V];
    for(int i = 0; i < V; i++)
    {
        visited[i] = false;
        recStack[i] = false;
    }
 
    // Call the recursive helper function to detect cycle in different
    // DFS trees
    for(int i = 0; i < V; i++)
        if (isCyclicUtil(i, visited, recStack))
            return true;
 
    return false;
}
 
public static void main(String[] args) {
    // Create a graph given in the above diagram
    Graph g= new Graph(4);
    g.addEdge(0, 1);
    g.addEdge(0, 2);
    g.addEdge(1, 2);
    g.addEdge(2, 0);
    g.addEdge(2, 3);
    g.addEdge(3, 3);
 
    if(g.isCyclic())
        System.out.println("Graph contains cycle");
    else
        System.out.println("Graph doesn't contain cycle");
    
	}
}
/*
Analysis:
Time Complexity= The program does a simple DFS Traversal of graph and graph is 
represented using adjacency list. So the time complexity is O(V+E)
Space Complexity = O(V+E)
*/