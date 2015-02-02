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
and the space complexity will also be O(n^2).

BUT WITH THIS ALGORITHM THOUGH THE TIME COMPLEXITY IF O(N), AND THE SPACE COMPLEXITY IS O(1)

Question and Answer Source:http://www.careercup.com/question?id=4793416529477632
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
	String small;
	String large;
	
	if(s1.length() > s2.length()){
		small = s2;
	    large = s1;
	}
	else{
		small = s1;
		large = s2;
	}
	
	int operations = 0;
	
	if(large.length() - small.length() > 1)
		return false;
	
	else if(large.length()==small.length()){

		for(int i=0;i<small.length();i++){
			if(small.charAt(i)!=large.charAt(i)){
				operations++;
				if(operations>1)
					return false;
			}
		}	
	}
	else{ // small and large strings are different by length = 1
		
	
		// HERE WE NEED A WHILE LOOP
		int i=0;
		
		while(i<small.length()){
			
			if(small.charAt(i)!=large.charAt(i+operations)){
				operations++;
				if(operations>1)
					return false;
			}
			else{
				i++;  // increment the i
			}
		}
		
	}
	return true;  // all conditions for false are checked, hence return true
	
	}
}
/*
Analysis:
	Time Complexity = O(n) where n = length of larger string
	Space Complexity = O(1)
*/