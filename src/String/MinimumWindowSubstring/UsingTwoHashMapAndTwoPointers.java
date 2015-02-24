/*
 * Question: You are given a set of unique characters and a string. 

Find the smallest substring of the string containing all the characters in the set. 

ex: 
Set : [a, b, c] 
String : "abbcbcba" 

Result: "cba"

Question Source: http://www.careercup.com/question?id=5092414932910080

 * Answer Source: https://linchicoding.wordpress.com/2014/08/20/leetcode-minimum-window-substring/
 * 
 * IMP Sources:
http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
http://mattcb.blogspot.com/2012/12/minimum-window-substring.html
https://linchicoding.wordpress.com/2014/08/20/leetcode-minimum-window-substring/
*/
package String.MinimumWindowSubstring;

import java.util.Scanner;

public class UsingTwoHashMapAndTwoPointers {
	
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter S");
			String s = in.nextLine();
			System.out.println("Enter T");
			String t = in.nextLine();
			System.out.println(minWindow(s, t));
		}
		finally{
			in.close();
		}
	}
	public static String minWindow(String S, String T) {
	        int[] tArr = new int[256];
	        for(int i = 0; i < T.length(); i++){
	            tArr[T.charAt(i)]++;
	        }
	        int [] sArr = new int[256];
	        int match = 0;   // initialize matches
	        String min = "";
	        int start = 0; // initialize start pointer
	        int end =0; // initialize end pointer
	        for(end = 0; end < S.length(); end++){
	            if(tArr[S.charAt(end)] > sArr[S.charAt(end)]){       // ----> T > S. BELOW we have reverse of this
	                match++;
	            }
	            sArr[S.charAt(end)]++;  // -----> mark as VISITED (NECESSARY [i.e. matching characters] as well as UNNECESSARY VISITS[i.e. NOT matching characters])
	            
	            if(match==T.length()){
	        
	            	// Remember THREE conditions if the match == T.length()
	            	
	            	
	            	// REMOVE THE UNNECESSARY NON-MATCHING VISITS UNTIL WE FIND A MATCHING VISIT
	            	
	            	// I. DECREMENT sArr, INCREMENT start IF AND ONLY IF no match found
	            	while(sArr[S.charAt(start)] > tArr[S.charAt(start)]){    // ----> S > T. ABOVE we have reverse of this
	                    sArr[S.charAt(start)]--;               // ------- > REPEAT BELOW 
	                    start++;                               // --------> REPEAT BELOW
	                }
                    
	            	// II. CHECK which is valid min
	                if(min.length()==0 ||  min.length() > end-start+1){
	                    min = S.substring(start, end+1);
	                }
	                
	                // SINCE WE HAVE ALREADY RECORDED THE MATCHING VISIT IN MIN, HENCE REMOVE THE MATCHING VISIT AS WELL
	                // III. DECREMENT sArr, INCREMENT start, DECREMENT match
	                sArr[S.charAt(start)]--;               // ----------> REPEATED
	                start++;                               // ----------> REPEATED
	                match--;
	            }
	             
	        }
	        return min;
	    }  
	}
/*
Analysis:
Time Complexity = O(n) where n = length of sentence S   [O(n) considering substring() is O(1) in some languages but not in JAVA. In JAVA it is O(n)]
Space Complexity = O(1) since we use set of 256 characters which is constant memory
*/