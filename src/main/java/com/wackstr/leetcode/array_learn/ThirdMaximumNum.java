package com.wackstr.leetcode.array_learn;

import java.util.TreeSet;

public class ThirdMaximumNum {
    public int thirdMax(int[] nums){
        int length = 3;
        TreeSet<Integer> set = new TreeSet<>();
        for(int num : nums){
            set.add(num);
            while(set.size() > length){
                set.remove(set.first());
            }
        }
        return (set.size() == length) ? set.first() : set.last();
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1};
        ThirdMaximumNum sol = new ThirdMaximumNum();
        System.out.println(sol.thirdMax(nums));
    }
}
