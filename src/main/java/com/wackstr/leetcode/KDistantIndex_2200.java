package com.wackstr.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
2025-06-24
 */
public class KDistantIndex_2200 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k){
        List<Integer> res = new ArrayList<>();
        Queue<Integer> pivots = new LinkedList<>();
        for(int i = 0; i < nums.length;i++) if(nums[i] == key) pivots.offer(i);
        int end = 0;
        while(!pivots.isEmpty()){
            int pivot = pivots.poll();
            int start = Math.max(end, Math.max(0, pivot - k));
            end = Math.min(nums.length, pivot + k + 1);
            for(int i = start; i < end; i++) res.add(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {734,228,636,204,552,732,686,461,973,874,90,537,939,986,855,387,344,939,552,389,116,93,545,805,572,306,157,899,276,479,337,219,936,416,457,612,795,221,51,363,667,112,686,21,416,264,942,2,127,47,151,277,603,842,586,630,508,147,866,434,973,216,656,413,504,360,990,228,22,368,660,945,99,685,28,725,673,545,918,733,158,254,207,742,705,432,771,578,549,228,766,998,782,757,561,444,426,625,706,946};
        int key = 939;
        int k = 34;
        KDistantIndex_2200 sol = new KDistantIndex_2200();
        System.out.println(sol.findKDistantIndices(nums, key, k));
    }
}
