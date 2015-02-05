package revision;


/* Algorithm:
1. Declare a HashMap<Ineteger,Integer>
2. If a[start]==a[end]
        check whether the key exists, if yes
        Insert (count+end-start+1) into the HashMap
        if no,
        Insert (end-start+1) into the HashMap
3. Recursively call start to  (start+end)/2
   Recursively call (start+end)/2+1 to end
*/
import java.util.HashMap;
class CountDuplicateElementsInSortedArray{
static HashMap<Integer,Integer> map = new HashMap<Integer,Integer>();

public static void main(String[] args){
    int[] a = new int[]{2,2,2,2,5,5,6,6,8,8,9,9,9};
    calculate(a,0,a.length-1);
    System.out.println(map);
}
public static void calculate(int[] a,int start,int end){
    
    if(a[start]==a[end]){
        if(!map.containsKey(a[start])){
            map.put(a[start],(end-start+1));
            
        }
        else{
            int count = map.get(a[start]);
            map.put(a[start],(count+(end-start)+1));
        }
    
    }
    else{
        calculate(a,start,(start+end)/2);
        calculate(a,(start+end)/2+1,end);
    }    

}

}