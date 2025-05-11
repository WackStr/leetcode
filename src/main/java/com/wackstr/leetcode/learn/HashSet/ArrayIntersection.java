package com.wackstr.leetcode.learn.HashSet;

import java.util.HashSet;
import java.util.Set;

public class ArrayIntersection {
    public int[] intersection(int[] nums1, int[] nums2){
        Set<Integer> lookup = new HashSet<>();
        for(int num : nums1) {
            lookup.add(num);
        }
        Set<Integer> res = new HashSet<>();
        for(int num : nums2){
            if(lookup.contains(num)) res.add(num);
        }
        int[] ans = new int[res.size()];
        int index = 0;
        for(int num : res){
            ans[index++] = num;
        }
        return ans;
    }
}
