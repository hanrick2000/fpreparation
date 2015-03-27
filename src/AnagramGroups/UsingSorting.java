package AnagramGroups;


import java.util.Arrays;
import java.util.Scanner;
public class UsingSorting {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of elements you want to enter in the string array");
			int n = in.nextInt();
			System.out.println("Enter the elements of the string array");
			String[] sArray = new String[n];
			for(int i=0;i<n;i++){
				sArray[i] = in.next();
				sArray[i] = sortString(sArray[i]);
			}
			Arrays.sort(sArray); // sort the string array. O(mlgm) time complexity.
			printArray(sArray);
			int count=0;
			for(int i=0;i<n-1;i++){
				if(sArray[i].equals(sArray[i+1])){
					System.out.println("String at Index: "+i+" pairs with string at Index: "+(i+1));
					count++;
				}
			}
			if(count==0)
				System.out.println("No anagram match found");
		}
		finally{
			in.close();
		}
	}
	private static void printArray(String[] sArray) {
		System.out.println("Array elements are:");
		for(int i=0;i<sArray.length;i++){
			System.out.println(sArray[i].toString());
		}
	}
	public static String sortString(String s){
		char[] array = s.toCharArray();
		Arrays.sort(array);           // sort the characters of the string. O(nlgn) time complexity.
		return String.valueOf(array);   // convert char array to String
	}
}
	

	/*Analysis:
		Time Complexity: O(m*lgm*n*logn), where m = No of Strings in String Array
											n = Length of each string
		Space Complexity: O(m*n)
	*/