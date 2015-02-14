package Testing;

public class CheckCeil {
public static void main(String[] args) {
	System.out.println((int)Math.sqrt(5));
	System.out.println((int)Math.ceil(Math.sqrt(8)));
	System.out.println(callfunction());
}

private static boolean callfunction() {
	boolean[] array = new boolean[5];
	array[4]=false;
	
	return (array[4]=true);
}
}
