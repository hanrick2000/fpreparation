package Divideandconquer;

public class isNumberPalindrome {
	
public static boolean isPalindrome(int number){
	int temp = number;
	int remainder =0 ;
	int rev =0 ;
	while(number>0){	
		remainder = number % 10;
		rev = (rev*10) + remainder; 
		number /=10;

	}
	return temp==rev;
}
public static void main(String[] args) {
	int no=121;
	System.out.println(isPalindrome(no));
}
}

/*
Analysis: The time complexity of the method is O(n) where n is the number of digits in the integer.
*/
// TODO : Find a better solution than this