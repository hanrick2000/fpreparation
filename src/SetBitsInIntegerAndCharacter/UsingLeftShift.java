package SetBitsInIntegerAndCharacter;

import java.util.Scanner;

public class UsingLeftShift {
public static void main(String[] args) {
	Scanner in = new Scanner(System.in);
	try{
		while(true){
			
		System.out.println("Program to check which of the first 8 bits (counting from right to left) are SET or UNSET");
		System.out.println("1. Character \n2. Integer \n3. END");
		System.out.println("Enter choice");
		int choice = in.nextInt();
		
		switch(choice){
		
		case 1:
			System.out.println("Checking set bits in Characters:");
			System.out.println("Enter the string");
			String s = in.next();
			char[] charArray = s.toCharArray();
			printSetBits(charArray);
			break;
			
		case 2:
			System.out.println("Checking set bits in Integers:");
			System.out.println("Enter the size of the integer array");
			int n = in.nextInt();
			int[] a = new int[n];
			System.out.println("Enter the elements of the integer array");
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			printSetBits(a);
			break;
		
		case 3:
			System.out.println("Program Ended");
			System.exit(0);
			
		default:
			System.out.println("Wrong choice");
			break;
		}
	}
		
	}
	finally{
		in.close();
	}
	}

private static void printSetBits(char[] c) {
	for(int i=0;i<c.length;i++){
		System.out.println("Character: "+c[i]);
		System.out.println("Ascii Value "+(int)c[i]);
		System.out.println("Consider counting of bits from right to left");
		System.out.println("Binary Representation "+Integer.toBinaryString((int)c[i]));
		for(int j=0;j<8;j++){  // j is the bitCounter which starts from 0000 and goes till 0111
// This is to check which of the first 8 bits (counting from right to left) are SET or UNSET
			System.out.print("For the "+j+"th bit: ");
			if((c[i]&(1<<j))!=0)  // 1 is left shifted by j positions, i.e. 1<<0 = 1
				System.out.print("SET");                          //   i.e. 1<<1 = 10
			else												  //   i.e. 1<<2 = 100
				System.out.print("UNSET");						  //   i.e. 1<<3 = 1000
			System.out.println();								  //   i.e. 1<<4 = 10000
		}														  //   i.e. 1<<5 = 100000
		System.out.println();									  //   i.e. 1<<6 = 1000000
	}															  //   i.e. 1<<7 = 10000000
}

private static void printSetBits(int[] a) {
	for(int i=0;i<a.length;i++){
		System.out.println("Integer: "+a[i]);
		System.out.println("Consider counting of bits from right to left");
		System.out.println("Binary Representation "+Integer.toBinaryString(a[i]));
		for(int j=0;j<8;j++){  // j is the bitCounter which starts from 0000 and goes till 0111
//This is to check which of the first 8 bits (counting from right to left) are SET or UNSET
			System.out.print("For the "+j+"th bit: ");
			if((a[i]&(1<<j))!=0)  // 1 is left shifted by j positions, i.e. 1<<0 = 1
				System.out.print("SET");                          //   i.e. 1<<1 = 10
			else												  //   i.e. 1<<2 = 100
				System.out.print("UNSET");						  //   i.e. 1<<3 = 1000
			System.out.println();								  //   i.e. 1<<4 = 10000
		}														  //   i.e. 1<<5 = 100000
		System.out.println();									  //   i.e. 1<<6 = 1000000
	}															  //   i.e. 1<<7 = 10000000
}
}
