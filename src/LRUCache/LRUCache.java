
/*
 * Source of Explanation which explains why we NEED both:
 * 	1. HashMap = for O(1) operations
 * 	2. DLL = for maintaining FIFO structure (i.e. DLL can easily be used as a Queue.
 * 	Also since we are using DLL instead of simple LL hence traversing is simple since traversal is 
 * 	possible in BOTH directions)
 * 
 * Explanation Source: https://alaindefrance.wordpress.com/2014/10/05/lru-cache-implementation/
 * Implementation Source: http://www.programcreek.com/2013/03/leetcode-lru-cache-java/
 * This implementation source gives the actual code for implementing LRU Cache
 * 
 */

package LRUCache;

import java.util.HashMap;



	class DoublyLinkedList{
	    int key;
	    int value;
	    DoublyLinkedList prev;
	    DoublyLinkedList next;
	    
	    public DoublyLinkedList(int key, int value){
	        this.key = key;
	        this.value = value;
	    }
	}
	public class LRUCache {
	    private HashMap<Integer,DoublyLinkedList> map = new HashMap<Integer,DoublyLinkedList>();
	    private DoublyLinkedList head;
	    private DoublyLinkedList tail;
	    private int capacity;
	    private int length;
	    
	    /*
	    We define 4 operations for LRU cache
	    1. getNode (NOTE: this method returns value of the node and NOT the node itself)
	    2. removeNode
	    3. setNode
	    4. setHeadAndTail
	    */
	    
	    public LRUCache(int capacity){
	        this.capacity = capacity;
	        this.length=0;
	    }
	    
	    // search operation in LRUCache
	    public int getNode(int key){
	        if(map.containsKey(key)){ // if key is present then return the key and replace the head with this node
	            DoublyLinkedList hitNode = map.get(key);
	           
	                removeNode(hitNode);
	                setHeadAndTail(hitNode);
	           
	            return hitNode.value;
	        }
	        else{ // if the node is not present then return -1 as value
	            return -1;
	        }
	    }
	    public void removeNode(DoublyLinkedList node){
	        //DoublyLinkedList curr = node;
	        DoublyLinkedList prev=node.prev;
	        DoublyLinkedList post=node.next;
	        
	        /* 
	        Since we are removing node from already built DLL, hence we can safely conclude that head and tail are NOT NULL
	        Hence we need to check for other 2 conditions while removing.
	        1. prevNode is null
	        2. postNode is null
	        */
	        
	        if(prev==null)
	            head = post;
	        else
	            prev.next=post;
	        
	        
	        if(post==null)
	            tail=prev;
	        else
	            post.prev=prev;
	            
	    }
	    public void setHeadAndTail(DoublyLinkedList node){
	        DoublyLinkedList curr = node;
	        /*
	        check 2 conditions while setting head.
	        1. If the head is already null
	        2. if the end is already null
	        */
	        
	        curr.next = head;  // even if head is null at this point, it doesn't matter
	        curr.prev = null;
	        
	        if(head==null)
	            head=curr;
	        else{
	            head.prev = curr;
	            head = curr;
	        }
	        
	        
	        if(tail==null)
	            tail=curr;
	        
	    }
	    public void setNode(int key, int value){
	        if(map.containsKey(key)){
	            DoublyLinkedList oldNode = map.get(key);
	            oldNode.value=value; // set the new value 
	            removeNode(oldNode);
	            setHeadAndTail(oldNode);
	        }
	        else{
	            // Create a new DLL
	            DoublyLinkedList newNode = new DoublyLinkedList(key,value);
	            /*
	            Add this node to the map. Two conditions exists
	            1. length<capacity
	            2. length=capacity
	            */
	            if(length<capacity){
	                
	                length++;
	            }
	            else{
	                // remove from HashMap
	                map.remove(tail.key);
	                //remove from DLL
	                tail=tail.prev;
	                
	                if(tail==null){} // check if DLL is null do nothing else set next of end as null
	                else
	                    tail.next=null;
	            }
	            
	            map.put(key,newNode);
	            setHeadAndTail(newNode);
	        }
	    }
	}