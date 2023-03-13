package dev.codewithram.level.medium.integer;

import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;

/**
 * <h1>Int32 to IPv4</h1>
 *
 * <p>
 * Take the following IPv4 address: 128.32.10.1
 * This address has 4 octets where each octet is a single byte (or 8 bits).
 * </p>
 *
 * <ul>
 *     <li>1st octet 128 has the binary representation: 10000000</li>
 *     <li>2nd octet 32 has the binary representation: 00100000</li>
 *     <li>3rd octet 10 has the binary representation: 00001010</li>
 *     <li>4th octet 1 has the binary representation: 00000001</li>
 * </ul>
 *
 * <p>
 * Because the above IP address has 32 bits, we can represent it as the unsigned 32 bit number: 2149583361
 * Complete the function that takes an unsigned 32 bit number and returns a string representation of its IPv4 address.
 * </p>
 *
 * <h2>Examples</h5>
 * <ul>
 *     <li>2149583361 ==> "128.32.10.1"</li>
 *     <li>32         ==> "0.0.0.32"</li>
 *     <li>0          ==> "0.0.0.0"</li>
 * </ul>
 */
public class Int32ToIPv4 {
    private static final int BITS_COUNT = 8;
    private static final BiFunction<String, Integer, Integer> calcStartPos = (s, pos) ->
            Math.min(s.length(), Math.max((s.length() - pos * BITS_COUNT), 0));
    private static final BiFunction<String, Integer, Integer> calcEndPos = (s, pos) ->
            Math.min(s.length(), Math.max(s.length() - ((pos - 1) * BITS_COUNT), 0));
    private static final BiFunction<String, Integer, String> extractSegment = (str, pos) ->
            Optional.of(str)
                    .map(s -> s.substring(calcStartPos.apply(s, pos), calcEndPos.apply(s, pos)))
                    .filter(s -> s.length() > 0)
                    .orElse("0");

    private static final UnaryOperator<String> convertBinaryToString = s -> String.valueOf(Integer.parseInt(s, 2));

    private Int32ToIPv4() {
    }

    public static String longToIP(long input) {
        String binaryValue = Long.toBinaryString(input);

        return IntStream.rangeClosed(1, 4).boxed()
                .map(pos -> extractSegment.apply(binaryValue, pos))
                .map(convertBinaryToString)
                .reduce((a, b) -> b + "." + a).orElse("0");

    }
}
