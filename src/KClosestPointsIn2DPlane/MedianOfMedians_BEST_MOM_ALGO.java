package KClosestPointsIn2DPlane;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import java.util.Scanner;

/*
 * IMP NOTE:
 * Both MOM and QuickSelect can be used to find answers for BOTH questions:
 * 1. Find the kth smallest element    (Find single element)
 * 2. Find all the k smallest elements (Find k elements)
 */
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
           	  return  (Math.sqrt((this.xCoord)*(this.xCoord) + (this.yCoord)*(this.yCoord)));  // distance from origin
           	  //return  (Math.sqrt((this.xCoord-5)*(this.xCoord-5) + (this.yCoord-5)*(this.yCoord-5))); // distance from point (5,5)
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
		  Point[] pointsArray = new Point[11]; 
		  Random random = new Random();
		  for(int i=0;i<11;i++){
				pointsArray[i]=new Point(random.nextInt(100),random.nextInt(100));
			}
		  System.out.println("Before Algo");
		  print(pointsArray);
		  
		  System.out.println("Enter k");
		  int k = in.nextInt();
		  
		  System.out.println(" * IMP NOTE: \n"+
			 " * Both MOM and QuickSelect can be used to find answers for BOTH questions: \n "+
			 " * 1. Find the kth smallest element    (Find single element) \n "+
			 " * 2. Find all the k smallest elements (Find k elements)");
		  
		  
		  Point res=kthSmallest(pointsArray,0,pointsArray.length-1,k);  // k can start from lowest value of 1 to highest value of pointsArray.length
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
				  return ((int)a.distance-(int)b.distance);
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
		  			return ((int)a.distance-(int)b.distance);
		  		}
		  	});
		  	int medianIndex = (left+totalElements)/2;
		  	return arr[medianIndex];
		  	
		}
	  public static Point kthSmallest(Point arr[], int l, int r, int k)
		{
		    // If k is smaller than number of elements in array
		    if (k > 0 && k <= r - l + 1)                          // (r-l+1) = number of elements within the range arr[l...r]. NOTE: DONOT REPLACE (r-l+1) with a.length
		    {
		        int n = r-l+1; // Number of elements to be considered within the range arr[l..r]
		 
		        // Divide arr[] in groups of size 5, calculate median
		        // of every group and store it in median[] array.
		        int i=0; 
		        Point[] median=new Point[(n+4)/5]; // There will be floor((n+4)/5) groups;
		        for (i=0; i<n/5; i++)
		            median[i] = findMedian(arr, l+i*5,5);
		        if (i*5 < n) //For last group with less than 5 elements. 
		       // Thus even the last part is sorted and median is taken from even the last part.
		       // If even number of elements in the last part Example 4 elements then 4/2 = 2nd index is taken in median array (RIGHTMOST index)
		       // If odd number of elements in the last part Example 3 elements then 3/2 = 1st index is taken in the median array (No issue in selecting median since odd number of elements)
		        {
		            median[i] = findMedian(arr,l+i*5,n%5); 
		            i++;     
		        }    
		        
		        // Find median of all medians using recursive call.
		        // If median[] has only one element, then no need
		        // of recursive call
		        Point medOfMed = (i == 1)? median[i-1]:
		                                 kthSmallest(median, 0, i-1, i/2);
		        
		        
		        // Partition the array around a random element and
		        // get position of pivot element in sorted array
		        int pos = partition(arr, l, r, medOfMed);
		 
		        // If position is same as k
		        if (pos-l == k-1)
		            return arr[pos];
		        else if (pos-l > k-1)  // If position is more, recur for left
		            return kthSmallest(arr, l, pos-1, k);
		        else
		        // Else recur for right subarray
		        return kthSmallest(arr, pos+1, r, k-pos+l-1);
		    }
		 
		    // If k is more than number of elements in array
		    return null;
		}
		 
		public static void swap(Point[] arr, int index1, int index2)
		{
		    Point temp = arr[index1];
		    arr[index1] = arr[index2];
		    arr[index2] = temp;
		}
		 
		// It searches for x in arr[l..r], and partitions the array 
		// around x.
		public static int partition(Point[] arr, int l, int r, Point medOfMed)
		{
		    // Search for x in arr[l..r] and move it to end
		    int i;
		    for (i=l; i<r; i++)
		        if ((int)arr[i].distance == (int)medOfMed.distance)
		           break;
		    
		    swap(arr,i, r);
		 
		    // Standard partition algorithm
		    int storage = l;                                  // store the left
		    for (int j = l; j <= r - 1; j++)
		    {
		    	if ((int)arr[j].distance <= (int)medOfMed.distance)
		        {
		            swap(arr,storage, j);
		            storage++;
		        }
		    }
		    swap(arr,storage, r);                             // swap storage and right
		    return storage;
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