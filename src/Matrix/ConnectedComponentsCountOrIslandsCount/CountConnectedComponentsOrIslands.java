/*
 * Question: Find the number of islands OR connected components in a undirected graph
 * 
 * Question and Answer Source: http://www.geeksforgeeks.org/find-number-of-islands/
 * 
 * Algorithm: Using DFS we can find the connected components in a graph

What is an island?
A group of connected 1s forms an island. For example, the below matrix contains 5 islands

	                	{1, 1, 0, 0, 0},
                        {0, 1, 0, 0, 1},
                        {1, 0, 0, 1, 1},
                        {0, 0, 0, 0, 0},
                        {1, 0, 1, 0, 1}
 */


package Matrix.ConnectedComponentsCountOrIslandsCount;

public class CountConnectedComponentsOrIslands{
	public static void main(String[] args) {
		int[][] M= new int[][]{  {1, 1, 0, 0, 0},
		        				 {0, 1, 0, 0, 1},
		        				 {1, 0, 0, 1, 1},
		        				 {0, 0, 0, 0, 0},
		        				 {1, 0, 1, 0, 1}
							  };
		System.out.println("The number of islands OR connected components in UNDIRECTED graph is: "+countIslands(M));
	}
	/*
	 * We need three methods to solve this
	 * 1. countIslands --> contains count variable
	 * 2. DFS
	 * 3. validNeighbor
	 */
	private static int countIslands(int[][] M) {
		boolean[][] visited = new boolean[M.length][M[0].length];
		int count=0;
		for(int row = 0;row<M.length;row++)
			for(int column = 0;column<M[0].length;column++)
				if(M[row][column]==1 && !visited[row][column]){      // TWO VERY IMP CONDITIONS IN if
					DFS(M,row,column,visited);
					count++;
				}
		return count;
	}

	private static void DFS(int[][] M, int row, int column, boolean[][] visited) {
		// mark this node as VISITED
		visited[row][column] = true;
		
		// get the neighboring 8 nodes around this (row,column) node
		for(int rowNeighbor = row-1;rowNeighbor<=row+1;rowNeighbor++)
			for(int columnNeighbor = column-1;columnNeighbor<=column+1;columnNeighbor++)
		// we are looking for neighbors hence exclude the node when rowNeighbor==row && columnNeighbor==column 
				if(!(rowNeighbor==row && columnNeighbor==column) && (validNeighbor(M,rowNeighbor,columnNeighbor,visited)))
					DFS(M,rowNeighbor,columnNeighbor,visited);    // Now check for the neighbors of this node			
	}

	private static boolean validNeighbor(int[][] M, int rowNeighbor, int columnNeighbor, boolean[][] visited) {
	   /*
	    * 4 IMP Conditions: (TR: O O 1 V)
	    * 1. Out of Bounds = row             ---> O
	    * 2. Out of Bounds = column          ---> O
	    * 3. m[i][j] = 1                     ---> 1
	    * 4. NOT visited                     ---> V
	    */
		
		if( (rowNeighbor>=0 && rowNeighbor<M.length)                // neighbor is within the boundary of rowMatrix
		&& (columnNeighbor>=0 && columnNeighbor<M[0].length)       // neighbor is within the boundary of columnMatrix
		&& (M[rowNeighbor][columnNeighbor]==1)                     // neighbor has value 1
		&& (!visited[rowNeighbor][columnNeighbor]))                // neighbor is NOT VISITED
			return true;
		else
			return false;
	}
}
/*
 * Analysis:
 * 			Time Complexity = O(m*n) where m = number of rows and n = number of columns
 * 			Space Complexity = O(m*n) used by the visited matrix
 */