/*
Question : You have a dictionary which is an array of words and array of strings. 

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

    private static final TrieNode[] EMPTYNODES = new TrieNode[0];

    private static final class TrieNode implements Comparable<TrieNode> {

        private final char character;
        private boolean isWord = false;
        private Map<Character, TrieNode> children = null;

        public TrieNode(char ch) {
            character = ch;
        }

        public TrieNode getOrCreateChild(char ch) {
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

        public TrieNode get(char ch) {
            return children != null ? children.get(ch) : null;
        }

        public void setWord() {
            isWord = true;
        }

        public boolean isWord() {
            return isWord;
        }

        public char getChar() {
            return character;
        }

        public TrieNode[] getChildNodes() {
            if (children == null) {
                return EMPTYNODES;
            }
            TrieNode[] result = children.values().toArray(new TrieNode[children.size()]);
            Arrays.sort(result);
            return result;
        }

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
            node = node.getOrCreateChild(ch);
            wdepth++;                         // word depth is incremented till the last character of the word
        }
        if (!node.isWord()) { // after adding all the characters of the word, flag the last character of the word 
        	// as end of the word with end of word marker to that last character node
            node.setWord();
            size++;         // size maintains the number of words in the trie
            if (wdepth > depth) {
                depth = wdepth;  // depth maintains the size of longest word
            }
        }
    }

    public boolean containsWord(String word){
        TrieNode node = root;
        for (char ch : word.toLowerCase().toCharArray()) {
            node = node.get(ch);
            if (node == null) {
                break;
            }
        }
        return node != null && node.isWord();
    }

    public int size() {
        return size;
    }

    public List<String> getWords() {
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
            charstack[stackdepth] = kid.getChar();
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

        List<String> words = t.getWords();

        for(String s : words){
            System.out.println(s);
        }
        System.out.println(t.containsWord("samsun"));
    }

}