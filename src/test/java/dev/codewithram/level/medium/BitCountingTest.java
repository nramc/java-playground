package dev.codewithram.level.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BitCountingTest {

    @Test
    void test_BitsCount() {
        // base condition
        assertEquals(0, BitCounting.countBits(0));

        assertEquals(2, BitCounting.countBits(10));
        assertEquals(5, BitCounting.countBits(1234));
    }

    @Test
    void test_BinaryConversion() {
        assertEquals(List.of(1), BitCounting.toBinary(1));
        assertEquals(List.of(1, 0), BitCounting.toBinary(2));
        assertEquals(List.of(1, 1), BitCounting.toBinary(3));
        assertEquals(List.of(1, 0, 0), BitCounting.toBinary(4));
        assertEquals(List.of(1, 0, 1), BitCounting.toBinary(5));
        assertEquals(List.of(1, 1, 0), BitCounting.toBinary(6));
    }

}