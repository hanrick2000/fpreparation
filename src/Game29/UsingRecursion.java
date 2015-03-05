
/*
 * Question:
Determine winner of 2/9 number game 

Two players play the following game: they pick a random number N (less than 2 billion) then, 
starting from 1, take turns multiplying the number from the previous turn with either 2 or 9 (their choice). 
Whoever reaches N first wins. 
The candidate should write a function that given N decides who wins (first or second player)?

Question Source: http://www.careercup.com/question?id=14633700

Solution Source: http://stackoverflow.com/questions/13364811/game-of-2-9-interview-at-facebook
https://meditationthrougheyes.wordpress.com/2013/01/18/29-game/

Algorithm:

1. Since they must reach exactly N, this is only possible if N is of the form 2^a * 9^b, with one of a, b 
allowed to be 0 as well.

2. Find a and b above: if a + b = even, then the second player will win, otherwise the first will win.

3. This is because, at each step, a player gets closer to either a or b by one, and therefore to a + b by one. 
So the problem reduces to: given k, if at each step a player must subtract 1 from k, 
which player will reach 0 first?






The optimal play will normally be to play the opposite of the opponent's move except right at the start and end.

By comparing with a recursive solution, it turns out that the answer can be computed based on the most significant 
digit in a base 18 representation of the number-1 as follows:

def win29(n):
    if n<=9: return True
    n-=1
    while n>=18:
        n = n//18
    return n==1 or 4<=n<=8
 */

package Game29;

public class UsingRecursion {

}
