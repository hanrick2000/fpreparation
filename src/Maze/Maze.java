
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
		
		mazeSolution(maze,start,exit);
	}
		public static void mazeSolution(int[][] maze,Point start, Point exit){
		//DFS approach
		Stack<Point> s = new Stack<Point>();
		s.push(start);
		Map<Point,Status> visited = new HashMap<Point,Status>();
		visited.put(start, Status.VISITING);
		
		while(!s.isEmpty()){
			Point currentP = s.peek();
			boolean isAllVisited = true;
			
			for (Point p : getAdjacent(currentP.x, currentP.y)){ // get the neighbors of the current point
				//It should be y and x, see above array
				if (visited.get(p)==null && maze[p.x][p.y]==1){  // If NOT VISITED before and this point is REACHABLE
					visited.put(p, Status.VISITING);  // mark currentPoint as VISITING
					isAllVisited = false;  // all the neighbors are NOT VISITED
					s.push(p);  // push to stack
					if ( p.equals(exit)){
						printStack(s);
					}
					break;  // break the for loop and go to the while loop since now we need to check the neighbors of this neighbor
				}  // if VISITED before OR this point is INVALID then do nothing, check the next neighbor
			} // end of for
			
			
			if (isAllVisited){  // if none of the neighbors are VALID TRAVERSALS then we reach a dead end 
				// we mark the node as VISITED and remove the node
				visited.put(currentP, Status.VISITED);  // all the neighbors of currentPoint are VISITED
				s.pop();
			}
		} // end of while
	} // end of method mazeSolution
	private static enum Status {
		UNVISITED, VISITING, VISITED
	}	
	private static void printStack(Stack<Point> s){
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
		}
		//right point;
		if (x+1<=5) {
			result.add(new Point(x+1, y));
		}
		//below point;
		if (y+1<=5) {
			result.add(new Point(x, y+1));
		}
		//left point;
		if (x-1>=0) {
			result.add(new Point(x-1, y));
		}
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
	}  // end of private static class Point
	
}
/*
Analysis:
Time Complexity = O(n^2)
Space Complexity = O(n^2)
*/