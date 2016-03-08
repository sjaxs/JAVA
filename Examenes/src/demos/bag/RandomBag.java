/**
 * @author Pepe Gallardo, Data Structures, Grado en Informática. UMA.
 *
 * Creates a random bag.
 */

package demos.bag;

import dataStructures.bag.Bag;

import java.util.Random;

public class RandomBag {
    public static void fill(Bag<Integer> bag, int seed, int length) {
        Random rnd = new Random(seed);
        for (int i = 0; i < length; i++) {
            int r = rnd.nextInt(4);
            switch (r) {
                case 0:
                case 1:
                    int x = rnd.nextInt();
                    bag.insert(x);
                    break;
                case 2:
                    int y = rnd.nextInt();
                    bag.delete(y);
                    break;
                case 3:
                    int z = rnd.nextInt();
                    bag.occurrences(z);
            }
        }
    }
}
