package dev.codewithram.level.medium;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

/**
 * The number 89 is the first integer with more than one digit that fulfills the property partially introduced in the title of this kata.
 * What's the use of saying "Eureka"? Because this sum gives the same number: 89 = 8^1 + 9 ^ 2
 * <p>
 * The next number in having this property is 135
 * See this property again:
 * 135 = 1^1 + 3^2 + 5^3
 * <p>
 * Task
 * <p>
 * We need a function to collect these numbers, that may receive two integers a,b
 * that defines the range [a,b] (inclusive) and outputs a list of the sorted numbers in the range that fulfills the property described above.
 * <p>
 * Examples
 * Let's see some cases (input -> output):
 * <p>
 * 1, 10  --> [1, 2, 3, 4, 5, 6, 7, 8, 9]
 * 1, 100 --> [1, 2, 3, 4, 5, 6, 7, 8, 9, 89]
 * If there are no numbers of this kind in the range
 * [a,b] the function should output an empty list.
 * <p>
 * 90, 100 --> []
 * Enjoy it!!
 */
public class SumDigitsPower {
    private SumDigitsPower() {}
    public static List<Long> sumDigPow(long a, long b) {
        return LongStream.rangeClosed(a, b)
                .filter(SumDigitsPower::isEqualOfSumOfPowOfDigits)
                .boxed()
                .toList();
    }

    static boolean isEqualOfSumOfPowOfDigits(long num) {
        long[] digits = Arrays.stream(String.valueOf(num).split("")).mapToLong(Long::valueOf).toArray();

        long total = LongStream.rangeClosed(1, digits.length)
                .reduce(0, (subTotal, digit) -> (long) (subTotal + Math.pow(digits[(int) (digit - 1)], digit)));

        return total == num;
    }

}
