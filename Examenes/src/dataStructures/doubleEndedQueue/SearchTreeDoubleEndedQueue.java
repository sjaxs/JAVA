/**
 * @author Pepe Gallardo, Data Structures, Grado en Informática. UMA.
 *
 * Double ended queue, dqueue or deque implemented by using a binary search tree.
 * Minimun node in tree stores first element in queue and maximum node stores last.
 */

package dataStructures.doubleEndedQueue;

import dataStructures.searchTree.AVL;
import dataStructures.searchTree.SearchTree;
import dataStructures.tuple.Tuple2;

public class SearchTreeDoubleEndedQueue<T> implements DoubleEndedQueue<T> {
    protected SearchTree<Integer,T> t;
    protected int fst, lst;

    public SearchTreeDoubleEndedQueue() {
        t = new AVL<>();
        fst = -1;
        lst = 0;
    }

    @Override
    public boolean isEmpty() {
        return t.isEmpty();
    }

    @Override
    public void addFirst(T x) {
        t.insert(fst, x);
        fst--;
    }

    @Override
    public void addLast(T x) {
        t.insert(lst, x);
        lst++;
    }

    @Override
    public T first() {
        if(isEmpty())
            throw new EmptyDoubleEndedQueueException("first on empty double ended queue");
        else
            return t.minim();
    }

    @Override
    public T last() {
        if(isEmpty())
            throw new EmptyDoubleEndedQueueException("last on empty double ended queue");
        else
            return t.maxim();
    }

    @Override
    public void deleteFirst() {
        if(isEmpty())
            throw new EmptyDoubleEndedQueueException("deleteFirst on empty double ended queue");
        else {
            t.deleteMinim();
            fst++;
        }
    }

    @Override
    public void deleteLast() {
        if(isEmpty())
            throw new EmptyDoubleEndedQueueException("deleteLast on empty double ended queue");
        else {
            t.deleteMaxim();
            lst--;
        }
    }

    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        String s = className+"(";
        for(Tuple2<?,T> tup : t.keysValues())
            s += tup._2()+",";
        s = s.substring(0,s.length()-1);
        s += ")";
        return s;
    }
}
