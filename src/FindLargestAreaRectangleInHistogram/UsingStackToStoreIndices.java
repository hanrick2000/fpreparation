/*package FindLargestAreaRectangleInHistogram;

import java.util.Scanner;
import java.util.Stack;

public class UsingStackToStoreIndices {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the height of each index in the histogram");
		System.out.println("Enter the size of the array");
		int n = in.nextInt();
		int[] hist = new int[n];
		System.out.println("Enter the height of the histogram rectangles");
		for(int i=0;i<hist.length;i++)
			hist[i]=in.nextInt();
		System.out.println("The maximum area rectangle in the histogram is: "+maxAreaRectangle(hist));
	}
	finally{
		in.close();
	}
}

private static int maxAreaRectangle(int[] hist) {
	
	if(hist==null || hist.length==0)
		return -1;
	
	Stack<Integer> stack = new Stack<Integer>();
	stack.push(0);                                   // Push the first INDEX in the stack
	int maxArea = 0;                                 // variable for storing the max area of the rectangle
	for(int i=1;i<hist.length;i++){
		int current = hist[i];          // get the current element of the hist array
		int prev = hist[stack.peek()];  // get the top element pushed in the stack
		
		if(current>prev)
			stack.push(i);              // push this index in the stack
		
		if(current==prev){}             // do nothing
		
		if(current<prev){
            // get the height and width for calculating area of rectangle
			int height = current;
			int width = 1;
			int top=0;
			while(!stack.empty() && hist[stack.peek()]<=current){
				top=stack.pop();
				width++;
				// update maxArea if this area is greater than the previous maxArea calculated
				if(maxArea< (height*width)) // if previous maxArea is less than current maxArea
					maxArea=(height*width);
			}
			
			stack.push(top);
		}
	}
	
	// while the stack is empty pop all elements and check their area
	
	while(!stack.empty()){
		
	}
	
}
}
*/