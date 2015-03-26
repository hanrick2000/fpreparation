package ContinentalDivide;

import java.util.ArrayList;


/*
 * Question: You are given a 2d rectangular array of positive integers representing the height map of a continent.
The "Pacific ocean" touches the left and top edges of the array and the "Atlantic ocean" touches the right and 
bottom edges. 
- Find the "continental divide". That is, the list of grid points where water can flow either to the Pacific or
 the Atlantic. 
Water can only flow from a cell to another one with height equal or lower. 

Example: 

Pacific ~ ~ ~ ~ ~ |__ 
~ 1 2 2 3 (5) ~ 
~ 3 2 3 (4)(4) ~ 
~ 2 4 (5) 3 1 ~ 
~ (6)(7) 1 4 5 ~ 
__ (5) 1 1 2 4 ~ 
|~ ~ ~ ~ ~ Atlantic 

The answer would be the list containing the coordinates of all circled cells: 
[(4,0), (3,1), (4,1), (2,2), (0,3), (1,3), (0,4)]



 * 
 * Question and Answer Source: http://www.careercup.com/question?id=5162862051852288
 * 
 * Difference between |(bitwise) and ||(logical) operators: http://stackoverflow.com/questions/7101992/why-do-we-usually-use-not-what-is-the-difference
 * 
 * Algorithm:
 * Could probably be made a little bit more efficient but I verified that it works. 
 * Idea is to try dropping water on every square and let it flow to the square's neighbors
 *  (if they have a height that is less than or equal to the current square's height), and then update information 
 *  about the current square.
 * 
 */
public class UsingAlgorithm {
	    public static class Square {
	        public boolean canReachPacific;
	        public boolean canReachAtlantic;
	        public boolean visited;

	        public Square() {
	            canReachPacific = false;
	            canReachAtlantic = false;
	            visited = false;
	        }
	    }

	    private static class Position {
	        public int row, col;

	        public Position(int row, int col) {
	            this.row = row;
	            this.col = col;
	        }

	        public String toString() {
	            return "(" + row + ", " + col + ")";
	        }
	    }

	    public static ArrayList<Position> getContinentalDivide(int[][] height) {
	        int nrows = height.length;
	        int ncols = height[0].length;
	        Square[][] grid = new Square[nrows][ncols];

	        // create Square objects
	        for (int row = 0; row < nrows; row++) {
	            for (int col = 0; col < ncols; col++) {
	                grid[row][col] = new Square();
	            }
	        }
	        /*
	         * Given that the "Pacific ocean" touches the LEFT AND TOP EDGES of the array and 
	         * the "Atlantic ocean" touches the RIGHT AND BOTTOM edges. 
	         */
	        
	        // mark .canReachPacific and .canReachAtlantic as true for edges
	        // mark the square edge box points as true
	        for (int row = 0; row < nrows; row++) {
	            grid[row][0].canReachPacific = true;
	            grid[row][ncols-1].canReachAtlantic = true;
	        }
	        for (int col = 0; col < ncols; col++) {
	            grid[0][col].canReachPacific = true;
	            grid[nrows-1][col].canReachAtlantic = true;
	        }

	        // visit every square and drop water on it
	        for (int row = 0; row < nrows; row++) {
	            for (int col = 0; col < ncols; col++) {
	                if (!grid[row][col].visited)
	                    dropWater(row, col, grid, height);
	            }
	        }
	        
	        // After dropping water, visit every square and check whether it can reach BOTH Pacific and Atlantic.
	        // If BOTH YES, then add this point to continental divide array list.
	        ArrayList<Position> divide = new ArrayList<Position>();
	        for (int row = 0; row < nrows; row++) {
	            for (int col = 0; col < ncols; col++) {
	                if (grid[row][col].canReachPacific && grid[row][col].canReachAtlantic)
	                    divide.add(new Position(row, col));
	            }
	        }

	        return divide;
	    }

	    // Drop water on a square, let it flow to surrounding squares(up, down, left and right) if possible,
	    // and then update the current square's .canReachPacific and .canReachAtlantic
	    // instance variables
	    public static void dropWater(int row, int col, Square[][] grid, int[][] height) {
	        int nrows = height.length;
	        int ncols = height[0].length;

	        grid[row][col].visited = true;

	        // up
	        if (row != 0 && height[row][col] >= height[row-1][col]) {
	            if (!grid[row-1][col].visited)
	                dropWater(row-1, col, grid, height);
	            grid[row][col].canReachPacific |= grid[row-1][col].canReachPacific;
	            grid[row][col].canReachAtlantic |= grid[row-1][col].canReachAtlantic;
	        }

	        // down
	        if (row != nrows-1  && height[row][col] >= height[row+1][col]) {
	            if (!grid[row+1][col].visited)
	                dropWater(row+1, col, grid, height);
	            grid[row][col].canReachPacific |= grid[row+1][col].canReachPacific;
	            grid[row][col].canReachAtlantic |= grid[row+1][col].canReachAtlantic;
	        }

	        // left
	        if (col != 0 && height[row][col] >= height[row][col-1]) {
	            if (!grid[row][col-1].visited)
	                dropWater(row, col-1, grid, height);
	            grid[row][col].canReachPacific |= grid[row][col-1].canReachPacific;
	            grid[row][col].canReachAtlantic |= grid[row][col-1].canReachAtlantic;
	        }

	        // right
	        if (col != ncols-1 && height[row][col] >= height[row][col+1]) {
	            if (!grid[row][col+1].visited)
	                dropWater(row, col+1, grid, height);
	            grid[row][col].canReachPacific |= grid[row][col+1].canReachPacific;
	            grid[row][col].canReachAtlantic |= grid[row][col+1].canReachAtlantic;
	        }
	    }

	    public static void main(String[] args) {
	        int[][] height = {
	            {1, 2, 2, 3, 5},
	            {3, 2, 3, 4, 4},
	            {2, 4, 5, 3, 1},
	            {6, 7, 1, 4, 5},
	            {5, 1, 1, 2, 4}
	        };

	        ArrayList<Position> divide = getContinentalDivide(height);

	        for (Position p : divide)
	            System.out.println(p);
	    }

	}
