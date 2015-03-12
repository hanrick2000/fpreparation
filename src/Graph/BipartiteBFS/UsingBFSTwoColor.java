/*
Question: WAP to check whether a graph is bipartite 
Question and Answer Source: 
http://www.sanfoundry.com/java-program-check-whether-graph-bipartite-using-bfs/
http://www.geeksforgeeks.org/bipartite-graph/
*/
package Graph.BipartiteBFS;

import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
 
public class UsingBFSTwoColor {
	
		private static int[][] adjacencyMatrix;
	 

	    public boolean isBipartite(int source, int totalNodes){  // VERY IMP: parameter(argument) source
	    	
	    	
	    	/*
	    	 * This program WOULD WORK FOR BOTH directed and undirected graphs
	    	 * VERY IMP: 
	    	 * 1. Queue
	    	 * 2. colored[] array
	    	 * Parameters Passed:
	    	 * 1. Source
	    	 * 2. totalNodes
	    	 */
	    	
	    	
	        
	        final int NO_COLOR = 0;                                      // define colors
		    final int RED = 1;
		    final int BLUE = 2;
	        
		    Queue<Integer> queue = new LinkedList<Integer>();            // initialize Queue and colored array
	        int[] colored = new int[totalNodes];
	        
	        for (int vertex = 0; vertex < totalNodes; vertex++)          // color all nodes
	            colored[vertex] = NO_COLOR;
	        
	        colored[source] = RED;										 // color the source and add to queue
	        queue.add(source);
	
	        int currentNode; 										     // initialize currentNode and neighbor
	        int neighbour;
	        
	        
	        
	        
	        // We have to exhaustively visit all the neighbors irrespective of whether it is visited previously or not
            // Hence we don't require visited[] array and thus we also don't require 
            // getUnvisitedChildNode(Node current) since we exhaustively visit all the neighbors
	        while(!queue.isEmpty()){
	            currentNode = queue.remove();
	            neighbour = 0;
	            while (neighbour < totalNodes)
	            { 	
	            	if(neighbour!=currentNode){ // LOOP EDGE: don't consider edge from vertex to same vertex 
	            		//i.e. loop edge. [Example: edge from node 0 to node 0]
	            		if (adjacencyMatrix[currentNode][neighbour] == 1 && colored[currentNode]== colored[neighbour])
	                    	return false;
	            		else if (adjacencyMatrix[currentNode][neighbour] == 1 && colored[neighbour]== NO_COLOR)
	                	{
	                		colored[neighbour] = (colored[currentNode]==RED) ? BLUE:RED;
	                		queue.add(neighbour);
	                	}
	            		else{ // adjacencyMatrix[element][neighbour] == 1 && colored[element]!= colored[neighbour]
	            			// OR adjacencyMatrix[element][neighbour] == 0
	            			// then do nothing
	            		}
	            	}	
	                neighbour++;  // go to the next neighbour
	            }
	        }
	        return true;
	    }
	  
	    public static void main(String[] args) {
	        int number_of_nodes, source;
	        Scanner scanner = null;
	        try 
	        {
	           System.out.println("Enter the number of nodes in the graph");
	           scanner = new Scanner(System.in);
	           number_of_nodes = scanner.nextInt();
	           adjacencyMatrix = new int[number_of_nodes][number_of_nodes];
	           System.out.println("Enter the adjacency matrix");
	           // graph can be directed or undirected
	           for (int i = 0; i < number_of_nodes; i++)
	           {
	               for (int j = 0; j < number_of_nodes; j++)
	               {	
	            	   adjacencyMatrix[i][j] = scanner.nextInt();
	               }
	           }
	           System.out.println("Enter the source for the graph");
	           source = scanner.nextInt();
	 
	           UsingBFSTwoColor bipartiteBfs = new UsingBFSTwoColor();
	           if (bipartiteBfs.isBipartite(source,number_of_nodes)) 
	           {
	               System.out.println("The given graph is BIPARTITE");
	           } else
	           {
	               System.out.println("The given graph is NOT BIPARTITE");
	           }
	       } catch (InputMismatchException inputMismatch) 
	       {
	           System.out.println("Wrong Input format");
	       }
	       finally{
	       scanner.close();
	       }
	    }
	}
/*
 * Analysis:
 * Time Complexity = O(V^2) where V = number of vertices in the graph
 * Space Complexity = O(V^2) where V = number vertices in the graph used by adjacency matrix
 */
