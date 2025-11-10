package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
2025-11-10
 */
public class ArrayOperations_3542 {

    public int minOperations(int[] nums) {
        List<Integer> s = new ArrayList<>();
        int res = 0;
        for (int a : nums) {
            while (!s.isEmpty() && s.get(s.size() - 1) > a) {
                s.remove(s.size() - 1);
            }
            if (a == 0) continue;
            if (s.isEmpty() || s.get(s.size() - 1) < a) {
                res++;
                s.add(a);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,2,2,4,4,1,1,1,2,4,1,5};
        ArrayOperations_3542 sol = new ArrayOperations_3542();
        System.out.println(sol.minOperations(nums));
    }
}
