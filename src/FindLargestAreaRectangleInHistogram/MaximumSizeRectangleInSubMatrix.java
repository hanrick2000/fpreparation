/*
Question: Find Maximum Area RECTANGLE in Histogram
Source: http://tech-queries.blogspot.com/2011/03/maximum-area-rectangle-in-histogram.html

	Algorithm:
		1. Calculate Histogram matrix
		2. Input each row of Histogram to FindLargestAreaInRectangle method which returns area
		3. max = Math.max(max,area)
*/	

package FindLargestAreaRectangleInHistogram;

import java.util.Stack;

public class MaximumSizeRectangleInSubMatrix {
	    public static void main(String[] args){
	      
	      int[][] knows = new int[][]{{0,1,1,0,1},
	                                  {1,1,1,0,0},
	                                  {0,1,1,1,0},
	                                  {0,0,1,0,0}};
	      int[][] s = new int[knows.length][knows[0].length];
	                                  
	      // converting to histogram
	      for(int i=1;i<knows.length;i++)
	          for(int j=0;j<knows[0].length;j++)
	              if(knows[i][j]==1)
	        	  s[i][j] = knows[i-1][j]+1;
	       
	      
	      // feed each row to histogram program
	      int max = 0;
	      int area;
	      for(int i=0;i<knows.length;i++){
	          area=largestRectangleInHistogckram(s[i]);
	          max = Math.max(max,area);
	          }
	      System.out.println("The max area of the rectangle is: "+max);
	    }

	    public static int largestRectangleInHistogckram(int[] a){
	    
	    int max = 0;
	    Stack<Integer> stack = new Stack<Integer>();
	   
	    
	    int i =1;
	        while(i<a.length){
	            
	            if(stack.isEmpty() || a[i]>=a[stack.peek()]){
	                stack.push(i++);
	            }
	            
	            else{
	                int height = a[stack.pop()];
	                int width = stack.empty()? i : (i-stack.peek()-1);
	                max = Math.max(height*width,max);
	            }
	        }    
	        
	        while(!stack.empty()){
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


