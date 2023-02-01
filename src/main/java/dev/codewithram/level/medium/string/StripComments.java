package dev.codewithram.level.medium.string;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StripComments {
    private StripComments() {
    }

    public static String stripComments(String text, String[] commentSymbols) {
        return Arrays.stream(text.split("\n"))
                .map(t -> t.substring(0, getCommentIndex(t, commentSymbols)))
                .map(String::stripTrailing)
                .collect(Collectors.joining("\n"));
    }

    private static int getCommentIndex(String text, String[] commentSymbols) {
        return Arrays.stream(commentSymbols).filter(text::contains).map(text::indexOf).findFirst().orElse(text.length());
    }
}
