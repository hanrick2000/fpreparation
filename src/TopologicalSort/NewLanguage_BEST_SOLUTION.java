/*
 * 
 * Question: There's a new language which uses the Latin alphabet. However, you don't know the order among letters. 

It could be: 
a b c d ... 

As it could also be: 
b e z a m i ... 

You receive a list of words lexicographically sorted by the rules of this new language. From this list, 
derive one valid particular ordering of letters in this language.
 * 
 * Question Source: http://www.careercup.com/question?id=5715650070708224
 * 											
 * 
 * 
 * 									OR
 * 
 * 
 * 	Given a function 

	getRandomTripplet() 

	which returns a random triplet of letters from a string. You don't
	know the string using calls to this function you have to correctly guess the string. 
	The length of the string is also given. 

	Lets say the string is helloworld the function getRandomTriplet will return things like 

	hlo 
	hew 
	wld 
	owo 

	the function maintains the relative order of the letters. so it will never return

	ohl since h is before o in the string. 
	owe since w is after e 

	The string is not known you are only given length of the string.
	
	Question and Answer Source: http://www.careercup.com/question?id=5678056593162240
	
	
	/************************NOTE: BOTH QUESTIONS ARE THE SAME***********************************/
	
 /*
  *  Answer Source: http://www.geeksforgeeks.org/given-sorted-dictionary-find-precedence-characters/
 * 
 * 
 * Algorithm:
 * The idea is to create a graph of characters and then find topological sorting of the created graph. 
 * Following are the detailed steps.

1) Create a graph g with number of vertices equal to the size of alphabet in the given alien language. 
For example, if the alphabet size is 5, then there can be 5 characters in words. Initially there are no 
edges in graph.

2) Do following for every pair of adjacent words in given sorted array.
   a) Let the current pair of words be word1 and word2. One by one compare characters of both words and 
	  find the first mismatching characters.
   b) Create an edge in g from mismatching character of word1 to that of word2.

3) Print topological sorting of the above created graph.


 * 
 * 
 */

package TopologicalSort;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;


public class NewLanguage_BEST_SOLUTION {
	//Driver program to test above functions
	public static void main(String[] args) {
	 
	 // Solution of Question: Derive the sequence of characters from random triplet function
	 String[] words1 = {"caa", "aaa", "aab"};
	 Graph.printOrder(words1, 3);             // NOTE: Here 3 = totalNumberOfCharacters in the new language 
	 
	 // Solution of Question: Derive New Language from sorted list of words
	 String[] words2 = {"battle", "bare", "barffdfsdf", "apple", "act", "do", "coap", "cool","copf"};
	 Graph.printOrder(words2, 26);
	 
	 // Check for 4 characters
	 String[] words3 = {"baa", "abcd", "abca", "cab", "cad"};
	 Graph.printOrder(words3, 4);
	 
	}
}
class Edge{
	int src;
	int dest;
	public Edge(int src, int dest){
		this.src = src;
		this.dest = dest;
	}
}
class Graph
{
    int V;    // No. of vertices
    List<Edge> adj;    // Pointer to an array containing adjacency lists
    
    public Graph(int V){  // Constructor
    	this.V = V;
    	this.adj = new ArrayList<Edge>();
    }

    public void addEdge(int v, int w){
    adj.add(new Edge(v,w)); // Add w to v’s list.
    }

//A recursive function used by topologicalSort
public void topologicalSortUtil(int v, boolean[] visited, Stack<Integer> stack)
{
 // Mark the current node as visited.
 visited[v] = true;

 // Recur for all the vertices adjacent to this vertex
 Iterator<Edge> itr = adj.iterator();
 while(itr.hasNext())
 {
 	Edge e = itr.next();
 	if(e.src==v){
     if (!visited[e.dest])
         topologicalSortUtil(e.dest, visited, stack);
 	}
 }
 // Push current vertex to stack which stores result
 stack.push(v);
}

//The function to do Topological Sort. It uses recursive topologicalSortUtil()
public void topologicalSort()
{
 Stack<Integer> stack = new Stack<Integer>();

 // Mark all the vertices as not visited
 boolean[] visited = new boolean[V];
 for (int i = 0; i < V; i++)
     visited[i] = false;

 // Call the recursive helper function to store Topological Sort
 // starting from all vertices one by one
 for (int i = 0; i < V; i++)
     if (visited[i] == false)
         topologicalSortUtil(i, visited, stack);

 // Print contents of stack
 while (stack.empty() == false)
 {
     System.out.print((char) ('a' + stack.peek())+" ");
     stack.pop();
 }
}

//This function finds and prints order of character from a sorted
//array of words. n is size of words[].  alpha is set of possible
//alphabets.
//For simplicity, this function is written in a way that only
//first 'alpha' characters can be there in words array.  For
//example if alpha is 7, then words[] should have only 'a', 'b',
//'c' 'd', 'e', 'f', 'g'
public static void printOrder(String words[], int totalCharacters)
{
 int n = words.length;
 // Create a graph with 'totalCharacters' vertices
 Graph g=new Graph(totalCharacters);

 // Process all adjacent pairs of words and create a graph
 for (int i = 0; i < n-1; i++)
 {
     // Take the current two words and find the first mismatching
     // character
     String word1 = words[i], word2 = words[i+1];
     for (int j = 0; j < Math.min(word1.length(), word2.length()); j++)
     {
         // If we find a mismatching character, then add an edge
         // from character of word1 to that of word2
         if (word1.charAt(j) != word2.charAt(j))
         {
             g.addEdge(word1.charAt(j)-'a', word2.charAt(j)-'a');
             break;
         }
     }
 }

 // Print topological sort of the above created graph
 g.topologicalSort();
 System.out.println();
}

}
/*
Analysis:

n = total number of words
totalCharacters = Average length of each word from the list of words

Time Complexity: The first step to create a graph takes O(n + totalCharacters) time where n is number 
of given words and totalCharacters is average length of each word from the list of words. 
The second step is also topological sorting. 
Note that there would be alpha vertices and at-most (n-1) edges in the graph. 
The time complexity of topological sorting is O(V+E) which is O(n + totalCharacters) here. So overall time complexity 
is O(n + totalCharacters) + O(n + totalCharacters) which is O(n + totalCharacters).

Space Complexity = O(|V|+|E|)
*/