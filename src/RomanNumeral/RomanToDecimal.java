package RomanNumeral;

public class RomanToDecimal {
	
public static void romanToDecimal(String romanNumber) {
	
	if(romanNumber == null || romanNumber.length()==0)
		System.out.println("Invalid Number");
	
    int total = 0;
    int lastNumberValue = 0;
    String romanNumeral = romanNumber.toUpperCase();  // convert to upper case

    
    for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
        char convertToDecimal = romanNumeral.charAt(x);
/*
 * TR: 
 * 1. count("DECIMAL") = 7. Hence TO GET DECIMAL from ROMAN we need 7 mappings
 * 2. 15 - XLCDM             Total Conditions = 7     Mention 15-XLCDM from BOTTOM TO TOP    
 * 3. for loop from last to first
 * 4. lastNumberValue = 0, currentNumberValue, total = 0   (LCT where C is variable others are initialized to 0) TR: LCT
 */
        switch (convertToDecimal) {
            case 'M':
            	total = processNumber(lastNumberValue, 1000, total);
            	lastNumberValue = 1000;
                break;

            case 'D':
            	total = processNumber(lastNumberValue, 500, total);
            	lastNumberValue = 500;
                break;

            case 'C':
            	total = processNumber(lastNumberValue, 100, total);
            	lastNumberValue = 100;
                break;

            case 'L':
            	total = processNumber(lastNumberValue, 50, total);
            	lastNumberValue = 50;
                break;

            case 'X':
            	total = processNumber(lastNumberValue, 10, total);
            	lastNumberValue = 10;
                break;

            case 'V':
            	total = processNumber(lastNumberValue, 5, total);
            	lastNumberValue = 5;
                break;

            case 'I':
            	total = processNumber(lastNumberValue, 1, total);
            	lastNumberValue = 1;
                break;
        }
    }
    System.out.println(total);
}

public static int processNumber(int lastNumberValue, int currentNumberValue, int total) {
    if (lastNumberValue > currentNumberValue)       //  TR: Roman Number = IV , lastNumberValue = V (since we start from R to L) and currentNumberValue = I
        return total - currentNumberValue;
    else
        return total + currentNumberValue;   //  TR: Roman Number = VI , lastNumberValue = I (since we start from R to L) and currentNumberValue = V
}

public static void main(java.lang.String args[]) {
    romanToDecimal("XIV");
}
}
/*
Analaysis:
Time Complexity: O(n)
Space Complexity: O(1) 
*/