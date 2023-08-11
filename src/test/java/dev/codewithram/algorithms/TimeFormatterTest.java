package dev.codewithram.algorithms;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static dev.codewithram.algorithms.TimeFormatter.DAY_IN_SECONDS;
import static dev.codewithram.algorithms.TimeFormatter.HOURS_IN_SECONDS;
import static dev.codewithram.algorithms.TimeFormatter.MINUTES_IN_SECONDS;
import static dev.codewithram.algorithms.TimeFormatter.YEAR_IN_SECONDS;
import static dev.codewithram.algorithms.TimeFormatter.formatDuration;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TimeFormatterTest {

    @Test
    @DisplayName("If it is zero, it just returns 'now'")
    void test_whenSecondZero_shouldReturnNow() {
        assertEquals("now", formatDuration(0));
    }

    @Test
    @DisplayName("The unit of time is used in plural if the integer is greater than 1")
    void tst_plural_words() {
        assertEquals("2 seconds",
                formatDuration(2));
        assertEquals("2 minutes and 2 seconds",
                formatDuration((2 * MINUTES_IN_SECONDS) + 2));
        assertEquals("2 hours, 2 minutes and 2 seconds",
                formatDuration((2 * HOURS_IN_SECONDS) + (2 * MINUTES_IN_SECONDS) + 2));
        assertEquals("2 days, 2 hours, 2 minutes and 2 seconds",
                formatDuration((2 * DAY_IN_SECONDS) + (2 * HOURS_IN_SECONDS) + (2 * MINUTES_IN_SECONDS) + 2));
        assertEquals("2 years, 2 days, 2 hours, 2 minutes and 2 seconds",
                formatDuration((2 * YEAR_IN_SECONDS) + (2 * DAY_IN_SECONDS) + (2 * HOURS_IN_SECONDS) + (2 * MINUTES_IN_SECONDS) + 2));
    }

    @Test
    @DisplayName("The components are separated by a comma and a space (\", \")")
    void test_component_separation() {
        assertEquals("2 years, 2 days, 2 hours, 2 minutes and 2 seconds",
                formatDuration((2 * YEAR_IN_SECONDS) + (2 * DAY_IN_SECONDS) + (2 * HOURS_IN_SECONDS) + (2 * MINUTES_IN_SECONDS) + 2));
    }

    @Test
    @DisplayName("A component will not appear at all if its value happens to be zero")
    void test_whenComponentValueIsZero_thenShouldNotAppear() {
        assertEquals("1 minute", formatDuration(60));
        assertEquals("1 hour", formatDuration(HOURS_IN_SECONDS));
        assertEquals("1 hour and 1 second", formatDuration(HOURS_IN_SECONDS + 1));
        assertEquals("1 day", formatDuration(DAY_IN_SECONDS));
        assertEquals("1 day and 1 minute", formatDuration(DAY_IN_SECONDS + MINUTES_IN_SECONDS));
        assertEquals("1 year", formatDuration(YEAR_IN_SECONDS));
        assertEquals("1 year and 1 hour", formatDuration(YEAR_IN_SECONDS + HOURS_IN_SECONDS));
    }

    @Test
    void exampleTests() {
        assertEquals("1 second", formatDuration(1));
        assertEquals("1 minute and 2 seconds", formatDuration(62));
        assertEquals("2 minutes", formatDuration(120));
        assertEquals("1 hour", formatDuration(3600));
        assertEquals("1 hour, 1 minute and 2 seconds", formatDuration(3662));
    }

    @Test
    void testComponent_YearFormatting() {
        assertEquals("1 year", formatDuration(YEAR_IN_SECONDS));
        assertEquals("2 years", formatDuration(2 * YEAR_IN_SECONDS));
    }
}