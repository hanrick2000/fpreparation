package revision;

import java.util.Arrays;
class Multiplication{
    public static void main(String args[]){
        int[] a = new int[]{2,3,1,4};
        System.out.println("Multiplication Result: "+multiplication(a));
    
    }
    public static String multiplication(int[] a){
        int[] forward = new int[a.length];
        int[] backward = new int[a.length];
        
        forward[0]=1;
        for(int i=1;i<forward.length;i++)
            forward[i] = forward[i-1]*a[i-1];
        
        backward[a.length-1]=1;
        for(int i=a.length-2;i>=0;i--)
            backward[i]=backward[i+1]*a[i+1];
            
        int[] solution = new int[a.length];
        for(int i=0;i<a.length;i++)
            solution[i] = forward[i]*backward[i];
            
        return Arrays.toString(solution);
    }
}
/*
Analysis: Time Complexity = O(n)
Space Complexity = O(n)

*/