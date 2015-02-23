/*
 * Question: Implement a HashTable ?
 * 
 * Question Source: MIT BBS Facebook Interview Question
 * 
 *  IMP LINKS:
 *  1. Difference between HashTable and HashMap
 *  http://www.careercup.com/question?id=5645950492082176
 *  
 *  2. Difference between ConcurrentHashMap, Hashtable and synchronizedMap
 *  http://stackoverflow.com/questions/510632/whats-the-difference-between-concurrenthashmap-and-collections-synchronizedmap
 *  
╔═══════════════╦═══════════════════╦═══════════════════╦═════════════════════╗
║   Property    ║     HashMap       ║    Hashtable      ║  ConcurrentHashMap  ║
╠═══════════════╬═══════════════════╬═══════════════════╩═════════════════════╣ 
║      Null     ║     allowed       ║              not allowed                ║
║  values/keys  ║                   ║                                         ║
╠═══════════════╬═══════════════════╬═════════════════════════════════════════╣
║Is thread-safe ║       no          ║                  yes                    ║
╠═══════════════╬═══════════════════╬═════════════════════════════════════════╣
║     Lock      ║       not         ║        locks the portion of             ║ 
║  mechanism    ║    applicable     ║                  map                    ║ 
╠═══════════════╬═══════════════════╩═══════════════════╦═════════════════════╣
║   Iterator    ║               fail-fast               ║       fail-safe     ║ 
╚═══════════════╩═══════════════════════════════════════╩═════════════════════╝




Answer Source: 
HashTable Implementation with array in Java:
https://github.com/ylwu/java-exercises/blob/master/src/HashTable.java   ->  Good Program
https://github.com/zwaldowski/zw-schoolwork/blob/master/CS%201332/HW6/HashTable.java


http://iwillgetthatjobatgoogle.tumblr.com/post/11352414963/implement-a-hash-table


 * 
 */

package ImplementHashtable;

public class myHashtable {

}
