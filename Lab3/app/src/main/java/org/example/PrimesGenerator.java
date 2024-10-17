package org.example;

import java.util.ArrayList;
import java.lang.Math;

public class PrimesGenerator {
    public static ArrayList<Integer> generatePrimes(final int N) {
        final ArrayList<Integer> primes = new ArrayList<>();
        int primesFound = 0;
        for(int currentNumber = 2; primesFound < N; ++currentNumber) {
            if (isPrime(currentNumber)) {
                ++primesFound;
                primes.add(currentNumber);
            }
        }
        return primes;
    }

    private static boolean isPrime(final int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) return false;
        }
        return true;
    }
}
