package org.example;

import java.util.ArrayList;
import java.util.ListIterator;

public class PrimesGeneratorTest {
    public static void test(final int N){
        final ArrayList<Integer> primes = PrimesGenerator.generatePrimes(N);
        final ListIterator<Integer> iterator = primes.listIterator();

        System.out.println("Primes forward.");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("Primes reversed.");
        while (iterator.hasPrevious()) {
            System.out.print(iterator.previous() + " ");
        }
        System.out.println();
    }
}
