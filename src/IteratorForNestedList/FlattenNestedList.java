/*
Question:
	Flatten an iterator of iterators in Java. If the input is [ [1,2], [3,[4,5]], 6], 
	it should return [1,2,3,4,5,6]. Implement hasNext() and next().

Question and Answr Source: http://www.careercup.com/question?id=5153954321137664
*/
package IteratorForNestedList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@SuppressWarnings("rawtypes")
public class FlattenNestedList implements Iterator {
	
	/*
	 *  The generic types are REMOVED
	 */
	private Collection c;
	private ArrayList result = new ArrayList();  // ArrayList of integers
	private Iterator resultItr = null;  // Iterator for integers stored in the result
	
	public FlattenNestedList(Collection o) {
		this.c = o;
		if(!c.isEmpty()) {
			extractAll(c);
			this.resultItr = result.iterator();
		}
	}
	
	@SuppressWarnings("unchecked")
	private void extractAll(Collection obj) {
		Iterator collectionItr = obj.iterator(); // iterator for the collection
		while(collectionItr.hasNext()) {
			Object o = collectionItr.next();
			if(o != null) {                  // FIRST CHECK FOR NULL
				if(o instanceof Collection)  // THEN CHECK FOR whether instance of COLLECTION
					extractAll((Collection)o);
				else
					result.add(o); // Here we are adding the underlying primitive Wrapper type. In this case it is Integer
				    // objs is Global variable				
			}
		} // end of while
	}

	public static void main(String[] args) {
	
		
		
		ArrayList<Integer> l1 = new ArrayList<Integer>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		ArrayList<Integer> l3 = new ArrayList<Integer>();
		ArrayList<Integer> l4 = new ArrayList<Integer>();
		ArrayList<Integer> l5 = new ArrayList<Integer>();
		ArrayList<Integer> l6 = new ArrayList<Integer>();
		
		
		ArrayList<ArrayList<Integer>> l11 = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> l21 = new ArrayList<ArrayList<Integer>>();
		ArrayList<ArrayList<Integer>> l31 = new ArrayList<ArrayList<Integer>>();
		
		l1=randomizer(l1, 3);
		l2=randomizer(l2, 4);
		l3=randomizer(l3, 5);
		l4=randomizer(l4, 3);
		// l5 is empty list
		l6=null; // l6 is null list
		
		l11.add(l1);
		l11.add(l4);
		l21.add(l2);
		l21.add(l5);
		l31.add(l3);
		l31.add(l6);
		System.out.println(l11.toString());
		System.out.println(l21.toString());
		System.out.println(l31.toString());
		
		List<ArrayList<ArrayList<Integer>>> nestedLists = new ArrayList<ArrayList<ArrayList<Integer>>>();
		nestedLists.add(l11);
		nestedLists.add(l21);
		nestedLists.add(l31);
		
		
		/*
		 * Sample Input : 
		[[90, 60, 35], [24, 59, 47]]
		[[60, 68, 38, 17], []]
		[[51, 96, 66, 44, 69], null]
		 */
		
		FlattenNestedList it = new FlattenNestedList(nestedLists);
		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
	}
	public static ArrayList<Integer> randomizer(ArrayList<Integer> l, int elementsCount){
		Random r = new Random();
		for(int i=0;i<elementsCount;i++){
			l.add(r.nextInt(100));
		}
		return l;
	}
	
	public boolean hasNext() {
		return resultItr.hasNext();
	}

	public Object next() {
		return resultItr.next();
	}

	// Not overriden
	public void remove() {
		
	}
}