/*
 * ANSWER Source: http://courses.cs.vt.edu/~cs5114/spring2010/notes.pdf. USE Ctrl+F and search for 'Celebrity' string
 * 
Question: Given a set of n people, find the celebrity. 
Celebrity is a person who: 
1. Knows only himself and no one else 
2. Every one else knows this person 
Devise a O(n) algorithm to find the solution.

* QUESTION Source: http://www.careercup.com/question?id=5090815091146752
                 http://www.glassdoor.com/Interview/Given-a-set-of-people-one-of-them-is-a-celebrity-You-have-a-2D-array-which-describes-which-people-know-each-other-that-i-QTN_541.htm
 
* ANSWER Source: http://courses.cs.vt.edu/~cs5114/spring2010/notes.pdf   . USE Ctrl+F and search for 'Celebrity' string
  
Celebrity Problem
In a group of n people, a celebrity is somebody whom everybody knows, but who knows no one else.

Problem: 
1. If we can ask questions of the form “does person i know person j?” 
2. How many questions do we need to find a celebrity, if one exists?
3. How should we structure the information?

Celebrity Problem (cont)
Formulate as an n × n boolean matrix M.
Mij = 1 iff i knows j.
     Example:   1 0 0 1 0
				1 1 1 1 1
				1 0 1 1 1
				0 0 0 1 0
				1 1 1 1 1
VERY IMP STATEMENT FOR FORMULATION OF ALGORITHM: A CELEBRITY HAS ALL 0’S IN HIS ROW AND ALL 1’S IN HIS COLUMN.
THERE CAN BE AT MOST ONE CELEBRITY.(i.e. EITHER 0 OR 1 CELEBRITY CAN BE PRESENT IN ADJ. MATRIX)
THERE CANNOT BE 2 OR MORE CELEBRITIES.

Clearly, O(n^2) questions suffice. Can we do better?
 * 
 *Efficient Celebrity Algorithm
Appeal to induction:
1. If we have an n × n matrix, how can we reduce it to an (n − 1) × (n − 1) matrix?
2. What are ways to select the n’th person?

Efficient Celebrity Algorithm (cont)
1. ELIMINATE ONE PERSON IF HE IS A NON-CELEBRITY.
2. STRIKE ONE ROW AND ONE COLUMN.
                1 0 0 1 0
				1 1 1 1 1
				1 0 1 1 1
				0 0 0 1 0
				1 1 1 1 1
DOES 1 KNOW 3? NO. 3 IS A NON-CELEBRITY.
DOES 2 KNOW 5? YES. 2 IS A NON-CELEBRITY.
OBSERVATION: EACH QUESTION ELIMINATES ONE NON-CELEBRITY.				

CELEBRITY ALGORITHM

Efficient Celebrity Algorithm
1. ELIMINATE ONE PERSON IF HE IS A NON-CELEBRITY.
2. STRIKE ONE ROW AND ONE COLUMN.

Algorithm:
1 Ask n − 1 questions to eliminate n − 1 non-celebrities.
This leaves one candidate who might be a celebrity.
2 Ask 2(n − 1) questions to check candidate.
Analysis:
Θ(n) questions are asked.

Example:
                1 0 0 1 0
				1 1 1 1 1
				1 0 1 1 1
				0 0 0 1 0
				1 1 1 1 1
Does 1 know 2? No. Eliminate 2
Does 1 know 3? No. Eliminate 3
Does 1 know 4? Yes. Eliminate 1
Does 4 know 5? No. Eliminate 5
				
 */

package Celebrity;

public class FindCelebrity {
	static int knows[][];      // global variable

	
	/*
CELEBRITY ALGORITHM
Algorithm:
1 Ask n − 1 questions to eliminate n − 1 non-celebrities.
This leaves one candidate who might be a celebrity.
2 Ask 2(n − 1) questions to check candidate.
Analysis:
Θ(n) questions are asked.

Example:
                1 0 0 1 0
				1 1 1 1 1
				1 0 1 1 1
				0 0 0 1 0
				1 1 1 1 1
Does 1 know 2? No. Eliminate 2
Does 1 know 3? No. Eliminate 3
Does 1 know 4? Yes. Eliminate 1
Does 4 know 5? No. Eliminate 5
				
	 */
	public static void main(String[] args) {
		knows = new int[][] { 
				{ 1, 0, 1, 1, 1 }, 
				{ 1, 1, 1, 1, 1 },
				{ 0, 0, 1, 0, 0 }, 
				{ 0, 0, 1, 1, 1 }, 
				{ 0, 0, 1, 1, 1 } };
		
		int totalPeople = knows.length;

		System.out.println(recursiveFindCelebrity(0,totalPeople));
		System.out.println(iterativeFindCelebrity(totalPeople));
	}

/*
Efficient Celebrity Algorithm
1. ELIMINATE ONE PERSON IF HE IS A NON-CELEBRITY.
2. STRIKE ONE ROW AND ONE COLUMN.
 */
	public static int iterativeFindCelebrity(int N) {
		int celebrity = 0;                            // Assume that the first index is a celebrity
		for (int i = 1;  i < N; i++) {
			if (knows(celebrity, i)) {
				celebrity = i;
			}
			else if (knows(i, celebrity)) {
				// No need to do anything here.
			}
			else if (i + 1 < N) {
				// None of them are celebrity, lets select a new one.
				celebrity = i + 1;
				i++; // Increment the counter as none of these two are celebrity.
			}
		}
		boolean noCelebrity = false;
		// We need to confirm if the celebrity is correct or not.
		for (int i = 0; i < N; i++) {
			if (!knows(i, celebrity) || (i != celebrity && knows(celebrity, i))) {
				noCelebrity = true;
			}
		}
		if (noCelebrity) {
			return -1;
		}
		return celebrity;
	}
	/*
	Analysis:
		Time Complexity:
			(n) + (n) = 2(n)
			Hence the time complexity ASYMPTOTICALLY is = O(n)
		Space Complexity = O(1)
	*/
	public static int recursiveFindCelebrity(int celebrity, int totalPeople) {
		if (celebrity >= totalPeople) {
			return -1;
		}

		// Everyone including celebrity knows themselves.
		// Hence even if knows[i][i] == 0 (i.e. a person who does not know himself)[which is an exception case]
		// then also we should move forward
		if (!knows(celebrity, celebrity)) {
			return recursiveFindCelebrity(celebrity + 1, totalPeople);
		}

		for (int newCandidate = celebrity + 1; newCandidate < totalPeople; newCandidate++) {

			if (knows(celebrity, newCandidate)) {  // Does 1 know 4? Yes. Eliminate 1. That is eliminate candidate
				return recursiveFindCelebrity(newCandidate,totalPeople); // newCandidate now becomes candidate. Check whether newCandidate is a celebrity
			}
			else { }// Does 1 know 4? No. Eliminate 4. Check for other newCandidates.
			
		}
		return checkCandidate(celebrity,totalPeople);
	}

	private static int checkCandidate(int candidate, int totalPeople) {
		int count=0;
		for(int i=0;i<totalPeople;i++){  //Ask 2(n − 1) questions to check candidate.
			if(i!=candidate && knows(i, candidate) && !knows(candidate,i)) // check if all rows are 0 and the columns are 1
				count++;
		}
		if(count==(totalPeople-1))
			return candidate;
		else
			return -1;
	}

	private static boolean knows(int i, int j) {
		return (knows[i][j] == 1);  // returns true or false
	}
	
}
/*
Analysis:
	Time Complexity:
		(n) + (n) = 2(n)
		Hence the time complexity ASYMPTOTICALLY is = O(n)
	Space Complexity = O(1)
*/