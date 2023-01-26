package dev.codewithram.level.easy;

import java.util.List;

public class DisemvowelTrolls {
    public String disemvowel(String str) {
        List<String> vowels = List.of("A", "E", "I", "O", "U");
        return vowels.stream().reduce(str, (name, vowel) -> name.replaceAll("(?i)" + vowel, ""));
    }
}
