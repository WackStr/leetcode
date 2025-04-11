package com.wackstr.leetcode.learn.array;

public class DominantIndex {
    public int dominantIndex(int[] nums){
        int max = 0;
        int index = 0;
        int next = 0;
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num > max) {
                next = max;
                max = num;
                index = i;
            }else if(num > next){
                next = num;
            }
        }
        return max >= next * 2 ? index : -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,6,1,0};
        DominantIndex sol = new DominantIndex();
        System.out.println(sol.dominantIndex(nums));
    }
}
