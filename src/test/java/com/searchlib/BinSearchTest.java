package com.searchlib;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BinSearchTest {

    private Result r;

    @BeforeEach
    void setUp() {
        r = new Result();
    }

    @Test
    @DisplayName("TC1: Key found at middle")
    void testKeyFoundAtMid() {
        int[] arr = {1, 3, 5, 7, 9};
        BinSearch.search(5, arr, r);
        assertTrue(r.found);
        assertEquals(2, r.index);
    }

    @Test
    @DisplayName("TC2: Key in upper half")
    void testKeyInUpperHalf() {
        int[] arr = {1, 3, 5, 7, 9};
        BinSearch.search(7, arr, r);
        assertTrue(r.found);
        assertEquals(3, r.index);
    }

    @Test
    @DisplayName("TC3: Key in lower half")
    void testKeyInLowerHalf() {
        int[] arr = {1, 3, 5, 7, 9};
        BinSearch.search(3, arr, r);
        assertTrue(r.found);
        assertEquals(1, r.index);
    }

    @Test
    @DisplayName("TC4: Key not found")
    void testKeyNotFound() {
        int[] arr = {1, 3, 5, 7, 9};
        BinSearch.search(4, arr, r);
        assertFalse(r.found);
        assertEquals(-1, r.index);
    }

    @Test
    @DisplayName("TC5: Key at first index")
    void testKeyAtFirstIndex() {
        int[] arr = {1, 3, 5, 7, 9};
        BinSearch.search(1, arr, r);
        assertTrue(r.found);
        assertEquals(0, r.index);
    }

    @Test
    @DisplayName("TC6: Key at last index")
    void testKeyAtLastIndex() {
        int[] arr = {1, 3, 5, 7, 9};
        BinSearch.search(9, arr, r);
        assertTrue(r.found);
        assertEquals(4, r.index);
    }

    @Test
    @DisplayName("TC7: Single element, not found")
    void testSingleElementNotFound() {
        int[] arr = {42};
        BinSearch.search(5, arr, r);
        assertFalse(r.found);
        assertEquals(-1, r.index);
    }

    @Test
    @DisplayName("TC8: Single element, found")
    void testSingleElementFound() {
        int[] arr = {42};
        BinSearch.search(42, arr, r);
        assertTrue(r.found);
        assertEquals(0, r.index);
    }

    @Test
    @DisplayName("TC9: Key smaller than all elements")
    void testKeyBelowRange() {
        int[] arr = {10, 20, 30, 40, 50};
        BinSearch.search(5, arr, r);
        assertFalse(r.found);
        assertEquals(-1, r.index);
    }

    @Test
    @DisplayName("TC10: Key greater than all elements")
    void testKeyAboveRange() {
        int[] arr = {10, 20, 30, 40, 50};
        BinSearch.search(60, arr, r);
        assertFalse(r.found);
        assertEquals(-1, r.index);
    }
}