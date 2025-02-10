package com.wackstr.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
2025-02-06
 */
public class SameProductTuple_1726 {
    public int tupleSameProduct(int[] nums){
        Map<Integer, Integer> products = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            for (int j = i + 1; j < nums.length; j++){
                products.merge(nums[i] * nums[j], 1, Integer::sum);
            }
        }
        int finalCount = 0;
        for(int product : products.keySet()){

            int currCount = products.get(product);
            if(currCount > 1){
                finalCount += currCount * (currCount - 1) * 4;
            }
        }
        return finalCount;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,4,6};
        SameProductTuple_1726 sol = new SameProductTuple_1726();
        System.out.println(sol.tupleSameProduct(nums));
    }
}
