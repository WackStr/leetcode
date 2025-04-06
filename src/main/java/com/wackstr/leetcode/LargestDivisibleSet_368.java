package com.wackstr.leetcode;

import com.wackstr.leetcode.structure.Pair;

import java.util.*;

/*
2025-04-06
 */
public class LargestDivisibleSet_368 {
    public List<Integer> largestDivisibleSubset(int[] nums){
        Arrays.sort(nums);
        List<Integer>[] dp = new List[nums.length];

        for(int i = 0; i < nums.length; i++){
            List<Integer> ls = new ArrayList<>();
            ls.add(nums[i]);
            dp[i] = ls;
        }

        List<Integer> res = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--){
            for(int j = i + 1; j < nums.length; j++){
                if(nums[j] % nums[i] == 0){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.addAll(dp[j]);
                    dp[i] = temp.size() > dp[i].size() ? temp : dp[i];
                }
            }
            res = dp[i].size() > res.size() ? dp[i] : res;
        }


        return res;

    }

    private List<Integer> largestDivisibleSubset_topDown_dp(int[] nums) {
        Arrays.sort(nums);
        List<Integer> res = new ArrayList<>();
        Map<Integer, List<Integer>> cache = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            List<Integer> tmp = dfs(i, nums, cache);
            if(tmp.size() > res.size()){
                res = tmp;
            }
        }
        return res;
    }

    public List<Integer> dfs(int i, int[] nums, Map<Integer, List<Integer>> cache){
        if(i == nums.length) return new ArrayList<>();
        if(cache.containsKey(i)) return cache.get(i);
        List<Integer> res = new ArrayList<>();
        res.add(nums[i]);
        for (int j = i + 1; j < nums.length; j++){
            if(nums[j] % nums[i] == 0){
            List<Integer> temp = new ArrayList<>();
            temp.add(nums[i]);
            temp.addAll(dfs(j, nums, cache));
            if(temp.size() > res.size()){
                res = temp;
            }
            }
        }
        cache.put(i, res);
        return res;
    }

    private List<Integer> largestDivisibleSubset_dfs(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ls = new ArrayList<>();
        ls.add(nums[0]);
        Map<Pair<Integer, Integer>, List<Integer>> memo =
                new HashMap<>();
        return dfs_twoIndex(0, 1, nums, memo);
    }

    public List<Integer> dfs_twoIndex(int index, int prev, int[] nums, Map<Pair<Integer, Integer>, List<Integer>> memo){
        if(index >= nums.length) return new ArrayList<>();
        Pair<Integer, Integer> key = new Pair<>(index, prev);
        if(memo.containsKey(key)) return memo.get(key);

        List<Integer> without = new ArrayList<>(dfs_twoIndex(index + 1, prev, nums, memo));
        List<Integer> with = new ArrayList<>();
        int currNum = nums[index];
        if(currNum % prev == 0){
            with.add(currNum);
            with.addAll(dfs_twoIndex(index + 1, currNum, nums, memo));
        }

        List<Integer> ans = with.size() > without.size() ? with : without;
        memo.put(key, ans);
        return ans;
    }



    public static void main(String[] args) {
        int[] nums = {2,3,4,9,8};
        LargestDivisibleSet_368 sol = new LargestDivisibleSet_368();
        System.out.println(sol.largestDivisibleSubset(nums));
    }
}
