package dev.codewithram.level.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindOddTest {

    @Test
    void test() {
        assertEquals(7, FindOdd.findIt(new int[]{7}));

        assertEquals(0, FindOdd.findIt(new int[]{0}));

        assertEquals(2, FindOdd.findIt(new int[]{1, 1, 2}));

        assertEquals(0, FindOdd.findIt(new int[]{0, 1, 0, 1, 0}));

        assertEquals(4, FindOdd.findIt(new int[]{1, 2, 2, 3, 3, 3, 4, 3, 3, 3, 2, 2, 1}));

    }

}