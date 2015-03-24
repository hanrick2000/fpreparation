
/*
 * Question: Implement Queue using two stacks
 * Question Source: 
 * 
 * Answer Source:
 * Watch the three videos mentioned here to understand the implementation:
 * Part I. https://www.youtube.com/watch?v=_PIRZqC0pS0    (10 minutes)
 * Part II. https://www.youtube.com/watch?v=D2Z2iGQW7cM   (10 minutes)
 * Part III. https://www.youtube.com/watch?v=DeChmB6JSZw  (10 minutes)
 * 
 * Explanation:
 * 1. We will use two stacks: oldStack and newStack
 * 2. Whenever there is enqueue operation we will enter the value in newStack
 * 3. Whenever there is dequeue we will check the following:
 *     3.a. if oldStack is empty then we will pop all the elements from the newStack and insert into oldStack. 
 *     Now we will pop an element from oldStack and return that value
 *     3.b. if oldStack is not empty then we will simply pop an element from the oldStack and return it
 * 4. To check the emptiness of the Queue, we need to check both oldStack and newStack. If both oldStack and newStack
 * 	  are empty then the Queue is empty otherwise the queue is not empty
 * 5. Similarly to check the size of the Queue we need to check both oldStack and newStack. The size of the Queue
 * 	  is the sum of sizes of oldStack and newStack
 * 
 */

package QueueUsingStacks;

import java.util.Stack;

public class QueueUsingTwoStacks {
	public static void main(String[] args) {
		Queue q = new Queue();
		System.out.println("The queue is empty: "+q.isEmpty());
		for(int i=0;i<5;i++){
			q.enqueue(i*10);
			System.out.println("ENQUEUED "+i*10+" into queue");
		}
		int size = q.size();
		for(int i=0;i<size;i++)
			System.out.println("DEQUEUED "+q.dequeue()+" from the queue");
	}
	
}
class Queue{
	private Stack<Integer> oldStack;
	private Stack<Integer> newStack;
	private int topElement;
	private int size;
	
	public Queue(){
		oldStack = new Stack<Integer>();
		newStack = new Stack<Integer>();
		topElement=-1;
		size = -1;
	}
	public boolean enqueue(int element){
		boolean ret = true;
		try{
			newStack.push(element);
		}
		catch(Exception e){
			ret=false;
			System.out.println("Error occurred");
		}
		return ret;
	}
	public int dequeue(){
		topElement=-1;
		if(oldStack.empty()){
			while(!newStack.empty()){
				topElement=newStack.pop();
				oldStack.push(topElement);
			}
		}
		if(!oldStack.empty()){
			topElement=oldStack.pop();
		}
		return topElement;
	}
	public boolean isEmpty(){
		if(oldStack.empty() && newStack.empty())
			return true;
		else
			return false;
	}
	public int size(){
		size = oldStack.size()+newStack.size();
		return size;
	}
}