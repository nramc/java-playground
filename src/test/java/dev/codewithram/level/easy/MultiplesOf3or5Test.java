package dev.codewithram.level.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MultiplesOf3or5Test {
    private final MultiplesOf3or5 obj = new MultiplesOf3or5();

    @Test
    void solution() {
        assertEquals(23, obj.solution(10));

    }
}