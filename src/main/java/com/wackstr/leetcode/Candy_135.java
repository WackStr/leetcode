package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-06-02
 */
public class Candy_135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int cnt = 0;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 1; i < n; i++)
            if (ratings[i] > ratings[i - 1])
                candies[i] = candies[i - 1] + 1;
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i - 1] > ratings[i])
                candies[i - 1] = Math.max(candies[i] + 1, candies[i - 1]);
            cnt += candies[i - 1];
        }
        return cnt + candies[n - 1];
    }

    public static void main(String[] args) {
        int[] ratings = {1,2,87,87,87,2,1};
        Candy_135 sol = new Candy_135();
        System.out.println(sol.candy(ratings));
    }
}
