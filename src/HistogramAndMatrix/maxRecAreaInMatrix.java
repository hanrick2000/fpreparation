/*
Question: Find Maximum Area RECTANGLE in Histogram
Source: http://tech-queries.blogspot.com/2011/03/maximum-area-rectangle-in-histogram.html

	Algorithm:
		1. Calculate Histogram matrix
		2. Input each row of Histogram to FindLargestAreaInRectangle method which returns area
		3. max = Math.max(max,area)
*/	

package HistogramAndMatrix;

import java.util.Stack;

public class maxRecAreaInMatrix {
	    public static void main(String[] args){
	      
	      int[][] knows = new int[][]{{0,1,1,0,1},
	                                  {1,1,1,0,0},
	                                  {0,1,1,1,0},
	                                  {0,1,1,0,0}};
	      // copy the matrix to a new matrix
	      int[][] s = knows;
	      
	                                  
	      // converting to histogram
	      for(int i=1;i<s.length;i++)
	          for(int j=0;j<s[0].length;j++)
	              if(s[i][j]==1)
	            	  s[i][j] = s[i-1][j]+1;
	              
	       
	      
	      // feed each row to histogram program
	      int max = 0;
	      int area;
	      for(int i=0;i<s.length;i++){
	          area=largestRectangleInHistogram(s[i]);
	          max = Math.max(max,area);
	          }
	      System.out.println("The max area of the rectangle is: "+max);
	    }

	    public static int largestRectangleInHistogram(int[] a){
	    
	    
	    Stack<Integer> stack = new Stack<Integer>();
	   
	    int max = 0;
	    int i =0;
	    
	    /*
	     * VERY VERY IMP:
	     * In BOTH cases we only use WHILE LOOP
	     */
	        while(i<a.length){                      // Case1: WHILE loop
	            
	            if(stack.isEmpty() || a[i]>=a[stack.peek()]){ // VERY IMP: greater than = to (>=)
	                stack.push(i++);
	            }
	            
	            else{
	                int height = a[stack.pop()];
	                int width = stack.empty()? i : (i-stack.peek()-1);
	                max = Math.max(height*width,max);
	            }
	        }    
	        
	        while(!stack.empty()){                 // Case2: WHILE loop
	        		int height = a[stack.pop()];
	                int width = stack.empty()? i : (i-stack.peek()-1);
	                max = Math.max(height*width,max);
	        }
	    
	    return max;
	    }
	}
	/*
	Time Complexity = O(m*n)
	Space Complexity = O(m*n)
	*/


