/*
 * 
 * IMP Links: 
http://www.careercup.com/question?id=14804692
http://www.careercup.com/question?id=3058
http://stackoverflow.com/questions/7153659/find-an-integer-not-among-four-billion-given-ones
http://www.quora.com/Given-a-file-containing-4-30-billion-32-bit-integers-how-can-we-find-a-number-which-has-appeared-at-least-twice
https://answers.yahoo.com/question/index?qid=20080508203418AAIV0jK
*/

package BillionIntegerSearch;

public class UsingBitMap {
	
	/*
	 * Parameters to be calculated from the INPUT
	 * (Source: http://www.careercup.com/question?id=3058)
	 * 
	 * 1. Number of distinct integers possible in JAVA = 2^(32) distinct integers possible in Java
	 * starting from -2147483648 to 2147483647. If we consider only unsigned integers then the total
	 * distinct integers that can be represented uniquely are 2^(32)=4294967296    (i.e. 4 billion integers)
	 * 
	 * 
	 * 2. So if enough memory is present we can initialize a BITMAP of size 4 BILLION BITS.
	 * Otherwise we can initialize a BITMAP of GIVEN MEMORY SIZE BITS
	 * (We use BITMAP because size of boolean variable is NOT 1 in Java. 
	 * Source: http://stackoverflow.com/questions/383551/what-is-the-size-of-a-boolean-variable-in-java)
	 * A BITMAP can only store value 1 or 0 and takes 1 BIT of Memory
	 * 
	 * 
	 * 
	 * 
	 * 		MY NOTES: i.   [Byte = 8 bits]
	 * 				  ii.  [Giga = billion = 10^9]
	 * 				  iii. [Mega = million = 10^6]
	 *      (My Notes Source: http://www.quora.com/Mathematics-How-many-zeros-does-a-million-and-a-billion-have)
	 * 
	 * 
	 * 3. GIVEN MEMORY calculations:
	 * (Source: http://www.careercup.com/question?id=3058)
	 * 
	 * 
	 * Question a. Given memory = 1GB 
	 * 					    = (10^9 * 8)  bits    [Giga = billion = 10^9] [Byte = 8 bits]
	 * 						= 8 billion bits of given memory
	 * 
	 * Since we are dealing with integers, the number of distinct integers can be 2^32, which is 4 billion.
	 *  
     * Since 1GB(8billion bits) memory is given, we can declare bit map array of size 4billion 
     * and initialize it to zero. Scan through the file. As and when you get an integer, 
     * set the corresponding bit map location bit to 1. If you encounter the same number again, 
     * check the bitmap's value is set. If it is set to 1, don't change. 
     * Once you finish reading the file, scan the bit map. If any bit map location is not set,
     * it is the number that is missing from the 4 billion integer list.
     * 
     * Question b. Given Memory = 10 MB
     * 						= (10 * 10^6 * 8) bits [Mega = million = 10^6] [Byte = 8 bits]
     * 						= 80 million bits of given memory
     * 
     * Since we are dealing with integers, the number of distinct integers can be 2^32, which is 4 billion.
     * 
     * To handle all the 4 billion integers, we need to process 10 MB memory 5 TIMES
     * Total steps = 4billion/80million = 5 
     * 
     * STEP 1: CHECK 1ST 80MILLION INTEGERS
     * Since 10MB(80 million bits) memory is given, we can declare bit map array of size 80 million and
     * initialize it to zero. Scan through the file. As and when you get an integer BETWEEN 1-80 million, 
     * set the bit to 1. If you encounter the same number again, check the bitmap's value is set. 
     * If it is set to 1, don't change. Once you finish reading the file, scan the bit map. 
     * If any bit is not set, it is the number that is missing from the 80million integer list. 
     * 
     * STEP 2: CHECK 2ND 80MILLION INTEGERS
     * Since 10MB(80 million bits) memory is given, we can declare bit map array of size 80 million and
     * initialize it to zero. Scan through the file. As and when you get an integer BETWEEN 1-80 million, 
     * set the bit to 1. If you encounter the same number again, check the bitmap's value is set. 
     * If it is set to 1, don't change. Once you finish reading the file, scan the bit map. 
     * If any bit is not set, it is the number that is missing from the 80million integer list.
     * 
     * STEP3: REPEAT ABOVE STEP UNTIL WE COVER THE COMPLETE INTEGER LIST OF 4 BILLION INTEGERS
     * Total steps = 4billion/80million = 5 
     * 
     * 
     * 
     * Question c.  Given Memory = x
     * 				Same logic of (b) is applicable to all memory constraints.
     * 
     * 
     * NOTE: The above program logic finds the missing integer/integers from the given 4 billion integers
     * The same program logic can be used to find the repeated integer/integers from the given 4 billion integers
     * 
	 */
	
	
}
