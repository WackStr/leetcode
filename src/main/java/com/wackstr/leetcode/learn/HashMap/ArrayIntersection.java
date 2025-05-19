package com.wackstr.leetcode.learn.HashMap;

import java.util.*;

public class ArrayIntersection {
    public int[] intersect(int[] nums1, int[] num2){
        if(nums1.length > num2.length){
            return intersect(num2, nums1);
        }
        Map<Integer, Integer> cnt = new HashMap<>();
        for(int num : nums1){
            cnt.merge(num, 1, Integer::sum);
        }
        List<Integer> res = new ArrayList<>();
        for(int num : num2){
            if(cnt.containsKey(num)){
                res.add(num);
                cnt.compute(num, (k, v) -> v-1 == 0 ? null : v - 1);
            }
        }
        int[] arr = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 9, 5};
        int[] nums2 = {9, 4, 9, 8, 4};
        ArrayIntersection sol = new ArrayIntersection();
        System.out.println(Arrays.toString(sol.intersect(nums1, nums2)));
    }
}
