package dev.codewithram.level.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MumblingTest {
    private final Mumbling obj = new Mumbling();
    @Test
    void test() {
        assertEquals("A-Bb-Ccc-Dddd", obj.accum("abcd"));
        assertEquals("R-Qq-Aaa-Eeee-Zzzzz-Tttttt-Yyyyyyy", obj.accum("RqaEzty"));
        assertEquals("C-Ww-Aaa-Tttt", obj.accum("cwAt"));

    }

    @Test
    void test_repeat() {
        assertEquals("Aaaaa", obj.repeatWithTitleCase('a', 5));
        assertEquals("A", obj.repeatWithTitleCase('a', 1));
        assertEquals("Vvv", obj.repeatWithTitleCase('v', 3));
    }

}