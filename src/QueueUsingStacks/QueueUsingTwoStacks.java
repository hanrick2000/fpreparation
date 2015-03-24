
/*
 * Question: Implement Queue using two stacks
 * Question Source: 
 * 
 * Answer Source:
 * Watch the three videos mentioned here to understand the implementation:
 * Part I. https://www.youtube.com/watch?v=_PIRZqC0pS0    (10 minutes)
 * Part II. https://www.youtube.com/watch?v=D2Z2iGQW7cM   (10 minutes)
 * Part III. https://www.youtube.com/watch?v=DeChmB6JSZw  (10 minutes)
 */

package QueueUsingStacks;

import java.util.Stack;

public class QueueUsingTwoStacks {
	public static void main(String[] args) {
		Queue q = new Queue();
		System.out.println("The queue is empty: "+q.isEmpty());
		for(int i=0;i<5;i++){
			q.enqueue(i*10);
			System.out.println("Enqueued "+i*10+" into queue");
		}
		int size = q.size();
		for(int i=0;i<size;i++)
			System.out.println("Dequeued "+q.dequeue()+" from the queue");
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
				topElement=newStack.peek();
				oldStack.push(topElement);
				newStack.pop();
			}
		}
		if(!oldStack.empty()){
			topElement=oldStack.peek();
			oldStack.pop();
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