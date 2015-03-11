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
https://linchicoding.wordpress.com/2014/08/20/leetcode-minimum-window-substring/
http://rleetcode.blogspot.com/2014/01/minimum-window-substring-java.html
http://www.geeksforgeeks.org/find-the-smallest-window-in-a-string-containing-all-characters-of-another-string/
http://mattcb.blogspot.com/2012/12/minimum-window-subs	tring.html
*/
package String.MinimumWindowSubstring;

import java.util.Scanner;

public class UsingTwoHashMapAndTwoPointers {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter sentence");
			String big = in.nextLine();
			System.out.println("Enter text which is small than sentence");
			String small = in.nextLine();
			System.out.println(minWindow(big, small));
		}
		finally{
			in.close();
		}
	}
	/*
	 * Notes:
1. To count occurrence of characters, instead of using a hash map, can use an int array of 256
2. Two pointer method with one point to end and one point to start.
   Pointer advance condition: move end forward till finds one window, then move start forward till the
   window no longer valid, then move end forward to find another valid window
 */
	public static String minWindow(String big, String small) {
		
		// EXTREME CASES
		if (small==null||big==null){
            return null;
        }
        if(small.length()==0 && small.length()==0){
            return "";
        }
        if (big.length()<small.length()){
            return "";
        }
		// END OF EXTREME CASES
   	        int[] smallArr = new int[256];
	        for(int i = 0; i < small.length(); i++){
	            smallArr[small.charAt(i)]++;
	        }
	        int [] bigArr = new int[256];
	        int match = 0;   // initialize matches
	        String min = "";
	        int start = 0; // initialize start pointer
	        int end =0; // initialize end pointer
	        for(end = 0; end < big.length(); end++){
	            if(smallArr[big.charAt(end)] > bigArr[big.charAt(end)]){       // ----> Small > Big. BELOW we have reverse of this
	                match++;
	            }
	            bigArr[big.charAt(end)]++;  // -----> mark as VISITED (NECESSARY [i.e. matching characters] as well as UNNECESSARY VISITS[i.e. NOT matching characters])
	            if(match==small.length()){	        
	            	// Remember THREE conditions if the match == Small.length()
	   	        	// REMOVE THE UNNECESSARY NON-MATCHING VISITS UNTIL WE FIND A MATCHING VISIT
	            	// I. DECREMENT smallArr, INCREMENT start IF AND ONLY IF no match found
	            	while(bigArr[big.charAt(start)] > smallArr[big.charAt(start)]){    // ----> Big > Small. ABOVE we have reverse of this
	                    bigArr[big.charAt(start)]--;               // ------- > REPEAT BELOW 
	                    start++;                               // --------> REPEAT BELOW
	                }
                    // II. CHECK which is valid min
	                if(min.length()==0 ||  min.length() > end-start+1){
	                    min = big.substring(start, end+1);
	                }
	                
	                // SINCE WE HAVE ALREADY RECORDED THE MATCHING VISIT IN MIN, HENCE REMOVE THE MATCHING VISIT AS WELL
	                // III. DECREMENT smallArr, INCREMENT start, DECREMENT match
	                bigArr[big.charAt(start)]--;               // ----------> REPEATED
	                start++;                               // ----------> REPEATED
	                match--;
	            }
	             
	        }
	        return min;
	    }  
	}
/*
Analysis:
Time Complexity = O(n) where n = length of big string   [O(n) considering substring() is O(1) in some languages but not in JAVA. In JAVA it is O(n)]
Space Complexity = O(1) since we use set of 256 characters which is constant memory
*/