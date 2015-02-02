package RemoveDuplicatesButMaintainOrder;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UsingLinkedHashSet {
	 public static void main(String[] args){
		    Scanner in = new Scanner(System.in);
		    try{
		    	System.out.println("This program will REMOVE DUPLICATES AND MAINTAIN INSERTION ORDER");
		    	System.out.println("Enter the number of elements in the array");
		    	int n = in.nextInt();
		    	int[] a = new int[n];
		    	System.out.println("Enter the elements of the array");
		    	for(int i=0;i<n;i++)
		    		a[i]=in.nextInt();
		    	removeDuplicatesAndMaintainOrder(a);
		    }
		    finally{
		    	in.close();
		    }
	    }
	    
	    public static void removeDuplicatesAndMaintainOrder(int[] a){
	    
	    Set<Integer> linkedset = new LinkedHashSet<Integer>();
	    
	    for(int i: a)
	        if(!linkedset.contains(i))
	            linkedset.add(i);
	    print(linkedset);
	    
	    }
	    public static void print(Set<Integer> set){
	        Iterator<Integer> iter = set.iterator();
	        while(iter.hasNext())
	            System.out.println(iter.next());
	    
	    }
	    /*
	     * Analysis:
	     * Time Complexity = O(n)
	     * Space Complexity = O(n)
	     */
}
