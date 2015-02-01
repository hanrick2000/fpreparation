package OneEditApart;

/*
Question: Given two strings, return boolean True/False, if they are only one edit apart.Edit can be insert/delete/update of only one character in the string. Eg: 

-True 
xyz,xz 
xyz, xyk 
xy, xyz 


-False 
xyz, xyz 
xyz,xzy 
x, xyz

NOTE: Can be done using EDIT-DISTANCE Algorithm, but IT WONT BE EFFICIENT since the time complexity will be O(n^2)
ans the space complexity will also be O(n^2).

Source: http://www.careercup.com/question?id=5092486548553728
*/


import java.util.Scanner;

public class StringsOneEditApart {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		System.out.println("Enter the two strings");
		String s1 = in.nextLine();
		String s2 = in.nextLine();
		System.out.println(areOneEditApart(s1,s2));
	}
	finally{
		in.close();
	}
}

private static boolean areOneEditApart(String s1, String s2) {
	int m = s1.length();
	int n = s2.length();
	if(Math.abs(m-n) > 1)  // if length of both the strings differs more than 1
		return false;
	if(s1.equals(s2))   // if they are exactly same. That means they are NOT ONE EDIT apart
		return false;
	int i=0;
	int j=0;
	while(i < m && j < n){
		if(s1.charAt(i)==s2.charAt(j)){
			i++;
			j++;
			continue;
		}
		if(s1.charAt(i)!=s2.charAt(j)){
			if(s1.substring(i+1, m).equals(s2.substring(j, n)))
				return true;
			if(s1.substring(i, m).equals(s2.substring(j+1, n)))
				return true;
		}
		
	}
	return false;
}
}
/*
Analysis:
	Time Complexity = O(n)
	Space Complexity = O(1)
*/