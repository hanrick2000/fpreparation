package divideandconquer;

import java.util.ArrayList;
import java.util.Iterator;

public class NQueens {

    public static ArrayList<String[]> solveNQueens(int n) {
        ArrayList<String[]> res = new ArrayList<String[]>();
        int[] loc = new int[n];
        dfs(res,loc,0,n);
        return res;
    }
    
    public static void dfs(ArrayList<String[]> res, int[] loc, int cur, int n){
        if(cur==n) 
            printboard(res,loc,n);
        else{
            for(int i=0;i<n;i++){
                loc[cur] = i;
                if(isValid(loc,cur))
                    dfs(res,loc,cur+1,n);
            }
        }
    }
    
    public static boolean isValid(int[] loc, int cur){
        for(int i=0;i<cur;i++){
            if(loc[i]==loc[cur]||Math.abs(loc[i]-loc[cur])==(cur-i))
                return false;
        }
        return true;
    }
    
    public static void printboard(ArrayList<String[]> res, int[] loc, int n){
        String[] ans = new String[n];
        for(int i=0;i<n;i++){
            String row = new String();
            for(int j=0;j<n;j++){
                if(j==loc[i]) row += "Q";
                else row += ".";
            }
            ans[i] = row;
        }
        res.add(ans);
    }
    public static void main(String[] args) {
		ArrayList<String[]> list=solveNQueens(4);
		Iterator<String[]> iter = list.iterator();
		int i=1;
		while(iter.hasNext()){
			String[] sArray=iter.next();
			System.out.println("Solution: "+i);
			for(String s: sArray)
				System.out.println(s+" ");
			System.out.println();
			i++;
		}
	}
}