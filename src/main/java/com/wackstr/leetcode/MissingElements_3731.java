package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
2028-08-04 3731
 */
public class MissingElements_3731 {
    public List<Integer> findMissingElements(int[] nums){
        List<Integer> ans = new ArrayList<>();
        int max = nums[0];
        int min = nums[0];

        for(int i : nums){
            max = Math.max(i, max);
            min = Math.min(i, min);
        }

        int[] arr = new int[max + 1];
        for(int i : nums){
            arr[i]++;
        }

        for(int i=min;i<max;i++){
            if(arr[i] == 0)
                ans.add(i);
        }
        return ans;
    }

    private static List<Integer> hashSet(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
            set.add(num);
        }

        List<Integer> ans = new ArrayList<>();

        for (int i = min + 1; i < max; i++) {
            if (!set.contains(i)) {
                ans.add(i);
            }
        }

        return ans;
    }

    private static List<Integer> sort(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Arrays.sort(nums);
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for(int j = last + 1; j < nums[i]; j++){
                res.add(j);
            }
            last = nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,4,2,5};
        MissingElements_3731 sol = new MissingElements_3731();
        System.out.println(sol.findMissingElements(nums));
    }
}
