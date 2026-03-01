package com.searchlib;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class LinearSearchTest {

    private Result r;

    @BeforeEach
    void setUp() {
        r = new Result();
    }

    @Test
    @DisplayName("TC1: Empty array")
    void testEmptyArray() {
        int[] arr = {};
        LinearSearch.search(5, arr, r);
        assertFalse(r.found);
        assertEquals(-1, r.index);
    }

    @Test
    @DisplayName("TC2: Key found at index 0")
    void testKeyFoundAtFirst() {
        int[] arr = {7, 2, 4, 9, 1};
        LinearSearch.search(7, arr, r);
        assertTrue(r.found);
        assertEquals(0, r.index);
    }

    @Test
    @DisplayName("TC3: Single element, not found")
    void testSingleElementNotFound() {
        int[] arr = {10};
        LinearSearch.search(5, arr, r);
        assertFalse(r.found);
        assertEquals(-1, r.index);
    }

    @Test
    @DisplayName("TC4: Key found after iterations")
    void testKeyFoundAfterIterations() {
        int[] arr = {1, 3, 5, 7, 9};
        LinearSearch.search(7, arr, r);
        assertTrue(r.found);
        assertEquals(3, r.index);
    }

    @Test
    @DisplayName("TC5: Key not found after full traversal")
    void testKeyNotFoundFullTraversal() {
        int[] arr = {2, 4, 6, 8, 10};
        LinearSearch.search(7, arr, r);
        assertFalse(r.found);
        assertEquals(-1, r.index);
    }

    @Test
    @DisplayName("TC6: Key at last position")
    void testKeyAtLastPosition() {
        int[] arr = {5, 10, 15, 20, 25};
        LinearSearch.search(25, arr, r);
        assertTrue(r.found);
        assertEquals(4, r.index);
    }

    @Test
    @DisplayName("TC7: Unsorted array")
    void testUnsortedArray() {
        int[] arr = {9, 3, 7, 1, 5};
        LinearSearch.search(1, arr, r);
        assertTrue(r.found);
        assertEquals(3, r.index);
    }

    @Test
    @DisplayName("TC8: Negative values")
    void testNegativeValues() {
        int[] arr = {-10, -5, 0, 5, 10};
        LinearSearch.search(-5, arr, r);
        assertTrue(r.found);
        assertEquals(1, r.index);
    }
}