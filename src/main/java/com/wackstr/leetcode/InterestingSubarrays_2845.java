package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
2025-04-25
 */
public class InterestingSubarrays_2845 {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k){
        int n = nums.size();
        HashMap<Integer, Integer> cnt = new HashMap<>();
        long res = 0;
        int prefix = 0;
        cnt.put(0, 1);
        for (int i = 0; i < n; i++) {
            prefix += nums.get(i) % modulo == k ? 1 : 0;
            res += cnt.getOrDefault((prefix - k + modulo) % modulo, 0);
            cnt.put(prefix % modulo, cnt.getOrDefault(prefix % modulo, 0) + 1);
        }
        return res;
    }

    private static long checkAllSubArrays(List<Integer> nums, int modulo, int k) {
        int[] prefix = new int[nums.size()];
        prefix[0] = nums.get(0) % modulo == k ? 1 : 0;
        for(int i = 1; i < nums.size(); i++){
            prefix[i] += prefix[i-1] + (nums.get(i) % modulo == k ? 1 : 0);
        }
        long res = 0;
        for(int right = 0; right < nums.size(); right++){
            for(int left = 0; left <= right; left++){
                if((prefix[right] - (left > 0 ? prefix[left - 1] : 0)) % modulo == k)
                    res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] arr = {3, 1, 9, 6};
        int modulo = 3;
        int k = 0;
        InterestingSubarrays_2845 sol = new InterestingSubarrays_2845();
        System.out.println(
                sol.countInterestingSubarrays(Arrays.asList(arr), modulo, k));
    }
}
