package Testing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CheckCeil {


public static void main(String[] args) {
	System.out.println((int)Math.sqrt(5));
	System.out.println((int)Math.ceil(Math.sqrt(8)));
	System.out.println(callfunction());
	System.out.println("A#$%A".toLowerCase());
	int numberOfSpaces = 3;
	
	String space = String.format("%" + numberOfSpaces + "s", "H");
	System.out.print(space);
	System.out.println();
	ArrayList<Integer> list = new ArrayList<Integer>();
	Integer a = new Integer(20);
	list.add(a);
	System.out.println(list instanceof Collection);
	Iterator<Integer> iter = list.iterator();
	while(iter.hasNext()){
		Object o = (Object)iter.next();
		System.out.println(o instanceof Collection);
	
	}
}

private static boolean callfunction() {
	boolean[] array = new boolean[5];
	array[4]=false;
	
	return (array[4]=true);
}
}
