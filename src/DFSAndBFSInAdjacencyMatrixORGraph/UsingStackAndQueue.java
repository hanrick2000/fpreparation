package DFSAndBFSInAdjacencyMatrixORGraph;

import java.util.*;

/* http://www.codeproject.com/KB/java/BFSDFS/graph.PNG */
public class UsingStackAndQueue
{
    private static int[][] adjacencyMatrix;
    private static boolean[] visited;

    public static void main(String[] args)
    {
        int numNodes = 6;
        adjacencyMatrix = new int[numNodes][numNodes];
        visited = new boolean[numNodes];

        adjacencyMatrix[0][1] = 1;
        adjacencyMatrix[0][2] = 1;
        adjacencyMatrix[0][3] = 1;
        adjacencyMatrix[1][0] = 1;
        adjacencyMatrix[1][4] = 1;
        adjacencyMatrix[1][5] = 1;
        adjacencyMatrix[2][0] = 1;
        adjacencyMatrix[2][5] = 1;
        adjacencyMatrix[3][0] = 1;
        adjacencyMatrix[4][1] = 1;
        adjacencyMatrix[5][1] = 1;
        adjacencyMatrix[5][2] = 1;
        System.out.println("Undirected Graph Adj Matrix:");
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            System.out.println(Arrays.toString(adjacencyMatrix[i]));
        }

        System.out.println("DFS");
        dfs(0);

        System.out.println("BFS");
        bfs(0);
        
        
    }

    // Step 1: Push the root node in the Stack.
    // Step 2: Loop until stack is empty.
    // Step 3: Peek the node of the stack.
    // Step 4: If the node has unvisited child nodes, get the unvisited child
    // node, mark it as traversed and push it on stack.
    // Step 5: If the node does not have any unvisited child nodes, pop the node
    // from the stack.
    public static void dfs(int rootNode)
    {
        Stack<Integer> s = new Stack<Integer>();
        s.push(rootNode);                             // push
        visited[rootNode] = true;                     // visit
        printNode(rootNode);                          // print
        while (!s.isEmpty()) {
            int n = s.peek();   // Please NOTE this is peek() [NOT pop()]
            int child = -1;
            if ((child = getUnvisitedChildNode(n)) != -1)  {
                s.push(child);                             // push
                visited[child] = true;                     // visit              
                printNode(child);                          // print
            } else {  // If the node does not have any unvisited child nodes, pop the node
                s.pop();
            }
        }
        // Clear visited property of nodes
        clearAllVisited();
    }

    // Step 1: Push the root node in the Queue.
    // Step 2: Loop until the queue is empty.
    // Step 3: Remove the node from the Queue.
    // Step 4: If the removed node has unvisited child nodes, mark them as
    // visited and insert the unvisited children in the queue.
    public static void bfs(int rootNode)
    {
        // BFS uses Queue data structure
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(rootNode);                              // push
        visited[rootNode] = true;                     // visit              
        printNode(rootNode);                          // print
        while (!q.isEmpty()) {
            int n = q.remove();
            int child = -1;
            while ((child = getUnvisitedChildNode(n)) != -1) {
                q.add(child);                              // push
                visited[child] = true;                     // visit              
                printNode(child);                          // print
            }
        }
        // Clear visited property of nodes
        clearAllVisited();
    }

    private static void clearAllVisited()
    {
        for (int i = 0; i < visited.length; i++) {
            visited[i] = false;
        }
    }

    /**
     * walks through adjacency matrix to find
     * edges from this node 'n' to neighbouring
     * nodes which have not yet been visited
     * 
     * returns -1 if none found, ie. all visited/
     * no outgoing edges
     * 
     * @param n
     * @return
     */
    private static int getUnvisitedChildNode(int n)
    {
        // visit all columns for row n
        for (int i = 0; i < adjacencyMatrix[n].length; i++) {
            if (adjacencyMatrix[n][i] == 1 && !visited[i]) {
                return i;
            }
        }
        return -1;
    }

    private static void printNode(int node)
    {
        System.out.println("visited node: " + (char) (node + 'A'));
    }
   
}
/*
Analysis(For both DFS and BFS):
Source: http://stackoverflow.com/questions/11468621/why-is-the-time-complexity-of-both-dfs-and-bfs-o-v-e
	Time Complexity = O(n+e) where n=nodes, e=edges
	Space Complexity = O(n) + O(n) = O(2n)   where,
	first O(n) is used to store nodes [which is used either for Stack(dfs) OR Queue(bfs)]
	second O(n) is used to store the visited nodes array of size n where n=nodes
*/