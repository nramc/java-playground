package dev.codewithram.level.medium.datetime;

/**
 * Write a function, which takes a non-negative integer (seconds) as input and returns the time in a human-readable format (HH:MM:SS)
 * <p>
 * HH = hours, padded to 2 digits, range: 00 - 99
 * MM = minutes, padded to 2 digits, range: 00 - 59
 * SS = seconds, padded to 2 digits, range: 00 - 59
 * The maximum time never exceeds 359999 (99:59:59)
 * <p>
 * You can find some examples in the test fixtures.
 */
public class HumanReadableTime {
    private HumanReadableTime() {
    }

    public static String makeReadable(int seconds) {
        int hours = seconds / (60 * 60);
        int mins = (seconds - (hours * 60 * 60)) / 60;
        int secs = (seconds - (hours * 60 * 60) - (mins * 60));

        return String.format("%02d:%02d:%02d", hours, mins, secs);
    }
}
