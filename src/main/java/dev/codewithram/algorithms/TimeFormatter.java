package dev.codewithram.algorithms;

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
    private static final int YEAR_IN_SECONDS = 365 * 24 * 60 * 60;
    private static final int DAY_IN_SECONDS = 24 * 60 * 60;
    private static final int HOURS_IN_SECONDS = 60 * 60;
    private static final int MINUTES_IN_SECONDS = 60;

    private TimeFormatter() {
    }

    public static String formatDuration(int seconds) {
        StringBuilder resultBuilder = new StringBuilder();
        int numberOfSeconds = seconds;

        int numberOfYears = numberOfSeconds / YEAR_IN_SECONDS;
        numberOfSeconds -= numberOfYears * YEAR_IN_SECONDS;
        if (numberOfYears > 0) {
            resultBuilder.append(numberOfYears).append(numberOfYears > 1 ? " years " : " year ");
        }

        int numberOfDays = numberOfSeconds / DAY_IN_SECONDS;
        numberOfSeconds -= numberOfDays * DAY_IN_SECONDS;
        if (numberOfDays > 0) {
            resultBuilder.append(numberOfDays).append(numberOfDays > 1 ? " days " : " day ");
        }

        int numberOfHours = numberOfSeconds / HOURS_IN_SECONDS;
        numberOfSeconds -= numberOfHours * HOURS_IN_SECONDS;
        if (numberOfHours > 0) {
            resultBuilder.append(numberOfHours).append(numberOfHours > 1 ? " hours " : " hour ");
        }

        int numberOfMinutes = numberOfSeconds / MINUTES_IN_SECONDS;
        numberOfSeconds -= numberOfMinutes * MINUTES_IN_SECONDS;
        if (numberOfMinutes > 0) {
            resultBuilder.append(numberOfMinutes).append(numberOfMinutes > 1 ? " minutes " : " minute ");
        }

        if (numberOfSeconds > 0) {
            resultBuilder.append(numberOfSeconds).append(numberOfSeconds > 1 ? " seconds " : " second ");
        }


        // your code goes here
        return resultBuilder.toString().trim();
    }

}
