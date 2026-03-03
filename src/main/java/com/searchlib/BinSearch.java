package com.searchlib;

public class BinSearch {

    public static void search(int key, int[] elemArray, Result r) {
        int bottom = 0;
        int top = elemArray.length - 1;
        int mid;
        r.found = false;
        r.index = -1;
        // search condition - sqe(for demo testing)
        while (bottom <= top) {
            mid = (top + bottom) / 2;
            if (elemArray[mid] == key) {
                r.index = mid;
                r.found = true;
                return;
            } else {
                if (elemArray[mid] < key) {
                    bottom = mid + 1;
                } else {
                    top = mid - 1;
                }
            }
        }
    }
}