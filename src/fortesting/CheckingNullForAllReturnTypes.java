package fortesting;

import java.util.List;

public class CheckingNullForAllReturnTypes {
public static void main(String[] args) {
	System.out.println(returnList());  
	System.out.println(returnDouble());
	System.out.println(returndoubleArray());
	System.out.println(returnDoubleArray());
	System.out.println(returnObject());
	System.out.println(returnString());
	//System.out.println(returndouble()); // VERY IMP: CANNOT RETURN NULL for Primitive Datatypes
}

public static List<Integer> returnList(){ // CAN RETURN NULL for return type of complex datatype
	return null;	
}
public static Double returnDouble(){  // CAN RETURN NULL for return type of Wrapper Classes
	return null;
}
public static double[] returndoubleArray(){   // CAN RETURN NULL for complex DS such as array of primitive datatype
	return null;
}
public static Double[] returnDoubleArray(){     // CAN RETURN NULL for complex DS such as array of Wrapper datatype
	return null;
}
public static Object returnObject(){
	return null;                            // CAN RETURN NULL for return type of complex datatype such as Object
}
public static String returnString(){
	return null;                        // CAN RETURN NULL for Wrapper class such as String, since there is no such thing called 'string'
										// The primitive datatype of String Wrapper Class is 'char' and NOT 'string'
}
/*
public static double returndouble(){    
	return null;                            // CANNOT RETURN NULL for Primitive Datatype 
}*/
/*
 * ANOTHER IMPORTANT THING:
 * public static string returnstring(){ // Throws ERROR, since there is no such thing called as 'string'
	// since 'string' is not Primitive datatype. 'String' exists which is Wrapper class
	// and not 'string'. The primitive type of 'String' Wrapper Class can be said to be 'char'.
	// Also the primitive type of 'Character' wrapper class is also 'char'
return null;
}
ONE MORE IMP THING:
public static void returnVoid(){
	return null;                   // This gives ERROR since the return type is void
}

public static void returnVoid(){
	return;                   // This DOES NOT gives ERROR since the return type is void
}
*/
}

/*
 * 
Output:
null
null
null
null
null
null
Exception in thread "main" java.lang.Error: Unresolved compilation problem: 
	Type mismatch: cannot convert from null to double

	at forTesting.CheckingNullForAllReturnTypes.returndouble(CheckingNullForAllReturnTypes.java:36)
	at forTesting.CheckingNullForAllReturnTypes.main(CheckingNullForAllReturnTypes.java:13)
*/
 

