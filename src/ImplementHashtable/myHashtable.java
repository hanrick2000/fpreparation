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

package ImplementHashtable;


/*
 * Generic implementation of a hashtable with array in Java
 * 
 * Algorithm: Inorder to implement Hashtable we will have to implement Entry<K,V> class also
 * Hashtable will have an array object of Entry class
 */
public class myHashtable<K, V> {

    @SuppressWarnings("rawtypes")
    private Entry[] table;
    private int size;
    private int capacity;
    static final int DEFAULT_INITIAL_CAPACITY = 16;
    
    public myHashtable(int capacity){
        this.capacity = capacity;
        table = new Entry[capacity];
        size = 0;
    }
    
    public myHashtable(){
        this(DEFAULT_INITIAL_CAPACITY);
    }
    
    public int size(){
        return size;
    }
    
    private int hash(Object key){
        return Math.abs(key.hashCode()) % capacity;
    }
    
    public V get(Object key){
        if (key == null) 
        	return getForNullKey();
        int hash = hash(key);
        for (@SuppressWarnings("unchecked")
		Entry<K,V> e = table[hash]; e!= null; e = e.next){  // do linear probing
            Object k=e.key;
            if (k == key || key.equals(k))
                return e.value;
        }
        return null;
    }
    
    private V getForNullKey() {
        for (@SuppressWarnings("unchecked")
		Entry<K,V> e = table[0]; e!= null; e = e.next){
            if (e.key == null)
                return e.value;
        }
        return null;
    }
    /*
public V put(K key, V value)

Returns:
the previous value associated with key, or null if there was no mapping for key. (A null return can also indicate that the map previously associated null with key.)
*/
    public V put(K key, V value) {
        if (key == null)
            return putForNullKey(value);
        int hash = hash(key);
        for (@SuppressWarnings("unchecked")
		Entry<K,V> e = table[hash]; e != null; e = e.next) { // if the element at key location is not null
            Object k=e.key;
            if (k == key || key.equals(k)){
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
        
        addEntry(hash, key, value);  // the element at hash location is null
        return null;
    }
    
    private V putForNullKey(V value) {
        for (@SuppressWarnings("unchecked")
		Entry<K,V> e = table[0]; e!= null; e = e.next) {
            if (e.key == null) {
                V oldValue = e.value;
                e.value = value;
                return oldValue;
            }
        }
    addEntry(0, null, value);
    return null;
    }
    
    void addEntry(int hash, K key, V value) {
        @SuppressWarnings("unchecked")
		Entry<K,V> e = table[hash];
        table[hash] = new Entry<>(hash, key, value,e);
    }
       
    static class Entry<K, V>{
        final K key;
        V value;
        Entry<K,V> next;
        final int hash;
        
        Entry(int h, K k, V v, Entry<K,V> n) {
            value = v;
            next = n;
            key = k;
            hash = h;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
        /*
         * setValue
         * 
         * if old value exists then replaces the oldvalue with newvalue and returns oldvalue
         */
        public V setValue(V newvalue) {
        	V oldValue = value;
            value = newvalue;
            return oldValue;
        }
        
       
        
    }
}