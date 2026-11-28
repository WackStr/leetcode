package com.wackstr.leetcode;

import java.util.Arrays;

/*
2026-11-28 3947
 */
public class FactorDiscount_3947 {
    public int maximumSaleItems(int[][] items, int budget) {
        Arrays.sort(items, (a, b) -> Integer.compare(a[1], b[1]));
        int mx = 0;
        for (int[] item : items) {
            mx = Math.max(mx, item[0]);
        }
        int[] freq = new int[mx + 1];
        for (int[] item : items) {
            freq[item[0]]++;
        }
        for (int i = 1; i <= mx; i++) {
            if (freq[i] > 0) {
                for (int j = i * 2; j <= mx; j += i) {
                    freq[i] += freq[j];
                }
            }
        }

        int mn = items[0][1];
        int ans = 0;
        for (int[] item : items) {
            int factor = item[0],
                    price = item[1];
            if (price - mn > mn) {
                break;
            }
            int cnt = freq[factor] - 1;
            int take = Math.min(cnt, budget / price);
            ans += take * 2;
            budget -= take * price;
        }
        ans += budget / mn;
        return ans;
    }

    public static void main(String[] args) {
        int[][] items = new int[][]{{1, 6}, {2, 4}, {3, 5}};
        int budget = 19;
        FactorDiscount_3947 sol = new FactorDiscount_3947();
        System.out.println(sol.maximumSaleItems(items, budget));
    }
}
