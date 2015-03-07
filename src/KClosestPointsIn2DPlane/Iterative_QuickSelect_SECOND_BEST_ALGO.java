//
/*
 * Question: Find k closest points from a given point
 * 
 * Question Source: http://www.careercup.com/question?id=15974664
 * 					http://www.careercup.com/question?id=5309537623998464
 * 
 * Answer Source: 
 * http://stackoverflow.com/questions/18861455/java-2d-find-the-k-closest-points-to-the-origin-in-2d-plane
 * https://solvethat.wordpress.com/2013/10/21/find-the-k-closest-point-to-the-origin/
 * 
 * 
 * EXPLANATION:
 * When to use heap and when not to use heap
 * 
I. When to use heap:
 * One would need a heap, if 
1) points are not yet loaded, and you receive them one-by-one (i.e. it's not a set of points, but a stream) 
2) or maybe you are out of memory, and you have to preserve the initial array (quickselect-based algoritm 
would modify it) - then you can use heap with O(k) memory instead of O(n) copy of array

II. When not to use heap
In fact we don't need a heap or a binary search tree here, because all the array is already loaded into memory.
So you can use some modification of Quick-Select algorithm, to achieve O(n) speed and O(1) extra-memory 
(because tail recursion can be effectively eliminated) in case you don't need your initial array later on 

K CLOSEST POINTS IN A 2D PLANE:
This problem is a variant of the nearest neighbor search problem. The simplest solution is to compute the distance
from the origin to all N points and then find the K that are nearest using for example the quickselect algorithm,
giving a time and space complexity of O(n).

*/

package KClosestPointsIn2DPlane;

import java.util.Random;
import java.util.Scanner;

public class Iterative_QuickSelect_SECOND_BEST_ALGO {
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
		  iterativeQuickSelect(pointsArray,k-1);  // k can start from lowest value of 1 to highest value of pointsArray.length
		  System.out.println("After Algo");
		  print(pointsArray);
		  
		  System.out.println(k+" closest point/points are: ");
		  for(int i=0;i<k;i++)
			  System.out.println(pointsArray[i].toString());
		  }
		  finally{
			  in.close();
		  }
		  
	  }
	  public static void print(Point[] pointsArray){
		  for(Point p:pointsArray)
			  System.out.println(p.toString());
	  }
	  
	  /*
	   * Source: https://gist.github.com/elderdigiuseppe/6242837
	   * 
	   * 
	   * Explanation: (PLEASE READ EVEYTHING CAREFULLY)
	   * This is a quickSelect algorithm to find the k-th smallest element in an unsorted array of numbers. 
	   * It is in place and non-recursive to save memory (meaning its extra memory is O(1)). 
	   * Further, if the list is randomly sorted, it should ignore half the list each time it
	   * parses through it which results in an O(n) complexity. Here is a quick example of
	   * why its expected O(n) first pass n second pass n/2 third pass n/4 fourth pass n/8 ... 
	   * so all passes together would be n + n/2 + n/4 + n/8 + ... which is the same as cn where
	   * c is some constant or O(n) some sample test cases are as follows....
	   * 
	   * 1 (2nd smallest) ----> 2 {7,1,6,5,3,4,2}, 
	   * 5 (2nd largest) ----> 6
	   * 
	   * 
	   * 
	   * 
	     * given a list of numbers, select the Kth number.  This means you can select 
	     * the median, or smallest, or largest, or 10th largest, etc number from your list.
	     * This method uses in place sorting similar to in place quicksort.  Because of this, 
	     * its extra memory is done in O(1) time.  AND because each time we go through the 
	     * list we eliminate (on average) half the list, its expected time is O(n).  however, 
	     * if the pivot selected is always the max or min, you can have a worst case of O(n^2).
	     * 
	     * 
	     * @return int  the kth value from the list you pass in
	     * @param int[] x:  a list of numbers
	     * @param k: the kth element you want, can be median, biggest, smallest, etc. 
	     * make sure k<x.length == true
	     */
	  public static int iterativeQuickSelect(Point[] x, int k){
	    	//dont work if the list isnt there or if they want a k that doesnt exist
	    	if(x == null || k>=x.length || k<0)
	    		throw new Error();
	    	
	    	int left = 0;
	    	int right = x.length-1;
	 
	    	//we stop when our indices have crossed
	    	while (left < right){
	 
	    		int pivot = left+((right - left)/2); //this can be whatever
	    		
	    		Point pivotValue = x[pivot]; // Move pivot to end(i.e. right)
	    		swap(x,pivot,right);
	    		
	    		// Now the pivot is the element which is at right index
	    		
	    		int storage=left; // store the left index
	    		
	    		// from (left) to (right-1)
	    		for(int i =left; i < right; i++){
	 //for each number i, if i is less than the pivot, swap i and storage and increment storage
	    			if(x[i].distance < pivotValue.distance){
	    				swap(x,i,storage);
	    				storage++;     // increment the stored value of left
	    			} 
	    		}
	    		// swap the storage and right (i.e. move the pivot to its correct absolute location in the list)
	    		swap(x,storage,right);
	    		int pos = storage;
	    		
	    		//pick the correct half of the list you need to parse through to find your K, and ignore the other half
	    		if(pos < k)
	    			left = pos+1;
	    		else//pos>= k
	    			right = pos;
	    	}
	    	
	    	return k;
	 
	    }
		public static void swap(Point[] arr, int index1, int index2)
		{
		    Point temp = arr[index1];
		    arr[index1] = arr[index2];
		    arr[index2] = temp;
		} 
		
		/*
		Analysis:
		(Analysis Source: http://www.geeksforgeeks.org/kth-smallestlargest-element-unsorted-array-set-2-expected-linear-time/)
		Worst Case Time Complexity = O(n^2). VERY IMP NOTE: THIS IS WOST CASE COMPLEXITY HENCE "O" is used.
		Best and Average Case Time Complexity = THETA(n)
		Space Complexity = O(1)
		*/
		
		
}
/*
 * EXTRA READING:
 * Two Types of Partition Exists in QuickSelect
Source: http://cs.stackexchange.com/questions/11458/quicksort-partitioning-hoare-vs-lomuto
1. Lomuto -> To understand this watch this video: https://www.youtube.com/watch?v=MZaf_9IZCrc
2. Hoare -> Normal i and j counter partition
The code for Hoare parition is:
private static int partition(int[] a, int low, int high) {
		
		int i = low;
		int j = high;
		int temp = 0;
		
		int pivot = a[low+(high-low)/2];
		
		while(i<=j){
			while(a[i]<pivot)
				i++;
			while(a[j]>pivot)
				j--;
			if(i>j)
				break;
			else{ // if(i<=j)
				temp=a[i];
				a[i]=a[j];
				a[j]=temp;
				i++;
				j--;
			}
		}
		return i; // return the pivot index
		
	}
 */
