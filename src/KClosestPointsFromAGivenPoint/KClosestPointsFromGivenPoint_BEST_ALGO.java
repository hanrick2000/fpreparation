
/*
 * Question: Find k closest points from a given point
 * 
 * Question Source: http://www.careercup.com/question?id=15974664
 * 					http://www.careercup.com/question?id=5309537623998464
 * 
 * Answer Source: http://www.careercup.com/question?id=15974664
 * 
 * BEST EXPLANATION: http://stackoverflow.com/questions/9202315/algorithm-to-find-100-closest-stars-to-the-origin
 * http://www.careercup.com/question?id=15974664
 * 
 * When to use heap and when not to use heap
 * 
I. When to use heap:
 * One would need a heap, if 
1) points are not yet loaded, and you receive them one-by-one (i.e. it's not a set of points, but a stream) 
2) or maybe you are out of memory, and you have to preserve the initial array (quickselect-based algoritm 
would modify it) - then you can use heap with O(k) memory instead of O(n) copy of array

II. When not to use heap
In fact we don't need a heap or a binary search tree here, because all the array is already loaded into memory.
So you can use some modification of Quick-Select algorithm, to achieve O(n) speed and O(1) extra-memory 
(because tail recursion can be effectively eliminated) in case you don't need your initial array later on 
*/

package KClosestPointsFromAGivenPoint;

public class KClosestPointsFromGivenPoint_BEST_ALGO {
	
}
