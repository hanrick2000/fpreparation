
/*
 * Question:
 * 
There are 3 rooms in which party is going on lets say room A, B, C. Guests are coming one by one and you have 
to tell the guest 
which room to enter. At any point of time each room has to maintain a percentage Lets say the percentage that
 each room has to maintain is 
A- 20% , B-30% , C- 50%. You can maintain total count of each room and keep on adding count to respective room 
as the new guest enters each room. 
HOW WOULD YOU GO ABOUT IT. WHAT FORMULA WOULD YOU USE. 
GIVE A GENERALISE FORMULA SO THAT IT WORKS IF NO OF ROOMS INCREASE.

Question and Answer Source: http://www.careercup.com/question?id=5684841825697792

Solution Heuristic:

 * Assume that we start out with 2 people in A, 3 people in B, and 5 people in C. We are currently maintaining 
 * the ideal percentage. Now, if we decide to add a person to a room, there is no way we can maintain this 
 * ideal percentage because we will have 11 people, so we can't get the exact percentages since you can't put
 *  a fraction of a person into a room. The best place to add a person would be in the room with the 
 *  highest percentage since this would lead to the smallest difference of ideal percentages over all of the rooms. 

So we know that in the case that we have an ideal percentage, we should add a person to the room with the 
highest ideal percentage (in this case, room C). 
Since (2/11) * 100 = 18.18 %
       (3/11) * 100 = 27.27 %
This means that C has greater difference to its ideal percentage. Hence we will add 12th person to room C 

Now, we can see that the percentages of the rooms will be lower for A and B, but higher for C. Since we can't 
take people out of rooms, we can only add people. Adding to C would be unwise, since it is already over the 
ideal percentage, so we will look at A and B. whichever has a greater difference from ideal percentage, 
we will add a person to the room. 

We continue this heuristic to get the best case percentages at any given time... 

With this heuristic, we add in this order to each room: 

CBACBCACBC 

If you go through it, you will see how stable the percentages are throughout
 * 
 * 
 */

package PartyRooms;

public class UsingHeuristicApproach {

}
