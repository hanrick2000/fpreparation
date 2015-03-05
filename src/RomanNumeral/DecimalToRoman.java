package RomanNumeral;

import java.util.LinkedHashMap;
import java.util.Map;


public class DecimalToRoman {
	public static String RomanNumerals(int Int) {
	    LinkedHashMap<String, Integer> roman_numerals = new LinkedHashMap<String, Integer>();
	    
	    /*
	     * TR: 1,4,5,9   -    XLCDM = 10,50,100,500,1000
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
	    
	    for(Map.Entry<String, Integer> entry : roman_numerals.entrySet()){
	      int matches = Int/entry.getValue();
	      res.append(repeat(entry.getKey(), matches));
	      Int = Int % entry.getValue();
	    }
	    return res.toString();
	  }
	  public static String repeat(String s, int repeat) {
	    if(s == null) {
	        return null;
	    }
	    final StringBuilder sb = new StringBuilder();
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