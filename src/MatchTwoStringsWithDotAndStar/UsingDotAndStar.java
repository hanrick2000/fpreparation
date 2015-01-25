package MatchTwoStringsWithDotAndStar;

public class UsingDotAndStar {
	public static void main(String[] args) {
		System.out.println(match("Facebook","F.c.bo*k"));
	}
	static boolean match(String input, String match){
        return matchExp(input.toLowerCase(),match.toLowerCase(),0,0);
    }

    static boolean  matchExp(String input, String match, int i, int j){


        if(i==input.length() && j==match.length()) return true;
        if(i==input.length()) return false;
        if(j==match.length()) return false;

        if(match.charAt(j)=='*'){
            boolean matchVal = false;
            for(int k  = i;k<input.length();k++){
                matchVal |= matchExp(input,match,k,j+1);
            }
            return matchVal;
        }

        return (match.charAt(j) == input.charAt(i) || match.charAt(j) == '.') && matchExp(input, match, i + 1, j + 1);

    }
	
}
