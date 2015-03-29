/*
Question: You're given an array of integers(eg [3,4,0,1,2,9,8,6]) 
Find the index of values that satisfy A+B = C + D, where A,B,C & D are integers values in the array. 

Example: Given [3,4,0,1,2,9,8,6] array 
Output: 
Pairs are: [0 3] and [1 2]
 
Question and Answer Source: http://www.careercup.com/question?id=5652354158297088
http://stackoverflow.com/questions/25142170/leetcode-four-sum

VERY IMP NOTE: Question can also be asked as A+B-C-D = 0. Find A,B,C,D
This is called as Four Sum Question. The solution is the SAME

Algorithm:
1. Use Pair class to record the sum of two values.
2. Use HashMap<Integer,Pair> to record the sum of two pair(currentSum) and find two pairs(Pair) which has the same sum
*/
package Sum.FourSum;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class FourSum {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements in the array");
			int n = in.nextInt();
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			System.out.println(print4Sum(a).toString());
		}
		finally{
			in.close();
		}
	}
	public static List<ResultPair> print4Sum(int[] a){
	    List<ResultPair> result= new ArrayList<ResultPair>();  
	    if(a.length<4)
	    	return result;
	    
	    int len = a.length;
	    int currentTwoSum = 0;
	    
	    HashMap<Integer, Pair> map = new HashMap<Integer,Pair>();
	    for(int i=0;i<len-1; i++){
	        for(int j=i+1; j<len; j++){
	            currentTwoSum = a[i]+a[j];
	            if (!map.containsKey(currentTwoSum)){  // If asked for A+B+C+D then  if(!map.containsKey(-currentTwoSum)
	                Pair node = new Pair(i,j);  
	                map.put(currentTwoSum, node); // enter the twoSum and the corresponding Pair forming the twoSum  
	            }
	            else{  
	                Pair p = map.get(currentTwoSum);  // If asked for A+B+C+D then Pair tnode = map.get(-currentTwoSum);
	                int x = p.x;
	                int y = p.y;
	                if (x != i && x != j && y != i && y != j)  
	                {   // add the indices forming A+B=C+D
	                    result.add(new ResultPair(p,  new Pair(i,j)));
	                }  
	            }  
	        }
	    }
	    return result;  
	}
	/*
	 * Analysis:
	 * Time Complexity = O(n^2)
	 * Space Complexity = O(n) since in the worst case all the indices can form valid pairs
	 */
}
class Pair{  
    int x;  
    int y;  
    public Pair(int x, int y){
    	this.x=x;
    	this.y=y;
    }
}
class ResultPair{
	Pair a;
	Pair b;
	public ResultPair(Pair a, Pair b){
		this.a = a;
		this.b = b;
	}
	@Override
	public String toString(){
		return ("Pairs are: ["+a.x+" "+a.y+"] and ["+b.x+" "+b.y+"]");
	}
}

