
public interface PriorityQueue <T extends Comparable<? super T>>{

	void enqueue(T elem);
	void dequeue();
	T first();
	boolean isEmpty();

}
