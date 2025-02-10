package com.wackstr.leetcode;

import java.util.ArrayDeque;

/*
2024-12-19
 */
public class MaxSortedChunks_769 {
    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int chunks = 0, maxElement = 0;

        // Iterate over the array
        for (int i = 0; i < n; i++) {
            // Update maxElement
            maxElement = Math.max(maxElement, arr[i]);

            if (maxElement == i) {
                // All values in range [0, i] belong to the prefix arr[0:i]; a new chunk can be formed
                chunks++;
            }
        }

        return chunks;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 4};
        MaxSortedChunks_769 sol = new MaxSortedChunks_769();
        System.out.println(sol.maxChunksToSorted(arr));
    }
}
