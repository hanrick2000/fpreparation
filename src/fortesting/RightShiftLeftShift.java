package fortesting;



public class RightShiftLeftShift {
public static void main(String[] args) {
	int n1 =-2;
	System.out.println(Integer.toBinaryString(n1));
	System.out.println(Integer.toBinaryString(n1>>31));
	
	int n2 = 2;
	System.out.println(Integer.toBinaryString(n2));
	System.out.println(Integer.toBinaryString(n2>>31));
}	
}