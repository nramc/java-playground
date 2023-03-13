package dev.codewithram.level.medium.integer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Int32ToIPv4Test {

    @Test
    void sampleTest() {
        assertEquals("128.114.17.104", Int32ToIPv4.longToIP(2154959208L));
        assertEquals("0.0.0.0", Int32ToIPv4.longToIP(0));
        assertEquals("128.32.10.1", Int32ToIPv4.longToIP(2149583361L));
    }

    @Test
    void test() {
        assertEquals("65.106.81.201", Int32ToIPv4.longToIP(1097486793L));

    }


}