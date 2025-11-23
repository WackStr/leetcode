package com.wackstr.leetcode;

/*
2025-11-23 1262
 */
public class DivisibleThreeSum_1262 {
    public int maxSumDivThree(int[] nums){
        int sum = 0;
        int two1 = 0;
        int two2 = 0;
        int one1 = 0;
        int one2 = 0;
        int rem;
        for (int num : nums) {
            sum += num;
            rem = num % 3;
            if(rem == 1) {
                if(one1 == 0 || num <= one1){
                    one2 = one1;
                    one1 = num;
                }else if(one2 == 0 || num <= one2){
                    one2 = num;
                }
            }else if(rem == 2){
                if(two1 == 0 || num <= two1){
                    two2 = two1;
                    two1 = num;
                }else if(two2 == 0 || num <= two2){
                    two2 = num;
                }
            }
        }
        rem = sum % 3;
        if(rem == 0) return sum;
        int reduce = Integer.MAX_VALUE;
        if(rem == 1){
            if(one1 == 0 && two1 == 0 && two2 == 0) return 0;
            if(one1 > 0) reduce = one1;
            if(two1 > 0 && two2 > 0) reduce = Math.min(reduce, two1 + two2);
        }else{
            if(two1 == 0 && one1 == 0 && one2 == 0) return 0;
            if(two1 > 0) reduce = two1;
            if(one1 > 0 && one2 > 0) reduce = Math.min(reduce, one1 + one2);
        }
        return sum - reduce;
    }
}
