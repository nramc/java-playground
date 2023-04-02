package dev.codewithram.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * How can you tell an extrovert from an introvert at NSA?
 * Va gur ryringbef, gur rkgebireg ybbxf ng gur BGURE thl'f fubrf.
 * <p>
 * I found this joke on USENET, but the punchline is scrambled. Maybe you can decipher it?
 * According to Wikipedia, ROT13 is frequently used to obfuscate jokes on USENET.
 * <p>
 * For this task you're only supposed to substitute characters. Not spaces, punctuation, numbers, etc.
 * <p>
 * Test examples:
 * <em>
 * <p>
 * "EBG13 rknzcyr." -> "ROT13 example."
 * <p>
 * "This is my first ROT13 excercise!" -> "Guvf vf zl svefg EBG13 rkprepvfr!"
 * </em>
 */
public class ROT13Algorithm {
    private static final Map<String, String> CHAR_MAPPING = new HashMap<>();

    static {
        IntStream.rangeClosed('A', 'M').forEach(key -> CHAR_MAPPING.put(String.valueOf((char) key), String.valueOf((char) (key + 13))));
        IntStream.rangeClosed('N', 'Z').forEach(key -> CHAR_MAPPING.put(String.valueOf((char) key), String.valueOf((char) (key - 13))));
        IntStream.rangeClosed('a', 'm').forEach(key -> CHAR_MAPPING.put(String.valueOf((char) key), String.valueOf((char) (key + 13))));
        IntStream.rangeClosed('n', 'z').forEach(key -> CHAR_MAPPING.put(String.valueOf((char) key), String.valueOf((char) (key - 13))));
    }

    private ROT13Algorithm() {
    }

    public static String rot13(String message) {

        return Arrays.stream(message.split("")).map(key -> CHAR_MAPPING.getOrDefault(key, key)).collect(Collectors.joining());
    }
}
