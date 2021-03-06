/*
Question: You are given a 2D array of characters and a character pattern. WAP to find if 
pattern is present in 2D array. Pattern can be in any way (all 8 neighbors to be considered)
but you can’t use same character twice while matching. Return 1 if match is found, 0 if not. 

eg : 

Matrix 
{'A','C','P','R','C'}, 
{'X','S','O','P','C'}, 
{'V','O','V','N','I'}, 
{'W','G','F','M','N'}, 
{'Q','A','T','I','T'} 

Source: http://www.careercup.com/question?id=13126665
		http://www.careercup.com/question?id=5890898499993600

And pattern is MICROSOFT. 
*/
package Matrix.WordSearch;

public class UsingPatternMatchAlgorithm {
public static void main(String[] args) {
	char[][] matrix = new char[][]{{'A','C','P','R','C'}, 
								   {'X','S','O','P','C'}, 
								   {'V','O','V','N','I'}, 
								   {'W','G','F','M','N'}, 
								   {'Q','A','T','I','T'}};
	System.out.println(patternMatch(matrix, matrix.length, matrix[0].length, "MICROSOFT"));
}
public static boolean patternMatch(char[][] matrix,int rowLength,int columnLength,String pattern){
	boolean found = false;
	boolean[][] visited = new boolean[rowLength][columnLength];  // this will initialize visited matrix to false
		
	outerloop:               // label the outer for loop as outerloop:
	for(int i=0;i<rowLength;i++)
		for(int j=0;j<columnLength;j++){
			if(findPattern(matrix, i, j, pattern, visited)){
				found = true;
				break outerloop;
			}
		}
	
	return found;
}
	public static boolean findPattern(char[][] matrix, int currentRow, int currentColumn,String pattern, boolean[][] visited){

	/*
	 FOUR conditions we have to check before making the current position as VISITED
	  (TR: 0 O F V)    -> zero zero F V
	 
	 1. pattern length is 0                                    ----> 0
	 2. search is OUT of bounds                                ----> O
	 3. FIRST CHARACTER MATCH with current position of matrix  ----> F
	 4. current position is already VISITED then return false  ----> V
	*/ 
	if(pattern.length()==0)
		return true;
	
	if(currentRow<0||currentRow>(matrix.length-1)||currentColumn<0||currentColumn>(matrix[0].length-1))
		return false;
	
	if(matrix[currentRow][currentColumn]!=pattern.charAt(0))
		return false;
	
	if(visited[currentRow][currentColumn]==true)
		return false;
	
	// If we reach here, that means that the current position in the matrix MATCHES with the 0th position of the pattern
	// i.e. matrix[currentRow][currentColumn]==pattern.charAt(0) is true here since we 
	// already checked previously that if this is not true then return false
	
	
	
	visited[currentRow][currentColumn]=true;
	// move in all 8 directions
	for(int Nrow = currentRow-1;Nrow<=currentRow+1;Nrow++){
		for(int Ncol=currentColumn-1;Ncol<=currentColumn+1;Ncol++){
			if(!(Nrow==currentRow && Ncol==currentColumn) && (findPattern(matrix, Nrow, Ncol, pattern.substring(1), visited)))
				return true;
		}
	}
	
	
	visited[currentRow][currentColumn]=false;  // for backtracking, make this again as false
	

	return false; // return this false
	}
}
/*
Analysis: 
Time Complexity = O(m*n) since each element of the matrix is VISITED. 
There cannot be better solution than BRUTE FORCE method.
Space Complexity = O(m*n) used by visited matrix
*/ 