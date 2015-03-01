/*
Question: You are given an input form such as the following 
(1, (2, 3), (4, (5, 6), 7)) 
Each element is either a number or a list (whose elements may also be numbers or other lists). 
Output the numbers as they appear, stripped down into a single list. 
E.G. (1, 2, 3, 4, 5, 6, 7) 

(Complication - how does your code handle the case of ((((5)))) vs just ( 5 ) ? )

Question Source: http://www.careercup.com/question?id=14967793

Answer Source: http://www.careercup.com/question?id=17727664

IMP Sources: 
	http://www.careercup.com/question?id=17727664
	https://github.com/kowshik/big-o/blob/master/java/src/collections/DeepIterator.java
	https://gist.github.com/daviddengcn/4970584
	http://codereview.stackexchange.com/questions/32827/flatten-iterator-for-nested-list
	http://stackoverflow.com/questions/12625038/nested-iterating-through-list-followed-by-an-eventual-deletion
*/		

package IteratorForNestedList;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


