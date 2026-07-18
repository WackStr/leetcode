package com.wackstr;

/*
2026-07-18
 */
public class ArrayGCD_1979 {
    public int findGCD(int[] nums){
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        int r = max % min;
        while(r != 0){
            max = min;
            min = r;
            r = max % min;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {7,5,6,8,3};
        ArrayGCD_1979 sol = new ArrayGCD_1979();
        System.out.println(sol.findGCD(nums));
    }
}


