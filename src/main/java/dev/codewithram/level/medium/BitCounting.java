package dev.codewithram.level.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Bit Counting
 * Write a function that takes an integer as input, and returns the number of bits that are equal to one in the binary representation of that number. You can guarantee that input is non-negative.
 * <p>
 * Example: The binary representation of 1234 is 10011010010, so the function should return 5 in this case
 */
public class BitCounting {
    private static final Predicate<Integer> isEqualToOne = n -> n == 1;

    public static int countBits(int n) {
        List<Integer> binaryValues = toBinary(n);
        return (int) binaryValues.stream().filter(isEqualToOne).count();
    }

    static List<Integer> toBinary(int n) {
        List<Integer> remainders = new ArrayList<>();
        int quotient = n;
        while (quotient > 0) {
            remainders.add(0, quotient % 2);
            quotient = Math.floorDiv(quotient, 2);
        }
        return remainders;
    }

}
