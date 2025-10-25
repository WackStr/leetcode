package com.wackstr.leetcode;

/*
2025-10-25
 */
public class LeetcodeBank_1716 {
    public int totalMoney(int n){
        int completeWeeks = n/7;
        int remainderContribution = 0;
        int totalWeekContribution = 7 * completeWeeks * (completeWeeks + 7) / 2;
        int remainderDays = n % 7;
        if(remainderDays > 0){
            remainderContribution = (n - 7 * completeWeeks)*(n - 5 * completeWeeks + 1)/2;
        }
        return remainderContribution + totalWeekContribution;
    }

    public static void main(String[] args) {
        int n = 10;
        LeetcodeBank_1716 sol = new LeetcodeBank_1716();
        System.out.println(sol.totalMoney(n));
    }
}
