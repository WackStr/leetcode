package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-10-08
 */
public class SpellsAndPotions_2300 {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length, m = potions.length;
        int[] res = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i < n; i++) {
            long t = (success - 1) / spells[i] + 1;
            int s = 0, e = m - 1;
            while (s < e) {
                int mid = (e + s) / 2;
                if (potions[mid] >= t) {
                    e = mid;
                } else {
                    s = mid + 1;
                }
            }

            res[i] = potions[s] >= t ? m - s : 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] spells = {15,39,38,35,33,25,31,12,40,27,29,16,22,24,7,36,29,34,24,9,11,35,21,3,33,10,9,27,35,17,14,3,35,35,39,23,35,14,31,7};
        int[] potions = {25,19,30,37,14,30,38,22,38,38,26,33,34,23,40,28,15,29,36,39,39,37,32,38,8,17,39,20,4,39,39,7,30,35,29,23};
        long success = 317;
        SpellsAndPotions_2300 sol = new SpellsAndPotions_2300();
        System.out.println(Arrays.toString(sol.successfulPairs(spells, potions, success)));
    }
}
