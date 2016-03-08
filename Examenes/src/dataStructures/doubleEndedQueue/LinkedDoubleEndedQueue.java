/**
 * @author Pablo López, Data Structures, Grado en Informática. UMA.
 *
 * Doubly linked implementation of a double ended queue, dequeue or deque
 */

package dataStructures.doubleEndedQueue;

public class LinkedDoubleEndedQueue<T> implements DoubleEndedQueue<T> {

    private static class Node<E> {
        private E item;
        private Node<E> next;
        private Node<E> previous;

        public Node(E x, Node<E> n, Node<E> p) {
            item = x;
            next = n;
            previous = p;
        }
    }

    private Node<T> first;
    private Node<T> last;

    public LinkedDoubleEndedQueue() {
        first = null;
        last = null;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void addFirst(T x) {
        first = new Node<>(x, first, null);
        if (last == null) {
            last = first;
        } else {
            first.next.previous = first;
        }
    }

    @Override
    public void addLast(T x) {
        last = new Node<>(x, null, last);
        if (first == null) {
            first = last;
        } else {
            last.previous.next = last;
        }
    }

    @Override
    public T first() {
        if (isEmpty()) {
            throw new EmptyDoubleEndedQueueException("first on empty dequeue");
        } else {
            return first.item;
        }
    }

    @Override
    public T last() {
        if (isEmpty()) {
            throw new EmptyDoubleEndedQueueException("last on empty dequeue");
        } else {
            return last.item;
        }
    }

    @Override
    public void deleteFirst() {
        if (isEmpty()) {
            throw new EmptyDoubleEndedQueueException(
                    "deleteFirst on empty dequeue");
        } else {
            first = first.next;
            if (first != null) {
                first.previous = null;
            } else {
                last = null;
            }
        }
    }

    @Override
    public void deleteLast() {
        if (isEmpty()) {
            throw new EmptyDoubleEndedQueueException(
                    "deleteLast on empty dequeue");
        } else {
            last = last.previous;
            if (last != null) {
                last.next = null;
            } else {
                first = null;
            }
        }
    }

    @Override
    public String toString() {
        String className = getClass().getSimpleName();
        String s = className+"(";
        for (Node<T> node = first; node != null; node = node.next)
            s += node.item + (node.next != null ? "," : "");
        s += ")";
        return s;
    }
}
