package com.wackstr.leetcode;

import java.util.HashSet;
import java.util.Set;

/*
2026-02-23 1461
 */
public class BinaryCodes_1461 {
    public boolean hasAllCodes(String s, int k){
        if(s.length() < k) return false;
        Set<Integer> nums = new HashSet<>();
        int shifter = (1 << k) - 1;
        int num = 0;

        for(int i = 0; i < k; i++) {
            num <<= 1;
            num |= (s.charAt(i) - '0');
        }

        nums.add(num);

        for(int i = 0; i < s.length() - k; i++) {
            num <<= 1;
            num &= shifter;
            num |= (s.charAt(i + k) - '0');
            nums.add(num);
            if(nums.size() == (1 << k)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String s = "0110";
        int k = 2;
        BinaryCodes_1461 sol = new BinaryCodes_1461();
        System.out.println(sol.hasAllCodes(s,k));
    }
}
