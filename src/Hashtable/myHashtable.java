/*
 * Question: Implement a HashTable ?
 * 
 * Question Source: MIT BBS Facebook Interview Question
 * 
 *  IMP LINKS:
 *  1. Difference between HashTable and HashMap
 *  http://www.careercup.com/question?id=5645950492082176
 *  
 *  2. Difference between ConcurrentHashMap, Hashtable and synchronizedMap
 *  http://stackoverflow.com/questions/510632/whats-the-difference-between-concurrenthashmap-and-collections-synchronizedmap
 *  
╔═══════════════╦═══════════════════╦═══════════════════╦═════════════════════╗
║   Property    ║     HashMap       ║    Hashtable      ║  ConcurrentHashMap  ║
╠═══════════════╬═══════════════════╬═══════════════════╩═════════════════════╣ 
║      Null     ║     allowed       ║              not allowed                ║
║  values/keys  ║                   ║                                         ║
╠═══════════════╬═══════════════════╬═════════════════════════════════════════╣
║Is thread-safe ║       no          ║                  yes                    ║
╠═══════════════╬═══════════════════╬═════════════════════════════════════════╣
║     Lock      ║       not         ║        locks the portion of             ║ 
║  mechanism    ║    applicable     ║                  map                    ║ 
╠═══════════════╬═══════════════════╩═══════════════════╦═════════════════════╣
║   Iterator    ║               fail-fast               ║       fail-safe     ║ 
╚═══════════════╩═══════════════════════════════════════╩═════════════════════╝




Answer Source: 
HashTable Implementation with array in Java:
https://github.com/ylwu/java-exercises/blob/master/src/HashTable.java   ->  Good Program
https://github.com/zwaldowski/zw-schoolwork/blob/master/CS%201332/HW6/HashTable.java


http://iwillgetthatjobatgoogle.tumblr.com/post/11352414963/implement-a-hash-table


 * 
 */

package Hashtable;


/*
 * Generic implementation of a hashtable with array in Java
 * 
 * Algorithm: Inorder to implement Hashtable we will have to implement Entry<K,V> class also
 * Hashtable will have an array object of Entry class
 * 
 * 
 * NOTE: If we want to implement HashMap then remove the condition which says
 * 
 * if(key==null || value==null){
			System.out.println("Null key or value not allowed");
			return null;
		}
		
	REMOVING THIS CONDITION WILL CONVERT HASHTable INTO HASHMAP
	NOTE: HashMap can have ATMOST one null key
		  HashMap can have MULTIPLE null values	
 * 
 * 
 */
public class myHashtable<K, V> {


    private Entry<K,V>[] table;
    private int size;
    private int capacity;
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    /*
     * TWO constructors:
     * I. Parameterized constructor
     * II. Default Constructor
     */
    @SuppressWarnings("unchecked")
    public myHashtable(int capacity){
        this.capacity = capacity;
        table = new Entry[capacity];
        size = 0;
    }
    
    public myHashtable(){
        this(DEFAULT_INITIAL_CAPACITY);
    }
    
    
    /*
     * THREE MUST HAVE functions of Hashtable
     * 
     *  I. size()
     *  II. hashKey(Object key)
     *  III. indexForHash(int hash, Entry<?,?>[] table)
     */
    public int size(){
        return size;
    }
    
    private static int hashKey(Object key) {
		return Math.abs(key.hashCode());
	}
	
	private static int indexForHash(int hash, Entry<?,?>[] table) {
		return hash % (table.length);
	}
    
    

	/*
	 * Maps the specified key to the specified value in this hashtable. 
	 * Neither the key nor the value can be null.
	 * 
	 * Returns:
		the previous value associated with key if there was a previous value OR 
		null if there was no mapping for key.
	 * 
	 * 
	 * (Source: http://docs.oracle.com/javase/7/docs/api/java/util/Hashtable.html#put(K,%20V))
	 * 
	 * 
	 * Methods required for put(K key, V value) method
	 * I.  put()
	 * II. addEntryAtIndex()
	 * III. addEntryToTableAtIndex
	 */
    public V put(K key ,V value) {
    	
    	/*
		 * Hashtable does not accept null keys and null values
		 */
		
		if(key==null || value==null){
			System.out.println("Null key or value not allowed");
			return null;
		}
    	
		int hash = hashKey(key);
		int index = indexForHash(hash, table);
		
		if (table[index] == null) { // If the array at index is empty then insert it
			addEntryAtIndex(index, key, value);
			return null;
		} else {
			Entry <K, V> entry = table[index]; // get the previous entry
			while (entry != null) {
				// if the entry is filled(i.e. value of the entry is NOT null) and key matches
				if (!entry.isAvailable() && ((entry.getKey() == key || entry.getKey().equals(key)))) {
					V oldValue = entry.getValue();
					entry.setValue(value);
					entry.setAvailable((value == null) ? true : false);
					return oldValue;  // break the loop and return
				}
				// else if the key does not match EXACTLY then do a linear probing
				index = indexForHash(index + 1, table);
				entry = table[index];
			}
		}
		
		// So we're now at a point where we can just insert it.
		// Thanks, linear probing!
		addEntryAtIndex(index, key, value);
		return null;
	}
    private void addEntryAtIndex(int hash, K key, V value) {
		addEntryToTableAtIndex(table, hash, key, value);
		size++;
		if (size >= capacity) {
			//resize();  We donot need to implement this method in interviews
		}
	}
	private void addEntryToTableAtIndex(Entry<K,V>[] table, int idx, K key, V value) {
		Entry<K, V> entry = new Entry<>(key, value);
		entry.setAvailable((value == null) ? true : false);
		table[idx] = entry;
	}
   
	
	
	/*
	 * Methods required for get(K key) method
	 * I.  get()
	 * II. getEntryWithKey()
	 */
	
	public V get(Object key) {
		/*
		 * Hashtable does not accept null keys
		 */
		
		if(key==null){
			System.out.println("Null key or value not allowed");
			return null;
		}
		
		Entry <K, V> entry = getEntryWithKey(key);
		if (entry == null) 
			return null;
		return entry.getValue();
	}
	
	private Entry<K, V> getEntryWithKey(Object key) {
		int hash = hashKey(key);
		int index = indexForHash(hash, table);
		
		Entry <K, V> entry = table[index];
		while (entry != null) {
			// if entry is filled and key matches then break this while loop
			if (!entry.isAvailable() && (entry.getKey() == key || entry.getKey().equals(key))) {
				break;
			}
			
			index = indexForHash(index + 1, table);
			entry = table[index];
		}
		
		return entry;
	}
       
	
	/*
	 * Entry Class with THREE data members
	 * I.  K key
	 * II. V value
	 * III boolean available
	 */
    public static class Entry<K,V> {
		private K key;
		private V value;
		private boolean available;
		
		public Entry(K key, V value) {
			this.setKey(key);
			this.setValue(value);
			this.setAvailable(true);
		}
		
		
		/*
		 * Getters and setters for each of the data member 
		 */
		
		
		// get and set key
		public void setKey(K key) {
			this.key = key;
		}
		
		public K getKey() {
			return this.key;
		}
		// get and set value
		public void setValue(V value) {
			this.value = value;
		}
		
		public V getValue() {
			return this.value;
		}
		// get and set available
		public boolean isAvailable() {
			return available;
		}

		public void setAvailable(boolean available) {
			this.available = available;
		}
		
		
	}

}