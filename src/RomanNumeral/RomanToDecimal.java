package RomanNumeral;

public class RomanToDecimal {
	
public static void romanToDecimal(java.lang.String romanNumber) {
    int decimal = 0;
    int lastNumber = 0;
    String romanNumeral = romanNumber.toUpperCase();  // convert to upper case

    
/* operation to be performed on upper cases even if user enters roman values in lower case chars */
    
    for (int x = romanNumeral.length() - 1; x >= 0 ; x--) {
        char convertToDecimal = romanNumeral.charAt(x);
/*
 * TR: 15 - XLCDM             Total Conditions = 7
 */
        switch (convertToDecimal) {
            case 'M':
                decimal = processDecimal(1000, lastNumber, decimal);
                lastNumber = 1000;
                break;

            case 'D':
                decimal = processDecimal(500, lastNumber, decimal);
                lastNumber = 500;
                break;

            case 'C':
                decimal = processDecimal(100, lastNumber, decimal);
                lastNumber = 100;
                break;

            case 'L':
                decimal = processDecimal(50, lastNumber, decimal);
                lastNumber = 50;
                break;

            case 'X':
                decimal = processDecimal(10, lastNumber, decimal);
                lastNumber = 10;
                break;

            case 'V':
                decimal = processDecimal(5, lastNumber, decimal);
                lastNumber = 5;
                break;

            case 'I':
                decimal = processDecimal(1, lastNumber, decimal);
                lastNumber = 1;
                break;
        }
    }
    System.out.println(decimal);
}

public static int processDecimal(int value, int lastNumber, int lastDecimal) {
    if (lastNumber > value)
        return lastDecimal - value;
    else
        return lastDecimal + value;
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