package dev.codewithram.opps.basics;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class PaginationHelperTest {

    @Test
    void testPageCount() {
        Assertions.assertEquals(1, new PaginationHelper<>(List.of("a", "b"), 5).pageCount());
        Assertions.assertEquals(2, new PaginationHelper<>(List.of("a", "b"), 1).pageCount());
    }

    @Test
    void testItemCount() {
        Assertions.assertEquals(2, new PaginationHelper<>(List.of("a", "b"), 5).itemCount());
        Assertions.assertEquals(1, new PaginationHelper<>(List.of("a"), 1).itemCount());
    }

    @Test
    void testPageItemCount() {
        Assertions.assertEquals(2, new PaginationHelper<>(List.of("a", "b"), 5).pageItemCount(0));
        Assertions.assertEquals(1, new PaginationHelper<>(List.of("a", "b"), 1).pageItemCount(1));
        Assertions.assertEquals(-1, new PaginationHelper<>(List.of("a", "b"), 1).pageItemCount(2));
    }

    @Test
    void testPageIndex() {
        Assertions.assertEquals(0, new PaginationHelper<>(List.of("a", "b"), 5).pageIndex(0));
        Assertions.assertEquals(2, new PaginationHelper<>(List.of("a", "b"), 1).pageIndex(1));
        Assertions.assertEquals(2, new PaginationHelper<>(List.of("a", "b", "c", "d", "e", "f", "g"), 3).pageIndex(6));
        Assertions.assertEquals(-1, new PaginationHelper<>(List.of("a", "b"), 1).pageIndex(20));
    }

}