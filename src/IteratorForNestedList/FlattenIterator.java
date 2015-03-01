/*
Question: You are given an input form such as the following 
(1, (2, 3), (4, (5, 6), 7)) 
Each element is either a number or a list (whose elements may also be numbers or other lists). 
Output the numbers as they appear, stripped down into a single list. 
E.G. (1, 2, 3, 4, 5, 6, 7) 

(Complication - how does your code handle the case of ((((5)))) vs just ( 5 ) ? )

Question Source: http://www.careercup.com/question?id=14967793

Answer Source: http://algokoder.blogspot.com/2008/10/flatten-iterator.html

IMP Sources: 
	http://www.careercup.com/question?id=17727664
	https://github.com/kowshik/big-o/blob/master/java/src/collections/DeepIterator.java
	https://gist.github.com/daviddengcn/4970584
	http://codereview.stackexchange.com/questions/32827/flatten-iterator-for-nested-list
	http://stackoverflow.com/questions/12625038/nested-iterating-through-list-followed-by-an-eventual-deletion
*/		
package IteratorForNestedList;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Stack;

public class FlattenIterator implements Iterator
{
    private final Stack<Iterator<?>> iterators = new Stack<Iterator<?>>();

    private boolean hasNextCalled;
    private boolean hasNextValue;
    private Object next;

    /**
     * Default constructor which takes in an iterator.
     * @param iterator
     * @throws RuntimeException - if iterator is null.
     */
    public FlattenIterator(Iterator iterator)
    {
        if (iterator == null)
        {
            throw new RuntimeException("Iterator cannot be null.");
        }

        iterators.push(iterator);
    }

    public boolean hasNext()
    {
        boolean hasNext = false;

        if (hasNextCalled)
        {
            hasNext = hasNextValue;
        }
        else
        {
            iterateNext();

            hasNextCalled = true;

            hasNext = (next != null);

            hasNextValue = hasNext;
        }

        return hasNext;
    }

    private void iterateNext()
    {
        if (!iterators.empty())
        {
            if (iterators.peek().hasNext())
            {
                next = iterators.peek().next();

                if (next instanceof Iterator)
                {
                    iterators.push((Iterator) next);

                    iterateNext();
                }
            }
            else
            {
                iterators.pop();

                iterateNext();
            }
        }
        else
        {
            next = null;
        }
    }

    public Object next()
    {
        Object returnValue = null;

        if (hasNextCalled)
        {
            hasNextCalled = false;
            returnValue = next;
        }
        else
        {
            iterateNext();

            returnValue = next;
        }

        if (returnValue == null)
        {
            throw new NoSuchElementException();
        }

        return returnValue;
    }

    public void remove()
    {

    }
}