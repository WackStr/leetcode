package com.wackstr.leetcode;

/*
2026-04-10 3740
 */
public class GoodTuples_3740 {
    public int minimumDistance(int[] nums){
        int n = nums.length;
        int[][] indexes = new int[n+1][3];
        int res = Integer.MAX_VALUE;
        for (int[] index : indexes) {
            index[0] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int[] index = indexes[num];

            index[2]++;
            if(index[2] >= 3) {
                res = Math.min(res, 2*(i - index[0]));
                index[0] = index[1];
                index[1] = i;
            }else if(index[2] == 2){
                index[1] = i;
            }else{
                index[0] = i;
            }
        }
        return res == Integer.MAX_VALUE ? - 1 : res;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        GoodTuples_3740 sol = new GoodTuples_3740();
        System.out.println(sol.minimumDistance(nums));
    }
}
