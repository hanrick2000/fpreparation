package divideandconquer;

public class ModifiedBinarySearch {
public static void main(String[] args) {
	int[] array = {1,1,1,1,0,0,0,0,0};
	int n = array.length;
	System.out.println("The number of 0's are: "+(n-modifiedBS(array, 0, n-1)));
	
}
public static int modifiedBS(int[] array, int low, int high) {
	
	int mid = (low+high)/2;
	// 0 is the first occurance
	if((array[mid]==0 && array[mid-1]==1)||mid==0)
		return mid;
	// 1 found
	if(array[mid]==1)
		return modifiedBS(array,mid+1,high);
	// 0 is found but not the first occurance
	else
		return modifiedBS(array, low, mid-1);
}
}
/*
Analysis:
	Time Complexity = O(lgn)
	Space Complexity = O(1)*/