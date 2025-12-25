package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-12-25 3075
 */
public class MaximizeHappiness_3075 {
    public long maximumHappinessSum(int[] happiness, int k) {
        long sum = 0;
        int cut = 0;
        Arrays.sort(happiness);
        for (int i = happiness.length - 1; i >= happiness.length - k; i--) {
            sum += Math.max(happiness[i] - cut, 0);
            cut++;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] happiness = {2,3,4,5};
        int k = 1;
    }
}
