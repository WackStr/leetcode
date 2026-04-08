package com.wackstr.leetcode;

/*
2026-04-08 3653
 */
public class XOROperation_3653 {
    public int xorAfterQueries(int[] nums, int[][] queries) {
        for (int[] query : queries) {
            for (int i = query[0]; i <= query[1] ; i += query[2]) {
                nums[i] = (int)(((long)nums[i] * query[3]) % (1_000_000_007));
            }
        }
        int res = nums[0];
        for (int i = 1; i < nums.length; i++)
            res ^= nums[i];
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {483, 414};
        int[][] queries = {{0,0,1,17}};
        XOROperation_3653 sol = new XOROperation_3653();
        System.out.println(sol.xorAfterQueries(nums, queries));
    }
}
