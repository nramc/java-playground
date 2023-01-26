package dev.codewithram.level.easy;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * <p>
 * If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.
 * Finish the solution so that it returns the sum of all the multiples of 3 or 5 below the number passed in.
 * Additionally, if the number is negative, return 0 (for languages that do have them).
 * <p>
 * Note: If the number is a multiple of both 3 and 5, only count it once.
 */
public class MultiplesOf3or5 {
    private static final IntPredicate isDividableBy3 = n -> n % 3 == 0;
    private static final IntPredicate isDividableBy5 = n -> n % 5 == 0;
    private static final IntPredicate isDividableBy3or5 = n -> isDividableBy3.or(isDividableBy5).test(n);

    public int solution(int number) {
        if (number <= 0) {
            return 0;
        }

        return IntStream.range(1, number).filter(isDividableBy3or5).sum();
    }
}
