/**
 * @author Pepe Gallardo, Data Structures, Grado en Informática. UMA.
 *
 * Interface for double ended queues
 */

package dataStructures.doubleEndedQueue;

public interface DoubleEndedQueue<T> {
	boolean isEmpty();
	
	void addFirst(T x);
	void addLast(T x);
	
	T first();
	T last();
	
	void deleteFirst();
	void deleteLast();
}
