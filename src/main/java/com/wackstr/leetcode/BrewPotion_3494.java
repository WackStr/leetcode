package com.wackstr.leetcode;

/*
2025-10-09
 */
public class BrewPotion_3494 {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] times = new long[n];

        for (int j = 0; j < m; j++) {
            long curTime = 0;
            for (int i = 0; i < n; i++) {
                curTime =
                        Math.max(curTime, times[i]) + (long) skill[i] * mana[j];
            }
            times[n - 1] = curTime;
            for (int i = n - 2; i >= 0; i--) {
                times[i] = times[i + 1] - (long) skill[i + 1] * mana[j];
            }
        }
        return times[n - 1];
    }

    public static void main(String[] args) {
        int[] skill = {1,5,2,4};
        int[] mana = {5,1,4,2};
        BrewPotion_3494 sol = new BrewPotion_3494();
        System.out.println(sol.minTime(skill, mana));
    }
}
