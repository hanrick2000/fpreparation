
/*
 * Question: Check whether two rectangles overlap
 * 
 * Question and Answer Source: http://www.geeksforgeeks.org/find-two-rectangles-overlap/
 * 
 * Algorithm:
 * Following is a simpler approach. Two rectangles do not overlap if one of the following conditions is true.
1) One rectangle is above top edge of other rectangle.
2) One rectangle is on left side of left edge of other rectangle.
 */


package RectanglesAndPoints;

public class TwoOveralappingRectangles {
	 
	 
	// Returns true if two rectangles (l1, r1) and (l2, r2) overlap
	public static boolean doOverlap(RecPoint l1, RecPoint r1, RecPoint l2, RecPoint r2)
	{
	    // If one rectangle is on left side of other
	    if (l1.x > r2.x || l2.x > r1.x)
	        return false;
	 
	    // If one rectangle is above other
	    if (l1.y < r2.y || l2.y < r1.y)
	        return false;
	 
	    return true;
	}
	 
	/* Driver program to test above function */
	public static void main(String[] args)
	{
		// left edges overlap
		RecPoint l1 = new RecPoint(0, 10), r1 = new RecPoint(10, 0);
		RecPoint l2 = new RecPoint(5, 5), r2 = new RecPoint(15, 0);
		
		/* 
		   //one rectangle completely inside another rectangle
		   RecPoint l1 = new RecPoint(0, 10), r1 = new RecPoint(10, 0);
		   RecPoint l2 = new RecPoint(5, 5), r2 = new RecPoint(8, 8);
		   
		   // right edges overlap
		   RecPoint l1 = new RecPoint(50, 10), r1 = new RecPoint(100, 0);
		   RecPoint l2 = new RecPoint(0, 5), r2 = new RecPoint(75, 0);
		   
		 */
		
	    if (doOverlap(l1, r1, l2, r2))
	        System.out.println("Rectangles Overlap");
	    else
	        System.out.println("Rectangles Don't Overlap");
	}

}

class RecPoint{
    int x, y;
    public RecPoint(int x, int y){
    	this.x = x;
    	this.y = y;
    }
}
