package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-05-12 1665
 */
public class MinimumEnergy_1665 {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> a[1] - a[0] - (b[1] - b[0]));
        int ans = 0;
        for (int[] task : tasks) {
            ans = Math.max(ans + task[0], task[1]);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] tasks = {{1,2}, {2,4}, {4,8}};
        MinimumEnergy_1665 sol = new MinimumEnergy_1665();
        System.out.println(sol.minimumEffort(tasks));
    }
}
