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
 
public class UsingTwoColorAlgorithm {
	
		private static int[][] adjacencyMatrix;	
	    private int numberOfVertices;
	    private Queue<Integer> queue;
	 
	    public static final int NO_COLOR = 0;
	    public static final int RED = 1;
	    public static final int BLUE = 2;
	 
	    public UsingTwoColorAlgorithm(int numberOfVertices){
	        this.numberOfVertices = numberOfVertices;
	        queue = new LinkedList<Integer>();
	    }
	 
	    public boolean isBipartite(int source){
	    
	        int[] colored = new int[numberOfVertices];
	        for (int vertex = 0; vertex < numberOfVertices; vertex++)
	        {
	            colored[vertex] = NO_COLOR;
	        }
	        colored[source] = RED;
	        queue.add(source);
	
	        int element, neighbour;
	        while(!queue.isEmpty()){
	            element = queue.remove();
	            neighbour = 0; 
	            // We have to exhaustively visit all the neighbours irrespective of whether it is visited previously or not
	            // Hence we dont require visited[] array and thus we also dont require 
	            // getUnvisitedChildNode(Node current) since we exhaustively visit all the neighbours
	            while (neighbour < numberOfVertices)
	            { 	
	            	if(neighbour!=element){  // dont consider edge from vertex to same vertex i.e. loop edge. [Example: edge from node 0 to node 0]
	            		if (adjacencyMatrix[element][neighbour] == 1 && colored[element]== colored[neighbour])
	                	{
	                    	return false;
	                	}
	            		else if (adjacencyMatrix[element][neighbour] == 1 && colored[neighbour]== NO_COLOR)
	                	{
	                		colored[neighbour] = (colored[element]==RED) ? BLUE:RED;
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
	 
	           UsingTwoColorAlgorithm bipartiteBfs = new UsingTwoColorAlgorithm(number_of_nodes);
	           if (bipartiteBfs.isBipartite(source)) 
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
