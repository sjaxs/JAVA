package demos.doubleEndedQueue;

import dataStructures.doubleEndedQueue.DoubleEndedQueue;
import dataStructures.doubleEndedQueue.SearchTreeDoubleEndedQueue;

public class DoubleEndedQueueDemo {

    public static void main(String[] args) {

        final String Name = "John"; // null;
        final String Surname = "Doe"; // null;

        if (Name == null || Surname == null) {
            throw new RuntimeException("Please fill in your name and surname");
        }

        System.out.printf("%s, %s\n", Surname, Name);

        final int N = 11;
        DoubleEndedQueue<Integer> dq = new SearchTreeDoubleEndedQueue<>();

        // Check the constructor

        if (!dq.isEmpty()) {
            throw new RuntimeException("Dequeue should be created empty");
        }

        // Check working at front of an empty dequeue

        dq.addFirst(1);

        if (dq.isEmpty()) {
            throw new RuntimeException("Dequeue should not be empty");
        }

        if (dq.first() != 1) {
            throw new RuntimeException("First should be 1");
        }

        if (dq.last() != 1) {
            throw new RuntimeException("Last should be 1");
        }

        dq.deleteFirst();

        if (!dq.isEmpty()) {
            throw new RuntimeException("Dequeue should be empty");
        }

        // Check working at rear of an empty dequeue

        dq.addLast(1);

        if (dq.isEmpty()) {
            throw new RuntimeException("Dequeue should not be empty");
        }

        if (dq.last() != 1) {
            throw new RuntimeException("Last should be 1");
        }

        if (dq.first() != 1) {
            throw new RuntimeException("First should be 1");
        }

        dq.deleteLast();

        if (!dq.isEmpty()) {
            throw new RuntimeException("Dequeue should be empty");
        }

        // Check N insertions/retrievals/deletions at front

        for (int i= 0; i <= N; i++) {
            dq.addFirst(i);
        }

        for (int i= N; i >= 0; i--) {
            if (i != dq.first()) {
                throw new RuntimeException("First should be " + i);
            }
            dq.deleteFirst();
        }

        if (!dq.isEmpty()) {
            throw new RuntimeException("Dequeue should be empty");
        }

        // Check N insertions/retrievals/deletions at rear

        for (int i= 0; i <= N; i++) {
            dq.addLast(i);
        }

        for (int i= N; i >= 0; i--) {
            if (i != dq.last()) {
                throw new RuntimeException("Last should be " + i);
            }
            dq.deleteLast();
        }

        if (!dq.isEmpty()) {
            throw new RuntimeException("Dequeue should be empty");
        }

        // Check N insertions/retrievals/deletions alternating front and rear

        for (int i= 0; i<= N; i++) {
            if (i % 2 == 0) {
                dq.addFirst(i);
            }
            else {
                dq.addLast(i);
            }
        }

        for (int i= N; i >= 0; i--) {
            if (i % 2 == 0) {
                if (i != dq.first()) {
                    throw new RuntimeException("First should be " + i);
                }
                dq.deleteFirst();
            }
            else {
                if (i != dq.last()) {
                    throw new RuntimeException("Last should be " + i);
                }
                dq.deleteLast();
            }
        }

        if (!dq.isEmpty()) {
            throw new RuntimeException("Dequeue should be empty");
        }

        System.out.println("DONE");
    }
}
