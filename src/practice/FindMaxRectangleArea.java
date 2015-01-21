
/*
	Algorithm:
	    1. Convert the input matrix to Histogram input whether each element would say the number of CONSECUTIVE 1's above it
	    2. Analyzing each row of the input matrix to check for maximum rectangle area using intelligent Algorithm(using
	    Stack since it is Linear algorithm)
	    3. return max by comparing previous max with current area
*/
	package practice;

	import java.util.Stack;

	public class FindMaxRectangleArea {

	    public static void main(String[] args[]){
	        int[][] matrix = new int[][]{{1,0,0,1,0},
	                                     {0,1,1,1,1},
	                                     {1,1,1,1,1},
	                                     {0,0,0,1,1}};
	        System.out.println("The max area is: "+maxArea(matrix)); 
	    }
	    
	    public static int maxArea(int[][] a){
	        int[][] modified = convertToHistogramInput(a);
	        
	        int area;
	        int max=0;
	        for(int i=0;i<a.length;i++){
	            area = calculateMaxArea(modified[i]);
	            max = Math.max(area,max);
	            }
	        return max;
	    }
	    public static int[][] convertToHistogramInput(int[][] a){
	        
	        int[][] s = new int[a.length][a[0].length];
	        
	        for(int i=0;i<a.length;i++)
	            s[0][i] = a[0][i];
	        
	        for(int i=1;i<a.length;i++)
	            for(int j=0;j<a[0].length;j++)
	                if(a[i][j]==1)
	                    s[i][j] = a[i-1][j]+1;
	                    
	       return s;
	    }
	    
	    public static int calculateMaxArea(int[] a){
	        
	        Stack<Integer> stack = new Stack<Integer>();
	        int i=0;
	        int max=0; // area calculation
	        while(i<a.length){
	            if(stack.isEmpty()||a[i]>=a[stack.peek()])
	                stack.push(i++); // push the index in the stack
	            else{
	                int h = a[stack.pop()];
	                int w = stack.isEmpty()?i:(i-stack.peek()-1);
	                max = Math.max(max,h*w);
	            }
	        }
	        while(!stack.isEmpty()){
	            int h = a[stack.pop()];
	            int w = stack.isEmpty()?i:i-stack.peek()-1;
	            max = Math.max(max,h*w);
	        }
	        
	        // stack is empty
	        return max;
	    }
	}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  



