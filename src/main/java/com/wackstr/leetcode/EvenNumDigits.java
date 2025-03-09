package com.wackstr.leetcode;

public class EvenNumDigits {
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
        EvenNumDigits sol = new EvenNumDigits();
        System.out.println(sol.findNumbers(nums));
    }
}
