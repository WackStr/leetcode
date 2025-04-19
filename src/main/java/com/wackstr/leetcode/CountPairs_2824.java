package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CountPairs_2824 {
    public int countPairs(List<Integer> nums, int target){
        nums.sort(Comparator.comparingInt(a -> a));
        int left = 0;
        int right = nums.size() - 1;
        int result = 0;
        while(left < right){
            int sum = nums.get(left) + nums.get(right);
            if(sum < target)  {
                result += right - left;
                left++;
            }else{
                right--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Integer[] nums = {-1, 1, 2, 3, 1};
        int target = 2;
        CountPairs_2824 sol = new CountPairs_2824();
        System.out.println(sol.countPairs(Arrays.asList(nums), target));
    }
}
