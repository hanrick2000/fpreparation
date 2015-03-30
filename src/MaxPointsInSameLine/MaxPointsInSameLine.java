/*
 * Question: Given n points on a 2D plane, find the maximum number of points that lie on the same straight line.
 * 
 * Question and Answer Source: http://www.fgdsb.com/2015/01/03/max-points-on-a-line/ 
 */

package MaxPointsInSameLine;

import java.util.HashMap;


public class MaxPointsInSameLine {
public static void main(String[] args) {
	Point[] points = new Point[4];
	points[0]=(new Point(1,1));
	points[1]=(new Point(2,2));
	points[2]=(new Point(3,3));
	points[3]=(new Point(5,10));
	System.out.println(maxPoints(points));
}
public static int maxPoints(Point[] points) {
    
    if (points==null||points.length==0){
        return 0;
    }  
    
    HashMap<Double, Integer> map=new HashMap<Double, Integer>();;
    int max=1;
    
    for(int i=0; i<points.length; i++){
        // shared point changed, map should be cleared and serve the new point
        map.clear();
        
        // maybe all points contained in the list are same points,and same points' k is 
        // represented by Integer.MIN_VALUE
        map.put((double)Integer.MIN_VALUE, 1);
        
        int dup=0;    // counter for duplicate points
        
        for(int j=i+1; j<points.length; j++){
            
           if (points[j].x==points[i].x && points[j].y==points[i].y){
               dup++;
               continue;
           }
           
           // look 0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x)
           // because (double)0/-1 is -0.0, so we should use 0.0+-0.0=0.0 to solve 0.0 !=-0.0
           // problem
           /*
            * To find the slope, we need two points of a line. We use the following formula:

				slope formula: m = [y1 - y2] / [x1 - x2]
            */
           // if the line through two points are parallel to y coordinator, then K(slop) is 
           // Integer.MAX_VALUE
           double key=points[j].x-points[i].x==0 ? Integer.MAX_VALUE:0.0+(double)(points[j].y-points[i].y)/(double)(points[j].x-points[i].x);
          
           if (map.containsKey(key)){
        	   
               map.put(key, map.get(key)+1);
           }
           else{
              map.put(key, 2);
           }
       }
      
      // For Duplicate Points
      for (int temp: map.values()){
        
          // duplicate may exist
          if (temp+dup>max){
              max=temp+dup;
          }
      }
       
    }
    
    return max;
}
/*
 * Analysis:
 * Time Complexity = O(n^2) where n = number of points
 * Space Complexity = O(n) used by HashMap
 */
}
class Point{
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Point(){
		this.x = 0; 
		this.y = 0; 
	}
}