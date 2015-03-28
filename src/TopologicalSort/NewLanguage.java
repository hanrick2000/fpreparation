/*
Question: There's a new language which uses the latin alphabet. However, you don't know the order among letters. 

It could be: 
a b c d ... 

as it could also be: 

b e z a m i ... 

You receive a list of words lexicographically sorted by the rules of this new language. From this list, 
derive one valid particular ordering of letters in this language.
 * 
 * Question Source: http://www.careercup.com/question?id=5715650070708224
 * 
 * Answer Source: http://siyang2notleetcode.blogspot.com/2015/02/derive-order-for-new-language.html
 */

package TopologicalSort;

	import java.util.List;
	import java.util.ArrayList;
	import java.util.Queue;
	import java.util.LinkedList;

	public class NewLanguage{
	    class Node{
	        char val;
	        int father;
	        List<Node> next;
	        Node(char c){
	            val = c;
	            father = 0;
	            next = new ArrayList<Node>();
	        }
	    }

	    public static void main(String args[]){
	    	NewLanguage s = new NewLanguage();
	        String[] strs = {"battle", "bare", "barffdfsdf", "apple", "act", "do", "coap", "cool","copf"};
	        char[] result=s.deriveOrder(strs);
	        System.out.println(String.valueOf(result));
	    }

	    public char[] deriveOrder(String[] strs){
	        char[] rlst = new char[26];                 // Assumption: All input strings are in lower case alphabets
	        Node[] order = new Node[26];
	        for(int i = 0;i < 26;i++)
	            order[i] = new Node((char)(i+'a'));
	        char preParent = '0', curParent;
	        int index = 0;
	        boolean hasNext= strs.length!=0;
	        while(hasNext){
	            int begin = 0, end = 0;
	            hasNext = false;
	            // find begin word
	            while(end < strs.length){
	                if(index < strs[end].length()){
	                    preParent = index==0?'0':strs[end].charAt(index-1);
	                    hasNext = true;
	                    break;
	                }
	                end++;
	            }
	            // find end word
	            begin = end;
	            while(++end < strs.length){
	                if(index < strs[end].length()){
	                    curParent = index==0?'0':strs[end].charAt(index-1);
	                    if(curParent!=preParent){
	                        setOrder(order,strs,begin,end,index);
	                        begin = end;
	                        preParent = index==0?'0':strs[begin].charAt(index-1);
	                    }
	                }
	            }
	            if(strs[Math.min(end-1,strs.length-1)].length() > index)
	                setOrder(order,strs,begin,end,index);
	            index++;
	        }
	       
	        // for(int i = 0;i < 26;i++){
	        //     System.out.println((char)(i+'a') + " has "+order[i].father+ " fathers with children:");
	        //     for(int j = 0;j < order[i].next.size();j++)
	        //         System.out.print((char)(order[i].next.get(j).val)+" ");
	        //     System.out.println();
	        // }

	        // topological sort
	        Queue<Node> queue = new LinkedList<Node>();
	        for(int i = 0;i < 26;i++)
	            if (order[i].father==0)
	                queue.add(order[i]);
	        index = 0;
	        while(!queue.isEmpty()){
	            Node node = queue.poll();
	            rlst[index++] = node.val;
	            for(int i = 0;i < node.next.size();i++){
	                node.next.get(i).father--;
	                if(node.next.get(i).father==0)
	                    queue.add(node.next.get(i));
	            }
	        }

	        // for(int i = 0;i < 26;i++)
	        //     System.out.print(rlst[i] + " ");

	        return rlst;
	    }

	    private void setOrder(Node[] order, String[] strs, int begin, int end, int index){
	        char pre = strs[begin].charAt(index), cur;
	        boolean newStart = true;
	        for(int i = begin;i < end && i < strs.length;i++){
	            if(index < strs[i].length()){
	                if(newStart){
	                    pre = strs[i].charAt(index);
	                    newStart = false;
	                }else{
	                    cur = strs[i].charAt(index);
	                    if(pre!=cur){
	                        order[toInt(pre)].next.add(order[toInt(cur)]);
	                        order[toInt(cur)].father++;
	                        pre = cur;
	                    }
	                }
	            }
	        }
	    }

	    private int toInt(char c){
	        return (int)(c-'a');
	    }

	} 

