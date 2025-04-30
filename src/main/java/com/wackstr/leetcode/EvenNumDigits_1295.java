package com.wackstr.leetcode;

/*
2025-04-30
 */
public class EvenNumDigits_1295 {
    public int findNumbers(int[] nums){
        int cnt = 0;
        for(int num : nums){
            if((getDigits(num) & 1) == 0) cnt++;
        }
        return cnt;
    }

    private int getDigits(int num) {
        int numDigits = 0;
        while(num > 0){
            num /= 10;
            numDigits++;
        }
        return numDigits;
    }

    public static void main(String[] args) {
        int[] nums = {12, 345, 2, 6, 7896};
        EvenNumDigits_1295 sol = new EvenNumDigits_1295();
        System.out.println(sol.findNumbers(nums));
    }
}
