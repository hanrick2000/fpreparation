/*
Question: Determine the 10 most frequent words given a terabyte of strings.

Question Source: http://www.careercup.com/question?id=14548838
	
Answer Source: http://www.glassdoor.com/Interview/Determine-the-10-most-frequent-words-given-a-terabyte-of-strings-QTN_242991.htm
*/

package MostFreqWordsInTerabyteOfStrings;

public class MostFreqWordsInTerabyteOfStrings {

}
/*
Method I: 
1. External Merge Sort the 1TB file (External Sorting -> http://en.wikipedia.org/wiki/External_sorting)

[External Merge Sort in Detail:

a. Read 100 MB of the data in main memory and sort by some conventional method, like quicksort.

b. Write the sorted data to disk.

c. Repeat steps 1 and 2 until all of the data is in sorted 100 MB chunks (there are 900MB / 100MB = 9 chunks), 
which now need to be merged into one single output file.

d. Read the first 10 MB (= 100MB / (9 chunks + 1)) of each sorted chunk into input buffers in main memory and 
allocate the remaining 10 MB for an output buffer. (In practice, it might provide better performance to make
the output buffer larger and the input buffers slightly smaller.)

e. Perform a 9-way merge and store the result in the output buffer. Whenever the output buffer fills, write it 
to the final sorted file and empty it. Whenever any of the 9 input buffers empties, fill it with the next 
10 MB of its associated 100 MB sorted chunk until no more data from the chunk is available. This is the 
key step that makes external merge sort work externally -- because the merge algorithm only makes one pass 
sequentially through each of the chunks, each chunk does not have to be loaded completely; rather, sequential
parts of the chunk can be loaded as needed.

]

2. Replace each word as pair<count,word> e.g. "1025,the"
3. now use min-heap of size 10 (top is the item with lowest count).
when inserting a new pair, if heap.top().count < pair.count(), pop heap, push this pair.
finally pop and print the heap

Method II: MapReduce

Check out this link -> http://www.geeksforgeeks.org/find-the-k-most-frequent-words-from-a-file/
NOTE: But for the above mentioned link, the condition is that ALL THE WORDS CAN BE KEPT IN MAIN MEMORY ALL AT ONCE

*/