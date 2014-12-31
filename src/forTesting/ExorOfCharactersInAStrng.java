package forTesting;

import java.util.Scanner;

public class ExorOfCharactersInAStrng {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
	System.out.println("Enter the number of elements in the array");
	int n = in.nextInt();
	String[] strArray = new String[n];
	for(int i=0;i<n;i++){
		strArray[i]=in.next();
		System.out.println(calculateXOR(strArray[i]));
	}
	}
	finally{
		in.close();
	}
	
}
public static int calculateXOR(String s){
	int xorValue = s.charAt(0);
	for(int i=1;i<s.length();i++)
		xorValue ^=s.charAt(i);
	return xorValue;
}
}
