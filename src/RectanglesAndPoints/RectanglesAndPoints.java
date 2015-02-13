/*
Question: There is a list of rectangles and a list of points in a 2d space.
Note that the edge of each rectangle are aligned to XY axis. 
Question is how to find rectangles with point or points inside

Question Source: Asked 2 times
http://www.careercup.com/question?id=5722141007806464
http://www.careercup.com/question?id=15443800

Answer Source: http://www.careercup.com/question?id=5722141007806464

*/

package RectanglesAndPoints;

import java.util.LinkedList;
import java.util.List;

public class RectanglesAndPoints {
public static void main(String[] args) {
	Point[][] rectanglePoints = {
			{new Point(5,5) , new Point(100,100)},    // initializing 2d array
			{new Point(15,15) , new Point(800,800)},
			{new Point(55,55) , new Point(300,300)},
			{new Point(95,95) , new Point(100,100)},
	};
	
	Point[] randomPointsArray = {new Point(3,80), new Point(40,289), new Point(56,120), new Point(400,288), new Point(100,100)};
	
	List<Rectangle> rectangles = new LinkedList<Rectangle>();
	List<Point> randomPoints = new LinkedList<Point>();
	
	for(Point[] p: rectanglePoints){    // accesing individual row of 2d array
		rectangles.add(new Rectangle(p[0],p[1]));      // adding the individual column Points in the row
	}
	
	for(Point p: randomPointsArray){
		randomPoints.add(p);
	}
	
	
	for(Rectangle r: rectangles){
		for(Point p: randomPoints){
			if(p.containsPoint(r.bottomLeft, r.topRight))
				System.out.println("Rectangle: "+r+" contains point: "+p);
		}
	}
	
	
	
	
}
}

class Point{
	int x;
	int y;
	
	public Point(int x, int y){
		this.x=x;
		this.y=y;
	}
	
	public String toString(){
		return ("x-coordinate:"+x+" "+"y-coordinate:"+y);
	}
	public boolean containsPoint(Point bottomLeft, Point topRight){
		if(this.x <= topRight.x &&
		   this.x>=bottomLeft.x &&
		   this.y >= bottomLeft.y &&
		   this.y <= topRight.y)
			return true;
		else
			return false;
	}
}

class Rectangle{
	Point bottomLeft;
	Point topRight;
	
	public Rectangle(Point x, Point y){
		bottomLeft = x;
		topRight = y;
	}
	
	public String toString(){
		return ("BottomLeft: "+bottomLeft.toString()+" TopRight: "+topRight.toString());
	}
}
/*
 * Analysis:
 * Time Complexity = O(rp) where
 * r = number of rectangles
 * p = number of points
 * 
 * Space Complexity = O(r+p)
 * where r = list for storing all rectangles
 * p = list for storing all points
 */
