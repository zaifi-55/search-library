package com.searchlib;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class InterpolationSearchTest {

    private Result r;

    @BeforeEach
    void setUp() {
        r = new Result();
    }

    @Test
    @DisplayName("TC1: Key below range")
    void testKeyBelowRange() {
        int[] arr = {10, 20, 30, 40, 50};
        InterpolationSearch.search(5, arr, r);
        assertFalse(r.found);
        assertEquals(-1, r.index);
    }

    @Test
    @DisplayName("TC2: Key above range")
    void testKeyAboveRange() {
        int[] arr = {10, 20, 30, 40, 50};
        InterpolationSearch.search(60, arr, r);
        assertFalse(r.found);
        assertEquals(-1, r.index);
    }

    @Test
    @DisplayName("TC3: Key found immediately")
    void testKeyFoundImmediately() {
        int[] arr = {10, 20, 30, 40, 50};
        InterpolationSearch.search(30, arr, r);
        assertTrue(r.found);
        assertEquals(2, r.index);
    }

    @Test
    @DisplayName("TC4: Key in upper half")
    void testKeyInUpperHalf() {
        int[] arr = {10, 20, 30, 40, 50};
        InterpolationSearch.search(40, arr, r);
        assertTrue(r.found);
        assertEquals(3, r.index);
    }

    @Test
    @DisplayName("TC5: Key in lower half")
    void testKeyInLowerHalf() {
        int[] arr = {10, 20, 30, 40, 50};
        InterpolationSearch.search(20, arr, r);
        assertTrue(r.found);
        assertEquals(1, r.index);
    }

    @Test
    @DisplayName("TC6: Key at first index")
    void testKeyAtFirstIndex() {
        int[] arr = {5, 10, 15, 20, 25};
        InterpolationSearch.search(5, arr, r);
        assertTrue(r.found);
        assertEquals(0, r.index);
    }

    @Test
    @DisplayName("TC7: Key at last index")
    void testKeyAtLastIndex() {
        int[] arr = {5, 10, 15, 20, 25};
        InterpolationSearch.search(25, arr, r);
        assertTrue(r.found);
        assertEquals(4, r.index);
    }

    @Test
    @DisplayName("TC8: Single element found")
    void testSingleElementFound() {
        int[] arr = {42};
        InterpolationSearch.search(42, arr, r);
        assertTrue(r.found);
        assertEquals(0, r.index);
    }

    @Test
    @DisplayName("TC9: Key not present in range")
    void testKeyInRangeButAbsent() {
        int[] arr = {10, 20, 40, 50};
        InterpolationSearch.search(30, arr, r);
        assertFalse(r.found);
        assertEquals(-1, r.index);
    }

    @Test
    @DisplayName("TC10: Large uniform array")
    void testLargeUniformArray() {
        int size = 100;
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) arr[i] = i * 10;
        InterpolationSearch.search(570, arr, r);
        assertTrue(r.found);
        assertEquals(57, r.index);
    }
}