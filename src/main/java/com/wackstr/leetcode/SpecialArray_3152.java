package com.wackstr.leetcode;

import java.util.Arrays;

/*
2024-12-9
 */
public class SpecialArray_3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int[] prefix = getPrefixArray(nums);
        boolean[] queryAnswer = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            queryAnswer[i] = query[0] >= prefix[query[1]];
        }
        return queryAnswer;
    }

    public int[] getPrefixArray(int[] nums){
        int[] prefix = new int[nums.length];
        int left = 0, right = 0;
        int currBit = nums[left] & 1;
        while(left < nums.length){
            right = left + 1;
            while(right < nums.length){
                int rightBit = nums[right] & 1;
                if((rightBit ^ currBit) != 1) break;
                currBit = rightBit;
                right++;
            }
            for(int i = left; i < right; i++){
                prefix[i] = left;
            }
            left = right;
        }
        return prefix;
    }

    private boolean[] isArraySpecialBrute(int[] nums, int[][] queries) {
        boolean[] ans = new boolean[queries.length];
        for(int i = 0; i < queries.length; i++){
            int[] query = queries[i];
            if(query[0] == query[1]){
                ans[i] = true;
            }else{
                ans[i] = solveCase(nums, query);
            }
        }
        return ans;
    }

    public boolean solveCase(int[] nums, int[] query){
        int currBit = nums[query[0]] & 1;
        for(int j = query[0] + 1; j <= query[1]; j++){
            int nextBit = nums[j] & 1;
            if((currBit ^ nextBit) != 1) return false;
            currBit = nextBit;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 1, 6};
        int[][] queries = {{0, 2}, {2, 3}};
        SpecialArray_3152 sol = new SpecialArray_3152();
        System.out.println(Arrays.toString(sol.isArraySpecial(nums, queries)));
    }
}
