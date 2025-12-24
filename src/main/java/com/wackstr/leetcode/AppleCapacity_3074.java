package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-12-24 3074
 */
public class AppleCapacity_3074 {
    public int minimumBoxes(int[] apple, int[] capacity){
        int cnt = 0;
        int sum = 0;
        for (int i : apple) {
            sum += i;
        }
        Arrays.sort(capacity);
        for (int i = capacity.length - 1; i >= 0 && sum > 0; i--) {
            sum -= capacity[i];
            cnt++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[] apple = {1, 3, 2};
        int[] capacity = {4, 3, 1, 5, 2};
        AppleCapacity_3074 sol = new AppleCapacity_3074();
        System.out.println(sol.minimumBoxes(apple, capacity));
    }
}
