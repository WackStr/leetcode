package com.wackstr.leetcode;

import java.util.Arrays;

/*
2025-03-31
 */
public class MarblesInBag_2551 {
    public long pubMarbles(int[] weights, int k){
        // We collect and sort the value of all n - 1 pairs.
        int n = weights.length;
        int[] pairWeights = new int[n - 1];
        for (int i = 0; i < n - 1; ++i) {
            pairWeights[i] = weights[i] + weights[i + 1];
        }
        // We will sort only the first (n - 1) elements of the array.
        Arrays.sort(pairWeights, 0, n - 1);

        // Get the difference between the largest k - 1 values and the
        // smallest k - 1 values.
        long answer = 0l;
        for (int i = 0; i < k - 1; ++i) {
            answer += pairWeights[n - 2 - i] - pairWeights[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] weights = {1, 3, 5, 1};
        int k = 2;
        MarblesInBag_2551 sol = new MarblesInBag_2551();
        System.out.println(sol.pubMarbles(weights, k));
    }
}
