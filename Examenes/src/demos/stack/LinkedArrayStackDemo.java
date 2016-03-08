/**
 * @author Blas Ruiz, Data Structures, Grado en Informática. UMA.
 *
 * Linked Array Stack demo
 */

package demos.stack;

import dataStructures.stack.LinkedArrayStack;
import dataStructures.stack.Stack;

public class LinkedArrayStackDemo {
    public static void main(String[] args) {
        Stack<Integer> s = new LinkedArrayStack<>();

        System.out.println("*** pushing numbers from 0 to 54");
        for (int i = 0; i < 55; i++)
            s.push(i);

        System.out.println(s);

        System.out.println("*** poping 10 elements and pushing number 1000");
        for (int i = 0; i < 10; i++)
            s.pop();
        s.push(1000);

        System.out.println(s);

        System.out.println("*** poping all elements");
        while (!s.isEmpty())
            s.pop();

        System.out.println(s);

        System.out.println("*** pushing numbers from 0 to 13");
        for (int i = 0; i < 14; i++)
            s.push(i);

        System.out.println(s);
    }
}
