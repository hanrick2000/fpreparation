/*
Question:
	Given a function 

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
	
	NOTE:
	If the string can contain duplicate letters, as @CT replies, we can never deduct the original string 
	by random triplet. 
Considering string S = "aaaabaaa", the triplet will always be one of the four types: "aab", "aba", "baa", "aaa". 

With these four type of triplets we cannot know the real position of 'b' in S, so S will never be deducted. 

If there is an extra condition that S does not contain duplicate letters. We can solve it with graph, for a 
triplet "abc", add a->b, b->c, a->c into the graph. 

(Assume the length of S is N) 
During constructing the graph, the node whose out-degree first reaches N-1 is the first letter of S, 
then find the node whose out-degree reaches N-2 first to find the second letter, etc..
	
	
	VERY IMP: SAME AS TOPOLOGICAL SORT OF NEW LANGUAGE QUESTION
*/
package TopologicalSort;

public class GuessTheStringFromRandomTriplets {
	
}
