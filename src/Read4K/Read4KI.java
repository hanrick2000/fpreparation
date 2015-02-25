/*
 * Question:
	Given API: 
		int Read4096(char* buf); 
		It reads data from a file and records the position so that the next time when it is called it read the next 4k chars (or the rest of the file, whichever is smaller) from the file. 
		The return is the number of chars read. 

		Todo: Use above API to Implement API 
		"int Read(char* buf, int n)" which reads any number of chars from the file.

Question Source: http://www.careercup.com/question?id=14424684

Answer Source: http://shanjiaxin.blogspot.com/2015/01/read-n-characters-given-read4-leetcode.html

Imp Sources: http://shanjiaxin.blogspot.com/2015/01/read-n-characters-given-read4-leetcode.html  --> BEST ANSWER SO FAR
	https://hellosmallworld123.wordpress.com/2014/09/23/given-read4k-implement-readanysize/
	*/	


package Read4K;

/* 
 * DESCRIPTION:

Read N Characters Given Read4 @LeetCode
The API: int read4(char *buf) reads 4 characters at a time from a file.
The return value is the actual number of characters read. For example, it returns 3 if there is only 3 characters 
left in the file.
By using the read4 API, implement the function int read(char *buf, int n) that reads n characters from the file.
Note:
The read function will only be called once for each test case.

*/




public class Read4KI {

/**
* @param destBuffer  Destination buffer
* @param    n        Maximum number of characters to read
* @return            The number of characters read
*/
	public int read(char[] destBuffer, int n) {
		char[] sourceBuffer = new char[4];
		boolean eof = false;
		int total = 0;    // total bytes read
		
		while (!eof && total < n) {
			int temp = read4(sourceBuffer);
			
			if (temp < 4) {
				eof = true;
			}
			
			int bytes = Math.min(n - total, temp);   // this handles the case when the file is not empty but all the n characters are read
			System.arraycopy(sourceBuffer, 0, destBuffer, total, bytes); //arraycopy(Object src, int srcPos, Object dest, int destPos, int length)
			total += bytes;
		}// end of while
		
		return total;
	}
	
	// API funciton
	public int read4(char[] buf) {
		return 0;
	}
}