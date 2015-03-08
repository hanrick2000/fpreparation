package RomanNumeral;

import java.util.LinkedHashMap;
import java.util.Map;


public class DecimalToRoman {
	public static String RomanNumerals(int givenNumber) {
	    LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
	    
	    /*
	     * TR:
	     * 1. 1,4,5,9-XLCDM = 10,50,100,500,1000    TOTAL MAPPINGS = 13   Mention 1459-XLCDM from BOTTOM TO TOP        
	     * 2. LinkedHashMap<String,Integer>
	     */
	    
	    roman_numerals.put("M", 1000);
	    roman_numerals.put("CM", 900);
	    roman_numerals.put("D", 500);
	    roman_numerals.put("CD", 400);
	    roman_numerals.put("C", 100);
	    roman_numerals.put("XC", 90);
	    roman_numerals.put("L", 50);
	    roman_numerals.put("XL", 40);
	    roman_numerals.put("X", 10);
	    roman_numerals.put("IX", 9);
	    roman_numerals.put("V", 5);
	    roman_numerals.put("IV", 4);
	    roman_numerals.put("I", 1);
	    
	    
	    StringBuilder res=new StringBuilder();
	    
	    for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){  // return value of entry.Set() is Set<Map.Entry<I,E>>
	      // get the key and value
	      String s = entry.getKey();
	      int v = entry.getValue();
	      // get the repeat chars
	      int repeat = givenNumber/v;                          // Divide
	      // append the repeated chars
	      res.append(repeatChar(s, repeat));
	      // modify the input number
	      givenNumber = givenNumber % v;                       // Modulus
	    } 
	    return res.toString();
	  }
	  public static String repeatChar(String s, int repeat) {
	    if(s == null)
	        return null;
	    
	    StringBuilder sb = new StringBuilder();
	    for(int i = 0; i < repeat; i++)
	        sb.append(s);
	    
	    return sb.toString();
	  }
	  
	  
	  
	  public static void main(String[] args) {
		System.out.println(RomanNumerals(998));
	}
}
/*
Analaysis:
Time Complexity: O(n)
Space Complexity: O(1) 
*/