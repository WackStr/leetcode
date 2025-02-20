package com.wackstr.leetcode;

/*
2025-02-20
 */
public class UniqueBinaryString_1980 {
    public String findDifferentBinaryString(String[] nums){
        StringBuilder uniqueString = new StringBuilder();
        for(int i = 0; i < nums.length; i++){
            uniqueString.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return uniqueString.toString();
    }

    public static void main(String[] args) {
        String[] nums = {"01","10"};
        UniqueBinaryString_1980 sol = new UniqueBinaryString_1980();
        System.out.println(sol.findDifferentBinaryString(nums));
    }
}
