/*
Question : You have a dictionary(i.e is an array of words) and you have an array of strings. 

Write two functions 

1. Prepare the array of strings to be searched in the dictionary 
2. Check if the string contains all valid words or not.

Question Source: http://www.careercup.com/question?id=5152893422272512

Solution Source: http://codereview.stackexchange.com/questions/41630/trie-tree-form-in-java
*/

package Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Trie {

    private static final TrieNode[] EMPTYNODES = new TrieNode[0]; // Empty TrieNodeNode array of length = 0. USED FOR REPREENTING EMPTY CHILDRENS FOR A TRIENODE

    private static final class TrieNode implements Comparable<TrieNode> {    // VERY IMP: implements Comparable hence NATURAL ORDERING

        private final char character;
        private boolean isWord = false;
        private Map<Character, TrieNode> children = null;
        
        
        // --------------------- set and get NODE ----------------------
        
        public TrieNode(char ch) {  // using constructor we SET the character of the node
            character = ch;
        }

        public char getNodeChar() {    // using this method we GET the character of the node
            return character;
        }
        
        
        // --------------------- set and get CHILD ----------------------
        
        public TrieNode getOrSetChild(char ch) {  // set a child
            if (children == null) {
                children = new HashMap<>();
            }
            TrieNode kid = children.get(ch);
            if (kid == null) {
                kid = new TrieNode(ch);
                children.put(ch, kid);
            }
            return kid;
        }
        
        public TrieNode getChild(char ch) {           // get the child
            return children != null ? children.get(ch) : null;
        }

        
        // --------------------- set and get WORD ----------------------
        
        public void setWord() {                 // set word
            isWord = true;
        }
        
        public boolean isWord() {              // get word
            return isWord;
        }

        // ------------------------ get all the CHILDRENS ----------------------

        public TrieNode[] getChildNodes() {
            if (children == null) {
                return EMPTYNODES;
            }
            TrieNode[] result = children.values().toArray(new TrieNode[children.size()]);
            /*
             * Source: http://docs.oracle.com/javase/7/docs/api/java/util/Collection.html
             * toArray(T[] a)
Returns an array containing all of the elements in this collection; the runtime type of the returned array is that of the specified array as parameter.
             */
            
            Arrays.sort(result);
            return result;
        }
        
        // --------------------- Override Comparable method ---------------------
        @Override
        public int compareTo(TrieNode o) {
            // cheap way to sort alphabetically.
            return (int)character - o.character;
        }

    }



    private final TrieNode root;  // fix - make root final.
    private int size = 0; // how many words
    private int depth = 0; // longest word

    public Trie(){
        // root has null character.
        root = new TrieNode((char)0);
    }

    public void addWord(String word){
        TrieNode node = root; 
        int wdepth = 0;  // word depth is 0
        for (char ch : word.toLowerCase().toCharArray()) {  // add all the characters of the word
            node = node.getOrSetChild(ch);    // update the NODE(root)
            wdepth++;                         // word depth is incremented till the last character of the word
        }
        if (!node.isWord()) { // after adding all the characters of the word, flag the last character of the word 
        	// as end of the word with end of word marker to that last character node
            node.setWord();
            size++;         // size maintains the number of words in the trie
            depth=Math.max(depth, wdepth);
        }
    }

    public boolean containsWord(String word){
        TrieNode node = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            node = node.getChild(ch); // update the NODE(root)
            if (node == null) {
                break;
            }
        }
        return (node != null && node.isWord());
    }

    public int size() {
        return size;
    }

    public List<String> getAllWords() {
        // set up a recursion call
        List<String> result = new ArrayList<String>(size);
        char[] charstack = new char[depth];
        getWords(root, charstack, 0, result);
        return result;
    }

    private void getWords(final TrieNode node, final char[] charstack, final int stackdepth, final List<String> result) {
        if (node == null) {
            return;
        }
        if (node.isWord()) {
            result.add(new String(charstack, 0, stackdepth));
        }
        for (TrieNode kid : node.getChildNodes()) {
            charstack[stackdepth] = kid.getNodeChar();
            getWords(kid, charstack, stackdepth + 1, result);
        }
    }

    public static void main(String[] args) {
        Trie t = new Trie();
        t.addWord("h");
        t.addWord("ha");
        t.addWord("hhha");
        t.addWord("samsung");
        t.addWord("sampson");
        t.addWord("Double Vision");

        List<String> words = t.getAllWords();

        for(String s : words){
            System.out.println(s);
        }
        System.out.println(t.containsWord("samsun"));
    }

}