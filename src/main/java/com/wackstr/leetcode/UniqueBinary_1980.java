package com.wackstr.leetcode;

/*
2026-03-08 1980
 */
public class UniqueBinary_1980 {
    public String findDifferentBinaryString(String[] nums){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < nums.length; i++)
            res.append(nums[i].charAt(i) == '0' ? '1' : '0');
        return res.toString();
    }

    public static void main(String[] args) {
        String[] nums = {"111", "011", "001"};
        UniqueBinary_1980 sol = new UniqueBinary_1980();
        System.out.println(sol.findDifferentBinaryString(nums));
    }
}
