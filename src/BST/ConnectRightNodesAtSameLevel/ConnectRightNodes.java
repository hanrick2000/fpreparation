/*
Question:
	Write a program to connect all the right nodes at the same level in a BST
Question Source: http://www.careercup.com/question?id=5678808906596352
Answer Source: http://www.geeksforgeeks.org/connect-nodes-at-same-level/

Example:
Write a function to connect all the adjacent nodes at the same level in a binary tree. 
Structure of the given Binary Tree node is like following.

struct node{
  int data;
  struct node* left;
  struct node* right;
  struct node* nextRight;  
}
Initially, all the nextRight pointers point to garbage values. Your function should set these pointers to 
point next right for each node.

Example

Input Tree
       A
      / \
     B   C
    / \   \
   D   E   F


Output Tree
       A--->NULL
      / \
     B-->C-->NULL
    / \   \
   D-->E-->F-->NULL
*/	

package BST.ConnectRightNodesAtSameLevel;

class Node{
	int value;
	Node left;
	Node right;
	Node next;
}
public class ConnectRightNodes {
	public static void connectForPerfectBST(Node root){
		
	}
}
