package KClosestPointsIn2DPlane;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;


public class MedianOfMedians_BEST_MOM_ALGO {
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
		  Point res=medianOfMedians(pointsArray,0,pointsArray.length-1,k);  // k can start from lowest value of 1 to highest value of pointsArray.length
		  System.out.println("The kth smallest point USING MOM is: "+res.toString());
		  System.out.println("After Algo");
		  print(pointsArray);
		  
		  System.out.println(k+" closest point/points are: ");
		  for(int i=0;i<k;i++)
			  System.out.println(pointsArray[i].toString());
		  
		  System.out.println("----------------------");
		  System.out.println("Points after sorting: ");
		  Arrays.sort(pointsArray,new Comparator<Point>(){
			  public int compare(Point a, Point b){
				  return (int) (a.distance-b.distance);
			  }
		  });
		  for(int i=0;i<pointsArray.length;i++)
			  System.out.println(pointsArray[i].toString());
		  System.out.println("kth smallest point USING SORTING is: "+pointsArray[k-1].toString());
		  }
		  finally{
			  in.close();
		  }
		  
	  }
	  private static Point findMedian(Point[] arr, int left, int totalElements) {
			
		  /* Arrays.sort(T[] a, int fromIndex, int toIndex, Comparator<? super T> c)
		   * The range to be sorted extends from index fromIndex, INCLUSIVE, to index toIndex, EXCLUSIVE. 
Sorts the specified range of the specified array of objects according to the order induced by the specified comparator.
		   */
		  
		  	Arrays.sort(arr, left, (left+totalElements), new Comparator<Point>(){
		  		public int compare(Point a, Point b){
		  			return (int) (a.distance-b.distance);
		  		}
		  	});
		  	int medianIndex = (left+totalElements)/2;
		  	return arr[medianIndex];
		  	
		}
	  private static Point medianOfMedians(Point[] arr, int l, int r, int k) {
		  
		  if(k>0 && k<=(r-l+1)){
			  int n = (r-l+1);
			  
			  int i=0;
			  Point[] med = new Point[(n+4)/5];
			  for(i=0;i<n/5;i++)
				  med[i]=findMedian(arr,l+i*5,5);
			  if(i*5<n){
				  med[i]=findMedian(arr, l+i*5, n%5);
				  i++;
			  }
			  
			  Point medOfMed = (i==1)?arr[i-1]:medianOfMedians(med, 0, i-1, i/2);
			  
			  int pos = partition(arr,l,r,medOfMed);
			  
			  if(pos-l==k-1)
				  return arr[pos];
			  if(pos-l>k-1)
				  return medianOfMedians(arr, l, pos-1, k);
			  
			  return medianOfMedians(arr, pos+1, r, k-pos+l-1);
		  }
		  return null;
	  }
	
	private static int partition(Point[] arr, int l, int r, Point medOfMed) {
		
		// swap the pivot with right
		int i;
		for(i=l;i<r;i++)
			if(arr[i].distance==medOfMed.distance)
				break;
		
		swap(arr,i,r);
		
		
		int storage = l;
		
		for(i=l;i<r;i++){
			if(arr[i].distance <= medOfMed.distance){
				swap(arr,i,storage);
				storage++;
			}
		}
		swap(arr, storage, r);
		return storage;
	}
	private static void swap(Point[] arr, int index1, int index2) {
		Point temp = arr[index1];
		arr[index1] = arr[index2];
		arr[index2] = temp;
	}
	public static void print(Point[] pointsArray){
		  for(Point p:pointsArray)
			  System.out.println(p.toString());
	  }
}
/*
Analysis:
(Analysis Source: http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-3-worst-case-linear-time/ )
Worst Case Time Complexity = O(n). VERY IMP NOTE: THIS IS WOST CASE COMPLEXITY HENCE "O" is used.
Best and Average Case Time Complexity = THETA(n)
Space Complexity = O(1)
*/