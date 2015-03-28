/*
Question: There's a new language which uses the Latin alphabet. However, you don't know the order among letters. 

It could be: 
a b c d ... 

As it could also be: 
b e z a m i ... 

You receive a list of words lexicographically sorted by the rules of this new language. From this list, 
derive one valid particular ordering of letters in this language.
 * 
 * Question Source: http://www.careercup.com/question?id=5715650070708224
 * 
 * Answer Source: http://siyang2notleetcode.blogspot.com/2015/02/derive-order-for-new-language.html
 * 
 * Algorithm:
 * Complexity of the algorithm is O (nk) k is the average length of each word and n = number of words
 * Starting index = 0, every first find a letter before the same [begin, end] section, and then call 
 * the subroutine setOrder (Node [] order, String [] strArray, int begin, int end, int index) to connecting 
 * the corresponding node, after the completion of this part to get a DAG, DAG order to run on the 
 * resulting topological sorting order is a new language.
 * 
 */

package TopologicalSort;

	import java.util.List;
	import java.util.ArrayList;
	import java.util.Queue;
	import java.util.LinkedList;

	public class NewLanguage{
	    class Node{
	        char val;
	        int parent;
	        List<Node> next;
	        public Node(char c){
	            val = c;
	            parent = 0;
	            next = new ArrayList<Node>();
	        }
	    }

	    public static void main(String args[]){
	    	NewLanguage s = new NewLanguage();
	        String[] strArray = {"battle", "bare", "barffdfsdf", "apple", "act", "do", "coap", "cool","copf"};
	        char[] result=s.deriveOrder(strArray);
	        System.out.println(String.valueOf(result));
	    }

	    public char[] deriveOrder(String[] strArray){
	        char[] result = new char[26];     
	        
	        // Create 26 nodes from a to z. Set node.val = character from a to z
	        Node[] order = new Node[26];              
	        for(int i = 0;i < 26;i++)
	            order[i] = new Node((char)(i+'a'));
	        
	        char preParent = '0';                   // set previous parent as null(null has ASCII value of '0')
	        char curParent;
	        int index = 0;
	        
	        // Check whether there are more than 0 words
	        boolean hasNext= strArray.length!=0;
	       
	        while(hasNext){
	            int begin = 0, end = 0;
	            hasNext = false;
	            // find begin word
	            while(end < strArray.length){
	                if(index < strArray[end].length()){
	                    preParent = index==0?'0':strArray[end].charAt(index-1);
	                    hasNext = true;
	                    break;
	                }
	                end++;
	            }
	            
	            // find end word
	            begin = end;
	            while(++end < strArray.length){
	                if(index < strArray[end].length()){
	                    curParent = index==0?'0':strArray[end].charAt(index-1);
	                    if(curParent!=preParent){
	                        setOrder(order,strArray,begin,end,index);
	                        begin = end;
	                        preParent = index==0?'0':strArray[begin].charAt(index-1);
	                    }
	                }
	            }
	            if(strArray[Math.min(end-1,strArray.length-1)].length() > index)
	                setOrder(order,strArray,begin,end,index);
	            index++;
	        }
	       
	        // for(int i = 0;i < 26;i++){
	        //     System.out.println((char)(i+'a') + " has "+order[i].parent+ " fathers with children:");
	        //     for(int j = 0;j < order[i].next.size();j++)
	        //         System.out.print((char)(order[i].next.get(j).val)+" ");
	        //     System.out.println();
	        // }

	        // topological sort
	        Queue<Node> queue = new LinkedList<Node>();
	        for(int i = 0;i < 26;i++)
	            if (order[i].parent==0)
	                queue.add(order[i]);
	        index = 0;
	        while(!queue.isEmpty()){
	            Node node = queue.poll();     // remove head
	            result[index++] = node.val;
	            for(int i = 0;i < node.next.size();i++){
	                node.next.get(i).parent--;
	                if(node.next.get(i).parent==0)
	                    queue.add(node.next.get(i));
	            }
	        }

	        // for(int i = 0;i < 26;i++)
	        //     System.out.print(result[i] + " ");

	        return result;
	    }

	    private void setOrder(Node[] order, String[] strArray, int begin, int end, int index){
	        char pre = strArray[begin].charAt(index), cur;
	        boolean newStart = true;
	        for(int i = begin;i < end && i < strArray.length;i++){
	            if(index < strArray[i].length()){
	                if(newStart){
	                    pre = strArray[i].charAt(index);
	                    newStart = false;
	                }else{
	                    cur = strArray[i].charAt(index);
	                    if(pre!=cur){
	                        order[toInt(pre)].next.add(order[toInt(cur)]);
	                        order[toInt(cur)].parent++;
	                        pre = cur;
	                    }
	                }
	            }
	        }
	    }

	    private int toInt(char c){
	        return (int)(c-'a');
	    }
	    /*
	     * Analysis:
	     * Time Complexity = O(nk) where k = average length of each word, n = number of words
	     */
	} 

