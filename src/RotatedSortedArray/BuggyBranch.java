/*
Question:
	You are at latest version of committed code.  assume one branch of code. CODE VERSION IS IN SORTED ORDER. 
	It is corrupted with bug. You have fun isBug(VerNumber) which returns True or False.

	Find the version in which bug was introduced?
	
Question Source: http://www.careercup.com/question?id=5156825198493696

Explanation:
	1. We need to use modified binary search (since given that CODE VERSIONS ARE IN SORTED ORDER)
	2. Since VERSIONS bug introduced in VERSIONS previous revision version of code can mutate to the rest of the revisions 
	   made after that, hence we need to find the first occurrence of the bug in the SORTED array of CODE VERSIONS

	
Example:
1. Let's assume that bugs are introduced linearly, such that if we introduce VERSIONS bug in rev x,
it will be contained in all revisions following x.

2. As such, if VERSIONS bug is not found in the middle, we can eliminate the revisions [start, middle],
and assume that the buggy revision lies between (middle, end], making binary search VERSIONS prime choice
to solve this problem.

*/

package RotatedSortedArray;

public class BuggyBranch {
	public static void main(String[] args) {
		Branch[] VERSIONS = new Branch[10];            // first 8 and not buggy
		int i=0;
		for(i=0;i<8;i++){
			VERSIONS[i] = new Branch();                // initialize the Branch
			VERSIONS[i].isBuggy=false;
		}
		while(i<VERSIONS.length){                      // last 2 are buggy
			VERSIONS[i] = new Branch();                // initialize the Branch
			VERSIONS[i].isBuggy=true;
			i++;
		}
		// print the version numbers
		for(int j=0;j<VERSIONS.length;j++)
			System.out.println("Branch "+j+" VERSION "+j+" -> Bug Status: "+VERSIONS[j].isBuggy);
		// print the buggy branch version number
		System.out.println("The bug is at branch version: "+usingModifiedBS(VERSIONS));
	}
	private static int usingModifiedBS(Branch[] VERSIONS) {
		
		if(VERSIONS==null || VERSIONS.length==0)
			return -1;
		
		int result = -1;                  // to store the result index
		int low = 0;
		int high = VERSIONS.length-1;
		int mid = 0;
		while(low<=high){
			
			mid = low+(high-low)/2;
			
			if(VERSIONS[mid].isBuggy){     // We found the buggy branch, now search for its first occurrence
				result = mid;              // store this index
				high=mid-1;                // search in left
			}
			
			else if(!VERSIONS[mid].isBuggy) // Not buggy branch which means [start, mid] is without bug SO search in right
				low=mid+1;
			
		} // end of while
		return result;
	}
	/*
	 * Analysis:
	 * Time Complexity = O(lgn) where n = length of array
	 * Space Complexity = O(1)
	 */
}

class Branch{
	boolean isBuggy;
}
