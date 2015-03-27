package testing;

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
		
		int[][] matrix = new int[][]{{20, 40, 80, 90}, {5, 60, 90, 100}, {45, 50, 55, 65}};
		System.out.println(matrix.length);
		System.out.println(matrix[0].length);
		
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
