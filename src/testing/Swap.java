package testing;

import java.util.Arrays;

public class Swap {
	public static void main(String[] args) {
		Swap s = new Swap();
		int[] a = new int[]{1,2,3,4,5,6};
		s.pairwiseSwap(a);
		System.out.println(Arrays.toString(a));
	}

	private  void pairwiseSwap(int[] a) {
		int i=0;
		while(i<=a.length-1 && i+1<=a.length-1){
			swap(i,i+1,a);
			System.out.print(a[i]+" "+a[i+1]+" ");
			i=i+2;
		}
		System.out.println(Arrays.toString(a));
	}

	private static void swap(int i, int j, int[] a) {
		int temp = a[i];
		a[i]=a[j];
		a[j]=temp;
	}
}
