
/*
 * Question: Find k closest points from a given point
 * 
 * Question Source: http://www.careercup.com/question?id=15974664
 * 					http://www.careercup.com/question?id=5309537623998464
 * 
 */

package KClosestPointsIn2DPlane;

import java.util.Random;
import java.util.Scanner;


public class Recursive_QuickSelect {
	
	 public static class Point
     {
             private int xCoord;
             private int yCoord;
             private double distance;
             
             public int getxCoord() {
                     return xCoord;
             }
             public void setxCoord(int xCoord) {
                     this.xCoord = xCoord;
             }
             public int getyCoord() {
                     return yCoord;
             }
             public void setyCoord(int yCoord) {
                     this.yCoord = yCoord;
             }
             
             
             public double getDistanceFromPoint()
             {
           	  return Math.sqrt((this.xCoord*this.xCoord) + (this.yCoord*this.yCoord));
             }
             
             public Point(int xCoord, int yCoord) {
                     super();
                     this.xCoord = xCoord;
                     this.yCoord = yCoord;
                     this.distance = getDistanceFromPoint();
             }
             
             @Override
             public String toString() {
                     return "Point [xCoord=" + xCoord + ", yCoord=" + yCoord + "]";
             }
 
     } // end of class Point
	
	public static void main(String[] args) {
		 Scanner in = new Scanner(System.in);
		  try{
		  Point[] pointsArray = new Point[10]; 
		  Random random = new Random();
		  for(int i=0;i<10;i++){
				pointsArray[i]=new Point(random.nextInt(100),random.nextInt(100));
			}
		  System.out.println("Before Algo");
		  print(pointsArray);
		  
		  System.out.println("Enter k");
		  int k = in.nextInt();
		  
		  int temp = recursiveQuickSelect(pointsArray,0,pointsArray.length-1,k-1);
		  
		  System.out.println("After Algo");
		  print(pointsArray);
		  
		  
		  System.out.println(k+" closest point/points are: ");
		  for(int i=0;i<=temp;i++)
			  System.out.println(pointsArray[i].toString());

		  }
		  finally{
			  in.close();
		  }
	}
	
	
	public static int recursiveQuickSelect(Point[] x, int left, int right, int k){
		if(x == null || k >=x.length || k<0)
    		throw new Error();
		
		int pivotIndex = randomPartitioning(x,left,right);
		 // If pivot is same as k
		if(pivotIndex==k)
			return pivotIndex;
		
		if(pivotIndex < k)
			return recursiveQuickSelect(x, pivotIndex+1, right,k-pivotIndex-1);
		
		else // k<pivotIndex
			return recursiveQuickSelect(x, left, pivotIndex, k);
	}
	
	
	  private static int randomPartitioning(Point[] x, int left, int right) {
		  if(left<=right){
		  int pivot = left+((right-left)/2);
		  swap(x,pivot,right);
		  return partition(x,left,right);
		  }
		  else
			  return -1;
	}


		private static void swap(Point[] x, int pivot, int right) {
			Point temp = x[pivot];
			x[pivot]=x[right];
			x[right]=temp;
		}

	private static int partition(Point[] x, int left, int right) {
		
		Point pivotValue = x[right];
		
		int storage = left;
		// from (left) to (right-1)
		for(int i=left;i<right;i++){
			if(x[i].distance < pivotValue.distance){
				Point temp =x[storage];
				x[storage] = x[i];
				x[i]=temp;
				// increment the stored value of left
				storage++;
			}
		}
		x[right]=x[storage];
		x[storage]=pivotValue;//move the pivot to its correct absolute location in the list
		
		return storage;
	}



	public static void print(Point[] pointsArray){
		  for(Point p:pointsArray)
			  System.out.println(p.toString());
	  }
	  

}
