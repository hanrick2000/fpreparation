package forTesting;

import java.util.Scanner;

public class Sample {
public static void main(String[] args) {
	
	Scanner in = new Scanner(System.in);
	try{String s = in.nextLine();
	System.out.println(s.substring(0,s.length()-1));
	System.out.println(s.length());
	}
	finally{
		in.close();
	}
}
}
