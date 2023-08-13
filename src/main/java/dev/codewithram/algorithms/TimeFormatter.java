package dev.codewithram.algorithms;

import java.util.function.UnaryOperator;

/**
 * Your task in order to complete this Kata is to write a function which formats a duration,
 * given as a number of seconds, in a human-friendly way.
 * <p>
 * The function must accept a non-negative integer. If it is zero, it just returns "now".
 * Otherwise, the duration is expressed as a combination of years, days, hours, minutes and seconds.
 *
 * <p>
 * <h4>It is much easier to understand with an example:</h4>
 * <ul>
 * <li>For seconds = 62, your function should return "1 minute and 2 seconds"</li>
 * <li>For seconds = 3662, your function should return "1 hour, 1 minute and 2 seconds"</li>
 * </ul>
 * For the purpose of this Kata, a year is 365 days and a day is 24 hours.
 * </p>
 * <p>
 * Note that spaces are important.
 * <p>
 * Detailed rules,
 * The resulting expression is made of components like 4 seconds, 1 year, etc.
 * In general, a positive integer and one of the valid units of time, separated by a space.
 * The unit of time is used in plural if the integer is greater than 1.
 * <p>
 * The components are separated by a comma and a space (", ").
 * Except the last component, which is separated by " and ", just like it would be written in English.
 * <p>
 * A more significant units of time will occur before than a least significant one.
 * Therefore, 1 second and 1 year is not correct, but 1 year and 1 second is.
 * <p>
 * Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.
 * <p>
 * A component will not appear at all if its value happens to be zero.
 * Hence, 1 minute and 0 seconds is not valid, but it should be just 1 minute.
 * <p>
 * A unit of time must be used "as much as possible".
 * It means that the function should not return 61 seconds, but 1 minute and 1 second instead.
 * Formally, the duration specified by of a component must not be greater than any valid more significant unit of time.
 */

public class TimeFormatter {
    static final int YEAR_IN_SECONDS = 365 * 24 * 60 * 60;
    static final int DAY_IN_SECONDS = 24 * 60 * 60;
    static final int HOURS_IN_SECONDS = 60 * 60;
    static final int MINUTES_IN_SECONDS = 60;

    public static final String LAST_COMPONENT_SEP = " and ";
    public static final String COMPONENT_SEP = ", ";

    private static final UnaryOperator<State> FORMAT_YEAR = input -> {

        int componentUnitInSeconds = YEAR_IN_SECONDS;
        String component = "year";

        int componentVal = input.seconds / componentUnitInSeconds;
        String componentTxt = componentVal + " " + (componentVal > 1 ? component + "s" : component);

        if (componentVal > 0) {

            int remainingSeconds = input.seconds - (componentVal * componentUnitInSeconds);

            String separator = remainingSeconds <= 0 ? LAST_COMPONENT_SEP : COMPONENT_SEP;
            String formattedText = input.formattedTxt().isBlank() ? componentTxt : input.formattedTxt() + separator + componentTxt;

            return new State(remainingSeconds, formattedText);

        } else {
            return input;
        }

    };

    private TimeFormatter() {
    }

    public static String formatDuration(int seconds) {


        return FORMAT_YEAR.apply(new State(seconds, "")).formattedTxt();
    }

    record State(int seconds, String formattedTxt) {
    }


}
