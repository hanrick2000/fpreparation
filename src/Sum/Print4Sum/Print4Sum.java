/*
Question: You're given an array of integers(eg [3,4,7,1,2,9,8]) 
Find the index of values that satisfy A+B = C + D, where A,B,C & D are integers values in the array. 

Example: Given [3,4,7,1,2,9,8] array 
The following 
3+7 = 1+ 9 satisfies A+B=C+D 
so print (0,2,3,5)
 * 
Question and Answer Source: http://www.careercup.com/question?id=5652354158297088

Algorithm:
1. Use Node class to record the sum of two values.
2. Use HashMap<Integer,Node> to record the sum of two pair(currentSum) and find two pairs(Node) which has the same sum
*/
package Sum.Print4Sum;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Print4Sum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println(print4Sum(a));
		}
		finally{
			in.close();
		}
	}
	public static HashSet<Integer> print4Sum(int[] a){
	    HashSet<Integer> set= new HashSet<Integer>();  
	    if(a.length<4)
	    	return set;
	    
	    int len = a.length;
	    int currentTwoSum = 0;
	    
	    HashMap<Integer, Node> map = new HashMap<Integer,Node>();
	    outerloop:
	    for(int i=0;i<len-1; i++){
	        for(int j=i+1; j<len; j++){
	            currentTwoSum = a[i]+a[j];
	            if (!map.containsKey(currentTwoSum)){  
	                Node node = new Node(i,j);  
	                map.put(currentTwoSum, node); // enter the twoSum and the corresponding Node forming the twoSum  
	            }
	            else{  
	                Node tnode = map.get(currentTwoSum);
	                int x = tnode.x;
	                int y = tnode.y;
	                if (x != i && x != j && y != i && y != j)  
	                {   // add the indices forming A+B=C+D
	                    set.add(x);  
	                    set.add(y);
	                    set.add(i);  
	                    set.add(j);  
	                    break outerloop;
	                }  
	            }  
	        }  
	    }
	    return set;  
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n^2)
	 * Space Complexity = O(1) since HashSet only requires storage of 4 to print the result
	 */
}
class Node  
{  
    int x;  
    int y;  
    public Node(int x, int y){
    	this.x=x;
    	this.y=y;
    }
}

