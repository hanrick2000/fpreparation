package find2NonRepeatingNumbers;

/*
 * NOTE: This method is applicable for not just 2 NON-repeating numbers but for n Non-repeating numbers.
*/
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class UsingHashMap {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try{
			System.out.println("Enter the number of number of elements in the array");
			int n = in.nextInt();
			System.out.println("Enter the 2 non repeating and the others as repeating elements in the array");
			int[] a = new int[n];
			for(int i=0;i<n;i++)
				a[i]=in.nextInt();
			get2NonRepeatingNumbers(a);
		}
		finally{
			in.close();
		}
	}

	private static void get2NonRepeatingNumbers(int[] a) {
		HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
		for(int i=0;i<a.length;i++){
			if(!hash.containsKey(a[i])){
				hash.put(a[i], 1);
			}
			else{
				int count = hash.get(a[i]);
				count++;
				hash.put(a[i], count);
			}
		}
		Set<Map.Entry<Integer,Integer>> set = hash.entrySet();
		Iterator<Map.Entry<Integer, Integer>> iter = set.iterator();  // we iterate over Map.Entry<>()
		while(iter.hasNext()){
			Map.Entry<Integer, Integer> element=iter.next();
			if(element.getValue()==1)
				System.out.println("The non-repeating element is: "+element.getKey());
		}
	}
	
}
/*
Analysis:
	Time Complexity = O(n)
	Space Complexity = O(n)
*/