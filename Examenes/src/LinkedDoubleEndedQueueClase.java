/**
 * Estructuras de Datos. Grado en Informática, IS e IC. UMA.
 * Examen de Febrero 2015.
 *
 * Implementación del TAD Deque
 *
 * Apellidos:
 * Nombre:
 * Grado en Ingeniería ...
 * Grupo:
 * Número de PC:
 */


public class LinkedDoubleEndedQueueClase<T> implements DoubleEndedQueueClase<T> {

    private static class Node<E> {
        private E elem;
        private Node<E> next;
        private Node<E> prev;

        public Node(E x, Node<E> nxt, Node<E> prv) {
            elem = x;
            next = nxt;
            prev = prv;
        }
    }

    private Node<T> first, last;

    /**
     *  Invariants:
     *  if queue is empty then both first and last are null
     *  if queue is non-empty:
     *      * first is a reference to first node and last is ref to last node
     *      * first.prev is null
     *      * last.next is null
     *      * rest of nodes are doubly linked
     */

    /**
     * Complexity:
     */
    public LinkedDoubleEndedQueueClase() {

    	first = null;
    	last = null;

    }

    /**
     * Complexity:
     */
    @Override
    public boolean isEmpty() {
    	return first == null;
    }

    /**
     * Complexity:
     */
    @Override
    public void addFirst(T x) {

    	Node n = new Node(x,first,null);
    	first.prev = n;
    	first = n;
    }

    /**
     * Complexity:
     */
    @Override
    public void addLast(T x) {
    	Node n = new Node(x,null,last);
    	last.next = n;
    	last = n;
    }

    /**
     * Complexity:
     */
    @Override
    public T first() {
    		return first.elem;
    }

    /**
     * Complexity:
     */
    @Override
    public T last() {
    		return last.elem;
    }

    /**
     * Complexity:
     */
    @Override
    public void deleteFirst() {
    	
    	first.next.prev = null;
    	first = first.next;
    	
    }

    /**
     * Complexity:
     */
    @Override
    public void deleteLast() {
    	
    	last.prev.next = null;
        last = last.prev;
    }

    /**
     * Returns representation of queue as a String.
     */
    @Override
    public String toString() {
    String className = getClass().getName().substring(getClass().getPackage().getName().length()+1);
        String s = className+"(";
        for (Node<T> node = first; node != null; node = node.next)
            s += node.elem + (node.next != null ? "," : "");
        s += ")";
        return s;
    }
}
