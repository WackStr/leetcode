package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*
2026-05-11 2553
 */
public class SeparateDigits_2553 {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> ls = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            while(num > 0){
                ls.add(num % 10);
                num /= 10;
            }
        }
        int n = ls.size();
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            res[i] = ls.get(n - i - 1);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {13, 25, 83, 77};
        SeparateDigits_2553 sol = new SeparateDigits_2553();
        System.out.println(Arrays.toString(sol.separateDigits(nums)));
    }
}
