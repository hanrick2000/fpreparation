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
			if(findPattern(matrix, i, j, rowLength, columnLength, pattern, visited)){
				found = true;
				break outerloop;
			}
		}
	
	return found;
}
	public static boolean findPattern(char[][] matrix, int currentRow, int currentColumn,
			int rowLength, int columnLength, String pattern, boolean[][] visited){
	
	int[] rowDir =  new int[]{-1, -1, -1, 0, 1, 1, 1, 0};
	int[] columnDir = new int[]{1, 0, -1, -1, -1, 0, 1, 1};
	
	/*
	 FOUR conditions we have to check before making the current position as VISITED
	 1. check whether the pattern length is 0
	 2. check whether the search is out of bounds
	 3. check whether the first character of pattern matches with the current position of matrix
	 4. current position is already VISITED then return false
	*/ 
	if(pattern.length()==0)
		return true;
	
	if(currentRow<0||currentRow>(rowLength-1)||currentColumn<0||currentColumn>(columnLength-1))
		return false;
	
	if(matrix[currentRow][currentColumn]!=pattern.charAt(0)||visited[currentRow][currentColumn]==true)
		return false;
	
	// If we reach here, that means that the current position in the matrix MATCHES with the 0th position of the pattern
	// i.e. matrix[currentRow][currentColumn]==pattern.charAt(0) is true here since we 
	// already checked previously that if this is not true then return false
	
	visited[currentRow][currentColumn]=true;
	
	
	// move in all 8 directions
	for(int k=0;k<8;k++){
		if(findPattern(matrix, currentRow+rowDir[k], currentColumn+columnDir[k], rowLength, columnLength, pattern.substring(1), visited))
			return true;
	}
	
	visited[currentRow][currentColumn]=false; // for backtracking, make this again as false
	return visited[currentRow][currentColumn]; // return this false
	}
}
/*
Analysis: 
Time Complexity = O(m*n) since each element of the matrix is VISITED. 
There cannot be better solution than BRUTE FORCE method.
Space Complexity = O(m*n) used by visited matrix
*/ 