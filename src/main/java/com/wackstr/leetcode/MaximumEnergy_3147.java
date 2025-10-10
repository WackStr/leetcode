package com.wackstr.leetcode;

/*
2025-10-10
 */
public class MaximumEnergy_3147 {

        public int maximumEnergy(int[] energy, int k) {
            int[] dp = new int[energy.length];
            int max = Integer.MIN_VALUE;
            for(int i = dp.length - 1; i >= dp.length - k; i--){
                dp[i] = energy[i];
                max = Math.max(max, dp[i]);
            }
            for(int i = dp.length - k - 1; i >= 0; i--){
                dp[i] = energy[i] + dp[i + k];
                max = Math.max(max, dp[i]);
            }
            return max;
        }

    public static void main(String[] args) {
        int[] energy = {5, 2, -10, -5, 1};
        int k =  3;
        MaximumEnergy_3147 sol = new MaximumEnergy_3147();
        System.out.println(sol.maximumEnergy(energy, k));
    }
}
