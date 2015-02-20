
/*
Question: Design a maze. Give the algorithm and code to find the correct path and get out of the maze.
(Facebook Interview)

Question and Answer Source: http://www.careercup.com/question?id=15579675
	http://www.glassdoor.com/Interview/Facebook-Software-Engineering-New-Grad-Interview-Questions-EI_IE40772.0,8_KO9,38.htm#
*/		

package Maze;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class Maze {

	public static void main(String[] args) {
		//Use 2D array
		int[][] maze = new int[6][6];
		maze[0] = new int[] { 1, 1, 0, 0, 0, 0 };
		maze[1] = new int[] { 0, 1, 0, 0, 0, 0 };
		maze[2] = new int[] { 0, 1, 0, 1, 1, 1 };
		maze[3] = new int[] { 1, 1, 1, 1, 0, 1 };
		maze[4] = new int[] { 0, 1, 0, 0, 0, 1 };
		maze[5] = new int[] { 0, 1, 0, 0, 0, 1 };

		//This is the start of exit point of maze
		Point start = new Point(0,0);
		Point exit = new Point(5,5);
		
		//DFS approach
		Stack<Point> s = new Stack<Point>();
		s.push(start);
		Map<Point,Status> visited = new HashMap<Point,Status>();
		visited.put(start, Status.VISITING);
		
		while(!s.isEmpty()){
			Point currentP = s.peek();
			boolean isAllVisited = true;
			
			for (Point p : getAdjacent(currentP.x, currentP.y)){
				//It should be y and x, see above array
				if (visited.get(p)==null && maze[p.x][p.y]==1){
					visited.put(p, Status.VISITING);
					isAllVisited = false ;
					s.push(p);
					if ( p.equals(exit)){
						printPath(s);
					}
break;
				}
			}
			if (isAllVisited){
				visited.put(currentP, Status.VISITED);
				s.pop();
			}
		}
	}
	private static enum Status {
		UNVISITED, VISITING, VISITED
	};
	private static void printPath(Stack<Point> s){
		while (!s.isEmpty()){
			System.out.print("->");
			Point p = s.remove(0);
			System.out.format("[%d,%d]",p.x,p.y);
		}
	}
	
	private static List<Point> getAdjacent(int x, int y){
		List<Point> result = new ArrayList<Point>();
		//above point;
		if (y-1>=0) {
			result.add(new Point(x, y-1));
		};
		//right point;
		if (x+1<=5) {
			result.add(new Point(x+1, y));
		};
		//below point;
		if (y+1<=5) {
			result.add(new Point(x, y+1));
		};
		//left point;
		if (x-1>=0) {
			result.add(new Point(x-1, y));
		};
		return result;		
	}

	private static class Point {
		int x, y;
		public Point(int x,int y) {
			this.x = x;
			this.y = y;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			
			if (this == obj)
				return true;
			
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			
			
			
			Point other = (Point) obj;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			
			return true;
		}
	}
	
}
/*
Analysis:
Time Complexity = O(n^2)
Space Complexity = O()
*/