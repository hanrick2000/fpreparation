package SortCharactersOfStringInASC;

import java.util.Scanner;

public class SortChractersOfAStringInASCOrder {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the string");
		String s = in.nextLine();
		System.out.println(sortInASC(s));
	}
	finally{
		in.close();
	}
}
public static String sortInASC(String s){
	int[] asciiTable = new int[256];
	for(char c: s.toCharArray()){
		asciiTable[c]++;
	}
	StringBuilder sb = new StringBuilder();
	for(int i=0;i<asciiTable.length;i++){
		if(asciiTable[i]>0){
			while(asciiTable[i]>0){
				sb.append((char)i);
				asciiTable[i]--;
			}
		}
	}
	return sb.toString();
}
}
/*Analysis:
	Time Complexity = O(n), Linear Time Sorting
	Space Complexity = (n)
*/