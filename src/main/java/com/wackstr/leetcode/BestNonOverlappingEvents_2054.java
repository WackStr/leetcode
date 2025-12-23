package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
2025-12-23 2054
 */
public class BestNonOverlappingEvents_2054 {
    private static final int START = 0;
    private static final int END = 1;
    private static final int VAL = 2;

    public int maxTwoEvents(int[][] events) {
        //Create a PriorityQueue to store the pair ending time and value.
        PriorityQueue<int[]> pq = new PriorityQueue<>((e1, e2) -> e1[END] - e2[END]);

        // O(n log n) Sort the array in ascending order
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int maxVal = 0, maxSum = 0;

        for (int[] event : events) {
//            System.out.printf("Processing event: start=%d, end=%d, value=%d%n", event[START], event[END], event[VAL]);
            // Poll all valid events from queue and take their maximum.
            while (!pq.isEmpty() && pq.peek()[END] < event[START]) {
                maxVal = Math.max(maxVal, pq.peek()[VAL]);
                // O(log n)
                pq.poll();
            }

            maxSum = Math.max(maxSum, maxVal + event[VAL]);
            pq.add(event);
        }

        return maxSum;
    }
}
