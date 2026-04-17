package com.wackstr.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
2026-04-17 3761
 */
public class MinimumPairDistance_3761 {

    public int minMirrorPairDistance(int[] nums){
        Map<Integer, Integer> map =  new HashMap<>();
        int res = nums.length;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(map.containsKey(num)) res = Math.min(res, i - map.get(num));
            map.put(reverse(num), i);
        }
        return res == nums.length ? -1 : res;
    }

    private int reverse(int num) {
        int ans = 0;
        while(num > 0){
            ans = 10 * ans + num % 10;
            num /= 10;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {21,120};
        MinimumPairDistance_3761 sol = new MinimumPairDistance_3761();
        System.out.println(sol.minMirrorPairDistance(nums));
    }
}