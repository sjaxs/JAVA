
public interface DoubleEndedQueueClase<T> {
    boolean isEmpty();

    void addFirst(T x);

    void addLast(T x);

    T first();

    T last();

    void deleteFirst();

    void deleteLast();
}
