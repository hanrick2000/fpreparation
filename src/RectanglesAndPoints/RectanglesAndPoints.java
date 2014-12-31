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

