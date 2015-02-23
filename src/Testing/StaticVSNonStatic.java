package Testing;

import java.util.Arrays;

public class StaticVSNonStatic {
	public static void main(String[] args) {
		int[] a = new int[]{1,2,3,4,5,6,7,8,9,10};
		staticSwap(a,0,9);
		System.out.println(Arrays.toString(a));
		
		
		
		StaticVSNonStatic demo = new StaticVSNonStatic();
		demo.nonStaticSwap(a,9,0);
		demo.nonStaticSwap(a,1,8);
		System.out.println(Arrays.toString(a));
		
	}
	public static void staticSwap(int[] a, int to, int from){
		a[to]=a[to]^a[from];
		a[from]=a[to]^a[from];
		a[to]=a[to]^a[from];
	}
	public void nonStaticSwap(int[] a, int to, int from){
		a[to]=a[to]^a[from];
		a[from]=a[to]^a[from];
		a[to]=a[to]^a[from];
	}
}
