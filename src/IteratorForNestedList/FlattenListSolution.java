package IteratorForNestedList;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class FlattenListSolution{
	
	public static void main(String[] args) {
		
		List<Integer> l1 = new ArrayList<Integer>();
		List<Integer> l2 = new ArrayList<Integer>();
		List<Integer> l3 = new ArrayList<Integer>();
		
		l1=randomizer(l1, 3);
		l2=randomizer(l2, 4);
		l3=randomizer(l3, 5);
		
		System.out.println(l1.toString());
		System.out.println(l2.toString());
		System.out.println(l3.toString());
		
		List<List<Integer>> appendedLists= new ArrayList<List<Integer>>();
		appendedLists.add(l1);
		appendedLists.add(l2);
		appendedLists.add(l3);
		
		FlattenList fl = new FlattenList();
		fl.flatten(appendedLists);
		// print the flattened lists
		while(fl.hasNext()){
			System.out.print(fl.next()+" ");
		}
		
	}
	public static List<Integer> randomizer(List<Integer> l, int elementsCount){
		Random r = new Random();
		for(int i=0;i<elementsCount;i++){
			l.add(r.nextInt(100));
		}
		return l;
	}
	
}


class FlattenList {
	
	/*
	 * VERY IMP NOTE:
	 * Make all the data members private and the member functions public
	 */
	
	
	private int index;
	private List<Integer> flattenedList;
	
	public FlattenList(){
		index=0;
		this.flattenedList = new ArrayList<Integer>();
	}

	public List<Integer> flatten(List<List<Integer>> appendedLists) {
		for(List<Integer> list : appendedLists){
			flattenedList.addAll(list);   // global variable
		}
		return flattenedList;
	}
	
	public boolean hasNext(){
		return flattenedList.size() > index; 
	}
	
	public Integer next(){
		Integer result = flattenedList.get(index);
		index++;
		return result;
	}
}


