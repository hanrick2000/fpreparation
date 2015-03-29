/*
 * Question: Given a dictionary of words, return an array of the words whose match. 
 * (i.e. pattern "c.t" match with "cat", "cut", etc. because the dot notation stand for ANY character). 
 * 
 * Question and Answer Source: http://www.careercup.com/question?id=5197316961075200
 * 							   http://www.javainterview.net/facebook/find-string-matches
 * 
 * Algorithm
 1. declare "Trie" data structure

 2. store the given word from question. "cat","cut","cot"

 3. input the match string "c.t" , dot(.) represent "ANY" character

 4. traverse from start and find a string , store it to arraylist

SEARCHPRINT method:
  1. It will printout current data as long as it finds "single character"
    then move to the next node 

 2. But if it finds dot(.) ,
    It will printout all the child data
    then recursively call searchPrint method with  (substring(currenposition+1),childNode)
    so that it can continue to walk through

 3. Because of step no 2. current loop will be actually void. - This is my trick :)
    That's why "break" syntax is there.
 */
package Regex.DotDictionary;

import java.util.ArrayList;
import java.util.List;

class ReturnArrayOfWords {

	 public static void main(String[] args){
		  Trie t = new Trie();
		  t.insert("cata");
		  t.insert("cot");
		  t.insert("cuta");
		  t.insert("cst");
		  t.searchPrint("c.t",t.root); 
		  System.out.println();
		  System.out.println(t.search("cot"));
		 }
}

//TrieNode of Trie data structure
class TrieNode{
	
	char data; //character
	List<TrieNode> children; //nodelist of child
	boolean isLastWord; // end of the word indicator
 
	//constructor
	public TrieNode(char c){
		this.data=c;
		children=new ArrayList<>();
		isLastWord=false;
	}
 
	//return childenode which contains character
	TrieNode getNode(char c){
		if(children==null || children.size()==0)
			return null;
		else{
			for(int i=0;i<children.size();i++){
				TrieNode n=children.get(i);
				if(n.data==c)
					return n;
			}
			return null;
		}
	}
} // end of class TrieNode

	class Trie{
	 
		//TrieNode Root data is " "//space empty 
	 TrieNode root;
	 public Trie(){
		 root=new TrieNode(' ');
	 }
	 
	 //insert method
	 public void insert(String s){
	  //check root or string is empty
		 if(root==null || s=="")
			 return;
		 else{
			 TrieNode curr=root;
			 char[] c=s.toCharArray();
			 
			 for(int i=0;i<c.length;i++){
				 char tmp=c[i];     
				 TrieNode n =curr.getNode(tmp);
				 
				 if(n==null){
					 curr.children.add(new TrieNode(tmp));
					 curr=curr.getNode(tmp);
				 }else{
					 curr=curr.getNode(tmp);
				 }
				 
				 //if the character is end of the word
				 //set the flag
				 if(i==c.length-1)
					 curr.isLastWord=true;
			 }
		 }
	 	}
	 
	 	//VERY IMPORTANT , RECURSIVE CALL TO TRAVERSE ALL BRANCHES OF TRIE
	 	public void searchPrint(String s,TrieNode n){
	 		TrieNode curr=n;
	 		
	 		if(curr==null || s==null)
	 			return;
	 		else{
	 			//search String loop
	 			for(int i=0;i<s.length();i++){
	 				//current character
	 				char c=s.charAt(i);
	 				
	 				//no match exit method
	 				if(curr.getNode(c) == null && c!='.')
	 					return;
	 				//match single character
	 				else if(curr.getNode(c) != null && c!='.'){
	 					curr=curr.getNode(c);
	 					System.out.print(curr.data);
	 					
	 				}
	 				//match but ALL(*)
	 				else{ //curr.getNode(c)!=null && c=='.'{
	 					System.out.println("\r\n");
	 					//print out all child first
	 					for(TrieNode t:curr.children)
	 						System.out.print(t.data);
	 					
	 					System.out.println("\r\n");
	 					
	 					//NAVIGATE TO NEXT NODE FROM EACH CHILDEREN
	 					for(TrieNode t:curr.children)
	 						searchPrint(s.substring(i+1),t); 
	 					break;
	 				} // end of else
	 			} // end of for
	 			
	 		} // end of else
	 	}   // end of method
	 	
	 	//search return true or false
	 	public boolean search(String s){
	 		if(root==null || s=="")
	 			return false;
	 		else{
	 			char[] c=s.toCharArray();
	 			TrieNode curr=root;
	 			for(int i=0;i<c.length;i++){
	 				char tmp=c[i];     
	 				TrieNode n =curr.getNode(tmp);
	 				
	 				if(n==null){
	 					return false;
	 				}else{
	 					curr=curr.getNode(tmp);
	 				}
	 				
	 				if(i==c.length-1 && curr.isLastWord==true)
	 					return true;
	 			}
	 			return false;
	 		}   
	 	}
	}
	/*
	Analysis:
	Time Complexity = O(m) where m = average length of word to be searched
	Space Complexity = O(n*m) where n = number of words and m = average length of each word
	*/