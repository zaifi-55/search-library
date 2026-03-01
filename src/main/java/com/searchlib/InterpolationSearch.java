package com.searchlib;

public class InterpolationSearch {

    public static void search(int key, int[] elemArray, Result r) {
        int low = 0;
        int high = elemArray.length - 1;
        r.found = false;
        r.index = -1;

        while (low <= high
                && key >= elemArray[low]
                && key <= elemArray[high]) {

            int pos = low + (((key - elemArray[low]) * (high - low))
                    / (elemArray[high] - elemArray[low]));

            if (elemArray[pos] == key) {
                r.index = pos;
                r.found = true;
                return;
            }

            if (elemArray[pos] < key) {
                low = pos + 1;
            } else {
                high = pos - 1;
            }
        }
    }
}