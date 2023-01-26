package dev.codewithram.level.easy;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Mumbling {

    public String accum(String s) {
        char[] characters = s.toCharArray();

        return IntStream.range(0, characters.length)
                .mapToObj(idx -> repeatWithTitleCase(characters[idx], idx+1))
                .collect(Collectors.joining("-"));
    }

    String repeatWithTitleCase(Character ch, int count) {
        String character = String.valueOf(ch).toLowerCase();
        return IntStream.range(1, count)
                .mapToObj(val -> character)
                .reduce(character.toUpperCase(), (ch1, ch2) -> ch1 + ch2);
    }

}
