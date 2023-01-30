package dev.codewithram.level.easy.algorithm;

import java.util.stream.IntStream;

/**
 * Define a function that takes an integer argument and returns a logical value true or false depending on if the integer is a prime.
 * <p>
 * Per Wikipedia, a prime number ( or a prime ) is a natural number greater than 1 that has no positive divisors other than 1 and itself.
 * <p>
 * Requirements
 * You can assume you will be given an integer input.
 * You can not assume that the integer will be only positive. You may be given negative numbers as well ( or 0 ).
 * NOTE on performance: There are no fancy optimizations required, but still the most trivial solutions might time out. Numbers go up to 2^31 ( or similar, depending on language ). Looping all the way up to n, or n/2, will be too slow.
 * Example
 * is_prime(1)  -> false
 * is_prime(2)  -> true
 * is_prime(-1) -> false
 */
public class Prime {

    private Prime() {
    }

    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        } else if (num == 2 || num == 3) {
            return true;
        } else if (num % 2 == 0 || num % 3 == 0) {
            return false;
        } else {
            return IntStream
                    .iterate(5, n -> n <= Math.sqrt(n), n -> n + 6)
                    .noneMatch(n -> num % n == 0 || num % (n + 2) == 0);
        }
    }

}
