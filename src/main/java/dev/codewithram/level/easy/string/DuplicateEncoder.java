package dev.codewithram.level.easy.string;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateEncoder {
    private DuplicateEncoder() {
    }

    static String encode(String word) {
        String[] characters = word.toLowerCase().split("");
        Map<String, Long> chMap = Arrays.stream(characters)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        return Arrays.stream(characters)
                .map(ch -> chMap.get(ch) == 1 ? "(" : ")")
                .collect(Collectors.joining());
    }

}
