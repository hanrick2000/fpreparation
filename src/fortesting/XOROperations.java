package fortesting;

public class XOROperations {
public static void main(String[] args) {
	/*
	3 EQUALLY SPACED(VERY VERY IMP) numbers (NOT NECESSARILY SORTED). 
	Hence if any two numbers are given then finding the 3rd number is easy 
	using XOR of the two given numbers
	
	In 3 numbers,
	
	a-----b------c
	
	If I want to find the middle number, then
	middle number = prev XOR next. Thus, to find middle[b], I should know prev[a] and next[c]
	any number = next XOR next.next . Thus, to find any number[a], I should know its next[b] and the next of next[c]
	any number = prev XOR prev.prev . Thus, to find any number[c], I should know its prev[b] and the prev of prev[a]
	
	This property of XOR is used in MEMORY EFFICIENT DOUBLY LINKED LIST
	
	
	NOTE: The missing number can only be found, if the numbers in the array start from 1 to n, where n = size of the array
	*/
	int a_equallySpaced = 80; // 3 EQUALLY SPACED NUMBERS
	int b_equallySpaced = 40;
	int c_equallySpaced = 120;
	
	
	int a1_UNequallySpaced = 20; // 3 UNEQUALLY SPACED NUMBERS
	int b1_UNequallySpaced = 80;
	int c1_UNequallySpaced = 120;
	
	// SINCE a,b,c are EQUALLY SPACED, HENCE WE CAN SUCCESSFULLY FIND THE MISSING NUMBER
	System.out.println(a_equallySpaced^c_equallySpaced); // gives b [Output: 80]
	System.out.println(a_equallySpaced^b_equallySpaced); // gives c [Output: 120]
	System.out.println(c_equallySpaced^b_equallySpaced); // gives a (XOR is COMMUTATIVE. HENCE IT IS SAME AS (b^c))   [Output: 40]
	
	
	// SINCE a1,b1,c1 are UNEQUALLY SPACED, HENCE WE CANNOT FIND THE MISSING NUMBER
	System.out.println(a1_UNequallySpaced ^c1_UNequallySpaced ); //  [Output: 108] which is NOT b
	System.out.println(a1_UNequallySpaced ^b1_UNequallySpaced ); //  [Output: 68]  which is NOT c
	System.out.println(c1_UNequallySpaced ^b1_UNequallySpaced ); //  [Output: 40]  which is NOT a
	}
}
