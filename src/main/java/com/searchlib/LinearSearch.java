package com.searchlib;

public class LinearSearch {

    public static void search(int key, int[] elemArray, Result r) {
        int i = 0;
        r.found = false;
        r.index = -1;

        while (i < elemArray.length && !r.found) {
            if (elemArray[i] == key) {
                r.index = i;
                r.found = true;
            } else {
                i++;
            }
        }
    }
}