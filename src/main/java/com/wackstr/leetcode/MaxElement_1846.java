package com.wackstr.leetcode;

/*
2026-06-28 1846
 */
public class MaxElement_1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        int n = arr.length;
        int[] counts = new int[n + 1];

        for (int num : arr) {
            counts[Math.min(num, n)]++;
        }

        int ans = 1;
        for (int num = 2; num <= n; num++) {
            ans = Math.min(ans + counts[num], num);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {100, 1, 1000};
        MaxElement_1846 sol = new MaxElement_1846();
        System.out.println(sol.maximumElementAfterDecrementingAndRearranging(arr));
    }
}
