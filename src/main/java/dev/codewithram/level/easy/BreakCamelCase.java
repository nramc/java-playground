package dev.codewithram.level.easy;

/**
 * Break camelCase
 * <p>
 * Complete the solution so that the function will break up camel casing, using a space between words.
 * <p>
 * Example
 * "camelCasing"  =>  "camel Casing"
 * "identifier"   =>  "identifier"
 * ""             =>  ""
 */
public class BreakCamelCase {
    private BreakCamelCase() {}

    public static String camelCase(String input) {
        return input.replaceAll("([A-Z])", " $1");
    }

}
