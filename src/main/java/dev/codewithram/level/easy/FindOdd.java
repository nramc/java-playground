package dev.codewithram.level.easy;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindOdd {

    public static int findIt(int[] a) {
        Map<Integer, Long> occurrencesOfValue = Arrays.stream(a).boxed().collect(
                Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return occurrencesOfValue.entrySet().stream()
                .filter(entry -> entry.getValue() % 2 == 1)
                .map(Map.Entry::getKey)
                .findFirst().orElse(0);
    }
}
