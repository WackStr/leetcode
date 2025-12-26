package com.wackstr.leetcode;

/*
2025-12-26 2483
 */
public class ShopPenalty_2483 {
    public int bestClosingTime(String customers) {
        int maxScore = 0, score = 0, rightTime = -1;
        for (int i = 0; i < customers.length(); i++) {
            score += (customers.charAt(i) == 'Y') ? 1 : -1;
            if (score > maxScore) {
                maxScore = score;
                rightTime = i;
            }
        }
        return rightTime+1;
    }

    public static void main(String[] args) {
        String customers = "YYYY";
        ShopPenalty_2483 sol = new ShopPenalty_2483();
        System.out.println(sol.bestClosingTime(customers));
    }
}
