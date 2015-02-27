
/*
 * 
 * Question: Write a function to convert int to String for MS Excel
Example: 1 to A
26 to Z
27 to AA
52 to AZ
53 to AAA
798 to AAZ.... etc
Similarly do the reverse

NOTE:
But this is not base-26. It's easy to see why BECAUSE: there is no zero! (everything starts from A
and ends on Z)

Question Source: http://www.careercup.com/question?id=6139456847347712

I think of it this way:
A-26 (26 of them)
AA-ZZ (26*26 of them)
AAA-ZZZ (26*26*26 of them)

So it's relatively easy once we figure out which "level" we are in.
We do that with several variables:
*/
package ExcelNumbers;

public class UsingLogic {
public static void main(String[] args) {
	System.out.println(numToStr(702));
	System.out.println(strToNum("A"));
}

public static String numToStr(int n) {
	// Extreme Case
	if(n==0)
		return null;
  
    String columnName = "";
    while(n>0){
    	int val = (n-1)%26; // Example if n=1 then value =0
    	columnName = (char)(val+65) + columnName;// value+65 = 0+65=A
    	n = (n-val)/26;
    }
    return columnName;
}
/*
Time Complexity = O(n/26) where n = numeric number
Space Complexity = O(1)
*/


public static int strToNum(String str){  // If str=A
	
	// Extreme Case
	if(str==null || str.length()==0)
		return -1;
	
	int sum=0;
	for(int i =str.length()-1;i>=0;i--)  
		sum = sum + (int)(str.charAt(i) - 64) * (int)Math.pow(26, str.length()-1-i); // Math.pow returns double, hence we typecast it to int
	  // we do -64 because we need 1 for A, so that multiplication would be VALID
	return sum;
	}
}
/*
Time Complexity = O(n) where n = length of string
Space Complexity = O(1)
*/