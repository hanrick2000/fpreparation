package testing;

import java.util.Arrays;

public class CheckingArrayCopy {
public static void main(String[] args) {
	int[] a = new int[]{2,3,4,5,6};
	int[] b = new int[a.length];
	System.arraycopy(a, 2, b, 1,3 );
	System.out.println(Arrays.toString(b));
}
}
